package com.jenkov.javafx.gfx3d;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Gfx3DExperiments extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws InterruptedException {

        boolean is3DSupported = Platform.isSupported(ConditionalFeature.SCENE3D);
        if(!is3DSupported) {
           System.out.println("Sorry, 3D is not supported in JavaFX on this platform.");
           return;
        }

        Box box1 = Gfx3DUtil.createBox(100, 100, 100, 250, 100, 200);
        Box box2 = Gfx3DUtil.createBox(100, 100, 100, 300, 150, 400);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.TEAL);
        box2.setMaterial(material);

        PerspectiveCamera camera = Gfx3DUtil.createPerspectiveCamera(false, 150, -100, 250);

        Group root = new Group(box1, box2);
        //root.setRotationAxis(Rotate.X_AXIS);
        //root.setRotate(30);

        Scene scene = new Scene(root, 500, 300, true);
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D Example");

        primaryStage.setX(200);

        primaryStage.show();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                Platform.runLater(() -> {
                    camera.setRotationAxis(Rotate.X_AXIS);
                    camera.setRotate(10);
                });
                Thread.sleep(1000);
                Platform.runLater(() -> {
                    camera.setRotationAxis(Rotate.X_AXIS);
                    camera.setRotate(20);
                });
                Thread.sleep(1000);
                Platform.runLater(() -> {
                    camera.setRotationAxis(Rotate.X_AXIS);
                    camera.setRotate(30);
                });
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }

        });
        thread.start();

        /*
        Thread.sleep(1000);
        Platform.runLater(() -> { camera.setRotationAxis(Rotate.X_AXIS); camera.setRotate(10);});
        Thread.sleep(1000);
        Platform.runLater(() -> { camera.setRotationAxis(Rotate.X_AXIS); camera.setRotate(20);});
        Thread.sleep(1000);
        Platform.runLater(() -> { camera.setRotationAxis(Rotate.X_AXIS); camera.setRotate(30);});
         */
    }


}