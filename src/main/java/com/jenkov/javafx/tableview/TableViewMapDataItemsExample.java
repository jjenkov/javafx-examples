package com.jenkov.javafx.tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class TableViewMapDataItemsExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TableView tableView = new TableView();

        ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();

        Map<String, Object> item1 = new HashMap<>();
        item1.put("firstName", "Randall");
        item1.put("lastName" , "Kovic");

        items.add(item1);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("firstName", "Irmelin");
        item2.put("lastName" , "Satoshi");

        items.add(item2);

        tableView.getItems().addAll(items);

        TableColumn<Map, String> firstNameColumn = new TableColumn<>("firstName");
        firstNameColumn.setCellValueFactory(new MapValueFactory<>("firstName"));

        TableColumn<Map, String> lastNameColumn = new TableColumn<>("lastName");
        lastNameColumn.setCellValueFactory(new MapValueFactory<>("lastName"));

        tableView.getColumns().add(firstNameColumn);
        tableView.getColumns().add(lastNameColumn);

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX TableView Example");

        primaryStage.show();
    }
}
