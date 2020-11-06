package com.jenkov.javafx.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX Canvas.
 */
public class CanvasExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Canvas canvas = new Canvas();
        canvas.setHeight(512);
        canvas.setWidth(512);

        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();

        graphicsContext2D.setFill(Color.valueOf("#ff0000"));
        graphicsContext2D.fillRect(100, 100, 200, 200);

        VBox vbox = new VBox(canvas);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
