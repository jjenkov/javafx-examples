package com.jenkov.javafx.menubutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX MenuButton - and prints a text when a menu item from the button is selected.
 */
public class MenuButtonExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //First, simple example of creating a MenuButton
        MenuItem menuItem1 = new MenuItem("Action 1");
        MenuItem menuItem2 = new MenuItem("Action 2");
        MenuItem menuItem3 = new MenuItem("Action 3");

        menuItem1.setOnAction((event) -> { System.out.println("MenuItem1 activated"); });
        menuItem2.setOnAction((event) -> { System.out.println("MenuItem2 activated"); });
        menuItem3.setOnAction((event) -> { System.out.println("MenuItem3 activated"); });

        MenuButton menuButton = new MenuButton("Actions", null, menuItem1, menuItem2, menuItem3);


        //second, more elaborate example of how a MenuButton can be created, and configured via setter methods
        MenuButton menuButton2 = new MenuButton();
        menuButton2.setText("More Actions");

        MenuItem menuItem2_1 = new MenuItem("Action 1");
        MenuItem menuItem2_2 = new MenuItem("Action 2");
        MenuItem menuItem2_3 = new MenuItem("Action 3");

        menuItem2_1.setOnAction((event) -> { System.out.println("MenuItem2_1 activated"); });
        menuItem2_2.setOnAction((event) -> { System.out.println("MenuItem2_2 activated"); });
        menuItem2_3.setOnAction((event) -> { System.out.println("MenuItem2_3 activated"); });

        menuButton2.getItems().add(menuItem2_1);
        menuButton2.getItems().add(menuItem2_2);
        menuButton2.getItems().add(menuItem2_3);

        VBox vbox = new VBox(menuButton, menuButton2);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth (300);
        primaryStage.setHeight(300);
        primaryStage.show();
    }

}
