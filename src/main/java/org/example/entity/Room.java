package org.example.entity;

import java.util.Objects;

public class Room extends Property{

    private final House house;

    public Room(String address, boolean status, double rentPrice, House house) {
        super(address, house.getOwner(), status, rentPrice);
        this.house = house;
    }

    @Override
    public void updateStatus() {
        if(getTenants().size() != 0){
            setStatus(true);
        } else {
            setStatus(false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(house, room.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), house);
    }
}
