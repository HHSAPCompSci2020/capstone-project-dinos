/**
 * Represents an item in the game. Superclass of Mask, Vaccine, and Covid and a subclass of MovingImage
 * @author 
 */
package movingObjects;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PImage;

public class Item extends MovingImage{
	
	private double speed;
	private ArrayList<Integer> yValues;

	/**
	 * Constructor for Item Class
	 * @param img image file for what Item looks like
	 * @param x top left x coordinate of Item
	 * @param y top left y coordinate of Item
	 * @param w width of Item
	 * @param h height of Item
	 */
	public Item(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		speed = -7;
		yValues = new ArrayList<Integer>(Arrays.asList(150, 200));
		
	}
	
	public void act() {
		double xCoord = x+speed;
		moveToLocation(xCoord, y);
	}
	
	public void spawnNewItem() {
		int n = (int) (Math.random() * yValues.size());
		moveToLocation(1000, yValues.get(n));
		
	}
	
	

}
