package com.jenkov.javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class FXMLExample extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        MyFxmlController controller = new MyFxmlController();
        controller.setValue("New value");

        loader.setController(controller);
        loader.setLocation(new URL("file:///C:/data/projects/tutorial-projects/javafx-9-examples/src/main/resources/com.jenkov.javafx/hello-world.fxml"));
        VBox vbox = loader.<VBox>load();

        MyFxmlController controllerRef = loader.getController();
        System.out.println(controllerRef.getValue());
        System.out.println(controllerRef.getLabel1Text());
        System.out.println(controllerRef.getLabel2Text());

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
