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
	private String message1, message2, message3;
	private Image docImage;
	
	/**
	 * Constructor for OptionPanel
	 * @param w Main object used in OptionPanel
	 */
	public OptionPanel(Main w) {
		this.w = w;
		d = w.getDrawingSurface();
		p = new JPanel();
		setBackground(new Color(230, 50, 210));
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		//p.add(Box.createVerticalStrut(500));
		
		startButton = new JButton("Start the game!");
		startButton.addActionListener(this);
		
		customizeButton = new JButton("Customize your character");
		customizeButton.addActionListener(this);
		
		message1 = "Instructions: Control a character by jumping and ducking to avoid Coronavirus particles";
		message2 = "while also collecting masks for bonus points and vaccines for a few seconds of invincibility.";
		message3 = "Press the up arrow key to jump and the down arrow key to duck.";
		
		docImage = Toolkit.getDefaultToolkit().getImage("media/doctor.png");
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
		g.setFont(new Font("SansSerif",Font.BOLD,17));
		g.drawString(message1, 40, 400);
		g.drawString(message2, 40, 450);
		g.drawString(message3, 40, 500);

		g2.setTransform(at);
		g2.drawImage(docImage, 335, 100, 120, 200, this);
		
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