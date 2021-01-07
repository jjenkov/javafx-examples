package com.jenkov.javafx.tableview;

public class Person {

    private String firstName = null;
    private String lastName = null;

    private String category = null;

    private boolean isXyz = true;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String category, boolean isXyz) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.category  = category;
        this.isXyz     = isXyz;
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


    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsXyz() {
        return this.isXyz;
    }

    public void setIsXyz(Boolean isXyz) {
        this.isXyz = isXyz;
    }
}
