# Final_Project

## Summary
This project is made up of a couple different objects that i designed for a simple choice based adventure game. You will get descriptions for each room and for the the outcomes of selecting 1 of the three items you have to choose from for each room. There is a simple health system as well as a penitly system which affects your health based on the choices you make in the game. There is also a combat minigame that activates based on the choices you make and can have a large detrement to your health if you fail to slay the enemy quickly.

## Motive
I made this program because i wanted to meet the course requirements in a way that i found fun and interactive. I chose to make it a text based adventure game because of a easter egg in "Call of Duty Black Ops" that allowed me to play a text based adventure game called "Zork I: The Great Underground Empire", i also drew motivation from turn based rpg games for the combat portion of it.

## Files and description
The files required to run this program are BasicEntity.java, AncientLibrary.java, ForgottenTomb.java, MustyCavern.java, RoomObject.java, FinalMainGui.java, Player.java, Enemy.java, Skeleton.jpg, Spirit.jpg, Draugr.jpg . It would be easiest to run them from eclipse just make sure to put them all into the same package. To start the program use the MainProject.java file to start it because that is where my main method is. To run it after you start it just type the word start or any word and it will begin, after it starts it should print out a short discription of the room that you are in and the objects that you will have to pick between to determine the outcome. Each object has a different outcome for the room. After you select an object by typing  a 0,1, or 2 and hitting enter it will tell you the outcome and how much health you have left over. There is also a minigame feature that activates depending on the choice you make in the room. One of the three choices for each room will trigger this minigame. For the minigame there are 3 buttons for different attacks and there is also a critical hit chance for each attack that can double your damage if the requirements are met for it. 

## Example of combatMiniGame

public Player combatMiniGame(Enemy enemy, BorderPane bPane, Player player, TextArea txt, Button choice0, Button choice1, Button choice2, BorderPane centerBPane, Text healthTxt, Button restartButton) {

im proud of this code because i didnt think id be able to make a "game inside a game" yet here it is and it works hand in hand with the code i used from my csci1112 project

