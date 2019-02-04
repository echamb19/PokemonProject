package pokemon.view;

import javax.swing.*;
import java.awt.Dimension; 
import pokemon.controller.PokedexController; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font; 

public class PokedexPanel extends JPanel
{
	
	private PokedexController pokeController;
	private SpringLayout appLayout;
	
	public PokedexPanel(PokedexController pokeController)
	{
		super();
		
		this.pokeController = pokeController;
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.BLACK);
		
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{

	}
}

