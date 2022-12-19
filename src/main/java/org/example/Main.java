package org.example;

import org.apache.commons.io.FileUtils;
import org.example.entity.Property;
import org.example.entity.RentData;
import org.example.entity.Tenant;
import org.example.exception.NoSuchRentDataFoundException;
import org.example.repository.RentDataRepository;
import org.example.service.InfoFileService;
import org.example.service.RentService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        RentDataRepository repository = RentDataRepository.getInstance();
        repository.generateTestData();
        RentService rentService = RentService.getInstance();
        InfoFileService infoFileService = new InfoFileService();

        System.out.println("Checking, that all classes works properly");
        for(RentData data : repository.findAll()){
            System.out.println(data);
            System.out.println(data.getProperty().getTenants());
        }

        Property property = repository.findAll().get(0).getProperty();
        Tenant tenant = repository.findAll().get(0).getTenants().get(0);
        try {
            rentService.unrentProperty(property, tenant);
        } catch(NoSuchRentDataFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Another check if deleting and unrenting works properly");
        System.out.println("......................................................");
        for(RentData data : repository.findAll()){
            System.out.println(data);
            System.out.println(data.getProperty().getTenants());
        }


        try {
            List<String> dataFromFile = infoFileService.readDataFromFile();
            System.out.println("********reading from file**********");
            for(String s : dataFromFile) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}