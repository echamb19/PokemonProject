package pokemon.model;

public class Eevee extends Pokemon implements Normal
{
	public Eevee(int number, String name)
	{
		super(number, name);
	}
	
	public void tackle()
	{
		System.out.println("Hiyah!");
	}
	
	public String taunt()
	{
		String taunt = "You suck!"; 
		return taunt;
	}
	
	public void pounce()
	{
		System.out.println("Gotcha!");
	}
}
