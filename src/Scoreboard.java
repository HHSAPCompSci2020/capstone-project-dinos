/**
 * Represents the scoreboard
 * 
 * @author Yukai Qiu
 */

public class Scoreboard {

	public static final int MASK = 20;

	private int score;
	private int count;
	private int onePoint;
	// private double multiplier;

	/**
	 * Constructor for Scoreboard class
	 */
	public Scoreboard() {
		score = 0;
		count = 0;
		onePoint = 10;
		// multiplier = 0;
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

		score +=  amount;

	}

	public void act() {

		if (count % onePoint == 0) {
			score++;
		}

		count++;
	}

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
