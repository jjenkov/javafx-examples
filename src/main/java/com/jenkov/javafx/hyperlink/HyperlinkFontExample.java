package com.jenkov.javafx.hyperlink;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HyperlinkFontExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        Hyperlink link = new Hyperlink("Click Me!");

        Font courierNewFontBold36 = Font.font("Courier New", FontWeight.BOLD, 36);

        link.setFont(courierNewFontBold36);

        link.setOnAction((event) -> {
            System.out.println("Hyperlink clicked");
        });

        VBox vBox = new VBox(link);
        Scene scene = new Scene(vBox, 200, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
