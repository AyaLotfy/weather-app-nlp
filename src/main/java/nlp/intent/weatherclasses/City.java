package nlp.intent.weatherclasses;


public class City
{
	private String id;
	private String name;
	private String country;
	private Coord coord;
	private Sun sun;


	public City(String ID, String name)
	{
		setID(ID);
		setName(name);
	}


	public String getID()
	{
		return id;
	}


	public void setID(String id)
	{
		this.id = id;
	}


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public String getCountry()
	{
		return country;
	}

	public void setCountry(String countryCode)
	{
		this.country = countryCode;
	}


	public Coord getCoordinates()
	{
		return coord;
	}

	
	public void setCoordinates(Coord coordinates)
	{
		this.coord = coordinates;
	}


	public Sun getSun()
	{
		return sun;
	}


	public void setSun(Sun sun)
	{
		this.sun = sun;
	}

	@Override
	public String toString()
	{
		return "[ID=" + getID() + ", Name=" + getName() + ", Country Code=" + getCountry() + ", Coord="
				+ getCoordinates() + ", Sun=" + getSun() + "]";
	}
}