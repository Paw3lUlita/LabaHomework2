package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Property;
import org.example.entity.RentData;
import org.example.entity.Tenant;
import org.example.exception.*;
import org.example.interfaces.Rentable;
import org.example.repository.RentDataRepository;

import java.util.List;

public class RentService implements Rentable {

    private static final Logger logger = LogManager.getLogger(RentService.class);

    private final RentDataRepository repository;

    private static RentService instance;

    private final InfoFileService infoFileService;

    public RentService() {
        this.repository = RentDataRepository.getInstance();
        infoFileService = new InfoFileService();
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
        property.setTenant(tenant);
        tenant.setProperty(property);
        RentData rentData = new RentData(property.getOwner(), tenant, property);
        repository.add(rentData);
        logger.info("Property is rented and successfully added to database");
    }

    @Override
    public void unrentProperty(Property property, Tenant tenant) throws NoSuchRentDataFoundException {
        property.setTenant(null);
        tenant.setProperty(null);
        if (property.getTenant() == null) {
            property.updateStatus();
            RentData rentData = repository.findDataForProperty(property);
            repository.delete(rentData);
            String dataToFile = String.format("Property unrented: %s \n", property.getAddress());
            infoFileService.writeToFile(dataToFile);
            logger.info("Property deleted form repository");
        }
    }

}
