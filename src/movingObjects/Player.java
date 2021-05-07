package movingObjects;
/**
 * Represents the user controlled character and is a subclass of MovingImage
 * @author 
 */

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
	
	/**
	 * Constructor for Player class
	 * @param img image file for what Player looks like
	 * @param x top left x coordinate of Player
	 * @param y top left y coordinate of Player
	 * @param w width of Player
	 * @param h height of Player
	 */
	public Player(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		yVelocity = 0;
		onASurface = false;
		gravity = 0.7;
		jumpStrength = 15;
	}
	
	/**
	 * Makes the Player jump up
	 */
	public void jump() {
		if (onASurface)
			yVelocity -= jumpStrength;
	}
	
	/**
	 * Method that is called repeatedly to make Player move/act
	 * @param platforms ArrayList of Shapes that are the platforms Player can jump on
	 */
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
