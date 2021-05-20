/**
 * Represents the end game panel
 * @author Clarence Choy
 */
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class SettingsPanel extends JPanel implements ActionListener{

	private Main w;
	private DrawingSurface d;
	
	private JPanel p;
	private JButton exit, buildings, timeOfDay, hitboxes;
	
	private String message;
	
	
	/**
	 * Constructor for CustomizePanel
	 * @param w Main object used in CustomizePanel
	 */
	public SettingsPanel(Main w) {
		this.w = w;
		d = w.getDrawingSurface();
		p = new JPanel();
		setBackground(new Color(255, 200, 60));
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		
		buildings = new JButton("Toggle Building Background");
		buildings.addActionListener(this);
		
		timeOfDay = new JButton("Toggle Night & Day");
		timeOfDay.addActionListener(this);
		
		exit = new JButton("Back to Menu");
		exit.addActionListener(this);
		
		hitboxes = new JButton("Toggle Hitboxes");
		hitboxes.addActionListener(this);
		
		message = "";
		
		p.add(buildings);
		p.add(timeOfDay);
		p.add(hitboxes);
		p.add(exit);
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

		g.setFont(new Font("SansSerif",Font.BOLD,28));
		g.setColor(Color.BLACK);
		message = "Change the settings of the game";
		int strWidth = g.getFontMetrics().stringWidth(message);
		g.drawString(message, 400-strWidth/2, 350);
		
//		g.setFont(new Font("SansSerif",Font.PLAIN,14));
//		if(d.getDrawBuildings()) g.drawString("Buildings: ON", 160, 50);
//		else g.drawString("Buildings: OFF", 110, 50);
//		if(d.getDrawNightAndDay()) g.drawString("Night & Day: ON", 330, 50);
//		else g.drawString("Night & Day: OFF", 320, 50);
//		if(d.getDrawHitboxes()) g.drawString("Hitboxes: ON", 470, 50);
//		else g.drawString("Hitboxes: OFF", 470, 50);
		
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/buildingBackground.png"), 110, 80, 180, 120, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/dayAndNight.png"), 320, 80, 100, 100, this);
		g2.setColor(Color.WHITE);
		g2.fillRect(470, 80, 80, 135);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/doctor.png"), 470, 80, 80, 135, this);
		
		g2.setTransform(at);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			w.changePanel("1");
			
		} else if(e.getSource() == buildings) {
			d.setSettings(!d.getDrawBuildings(), d.getDrawNightAndDay(), d.getDrawHitboxes());
			if(d.getDrawBuildings()) System.out.println("Buildings: ON");
			else System.out.println("Buildings: OFF");
			
		} else if(e.getSource() == timeOfDay) {
			d.setSettings(d.getDrawBuildings(), !d.getDrawNightAndDay(), d.getDrawHitboxes());
			if(d.getDrawNightAndDay()) System.out.println("Night & Day: ON");
			else System.out.println("Night & Day: OFF");
			
		} else if(e.getSource() == hitboxes) {
			d.setSettings(d.getDrawBuildings(), d.getDrawNightAndDay(), !d.getDrawHitboxes());
			if(d.getDrawHitboxes()) System.out.println("Hitboxes: ON");
			else System.out.println("Hitboxes: OFF");
		}
	}

	
	
}
