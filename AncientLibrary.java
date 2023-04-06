package finalProject1;
/**
 * 
 * this class contains all of the string information neccisary to the story of the game, and has methods for returning these strings based on the choice made by the player 
 * @author ethan
 * 
 */
public class AncientLibrary {
	String choice0 = "investigate the book";
	String choice1 = "test the torches";
	String choice2 = "try your luck with the crate";
	String roomName = "Ancient Library";
	AncientLibrary(){
	}
	
	/**
	 * 
	 * @return String "roomDesc" which is a description of the ancient library
	 */
	public String roomDescription() {
		String roomDesc = ("\nYou enter into a large stone room that is lit by a four torches symmetrically placed around the room.\n"
				+ "The room is lined with cobbweb-riddled, stone bookshelves. The shelves are filled with papyrus scrolls that are rotten from deteriorating of passing time. "
				+ "The only thing in the room that stands out is a strange statue of the aztec god of knowledge Quetzalcoatl, there is a book in the statues hand and "
				+ "strangly it is in english. You feel as if the statue is following your every movement with its eyes. You look at the far side of the "
				+ "room and you observe an oddly small door with a peculiarly shaped key hole next to the handle. You do a second glance around the room and you realize "
				+ "that some of the tourches have metalic grips that are somewhat similar to the keyhole in the door. You also notice that there is a small crate off to "
				+ "the side of the statue. You options for escape are to try to read the book in the statues hand and see if it reviels any useful knowledge to aid you. "
				+ "Testing the torch handles as keys to the door. Or lastly you can investigate the crate. \n"
				+ "\nEnter 0 to investigate the book, 1 to test the torches, or 2 to try your luck with the crate.\n");
		return roomDesc;
	}

	/**
	 * 
	 * @return String "choice0" a description of what happens if the user selects choice0
	 */
	public String choiceDescription0() {
		String choice0 = ("\nYou maker your way towards the statue but you can't shake the eerie feeling that it is watching you.\n"
				+ "As you get within 2 yards of it the feeling of being watch quickly changes to pure dread, but you force yourself to continue towards it. "
				+ "You are now within an arms length of the statue, you slowly move your hands towards the statues fighting all of your natural instincts that are telling you to run "
				+ "You grab the book and try to pull it from the statues hand but it is stuck, so you change your footing and prepare to give it a hard tug when "
				+ "suddenly the arm of the statue pulls towards you like a lever and you hear what sounds like stone gears hitting against eachother inside of the state "
				+ "after a brief moment of silence from the statue the eyes of the statue instantly turn to look at you locking eye contact with you seemingly staring into your soul.  "
				+ "You release your grip of the book out of surprise and fall backwards onto the ground shuffling away from the statue as fast as you can as the statue begins to vibrate and dust "
				+ "starts falling off of it. After a brief moment of vibration the statue begins to start to move as if it was alive and the book falls out of its hand as  "
				+ "it slowly stands and begins to walk towards you and frozen in terror you just sit and watch it take steps closer and closer until its at your feet. the statue leans forward "
				+ "and puts itself directly above you and its mouth opens, but to your surprise it emits what sounds like a hearty belch, then closes its mouth, slaps its stomach and begins walking away "
				+ "from you towards the door where it then forces it open to reveal an assortment of strange liquids. As you watch in a state of confusion it picks one up of the jars and takes a drinks "
				+ "of it and it throws the remaining liquid at a nearby wall. The statue then goes back to its mount and assumes the position it was in and goes completely silent. The liquid that was throw "
				+ "begins to bubble at crackle on the wall as it drips down it and slowly cracks begin forming and you can see glimpses of light. You go over to the wall and use one of the nearby "
				+ "torches to hit the wall breaking a hole wide enough to move through to the new area.\n");
		return choice0;
	}

	/**
	 * 
	 * @return String "choice1" a description of what happens if the user selects choice1
	 */
	public String choiceDescription1() {
		String choice1 = ("\nYou begin by taking off one of the torches nearest to you and removing the handle. You then take that handle and try to insert it into the keyhole but it .\n"
				+ "is slightly too wide to fit You toss it aside and move to the next torch and remove the handle. You go to use it and it fits into the lock, you begin to turn it and you hear the   "
				+ "click of what you think is the lock mechanism from inside the door, but to your surprise the ground under you begins to sink down to reveal stairs leading down into a dim corridor.  "
				+ "You grab one of the remaining torches and begin to travel down the steps, as you step down from the final step your foot hits the ground and you feel  "
				+ "it sink in and you look back at the entrance of the stairs to see that there is a slab of stone quickly sliding out to cover the way out leaving you with no choice but to move forward  "
				+ "down the hallway. As you walk you begin to hear a strange noise that is too faint to quite make out. As you move farther you can make out that the sound is the noise of something being chewed. "
				+ "Hesitantly you move forward as the noise just gets louder and louder until you see round humanoid creature sitting on the floor facing away from you moving in motions that  "
				+ "seem like it's eating something off the ground. You inch closer and your foot hits into a small pebble causing it to skip across the ground making a faint noise.  "
				+ "The creature instantly stops what its doing and flips around to face you directly. It's danny devito but he's wearing his penguin costume from 1992 batman returns "
				+ "You see that the source of the noises was a small pile of fish on the ground. The danny grins at you and begins quoting his role of frank in the tv series \"it's always sunny in Philadelphia\" "
				+ "\"I'm the Trash Man! I come out, I throw trash all over the- all over the ring! And then I start eatin' garbage! And then I pick up the trash can, and I bash the guy on the head.\" "
				+ "As he sprints towards you full speed, he penguin dives head first into your stomach then suddenly everything goes black.\n"
				+ "\nYou have lost 10 hp...\n");
		return choice1;
	}

	/**
	 * 
	 * @return String "choice2" a description of what happens if the user selects choice2
	 */
	public String choiceDescription2() {
		String choice2 = ("\nYou eagerly open the crate, but to your disappointment, you find it empty. Suddenly, a cold chill runs down your spine, causing you to shiver. "
				+ "As you turn around, a spirit materializes in front of you, and you realize you must engage in a battle to defend yourself. "
				+ "Steeling your resolve, you ready your weapon and prepare to face the otherworldly foe.");
		return choice2;
	}

}
