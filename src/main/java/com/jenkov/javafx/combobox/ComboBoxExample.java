package com.jenkov.javafx.combobox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX Button - and prints a text when the button is clicked.
 */
public class ComboBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Choice 0");
        comboBox.getItems().add("Choice 1");
        comboBox.getItems().add("Choice 2");

        comboBox.setEditable(true);

        comboBox.setOnAction((event) -> {
            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = comboBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ChoiceBox.getValue(): " + comboBox.getValue());
        });

        VBox vbox = new VBox(comboBox);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("ComboBox Example");
        primaryStage.show();
    }

}
