package org.example.interfaces;

import org.example.entity.Property;
import org.example.entity.Tenant;

public interface Rentable {

    void rentProperty(Property property, Tenant tenant);

    void unrentProperty(Property property, Tenant tenant);

}
