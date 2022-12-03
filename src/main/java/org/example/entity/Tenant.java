package org.example.entity;

public class Tenant extends Person{


    private Property property;

    private String accountNumber;

    public Tenant(String name, String surname, String phoneNumber,
                  String email, String accountNumber) {
        super(name, surname, phoneNumber, email);
        this.accountNumber = accountNumber;
    }

    public Tenant() {}

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
