package com.jenkov.javafx.textfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TextFieldExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        textField.setText("This text is visible");

        String text = textField.getText();
        System.out.println(text);

        Scene scene = new Scene(new Pane(textField), 500, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}