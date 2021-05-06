/**
 * DrawingSurface class where all of the objects are instantiated and methods are called
 * @author 
 */
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Player player;
	
	private ArrayList<Integer> keys;
	private ArrayList<Shape> platforms;
	
	/**
	 * Constructor for DrawingSurface class
	 */
	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		platforms = new ArrayList<Shape>();
		platforms.add(new Rectangle(0, 400, 800, 200));
		player = new Player(loadImage("media/doctor.png"), 100, 200, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
		
	}
	
	/**
	 * Draw method that is responsible for all of the changes on screen
	 */
	public void draw() {
		background(0, 255, 255);
		
		pushMatrix();

		int width = getWidth();
		int height = getHeight();

		float ratioX = (float)width/DRAWING_WIDTH;
		float ratioY = (float)height/DRAWING_HEIGHT;

		scale(ratioX, ratioY);
		
		fill(100);
		for (Shape s : platforms) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				rect(r.x,r.y,r.width,r.height);
			}
		}
		
		player.draw(this);
		
		popMatrix();
		
		if (isPressed(KeyEvent.VK_UP)) {
			player.jump();
		}
		
		player.act(platforms);
			
	}
	
	/**
	 * Adds the key code of the pressed key to the ArrayList of keys
	 */
	public void keyPressed() {
		keys.add(keyCode);
	}

	/**
	 * Removes the key code(s) of a key when it is no longer pressed
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	/**
	 * Checks if a certain key is pressed
	 * @param code key code of the key you want to check
	 * @return true if the key is pressed and false otherwise
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
}
