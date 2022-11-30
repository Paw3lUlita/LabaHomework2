package org.example.entity;

import org.example.interfaces.Rentable;

public class Agent extends Person implements Rentable {


    public Agent(String name, String surname, String phoneNumber, String email) {
        super(name, surname, phoneNumber, email);
    }


    @Override
    public void rentProperty(Property property, Tenant tenant) {
        property.setTenant(tenant);
        property.changeStatus();
    }

    @Override
    public void unrentProperty(Property property, Tenant tenant) {
        property.setTenant(null);
        property.changeStatus();
    }
}
