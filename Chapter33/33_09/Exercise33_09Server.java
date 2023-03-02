/**
 * @author Ethan Hunt
 * @date 3/2/23
 */
package exercise33_9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise33_09Server extends Application {
    private TextArea history = new TextArea();
    private TextArea chatArea = new TextArea();
    public int port = 1738;
    DataInputStream in;
    DataOutputStream out;
    ServerSocket server;
    Socket socket;
    public String chatText;

    @Override
    public void start(Stage primaryStage) {
        history.setWrapText(true);
        chatArea.setWrapText(true);
        history.setEditable(false);

        BorderPane pane1 = new BorderPane();
        pane1.setTop(new Label("History"));
        pane1.setCenter(new ScrollPane(history));
        BorderPane pane2 = new BorderPane();
        pane2.setTop(new Label("New Message"));
        pane2.setCenter(new ScrollPane(chatArea));

        VBox chatBox = new VBox(5);
        chatBox.getChildren().addAll(pane1, pane2);

        // Create a scene and place it in the stage
        Scene scene = new Scene(chatBox, 200, 200);
        primaryStage.setTitle("Exercise31_09Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        chatArea.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")) {
                String message = chatArea.getText();
                try {
                    sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                chatArea.clear();
            }
        });

        new Thread(() -> connectToClient()).start();
    }

    public void connectToClient() {
        try {
            server = new ServerSocket(port);
            socket = server.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = in.readUTF();
                Platform.runLater(() -> {
                    history.appendText("Client: " + message + "\n");
                });
            }
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

    public static void main(String[] args) {
        launch(args);
    }
}
