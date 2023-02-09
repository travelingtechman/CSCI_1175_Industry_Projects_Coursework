package exersice32_3;

import javafx.scene.image.ImageView;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;


public class FlagRisingAnimation extends Application {
	ImageView imageView = new ImageView("C:\\Users\\ethan\\eclipse-workspace\\CSCI 1175\\src\\exersice32_3\\us.gif");
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		
		// Add an image view and add it to pane
		
		pane.getChildren().add(imageView);
		
		
		// Create a path transition
		new Thread(() -> { // lambda expression 
			  try { 
				  PathTransition pt = new PathTransition(Duration.millis(10000),
						new Line(100, 200, 100, 0), imageView); pt.setCycleCount(5);
						pt.play();
			    
			  } catch (Exception ex) {
			  }
			}).start();
	
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200); 
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}