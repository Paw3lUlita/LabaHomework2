package org.example;

public class Main {


    public static void main(String[] args) {
        Agent agent = new Agent("Jurek", "Jurkowski", "456765675", "papapapapa@we.pl");

        Person tenant = new Tenant("Marek", "dsda00", "567434", "dfasda@pl.pl",
                new House(), "" );

        Complain complain = new Complain("Brudno tu", (Tenant) tenant);
        System.out.println(complain);
        System.out.println(tenant);
    }
}