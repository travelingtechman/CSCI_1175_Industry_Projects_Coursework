package exercise33_01;
/**
 * Ethan Hunt
 * 2/18/23
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
//Exercise31_01Server.java: The server can communicate with
//multiple clients concurrently using the multiple threads

public class Exercise33_01Server extends Application {
	// Text area for displaying contents
	private TextArea ta = new TextArea();
	public int port = 1738;
	DataInputStream in;
	DataOutputStream out;
	ServerSocket server;
	Socket socket;
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		ta.setWrapText(true);
		ta.setEditable(false);
		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 400, 200);
		primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> connectToClient()).start();
	}

	//pulls data from client and implements loan to calculate all the req info, then returns it to the client
	public void connectToClient(){

		try {
			server = new ServerSocket(port);
			socket = server.accept();
			DataInputStream input = new DataInputStream 
					(socket.getInputStream());
			DataOutputStream output = new DataOutputStream 
					(socket.getOutputStream());

			double Ir = input.readDouble();
			int NOY = input.readInt();
			int TLA = input.readInt();
			String NOYString = String.valueOf(NOY);
			String IrString = String.valueOf(Ir);
			String TLAString = String.valueOf(TLA);
			
			ta.appendText("Annual Interest Rate: " + IrString + "\n" );
			ta.appendText("Number Of Years: " + NOYString + "\n");
			ta.appendText("Loan Amount: " + TLAString + "\n");
			
			Loan loan = new Loan(Ir, NOY, TLA);
			double monthly = loan.getMonthlyPayment();
			ta.appendText("Monthly payment: " + monthly);
			
			double totalPayment = loan.getTotalPayment();
			ta.appendText("\nTotal Payment: " + totalPayment);
			
			output.writeDouble(monthly);
			output.writeDouble(totalPayment);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void loanCalculation(){

	}
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
