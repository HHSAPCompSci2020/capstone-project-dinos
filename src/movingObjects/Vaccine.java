/**
 * Represents the vaccines and is a subclass of Item
 * @author 
 */
package movingObjects;

import processing.core.PImage;

public class Vaccine extends Item{

	/**
	 * VACCINE_WIDTH is the width of the vaccine on the screen
	 * VACCINE_HEIGHT is the height of the vaccine on the screen
	 */
	public static final int VACCINE_WIDTH = 60;
	public static final int VACCINE_HEIGHT = 60;
	
	/**
	 * Constructor for Vaccine class
	 * @param img image file for what Vaccine looks like
	 * @param x top left x coordinate of Vaccine
	 * @param y top left y coordinate of Vaccine
	 * @param w width of Vaccine
	 * @param h height of Vaccine
	 */
	public Vaccine(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h, -7, 0);
		// TODO Auto-generated constructor stub
	}

}
