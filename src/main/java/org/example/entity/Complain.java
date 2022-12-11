package org.example.entity;

import java.util.Objects;

public class Complain {
    private String message;

    private Person sender;

    private Person receiver;

    public Complain(String message, Person sender, Person receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Complain() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return String.format("Complain from: %s \n to: %s \n message: \n %s", sender.getName(), receiver.getName(), message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complain complain)) return false;
        return Objects.equals(getMessage(), complain.getMessage()) && Objects.equals(sender, complain.sender) && Objects.equals(receiver, complain.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), sender, receiver);
    }
}
