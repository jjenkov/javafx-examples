package com.jenkov.javafx.font;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.List;

public class FontExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        //Font creation examples. The Font instances are not used. Examples illustrate instantiation only.
        String      fontFamily  = "Arial";
        double      fontSize    = 13;
        FontWeight  fontWeight  = FontWeight.BOLD;
        FontPosture fontPosture = FontPosture.ITALIC;

        Font font1 = Font.font(fontFamily);
        Font font2 = Font.font(fontSize);
        Font font3 = Font.font(fontFamily, fontSize);
        Font font4 = Font.font(fontFamily, fontWeight , fontSize);
        Font font5 = Font.font(fontFamily, fontPosture, fontSize);
        Font font6 = Font.font(fontFamily, fontWeight , fontPosture, fontSize);


        //Font instances in use - examples
        Font arialFont        = Font.font("Arial");
        Font arialFontBold36  = Font.font("Arial", FontWeight.BOLD, 36);

        Text textArial        = createText("Text in Arial", arialFont, 0, 30);
        Text textArialBold36  = createText("Text in Arial Bold 36", arialFontBold36, 0, 70);

        Font robotoFont       = Font.font("Roboto");
        Font robotoFontBold36 = Font.font("Roboto", FontWeight.BOLD, 36);

        Text textRoboto       = createText("Text in Roboto", robotoFont, 0, 100);
        Text textRobotoBold36 = createText("Text in Roboto Bold 36", robotoFontBold36, 0, 140);

        Font courierNewFont       = Font.font("Courier New");
        Font courierNewFontBold36 = Font.font("Courier New", FontWeight.BOLD, 36);

        Text textCourierNew       = createText("Text in Courier New", courierNewFont, 0, 180);
        Text textCourierNewBold36 = createText("Text in Courier New Bold 36", courierNewFontBold36, 0, 220);


        Pane pane = new Pane();
        pane.getChildren().add(textArial);
        pane.getChildren().add(textArialBold36);
        pane.getChildren().add(textRoboto);
        pane.getChildren().add(textRobotoBold36);
        pane.getChildren().add(textCourierNew);
        pane.getChildren().add(textCourierNewBold36);

        Scene scene = new Scene(pane, 600, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        List<String> fontFamilies = Font.getFamilies();
        List<String> fontNames    = Font.getFontNames();

        System.out.println("=====================");
        System.out.println("Font families: " + fontFamilies.size());
        System.out.println("=====================");
        printList(fontFamilies);
        System.out.println("=====================");
        System.out.println("Font names: " + fontNames.size());
        System.out.println("=====================");
        printList(fontNames);

    }

    private void printList(List<String> list) {
        for(String item : list) {
            System.out.println(item);
        }
    }

    private Text createText(String textToDisplay, Font font, double x, double y) {
        Text text = new Text(textToDisplay);
        text.setFontSmoothingType(FontSmoothingType.GRAY);
        text.setFont(font);
        text.setFill(Color.DARKMAGENTA);
        text.setTextOrigin(VPos.BASELINE);

        text.setX(x);
        text.setY(y);

        return text;
    }
}