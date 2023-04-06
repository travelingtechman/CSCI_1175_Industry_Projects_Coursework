package finalProject1;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * this class is the main platform for running the game. there are a good amount of methods, each method's function is described by the name of the 
 * method itself, but any quirks or areas where i deem it to be mor complex then the name will include a brief explanation
 * @author ethan hunt
 * @version 1.0
 * 
 */

public class FinalMainGui extends Application {
	static String roomDescription;
	static String buttonDescriptions;
	static MustyCavern musty = new MustyCavern();
	static AncientLibrary library = new AncientLibrary();
	static ForgottenTomb tomb = new ForgottenTomb();
	int II = 0;
	int playerChoiceGlobal ;
	Player player = new Player(100,5);
	private boolean playerTurn = true;
	// (for when status effects are added) private boolean enemyConcussed = false;
	private Button attackHeadBtn, attackLegsBtn, attackChestBtn;
	private Label messageLabel, playerHealthLabel, enemyHealthLabel;

	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Text healthTxt = new Text("Current Player Health " + player.getHealth());
		healthTxt.setFill(Color.RED);
		TextArea txt = new TextArea("Welcome to the my game! If the game closes after selecting an option that means you died instantly! \n     Select Start to begin\n\n" );
		txt.setEditable(false);
		txt.setPrefSize(800, 400);
		txt.setWrapText(true);

		Button choice0 = new Button("0");
		choice0.setOnAction(e->{
			playerChoiceGlobal = 0;
		});
		
		Button choice1 = new Button("1");
		choice1.setOnAction(e->{
			playerChoiceGlobal = 1;
		});

		Button choice2 = new Button("2");
		choice2.setOnAction(e->{
			playerChoiceGlobal = 2;
		});
		
		//restartButton that resets the program
		Button restartButton = new Button("restart2.0");
		restartButton.setOnMouseClicked(e-> {
			primaryStage.close();
			Platform.runLater( () -> {
				new FinalMainGui().start(new Stage() );
			} );
		});
		restartButton.setVisible(false);
		//HBox hb4Health = new HBox(healthTxt);
		HBox hbox4txt = new HBox(250);
		VBox vbox4ChoiceButtons = new VBox(15);
		HBox hbox4healthAndStartButton = new HBox(10);

		Button start = new Button("start"); 

		hbox4healthAndStartButton.getChildren().addAll(healthTxt , start);
		hbox4txt.getChildren().add(txt);
		vbox4ChoiceButtons.getChildren().addAll(choice0,choice1,choice2, restartButton);

		//set positioning for buttons and text in the respective h Boxes
		hbox4healthAndStartButton.setAlignment(Pos.TOP_CENTER);
		hbox4txt.setAlignment(Pos.TOP_CENTER);
		vbox4ChoiceButtons.setAlignment(Pos.CENTER);

		//create borderPane and set the location of the hBoxes
		BorderPane bPane = new BorderPane();
		bPane.setLeft(hbox4txt);
		bPane.setTop(hbox4healthAndStartButton);
		BorderPane centerBPane = new BorderPane();
		centerBPane.setBottom(vbox4ChoiceButtons);
		bPane.setCenter(centerBPane);

		start.setOnAction(buttonClicked->{
			txt.clear();
			start.setVisible(false);
			mustyCavGuiOverride(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane, restartButton);

		});

