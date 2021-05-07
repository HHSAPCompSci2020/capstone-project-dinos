Covid Run (Dinosaur Run)
Authors: Clarence Choy, Yukai Qiu, Isaac Phoon
Revision: 5/3/2021

Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?
What problem does it solve? Why did you write it?
What is the story?
What are the rules? What is the goal?
Who would want to use your program?
What are the primary features of your program?]

It is the year 2021 and a year before the deadly virus Covid-19 has taken the world by surprise. Infection rates have skyrocketed globally and without an end in sight, it seemed hopeless. Miraculously, just earlier this year a vaccine for the virus was created and is gradually being released to the public. However, not all of the elderly are able to travel to a place to be vaccinated so you must gather masks and vaccines to deliver them. 

In this java-based game, the user controls a character that can jump and duck. Your character runs while different items such as masks, vaccines, and Covid-19 particles spawn in. The goal of the game is to survive while avoiding the Covid-19 particles and collecting masks and vaccines to gain a higher score. To add to the difficulty, the speed that the character runs increases making it harder to avoid obstacles. We decided to write this game because it is relevant to our current situation and is also a fun game for students to play. The rules of the are simple:

Avoid Covid-19 particles so you don’t get infected
Pick up masks and other items to boost your score
Don’t stop running

Our program is mainly for anyone interested in having a fun time playing a game so it is suited for all ages. The main features of our program are our randomized obstacle spawning and simple yet enjoyable game.

Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? 
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]

Once you run the program, a window will appear with the GUI of the game. Once you click the start button to begin the game, your character will start running at a slow pace but gradually run faster. Use the arrow keys to control the character. To jump, press the up arrow key. To duck down, press the down arrow key. As you run, items will appear on the right side of the screen and come closer (as you run forwards). These can either be good or bad so be careful whether it is a mask or a dangerous Covid-19 particle. 

Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]

A user controlled character
Jumps when the up arrow key is pressed and ducks when the down arrow key is pressed. The character can stand on platforms and has some physics applied to it to make the jumping look somewhat real
Character-Mask interaction
Masks will randomly spawn in the window from the right side of the screen at set heights above the ground. When the character touches the mask, the user’s score will increase and the mask will disappear
Character-Covid interaction
Covid particles will also spawn in from the right side of the screen at set heights above the ground. If the character touches the Covid, the player will “die” and the game over screen will appear
Scoreboard in the top left corner
A small box in the top left of the window that displays a number which will be your score. Your score can increase from collecting masks and also from surviving for longer.
A vaccine item with character interaction
Vaccines will randomly spawn and if the user touches it they will be immune to the Covid particles for 5 seconds. Indication of immunity will be shown by a change in color of the character

Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]

Building background
There are buildings in the background to resemble a city-like environment where Covid-19 is easily spreadable. The buildings will be moving slightly to the left to make the game seem more 3D
Animations 
Use gifs as running animations for the character and a dying animation for when the character runs into a Covid particle
The ability to change the skin or outfit of the player
Before the game starts, there will be a customize button that you can click on to change what your character looks like. Once the user selects their desired character they can go back and start the game
More complex terrains
Add platforms instead of just one flat ground that the user can run on. The character can jump onto these platforms and items can also spawn at these heights
A game over screen
Once the character touches a Covid particle and dies the screen will switch to a game over screen which says “Game Over” and also the score that the user has achieved.

Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]

 Have the game in 3D graphics where the same game rules apply
Have the camera in 3rd person view facing the way the character is running
Different sound packs and sound effects
Add sounds for jumping, interactions with masks and vaccines, and a sound when the character dies
Allow the user to change the difficulty of the game
The user can set the starting speed, speed multiplier, and the amount of Covid that spawns in during the game
Different HUD and GUI.
The user can change resolution, graphics, and even controls.


Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]

Main - Initializes a window and a drawing board to start the game
MovingImage - Superclass of Player and Item, allows for basic physics and movement of objects
Player - Represents the character that the user will be able to control
Item - Superclass of Mask, Covid, and Vaccine
Mask - Represents the mask item, extends Item class
Covid - Represents the Covid particles, extends Item class
DrawingSurface - Draws the game 
Vaccine - Represents the vaccine item, extends Item class
Scoreboard - Keeps track of the score
GameOver - Represents the screen when the player dies

Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]
Everyone - UML, README
Clarence - Item, Mask, Covid
Isaac - Player
Yukai - Scoreboard, Vaccine
All work on Main and DrawingSurface

MovingImage class - Mr. Shelby
