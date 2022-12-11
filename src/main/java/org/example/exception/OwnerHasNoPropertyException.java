package org.example.exception;

public class OwnerHasNoPropertyException extends Exception{

    public OwnerHasNoPropertyException() {
    }

    public OwnerHasNoPropertyException(String message) {
        super(message);
    }
}
