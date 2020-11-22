package com.jenkov.javafx.transformations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class TransformationsExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Rectangle rectangle = new Rectangle();
        rectangle.setX(200);
        rectangle.setY(200);
        rectangle.setWidth(300);
        rectangle.setHeight(400);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.valueOf("#00ffff"));

        double degrees = 30;
        double rotationPointX = 100;
        double rotationPointY = 100;
        Transform rotate = Transform.rotate(degrees, rotationPointX, rotationPointY);
        rectangle.getTransforms().add(rotate);

        Transform translate = Transform.translate(100, 0);
        rectangle.getTransforms().add(translate);

        Pane pane = new Pane();
        pane.getChildren().add(rectangle);

        Scene scene = new Scene(pane, 1024, 800, true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D Example");

        primaryStage.show();
    }
}