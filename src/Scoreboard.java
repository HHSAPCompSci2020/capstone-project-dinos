/**
 * Represents the scoreboard
 * @author Yukai Qiu
 */

public class Scoreboard {

	/**
	 * MASK_WORTH is the point value of a mask
	 */
	public final int MASK_WORTH = 30;

	private int score;
	private int multiplier;

	/**
	 * Constructor for Scoreboard class
	 */
	public Scoreboard() {
		score = 0;
		multiplier = 1;
	}

	/**
	 * Increases/decreases the score by a certain amount
	 * @param amount number of points the score increases/decreases by
	 */
	public void add(int amount) {
		score +=  amount;

	}

	/**
	 * Increases the score by a gradually increasing
	 * @param count variable that keeps track of how many times draw method is called, similar to a time variable
	 */
	public void act(int count) {

		if (count % 10 == 0) {
			multiplier += 0.2;
			score += multiplier;
					
		} 
	}

	/**
	 * Gets the score in a string format
	 * @return score as a string
	 */
	public String getScore() {
		String dscore = String.valueOf(score);
		String display = "";
		for (int i = 0; i < 10 - dscore.length(); i++) {
			display += "0";
		}
		display += dscore;
		return display;

	}
}
