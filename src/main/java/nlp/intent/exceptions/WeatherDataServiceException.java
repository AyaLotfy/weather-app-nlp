package nlp.intent.exceptions;

public class WeatherDataServiceException extends Exception
{
	private static final long serialVersionUID = 1L;

	public WeatherDataServiceException()
	{
		super();
	}

	public WeatherDataServiceException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
	}


	public WeatherDataServiceException(String arg0)
	{
		super(arg0);
	}
}