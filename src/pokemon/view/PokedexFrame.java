package pokemon.view;

import javax.swing.JFrame;
import pokemon.controller.PokedexController;

public class PokedexFrame extends JFrame
{
	private PokedexController pokeController;
	private PokedexPanel pokePanel;
	
	public PokedexFrame(PokedexController pokeController)
	{
		super();
		
		this.pokeController = pokeController; 
		this.pokePanel = new PokedexPanel(pokeController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(pokePanel);
		this.setTitle("Pokemon Data");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}
