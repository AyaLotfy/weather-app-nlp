package nlp.intent.classes;

import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import nlp.intent.weatherclasses.*;


public class WeatherData {
	private City city;
	private Clouds clouds;
	private Direction direction;
	private Humidity humidity;
	private LastUpdate lastUpdate;
	private Precipitation precipitation;
	private Pressure pressure;
	private Temperature temperature;
	private Visibility visibility;
	private Weather weather;
	private Wind wind;
	private Speed speed;
	private Sun sun;

	private void debugPrint(String s) {
		System.out.println(s);
	}

	private void setAttribute(String currentTagName, Element rootElement) {
		NodeList currentList = rootElement.getElementsByTagName(currentTagName);
		Node currentNode = currentList.item(0);
		Element currentElement = (Element) currentNode;


		if (currentTagName.equals("city")) {
			city = new City(currentElement.getAttribute("id"), currentElement.getAttribute("name"));
		} else if (currentTagName.equals("coord")) {
			Coord coord = new Coord(currentElement.getAttribute("lon"), currentElement.getAttribute("lat"));
			city.setCoordinates(coord);
		} else if (currentTagName.equals("country")) {
			city.setCountry(currentElement.getTextContent());
		} else if (currentTagName.equals("sun")) {
			sun = new Sun(currentElement.getAttribute("rise"), currentElement.getAttribute("set"));
			city.setSun(sun);
		} else if (currentTagName.equals("temperature")) {
			temperature = new Temperature(currentElement.getAttribute("value"), currentElement.getAttribute("min"),
					currentElement.getAttribute("max"), currentElement.getAttribute("unit"));
		} else if (currentTagName.equals("humidity")) {
			humidity = new Humidity(currentElement.getAttribute("value"), currentElement.getAttribute("unit"));
		} else if (currentTagName.equals("pressure")) {
			pressure = new Pressure(currentElement.getAttribute("value"), currentElement.getAttribute("unit"));
		} else if (currentTagName.equals("wind")) {
			wind = new Wind();
		} else if (currentTagName.equals("speed")) {
			Speed speed = new Speed(currentElement.getAttribute("value"), currentElement.getAttribute("name"));
			wind.setSpeed(speed);
		} else if (currentTagName.equals("direction")) {
			Direction direction = new Direction(currentElement.getAttribute("value"),
					currentElement.getAttribute("code"), currentElement.getAttribute("name"));
			wind.setDirection(direction);
		} else if (currentTagName.equals("clouds")) {
			clouds = new Clouds(currentElement.getAttribute("value"), currentElement.getAttribute("name"));
		} else if (currentTagName.equals("visibility")) {
			visibility = new Visibility(currentElement.getAttribute("value"));
		} else if (currentTagName.equals("precipitation")) {
			precipitation = new Precipitation(currentElement.getAttribute("value"),
					currentElement.getAttribute("mode"));
		} else if (currentTagName.equals("weather")) {
			weather = new Weather(currentElement.getAttribute("value"), currentElement.getAttribute("icon"),
					currentElement.getAttribute("number"));
		} else if (currentTagName.equals("lastupdate")) {
			lastUpdate = new LastUpdate(currentElement.getAttribute("value"));
		}

	
	}

	public void setAllWeatherDataByTagNames(Document doc) {
		NodeList list = doc.getElementsByTagName("current");
		Node rootNode = list.item(0);
		Element rootElement = (Element) rootNode;

		setAttribute("city", rootElement);
		setAttribute("coord", rootElement);
		setAttribute("country", rootElement);
		setAttribute("sun", rootElement);
		setAttribute("temperature", rootElement);
		setAttribute("humidity", rootElement);
		setAttribute("pressure", rootElement);
		setAttribute("wind", rootElement);
		setAttribute("speed", rootElement);
		setAttribute("direction", rootElement);
		setAttribute("clouds", rootElement);
		setAttribute("visibility", rootElement);
		setAttribute("precipitation", rootElement);
		setAttribute("weather", rootElement);
		setAttribute("lastupdate", rootElement);
	}

	/**
	 * A Method that returns a string that describes the WeatherData object
	 */
	@Override
	public String toString() {
		return "WeatherData [Clouds=" + getClouds() + ", Wind=" + getWind() + ",\nLast update=" + getLastUpdate()
				+ ", Humidity=" + getHumidity() + ", \nPressure=" + getPressure() + ", Visibility=" + getVisibility()
				+ ", \nPrecipitation=" + getPrecipitation() + ", Weather=" + getWeather() + ", Temperature="
				+ getTemperature() + "]";
	}


	public City getCity() {
		return city;
	}


	public Clouds getClouds() {
		return clouds;
	}


	public Direction getDirection() {
		return direction;
	}

	public Humidity getHumidity() {
		return humidity;
	}

	public LastUpdate getLastUpdate() {
		return lastUpdate;
	}


	public Precipitation getPrecipitation() {
		return precipitation;
	}


	public Pressure getPressure() {
		return pressure;
	}


	public Speed getSpeed() {
		return speed;
	}


	public Sun getSun() {
		return sun;
	}


	public Temperature getTemperature() {
		return temperature;
	}


	public Visibility getVisibility() {
		return visibility;
	}

	
	public Weather getWeather() {
		return weather;
	}


	public Wind getWind() {
		return wind;
	}
}