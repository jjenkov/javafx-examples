package com.jenkov.javafx.color;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        double red   = 1.0;
        double green = 0.8;
        double blue  = 0.6;
        double alpha = 1.0;

        Color color  = new Color(red, green, blue, alpha);
        Color color1  = Color.web("#ff00ff");
        Color color1_1  = Color.web("hsl(270,100%,100%)");
        Color color2  = Color.web("#ff00ff", 0.5);
        Color color3  = Color.rgb(255, 0, 255);
        Color color4  = Color.rgb(255, 0, 255, 0.5);
        Color color5  = Color.grayRgb(255);
        Color color6  = Color.grayRgb(255, 0.5);
        Color color7  = Color.hsb(1.0, 0.5, 0.8);
        Color color8  = Color.hsb(1.0, 0.5, 0.8, 0.5);
        Color color9  = Color.color(1.0, 0.0, 1.0);
        Color color10 = Color.color(1.0, 0.0, 1.0, 0.5);

        Pane pane = new Pane();
        pane.setPrefWidth(300);
        pane.setPrefHeight(300);

        Background background = new Background(new BackgroundFill(color1_1, null, null));
        pane.setBackground(background);

        VBox vBox = new VBox(pane);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}