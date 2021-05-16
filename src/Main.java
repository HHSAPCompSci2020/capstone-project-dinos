/**
 * Class that is run to start the program
 * @author 
 */
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

	private JPanel cardPanel;
	private OptionPanel panel1;
	private DrawingSurface panel2;
	
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
	    
	    panel1 = new OptionPanel(this);    
	    panel2 = new DrawingSurface(this);
	    panel2.init();
	    
	    cardPanel.add(panel1, "1");
	    cardPanel.add(panel2, "2");
	    add(cardPanel);
	    addKeyListener(panel2);
	    
	    setVisible(true);
	}
	
	/**
	 * Main method
	 * @param args String array passed to main method
	 */
	public static void main(String[] args) {
		Main main = new Main("CovidRun");
		System.out.println("This is our Capstone Project");
		System.out.println("Made by: Isaac Phoon, Clarence Choy, Yukai Qiu");
	}

	/**
	 * Changes the panel shown
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
		
		if(name.equals("2"))
			panel2.startGame();
	}
}
