package org.example.entity;

import org.example.abstractClasses.Property;
import org.example.enums.RentStatus;

public class House extends Property {


    public House(String address, PropertyOwner owner, boolean status, double rentPrice) {
        super(address, owner, status, rentPrice);
    }
    public House() {}
    @Override
    public void updateStatus() {
        if(getTenant() != null) {
            setStatus(RentStatus.RENTED);
        } else {
            setStatus(RentStatus.AVAILABLE_TO_RENT);
        }
    }

    @Override
    public String toString() {
        return String.format("House address: %s \n Owner: %s \n Tenant: %s \n Rent price: %s",
                super.getAddress(), super.getOwner(), super.getTenant(), super.getRentPrice());
    }
}