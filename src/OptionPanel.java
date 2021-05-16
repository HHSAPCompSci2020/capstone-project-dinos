import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	private JPanel p;
	private JButton startButton;
	
	public OptionPanel(Main w) {
		this.w = w;
		
		setBackground(Color.BLUE);
		
		//p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		//p.add(Box.createVerticalStrut(300));
		
		startButton = new JButton("Start the game!");
		startButton.setBounds(300, 275, 200, 30);
		startButton.addActionListener(this);
		w.add(startButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("2");
		w.remove(startButton);
	}
	
}