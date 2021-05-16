/**
 * Represents the covid particles and is a subclass of Item
 * @author 
 */
package movingObjects;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PImage;

public class Covid extends Item{
	
	/**
	 * COVID_WIDTH is the width of the covid particle on the screen
	 * COVID_HEIGHT is the height of the covid particle on the screen
	 */
	public static final int COVID_WIDTH = 60;
	public static final int COVID_HEIGHT = 60;
	
	private static ArrayList<Integer> yValues = new ArrayList<Integer>(Arrays.asList(140, 260, 320, 320, 320, 320));

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
	 * Spawns a new item at a certain x location and a random y only for Covid
	 * @param x x coordinate of the new location
	 */
	public void spawnNewItem(int x) {
		
		moveToLocation(x, getRandomY());
		
	}
	
	/**
	 * Spawns a new item at a random x and a random y only for Covid
	 * @param minX minimum x value the item can spawn at
	 * @param maxX maximum x value the item can spawn at
	 */
	public void spawnNewItem(int minX, int maxX) {
		
		moveToLocation(getRandomX(minX, maxX), getRandomY());
		
	}
	
	/**
	 * Chooses a random y value from an array list of set y values only for Covid
	 * @return random y coordinate value
	 */
	public static int getRandomY() {
		
		int n = (int) (Math.random() * yValues.size());
		return yValues.get(n);
		
	}

}
