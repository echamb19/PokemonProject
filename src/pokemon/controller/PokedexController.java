package pokemon.controller;

import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import java.util.ArrayList;
import pokemon.model.*;

public class PokedexController
{
	private PokedexFrame pokeFrame;
	private ArrayList<Pokemon> pokemonList;
	
	public PokedexController()
	{
		pokeFrame = new PokedexFrame(this); 
		
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
	}
	
	private void addPokemon()
	{
		pokemonList.add(new Eevee());
		pokemonList.add(new Squirtle());
		pokemonList.add(new Pichu());
		pokemonList.add(new Torchic());
		pokemonList.add(new Togepi());
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
	
	public boolean isDouble(String mightBeDouble)
	{
		boolean isValid = false;
		
		try
		{
			Double.parseDouble(mightBeDouble);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "Type a decimal value please.");
		}
		return isValid;
	}
	
	public boolean isInt(String maybeInt)
	{
		boolean isValid = false; 
		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch (NumberFormatException error) //Two things inside perens is formal perameter
		{
			JOptionPane.showMessageDialog(null, "You need to type in a whole number. :)");
		}
		
		return isValid;
	}
}
