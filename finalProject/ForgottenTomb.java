package finalProject1;
/**
 * 
 * this class contains all of the string information neccisary to the story of the game, and has methods for returning these strings based on the choice made by the player 
 * @author ethan
 * 
 */
public class ForgottenTomb {
	String choice0 = "investigate nordic sword";
	String choice1 = "investigate strange staff";
	String choice2 = "ivestigate golden ball";
	String roomName = "Forgotten Tomb";
	/**
	 * 
	 * @return String "roomDesc" which is a description of the Forgotten tomb
	 */
	public String roomDescription() {
		String roomDesc = ("\n\nYou look around you and see a nordic burial site with cut out slots on the walls for corpses of the fallen warriors. There is lare metal door at the end of the room "
				+ "You glance around the room more closely to see a nordic sword on one of withered corpses. There is also a strange metal pole on one of the corpses that has "
				+ "faces that wrap around the top of it. The head of the staff resembles three of daedric lord Sheogorath's faces in the differing moods, you feel a strange energy emanating from it. "
				+ "There is also a small golden ball with an intricate decorative pattern etched into it, and also a spiked tip on the top of it. \n"
				+ "\nYou have 3 choices, enter 0 to investigate the nordic sword, 1 to investigate strange staff, or 2 for the golden ball\n");
		return roomDesc;
	}

	/**
	 * 
	 * @return String "choice0" a description of what happens if the user selects choice0
	 */
	public String choiceDescription0() {
		String choice0 = ("\n\nYou walk towards the corpse and reach down to grab the sword but the corpses hand is firmly gripping the sword.  "
				+ "You begin tugging on the sword when suddenly the arm brakes off of the corpse, you then try to pry the fingers of the still gripping arm off the sword. "
				+ "Suddenly you hear what sounds like a whoosh of air come out of the corpses mouth that was holding the sword. The corpse suddenly rolls out of its perch on the wall onto the ground. "
				+ "You now prepare to fight the draugr faced in front of you\n\n");
		return choice0;
	}

	/**
	 * 
	 * @return String "choice1" a description of what happens if the user selects choice1
	 */
	public String choiceDescription1() {
		String choice1 = ("\n\nYou walk over to the body with the staff and you pull it off the body. As soon as your skin touches the metal you feel a strange surge of power flow through you."
				+ "You then point the staff towards the door and release the energy into the staff and a glowing orb shoots towards the door and as it comes into contact with "
				+ "it the door disintegrates into a pile of ash. The corpses of the warriors around you begin to roll out of their tombs onto the ground and getting up drawing their weapons. "
				+ "You begin firing orbs at them but instead of disentigrating the orbs have strange effects. One of the orbs transforms the undead warrior into a large crab, another "
				+ "one is transformed into a chicken. You continue firing orbs as you run across the room towards the door changing more of the warriors as you go. "
				+ "You make it through the door and fire one last orb at the group of undead that was forming and it causes a firey tornado to tear throgh them burning them as it goes "
				+ "You run throgh the corridor with the staff you walk into the convenetly placed elevator at the end and make your leave from this wretched place.\n");
		return choice1;
	}

	/**
	 * 
	 * @return String "choice2" a description of what happens if the user selects choice2
	 */
	public String choiceDescription2() {
		String choice2 = ("\n\nYou walk over to the sphere and pick it up off the ground. As you pick it up you cut your palm on the pointed tip and you blood drips down the point and  "
				+ "begins to eerily flow around the sphere into the engraved patterns until all the gaps are filled. The sphere rapidly begins to heat up and glow brighter and brighter "
				+ "until the whole room is filled with blinding light. All of the corpses seemigly writhing in pain as they are burned by the light of the sphere. "
				+ "Once the light seemigly couldn't get any brighter all the sudden it dissapated getting absorbed back into the ball. Then suddenly in a glory blaze  "
				+ "the ball exploded instantly launching you into the wall but somehow u survive but sustained substancial damage. \n"
				+ "\nYou have lost 15 hp\n");
		return choice2;
	}

}
