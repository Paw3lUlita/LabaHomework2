package org.example;

import java.time.LocalDateTime;

public class Payment {

    private LocalDateTime dateOfPayment;

    private String accountFrom;

    private String accountTo;

    public Payment(LocalDateTime dateOfPayment, String accountFrom, String accountTo) {
        this.dateOfPayment = dateOfPayment;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }
}
