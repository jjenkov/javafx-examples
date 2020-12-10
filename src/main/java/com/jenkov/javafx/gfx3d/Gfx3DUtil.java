package com.jenkov.javafx.gfx3d;

import javafx.scene.PerspectiveCamera;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;

public class Gfx3DUtil {

    public static PerspectiveCamera createPerspectiveCamera(
            boolean fixedEyeAtCameraZero, double x, double y, double z ) {
        PerspectiveCamera camera = new PerspectiveCamera(fixedEyeAtCameraZero);
        camera.setTranslateX(x);
        camera.setTranslateY(y);
        camera.setTranslateZ(z);
        return camera;
    }

    public static Box createBox(double width, double height, double depth, double x, double y, double z) {
        Box box = new Box(width, height, depth);
        box.setCullFace(CullFace.NONE);
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setTranslateZ(z);

        return box;
    }


}
