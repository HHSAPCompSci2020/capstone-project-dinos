import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

	private JPanel cardPanel;
	private DrawingSurface panel1;
	
	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    panel1 = new DrawingSurface();
	    panel1.init();
	    
	    cardPanel.add(panel1);
	    add(cardPanel);
	    
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		Main main = new Main("CovidRun");
		System.out.println("This is our Capstone Project");
	}

	public void changePanel() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		panel1.requestFocus();
	}
}
