package com.jenkov.javafx.transformations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TranslateTransformationExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        ImageView imageViewOriginal  = createImageView();
        ImageView imageViewTranslated = createImageView();

        Translate translateTransform = new Translate();
        translateTransform.setX(200);
        translateTransform.setY(100);

        imageViewTranslated.getTransforms().add(translateTransform);

        Pane pane = new Pane();
        pane.getChildren().add(imageViewTranslated);
        pane.getChildren().add(imageViewOriginal);

        Scene scene = new Scene(pane, 1024, 800, true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D Example");

        primaryStage.show();
    }

    private ImageView createImageView() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("assets/media/abstract-5719221_640.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        return imageView;
    }

}