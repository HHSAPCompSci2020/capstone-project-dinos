/**
 * Represents the option panel
 * @author Clarence Choy
 */
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	private DrawingSurface d;
	private JPanel p;
	private JButton startButton, customizeButton;
	
	
	/**
	 * Constructor for OptionPanel
	 * @param w Main object used in OptionPanel
	 */
	public OptionPanel(Main w) {
		this.w = w;
		d = w.getDrawingSurface();
		p = new JPanel();
		setBackground(new Color(0, 180, 255));
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		
		startButton = new JButton("Start the game!");
		startButton.addActionListener(this);
		
		customizeButton = new JButton("Customize your character");
		customizeButton.addActionListener(this);
		

		
		p.add(startButton);
		p.add(customizeButton);
		add(p);
		w.add(this);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/800.0;
		double ratioY = (double)height/600.0;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		g.setColor(Color.BLACK);

		g.setFont(new Font("SansSerif",Font.BOLD,30));
		g.drawString("Item Description", 65, 70);
		g.drawString("Controls", 600, 100);
		g.setFont(new Font("SansSerif",Font.BOLD,17));
		g.drawString("Covid: Bad! Hit it and you will die!", 50, 160);
		g.drawString("Mask: Take and receive 30 Points!", 52, 250);
		g.drawString("Vaccine: Immunity for 5 seconds!", 54, 360);
		g.setFont(new Font("SansSerif",Font.BOLD,25));
		g.drawString("Jump", 700, 185);
		g.drawString("Duck", 700, 250);
		
		g2.setTransform(at);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/doctor.png"), 335, 100, 120, 200, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/covid.png"), 100, 80, 50, 50, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/mask.png"),100,170,50,50,this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/vaccine.png"), 100,270,50,50,this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/keys.png"), 600,100,60,200,this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			w.changePanel("2");
			d.startGame();
			
		} if(e.getSource() == customizeButton) {
			w.changePanel("3");
		}
		
		w.remove(this);
	}
	
}