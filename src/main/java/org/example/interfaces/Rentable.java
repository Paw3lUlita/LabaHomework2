package org.example.interfaces;

import org.example.entity.Property;
import org.example.entity.Tenant;
import org.example.exception.NoSuchRentDataFoundException;
import org.example.exception.NoTenantException;
import org.example.exception.OwnerHasNoPropertyException;
import org.example.exception.RentingPropertyWithoutOwnerException;

public interface Rentable {

    void rentProperty(Property property, Tenant tenant) throws RentingPropertyWithoutOwnerException, OwnerHasNoPropertyException, NoTenantException;

    void unrentProperty(Property property, Tenant tenant) throws NoSuchRentDataFoundException;


}
