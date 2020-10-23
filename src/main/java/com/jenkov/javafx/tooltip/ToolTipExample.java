package com.jenkov.javafx.tooltip;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ToolTipExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        Tooltip tooltip1 = new Tooltip("Creates a new file");
        //tooltip1.setMinWidth(300);
        tooltip1.setTextAlignment(TextAlignment.LEFT);
        tooltip1.setGraphic(new ImageView("file:iconmonstr-basketball-1-16.png"));



        Button button1 = new Button("New");
        button1.setTooltip(tooltip1);

        /*
        Button button2 = new Button("Open");
        Tooltip tooltip2 = new Tooltip("Opens an existing file from your local computer");
        button2.setTooltip(tooltip2);
        */

        HBox hBox = new HBox(button1);
        //HBox hBox = new HBox(button1, button2);
        Scene scene = new Scene(hBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
