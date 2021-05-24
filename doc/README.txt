Covid Run (Dinosaur Run)
Authors: Clarence Choy, Yukai Qiu, Isaac Phoon
Revision: 5/23/2021


Introduction: 
It is the year 2021 and a deadly virus named Covid-19 has taken the world by surprise. In just a few weeks, the virus has spread all over the world and there seems to be no sign of it stopping. Infection rates have skyrocketed globally and without a vaccine in sight, it seemed hopeless. Miraculously, you and your group of doctors have announced that a vaccine for the virus has been created and is gradually being released to the public. However, not everyone is able to travel to a vaccination center (especially the elderly) so you must gather masks and vaccines so you can then deliver them to people in need.


In this java-based game, the user controls a doctor that can perform two actions, jumping and ducking. Your character runs while different items such as masks, vaccines, and Covid-19 particles spawn in. The goal of the game is to survive while avoiding the Covid-19 particles and collecting masks and vaccines to gain a higher score. To add to the difficulty, the speed that the character runs increases making it harder to avoid obstacles. We decided to write this game because it is relevant to our current situation and is also a fun game for students to play. The rules of the game are simple:


1. Avoid Covid-19 particles so you don’t get infected
2. Pick up masks and other items to boost your score
3. Don’t stop running


Our program is mainly for anyone interested in having a fun time playing a game so it is suited for all ages. The main features of our program are our randomized obstacle spawning and simple yet enjoyable game.


Instructions:
Once you run the program, a window will appear with the GUI of the game. On this window, you will see options to start the game, customize your character, or go to settings. Click the start button to begin the game. Your character will spawn in and start running at a slow pace but gradually run faster. While running, your character can either jump up or duck. To jump, press the up arrow key. To duck down, press the down arrow key. As you run, items will appear on the right side of the screen and come closer to the character (as you run forwards). There are three different items in the game: 
* Masks which give the user 30 points
* Covid particles which will kill the player
* Vaccines which give the user 5 seconds of immunity to Covid
Run as far as you can to achieve the highest score.


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
* A user controlled character
   * Jumps when the up arrow key is pressed and ducks when the down arrow key is pressed. The character can stand on platforms and has some physics applied to it to make the jumping look somewhat real
   * The character will not actually move, the background and obstacles will move to make it appear that the character is running
* Character-Mask interaction
   * Masks will randomly spawn in the window from the right side of the screen at set heights above the ground. When the character touches the mask, the user’s score will increase and the mask will disappear
* Character-Covid interaction
   * Covid particles will also spawn in from the right side of the screen at set heights above the ground. If the character touches the Covid, the player will “die” and the game over screen will appear
* Scoreboard in the top right corner
   * A small box in the top right of the window that displays a number which will be your score. Your score can increase from collecting masks and also from surviving for longer.
   * The score will originally increase at a rate of 10 points a second but the rate at which points are earned will increase. We have not yet determined this rate
* A vaccine item with character interaction
   * Vaccines will randomly spawn and if the user touches it they will be immune to the Covid particles for 5 seconds. Indication of immunity will be shown by a change in color of the character


Want-to-have Features:
* Building background
   * There are buildings in the background to resemble a city-like environment where Covid-19 is easily spreadable. The buildings will be moving slightly to the left to make the game seem more 3D
* Animations 
   * Use gifs as running animations for the character and a dying animation for when the character runs into a Covid particle
* The ability to change the skin or outfit of the player
   * Before the game starts, there will be a customize button that you can click on to change what your character looks like. This button will go to a new window with different outfits that the user can wear. Once the user selects their desired character they can go back and start the game
* More complex terrains
   * Add platforms instead of just one flat ground that the user can run on. The character can jump onto these platforms and items can also spawn at these heights
* A game over screen
   * Once the character touches a Covid particle and dies the screen will switch to a game over screen which says “Game Over” and also the score that the user has achieved.


Stretch Features:
* Have the game in 3D graphics where the same game rules apply
   * Have the camera in 3rd person view facing the way the character is running
* Sound packs and sound effects
   * Add sounds for jumping, interactions with masks and vaccines, and a sound when the character dies
* Allow the user to change the difficulty of the game
   * The user can set the starting speed, speed multiplier, and the amount of Covid that spawns in during the game
* Different HUD and GUI.
* The user can change resolution, graphics, and even controls.




Class List:
Main - Starts the game
OptionPanel - Main menu of the game
CustomizePanel - Customization window where the user can choose their character
EndPanel - The screen that shows when the player dies, displays score and button to exit to menu
SettingsPanel - Settings window where the user can change some visual settings
DrawingSurface - Draws the game and contains the bulk of the game mechanics
EasySound - Represents a sound file that can be played
MovingImage - Superclass of Player and Item, allows for basic physics and movement of objects
Player - Represents the character that the user will be able to control
Item - Superclass of Mask, Covid, and Vaccine, represents an item
Mask - Represents the mask item, subclass of Item
Covid - Represents the Covid particles, subclass of Item
Vaccine - Represents the vaccine item, subclass of Item
Scoreboard - Keeps track of the score and highscore
Platform - Represents the platform that the user can jump on, subclass of Item
Background - Represents any background images or objects that are only there for visual effects


