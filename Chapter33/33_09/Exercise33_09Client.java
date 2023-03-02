
package exercise33_9;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Exercise33_09Client extends Application {
	private TextArea history = new TextArea();
	private TextArea chatArea = new TextArea();
	public int port = 1738;
	String host = "localhost";
	DataInputStream in;
	DataOutputStream out;
	Socket socket;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		history.setWrapText(true);
		chatArea.setWrapText(true);
		//taServer.setDisable(true);

		BorderPane pane1 = new BorderPane();
		pane1.setTop(new Label("History"));
		pane1.setCenter(new ScrollPane(history));
		history.setEditable(false);
		BorderPane pane2 = new BorderPane();
		pane2.setTop(new Label("New Message"));
		pane2.setCenter(new ScrollPane(chatArea));

		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(pane1, pane2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(vBox, 200, 200);
		primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		chatArea.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")) {
                String message = chatArea.getText();
                try {
                    sendMessage(message);
                    history.appendText("Me: " + message + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                chatArea.clear();
            }
        });

		 new Thread(() -> connectToServer()).start();
		}

	public void connectToServer() {
	    try {
	        socket = new Socket(host, port);
	        in = new DataInputStream(socket.getInputStream());
	        out = new DataOutputStream(socket.getOutputStream());

	        new Thread(() -> {
	            while (true) {
	                try {
	                    String message = in.readUTF();
	                    Platform.runLater(() -> {
	                        history.appendText("Server: " + message + "\n");
	                    });
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    break;
	                }
	            }
	        }).start();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

		public void sendMessage(String message) throws IOException {
	        out.writeUTF(message);
	        out.flush();
	        chatArea.appendText("me: " + message + "\n");
	        Platform.runLater(() -> {
	            history.appendText("me: " + message + "\n");
	        });
	    }
		public TextArea getChatArea() {
			return chatArea;
		}

		/**
		 * The main method is only needed for the IDE with limited
		 * JavaFX support. Not needed for running from the command line.
		 */
		public static void main(String[] args) {
			launch(args);
		}
	}
