package org.example.entity;

import org.example.abstractClasses.Person;
import org.example.abstractClasses.Property;
import org.example.exception.EmptyMessageComplainException;
import org.example.interfaces.Icomplain;

public class PropertyOwner extends Person implements Icomplain {



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

    @Override
    public void sendComplain(Complain complain) throws EmptyMessageComplainException {
        if(complain.getMessage() == null){
            throw new EmptyMessageComplainException("Message cannot be null");
        }
    }
}
