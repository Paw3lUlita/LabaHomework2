package org.example;


import org.example.entity.Agent;
import org.example.entity.Property;
import org.example.entity.RentData;
import org.example.entity.Tenant;
import org.example.repository.CentralRepository;

public class Main {


    public static void main(String[] args) {

        CentralRepository repository = CentralRepository.getINSTANCE();
        repository.generateSomeData();

        System.out.println("Checking all data are saving properly");
        System.out.println(".....................................");
        for(RentData data : repository.findAll()){
            System.out.println(data);
            System.out.println(data.getProperty().getTenant());
        }

        Agent agent = repository.findAll().get(0).getAgent();
        Property property = repository.findAll().get(0).getProperty();
        Tenant tenant = repository.findAll().get(0).getTenant();
        agent.unrentProperty(property, tenant);

        System.out.println("Another check if deleting and unrenting works properly");
        System.out.println("......................................................");
        for(RentData data : repository.findAll()){
            System.out.println(data);
            System.out.println(data.getProperty().getTenant());
        }

    }
}