package pokemon.model;

public class Togepi extends Pokemon implements Fairy
{
	public Togepi(int number, String name)
	{
		super(number, name);
	}
	
	public void tackle()
	{
		System.out.println("Boom!");
	}
	
	public String enchant()
	{
		String enchantment = "Bippidy Boppidy Boo!";
		return enchantment; 
	}
}
