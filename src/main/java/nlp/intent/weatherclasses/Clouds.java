package nlp.intent.weatherclasses;


public class Clouds
{
	private String value;
	private String name;


	public Clouds(String name, String value)
	{
		super();
		this.name = name;
		this.value = value;
	}

	
	public String getValue()
	{
		return value;
	}

	
	public void setValue(String value)
	{
		this.value = value;
	}

	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return getValue() + " : " + getName();
	}
}