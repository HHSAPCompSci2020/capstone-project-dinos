/**
 * Represents the scoreboard
 * @author 
 */

public class Scoreboard {
	
	private int score;
	
	/**
	 * Constructor for Scoreboard class
	 */
	public Scoreboard() {
		score = 0;
	}
	
	/**
	 * Increases/decreases the score by a certain amount
	 * @param amount number of points the score increases/decreases by
	 */
	public void add(int amount) {
		score += amount;
	}
}
