package org.example;

public class Room {

    private House house;

    private double price;

    private boolean status; //true = rented, false= to rent

    private Tenant tenant;

    private double rentPrice;

    public Room(House house, double price, boolean status, Tenant tenant, double rentPrice) {
        this.house = house;
        this.price = price;
        this.status = status;
        this.tenant = tenant;
        this.rentPrice = rentPrice;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }
}
