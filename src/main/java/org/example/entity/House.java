package org.example.entity;

import org.example.abstractClasses.Property;

public class House extends Property {


    public House(String address, PropertyOwner owner, boolean status, double rentPrice) {
        super(address, owner, status, rentPrice);
    }
    public House() {}
    @Override
    public void updateStatus() {
        if(getTenant() != null) {
            setRented(true);
        } else {
            setRented(false);
        }
    }

    @Override
    public String toString() {
        return String.format("House address: %s \n Owner: %s \n Tenant: %s \n Rent price: %s",
                super.getAddress(), super.getOwner(), super.getTenant(), super.getRentPrice());
    }
}