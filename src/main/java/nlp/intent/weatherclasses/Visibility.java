package nlp.intent.weatherclasses;


public class Visibility
{
	private String value;

	public Visibility(String value)
	{
		super();
		setValue(value);
	}

	public String getValue()
	{
		return value;
	}

	
	public void setValue(String value)
	{
		this.value = value;
	}


	@Override
	public String toString()
	{
		return "Visibility [Value=" + getValue() + "]";
	}
}