package org.example;

import org.example.abstractClasses.Person;
import org.example.abstractClasses.Property;
import org.example.entity.House;
import org.example.entity.PropertyOwner;
import org.example.entity.Tenant;
import org.example.exception.NoSuchRentDataFoundException;
import org.example.exception.NoTenantException;
import org.example.exception.OwnerHasNoPropertyException;
import org.example.exception.RentingPropertyWithoutOwnerException;
import org.example.repository.RentDataRepository;
import org.example.service.RentService;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static RentDataRepository repository = RentDataRepository.getInstance();
    static RentService rentService = RentService.getInstance();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1 -> printAllRentData();
                case 2 -> rentAHouse();
                case 3 -> unrentAHouse();
                case 4 -> System.out.println("Your data is saved, switching off the program");
                default -> System.out.println("Choose correct option!");
            }
        } while (option != 4);
        repository.writeDataToFile();
    }

    public static void showMenu() {
        System.out.println("Welcome to Real Estate Manager. Choose one option: ");
        System.out.println("1. Show all rent data");
        System.out.println("2. Rent a house");
        System.out.println("3. Unrent a House");
        System.out.println("4. Exit");
    }

    private static void printAllRentData() {
        AtomicInteger tempId = new AtomicInteger(1);
        repository.findAll().forEach(rentData -> System.out.println("ID: " + tempId.getAndIncrement() +"\n"+rentData));
    }

    private static void rentAHouse() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creating an owner...");
        System.out.println("Provide name: ");
        String name = scanner.nextLine();
        System.out.println("Provide surname");
        String surname = scanner.nextLine();
        System.out.println("Provide phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Provide email: ");
        String email = scanner.nextLine();
        System.out.println("Provide account number");
        String accNumber = scanner.nextLine();
        PropertyOwner propertyOwner = new PropertyOwner(name, surname, phoneNumber, email, null, accNumber);

        System.out.println("Creating a property...");
        System.out.println("Provide an address: ");
        String address = scanner.nextLine();
        System.out.println("Provide an rent price: ");
        double rentPrice = Double.parseDouble(scanner.nextLine());
        Property house = new House(address, propertyOwner, false, rentPrice);
        propertyOwner.setProperty(house);

        System.out.println("Creating a tenant...");
        System.out.println("Provide name: ");
        String tenantName = scanner.nextLine();
        System.out.println("Provide surname");
        String tenantSurname = scanner.nextLine();
        System.out.println("Provide phone number: ");
        String tenantPhoneNumber = scanner.nextLine();
        System.out.println("Provide email: ");
        String tenantEmail = scanner.nextLine();
        System.out.println("Provide account number");
        String tenantAccNumber = scanner.nextLine();
        Tenant tenant = new Tenant(tenantName, tenantSurname, tenantPhoneNumber, tenantEmail, tenantAccNumber);
        try {
            rentService.rentProperty(house, tenant);
        } catch (RentingPropertyWithoutOwnerException | OwnerHasNoPropertyException | NoTenantException e) {
            e.printStackTrace();
        }
    }

    private static void unrentAHouse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide rent data ID wchich house should be unrented");
        int id = scanner.nextInt();
        Property house = repository.findAll().get(id-1).getProperty();
        try {
            rentService.unrentProperty(house, house.getTenant());
        } catch (NoSuchRentDataFoundException e) {
            e.printStackTrace();
        }
    }
}
