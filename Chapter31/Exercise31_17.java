/**
 * @author ethan
 * @dateCreated 3/8/23
 */
package exercise31_17;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise31_17 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create text fields
        TextField investmentAmountTextField = new TextField();
        TextField yearsTextField = new TextField();
        TextField annualInterestRateTextField = new TextField();

        Label investmentAmountLabel = new Label("Investment Amount:");
        Label yearsLabel = new Label("Number of Years:");
        Label annualInterestRateLabel = new Label("Annual Interest Rate:");
        Label futureValueLabel = new Label("Future Value:");
        
        Label futureValueResultLabel = new Label("Future Value:");
        TextField futureValueResultTextField = new TextField();
        futureValueResultTextField.setEditable(false);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, investmentAmountLabel, investmentAmountTextField);
        gridPane.addRow(1, yearsLabel, yearsTextField);
        gridPane.addRow(2, annualInterestRateLabel, annualInterestRateTextField);

        gridPane.addRow(4, futureValueResultLabel, futureValueResultTextField);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Operation");

        MenuItem menuItem1 = new MenuItem("Calculate");
        MenuItem menuItem2 = new MenuItem("Exit");

        menu.getItems().addAll(menuItem1, menuItem2);

        menuBar.getMenus().add(menu);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> {
            double investmentAmount = Double.parseDouble(investmentAmountTextField.getText());
            int numberOfYears = Integer.parseInt(yearsTextField.getText());
            double annualInterestRate = Double.parseDouble(annualInterestRateTextField.getText());
            double monthlyInterestRate = annualInterestRate / 12 / 100;
            double futureValue = investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);
            futureValueResultTextField.setText(String.format("$%.2f", futureValue));
        });

        HBox buttonLayout = new HBox(calculateButton);
        buttonLayout.setPadding(new Insets(10));
        buttonLayout.setSpacing(10);
        buttonLayout.setAlignment(Pos.CENTER_RIGHT);

        VBox layout = new VBox();
        layout.getChildren().addAll(menuBar, gridPane, buttonLayout);
 
        Scene scene = new Scene(layout, 280, 240);

        primaryStage.setTitle("Investment Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
