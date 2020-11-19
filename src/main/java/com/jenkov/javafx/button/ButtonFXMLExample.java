package com.jenkov.javafx.button;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

/**
 * Shows a simple JavaFX Button FXML example. The Button is declared in the assets/fxml/button-example.fxml file
 */
public class ButtonFXMLExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();

        ButtonFXMLController controller = new ButtonFXMLController();
        loader.setController(controller);

        File fxmlFile = new File("assets/fxml/button-example.fxml");
        URL fxmlUrl = fxmlFile.toURI().toURL();
        loader.setLocation(fxmlUrl);

        VBox vbox = loader.<VBox>load();
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Button FXML Example");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.show();
    }
}
