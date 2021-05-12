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
	private static ArrayList<Integer> yValues = new ArrayList<Integer>(Arrays.asList(150, 300));
	
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
		
	}
	
//	public Item(int minX, int maxX, int w, int h, PImage img) {
//		super(img, getRandomX(minX, maxX), getRandomY(), w, h);
//		speed = -7;
//		
//	}
//	
//	public Item(PImage img, int x, int w, int h) {
//		super(img, x, getRandomY(), w, h);
//		speed = -7;
//	}
	
	public void act() {
		
		double xCoord = x+speed;
		moveToLocation(xCoord, y);
		
	}
	
	public void spawnNewItem(int x) {
		
		moveToLocation(x, getRandomY());
		
	}
	
	public void spawnNewItem(int minX, int maxX) {
		
		moveToLocation(getRandomX(minX, maxX), getRandomY());
		
	}
	
	public static int getRandomY() {
		
		int n = (int) (Math.random() * yValues.size());
		return yValues.get(n);
		
	}
	
	public static int getRandomX(int minX, int maxX) {
		
		int n = (int) (Math.random() * (maxX-minX));
		return minX + n;
		
	}
	
	
	

}
