package nlp.intent.weatherclasses;


public class Direction
{
	private String value;
	private String name;
	private String code;


	public Direction(String value, String code, String name)
	{
		super();
		this.value = value;
		this.code = code;
		this.name = name;
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

	
	public String getDirectionCode()
	{
		return code;
	}

	
	public void setDirectionCode(String directionCode)
	{
		this.code = directionCode;
	}

	
	@Override
	public String toString()
	{
		return getValue() + ", " + getName();
	}
}