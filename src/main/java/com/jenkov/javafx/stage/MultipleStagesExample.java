package com.jenkov.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This example shows two Stages at the same time.
 * Please keep in mind that the second Stage is not shown in modal mode - meaning the second Stage
 * does not block access to the first Stage.
 *
 */
public class MultipleStagesExample extends Application  {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        primaryStage.setTitle("JavaFX App");
        primaryStage.setHeight(200);
        primaryStage.setWidth(200);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("JavaFX Stage Window Title");
        stage.setX(500);
        stage.setY(500);

        stage.setWidth(600);
        stage.setHeight(300);

        stage.showAndWait();
    }



}
