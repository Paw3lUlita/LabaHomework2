package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Property;
import org.example.entity.RentData;
import org.example.entity.Tenant;
import org.example.exception.*;
import org.example.interfaces.Rentable;
import org.example.repository.CentralRepository;

import java.util.List;

public class RentService implements Rentable {

    private static final Logger logger = LogManager.getLogger(RentService.class);
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
            logger.info("Something went wrong while renting property");
            throw new TenantIsAlreadySetInOtherPropertyException("Tenant is already accommodated in other property");
        }
        if(property.getOwner() == null){
            logger.info("Something went wrong while renting property");
            throw new RentingPropertyWithoutOwnerException("Property has no owner, you can't rent property for sale");
        }
        property.updateStatus();
        property.addTenant(tenant);
        tenant.setProperty(property);
        RentData rentData = new RentData(property.getOwner(), List.of(tenant), property);
        repository.add(rentData);
        logger.info("Property is rented and successfully added to database");
    }

    @Override
    public void unrentProperty(Property property, Tenant tenant) throws NoSuchRentDataFoundException {
        property.removeTenant(tenant);
        tenant.setProperty(null);
        if (property.getTenants().size() == 0) {
            property.updateStatus();
            RentData rentData = repository.findDataForProperty(property);
            repository.delete(rentData);
            logger.info("Property deleted form repository");
        }
    }

}
