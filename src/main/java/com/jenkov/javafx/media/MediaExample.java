package com.jenkov.javafx.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Shows a simple JavaFX Media, MediaPlayer and MediaView example, playing an MP4 video. Please note that the
 * video is downloaded from Pixabay.com. Please do not redistribute the video for any purpose. Download it from Pixabay
 * if you want to use it:
 *
 * https://pixabay.com/videos/golden-particles-overlay-decoration-48569/
 */

public class MediaExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws MalformedURLException {
        File mediaFile = new File("assets/media/Golden-48569.mp4");
        Media media = new Media(mediaFile.toURI().toURL().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        MediaView mediaView = new MediaView(mediaPlayer);

        Scene scene = new Scene(new Pane(mediaView), 1024, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

        mediaPlayer.play();

    }
}