package pokemon.controller;

import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import pokemon.model.Pokemon;

public class PokedexController
{
	private PokedexFrame pokeFrame;
	
	public PokedexController()
	{
		pokeFrame = new PokedexFrame(this);
		
		String [] pokemonList = new String [5];
	}
	
	public void start()
	{
		
	}
	
	public void updatePokemon(int index, String [] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
		}
	}
	
	public String[] buildPokedexText()
	{
		String [] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names; 
	}
}
