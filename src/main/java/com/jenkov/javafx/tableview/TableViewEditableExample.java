package com.jenkov.javafx.tableview;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class TableViewEditableExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException, FileNotFoundException {

        TableView tableView = new TableView();
        tableView.setEditable(true);

        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        column2.setCellFactory(TextFieldTableCell.<Person>forTableColumn());

        TableColumn<Person, String> column3 = new TableColumn<>("Category");
        column3.setCellValueFactory(new PropertyValueFactory<>("category"));
        column3.setCellFactory(ComboBoxTableCell.<Person, String>forTableColumn("Category 1", "Category 2"));

        TableColumn<Person, Boolean> column4 = new TableColumn<>("Is XYZ");
        column4.setCellValueFactory( cellData -> new ReadOnlyBooleanWrapper(cellData.getValue().getIsXyz()));
        column4.setCellFactory(CheckBoxTableCell.<Person>forTableColumn(column4));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        tableView.getItems().add(new Person("John"  , "Doe"  , null, false));
        tableView.getItems().add(new Person("Jane"  , "Deer" , "Category 1", true));
        tableView.getItems().add(new Person("Dinesh", "Gupta", "Category 2", true));

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Editable TableView Example");

        primaryStage.show();

        System.out.println("Opened");
    }
}
