package com.jenkov.javafx.tableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewNestedColumnsExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {

        TableView tableView = new TableView();

        TableColumn<Customer, String> customer = new TableColumn<>("Customer");

        TableColumn<Customer, String> customerId = new TableColumn<>("Customer No");

        TableColumn<Customer, String> name       = new TableColumn<>("Name");
        TableColumn<Customer, String> firstName  = new TableColumn<>("First Name");
        TableColumn<Customer, String> lastName   = new TableColumn<>("Last Name");

        name.getColumns().addAll(firstName, lastName);
        customer.getColumns().addAll(customerId, name);
        tableView.getColumns().addAll(customer);

        customerId.setCellValueFactory(new PropertyValueFactory<>("customerNo"));
        firstName .setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName  .setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getItems().add(new Customer("007", "Jane", "Deer"));
        tableView.getItems().add(new Customer("006", "John", "Doe"));
        tableView.getItems().add(new Customer("008", "Mack", "Alamo"));

        TableColumn<String, Customer> visibleLeafColumn = tableView.getVisibleLeafColumn(1);

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX TableView Nested Columns Example");

        primaryStage.show();
    }

}

