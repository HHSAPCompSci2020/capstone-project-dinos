import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import processing.core.PImage;

public class Player extends MovingImage{

	private double yVelo;
	private boolean onASurface;
	private double friction;
	private double gravity;
	private double jumpStrength;
	
	public Player(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		yVelo = 0;
		onASurface = false;
		gravity = 0.7;
		friction = .85;
		jumpStrength = 15;
	}
	
	public void jump() {
		if (onASurface)
			yVelo -= jumpStrength;
	}
	
	public void act() {
		
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();
		
		yVelo += gravity; // GRAVITY
		double yCoord2 = yCoord + yVelo;

		Rectangle2D.Double strechY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelo));

		onASurface = false;
		
		if (yVelo > 0) {
			Shape standingSurface = null;
			
			if (standingSurface != null) {
				Rectangle r = standingSurface.getBounds();
				yCoord2 = r.getY()-height;
			}
		} else if (yVelo < 0) {
			Shape headSurface = null;
			
			if (headSurface != null) {
				Rectangle r = headSurface.getBounds();
				yCoord2 = r.getY()+r.getHeight();
			}
		}

		if (Math.abs(yVelo) < .5)
			yVelo = 0;
		
		moveToLocation(xCoord, yCoord2);
	}

}
