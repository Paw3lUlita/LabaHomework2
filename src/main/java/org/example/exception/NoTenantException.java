package org.example.exception;

public class NoTenantException extends Exception{

    public NoTenantException() {
    }

    public NoTenantException(String message) {
        super(message);
    }
}
