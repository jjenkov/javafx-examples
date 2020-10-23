package com.jenkov.javafx.treeview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        TreeItem rootItem = new TreeItem("Tutorials");

        TreeItem webItem = new TreeItem("Web Tutorials");
        webItem.getChildren().add(new TreeItem("HTML  Tutorial"));
        webItem.getChildren().add(new TreeItem("HTML5 Tutorial"));
        webItem.getChildren().add(new TreeItem("CSS Tutorial"));
        webItem.getChildren().add(new TreeItem("SVG Tutorial"));
        rootItem.getChildren().add(webItem);

        TreeItem javaItem = new TreeItem("Java Tutorials");
        javaItem.getChildren().add(new TreeItem("Java Language"));
        javaItem.getChildren().add(new TreeItem("Java Collections"));
        javaItem.getChildren().add(new TreeItem("Java Concurrency"));
        rootItem.getChildren().add(javaItem);

        TreeView treeView = new TreeView();
        treeView.setRoot(rootItem);

        treeView.setShowRoot(false);


        VBox vbox = new VBox(treeView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
