package com.jenkov.javafx.apps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Label label = new Label("Minimal app");

        Scene scene = new Scene(new Pane(label), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}