		Scene scene = new Scene(bPane, 1900,1000);

		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args){
		launch(args);
	}
	/**
	 * 
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 */
	public void buttonSwitch(Button choice0, Button choice1, Button choice2) {
		if(choice0.isDisabled() == true) {
			choice0.setDisable(false);
			choice1.setDisable(false);
			choice2.setDisable(false);

		} else if(choice0.isDisabled() == false) {
			choice0.setDisable(true);
			choice1.setDisable(true);
			choice2.setDisable(true);
		}
		
	}
	/**
	 * 
	 * @param i: int, it is a place holder for the global II value
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 * @param bPane: BorderPane: A border pane that contains the buttons and text area
	 * @param centerBPane: BorderPane: a border pane containing the enemy image and fight text log
	 * @param restartButton: Button: a button that restarts the program
	 */
	public void mustyCavGuiOverride(int i, TextArea txt , Player player, Button choice0, Button choice1, Button choice2, Text healthTxt, BorderPane bPane, BorderPane centerBPane, Button restartButton) {
 		choice0.setVisible(true);
		choice1.setVisible(true);
		choice2.setVisible(true);
		txt.appendText(musty.roomDescription());
		choice0.setText(musty.choice0);
		choice1.setText(musty.choice1);
		choice2.setText(musty.choice2);
		
		//creates enemy "skeleton" with 35 health points 5 damage
		Enemy Skeleton = new Enemy(30, 5, "Skeleton", "C:\\Users\\ethan\\eclipse-workspace\\CSCI 1175\\src\\finalProject1\\Skeleton.jpg");


			if(player.getHealth()> 0) {
				choice0.setOnAction(buttonPushed->{
					playerChoiceGlobal = 0;
					player.setHealth(player.getHealth()-4);
					txt.appendText(musty.choiceDescription0());
					II++;
					endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, Skeleton, restartButton);
					healthTxt.setText("Current Player Health" + player.getHealth());
					ancientLibraryLoop(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane, restartButton);
				});
				choice1.setOnAction(buttonPushed->{
					playerChoiceGlobal = 1;
					player.setHealth(player.getHealth()-1);
					txt.appendText(musty.choiceDescription1());
					II++;
					endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, Skeleton, restartButton);
					healthTxt.setText("Current Player Health" + player.getHealth());
					ancientLibraryLoop(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane, restartButton);
				});
				choice2.setOnAction(buttonPushed->{
					playerChoiceGlobal = 2;
					txt.appendText(musty.choiceDescription2());
					II++;
					combatMiniGame(Skeleton, bPane, player, txt, choice0, choice1, choice2, centerBPane, healthTxt, restartButton );
					player.setHealth(player.getHealth());
					endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, Skeleton, restartButton);
					healthTxt.setText("Current Player Health" + player.getHealth());
				});

			} else if(player.getHealth()<= 0) {
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, Skeleton, restartButton);

			}
	}
	/**
	 * 
	 * @param i: int, it is a place holder for the global II value
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 * @param bPane: BorderPane: A border pane that contains the buttons and text area
	 * @param centerBPane: BorderPane: a border pane containing the enemy image and fight text log
	 * @param restartButton: Button: a button that restarts the program
	 */
	public void ancientLibraryLoop(int i, TextArea txt , Player player, Button choice0, Button choice1, Button choice2, Text healthTxt, BorderPane bPane, BorderPane centerBPane, Button restartButton) {
		Enemy spirit = new Enemy(40, 5, "Spirit", "C:\\Users\\ethan\\eclipse-workspace\\CSCI 1175\\src\\finalProject1\\Spirit.jpg");
		choice0.setVisible(true);
		choice1.setVisible(true);
		choice2.setVisible(true);
		txt.appendText(library.roomDescription());
		choice0.setText(library.choice0);
		choice1.setText(library.choice1);
		choice2.setText(library.choice2);
		if(player.getHealth()> 0) {	
			choice0.setOnAction(buttonPushed->{
				playerChoiceGlobal = 0;
				txt.appendText(library.choiceDescription0());
				II++;
				
				//combatMiniGame(spirit, bPane, player, txt, choice0, choice1, choice2, centerBPane );
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, spirit, restartButton);
				healthTxt.setText("Current Player Health" + player.getHealth());
				ForgottenTombLoop(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane, restartButton);
			});
			choice1.setOnAction(buttonPushed->{
				playerChoiceGlobal = 1;
				player.setHealth(player.getHealth()-10); 
				txt.appendText(library.choiceDescription1());
				II++;
				
				//combatMiniGame(spirit, bPane, player, txt, choice0, choice1, choice2, centerBPane );
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, spirit, restartButton);
				healthTxt.setText("Current Player Health" + player.getHealth());
				ForgottenTombLoop(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane, restartButton);
			});
			choice2.setOnAction(buttonPushed->{
				playerChoiceGlobal = 2;
				//player.setHealth(player.getHealth()-5);
				txt.appendText(library.choiceDescription2());
				II++;
				
				combatMiniGame(spirit, bPane, player, txt, choice0, choice1, choice2, centerBPane, healthTxt, restartButton);
				//endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, spirit, restartButton);
				healthTxt.setText("Current Player Health" + player.getHealth());
			//	ForgottenTombLoop(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane);
			});
		} else {
			endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, spirit, restartButton);		
		}
	}
	/**
	 * 
	 * @param i: int, it is a place holder for the global II value
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 * @param bPane: BorderPane: A border pane that contains the buttons and text area
	 * @param centerBPane: BorderPane: a border pane containing the enemy image and fight text log
	 * @param restartButton: Button: a button that restarts the program
	 */
	public void ForgottenTombLoop(int i, TextArea txt , Player player, Button choice0, Button choice1, Button choice2, Text healthTxt, BorderPane bPane, BorderPane centerBPane, Button restartButton) {
		//create enemy called draugr
		Enemy draugr = new Enemy(50, 7, "Draugr", "C:\\Users\\ethan\\eclipse-workspace\\CSCI 1175\\src\\finalProject1\\Draugr.jpg");
		
		choice0.setVisible(true);
		choice1.setVisible(true);
		choice2.setVisible(true);
		txt.appendText(tomb.roomDescription());
		choice0.setText(tomb.choice0);
		choice1.setText(tomb.choice1);
		choice2.setText(tomb.choice2);
		if(player.getHealth() > 0) {
			choice0.setOnAction(buttonPushed->{
				playerChoiceGlobal = 0;
				txt.appendText(tomb.choiceDescription0());
				healthTxt.setText("Current Player Health" + player.getHealth());
				II++;
				combatMiniGame(draugr, bPane, player, txt, choice0, choice1, choice2, centerBPane, healthTxt, restartButton);
				healthTxt.setText("Current Player Health" + player.getHealth());
 
			});
			choice1.setOnAction(buttonPushed->{
				playerChoiceGlobal = 1;
				player.setHealth(player.getHealth()-0); 
				txt.appendText(tomb.choiceDescription1());
				healthTxt.setText("Current Player Health" + player.getHealth());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, draugr, restartButton);
			});
			choice2.setOnAction(buttonPushed->{
				playerChoiceGlobal = 2;
				player.setHealth(player.getHealth()-10); 
				txt.appendText(tomb.choiceDescription2());
				healthTxt.setText("Current Player Health" + player.getHealth());
				II++;
				endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, draugr, restartButton);
			});
		} else {
			endGameSequince(player,txt, choice0, choice0, choice2, healthTxt, draugr, restartButton);
		}
	}
	/**
	 * 
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param healthTxt: Text: displays the users health onto the gui
	 * @param enemy: Enemy: contatins the enemy object with the parameters assigned to it when constucted 
	 * @param restartButton: Button: a button that restarts the program
	 */
	public void endGameSequince(Player player, TextArea txt, Button choice0, Button choice1, Button choice2, Text healthTxt, Enemy enemy, Button restartButton) {
		if(player.getHealth()<=0) {
			txt.appendText("\n\nYou died... L \nRestart the program to play again");
			choice0.setVisible(false);
			choice2.setVisible(false);
			choice1.setVisible(false);
			restartButton.setVisible(true);
			//}
		} else if((player.getHealth() > 0) && (II == 3)){
			txt.appendText("\n\nYOU WIN:)!!!!!!\n click restart to play again");
			choice0.setVisible(false);
			choice2.setVisible(false);
			choice1.setVisible(false);
			restartButton.setVisible(true);
			
		} else  {
		}
	}
	/**
	 * 
	 * @param enemy: Enemy: contatins the enemy object with the parameters assigned to it when constucted
	 * @param bPane: BorderPane: A border pane that contains the buttons and text area
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param txt: TextArea: the text that is displayed on the stage
	 * @param choice0: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice1: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param choice2: Button: displays the given text for the first option and causes the program to either end or move to the next room if selected
	 * @param centerBPane: BorderPane: a border pane containing the enemy image and fight text log
	 * @param healthTxt: Text: displays the users health onto the gui
	 * @param restartButton: Button: a button that restarts the program
	 * @return Player: already described above
	 */
	public Player combatMiniGame(Enemy enemy, BorderPane bPane, Player player, TextArea txt, Button choice0, Button choice1, Button choice2, BorderPane centerBPane, Text healthTxt, Button restartButton) {
		
		buttonSwitch(choice0, choice1, choice2);
		// Create attack buttons
		attackHeadBtn = new Button("Attack Head");
		attackLegsBtn = new Button("Attack Legs");
		attackChestBtn = new Button("Attack Chest");

		// Create health labels
		playerHealthLabel = new Label("Player Health: " + player.getHealth());
		enemyHealthLabel = new Label(enemy.getName() + " Health: " + enemy.getHealth());

		// Create message label
		messageLabel = new Label("Choose an attack.");
		
		//Create text area
		TextArea battleText = new TextArea();

		// Create button box
		HBox attackButtons = new HBox(10);
		attackButtons.setAlignment(Pos.CENTER);
		attackButtons.getChildren().addAll(attackHeadBtn, attackLegsBtn, attackChestBtn);

		// Create health box
		VBox healthDisplay = new VBox(10);
		healthDisplay.setAlignment(Pos.CENTER);
		healthDisplay.getChildren().addAll(playerHealthLabel, enemyHealthLabel);

		// Create message box 
		VBox attackHistory = new VBox(10);
		attackHistory.setAlignment(Pos.CENTER);
		attackHistory.getChildren().addAll(messageLabel, battleText);
		
		VBox imageHolder = new VBox();
		imageHolder.setAlignment(Pos.CENTER);
		
		// Create main grid pane
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setPadding(new Insets(20));
		gridPane.add(attackButtons, 0, 0);
		gridPane.add(healthDisplay, 1, 0);
		gridPane.add(attackHistory, 0, 1, 2, 1);

		bPane.setRight(gridPane);
		
		setImageToBorderPane(centerBPane,(enemy.getImagePath()), imageHolder);
		// Set up button actions
		attackHeadBtn.setOnAction(event -> {
			if (playerTurn) {
				int damage = player.getDmgOutput() + 5;

				boolean isCritical = (Math.random() < 0.2); // 20% chance of a critical strike
				if (isCritical) {
					damage *= 2; // double damage
					messageLabel.setText("Critical hit! You attack the enemy's head for " + damage + " damage!\n");
					battleText.appendText("Critical hit! You attack the enemy's head for " + damage + " damage!\n");
					//enemyConcussed = true; // set concussion status effect
				} else {
					messageLabel.setText("You attack the enemy's head for " + damage + " damage!\n");
					battleText.appendText("You attack the enemy's head for " + damage + " damage!\n");
					//enemyConcussed = false; // clear concussion status effect
				}
				enemy.setHealth(enemy.getHealth() - damage);
				enemyHealthLabel.setText("Enemy Health: " + enemy.getHealth());
				
				//any scene/pane changes should start here
				if (enemy.getHealth() <= 0) {
					messageLabel.setText("\nYou win!");
					battleText.appendText("\nYou win!");
					//disableButtons();
					buttonSwitch(choice0, choice1, choice2);
					
					centerBPane.setBackground(null);
					gridPane.getChildren().clear();
					if(enemy.getName() == "Skeleton") {
						healthTxt.setText("Current Player Health" + player.getHealth());
						endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, enemy, restartButton);
						ancientLibraryLoop(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane, restartButton);
					} else if(enemy.getName() == "Spirit") {
						healthTxt.setText("Current Player Health" + player.getHealth());
						endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, enemy, restartButton);
						ForgottenTombLoop(II, txt, player, choice0, choice1, choice2, healthTxt, bPane, centerBPane, restartButton);
					} else if (enemy.getName() == "Draugr"){
						healthTxt.setText("Current Player Health" + player.getHealth());
						endGameSequince(player,txt, choice0, choice1, choice2, healthTxt, enemy, restartButton);
					}
					
				} else {
					playerTurn = false;
					enemyTurn(enemy, player, txt);
				}
			}
		});

		attackLegsBtn.setOnAction(event -> {
			if (playerTurn) {
				int damage = (player.getDmgOutput() );
				if (Math.random() < 0.2) { // 20% chance of a critical strike
					damage *= 2; // double damage
					messageLabel.setText("Critical hit! You attack the enemy's legs for " + damage + " damage!\n");
					battleText.appendText("Critical hit! You attack the enemy's legs for " + damage + " damage!\n");
				} else {
					messageLabel.setText("You attack the enemy's head for " + damage + " damage!\n");
					battleText.appendText("You attack the enemy's head for " + damage + " damage!\n");
				}
				enemy.setHealth(enemy.getHealth() - damage);
				enemyHealthLabel.setText("Enemy Health: " + enemy.getHealth());
				if (enemy.getHealth() <= 0) {
					messageLabel.setText("\nYou have slain you foe!\n");
					battleText.appendText("\nYou have slain you foe!\n");
					//disableButtons();
					buttonSwitch(choice0, choice1, choice2);
					
					//imageHolder.getChildren().clear();
					centerBPane.setBackground(null);
					gridPane.getChildren().clear();
				} else {
					playerTurn = false;
					enemyTurn(enemy, player, txt);
				}
			}
		});

		attackChestBtn.setOnAction(event -> {
			if (playerTurn) {
				int damage = ( player.getDmgOutput() + 2 );
				if (Math.random() < 0.2) { // 20% chance of a critical strike
					damage *= 2; // double damage
					messageLabel.setText("Critical hit! You attack the enemy's head for " + damage + " damage!\n");
					battleText.appendText("Critical hit! You attack the enemy's head for " + damage + " damage!\n");
				} else {
					messageLabel.setText("You attack the enemy's head for " + damage + " damage!\n");
					battleText.appendText("You attack the enemy's head for " + damage + " damage!\n");
				}
				enemy.setHealth(enemy.getHealth() - damage);
				enemyHealthLabel.setText("Enemy Health: " + enemy.getHealth());
				if (enemy.getHealth() <= 0) {
					messageLabel.setText("\nYou have slain you foe!\n");
					battleText.appendText("\nYou have slain you foe!\n");
					//disableButtons();
					buttonSwitch(choice0, choice1, choice2);
					centerBPane.setBackground(null);
					gridPane.getChildren().clear();

				} else {
					playerTurn = false;
					enemyTurn(enemy, player, txt);
				}
			}
		});
		return player;


	}

	
	/**
	 * 
	 * @param enemy: Enemy: contatins the enemy object with the parameters assigned to it when constucted
	 * @param player: Player: acts as a placeholder for the global Player object
	 * @param txt: TextArea: the text that is displayed on the stage
	 */
	// Enemy's turn
	private void enemyTurn(Enemy enemy, Player player, TextArea txt) {
		if (enemy.getHealth() <= 0) {
			messageLabel.setText("You have slain your foe!");
			disableButtons();
		} else {
			int attack = (int) (Math.random() * 3) + 1;
			switch (attack) {
			case 1:
				player.setHealth(player.getHealth() - (enemy.getDmgOutput() + 4));
				playerHealthLabel.setText("Player Health: " + player.getHealth());
				messageLabel.setText("The enemy attacks your head for " + (enemy.getDmgOutput() + 4) + " damage!\n");
				break;
			case 2:
				player.setHealth(player.getHealth() - enemy.getDmgOutput()  );
				playerHealthLabel.setText("Player Health: " + player.getHealth());
				messageLabel.setText("The enemy attacks your legs for " + enemy.getDmgOutput() + " damage!\n");
				break;
			case 3:
				player.setHealth(player.getHealth() - (enemy.getDmgOutput() + 4));
				playerHealthLabel.setText("Player Health: " + player.getHealth());
				messageLabel.setText("The enemy attacks your chest for "+ (enemy.getDmgOutput() + 4) + " damage!\n");
				break;
			}
			if (player.getHealth()<= 0) {
				messageLabel.setText("\nYou lose!\n");
				disableButtons();
			} else {
				playerTurn = true;
			}
		}
	}

	private void disableButtons() {
		attackHeadBtn.setDisable(true);
		attackLegsBtn.setDisable(true);
		attackChestBtn.setDisable(true);
	}

	private void setImageToBorderPane(BorderPane centerBPane, String imagePath, VBox vbox) {
		Image image = new Image(imagePath);
		//ImageView imageView = new ImageView();
//		vbox.getChildren().add(imageView);
		//centerBPane.setCenter(imageView);
		
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		centerBPane.setBackground(background);
//		
	}
	/**
	 * 
	 * @param borderPane : placeholder for a BorderPane
	 */
	public static void clearBorderPane(BorderPane borderPane) {
	    borderPane.getChildren().clear();
	}
	/**
	 * 
	 * @param gridPane : placeholder for a GridPane
	 */
	public static void clearGridPane(GridPane gridPane) {
	    gridPane.getChildren().clear();
	}
}
