/**
 * Represents the user controlled character and is a subclass of MovingImage
 * @author Clarence Choy
 */
package movingObjects;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PImage;

public class Player extends MovingImage {

	/**
	 * PLAYER_WIDTH is the width of the player on the screen PLAYER_HEIGHT is the
	 * height of the player on the screen
	 */
	public static final int PLAYER_WIDTH = 60;
	public static final int PLAYER_HEIGHT = 100;

	private double yVelocity;
	private boolean onASurface;
	private double gravity;
	private double jumpStrength;
	private int state; // 0 = Dead 1 = Alive -1 or 2 = Invincible 3 = Game Has Not Started
	private int countdown;
	private long start;

	/**
	 * Constructor for Player class
	 * 
	 * @param img image file for what Player looks like
	 * @param x   top left x coordinate of Player
	 * @param y   top left y coordinate of Player
	 * @param w   width of Player
	 * @param h   height of Player
	 */
	public Player(PImage img, int x, int y, int w, int h, int state, long time) {
		super(img, x, y, w, h);
		yVelocity = 0;
		onASurface = false;
		gravity = 0.9;
		jumpStrength = 20;
		this.state = state;
		start = time;
		countdown = 5;
	}

	/**
	 * Makes the Player jump up
	 * @return if the player actually jumped or not
	 */
	public boolean jump() {
		if (onASurface) {
			yVelocity -= jumpStrength;
			return true;
		}
		return false;

	}

	/**
	 * Makes the Player duck
	 */
	public void duck() {
		if (!onASurface)
			yVelocity += 10;

	}

	/**
	 * Method that is called repeatedly to make Player move/act
	 * @param platforms ArrayList of Shapes that are the platforms Player can jump on
	 */
	public void act(ArrayList<Platform> platforms) {

		// INVINICIBILITY
		if (state == 2) {
			start = System.currentTimeMillis();
			state = -1;
		}

		if (state == -1 && countdown <= (int) (System.currentTimeMillis() - start) / 1000) {
			state = 1;
			start = 0;
		}

		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();

		yVelocity += gravity; // GRAVITY
		double yCoord2 = yCoord + yVelocity;

		Rectangle2D.Double stretchY = new Rectangle2D.Double(xCoord, Math.min(yCoord, yCoord2), width,
				height + Math.abs(yVelocity));

		onASurface = false;

		if (yVelocity > 0) {

			Shape standingSurface = null;
			for (Platform s : platforms) {
				if (s.intersects(stretchY)) {
					onASurface = true;
					standingSurface = s;
					yVelocity = 0;
				}
			}
			if (standingSurface != null) {
				Rectangle r = standingSurface.getBounds();
				yCoord2 = r.getY() - height;
			}

		} else if (yVelocity < 0) {
			Shape headSurface = null;
			for (Shape s : platforms) {
				if (s.intersects(stretchY)) {
					headSurface = s;
					yVelocity = 0;
				}
			}
			if (headSurface != null) {
				Rectangle r = headSurface.getBounds();
				yCoord2 = r.getY() + r.getHeight();
			}
		}

		if (Math.abs(yVelocity) < .5)
			yVelocity = 0;

		moveToLocation(xCoord, yCoord2);
	}

	/**
	 * Sets the state of the player
	 * @param state state you want the player to be set to
	 */
	public void setState(int state) {
		this.state = state;

	}

	/**
	 * Gets the state of the player
	 * @return state of the player
	 */
	public int getState() {
		return state;

	}

	/**
	 * Determines if the player is on a surface or not
	 * @return true if the player is on a surface and false if not
	 */
	public boolean getOnASurface() {
		return onASurface;
	}

	/**
	 * Gets the number of seconds left of the player's invincibility
	 * @return number of seconds left that the invincibility lasts
	 */
	public int getCountdown() {
		return countdown - (int) (System.currentTimeMillis() - start) / 1000;
		
	}
	
	/**
	 * Gets the time in milliseconds that the vaccine item was acquired
	 * @return time in milliseconds that the vaccine item was acquired
	 */
	public long getVaccineStart() {
		return start;
		
	}

}
