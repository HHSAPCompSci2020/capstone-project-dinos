/**
 * Represents the platforms that the player can run and jump on
 * @author Isaac Phoon
 */
package movingObjects;

import processing.core.PImage;

public class Platform extends Item {

	/**
	 * Constructor for Platform class
	 * @param img image file for what Platform looks like
	 * @param x top left x coordinate of Platform
	 * @param y top left y coordinate of Platform
	 * @param w width of Platform
	 * @param h height of Platform
	 */
	public Platform(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h, -5, 0);
	}
		

}
