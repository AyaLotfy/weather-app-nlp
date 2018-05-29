package nlp.intent.weatherclasses;


public class Wind
{
	private Speed speed;
	private Direction direction;

	
	public Wind(Speed speed, Direction direction)
	{
		super();
		setSpeed(speed);
		setDirection(direction);
	}

	
	public Wind()
	{

	}

	public Speed getSpeed()
	{
		return speed;
	}

	
	public void setSpeed(Speed speed)
	{
		this.speed = speed;
	}

	
	public Direction getDirection()
	{
		return direction;
	}

	
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}

	
	@Override
	public String toString()
	{
		return getSpeed() + ", " + getDirection();
	}
}