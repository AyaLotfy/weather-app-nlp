package nlp.intent.toolkit;

import opennlp.tools.doccat.DoccatModel;

import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.*;
import opennlp.tools.util.featuregen.AdaptiveFeatureGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import nlp.intent.classes.*;
import nlp.intent.exceptions.*;
import nlp.intent.weatherclasses.Coord;
import nlp.intent.classes.WeatherDataServiceFactory.service;


public class IntentTrainer {
	int optionVal = 0;

	public static void main(String[] args) throws Exception {
		IntentTrainer object = new IntentTrainer();
		object.welcomeMethod();
		if (!( object.optionVal == 3)) {
			return;
		}

		File trainingDirectory = new File("example//weather//train");

	
		String[] slots = new String[1];

		
		slots[0] = "city";

		if (!trainingDirectory.isDirectory()) {
			throw new IllegalArgumentException(
					"TrainingDirectory is not a directory: " + trainingDirectory.getAbsolutePath());
		}

		List<ObjectStream<DocumentSample>> categoryStreams = new ArrayList<ObjectStream<DocumentSample>>();
		for (File trainingFile : trainingDirectory.listFiles()) {
			String intent = trainingFile.getName().replaceFirst("[.][^.]+$", "");
			ObjectStream<String> lineStream = new PlainTextByLineStream(new FileInputStream(trainingFile), "UTF-8");
			ObjectStream<DocumentSample> documentSampleStream = new IntentDocumentSampleStream(intent, lineStream);
			categoryStreams.add(documentSampleStream);
		}

		ObjectStream<DocumentSample> combinedDocumentSampleStream = ObjectStreamUtils
				.createObjectStream(categoryStreams.toArray(new ObjectStream[0]));

		DoccatModel doccatModel = DocumentCategorizerME.train("en", combinedDocumentSampleStream, 0, 100);
		combinedDocumentSampleStream.close();

		List<TokenNameFinderModel> tokenNameFinderModels = new ArrayList<TokenNameFinderModel>();

		for (String slot : slots) {
			List<ObjectStream<NameSample>> nameStreams = new ArrayList<ObjectStream<NameSample>>();
			for (File trainingFile : trainingDirectory.listFiles()) {
				ObjectStream<String> lineStream = new PlainTextByLineStream(new FileInputStream(trainingFile), "UTF-8");
				ObjectStream<NameSample> nameSampleStream = new NameSampleDataStream(lineStream);
				nameStreams.add(nameSampleStream);
			}
			ObjectStream<NameSample> combinedNameSampleStream = ObjectStreamUtils
					.createObjectStream(nameStreams.toArray(new ObjectStream[0]));

			TokenNameFinderModel tokenNameFinderModel = NameFinderME.train("en", "city", combinedNameSampleStream,
					TrainingParameters.defaultParams(), (AdaptiveFeatureGenerator) null,
					Collections.<String, Object>emptyMap());
			combinedNameSampleStream.close();
			tokenNameFinderModels.add(tokenNameFinderModel);
		}

		DocumentCategorizerME categorizer = new DocumentCategorizerME(doccatModel);
		NameFinderME[] nameFinderMEs = new NameFinderME[tokenNameFinderModels.size()];
		for (int i = 0; i < tokenNameFinderModels.size(); i++) {
			nameFinderMEs[i] = new NameFinderME(tokenNameFinderModels.get(i));
		}

		System.out.println("Training complete. Ready.");
		System.out.print(">");
		String s;
		String[] array = new String[1];
		int pointer = 0;
		System.out.println("Enter your question\n ");
		Scanner scanner = new Scanner(System.in);

		array[0]  = scanner.next();
		while (pointer < array.length) {
			s = array[pointer];
			pointer++;
			double[] outcome = categorizer.categorize(s);
			System.out.print("action=" + categorizer.getBestCategory(outcome) + " args={ ");

			String[] tokens = WhitespaceTokenizer.INSTANCE.tokenize(s);
			for (NameFinderME nameFinderME : nameFinderMEs) {
				Span[] spans = nameFinderME.find(tokens);
				String[] names = Span.spansToStrings(spans, tokens);
				for (int i = 0; i < spans.length; i++) {
					System.out.print(spans[i].getType() + "=" + names[i] + " ");
					/*
					 * 
					 */
					IWeatherDataService dataService = WeatherDataServiceFactory
							.getWeatherDataService(service.OPEN_WEATHER_MAP);
					WeatherData data;
					try {
						data = dataService.getWeatherData(new Location(names[i], names[i]));

						System.out.println(data.toString());
					} catch (WeatherDataServiceException e) {
						e.printStackTrace();
					}

				}
			}
			System.out.println("}");
			System.out.print(">");

		}
	}

	private void welcomeMethod() {
		System.out.println("Hello in The Weather Chatbot\n");
		System.out
				.println("Please Specify an option\n1- Enter your city/countery\n2- enter long/latitude\n3- Use NLP\n");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.next();

		if (option.equals("1")) {
			System.out.println("Enter your city/countery\n ");
			String loc = scanner.next();

			IWeatherDataService dataService = WeatherDataServiceFactory.getWeatherDataService(service.OPEN_WEATHER_MAP);
			WeatherData data;
			try {
				data = dataService.getWeatherData(new Location(loc, loc));
				System.out.println(data.toString());
			} catch (WeatherDataServiceException e) {
				e.printStackTrace();
			}

		} else if (option.equals("2")) {
			System.out.println("Enter your long\n ");

			String lon = scanner.next();
			System.out.println("Enter your latitude\n ");

			String lat = scanner.next();

			IWeatherDataService dataService = WeatherDataServiceFactory.getWeatherDataService(service.OPEN_WEATHER_MAP);
			WeatherData data;
			try {
				 data = dataService.getWeatherDataLongLatitude(new Coord(lon, lat));
				System.out.println(data.toString());
			} catch (WeatherDataServiceException e) {
				e.printStackTrace();
			}

		} else if (option.equals("3")) {
			optionVal = 3;

		} else {
			System.out.println("cannot understand your option!\n");
		}

	}

}
