import javax.swing.*;

public class Main extends JFrame{

	public Main(String title) {
		setTitle(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		Main main = new Main("CovidRun");
		System.out.println("This is our Capstone Project");
	}

}
