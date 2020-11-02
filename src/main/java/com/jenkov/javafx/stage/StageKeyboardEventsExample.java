package com.jenkov.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageKeyboardEventsExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        Label label = new Label("This app will shut down automatically");
        VBox vbox = new VBox(label);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(100);
        primaryStage.show();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            System.out.println("Key pressed: " + event.toString());

            switch(event.getCode().getCode()) {
                case 27 : { // 27 = ESC key
                    primaryStage.close();
                    break;
                }
                case 10 : { // 10 = Return
                    primaryStage.setWidth( primaryStage.getWidth() * 2);
                }
                default:  {
                    System.out.println("Unrecognized key");
                }
            }
        });
    }
}
