package org.example.abstractClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.service.RentService;

import java.util.Objects;

public abstract class Person {

    private static final Logger logger = LogManager.getLogger(Person.class);
    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

    public String getName() {
        return name;
    }

    public Person(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        logger.debug("Instance of Person class is created");
    }

    public Person() {
        this.name = "John";
        this.surname = "Smith";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        boolean isNameEqual = name.equals(person.name);
        boolean isSurnameEqual = surname.equals(person.surname);
        boolean isPhoneNumberEqual = phoneNumber.equals(person.phoneNumber);
        boolean isEmailEqual = email.equals(person.email);
        return isNameEqual && isSurnameEqual && isPhoneNumberEqual && isEmailEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}