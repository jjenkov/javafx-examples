package com.jenkov.javafx.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX Button - and prints a text when the button is clicked.
 */
public class ButtonDefaultAndCancelModesExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Click me!");

        button.setOnAction((event) -> {
            System.out.println("Button clicked!");
        });

        button.setCancelButton(false);
        button.setDefaultButton(false);


        Button buttonDefault = new Button("Default (OK)");

        buttonDefault.setOnAction((event) -> {
            System.out.println("Default Button clicked!");
        });

        buttonDefault.setCancelButton(false);
        buttonDefault.setDefaultButton(true);


        Button buttonCancel = new Button("Cancel");

        buttonCancel.setOnAction((event) -> {
            System.out.println("Cancel Button clicked!");
        });

        buttonCancel.setCancelButton(true);
        buttonCancel.setDefaultButton(false);


        HBox vbox = new HBox(button, buttonDefault, buttonCancel);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(512);
        primaryStage.setHeight(512);
        primaryStage.show();
    }

}
