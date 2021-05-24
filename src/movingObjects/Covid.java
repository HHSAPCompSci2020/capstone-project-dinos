/**
 * Represents the covid particles and is a subclass of Item
 * @author Isaac Phoon
 */
package movingObjects;

import processing.core.PImage;

public class Covid extends Item{
	
	/**
	 * COVID_WIDTH is the width of the covid particle on the screen
	 * COVID_HEIGHT is the height of the covid particle on the screen
	 */
	public static final int COVID_WIDTH = 60;
	public static final int COVID_HEIGHT = 60;

	/**
	 * Constructor for Covid class
	 * @param img image file for what Covid looks like
	 * @param x top left x coordinate of Covid
	 * @param y top left y coordinate of Covid
	 * @param w width of Covid
	 * @param h height of Covid
	 */
	public Covid(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h, -7, 0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Checks if Covid is too close to another Covid
	 * @param check other instance of Covid
	 * @return true if the two Covid objects are too close and false otherwise
	 */
	public boolean isTooClose(Covid check) {
		
		if(this.intersects(check))
			return true;
		
		if(Math.abs(x-check.x) <= 600)
			return true;
		
		return false;
	}

}
