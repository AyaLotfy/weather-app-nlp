package nlp.intent.classes;


public class WeatherDataServiceFactory
{

	public enum service
	{
		OPEN_WEATHER_MAP;
	}


	public static IWeatherDataService getWeatherDataService(service i_Service)
	{
		switch (i_Service)
		{
		case OPEN_WEATHER_MAP:
			return OpenWeatherMap.getInstance();
		}

		return null;
	}
}