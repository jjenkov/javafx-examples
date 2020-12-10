package com.jenkov.javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class AutoResponsiveLayoutExample extends Application {

    private int widgetCount = 0;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        //scrollPane.fitToHeightProperty().set(true);

        scrollPane.setPrefHeight(1024);

        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Pane containerPane = new Pane();
        scrollPane.setContent(containerPane);
        AutoResponsiveLayout autoResponsiveLayout = new AutoResponsiveLayout(containerPane, scrollPane);

        ToolBar toolbar = createToolBar(containerPane, autoResponsiveLayout);

        //VBox vBox = new VBox(toolbar, containerPane);
        VBox vBox = new VBox(toolbar, scrollPane);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);

        primaryStage.setWidth(1024);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Auto-responsive Layout Example");

        primaryStage.show();
    }

    private ToolBar createToolBar(Pane containerPane, AutoResponsiveLayout autoResponsiveLayout) {
        ToolBar toolbar = new ToolBar();

        addButton(autoResponsiveLayout, toolbar, "1x1", 256, 256);
        addButton(autoResponsiveLayout, toolbar, "2x1", 512, 256);
        addButton(autoResponsiveLayout, toolbar, "1x2", 256, 512);
        addButton(autoResponsiveLayout, toolbar, "2x2", 512, 512);

        toolbar.getItems().add(new Separator());

        ToggleButton toggleButton2 = new ToggleButton("Balance Rows");
        toggleButton2.setOnAction((event) -> {
            autoResponsiveLayout.balanceRows = !autoResponsiveLayout.balanceRows;
            autoResponsiveLayout.layoutPane();
        });

        toolbar.getItems().add(toggleButton2);

        ToggleButton toggleButton1 = new ToggleButton("Pull Up Children");
        toggleButton1.setOnAction((event) -> {
            autoResponsiveLayout.pullUpChildren = !autoResponsiveLayout.pullUpChildren;
            autoResponsiveLayout.layoutPane();
        });

        toolbar.getItems().add(toggleButton1);

        ToggleButton toggleButton3 = new ToggleButton("Expand Child Width");
        toggleButton3.setOnAction((event) -> {
            autoResponsiveLayout.extendChildWidth = !autoResponsiveLayout.extendChildWidth;
            autoResponsiveLayout.layoutPane();
        });

        toolbar.getItems().add(toggleButton3);

        ToggleButton toggleButton4 = new ToggleButton("Expand Child Height");
        toggleButton4.setOnAction((event) -> {
            autoResponsiveLayout.extendChildHeight = !autoResponsiveLayout.extendChildHeight;
            autoResponsiveLayout.layoutPane();
        });

        toolbar.getItems().add(toggleButton4);

        toolbar.getItems().add(new Separator());

        ToggleButton toggleButton5 = new ToggleButton("Clear");
        toggleButton5.setOnAction((event) -> {
            autoResponsiveLayout.clear();
            autoResponsiveLayout.layoutPane();
        });
        toolbar.getItems().add(toggleButton5);


        return toolbar;
    }

    private void addButton(AutoResponsiveLayout autoResponsiveLayout, ToolBar toolbar, String buttonText, double minWidth, double minHeight) {
        Button buttonAdd = new Button(buttonText);

        buttonAdd.setOnAction((event) -> {
            Pane widgetPane = createWidgetPane(minWidth, minHeight);
            autoResponsiveLayout.addWidget(widgetPane);
            autoResponsiveLayout.layoutPane();
        });

        toolbar.getItems().add(buttonAdd);
    }

    private Pane createWidgetPane(double minWidth, double minHeight) {
        this.widgetCount++;

        Pane widgetPane = new Pane();
        widgetPane.setMinWidth(minWidth);
        widgetPane.setMinHeight(minHeight);

        StrokeType     strokeType     = StrokeType.INSIDE;
        StrokeLineJoin strokeLineJoin = StrokeLineJoin.MITER;
        StrokeLineCap  strokeLineCap  = StrokeLineCap.BUTT;
        double         miterLimit     = 10;
        double         dashOffset     = 0;
        List<Double> dashArray      = null;

        BorderStrokeStyle borderStrokeStyle =
                new BorderStrokeStyle(
                        strokeType,
                        strokeLineJoin,
                        strokeLineCap,
                        miterLimit,
                        dashOffset,
                        dashArray
                );


        BorderStroke borderStroke =
                new BorderStroke(
                        //Color.valueOf("08ff80"),
                        Color.valueOf("#303F9F"),
                        borderStrokeStyle,
                        new CornerRadii(0),
                        new BorderWidths(8)
                );

        Border border = new Border(borderStroke);

        Label label = new Label("" + this.widgetCount);
        label.setFont(Font.font("Arial", FontWeight.BOLD , FontPosture.REGULAR, 32));
        label.setLayoutX(20);
        label.setLayoutY(20);
        widgetPane.getChildren().add(label);
        widgetPane.setBorder(border);
        return widgetPane;
    }
}