package com.jenkov.javafx.titledpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitledPaneExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("The content inside the TitledPane");
        TitledPane titledPane = new TitledPane("The Title", label);
        titledPane.setCollapsible(false);

        titledPane.setExpanded(true);
        titledPane.setExpanded(false);

        Scene scene = new Scene(new VBox(titledPane));
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}