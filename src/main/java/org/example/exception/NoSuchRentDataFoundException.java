package org.example.exception;

import org.example.entity.RentData;

public class NoSuchRentDataFoundException extends Exception{

    public NoSuchRentDataFoundException() {
    }

    public NoSuchRentDataFoundException(RentData rentData) {
        super(generateMessage(rentData));
    }

    private static String generateMessage(RentData rentData) {
        return String.format("Not such rentData founf for Owner: %s, Tenant: %s and property: %s",
                rentData.getOwner(), rentData.getTenant(), rentData.getProperty());
    }
}
