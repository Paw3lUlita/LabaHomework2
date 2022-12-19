package org.example.repository;

import org.example.entity.*;
import org.example.exception.*;
import org.example.interfaces.IRepo;
import org.example.service.RentService;

import java.util.ArrayList;
import java.util.List;


public class CentralRepository implements IRepo<RentData> {

    private final List<RentData> data;
    private static CentralRepository instance;

    public CentralRepository() {

        this.data = new ArrayList<>();
    }

    public static CentralRepository getInstance() {
        if(instance == null) {
            instance = new CentralRepository();
        }
        return instance;
    }

    @Override
    public void add(RentData rentData) {
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
    public void delete(RentData rentData) throws NoSuchRentDataFoundException {
        if(!data.contains(rentData)) {
            throw new NoSuchRentDataFoundException("You trying delete not saved data");
        }
        data.remove(rentData);
    }

    public void generateTestData() {

        Property house1 = new House("Baker Street 21", null, false, 456.34);
        Property house2 = new House("Flower Street 34", null, false, 789.98);

        PropertyOwner owner1 = new PropertyOwner("Will", "Defoe", "456098123", "test@rtrt.pl", house1,"0000100000000000000");
        PropertyOwner owner2 = new PropertyOwner("Arnold", "Shwarzenegger", "450008123", "arnold@rtrt.pl", house2,"0000100000999999000");

        house1.setOwner(owner1);
        house2.setOwner(owner2);

        Tenant tenant1 = new Tenant("Donald", "Trump", "4567777", "ert@dot.com", "95959595959595959");
        Tenant tenant2 = new Tenant("Mariah", "Carey", "45000007", "emailt@dot.com", "92222223333359");

        try {
            house1.updateStatus();
            house1.addTenant(tenant1);
            tenant1.setProperty(house1);
            RentData rentData = new RentData(house1.getOwner(), List.of(tenant1), house1);
            data.add(rentData);

            house2.updateStatus();
            house2.addTenant(tenant2);
            tenant2.setProperty(house2);
            RentData rentData2 = new RentData(house2.getOwner(), List.of(tenant2), house2);
            data.add(rentData2);
        } catch (OwnerHasNoPropertyException | RentingPropertyWithoutOwnerException | NoTenantException e) {
            e.printStackTrace();
        }

    }
}
