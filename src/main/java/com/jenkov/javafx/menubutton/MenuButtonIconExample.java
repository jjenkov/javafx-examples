package com.jenkov.javafx.menubutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Shows a simple JavaFX Button - and prints a text when the button is clicked.
 */
public class MenuButtonIconExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //load MenuButton icon
        ImageView imageView = loadIcon();

        MenuItem menuItem1 = new MenuItem("User 1");
        MenuItem menuItem2 = new MenuItem("User 2");

        //create MenuButton - pass ImageView via constructor
        MenuButton menuButton1 = new MenuButton("Show User", imageView, menuItem1, menuItem2);


        MenuItem menuItem2_1 = new MenuItem("User 1");
        MenuItem menuItem2_2 = new MenuItem("User 2");

        //second example - pass ImageView via setGraphic()
        ImageView imageView2 = loadIcon();
        MenuButton menuButton2 = new MenuButton("Show User", null, menuItem2_1, menuItem2_2);
        menuButton2.setGraphic(imageView2);


        VBox vbox = new VBox(menuButton1, menuButton2);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth (300);
        primaryStage.setHeight(300);
        primaryStage.show();
    }


    private ImageView loadIcon() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("assets/media/iconmonstr-user-1-32.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        return imageView;
    }


}
