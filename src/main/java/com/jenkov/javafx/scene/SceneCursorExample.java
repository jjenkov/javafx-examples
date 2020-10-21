package com.jenkov.javafx.scene;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
    This example shows how to set a specific mouse cursor
 */
public class SceneCursorExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        //scene.setCursor(Cursor.DEFAULT);

        scene.setCursor(Cursor.CROSSHAIR);
        //scene.setCursor(Cursor.DISAPPEAR);

        //scene.setCursor(Cursor.CLOSED_HAND);
        //scene.setCursor(Cursor.HAND);
        //scene.setCursor(Cursor.OPEN_HAND);

        //scene.setCursor(Cursor.V_RESIZE);
        //scene.setCursor(Cursor.H_RESIZE);

        //scene.setCursor(Cursor.N_RESIZE);
        //scene.setCursor(Cursor.NE_RESIZE);
        //scene.setCursor(Cursor.E_RESIZE);
        //scene.setCursor(Cursor.SE_RESIZE);
        //scene.setCursor(Cursor.S_RESIZE);
        //scene.setCursor(Cursor.SW_RESIZE);
        //scene.setCursor(Cursor.W_RESIZE);
        //scene.setCursor(Cursor.NW_RESIZE);

        primaryStage.setTitle("Scene Example");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
