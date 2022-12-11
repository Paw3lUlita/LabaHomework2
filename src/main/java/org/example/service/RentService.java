package org.example.service;

import org.example.entity.Property;
import org.example.entity.RentData;
import org.example.entity.Tenant;
import org.example.exception.*;
import org.example.interfaces.Rentable;
import org.example.repository.CentralRepository;

public class RentService implements Rentable {

    private final CentralRepository repository = CentralRepository.getInstance();

    private static RentService instance;

    public RentService() {
    }

    public static RentService getInstance() {
        if(instance == null) {
            instance = new RentService();
        }
        return instance;
    }
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
        RentData rentData = new RentData(property.getOwner(), tenant, property);
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
