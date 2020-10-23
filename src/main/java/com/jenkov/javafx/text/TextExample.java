package com.jenkov.javafx.text;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Text text = new Text("This is a JavaFX text. Line 2");
        //text.setWrappingWidth(80);
        //text.setStrikethrough(true);
        //text.setUnderline(true);
        text.setFontSmoothingType(FontSmoothingType.GRAY);
        text.setFontSmoothingType(FontSmoothingType.LCD);

        Text text2 = new Text();
        text2.setText("123");

        text2.setFont(Font.font("Arial"));
        text2.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        text.setFill(Color.DARKMAGENTA);
        //text.setStroke(Color.GREEN);

        text.setX(0);
        text.setY(20);

        text.setTextOrigin(VPos.BASELINE);

        //Scene scene = new Scene(new VBox(text), 300, 250);
        Scene scene = new Scene(new Pane(text), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}