package org.example.entity;

import org.example.exception.NoTenantException;
import org.example.exception.OwnerHasNoPropertyException;
import org.example.exception.RentingPropertyWithoutOwnerException;

import java.util.Objects;

public class RentData {

    private Agent agent;

    private PropertyOwner owner;

    private Tenant tenant;

    private Property property;

    private double rentPrice;

    public RentData(Agent agent, PropertyOwner owner, Tenant tenant, Property property) throws OwnerHasNoPropertyException, NoTenantException, RentingPropertyWithoutOwnerException {

        if(owner.getProperty() == null){
            throw new OwnerHasNoPropertyException("You can't write RentData with owner without property");
        }

        if(property.getTenant() == null){
            throw new NoTenantException("You should set tenant to the property");
        }

        if(property.getOwner() == null){
            throw new RentingPropertyWithoutOwnerException("Your property doesn't has owner set");
        }

        this.agent = agent;
        this.owner = owner;
        this.tenant = tenant;
        this.property = property;
        this.rentPrice = property.getRentPrice();
    }

    public RentData() {}

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

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

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentData rentData)) return false;
        return Double.compare(rentData.getRentPrice(), getRentPrice()) == 0 && getAgent().equals(rentData.getAgent()) && getOwner().equals(rentData.getOwner()) && getTenant().equals(rentData.getTenant()) && getProperty().equals(rentData.getProperty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAgent(), getOwner(), getTenant(), getProperty(), getRentPrice());
    }

    @Override
    public String toString() {
        return String.format("Rent information: \n Agent: %s \n Owner: %s \n Tenant: %s \n Property: %s ",
                agent.getSurname(), owner.getSurname(), tenant.getSurname(), property.getAddress());
    }
}
