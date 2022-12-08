package org.example.entity;

import java.util.Objects;

public class Complain {

    private String message;

    private Person fromWho;

    private Person toWho;

    public Complain(String message, Person fromWho, Person toWho) {
        this.message = message;
        this.fromWho = fromWho;
        this.toWho = toWho;
    }

    public Complain() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getFromWho() {
        return fromWho;
    }

    public void setFromWho(Person fromWho) {
        this.fromWho = fromWho;
    }

    public Person getToWho() {
        return toWho;
    }

    public void setToWho(Person toWho) {
        this.toWho = toWho;
    }

    @Override
    public String toString() {
        return String.format("Complain from: %s \n to: %s \n message: \n %s", fromWho.getName(), toWho.getName(), message);
    }


}
