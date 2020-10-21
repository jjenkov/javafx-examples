package com.jenkov.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * This example displays a Stage without any decorations - meaning without any "close" or "minimize" buttons,
 * and no top title bar. You can play with the other Stage styles by commenting the other options in and out.
 *
 */
public class StageDecorationExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        primaryStage.setTitle("This title is not visible");
        primaryStage.setScene(scene);

        //primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.initStyle(StageStyle.UNIFIED);
        //primaryStage.initStyle(StageStyle.UTILITY);

        primaryStage.show();
    }

}
