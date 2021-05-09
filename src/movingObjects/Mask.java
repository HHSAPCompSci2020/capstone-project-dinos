/**
 * Represents the masks and is a subclass of Item
 * @author 
 */
package movingObjects;

import processing.core.PImage;

public class Mask extends Item{

	public static final int MASK_WIDTH = 80;
	public static final int MASK_HEIGHT = 80;
	
	/**
	 * Constructor for Mask class
	 * @param img image file for what Mask looks like
	 * @param x top left x coordinate of Mask
	 * @param y top left y coordinate of Mask
	 * @param w width of Mask
	 * @param h height of Mask
	 */
	public Mask(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

}
