package org.example.entity;

import java.util.Objects;

public class Offer {

    private String name;

    private Property property;

    private Agent agent;

    private double rentPrice;

    public Offer(String name, Property house, Agent agent, double rentPrice) {
        this.name = name;
        this.property = house;
        this.agent = agent;
        this.rentPrice = rentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(House property) {
        this.property = property;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public String toString() {
        return String.format("Offer %s made by: %s \n Property to rent: %s \n Rent price: %s ",
                name, agent.getName(), property.getAddress(), rentPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer offer)) return false;
        return Double.compare(offer.getRentPrice(), getRentPrice()) == 0 && getName().equals(offer.getName()) && getProperty().equals(offer.getProperty()) && getAgent().equals(offer.getAgent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProperty(), getAgent(), getRentPrice());
    }
}
