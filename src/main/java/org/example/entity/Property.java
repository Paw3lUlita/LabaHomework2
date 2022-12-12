package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Property {

    private String address;

    private PropertyOwner owner;

    private boolean status; //true = rented, false= to rent

    private List<Tenant> tenants;

    private double rentPrice;

    public abstract void updateStatus();

    public Property(String address, PropertyOwner owner, boolean status, double rentPrice) {
        this.address = address;
        this.owner = owner;
        this.status = status;
        this.rentPrice = rentPrice;
        tenants = new ArrayList<>();
    }

    public Property() {}

    public void addTenant(Tenant tenant) {
        tenants.add(tenant);
    }

    public void removeTenant(Tenant tenant) {
        tenants.remove(tenant);
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

    public List<Tenant> getTenants() {
        return List.copyOf(tenants);
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
        return isStatus() == property.isStatus() && Double.compare(property.getRentPrice(), getRentPrice()) == 0 && Objects.equals(getAddress(), property.getAddress()) && Objects.equals(getOwner(), property.getOwner()) && Objects.equals(getTenants(), property.getTenants());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getOwner(), isStatus(), getTenants(), getRentPrice());
    }
}
