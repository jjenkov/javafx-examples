package com.jenkov.javafx.splitmenubutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SplitMenuButtonFontExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        SplitMenuButton button = new SplitMenuButton();
        button.setText("Click here!");

        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        button.setFont(font);

        button.setOnAction((e) -> {
            System.out.println("Button clicked!");
            System.out.println(e);
            System.out.println();
        });

        MenuItem choice1 = new MenuItem("Choice 1");
        MenuItem choice2 = new MenuItem("Choice 2");
        MenuItem choice3 = new MenuItem("Choice 3");

        choice1.setOnAction((e)-> {
            System.out.println("Choice 1 selected");
        });
        choice2.setOnAction((e)-> {
            System.out.println("Choice 2 selected");
        });
        choice3.setOnAction((e)-> {
            System.out.println("Choice 3 selected");
        });

        button.getItems().addAll(choice1, choice2, choice3);

        VBox vBox = new VBox(button);
        //HBox hBox = new HBox(button1, button2);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
