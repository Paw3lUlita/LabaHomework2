package org.example;


import org.apache.logging.log4j.*;


import org.example.entity.Agent;
import org.example.entity.Property;
import org.example.entity.RentData;
import org.example.entity.Tenant;
import org.example.exception.NoSuchRentDataFoundException;
import org.example.repository.CentralRepository;

public class Main {

private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args)  {
        CentralRepository repository = CentralRepository.getInstance();
        repository.generateTestData();

        logger.info("Checking, that all classes works properly");
        for(RentData data : repository.findAll()){
            System.out.println(data);
            System.out.println(data.getProperty().getTenant());
        }
        logger.info("Check");
        Agent agent = repository.findAll().get(0).getAgent();
        Property property = repository.findAll().get(0).getProperty();
        Tenant tenant = repository.findAll().get(0).getTenant();
        try {
            agent.unrentProperty(property, tenant);
        } catch(NoSuchRentDataFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Another check if deleting and unrenting works properly");
        System.out.println("......................................................");
        for(RentData data : repository.findAll()){
            System.out.println(data);
            System.out.println(data.getProperty().getTenant());
        }
    }
}