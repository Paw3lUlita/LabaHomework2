package org.example.exception;

public class TenantIsAlreadySetInOtherPropertyException extends IllegalArgumentException{

    public TenantIsAlreadySetInOtherPropertyException() {
    }

    public TenantIsAlreadySetInOtherPropertyException(String s) {
        super(s);
    }
}
