package com.jenkov.javafx.button;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ButtonFXMLController {

    public Button button1 = null;
    private int   button1ClickCount = 0;

    @FXML
    public void buttonClicked(Event e){
        this.button1ClickCount++;

        String text = "Button1 clicked " + this.button1ClickCount + " times";

        System.out.println(text);

        button1.setText(text);
    }

}
