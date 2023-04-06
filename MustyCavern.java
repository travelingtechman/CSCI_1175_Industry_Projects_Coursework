package finalProject1;
/**
 * this class contains all of the string information neccisary to the story of the game, and has methods for returning these strings based on the choice made by the player 
 * @author ethan
 * 
 */
public class MustyCavern  {
	String choice0 = "Flashlight";
	String choice1 = "Lighter";
	String choice2 = "Wander Blindly";
	String roomName = "Musty Cavern";
	MustyCavern(){
		
	}
	
	/**
	 *  
	 * @return String roomDesc: A description for the Musty Cavern.
	 */
	public String roomDescription() {
		String roomDesc = ("\nYou find yourself inside of a very dark cavern that has a strange odor, you hear the sounds of water dripping from the hanging  "
				+ "stalactites and the occasional sound of wings flapping. The only source of light is coming from the key hole of a stone door at the far side of "
				+ "the cavern away from you. It is too dark to see anything other then the outlines of the rocks closest to the door so you have a few options to "
				+ "move forward. In your bag you have a flashlight and a lighter, but you also have the option of searching blindly with only the touch of your "
				+ "hands to guide you, what to do you choose?\n"
				+ "	\nEnter 0 for the flashlight, 1 for the lighter, or 2 for the option of moving blindly with just your sense of touch to guide you\n");
		return roomDesc;
	}

	/**
	 * 
	 * @return String "choice0" a description of what happens if the user selects choice0
	 */
	public String choiceDescription0() {
		 choice0 = ("\nYou pull the flashlight out of your bag and hit the switch to turn it on, and suddenly everything goes quite and you no longer hear any  "
				+ "sounds other then the water dripping from the ceiling.You point your flashlight around the room and something reflective catches your eye  "
				+ "against the wall, as your eyes begin to focus you make out the shape of a trophy.You pick up the trophy and read the engraved words and it says "
				+ "\"Oldest living, Light-Senitive Misanthrope. 1812-2022\" suddenly you catch a glimps of movement behind you in the reflection on the trophy. "
				+ "You turn around and point the flashlight directly into the face of a very tall hairy misanthrope with giant thumbs instead of legs and arms, it then lets out a "
				+ "high pitched screech and begins to scratch you using its enlarged thumb nails that are more sharp then they would seem. In quick, percise motions "
				+ "it makes deep lacerations all over your body causing you to lose conciosnes due to blood loss and you fall to the groud and die as it begins to consume your flesh but  "
				+ "by some twist of fate u remember what the trophie said and grab the flashlight with all of the effort you are able to muster and point it directly into the eyes of the beast  "
				+ "rendering it blind as it rears back from the contact with the light, it hits its back directly into a wall revealing a seceret tunnel giving you a chance to escape. \n"
				+ "\nYou lost 4 health points due to blood loss...\n");
		return choice0;
	}

	/**
	 * 
	 * @return String "choice1" a description of what happens if the user selects choice1
	 */
	public String choiceDescription1() {
		 choice1 = ("\nyou spark the lighter and you instantly discover what the source of the strange odor, the cavern is full of "
				+ "natural propane and  as you sparked the lighter it caused an explosion that sent you flying against a wall. As you hit  "
				+ "the wall it crumbles under the force of the impact reveling a secret tunnel that leads out of the cave into a new area. \n"
				+ "\nYou lost 1 health point due to a concussion...\n");
		return choice1;
	}

	/**
	 * 
	 * @return String "choice0" a description of what happens if the user selects choice2
	 */
	public String choiceDescription2() {
		choice2 = ("\nAs you shuffle forward, you accidentally kick a small pile of objects on the ground, scattering their contents." 
	            + "Suddenly, the scattered bones begin to swirl around, coalescing into a skeleton wielding a sword that appears to be controlled by magic." 
	            + "The skeleton attacks you, and you find yourself engaged in a fierce battle.\n" );
		return choice2;
	}
	
}
