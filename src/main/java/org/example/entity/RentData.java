package org.example.entity;

import org.example.exception.NoTenantException;
import org.example.exception.OwnerHasNoPropertyException;
import org.example.exception.RentingPropertyWithoutOwnerException;

import java.util.List;
import java.util.Objects;

public class RentData {

    private PropertyOwner owner;

    private List<Tenant> tenants;

    private Property property;

    private double rentPrice;

    public RentData(PropertyOwner owner, List<Tenant> tenants, Property property) throws OwnerHasNoPropertyException, NoTenantException, RentingPropertyWithoutOwnerException {

        if(owner.getProperty() == null){
            throw new OwnerHasNoPropertyException("You can't write RentData with owner without property");
        }

        if(property.getTenants().size() == 0){
            throw new NoTenantException("You should set tenant to the property");
        }

        if(property.getOwner() == null){
            throw new RentingPropertyWithoutOwnerException("Your property doesn't has owner set");
        }

        this.owner = owner;
        this.tenants = tenants;
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

    public List<Tenant> getTenants() {
        return List.copyOf(tenants);
    }

    public void addTenant(Tenant tenant) {
        tenants.add(tenant);
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
        return Double.compare(rentData.getRentPrice(), getRentPrice()) == 0 && getOwner().equals(rentData.getOwner()) && getTenants().equals(rentData.getTenants()) && getProperty().equals(rentData.getProperty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner(), getTenants(), getProperty(), getRentPrice());
    }

    @Override
    public String toString() {
        return String.format("Rent information: \n Owner: %s \n Tenants: %s \n Property: %s ",
                owner.getSurname(), tenants.toString(), property.getAddress());
    }
}
