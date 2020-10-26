package com.jenkov.javafx.tableview;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class TableViewSelectionModelExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException, FileNotFoundException {

        TableView tableView = new TableView();

        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.getItems().add(new Person("John", "Doe"));
        tableView.getItems().add(new Person("Jane", "Deer"));



        TableView.TableViewSelectionModel<Person> selectionModel = tableView.getSelectionModel();

        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        ObservableList<Person> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                System.out.println("Selection changed: " + change.getList());
            }
        });

        selectionModel.select(1);

        ObservableList<Integer> selectedIndices = selectionModel.getSelectedIndices();


        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX TableView Example");

        primaryStage.show();
    }
}
