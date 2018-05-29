package nlp.intent.weatherclasses;


public class Speed
{
	private String value;
	private String name;

	
	public Speed(String value, String name)
	{
		super();
		setValue(value);
		setName(name);
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
		return getValue() + "m/s, " + getName();
	}
}