Credits:
Everyone - UML Diagram, README, Main.java
Clarence - DrawingSurface.java, Player.java, Item.java, CustomizePanel.java, EndPanel.java, SettingsPanel.java, Background.java
Isaac - Mask.java, Vaccine.java, Platform.java, Covid.java
Yukai - Scoreboard.java, EasySound.java, title.png, OptionPanel.java


OptionPanel inspiration, changePanel() method - Mr. Shelby
MovingImage.java - Mr. Shelby’s Demo
processing.jar/library - https://processing.org/ 


dirtPlatform.png - https://www.google.com/url?sa=i&url=http%3A%2F%2Fclipart-library.com%2Fbrown-ground-cliparts.html&psig=AOvVaw3ktVclwhPXwUMjh5lbxHKJ&ust=1621210704503000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMiMw9P2zPACFQAAAAAdAAAAABAD 


brickPlatform.png - 
https://www.google.com/url?sa=i&url=http%3A%2F%2Fpixelartmaker.com%2Fart%2Fba13ef283adf1be&psig=AOvVaw3IuGs7sIfLao1X_t_q-85d&ust=1621209731296000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOCx4pf3zPACFQAAAAAdAAAAABAJ 


covid.png - 
https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.iconpacks.net%2Ffree-icon%2Fcorona-virus-outbreak-3176.html&psig=AOvVaw3QAke4F4-uJIL3ygx2Z1dE&ust=1621212036914000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJi-5NH7zPACFQAAAAAdAAAAABAD 


doctor.png - 
https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinclipart.com%2Fpindetail%2FibiRbmT_doctor-cartoon-png-clipart%2F&psig=AOvVaw3hQt5b7Nuv2mbkYoKENyn7&ust=1621212085325000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLi73eX7zPACFQAAAAAdAAAAABAG 


mask.png - 
https://www.google.com/url?sa=i&url=https%3A%2F%2Fin.pinterest.com%2Fpin%2F315252042671282715%2F&psig=AOvVaw1dxcwpukcTX4-Twv4qiowx&ust=1621574486315000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJDAmevB1_ACFQAAAAAdAAAAABAD 


vaccine.png - 
https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F368239707024923914%2F&psig=AOvVaw2h_uMnOeju_7LKFTMSOcYs&ust=1621212847545000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCUgdH-zPACFQAAAAAdAAAAABAD 


dinosaur.png - 
https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pixilart.com%2Fart%2Fthe-dreaded-google-chrome-dino-d8a5d6f1f1f432a&psig=AOvVaw0ljj2K8YpO1UL1naPnGVRN&ust=1621370109862000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOiwzb3I0fACFQAAAAAdAAAAABAI 


buildingBackground.png - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pngkey.com%2Fmaxpic%2Fu2e6i1o0i1o0e6e6%2F&psig=AOvVaw3gYxqtj5gHVevvrTKUomyr&ust=1621625889915000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMDj8r2H2fACFQAAAAAdAAAAABAD 


dayAndNight.png - https://www.google.com/url?sa=i&url=https%3A%2F%2Fcreazilla.com%2Fnodes%2F36360-day-and-night-clipart&psig=AOvVaw12XU1Bh31RMS4n3Xa9DQvp&ust=1621631682818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCesZmX2fACFQAAAAAdAAAAABAV 


pinkiePie.png - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F406942516311789804%2F&psig=AOvVaw2X74D22LsRLkwNEFdEVsWJ&ust=1621833880245000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJDcnZWI3_ACFQAAAAAdAAAAABAD


dryBones.png - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.mariowiki.com%2FDry_Bones&psig=AOvVaw0-gBs5IVbksAM5xD1w63hl&ust=1621833905403000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKj16KKI3_ACFQAAAAAdAAAAABAD 


creeper.png - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pngix.com%2Ftranspng%2FhoRJm%2F&psig=AOvVaw2J1laLhe3ALsv7jOKg8Gac&ust=1621834480529000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjcwLOK3_ACFQAAAAAdAAAAABAZ 


key.png - https://wwgc.firebaseapp.com/ 


deathSound.wav - https://freesound.org/people/stumpbutt/sounds/381690/ 


jumpSound.wav - https://freesound.org/people/AbbasGamez/sounds/411443/ 


maskSound.wav - https://freesound.org/people/MATRIXXX_/sounds/515736/ 


vaccineSound.wav - https://freesound.org/people/suntemple/sounds/253172/