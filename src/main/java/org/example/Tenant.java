package org.example;

public class Tenant extends Person{


    private House house;

    private String accountNumber;

    public Tenant(String name, String surname, String phoneNumber,
                  String email, House house, String accountNumber) {
        super(name, surname, phoneNumber, email);
        this.house = house;
        this.accountNumber = accountNumber;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
