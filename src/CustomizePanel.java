/**
 * Represents the customization panel
 * @author Clarence Choy
 */
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class CustomizePanel extends JPanel implements ActionListener{

	private Main w;
	private JPanel p;
	private JButton doctor, dinosaur, dora, pinkie;
	private JButton exit;
	
	private String message, character;

	
	/**
	 * Constructor for CustomizePanel
	 * @param w Main object used in CustomizePanel
	 */
	public CustomizePanel(Main w) {
		this.w = w;
		p = new JPanel();
		setBackground(new Color(50, 255, 80));
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		
		doctor = new JButton("Doctor");
		doctor.addActionListener(this);
		dinosaur = new JButton("Dinosaur");
		dinosaur.addActionListener(this);
		dora = new JButton("Dora the Explorer");
		dora.addActionListener(this);
		pinkie = new JButton("Pinkie Pie");
		pinkie.addActionListener(this);
		
		exit = new JButton("Back to Menu");
		exit.addActionListener(this);

		message = "Customize your character! Click the tag above to select!";
		character = "Doctor";
		
		p.add(doctor);
		p.add(dinosaur);
		p.add(dora);
		p.add(pinkie);
		p.add(exit);
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
		g.setFont(new Font("SansSerif",Font.BOLD,28));
		int strWidth = g.getFontMetrics().stringWidth(message);
		g.drawString(message, 400-strWidth/2, 300);

		g.setFont(new Font("SansSerif",Font.PLAIN,24));
		strWidth = g.getFontMetrics().stringWidth("Your character is set as " + character);
		g.drawString("Your character is set as " + character, 400-strWidth/2, 70);
		
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/doctor.png"), 160, 100, 60, 100, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/dinosaur.png"), 240, 100, 60, 90, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/dora.png"), 340, 100, 60, 100, this);
		g2.drawImage(Toolkit.getDefaultToolkit().getImage("media/pinkiePie.png"), 460, 100, 60, 100, this);
		
		g2.setTransform(at);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == doctor) {
			w.getDrawingSurface().changePlayer("media/doctor.png");
			character = "Doctor";
		} else if(e.getSource() == dinosaur) {
			w.getDrawingSurface().changePlayer("media/dinosaur.png");
			character = "Dinosaur";
		} else if(e.getSource() == dora) {
			w.getDrawingSurface().changePlayer("media/dora.png");
			character = "Dora the Explorer";
		} else if(e.getSource() == pinkie) {
			w.getDrawingSurface().changePlayer("media/pinkiePie.png");
			character = "Pinkie Pie";
		}
		repaint();
		
		if(e.getSource() == exit) {
			w.changePanel("1");
		}
	}

	
	
}
