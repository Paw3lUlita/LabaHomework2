package org.example.entity;

import org.example.exception.*;
import org.example.interfaces.Rentable;
import org.example.repository.CentralRepository;

public class Agent extends Person implements Rentable {


    private final CentralRepository repository = CentralRepository.getInstance();
    public Agent(String name, String surname, String phoneNumber, String email) {
        super(name, surname, phoneNumber, email);
    }

    public Agent() {}


    @Override
    public void rentProperty(Property property, Tenant tenant)
            throws TenantIsAlreadySetInOtherPropertyException, RentingPropertyWithoutOwnerException,
            OwnerHasNoPropertyException, NoTenantException {
        if(tenant.getProperty() != null) {
            throw new TenantIsAlreadySetInOtherPropertyException("Tenant is already accommodated in other property");
        }
        if(property.getOwner() == null){
            throw new RentingPropertyWithoutOwnerException("Property has no owner, you can't rent property for sale");
        }
        property.updateStatus();
        property.setTenant(tenant);
        tenant.setProperty(property);
        RentData rentData = new RentData(this, property.getOwner(), tenant, property);
        repository.add(rentData);
    }

    @Override
    public void unrentProperty(Property property, Tenant tenant) throws NoSuchRentDataFoundException {
        property.setTenant(null);
        tenant.setProperty(null);
        property.updateStatus();
        RentData rentData = repository.findDataForProperty(property);
        repository.delete(rentData);
    }
}
