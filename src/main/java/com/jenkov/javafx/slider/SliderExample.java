package com.jenkov.javafx.slider;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        Slider slider = new Slider(0, 100, 0);

        slider.setMajorTickUnit(8);
        slider.setMinorTickCount(2);

        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);

        VBox vBox = new VBox(slider);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
