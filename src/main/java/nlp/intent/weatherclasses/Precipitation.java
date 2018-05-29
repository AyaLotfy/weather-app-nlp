package nlp.intent.weatherclasses;


public class Precipitation
{
	private String value;
	private String mode;

	
	public Precipitation(String value, String mode)
	{
		this.value = value;
		this.mode = mode;
	}

	
	public String getValue()
	{
		return value;
	}

	
	public void setValue(String value)
	{
		this.value = value;
	}

	
	public String getMode()
	{
		return mode;
	}

	
	public void setMode(String mode)
	{
		this.mode = mode;
	}

	
	public String toString()
	{
		return "[value=" + getValue() + ", mode=" + getMode() + "]";
	}
}