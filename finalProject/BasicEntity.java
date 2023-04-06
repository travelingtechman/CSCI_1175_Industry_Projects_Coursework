package finalProject1;
/**
 * This interface lays out the simple format for any entity that will be involved in the battles
 * @author ethan hunt
 *
 */
interface BasicEntity {
	public void setHealth(int health);
	public void setDmgOutput(int Dmg);
	public void setName(String Name);
	public int getHealth();
	public int getDmgOutput();
	public String getName();
}
