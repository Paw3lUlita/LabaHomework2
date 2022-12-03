package org.example.entity;

public class PropertyOwner extends Person{



    private Property property;

    private String accountNumber;


    public PropertyOwner(String name, String surname, String phoneNumber, String email, Property property, String accountNumber) {
        super(name, surname, phoneNumber, email);
        this.property = property;
        this.accountNumber = accountNumber;
    }

    public PropertyOwner() {}

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
