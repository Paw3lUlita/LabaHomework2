package org.example.entity;

import org.example.exception.EmptyMessageComplainException;
import org.example.interfaces.Icomplain;

public class Tenant extends Person implements Icomplain {

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

    @Override
    public void sendComplain(Complain complain) throws EmptyMessageComplainException {
        if (complain.getMessage() == null){
            throw new EmptyMessageComplainException("Message cannot be empty");
        }
    }
}
