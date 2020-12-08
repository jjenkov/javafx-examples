package com.jenkov.javafx.hyperlink;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HyperlinkChangeTextExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        Hyperlink link = new Hyperlink("Click Me!");

        link.setText("New Link Text");

        link.setOnAction((event) -> {
            System.out.println("Hyperlink clicked");
        });

        VBox vBox = new VBox(link);
        Scene scene = new Scene(vBox, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
