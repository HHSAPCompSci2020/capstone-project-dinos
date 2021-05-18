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
import java.awt.Image;
import java.awt.Toolkit;

public class CustomizePanel extends JPanel implements ActionListener{

	private Main w;
	private DrawingSurface d;
	
	private JPanel p;
	private JButton doctor, dinosaur;
	private JButton exit;
	private Image docImage, dinoImage;
	
	private String message;
	
	
	/**
	 * Constructor for CustomizePanel
	 * @param w Main object used in CustomizePanel
	 */
	public CustomizePanel(Main w) {
		this.w = w;
		d = w.getDrawingSurface();
		p = new JPanel();
		setBackground(new Color(75, 200, 50));
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		//p.add(Box.createVerticalStrut(500));
		
		doctor = new JButton("Doctor");
		doctor.addActionListener(this);
		dinosaur = new JButton("Dinosaur");
		dinosaur.addActionListener(this);
		
		exit = new JButton("Back to Menu");
		exit.addActionListener(this);
		
		docImage = Toolkit.getDefaultToolkit().getImage("media/doctor.png");
		dinoImage = Toolkit.getDefaultToolkit().getImage("media/dinosaur.png");
		
		message = "Customize your character!";
		
		p.add(doctor);
		p.add(dinosaur);
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

		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif",Font.BOLD,28));
		int strWidth = g.getFontMetrics().stringWidth(message);
		g.drawString(message, 400-strWidth/2, 300);
		
		g2.drawImage(docImage, 270, 100, 60, 100, this);
		g2.drawImage(dinoImage, 350, 100, 60, 90, this);
		
		g2.setTransform(at);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == doctor) {
			d.changePlayer("media/doctor.png");
			System.out.println("Your character is now a doctor");
		} 
		if(e.getSource() == dinosaur) {
			d.changePlayer("media/dinosaur.png");
			System.out.println("Your character is now a dinosaur");
		}
		if(e.getSource() == exit) {
			w.changePanel("1");
		}
	}

	
	
}
