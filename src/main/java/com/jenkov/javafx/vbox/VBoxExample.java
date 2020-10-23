package com.jenkov.javafx.vbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1   = new Button("Button 1");
        button1.setMaxWidth(Double.MAX_VALUE);
        button1.setMaxHeight(Double.MAX_VALUE);
        Button button1_2 = new Button("Button 1.2");

        VBox vbox1 = new VBox(button1, button1_2);
        vbox1.setPrefHeight(100);
        vbox1.setAlignment(Pos.CENTER_LEFT);
        //VBox.setMargin(button1, new Insets(10, 10, 10, 10));
        VBox.setVgrow(button1, Priority.ALWAYS);
        vbox1.setFillWidth(true);


        vbox1.setStyle("-fx-border-style: solid inside;");

        VBox vbox2 = new VBox(new Button("Button 2"));
        vbox2.setAlignment(Pos.CENTER);

        VBox vbox3 = new VBox(new Button("Button 3"));
        vbox3.setAlignment(Pos.CENTER_RIGHT);


        Scene scene = new Scene(new VBox(vbox1, vbox2, vbox3));

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(400);

        primaryStage.show();
    }

}
