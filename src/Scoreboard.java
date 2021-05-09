/**
 * Represents the scoreboard
 * @author
 */

public class Scoreboard {

	public static final int MASK = 20;
	
	private int score;
	private int multiplier;

	/**
	 * Constructor for Scoreboard class
	 */
	public Scoreboard() {
		score = 0;
		multiplier = 0;
	}

	/**
	 * Increases/decreases the score by a certain amount
	 * 
	 * @param amount number of points the score increases/decreases by
	 */
	public void add(int amount) {
//		int time = 1;
//		//check if player
//		while (p != isdead) {
//			score += amount;
//			multiplyer++;
//			if(multiplyer>100*(time*time)) {
//				amount*=1.2;
//				time++;
//			}
//
//		}

		score += amount;
		
	}
	
	public int getScore() {
		return score;
	}
}
