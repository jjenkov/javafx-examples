package com.jenkov.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This example shows two Stages at the same time - in modal mode.
 * This means, that the second Stage blocks access to the first while the second Stage is visible/open.
 * Notice how you cannot click the Button that is visible in the primary Stage while the secondary Stage is
 * open.
 *
 */
public class MultipleStagesModalExample extends Application  {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Click me if you can...");
        button.setOnAction((event) -> {
            System.out.println("Button clicked");
        });

        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Primary Stage");
        primaryStage.setX(250);
        primaryStage.setY(250);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("Secondary Stage - in Modal Mode");
        stage.setX(300);
        stage.setY(300);
        stage.setWidth(300);
        stage.setHeight(300);

        stage.initOwner(primaryStage);
        //stage.initModality(Modality.NONE);
        stage.initModality(Modality.WINDOW_MODAL);
        //stage.initModality(Modality.APPLICATION_MODAL);


        stage.showAndWait();
    }



}
