/**
 * Represnts a moving image
 * @author Shelby
 */
package movingObjects;

import java.awt.geom.Rectangle2D;
import processing.core.PApplet;
import processing.core.PImage;

public class MovingImage extends Rectangle2D.Double {
	
	// FIELDS
	private PImage image;
	
	// CONSTRUCTORS
	/**
	 * Constructor for MovingImage
	 * @param img Image that MovingImage looks like
	 * @param x top left x coordinate of MovingImage
	 * @param y top left y coordinate of MovingImage
	 * @param w width of MovingImage
	 * @param h height of MovingImage
	 */
	public MovingImage(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	// METHODS	
	/**
	 * Moves to the location x, y
	 * @param x x coordinate MovingImage moves to
	 * @param y y coordinate MovingImage moves to
	 */
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	/**
	 * Moves by the amount x, y
	 * @param x amount MovingImage moves horizontally
	 * @param y amount MovingImage moves vertically
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Applies the limits of the window
	 * @param windowWidth width of the window
	 * @param windowHeight height of the window
	 */
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	/**
	 * Draws MovingImage
	 * @param g PApplet object used to draw MovingImage
	 */
	public void draw(PApplet g) {
		g.image(image,(int)x,(int)y,(int)width,(int)height);
	}
	
	
}










