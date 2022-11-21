package org.example;

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
}
