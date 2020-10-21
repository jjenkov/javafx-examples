package com.jenkov.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a Stage in full screen mode. Use ESC key to exit full screen mode.
 */
public class FullScreenStageExample  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        //Notice that the Stage title is not visible in full screen mode
        primaryStage.setTitle("Full Screen Window Title");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

        primaryStage.show();
    }


}
