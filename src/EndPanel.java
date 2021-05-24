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

public class EndPanel extends JPanel implements ActionListener{

	private Main w;
	private JPanel p;
	private JButton exit;
	
	private String message;
	
	
	/**
	 * Constructor for CustomizePanel
	 * @param w Main object used in CustomizePanel
	 */
	public EndPanel(Main w) {
		this.w = w;
		p = new JPanel();
		setBackground(new Color(175, 175, 175));
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		
		exit = new JButton("Back to Menu");
		exit.addActionListener(this);
		
		message = "";
		
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

		g.setFont(new Font("SansSerif",Font.BOLD,28));
		g.setColor(Color.RED);
		g2.drawString("GAME OVER", 315, 300);
		
		message = "SCORE: " + w.getDrawingSurface().getScoreboard().getHighscore();
		int strWidth = g.getFontMetrics().stringWidth(message);
		g.drawString(message, 400-strWidth/2, 350);
		
		g2.setTransform(at);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			w.changePanel("1");
		}
	}

	
	
}
