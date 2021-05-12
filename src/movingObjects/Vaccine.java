/**
 * Represents the vaccines and is a subclass of Item
 * @author 
 */
package movingObjects;

import processing.core.PImage;

public class Vaccine extends Item{

	public static final int VACCINE_WIDTH = 80;
	public static final int VACCINE_HEIGHT = 80;
	
	/**
	 * Constructor for Vaccine class
	 * @param img image file for what Vaccine looks like
	 * @param x top left x coordinate of Vaccine
	 * @param y top left y coordinate of Vaccine
	 * @param w width of Vaccine
	 * @param h height of Vaccine
	 */
	public Vaccine(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

}
