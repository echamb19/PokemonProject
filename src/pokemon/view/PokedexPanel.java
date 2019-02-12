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
	
	private JButton changeButton;
	private JComboBox pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField; 
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel; 
	private JLabel evolveLabel;
	private JLabel attackLabel; 
	private JLabel enhancementLabel; 
	private JLabel healthLabel; 
	private JLabel imageLabel; 
	
	public PokedexPanel(PokedexController pokeController)
	{
		super();
		
		this.pokeController = pokeController;
		appLayout = new SpringLayout();

		numberLabel = new JLabel("This Pokemon's number is ");
		nameLabel = new JLabel ("My Name is ");
		evolveLabel = new JLabel("This pokemon can evolve: ");
		attackLabel = new JLabel("This pokemon attack level is ");
		enhancementLabel = new JLabel(" This pokemon enhancement is ");
		healthLabel = new JLabel("This Pokemon's health is ");
		imageLabel = new JLabel("Pokemon goes here.");
				
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		changeButton = new JButton("Change");
		pokedexDropdown = new JComboBox();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.BLACK);
		
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhancementLabel);
		this.add(healthLabel);
		this.add(imageLabel);	
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{

	}
}

