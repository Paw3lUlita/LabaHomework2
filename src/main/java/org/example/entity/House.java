package org.example.entity;

import java.util.Objects;

public class House extends Property {


    public House(String address, PropertyOwner owner, boolean status, double rentPrice) {
        super(address, owner, status, rentPrice);
    }

    @Override
    void changeStatus() {
        if(getTenant() != null){
            setStatus(true);
        }
    }

    @Override
    public String toString() {
        return String.format("House address: %s \n Owner: %s \n Tenant: %s \n Rent price: %s",
                super.getAddress(), super.getOwner(), super.getTenant(), super.getRentPrice());
    }


}
