/**
 * Class that is run to start the program
 * @author 
 */
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

	private JPanel cardPanel;
	private OptionPanel menu;
	private DrawingSurface game;
	private CustomizePanel customize;
	private EndPanel end;
	private SettingsPanel settings;
	
	/**
	 * Constructor for Main class
	 * @param title name of the window
	 */
	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    game = new DrawingSurface(this);
	    game.init();
	    menu = new OptionPanel(this);    
	    customize = new CustomizePanel(this);
	    end = new EndPanel(this);
	    settings = new SettingsPanel(this);
	    
	    cardPanel.add(menu, "1");
	    cardPanel.add(game, "2");
	    cardPanel.add(customize, "3");
	    cardPanel.add(end, "4");
	    cardPanel.add(settings, "5");
	    add(cardPanel);
	    addKeyListener(game);
	    
	    setVisible(true);
	}
	
	/**
	 * Main method
	 * @param args String array passed to main method
	 */
	public static void main(String[] args) {
		Main main = new Main("CovidRun");
		System.out.println("This is our Capstone Project");
		System.out.println("Made by: Clarence Choy, Isaac Phoon, Yukai Qiu");
	}
	
	/**
	 * Returns the DrawingSurface
	 * @return DrawingSurface that Main has
	 */
	public DrawingSurface getDrawingSurface() {
		return game;
		
	}

	/**
	 * Changes the panel shown
	 * @param name the name of the panel
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
		
		
	}
}
