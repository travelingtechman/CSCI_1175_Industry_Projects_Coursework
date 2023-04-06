package finalProject1;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PossibleGuiSimplifiedForGeneric extends Application {
//    Player player = new Player(100, 5);
//
    @Override
    public void start(Stage primaryStage) {
//        TextArea txt = new TextArea("Welcome to the my game! If the game closes after selecting an option that means you died instantly! \n     Select Start to begin\n\n");
//        txt.setEditable(false);
//        txt.setPrefSize(800, 500);
//        txt.setWrapText(true);
//
//        Button[] choices = new Button[3];
//        for (int i = 0; i < choices.length; i++) {
//            choices[i] = new Button();
//        }
//
//        Text healthTxt = new Text("Current Player Health: " + player.getHealth());
//        healthTxt.setFill(Color.RED);
//
//        Button start = new Button("start");
//        start.setOnAction(buttonClicked -> {
//            txt.clear();
//            start.setVisible(false);
//            MustyCavern musty = new MustyCavern();
//            processRoom(musty, txt, player, choices, healthTxt);
//        });
//
//        Button minigame = new Button("Minigame");
//
//        Enemy Skeleton = new Enemy(35, 5, "skeleton");
//
//        HBox hbox4healthAndStartButton = new HBox(10);
//        hbox4healthAndStartButton.getChildren().addAll(healthTxt, start, minigame);
//        hbox4healthAndStartButton.setAlignment(Pos.TOP_CENTER);
//
//        HBox hbox4txt = new HBox(250);
//        hbox4txt.getChildren().add(txt);
//        hbox4txt.setAlignment(Pos.TOP_CENTER);
//
//        VBox vbox4ChoiceButtons = new VBox(15);
//        vbox4ChoiceButtons.getChildren().addAll(choices);
//        vbox4ChoiceButtons.setAlignment(Pos.CENTER_LEFT);
//
//        BorderPane bPane = new BorderPane();
//        bPane.setLeft(hbox4txt);
//        bPane.setTop(hbox4healthAndStartButton);
//        bPane.setCenter(vbox4ChoiceButtons);
//
//        minigame.setOnAction(buttonClicked -> {
//            combatMiniGame(Skeleton, bPane, player, txt);
//        });
//
//        Scene scene = new Scene(bPane, 1900, 1000);
//
//        primaryStage.setTitle("MyJavaFX");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    public void processRoom(RoomObject room, TextArea txt, Player player, Button[] choices, Text healthTxt) {
//        int numChoices = room.getNumChoices();
//        for (int i = 0; i < numChoices; i++) {
//            String choiceText = room.getChoiceText(i);
//            choices[i].setText(choiceText);
//            choices[i].setVisible(true);
//            int choiceIndex = i;
//            choices[i].setOnAction(buttonPushed -> {
//                player.setHealth(player.getHealth() - room.getChoiceDamage(choiceIndex));
//                txt.appendText(room.getChoiceDescription(choiceIndex));
//                healthTxt.setText("Current Player Health: " + player.getHealth());
//                endGameSequince(player, txt, choices[0], choices[1], choices[2], healthTxt);
//
//                if (room instanceof MustyCavern) {
//                    AncientLibrary library = new AncientLibrary();
//                    processRoom(library, txt, player, choices, healthTxt);
//                } else if (room instanceof AncientLibrary) {
//                    // Implement the next room class and replace "NextRoom" with the class name
//                    NextRoom nextRoom = new NextRoom();
//                    processRoom(nextRoom, txt, player, choices, healthTxt);
//                } else {
//                    // Add more rooms as needed
//                }
//            });
//        }
//
//        for (int i = numChoices; i < choices.length; i++) {
//            choices[i].setVisible(false);
//        }
//    }
//
//    public void endGameSequince(Player player, TextArea txt, Button btn1, Button btn2, Button btn3, Text healthTxt) {
//        if (player.getHealth() <= 0) {
//            txt.appendText("\n\nYou have died.");
//            btn1.setVisible(false);
//            btn2.setVisible(false);
//            btn3.setVisible(false);
//            healthTxt.setText("You are dead!");
//        }
//    }
//
//    public void combatMiniGame(Enemy enemy, BorderPane bPane, Player player, TextArea txt) {
//        // Implement the combat mini-game logic here
    	
    	
//    	private String minigameResults(int resultOfFightSequence) {
    	//
//    			switch (resultOfFightSequence) {
//    			case 0:
    	//
//    				break;
    	//
//    			case 1:
    	//
//    				break;
    	//
//    			case 2: 
    	//
//    				break;
    	//
//    			case 3: 
    	//
//    				break;
    	//
//    			case 4: 
    	//
//    				break;
    	//
    	//
//    			}
    	//
    	//
//    			return "minigameResults not working if u see this";
//    		}
    	//	
    			//semi-generic method that does the same thing as all three of the room methods (mustyCavern, AncientLibrary, ForgottenTomb) but just uses arrays to get the info rather then its own little method
//    		public void processRoom(RoomObject room, TextArea txt, Player player, Button[] choices, Text healthTxt, Enemy enemy) { 
//    			int numChoices = room.getNumChoices();
//    			for (int i = 0; i < numChoices; i++) {
//    				String choiceText = room.getChoiceText(i);
//    				choices[i].setText(choiceText);
//    				choices[i].setVisible(true);
//    				int choiceIndex = i;
//    				choices[i].setOnAction(buttonPushed -> {
//    					player.setHealth(player.getHealth() - room.getChoiceDamage(choiceIndex));
//    					txt.appendText(room.getChoiceDescription(choiceIndex));
//    					healthTxt.setText("Current Player Health: " + player.getHealth());
//    					endGameSequince(player, txt, choices[0], choices[1], choices[2], healthTxt, enemy);
//    				});
//    			}
//    			txt.appendText(room.getRoomDescription());
//    		}
    		
   }
}
