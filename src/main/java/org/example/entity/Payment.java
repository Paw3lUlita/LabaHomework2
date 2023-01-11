package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {

    private LocalDateTime dateOfPayment;

    private Tenant sender;

    private PropertyOwner receiver;

    private double amount;


    public Payment(LocalDateTime dateOfPayment, Tenant sender, PropertyOwner receiver, double amount) {
        this.dateOfPayment = dateOfPayment;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Payment() {}

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

    public PropertyOwner getReceiver() {
        return receiver;
    }

    public void setReceiver(PropertyOwner receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Payment from %s to %s \n amount: %s \n date: %s",
                sender.getName(), receiver.getName(), amount, dateOfPayment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Double.compare(payment.getAmount(), getAmount()) == 0 && Objects.equals(getDateOfPayment(), payment.getDateOfPayment()) && Objects.equals(getSender(), payment.getSender()) && Objects.equals(getReceiver(), payment.getReceiver());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateOfPayment(), getSender(), getReceiver(), getAmount());
    }
}
