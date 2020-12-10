package com.jenkov.javafx.gfx3d;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Gfx3DExampleDraft extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        boolean is3DSupported = Platform.isSupported(ConditionalFeature.SCENE3D);
        if(!is3DSupported) {
           System.out.println("Sorry, 3D is not supported in JavaFX on this platform.");
           return;
        }

        Box box = new Box(100,100,100);
        box.setCullFace(CullFace.NONE);
        box.setTranslateX(450);
        box.setTranslateY(100);
        box.setTranslateZ(400);

        boolean fixedEyeAtCameraZero = false;
        PerspectiveCamera camera = new PerspectiveCamera(fixedEyeAtCameraZero);
        camera.setTranslateX(100);
        camera.setTranslateY(-75);
        camera.setTranslateZ(300);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), camera);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setAxis(Rotate.X_AXIS);
        rotateTransition.play();

        PointLight redLight = new PointLight();
        redLight.setColor(Color.valueOf("#ff0000"));
        redLight.setTranslateX(250);
        redLight.setTranslateY(-100);
        redLight.setTranslateZ(250);

        PointLight greenLight = new PointLight();
        greenLight.setColor(Color.valueOf("#00ff00"));
        greenLight.setTranslateX(275);
        greenLight.setTranslateY(325);
        greenLight.setTranslateZ(325);

        Group root = new Group(box, redLight, greenLight);
        root.setRotationAxis(Rotate.X_AXIS);
        root.setRotate(70);

        Scene scene = new Scene(root, 500, 300, true); //true = use depth buffer in Scene
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D Example");

        primaryStage.show();
    }
}