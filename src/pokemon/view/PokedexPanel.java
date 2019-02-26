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
	private JButton saveButton;
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
		
		this.app = pokeController;
		this.appLayout = new SpringLayout();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/pokeball2.png"));

		numberLabel = new JLabel("This Pokemon's number is ");
		numberLabel.setForeground(Color.WHITE);
		nameLabel = new JLabel ("My Name is ");
		nameLabel.setForeground(Color.WHITE);
		evolveLabel = new JLabel("This pokemon can evolve: ");
		evolveLabel.setForeground(Color.WHITE);
		attackLabel = new JLabel("This pokemon attack level is ");
		attackLabel.setForeground(Color.WHITE);
		enhancementLabel = new JLabel(" This pokemon enhancement is ");
		enhancementLabel.setForeground(Color.WHITE);
		healthLabel = new JLabel("This Pokemon's health is ");
		healthLabel.setForeground(Color.WHITE);
		imageLabel = new JLabel("Pokemon goes here", pokemonIcon, JLabel.CENTER);
				
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		changeButton = new JButton("Change");
		saveButton = new JButton("Save");
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 223, SpringLayout.WEST, this);
		pokedexDropdown = new JComboBox<String>();
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 400));
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
		this.add(saveButton);
		this.add(pokedexDropdown);
		
		numberField.setEnabled(false);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 34, SpringLayout.SOUTH, enhancementField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -93, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 34, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, -93, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 34, SpringLayout.SOUTH, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, -93, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 34, SpringLayout.SOUTH, numberField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -93, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 34, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 34, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -93, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -93, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -62, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, enhancementLabel, 55, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 55, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 55, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 55, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 55, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, 313, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 43, SpringLayout.SOUTH, enhancementLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 368, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementLabel, 43, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 43, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 43, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 43, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 43, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -14, SpringLayout.WEST, changeButton);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -6, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 5, SpringLayout.SOUTH, imageLabel);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent click)
				{
					sendDataToController();
				}
		});
		
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
//				updateFields();
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.savePokedex();
			}
		});
	}
	
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String [5];
			
			data[0] = attackField.getText();
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = nameField.getText();
			data[4] = evolveField.getText();
			
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "pokeball2";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch(NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void updateFields(int index)
	{
		String [] data = app.getPokeData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
		
	}
}

