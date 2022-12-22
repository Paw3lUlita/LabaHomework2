package org.example.exception;

import org.example.abstractClasses.Property;

public class NoTenantException extends Exception{

    public NoTenantException() {
    }

    public NoTenantException(Property property) {
        super(generateMessage(property));
    }

    private static String generateMessage(Property property) {
        return String.format("Property: %s, has no Tenant", property.getAddress());
    }
}
