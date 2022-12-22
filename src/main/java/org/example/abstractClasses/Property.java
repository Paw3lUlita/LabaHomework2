package org.example.abstractClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.PropertyOwner;
import org.example.entity.Tenant;
import org.example.service.RentService;

import java.util.Objects;

public abstract class Property {

    private static final Logger logger = LogManager.getLogger(Property.class);
    private String address;

    private PropertyOwner owner;

    /**
     * true = isRented, false= isAvailable
     */
    private boolean rented;

    private Tenant tenant;

    private double rentPrice;

    public abstract void updateStatus();

    public Property(String address, PropertyOwner owner, boolean rented, double rentPrice) {
        this.address = address;
        this.owner = owner;
        this.rented = rented;
        this.rentPrice = rentPrice;
        logger.debug("Instance of Property class is created");
    }

    public Property() {}

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertyOwner getOwner() {
        return owner;
    }

    public void setOwner(PropertyOwner owner) {
        this.owner = owner;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property property)) return false;
        boolean isStatusEqual = isRented() == property.isRented();
        boolean isRentPriceEqual = Double.compare(property.getRentPrice(), getRentPrice()) == 0;
        boolean isAddressEqual = Objects.equals(getAddress(), property.getAddress());
        boolean isOwnerEqual = Objects.equals(getOwner(), property.getOwner());
        boolean isTenantEqual = Objects.equals(getTenant(), property.getTenant());
        return  isStatusEqual && isRentPriceEqual && isAddressEqual && isOwnerEqual && isTenantEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getOwner(), isRented(), getTenant(), getRentPrice());
    }
}