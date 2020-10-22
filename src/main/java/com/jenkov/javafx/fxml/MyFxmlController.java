package com.jenkov.javafx.fxml;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyFxmlController {

    private String value = "Default value";

    public Label label1 = null;
    public Label label2 = null;



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void initialize() {
        System.out.println("Initialized MyFxmlController");
    }

    public String getLabel1Text() {
        return this.label1.getText();
    }

    public String getLabel2Text() {
        return this.label2.getText();
    }

    @FXML
    public void buttonClicked(Event e){
        System.out.println("Button clicked");
    }
}
