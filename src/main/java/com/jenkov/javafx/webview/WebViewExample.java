package com.jenkov.javafx.webview;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;

import java.util.Date;
import java.util.Iterator;

public class WebViewExample extends Application {

     public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX WebView Example");

        WebView webView = new WebView();
        //webView.setZoom(2.25);
        //webView.setFontScale(1.25);
        //webView.setContextMenuEnabled(false);

        WebEngine webEngine = webView.getEngine();
        //webEngine.setUserStyleSheetLocation("assets/webview/stylesheet.css");

        //webEngine.load("http://tutorials.jenkov.com");
        webEngine.loadContent("<!DOCTYPE html><html><body>Hello World!</body></html>", "text/html");

        webEngine.setUserAgent("MyApp Web Browser 1.0");

        //webEngine.reload();

        //historyExamples(webEngine);

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void historyExamples(WebEngine webEngine) {
        WebHistory history = webEngine.getHistory();

        ObservableList<WebHistory.Entry> entries = history.getEntries();

        Iterator<WebHistory.Entry> iterator = entries.iterator();
        while(iterator.hasNext()){
            WebHistory.Entry entry = iterator.next();
        }
        for(WebHistory.Entry entry : entries){
            //do something with the entry
            String url           = entry.getUrl();
            String title         = entry.getTitle();
            Date lastVisitedDate = entry.getLastVisitedDate();
        }

        history.go(1);
        history.go(-1);

        int currentIndex = history.getCurrentIndex();
    }
}