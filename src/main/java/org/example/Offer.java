package org.example;

import java.util.Objects;

public class Offer {

    private String name;

    private House house;

    private Agent agent;

    private double rentPrice;

    public Offer(String name, House house, Agent agent, double rentPrice) {
        this.name = name;
        this.house = house;
        this.agent = agent;
        this.rentPrice = rentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
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
        return String.format("Offer %s made by: %s \n House to rent: %s \n Rent price: %s ",
                name, agent.getName(), house.getAddress(), rentPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer offer)) return false;
        return Double.compare(offer.getRentPrice(), getRentPrice()) == 0 && getName().equals(offer.getName()) && getHouse().equals(offer.getHouse()) && getAgent().equals(offer.getAgent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHouse(), getAgent(), getRentPrice());
    }
}
