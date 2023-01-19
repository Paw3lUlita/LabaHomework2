package org.example.exception;

import org.example.entity.Tenant;

public class TenantIsAlreadySetInOtherPropertyException extends IllegalArgumentException{

    public TenantIsAlreadySetInOtherPropertyException() {
    }

    public TenantIsAlreadySetInOtherPropertyException(Tenant tenant) {
        super(generateMessage(tenant));
    }

    private static String generateMessage(Tenant tenant) {
        return String.format("%s %s is already accommodated at %s", tenant.getName(),
                tenant.getSurname(), tenant.getProperty().getAddress());
    }
}
