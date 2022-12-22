package org.example.exception;

import org.example.entity.PropertyOwner;

public class OwnerHasNoPropertyException extends Exception{

    public OwnerHasNoPropertyException() {
    }

    public OwnerHasNoPropertyException(PropertyOwner owner) {
        super(generateMessage(owner));
    }

    private static String generateMessage(PropertyOwner owner) {
        return String.format("%s %s has no property set", owner.getName(), owner.getSurname());
    }
}
