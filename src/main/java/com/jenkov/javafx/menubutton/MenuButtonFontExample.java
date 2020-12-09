package com.jenkov.javafx.menubutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX Button - and prints a text when the button is clicked.
 */
public class MenuButtonFontExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        MenuItem menuItem1 = new MenuItem("Option 1");
        MenuItem menuItem2 = new MenuItem("Option 2");
        MenuItem menuItem3 = new MenuItem("Option 3");

        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);

        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        menuButton.setFont(font);

        VBox vbox = new VBox(menuButton);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth (300);
        primaryStage.setHeight(300);
        primaryStage.show();
    }

}
