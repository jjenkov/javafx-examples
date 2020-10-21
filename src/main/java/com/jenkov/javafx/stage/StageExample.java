package com.jenkov.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a simple Stage with a title, X,Y position and width and height.
 */
public class StageExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Window Title");
        primaryStage.setX(250);
        primaryStage.setY(250);
        primaryStage.setHeight(200);
        primaryStage.setWidth(200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
