package nlp.intent.weatherclasses;


public class Humidity
{
	private String value;
	private String unit;


	public Humidity(String value, String unit)
	{
		setValue(value);
		setUnit(unit);
	}

	
	public String getValue()
	{
		return value;
	}

	
	public void setValue(String value)
	{
		this.value = value;
	}

	
	public String getUnit()
	{
		return unit;
	}

	
	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	
	@Override
	public String toString()
	{
		return getValue() + getUnit();
	}
}
