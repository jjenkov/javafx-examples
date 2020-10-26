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

/*
    Mouse wheel zoom by Friedhold Matz @FriedholdMatz :

        // --- Scroll Zooming ---
        webView.addEventFilter(ScrollEvent.SCROLL, (ScrollEvent e) -> {
            double deltaY = e.getDeltaY();
            if (e.isControlDown() && deltaY > 0) {
                webView.setZoom(webView.getZoom() * 1.1);
                e.consume();
            } else if (e.isControlDown() && deltaY < 0) {
                webView.setZoom(webView.getZoom() / 1.1);
                e.consume();
            }
        });
 */

public class WebViewExample extends Application {

    public static class MyObject {

        public void doIt() {
            System.out.println("doIt() called");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX WebView Example");

        WebView webView = new WebView();
        //webView.setZoom(2.25);
        webView.setFontScale(1.25);
        webView.setContextMenuEnabled(false);

        WebEngine webEngine = webView.getEngine();
        webEngine.setUserStyleSheetLocation("stylesheet.css");

        //webEngine.load("http://google.com");
        webEngine.loadContent("<!DOCTYPE html><html><body>Hello World!<script type=\"text/javascript\">function hmm() { return 'Hey!'; }; document.write(hmm()); </script><button onclick='window.myObject.doIt();'>Do It</button></body></html>", "text/html");

        try {
            Thread.sleep(0001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webEngine.setUserAgent("MyApp Web Browser 1.0");

        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    System.out.println("oldValue: " + oldValue);
                    System.out.println("newValue: " + newValue);

                    if (newValue != Worker.State.SUCCEEDED) {
                        return;
                    }
                    System.out.println("Succeeded!");
                    String hello = (String) webEngine.executeScript("hmm()");
                    System.out.println("hello: " + hello);

                    JSObject window = (JSObject) webEngine.executeScript("window");
                    window.setMember("myObject", new MyObject());

                    Document document = webEngine.getDocument();
                }
            }
        );

        //String result = (String) webEngine.executeScript("hmm()");
        //System.out.println(result);

        //webEngine.reload();

        //historyExamples(webEngine);

        VBox vBox = new VBox(webView);
        //HBox hBox = new HBox(button1, button2);
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