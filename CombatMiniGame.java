package finalProject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CombatMiniGame extends Application {
    private int playerHealth = 50;
    private int enemyHealth = 50;
    private boolean playerTurn = true;
    private boolean enemyConcussed = false;
    private Button attackHeadBtn, attackLegsBtn, attackChestBtn;
    private Label messageLabel, playerHealthLabel, enemyHealthLabel;
    
    public CombatMiniGame(){
    	
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Create attack buttons
        attackHeadBtn = new Button("Attack Head");
        attackLegsBtn = new Button("Attack Legs");
        attackChestBtn = new Button("Attack Chest");

        // Create health labels
        playerHealthLabel = new Label("Player Health: " + playerHealth);
        enemyHealthLabel = new Label("Enemy Health: " + enemyHealth);

        // Create message label
        messageLabel = new Label("Choose an attack.");
        
        // Create button box
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(attackHeadBtn, attackLegsBtn, attackChestBtn);

        // Create health box
        VBox healthBox = new VBox(10);
        healthBox.setAlignment(Pos.CENTER);
        healthBox.getChildren().addAll(playerHealthLabel, enemyHealthLabel);

        // Create message box
        VBox messageBox = new VBox(10);
        messageBox.setAlignment(Pos.CENTER);
        messageBox.getChildren().add(messageLabel);

        /*File path for enemy jpgs.
         * 
         * ("C:\\Users\\ethan\\eclipse-workspace\\CSCI 1175\\src\\finalProject1\\" + enemy + ".jpg")
         * 
         */
        // Create main grid pane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(20));
        gridPane.add(buttonBox, 0, 0);
        gridPane.add(healthBox, 1, 0);
        gridPane.add(messageBox, 0, 1, 2, 1);

        // Set up button actions
        attackHeadBtn.setOnAction(event -> {
            if (playerTurn) {
                int damage = 10;
                boolean isCritical = (Math.random() < 0.2); // 20% chance of a critical strike
                if (isCritical) {
                    damage *= 2; // double damage
                    messageLabel.setText("Critical hit! You attack the enemy's head for " + damage + " damage!");
                    enemyConcussed = true; // set concussion status effect
                } else {
                    messageLabel.setText("You attack the enemy's head for " + damage + " damage!");
                    enemyConcussed = false; // clear concussion status effect
                }
                enemyHealth -= damage;
                enemyHealthLabel.setText("Enemy Health: " + enemyHealth);
                if (enemyHealth <= 0) {
                    messageLabel.setText("You win!");
                    disableButtons();
                } else {
                    playerTurn = false;
                    enemyTurn();
                }
            }
        });

        attackLegsBtn.setOnAction(event -> {
        	 if (playerTurn) {
                 int damage = 5;
                 if (Math.random() < 0.2) { // 20% chance of a critical strike
                     damage *= 2; // double damage
                     messageLabel.setText("Critical hit! You attack the enemy's head for " + damage + " damage!");
                 } else {
                     messageLabel.setText("You attack the enemy's head for " + damage + " damage!");
                 }
                 enemyHealth -= damage;
                 enemyHealthLabel.setText("Enemy Health: " + enemyHealth);
                 if (enemyHealth <= 0) {
                     messageLabel.setText("You win!");
                     disableButtons();
                 } else {
                     playerTurn = false;
                     enemyTurn();
                 }
             }
         });

        attackChestBtn.setOnAction(event -> {
        	 if (playerTurn) {
                 int damage = 7;
                 if (Math.random() < 0.2) { // 20% chance of a critical strike
                     damage *= 2; // double damage
                     messageLabel.setText("Critical hit! You attack the enemy's head for " + damage + " damage!");
                 } else {
                     messageLabel.setText("You attack the enemy's head for " + damage + " damage!");
                 }
                 enemyHealth -= damage;
                 enemyHealthLabel.setText("Enemy Health: " + enemyHealth);
                 if (enemyHealth <= 0) {
                     messageLabel.setText("You win!");
                     disableButtons();
                 } else {
                     playerTurn = false;
                     enemyTurn();
                 }
             }
         });

        // Set up the scene
        Scene scene = new Scene(gridPane, 450, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Turn-Based Combat");
        primaryStage.show();
    }
    // Enemy's turn
    private void enemyTurn() {
        if (enemyHealth <= 0) {
            messageLabel.setText("You win!");
            disableButtons();
        } else {
            int attack = (int) (Math.random() * 3) + 1;
            switch (attack) {
                case 1:
                    playerHealth -= 10;
                    playerHealthLabel.setText("Player Health: " + playerHealth);
                    messageLabel.setText("The enemy attacks your head for 10 damage!");
                    break;
                case 2:
                    playerHealth -= 5;
                    playerHealthLabel.setText("Player Health: " + playerHealth);
                    messageLabel.setText("The enemy attacks your legs for 5 damage!");
                    break;
                case 3:
                    playerHealth -= 7;
                    playerHealthLabel.setText("Player Health: " + playerHealth);
                    messageLabel.setText("The enemy attacks your chest for 7 damage!");
                    break;
            }
            if (playerHealth <= 0) {
                messageLabel.setText("You lose!");
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

        public static void main(String[] args) {
            launch(args);
        }
}