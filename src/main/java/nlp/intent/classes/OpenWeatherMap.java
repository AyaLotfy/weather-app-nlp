package nlp.intent.classes;

import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import nlp.intent.exceptions.WeatherDataServiceException;
import nlp.intent.weatherclasses.Coord;


public class OpenWeatherMap implements IWeatherDataService {
	private WeatherData weatherData = new WeatherData();
	private static volatile OpenWeatherMap weatherMap;

	private OpenWeatherMap() {
	}

	public static OpenWeatherMap getInstance() {
		if (weatherMap == null) {
			weatherMap = new OpenWeatherMap();
		}

		return weatherMap;
	}

	
	public WeatherData getWeatherData(Location location)
	{
		String city = location.getCity();
		String country = location.getCountry();

		try {
			URL url;
			String appID = "bd5e378503939ddaee76f12ad7a97608";
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units="
					+ location.getUnit() + "&mode=xml&APPID=" + appID);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			InputStream in = con.getInputStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);

			weatherData.setAllWeatherDataByTagNames(doc);
		} catch (Exception e) {
			System.out.println("Weather parsing error. please try again or contact app developer.");
			e.printStackTrace();
		}

		return weatherData;
	}

	public WeatherData getWeatherDataLongLatitude(Coord coord)
	{

		try {
			URL url;
			String appID = "bd5e378503939ddaee76f12ad7a97608";
			String lat = coord.getLatitude();
			;
			String lon =

					coord.getLongitude();

			url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon
					+ "&mode=xml&APPID=" + appID);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			InputStream in = con.getInputStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);

			weatherData.setAllWeatherDataByTagNames(doc);
		} catch (Exception e) {
			System.out.println("Weather parsing error. please try again or contact app developer.");
			e.printStackTrace();
		}

		return weatherData;
	}


}