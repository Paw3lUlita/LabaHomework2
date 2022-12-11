package org.example.exception;

public class RentingPropertyWithoutOwnerException extends Exception{

    public RentingPropertyWithoutOwnerException() {
    }

    public RentingPropertyWithoutOwnerException(String message) {
        super(message);
    }
}
