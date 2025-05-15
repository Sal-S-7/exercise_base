package org.example.exercisesPoo.ex06Annuaire;

public class Company {
    private String name;
    private int number;
    private String address;
    private String site;

    public Company(String name, int number, String address, String site) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.site = site;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nNom: " + name + "\nNuméro de siret: " + number + "\nAdresse: " + address + "\nSite: " + site;
    }
}

