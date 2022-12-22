package org.example.exception;

import org.example.abstractClasses.Property;

public class RentingPropertyWithoutOwnerException extends Exception{

    public RentingPropertyWithoutOwnerException() {
    }

    public RentingPropertyWithoutOwnerException(Property property) {
        super(generateMessage(property));
    }

    private static String generateMessage(Property property) {
        return String.format("Property %s has no owner set", property.getAddress());
    }
}
