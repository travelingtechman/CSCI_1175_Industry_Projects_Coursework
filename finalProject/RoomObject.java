package finalProject1;

public class RoomObject {
    private String roomName;
    private String roomDescription;
    private String[] choiceDescriptions;
    private int[] choiceDamages;
    
    public RoomObject(String roomName, String roomDescription, String[] choiceDescriptions, int[] choiceDamages) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.choiceDescriptions = choiceDescriptions;
        this.choiceDamages = choiceDamages;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public String getRoomDescription() {
        return roomDescription;
    }
    
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
    
    public String[] getChoiceDescriptions() {
        return choiceDescriptions;
    }
    
    public void setChoiceDescriptions(String[] choiceDescriptions) {
        this.choiceDescriptions = choiceDescriptions;
    }
    
    public int[] getChoiceDamages() {
        return choiceDamages;
    }
    
    public void setChoiceDamages(int[] choiceDamages) {
        this.choiceDamages = choiceDamages;
    }
    
    public int getNumChoices() {
        return choiceDescriptions.length;
    }
    
    public String getChoiceText(int choiceIndex) {
        return "Enter " + choiceIndex + " to " + choiceDescriptions[choiceIndex];
    }
    
    public String getChoiceDescription(int choiceIndex) {
        return choiceDescriptions[choiceIndex];
    }
    
    public int getChoiceDamage(int choiceIndex) {
        return choiceDamages[choiceIndex];
    }
}