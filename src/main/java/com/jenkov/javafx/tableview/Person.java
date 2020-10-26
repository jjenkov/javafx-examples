package com.jenkov.javafx.tableview;

public class Person {

    private String firstName = null;
    private String lastName = null;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "{ firstName: '" + this.firstName + ", lastName: " + this.lastName + " }";
    }
}
