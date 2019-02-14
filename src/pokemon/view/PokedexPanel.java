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
	
	private PokedexController app;
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
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController pokeController)
	{
		super();
		
		this.app = app;
		appLayout = new SpringLayout();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/picture.png"));

		numberLabel = new JLabel("This Pokemon's number is ");
		nameLabel = new JLabel ("My Name is ");
		evolveLabel = new JLabel("This pokemon can evolve: ");
		attackLabel = new JLabel("This pokemon attack level is ");
		enhancementLabel = new JLabel(" This pokemon enhancement is ");
		healthLabel = new JLabel("This Pokemon's health is ");
		imageLabel = new JLabel("Pokemon goes here", pokemonIcon, JLabel.CENTER);
				
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		changeButton = new JButton("Change");
		pokedexDropdown = new JComboBox<String>(); // Stub
		
		setupDropdown();
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
		
		this.add(changeButton);
		this.add(pokedexDropdown);
		
		numberField.setEnabled(false);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{

	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
}
