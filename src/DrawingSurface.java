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
	private int keyPressed;
	
	public DrawingSurface() {
		super();
		player = new Player(loadImage("stickFigure.png"), 100, 300, 50, 100);
	}
	
	public void draw() {
		background(0, 255, 255);
		
		pushMatrix();

		int width = getWidth();
		int height = getHeight();

		float ratioX = (float)width/DRAWING_WIDTH;
		float ratioY = (float)height/DRAWING_HEIGHT;

		scale(ratioX, ratioY);
		
		player.draw(this);
		
		popMatrix();
		
		if (keyPressed == KeyEvent.VK_UP) {
			System.out.println("up");
			player.jump();
		}
			
	}
}
