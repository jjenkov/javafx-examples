package com.jenkov.javafx.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ScrollPaneExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("JavaFX App");

        //String imagePath = "file://E:/video-projects/tutorials/java-switch-expression/assets/aerial-beverage-caffeine-972533.jpg";

        //choose the path for some large image on your hard disk here.
        String imagePath = "images/aerial-beverage-caffeine-972533.jpg";
        ImageView imageView = new ImageView(new Image(new FileInputStream(imagePath)));

        //ScrollPane scrollPane = new ScrollPane(imageView);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.pannableProperty().set(true);

        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);

        scrollPane.setContent(imageView);


        VBox vBox = new VBox(scrollPane);
        //HBox hBox = new HBox(button1, button2);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
