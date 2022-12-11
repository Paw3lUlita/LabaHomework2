package org.example;

import org.example.entity.Property;
import org.example.entity.RentData;
import org.example.entity.Tenant;
import org.example.exception.NoSuchRentDataFoundException;
import org.example.repository.CentralRepository;
import org.example.service.RentService;

public class Main {
    public static void main(String[] args)  {
        CentralRepository repository = CentralRepository.getInstance();
        repository.generateTestData();
        RentService rentService = RentService.getInstance();

        System.out.println("Checking, that all classes works properly");
        for(RentData data : repository.findAll()){
            System.out.println(data);
            System.out.println(data.getProperty().getTenant());
        }

        Property property = repository.findAll().get(0).getProperty();
        Tenant tenant = repository.findAll().get(0).getTenant();
        try {
            rentService.unrentProperty(property, tenant);
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