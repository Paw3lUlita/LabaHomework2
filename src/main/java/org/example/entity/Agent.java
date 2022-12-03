package org.example.entity;

import org.example.interfaces.Rentable;
import org.example.repository.CentralRepository;

public class Agent extends Person implements Rentable {


    private final CentralRepository repository = CentralRepository.getINSTANCE();
    public Agent(String name, String surname, String phoneNumber, String email) {
        super(name, surname, phoneNumber, email);
    }

    public Agent() {}


    @Override
    public void rentProperty(Property property, Tenant tenant) {
        property.changeStatus();
        property.setTenant(tenant);
        tenant.setProperty(property);
        RentData rentData = new RentData(this, property.getOwner(), tenant, property);
        repository.save(rentData);
    }

    @Override
    public void unrentProperty(Property property, Tenant tenant) {
        property.setTenant(null);
        tenant.setProperty(null);
        property.changeStatus();
        RentData rentData = repository.findDataForProperty(property);
        repository.delete(rentData);
    }
}
