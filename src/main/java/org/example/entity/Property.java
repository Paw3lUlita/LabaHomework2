package org.example.entity;

import java.util.Objects;

public abstract class Property {

    private String address;

    private PropertyOwner owner;

    private boolean status; //true = rented, false= to rent

    private Tenant tenant;

    private double rentPrice;

    abstract void changeStatus();

    public Property(String address, PropertyOwner owner, boolean status, double rentPrice) {
        this.address = address;
        this.owner = owner;
        this.status = status;
        this.rentPrice = rentPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertyOwner getOwner() {
        return owner;
    }

    public void setOwner(PropertyOwner owner) {
        this.owner = owner;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property property)) return false;
        return isStatus() == property.isStatus() && Double.compare(property.getRentPrice(), getRentPrice()) == 0 && Objects.equals(getAddress(), property.getAddress()) && Objects.equals(getOwner(), property.getOwner()) && Objects.equals(getTenant(), property.getTenant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getOwner(), isStatus(), getTenant(), getRentPrice());
    }
}
