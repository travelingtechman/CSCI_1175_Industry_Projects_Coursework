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
//Exercise31_01Client.java: The client sends the input to the server and receives
//result back from the server
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise33_01Client extends Application {
	// Text field for receiving radius
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumOfYears = new TextField();
	private TextField tfLoanAmount = new TextField();
	private Button btSubmit= new Button("Submit");
	private double IR = 0.0;
	private int TLA = 0;
	private int NOY = 0;
	private double Total = 0;
	private double Monthly = 0;
	public int port = 1738;
	String host = "localhost";
	DataInputStream in;
	DataOutputStream out;
	Socket socket;
	// Text area to display contents
	private TextArea ta = new TextArea();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		//socket = new Socket(host,port);
		//DataInputStream input = new DataInputStream(socket.getInputStream());
		//DataOutputStream output = new DataOutputStream(socket.getOutputStream());


		ta.setWrapText(true);

		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Annual Interest Rate"), 0, 0);
		gridPane.add(new Label("Number Of Years"), 0, 1);
		gridPane.add(new Label("Loan Amount"), 0, 2);
		gridPane.add(tfAnnualInterestRate, 1, 0);
		gridPane.add(tfNumOfYears, 1, 1);
		gridPane.add(tfLoanAmount, 1, 2);
		gridPane.add(btSubmit, 2, 1);

		tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
		tfNumOfYears.setAlignment(Pos.BASELINE_RIGHT);
		tfLoanAmount.setAlignment(Pos.BASELINE_RIGHT);

		tfLoanAmount.setPrefColumnCount(5);
		tfNumOfYears.setPrefColumnCount(5);
		tfLoanAmount.setPrefColumnCount(5);

		BorderPane pane = new BorderPane();
		pane.setCenter(new ScrollPane(ta));
		pane.setTop(gridPane);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 250);
		primaryStage.setTitle("Exercise31_01Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		//works for action event on "submit" button click
		btSubmit.setOnAction(e->{
			setIR(Double.parseDouble(tfAnnualInterestRate.getText()));
			setTLA(Integer.parseInt(tfLoanAmount.getText()));
			setNOY(Integer.parseInt(tfNumOfYears.getText()));

			new Thread(() -> connectToServer()).start();
			new Thread(() -> thread4ServerInfo()).start();
		});
	}
	public void connectToServer(){


		try {
			socket = new Socket(host,port);
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeDouble(getIR());
			output.writeInt(getNOY());
			output.writeInt(getTLA());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void thread4ServerInfo() {
		try {
			socket = new Socket(host,port);
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());

			setMonthly(input.readDouble());
			setTotal(input.readDouble());

			ta.appendText("Annual Interest Rate: " + IR);
			ta.appendText("\nNumber of Years: " + NOY);
			ta.appendText("\nLoan Amount: " + TLA);
			ta.appendText("\nMonthly Payment: " + Monthly);
			ta.appendText("\nTotal Payment: " + Total);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double getIR() {
		return this.IR;
	}
	public void setIR(double annualIntrestRate) {
		this.IR = annualIntrestRate;
	}
	public int getTLA() {
		return this.TLA;
	}
	public void setTLA(int tla) {
		this.TLA = tla;
	}
	public int getNOY() {
		return this.NOY;
	}
	public void setNOY(int noy) {
		this.NOY = noy;
	}
	public double getTotal() {
		return this.Total;
	}
	public void setTotal(double total) {
		this.Total = total;
	}
	public double getMonthly() {
		return this.Monthly;
	}
	public void setMonthly(double monthly) {
		this.Monthly = monthly;
	}
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
