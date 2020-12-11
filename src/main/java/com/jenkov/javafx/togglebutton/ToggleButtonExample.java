package com.jenkov.javafx.togglebutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX MenuButton - and prints a text when a menu item from the button is selected.
 */
public class ToggleButtonExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //First, simple example of creating a MenuButton
        ToggleButton toggleButton = new ToggleButton("Toggle This!");

        toggleButton.setOnAction((event) -> {
            System.out.println("Toggle button clicked");
            String buttonText = toggleButton.isSelected() ? "On" : "Off";
            toggleButton.setText(buttonText);
        });

        VBox vbox = new VBox(toggleButton);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth (300);
        primaryStage.setHeight(300);
        primaryStage.show();
    }

}
