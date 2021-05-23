/**
 * Represents the option panel
 * @author Clarence Choy
 */
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	private JPanel p;
	private JButton startButton, customizeButton, settingsButton;
	
	/**
	 * Constructor for OptionPanel
	 * @param w Main object used in OptionPanel
	 */
	public OptionPanel(Main w) {
		this.w = w;
		p = new JPanel();
		setBackground(new Color(0, 180, 255));
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		
		startButton = new JButton("Start the game!");
		startButton.addActionListener(this);
		
		customizeButton = new JButton("Customize your character");
		customizeButton.addActionListener(this);
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(this);
		
		p.add(startButton);
		p.add(customizeButton);
		p.add(settingsButton);
		add(p);
		w.add(this);
		
	}
	
	@Override
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
		g.drawString("Legend", 60, 200);
		g.drawString("Controls", 550, 250);
		g.setFont(new Font("SansSerif",Font.BOLD,17));
		g.drawString("Covid: Bad! Hit it and you will die!", 50, 310);
		g.drawString("Mask: Take and receive 30 Points!", 50, 400);
		g.drawString("Vaccine: Immunity for 5 seconds!", 50, 510);
		g.setFont(new Font("SansSerif",Font.BOLD,25));
		g.drawString("Jump", 650, 335);
		g.drawString("Duck", 650, 400);
		
		
		
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/doctor.png"), 375, 250, 120, 200, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/covid.png"), 100, 230, 50, 50, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/mask.png"),100, 320, 50, 50, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/vaccine.png"), 100, 420, 50, 50, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/keys.png"), 550, 250, 60, 200, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/Untitled-removebg-preview.png"), 150, 50, 500, 200, this);
		g2.setTransform(at);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			w.changePanel("2");
			w.getDrawingSurface().startGame();
			
		} else if(e.getSource() == customizeButton) {
			w.changePanel("3");
			
		} else if(e.getSource() == settingsButton) {
			w.changePanel("5");
		}
		
		w.remove(this);
	}
	
}