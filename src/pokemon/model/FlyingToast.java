package pokemon.model;

public class FlyingToast extends Pokemon implements Fairy
{
	public FlyingToast()
	{
		super(115, "FlyingToast");
	}
	
	public FlyingToast(String name)
	{
		super(115, name);
	}
	
	public FlyingToast(int number, String name)
	{
		super(number, name);
	}
	
	public void tackle()
	{
		
	}
	
	public String enchant()
	{
		String says = "hOi!";
		return says; 
	}
}
