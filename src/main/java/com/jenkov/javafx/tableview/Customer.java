package com.jenkov.javafx.tableview;

public class Customer {
    private String customerNo = null;
    private String firstName = null;
    private String lastName = null;


    public Customer(String customerNo, String firstName, String lastName){
        this.customerNo = customerNo;
        this.firstName  = firstName;
        this.lastName   = lastName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
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
}
