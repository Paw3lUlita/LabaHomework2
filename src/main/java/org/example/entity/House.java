package org.example.entity;

public class House extends Property {


    public House(String address, PropertyOwner owner, boolean status, double rentPrice) {
        super(address, owner, status, rentPrice);
    }
    public House() {}
    @Override
    public void updateStatus() {
        if(getTenants().size() != 0) {
            setStatus(true);
        } else {
            setStatus(false);
        }
    }

    @Override
    public String toString() {
        return String.format("House address: %s \n Owner: %s \n Tenant: %s \n Rent price: %s",
                super.getAddress(), super.getOwner(), super.getTenants(), super.getRentPrice());
    }
}
