package movingObjects;

import processing.core.PImage;

public class Background extends Item {
	
	/**
	 * Constructor for Background class
	 * @param img image file for what Background looks like
	 * @param x top left x coordinate of Background
	 * @param y top left y coordinate of Background
	 * @param w width of Background
	 * @param h height of Background
	 */
	public Background(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h, -1, 0);
		// TODO Auto-generated constructor stub
	}
}
