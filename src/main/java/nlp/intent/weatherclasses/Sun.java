package nlp.intent.weatherclasses;


public class Sun
{
	private String rise;
	private String set;

	
	public Sun(String rise, String set)
	{
		super();
		setRise(rise);
		setSet(set);
	}

	
	public String getRise()
	{
		return rise.replace('T', ' ');
	}

	
	public void setRise(String rise)
	{
		this.rise = rise;
	}

	
	public String getSet()
	{
		return set.replace('T', ' ');
	}

	
	public void setSet(String set)
	{
		this.set = set;
	}

	@Override
	public String toString()
	{
		return "[Rise: " + getRise() + "] [Set: " + getSet() + "]";
	}
}