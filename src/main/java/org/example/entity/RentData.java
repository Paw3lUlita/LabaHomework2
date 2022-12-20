package org.example.entity;

import org.example.exception.NoTenantException;
import org.example.exception.OwnerHasNoPropertyException;
import org.example.exception.RentingPropertyWithoutOwnerException;

import java.util.List;
import java.util.Objects;

public class RentData {

    private PropertyOwner owner;

    private Tenant tenant;

    private Property property;

    private double rentPrice;

    public RentData(PropertyOwner owner, Tenant tenant, Property property) throws OwnerHasNoPropertyException, NoTenantException, RentingPropertyWithoutOwnerException {

        if(owner.getProperty() == null){
            throw new OwnerHasNoPropertyException("You can't write RentData with owner without property");
        }

        if(property.getTenant() == null){
            throw new NoTenantException("You should set tenant to the property");
        }

        if(property.getOwner() == null){
            throw new RentingPropertyWithoutOwnerException("Your property doesn't has owner set");
        }

        this.owner = owner;
        this.tenant = tenant;
        this.property = property;
        this.rentPrice = property.getRentPrice();
    }

    public RentData() {}

    public PropertyOwner getOwner() {
        return owner;
    }

    public void setOwner(PropertyOwner owner) {
        this.owner = owner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentData rentData)) return false;
        return Double.compare(rentData.getRentPrice(), getRentPrice()) == 0 && getOwner().equals(rentData.getOwner()) && getTenant().equals(rentData.getTenant()) && getProperty().equals(rentData.getProperty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner(), getTenant(), getProperty(), getRentPrice());
    }

    @Override
    public String toString() {
        return String.format("Rent information: \n Owner: %s \n Tenants: %s \n Property: %s ",
                owner.getSurname(), tenant.toString(), property.getAddress());
    }
}
