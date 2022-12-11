package org.example.exception;

public class NoSuchRentDataFoundException extends Exception{

    public NoSuchRentDataFoundException() {
    }

    public NoSuchRentDataFoundException(String message) {
        super(message);
    }
}
