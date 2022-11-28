package org.example;

import java.util.Objects;

public class Complain {

    private String message;

    private Tenant tenant;

    public Complain(String message, Tenant tenant) {
        this.message = message;
        this.tenant = tenant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return String.format("Complain from: %s \n message: \n %s", tenant.getName(), message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complain complain)) return false;
        return getMessage().equals(complain.getMessage()) && getTenant().equals(complain.getTenant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getTenant());
    }
}
