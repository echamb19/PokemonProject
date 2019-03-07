package pokemon.controller;

import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import java.util.ArrayList;
import pokemon.model.*;
import java.io.*;

public class PokedexController
{
	private PokedexFrame pokeFrame;
	private ArrayList<Pokemon> pokemonList;
	private String saveFile = "backup.pokemon";
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		pokeFrame = new PokedexFrame(this); 
	}
	
	private void addPokemon()
	{
		pokemonList.add(new Eevee());
		pokemonList.add(new Squirtle());
		pokemonList.add(new Pichu());
		pokemonList.add(new Torchic());
		pokemonList.add(new Togepi());
		pokemonList.add(new FlyingToast());
	}
	
	public void start()
	{
		loadPokedex();
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return pokemonList;
	}
	
	public PokedexFrame getFrame()
	{
		return pokeFrame;
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

	public String [] getPokeData(int index)
	{
		String [] data = new String [6];
		Pokemon current = pokemonList.get(index);
		data[0] = current.getAttackPoints() + "";
		data[1] = current.getEnhancementModifier() + "";
		data[2] = current.getHealthPoints() + "";
		data[3] = current.getName() + "";
		data[4] = current.isCanEvolve() + "";
		data[5] = current.getNumber() + "";
		return data;
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
	
	public void savePokedex()
	{
		try
		{
			FileOutputStream saveStream = new FileOutputStream(saveFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream);
			output.writeObject(pokemonList);
			output.close();
			saveStream.close();
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(pokeFrame, error.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadPokedex()
	{
		try
		{
			ArrayList<Pokemon> saved = new ArrayList<Pokemon>(); 
			FileInputStream inputStream = new FileInputStream(saveFile);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			saved = (ArrayList<Pokemon>) input.readObject();
			input.close();
			inputStream.close();
			pokemonList = saved;
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(pokeFrame, "No Save File", "LoadingPokemon", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(ClassNotFoundException pokemonError)
		{
			JOptionPane.showMessageDialog(pokeFrame, pokemonError.getMessage(), "Type Error", JOptionPane.ERROR_MESSAGE);
		}
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
