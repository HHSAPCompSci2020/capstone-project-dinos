import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PImage;

public class Player extends MovingImage{

	public static final int PLAYER_WIDTH = 70;
	public static final int PLAYER_HEIGHT = 100;
	
	private double yVelocity;
	private boolean onASurface;
	private double gravity;
	private double jumpStrength;
	
	public Player(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		yVelocity = 0;
		onASurface = false;
		gravity = 0.7;
		jumpStrength = 15;
	}
	
	public void jump() {
		if (onASurface)
			yVelocity -= jumpStrength;
	}
	
	public void act(ArrayList<Shape> platforms) {
		
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();
		
		yVelocity += gravity; // GRAVITY
		double yCoord2 = yCoord + yVelocity;

		Rectangle2D.Double stretchY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelocity));

		onASurface = false;
		
		if (yVelocity > 0) {
			Shape standingSurface = null;
			for (Shape s : platforms) {
				if (s.intersects(stretchY)) {
					onASurface = true;
					standingSurface = s;
					yVelocity = 0;
				}
			}
			if (standingSurface != null) {
				Rectangle r = standingSurface.getBounds();
				yCoord2 = r.getY()-height;
			}
			
		} else if (yVelocity < 0) {
			Shape headSurface = null;
			for (Shape s : platforms) {
				if (s.intersects(stretchY)) {
					headSurface = s;
					yVelocity = 0;
				}
			}
			if (headSurface != null) {
				Rectangle r = headSurface.getBounds();
				yCoord2 = r.getY()+r.getHeight();
			}
		}

		if (Math.abs(yVelocity) < .5)
			yVelocity = 0;
		
		moveToLocation(xCoord, yCoord2);
	}

}
