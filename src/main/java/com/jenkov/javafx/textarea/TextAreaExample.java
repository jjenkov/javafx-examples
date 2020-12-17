package com.jenkov.javafx.textarea;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextAreaExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        TextArea textArea = new TextArea();

        textArea.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        Scene scene = new Scene(new Pane(textArea), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}