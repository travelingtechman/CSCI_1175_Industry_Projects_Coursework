package finalProject1;
/**
 * 
 * this object contains the health, damage, name, and image filepath for an enemy of your creation in the constructor, also it has getter and setter methods for each of the varibles
 * @author ethan
 * 
 */
public class Enemy implements BasicEntity {
	private int health = 0;
	private int dmg = 0;
	private String name = "Enemy";
	private String imagePath = "";
	
	Enemy(){
	}
	/**
	 * 
	 * @param health: int: placeholder for enemy health
	 * @param dmg: int: placeholder for enemy damage
	 * @param name: String: placeholder for enemy name
	 * @param imagePath: String: placeholder for enemy image filepath in the form of a string
	 */
	Enemy(int health, int dmg, String name, String imagePath){
		this.health = health;
		this.dmg = dmg;
		this.name = name;
		this.imagePath = imagePath;
	}
	/**
	 * 
	 * @param name : placeholder for enemy name
	 * @param imagePath: placeholder for a string filepath
	 */
	public void setImagePath(String name, String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * 
	 * @return imagePath: a string filepath for the image
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	@Override
	public void setHealth(int health) {
		this.health = health;
		
	}
	
	@Override
	public void setDmgOutput(int dmg) {
		this.dmg = dmg;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getDmgOutput() {
		return dmg;
	}

	@Override
	public String getName() {
		return name;
	}

	
	
	
}
