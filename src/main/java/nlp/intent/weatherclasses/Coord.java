package nlp.intent.weatherclasses;


public class Coord
{
	private String longitude;
	private String latitude;

	
	public Coord(String longitude, String latitude)
	{
		super();
		setLatitude(latitude);
		setLongitude(longitude);
	}

	
	public String getLongitude()
	{
		return longitude;
	}

	
	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}

	public String getLatitude()
	{
		return latitude;
	}

	
	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	
	@Override
	public String toString()
	{
		return "[" + getLongitude() + "," + getLatitude() + "]";
	}
}