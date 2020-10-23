package com.jenkov.javafx.toolbar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToolBarExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        ToolBar toolBar = new ToolBar();

        Button button1 = new Button("Button 1");
        toolBar.getItems().add(button1);

        toolBar.getItems().add(new Separator());

        Button button2 = new Button("Button 2");
        toolBar.getItems().add(button2);

        VBox vBox = new VBox(toolBar);

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
