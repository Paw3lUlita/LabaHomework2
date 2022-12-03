package org.example.repository;

import org.example.entity.*;
import org.example.interfaces.IRepo;

import java.util.ArrayList;
import java.util.List;


public class CentralRepository implements IRepo<RentData> {

    private final List<RentData> data;
    private static CentralRepository INSTANCE;

    public CentralRepository() {
        this.data = new ArrayList<>();

    }

    public static CentralRepository getINSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new CentralRepository();
        }
        return INSTANCE;
    }
    @Override
    public void save(RentData rentData) {
        data.add(rentData);
    }

    @Override
    public List<RentData> findAll() {
        return List.copyOf(data);
    }

    public RentData findDataForProperty(Property property){
        return data.stream().
                filter(d -> d.getProperty().equals(property))
                .findAny().orElseThrow();
    }

    @Override
    public void delete(RentData rentData) {
        data.remove(rentData);
    }

    public void generateSomeData(){
        Agent agent1 = new Agent("John", "Smith", "345345567", "sdfsd@dot.com");
        Agent agent2 = new Agent("Elizabeth", "Longe", "3908767", "somemail@dot.com");

        Property house1 = new House("Baker Street 21", null, false, 456.34);
        Property house2 = new House("Flower Street 34", null, false, 789.98);

        PropertyOwner owner1 = new PropertyOwner("Will", "Defoe", "456098123", "test@rtrt.pl", house1,"0000100000000000000");
        PropertyOwner owner2 = new PropertyOwner("Arnold", "Shwarzenegger", "450008123", "arnold@rtrt.pl", house2,"0000100000999999000");

        house1.setOwner(owner1);
        house2.setOwner(owner2);

        Tenant tenant1 = new Tenant("Donald", "Trump", "4567777", "ert@dot.com", "95959595959595959");
        Tenant tenant2 = new Tenant("Mariah", "Carey", "45000007", "emailt@dot.com", "92222223333359");

        agent1.rentProperty(house1, tenant1);
        agent1.rentProperty(house2, tenant2);

    }
}
