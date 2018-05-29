package nlp.intent.weatherclasses;


public class Weather
{
	private String number;
	private String value;
	private String icon;

	
	public Weather(String value, String icon, String number)
	{
		super();
		setValue(value);
		setIcon(icon);
		setNumber(number);
	}

	
	public String getNumber()
	{
		return number;
	}

	
	public void setNumber(String number)
	{
		this.number = number;
	}

	
	public String getValue()
	{
		return value;
	}

	
	public void setValue(String value)
	{
		this.value = value;
	}

	
	public String getIcon()
	{
		return icon;
	}

	
	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	
	@Override
	public String toString()
	{
		return "Weather [Value=" + getValue() + ", \nIcon=" + getIcon() + ", Number=" + getNumber() + "]";
	}
}