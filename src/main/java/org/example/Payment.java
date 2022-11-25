package org.example;

import java.time.LocalDateTime;

public class Payment {

    private LocalDateTime dateOfPayment;

    private Tenant sender;

    private HouseOwner receiver;

    private double amount;


    public Payment(LocalDateTime dateOfPayment, Tenant sender, HouseOwner receiver, double amount) {
        this.dateOfPayment = dateOfPayment;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Tenant getSender() {
        return sender;
    }

    public void setSender(Tenant sender) {
        this.sender = sender;
    }

    public HouseOwner getReceiver() {
        return receiver;
    }

    public void setReceiver(HouseOwner receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
