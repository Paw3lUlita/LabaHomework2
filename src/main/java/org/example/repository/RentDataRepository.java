package org.example.repository;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.abstractClasses.Property;
import org.example.entity.*;
import org.example.exception.*;
import org.example.interfaces.IRepo;
import org.example.service.RentService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RentDataRepository implements IRepo<RentData> {

    private static final Logger logger = LogManager.getLogger(RentDataRepository.class);

    private static final String FILE_PATH = "src/main/resources/rentData.csv";

    private final File rentDataFile;

    private final List<RentData> data;

    private static RentDataRepository instance;


    public RentDataRepository() {
        this.rentDataFile = new File(FILE_PATH);
        this.data = readDataFromFile();
        logger.debug("Instance of RentDataRepository class is created");
    }

    public static RentDataRepository getInstance() {
        if(instance == null) {
            instance = new RentDataRepository();
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
                .findAny()
                .orElseThrow();
    }

    @Override
    public void delete(RentData rentData) throws NoSuchRentDataFoundException {
        if(!data.contains(rentData)) {
            throw new NoSuchRentDataFoundException("You trying delete not saved data");
        }
        data.remove(rentData);
    }

    /**
     * cleaning the file first, to overwrite new data
     */
    public void writeDataToFile() {
        try {
            FileUtils.write(rentDataFile, "", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        data.forEach(rentData -> {
            try {
                FileUtils.write(rentDataFile, rentData.getOwner().getName()+","+
                                rentData.getOwner().getSurname()+","+
                                rentData.getOwner().getPhoneNumber()+","+
                                rentData.getOwner().getEmail()+","+
                                rentData.getOwner().getAccountNumber()+"\n",
                                "UTF-8", true);

                FileUtils.write(rentDataFile, rentData.getTenant().getName()+","+
                                rentData.getTenant().getSurname()+","+
                                rentData.getTenant().getPhoneNumber()+","+
                                rentData.getTenant().getEmail()+","+
                                rentData.getTenant().getAccountNumber()+"\n",
                        "UTF-8", true);

                FileUtils.write(rentDataFile, rentData.getProperty().getAddress()+","+
                                rentData.getProperty().getRentPrice()+"\n",
                        "UTF-8", true);
                logger.debug("Data written successfully to the file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public List<RentData> readDataFromFile() {
        List<RentData> dataFromFile = new ArrayList<>();
        List<String> linesOfFile = new ArrayList<>();
        try {
            linesOfFile = FileUtils.readLines(rentDataFile, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < linesOfFile.size(); i+=3) {
            String[] ownerFields = linesOfFile.get(i).split(",");
            PropertyOwner owner = new PropertyOwner(ownerFields[0], ownerFields[1], ownerFields[2],
                                        ownerFields[3], null, ownerFields[4]);

            String[] tenantFields = linesOfFile.get(i+1).split(",");
            Tenant tenant = new Tenant(tenantFields[0], tenantFields[1], tenantFields[2],
                                        tenantFields[3], tenantFields[4] );

            String[] propertyFields = linesOfFile.get(i+2).split(",");
            Property property = new House(propertyFields[0], owner, true, Double.parseDouble(propertyFields[1]));
            property.setTenant(tenant);
            owner.setProperty(property);
            tenant.setProperty(property);
            try {
                RentData rentData = new RentData(owner, tenant, property);
                dataFromFile.add(rentData);
                logger.debug("RentData read successfully from the file");
            } catch (OwnerHasNoPropertyException | NoTenantException | RentingPropertyWithoutOwnerException e) {
                e.printStackTrace();
            }
        }
        return dataFromFile;
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
            house1.setTenant(tenant1);
            tenant1.setProperty(house1);
            RentData rentData = new RentData(house1.getOwner(), tenant1, house1);
            data.add(rentData);

            house2.updateStatus();
            house2.setTenant(tenant2);
            tenant2.setProperty(house2);
            RentData rentData2 = new RentData(house2.getOwner(), tenant1, house2);
            data.add(rentData2);
        } catch (OwnerHasNoPropertyException | RentingPropertyWithoutOwnerException | NoTenantException e) {
            e.printStackTrace();
        }
    }
}
