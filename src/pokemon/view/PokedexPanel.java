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
	
	private JTextField PichuText;
	private JTextField EeveeText;
	private JTextField SquirtleText;
	private JTextField TogepiText;
	private JTextField TorchicText; 
	
	private JLabel PichuLabel;
	private JLabel EeveeLabel; 
	private JLabel SquirtleLabel;
	private JLabel TogepiLabel; 
	private JLabel TorchicLabel; 
	
	public PokedexPanel(PokedexController pokeController)
	{
		super();
		
		this.pokeController = pokeController;
		appLayout = new SpringLayout();
		
		PichuText = new JTextField("Pichu is...");
		EeveeText = new JTextField("Eevee is...");
		SquirtleText = new JTextField("Squirtle is...");
		TogepiText = new JTextField("Togepi is...");
		TorchicText = new JTextField("Torchic is...");
		
		PichuLabel = new JLabel("Pichu");
		EeveeLabel = new JLabel ("Eevee");
		SquirtleLabel = new JLabel("Squirtle");
		TogepiLabel = new JLabel("Togepi");
		TorchicLabel = new JLabel("Torchic");
		
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

