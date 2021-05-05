import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;

import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Player player;
	
	private ArrayList<Integer> keys;
	private ArrayList<Shape> platforms;
	
	public DrawingSurface() {
		super();
		keys = new ArrayList<Integer>();
		platforms = new ArrayList<Shape>();
		platforms.add(new Rectangle(0, 400, 800, 200));
		player = new Player(loadImage("doctor.png"), 100, 200, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
		
	}
	
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
	
	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
}
