/**
 * @author ethan
 * @dateCreated Mar 8, 2023
 */
package exercise31_20;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise31_20 extends Application {

    @Override
    public void start(Stage primaryStage) {

        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Line");
        StackPane pane1 = new StackPane();
        pane1.getChildren().add(new Line(10, 10, 80, 80));
        tab1.setContent(pane1);

        Tab tab2 = new Tab("Rectangle");
        tab2.setContent(new Rectangle(10, 10, 200, 200));

        Tab tab3 = new Tab("Circle");
        tab3.setContent(new Circle(50, 50, 20));

        Tab tab4 = new Tab("Ellipse");
        tab4.setContent(new Ellipse(10, 10, 100, 80));

        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);

        ToggleGroup group = new ToggleGroup();

        RadioButton top = new RadioButton("Top");
        top.setToggleGroup(group);
        top.setSelected(true);

        RadioButton bottom = new RadioButton("Bottom");
        bottom.setToggleGroup(group);

        RadioButton left = new RadioButton("Left");
        left.setToggleGroup(group);

        RadioButton right = new RadioButton("Right");
        right.setToggleGroup(group);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(left, bottom, right, top);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);

        vbox.getChildren().addAll(hbox);

        top.setOnAction(e -> {
            tabPane.setSide(Side.TOP);
        });

        bottom.setOnAction(e -> {
            tabPane.setSide(Side.BOTTOM);
        });

        left.setOnAction(e -> {
            tabPane.setSide(Side.LEFT);
        });

        right.setOnAction(e -> {
            tabPane.setSide(Side.RIGHT);
        });

        StackPane mainPane = new StackPane();
        mainPane.getChildren().addAll(tabPane, vbox);
        StackPane.setAlignment(vbox, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(mainPane, 400, 300);

        primaryStage.setTitle("DisplayFigure");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

