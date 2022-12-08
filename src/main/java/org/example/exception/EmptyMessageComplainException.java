package org.example.exception;

public class EmptyMessageComplainException extends Exception{

    public EmptyMessageComplainException() {
    }

    public EmptyMessageComplainException(String message) {
        super(message);
    }
}
