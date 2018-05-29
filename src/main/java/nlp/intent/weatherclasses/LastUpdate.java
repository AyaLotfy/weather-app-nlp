package nlp.intent.weatherclasses;


public class LastUpdate
{
	private String value;

	public LastUpdate(String value)
	{
		super();
		this.value = value;
	}

	
	public String getValue()
	{
		return value.replace('T', ' ');
	}

	
	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return "LastUpdate [Value=" + getValue() + "]";
	}
}