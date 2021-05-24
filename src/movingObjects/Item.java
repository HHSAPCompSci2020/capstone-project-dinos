/**
 * Represents an item in the game. Superclass of Mask, Vaccine, and Covid and a subclass of MovingImage
 * @author Clarence Choy
 */
package movingObjects;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PImage;

public class Item extends MovingImage{
	
	private double speed;
	private double multiplier;
	
	private static ArrayList<Integer> yValues = new ArrayList<Integer>(Arrays.asList(140, 260, 320));
	private static ArrayList<Integer> covidYValues = new ArrayList<Integer>(Arrays.asList(140, 260, 320, 320, 320, 320));
	
	/**
	 * Constructor for Item Class
	 * @param img image file for what Item looks like
	 * @param x top left x coordinate of Item
	 * @param y top left y coordinate of Item
	 * @param w width of Item
	 * @param h height of Item
	 * @param speed the speed of the Item traveling
	 * @param multiplier the multiplier of the points
	 */
	public Item(PImage img, int x, int y, int w, int h, double speed, double multiplier) {
		super(img, x, y, w, h);
		this.speed = speed;
		this.multiplier = multiplier;
		
	}
	
	/**
	 * Moves the item and increase the speed
	 * @param count variable that keeps track of how many times draw method is called, similar to a time variable
	 */
	public void act(int count) {
		
		double xCoord = x+speed;
		moveToLocation(xCoord, y);
		
		if (count % 10 == 0) {
			multiplier += 0.00001;
			speed -= multiplier;
					
		} 
	}
	
	/**
	 * Spawns a new item at a certain x location and a random y
	 * @param x x coordinate of the new location
	 */
	public void spawnNewItem(int x) {
		
		if(this instanceof Covid)
			moveToLocation(x, getRandomY(true));
		
		moveToLocation(x, getRandomY(false));
		
	}
	
	/**
	 * Spawns a new item at a random x and a random y
	 * @param minX minimum x value the item can spawn at
	 * @param maxX maximum x value the item can spawn at
	 */
	public void spawnNewItem(int minX, int maxX) {
		
		if(this instanceof Covid)
			moveToLocation(getRandomX(minX, maxX), getRandomY(true));
		
		moveToLocation(getRandomX(minX, maxX), getRandomY(false));
	}
	
	/**
	 * Chooses a random y value from an array list of set y values
	 * @param isCovid covid class or not
	 * @return random y coordinate value
	 */
	public int getRandomY(boolean isCovid) {
		
		if(isCovid) {
			int n = (int) (Math.random() * covidYValues.size());
			return covidYValues.get(n);
		} else {
			int n = (int) (Math.random() * yValues.size());
			return yValues.get(n);
		}
		
	}
	
	/**
	 * Chooses a random x value from a minimum and maximum
	 * @param minX minimum x value
	 * @param maxX maximum x value
	 * @return random integer between the minimum and the maximum inclusive
	 */
	public int getRandomX(int minX, int maxX) {
		
		int n = (int) (Math.random() * (maxX-minX+1));
		return minX + n;
		
	}
	/**
	 * Checks if this Item is overlapping with another
	 * @param check the Item that it is checking for overlap with
	 * @return if the items are overlapping
	 */
	public boolean isOverlapping(Item check) {
		
		if(this.intersects(check))
			return true;
 
		return false;
		
	}
	
	

}
