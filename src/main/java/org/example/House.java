package org.example;

import java.util.Objects;

public class House {

    private String address;

    private HouseOwner owner;

    private double price;

    private boolean status; //true = rented, false= to rent

    private Tenant tenant;

    private double rentPrice;

    public House() {}

    public House(String address, HouseOwner owner, double price, boolean status, Tenant tenant, double rentPrice) {
        this.address = address;
        this.owner = owner;
        this.price = price;
        this.status = status;
        this.tenant = tenant;
        this.rentPrice = rentPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HouseOwner getOwner() {
        return owner;
    }

    public void setOwner(HouseOwner owner) {
        this.owner = owner;
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

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", owner=" + owner +
                ", price=" + price +
                ", status=" + status +
                ", tenant=" + tenant +
                ", rentPrice=" + rentPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        return Double.compare(house.getPrice(), getPrice()) == 0 && isStatus() == house.isStatus() && Double.compare(house.getRentPrice(), getRentPrice()) == 0 && Objects.equals(getAddress(), house.getAddress()) && Objects.equals(getOwner(), house.getOwner()) && Objects.equals(getTenant(), house.getTenant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getOwner(), getPrice(), isStatus(), getTenant(), getRentPrice());
    }
}
