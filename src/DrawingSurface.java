
/**
 * DrawingSurface class where all of the objects are instantiated and methods are called
 * @author Clarence Choy
 */

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import movingObjects.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	/**
	 * DRAWING_WIDTH is the width of the drawing window DRAWING_HEIGHT is the height
	 * of the drawing window
	 */
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Main main;
	private Player player;
	private String playerImage;
	private Scoreboard sb;
	private ArrayList<Integer> keys;
	private ArrayList<Platform> platforms;
	private ArrayList<Item> items;
	private ArrayList<Covid> covid;
	private EasySound jumpSound;
	private EasySound deathSound;
	private EasySound maskSound;
	private EasySound vaccineSound;
	private Item test;

	private int count;
	private float weather;
	private boolean cycle;
//	private float sunX;
//	private float sunY;
//	private float time;

	/**
	 * Constructor for DrawingSurface class
	 * 
	 * @param w Main class
	 */
	public DrawingSurface(Main w) {
		main = w;
		keys = new ArrayList<Integer>();
		platforms = new ArrayList<Platform>();
		items = new ArrayList<Item>();
		covid = new ArrayList<Covid>();
		sb = new Scoreboard();
		count = 0;
		jumpSound = new EasySound(new File("").getAbsolutePath() + "\\media\\jumpSound.wav");
		deathSound = new EasySound(new File("").getAbsolutePath() + "\\media\\deathSound.wav");
		maskSound = new EasySound(new File("").getAbsolutePath() + "\\media\\maskSound.wav");
		vaccineSound = new EasySound(new File("").getAbsolutePath() + "\\media\\vaccineSound.wav");

		test = new Item(loadImage("media/mask.png"), 0, 0, 0, 0, 0, 0);
		playerImage = "media/doctor.png";
		addGameElements(items, covid, platforms);
		
		weather = 0;
		cycle = true;
//		sunX = 0;
//		sunY = 0;
//		time = 0;
	}

	/**
	 * Draw method that is responsible for all of the changes on screen
	 */
	public void draw() {
		background(52, 180f - weather, 235f - weather);
		
		pushMatrix();
		int width = getWidth();
		int height = getHeight();

		float ratioX = (float) width / DRAWING_WIDTH;
		float ratioY = (float) height / DRAWING_HEIGHT;

		scale(ratioX, ratioY);
		
		drawOutlines();

		// DRAWING OBJECTS
		player.draw(this);
		for (Item i : items)
			i.draw(this);
		for (Covid c : covid)
			c.draw(this);
		for (Platform p : platforms)
			p.draw(this);

		// DISPLAYING SCORE
		textSize(24);
		fill(0, 0, 0);
		text(sb.toString(), 570, 30);


		if (player.getState() != 0 && player.getState() != 3) {

			// BACKGROUND
			if (cycle == true) {
				weather += 0.1;
			}
			if (weather >= 130) {
				cycle = false;
			}
			if (cycle == false) {
				weather -= 0.1;
			}
			if (weather <= 0) {
				cycle = true;
			}
			
			// SUN
//			time += 0.3;
//			sunX = 400f - (float) (350 * Math.cos(Math.PI * time / 130.0 + (Math.PI / 3)));
//			sunY = 400f - (float) (325 * Math.sin(Math.PI * time / 130.0 + (Math.PI / 3)));
//			fill(252, 223, 3);
//			ellipse(sunX, sunY, 50f, 50f);
			
			// PLAYER & ITEM MOVEMENT
			if (isPressed(KeyEvent.VK_UP)) {
				if (player.jump()) {
					jumpSound.play();
				}

			} else if (isPressed(KeyEvent.VK_DOWN)) {
				player.duck();
				if (player.height == Player.PLAYER_HEIGHT)
					player = new Player(loadImage(playerImage), (int) player.x,
							(int) player.y + Player.PLAYER_HEIGHT / 2, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT / 2,
							player.getState(), player.getVaccineStart());
			} else {
				if (player.height != Player.PLAYER_HEIGHT)
					player = new Player(loadImage(playerImage), (int) player.x,
							(int) player.y - Player.PLAYER_HEIGHT / 2, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT,
							player.getState(), player.getVaccineStart());

			}

			player.act(platforms);
			for (Item i : items)
				i.act(count);
			for (Item c : covid)
				c.act(count);
			for (Platform p : platforms)
				p.act(count);

			// COLLISION DETECTION
			for (Item i : items) {
				if (i.intersects(player)) {

					if (i instanceof Mask) {
						maskSound.play();
						sb.add(sb.MASK_WORTH);
						i.spawnNewItem(1500, 2500);
						for (Item j : items) {
							if (!i.equals(j)) {
								while (i.isOverlapping(j))
									i.spawnNewItem(1500, 2500);
							}
						}

					} else if (i instanceof Vaccine) {
						vaccineSound.play();
						player.setState(2);
						i.spawnNewItem(10000, 20000);
						for (Item j : items) {
							if (!i.equals(j)) {
								while (i.isOverlapping(j))
									i.spawnNewItem(10000, 20000);
							}
						}
					}
				}

				if (i.x + i.width < 0) {

					if (i instanceof Mask) {
						i.spawnNewItem(1500, 2500);
						for (Item j : items) {
							if (!i.equals(j)) {
								while (i.isOverlapping(j))
									i.spawnNewItem(1500, 2500);
							}
						}

					} else if (i instanceof Vaccine) {
						i.spawnNewItem(10000, 20000);
						for (Item j : items) {
							if (!i.equals(j)) {
								while (i.isOverlapping(j))
									i.spawnNewItem(10000, 20000);
							}
						}
					}
				}
			}

			for (Covid c : covid) {

				if (c.intersects(player)) {
					if (player.getState() != 2 && player.getState() != -1) {
						deathSound.play();
						player.setState(0);
					}
				}

				if (c.x + c.width < 0) {
					c.spawnNewItem(1200, 1400);
					for (Covid j : covid) {
						if (!c.equals(j)) {
							while (c.isTooClose(j)) {
								c.spawnNewItem(1200, 1400);
							}
						}
					}
				}
			}

			for (Platform p : platforms) {
				if (p.x + p.width < 0) {
					p.moveToLocation(970, 400);

				}
			}
			
			// VACCINE AND TIMER
			if (player.getState() == 2 || player.getState() == -1) {
				textSize(24);
				fill(0, 255, 0);
				text("Immunity: " + player.getCountdown(), 10, 30);
			}

			sb.act(count);
			count++;
		}

		// GAME OVER TEXT
		if (player.getState() == 0) {
			deathSequence();
			resetGame();
		}
		
		popMatrix();
	}
	
	/**
	 * Creates a new Player with the image of the file playerImage
	 * 
	 * @param playerImage file of the image you want the player to change to
	 */
	public void changePlayer(String playerImage) {
		this.playerImage = playerImage;
		player = new Player(loadImage(playerImage), (int) player.x, (int) player.y, (int) player.width,
				(int) player.height, 3, System.currentTimeMillis());
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
		while (keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	/**
	 * Checks if a certain key is pressed
	 * 
	 * @param code key code of the key you want to check
	 * @return true if the key is pressed and false otherwise
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

	/**
	 * Begins the game
	 */
	public void startGame() {
		player = new Player(loadImage(playerImage), 100, 200, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT, 3,
				System.currentTimeMillis());
		player.setState(1);
	}
	
	/**
	 * Gets the Scoreboard object being used in DrawingSurface
	 * @return Scoreboard object
	 */
	public Scoreboard getScoreboard() {
		return sb;
		
	}
	
	private void resetGame() {
		if(sb.getScore() > sb.getHighscore())
			sb.setHighscore(sb.getScore());
		sb.setScore(0);
		items.clear();
		covid.clear();
		platforms.clear();
		count = 0;
		weather = 0;
		cycle = true;
		addGameElements(items, covid, platforms);
	}

	private void addGameElements(ArrayList<Item> i, ArrayList<Covid> c, ArrayList<Platform> p) {

		player = new Player(loadImage(playerImage), 100, 200, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT, 3,
				System.currentTimeMillis());

		i.add(new Mask(loadImage("media/mask.png"), test.getRandomX(2000, 3000), test.getRandomY(false),
				Mask.MASK_WIDTH, Mask.MASK_HEIGHT));
		i.add(new Vaccine(loadImage("media/vaccine.png"), test.getRandomX(5000, 10000), test.getRandomY(false),
				Vaccine.VACCINE_WIDTH, Vaccine.VACCINE_HEIGHT));

		c.add(new Covid(loadImage("media/covid.png"), 2000, test.getRandomY(true), Covid.COVID_WIDTH,
				Covid.COVID_HEIGHT));
		c.add(new Covid(loadImage("media/covid.png"), 2600, test.getRandomY(true), Covid.COVID_WIDTH,
				Covid.COVID_HEIGHT));

		p.add(new Platform(loadImage("media/dirtPlatform.png"), 0, 400, 1000, 200));
		p.add(new Platform(loadImage("media/dirtPlatform.png"), 990, 400, 1000, 200));
	}
	
	private void deathSequence() {	
		
		int num = 0;
		while(num < 10000) {
			textSize(24);
			fill(210, 25, 55);
			int strWidth = this.getFontMetrics(getFont()).stringWidth("GAME OVER   ");
			text("GAME OVER   ", 400 - strWidth / 2, 200);
			num++;
		}
		
		main.changePanel("4");
		
	}

	private void drawOutlines() {
		
		fill(255);
		for (Item i : items) {
			rect((float) i.x, (float) i.y, (float) i.width, (float) i.height);
		}
		for (Covid c : covid) {
			rect((float) c.x, (float) c.y, (float) c.width, (float) c.height);
		}
		rect((float) player.x, (float) player.y, (float) player.width, (float) player.height);
		
	}

}
