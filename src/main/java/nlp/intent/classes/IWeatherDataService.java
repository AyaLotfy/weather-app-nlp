package nlp.intent.classes;
import nlp.intent.exceptions.WeatherDataServiceException;
import nlp.intent.weatherclasses.Coord;


public interface IWeatherDataService
{
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException;
	public WeatherData 	getWeatherDataLongLatitude(Coord coord) throws WeatherDataServiceException;

}
