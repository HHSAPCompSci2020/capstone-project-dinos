/**
 * DrawingSurface class where all of the objects are instantiated and methods are called
 * @author Clarence Choy
 */
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import movingObjects.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	/**
	 * DRAWING_WIDTH is the width of the drawing window
	 * DRAWING_HEIGHT is the height of the drawing window
	 */
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Player player;
	private Scoreboard sb;

	private ArrayList<Integer> keys;
	private ArrayList<Shape> platforms;
	private ArrayList<Item> items;
	
	private int count;
	
	/**
	 * Constructor for DrawingSurface class
	 */
	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		platforms = new ArrayList<Shape>();
		platforms.add(new Rectangle(0, 400, 800, 200));
		items = new ArrayList<Item>();
		sb = new Scoreboard();
		
		addItems(items);
		player = new Player(loadImage("media/doctor.png"), 100, 200, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
		count = 0;
	}
	
	/**
	 * Draw method that is responsible for all of the changes on screen
	 */
	public void draw() {
		background(0, 255, 255);
		
		pushMatrix();

		int width = getWidth();
		int height = getHeight();

		float ratioX = (float)width/DRAWING_WIDTH;
		float ratioY = (float)height/DRAWING_HEIGHT;

		scale(ratioX, ratioY);
		
		
		// DRAWING PLATFORM
		fill(100);
		for (Shape s : platforms) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				rect(r.x,r.y,r.width,r.height);
			}
		}
		
		// OBJECT OUTLINES
		fill(255);
		for(Item i : items) {
			rect((float)i.x, (float)i.y, Mask.MASK_WIDTH, Mask.MASK_HEIGHT);
		}
		rect((float)player.x, (float)player.y, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
		
		
		// DRAWING OBJECTS
		player.draw(this);
		for(Item i : items)
			i.draw(this);
		
		
		// DISPLAYING SCORE
		textSize(24);
		fill(0, 0, 0);
		text(sb.getScore(), 650, 30);
		
		popMatrix();
		
		// PLAYER & ITEM MOVEMENT
		if (isPressed(KeyEvent.VK_UP)) {
			player.jump();
		}
		
		player.act(platforms);
		for(Item i : items) {
			i.act(count);
		}
		
		
		// COLLISION DETECTION
		for(Item i : items) {
			if(i.intersects(player)) {
				
				if(i instanceof Mask) {
					sb.add(sb.MASK_WORTH);
					i.spawnNewItem(1000);
					
				} else if(i instanceof Vaccine) {
					player.setState(2);
					i.spawnNewItem(5000, 10000);
					
				} else if(i instanceof Covid) {
					player.setState(0);
					System.out.println("Player is dead x_x");
					
				}
			}
			
			if(i.x+i.width < 0) {
				
				if(i instanceof Mask) {
					i.spawnNewItem(1000);
				} else if(i instanceof Vaccine) {
					
				} else if(i instanceof Covid) {
					i.spawnNewItem(Item.getRandomX(1000, 1500));
				}
			}
		}
		
		
		sb.act(count);
		
		count++;
	}
	
	/**
	 * Adds the many items to the game in the start
	 * @param i ArrayList of Items that the new items are added to
	 */
	public void addItems(ArrayList<Item> i) {
		
		i.add(new Mask(loadImage("media/mask.png"), 2000, Item.getRandomY(), Mask.MASK_WIDTH, Mask.MASK_HEIGHT));
		i.add(new Mask(loadImage("media/mask.png"), 2500, Item.getRandomY(), Mask.MASK_WIDTH, Mask.MASK_HEIGHT));
		i.add(new Covid(loadImage("media/covid.png"), Item.getRandomX(1500, 2500), 300, Covid.COVID_WIDTH, Covid.COVID_HEIGHT));
		
		
	}
	
	/**
	 * Adds the key code of the pressed key to the ArrayList of keys
	 */
	public void keyPressed() {
		keys.add(keyCode);
	}

	/**
	 * Removes the key code(s) of a key when it is no longer pressed
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	/**
	 * Checks if a certain key is pressed
	 * @param code key code of the key you want to check
	 * @return true if the key is pressed and false otherwise
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
}
