/**
 * Represents the scoreboard
 * @author Yukai Qiu
 */

public class Scoreboard {

	/**
	 * MASK_WORTH is the point value of a mask
	 */
	public final int MASK_WORTH = 30;
	
	private static int highscore = 0;
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
	 * Sets the score
	 * @param s score you want to set to
	 */
	public void setScore(int s) {
		score = s;
		
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
	 * Gets the score
	 * @return score
	 */
	public int getScore() {
		return score;
		
	}
	
	/**
	 * Gets the score in a string format
	 * @return score as a string
	 */
	public String toString() {
		String dscore = String.valueOf(score);
		String hscore = String.valueOf(highscore);
		String display = "HI ";
		for (int i = 0; i < 5 - hscore.length(); i++) {
			display += "0";
		}
		display += hscore;
		display += "     ";
		for (int i = 0; i < 5 - dscore.length(); i++) {
			display += "0";
		}
		display += dscore;
		return display;

	}
	
	public void setHighscore(int score) {
		highscore = score;
		
	}
	
	public int getHighscore() {
		return highscore;
		
	}
}
