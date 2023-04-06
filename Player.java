package finalProject1;
/**
 * this object contains the health, damage, and name for the player in the constructor, also it has getter and setter methods for each of the varibles, it also contains a 
 * method for checking if the players health is less or equal to 0  
 * @author ethan hunt
 * 
 */
public class Player implements BasicEntity {
	private int health = 0;
	private int Dmg = 0;
	private String Name = "Player";
	Player(){
	}
	/**
	 * 
	 * @param health of the player
	 * @param DmgOutput of the player
	 */
	Player(int health, int DmgOutput){
		this.health	= health;
		this.Dmg = DmgOutput;
	}
	@Override
	public void setHealth(int health) {
		this.health = health;
	}
	@Override
	public void setDmgOutput(int Dmg){
		this.Dmg = Dmg;
	}
	@Override
	public int getHealth() {
		int Health = this.health;
		return Health;
	}
	@Override
	public int getDmgOutput(){
		int dmg = this.Dmg;
		return dmg;
	}
	@Override
	public void setName(String Name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param health : the amount of health the player has 
	 * @return boolean "dead", which will be true if the player's health has reached zero and false if not 
	 */
	public boolean isPlayerDead(int health) {
		boolean dead = false;
		if(health <= 0) {
			System.out.println("you have died, restart the program to play again");
			dead = true;
		} else if(health > 0) {
			dead = false;
		} return dead;
	}
}