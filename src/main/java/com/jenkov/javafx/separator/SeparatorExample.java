package com.jenkov.javafx.separator;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeparatorExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Label label1 = new Label("Component 1");
        Label label2 = new Label("Component 2");

        Separator separator = new Separator(Orientation.VERTICAL);

        VBox vBox = new VBox(label1, separator, label2);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");

        primaryStage.show();
    }
}