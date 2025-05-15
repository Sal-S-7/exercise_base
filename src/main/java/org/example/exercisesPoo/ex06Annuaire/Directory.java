package org.example.exercisesPoo.ex06Annuaire;

import java.util.ArrayList;

public class Directory {
    private ArrayList<Company> company;

    public Directory() {
        company = new ArrayList<>();
    }

    public void addCompany(Company c) {
        company.add(c);
    }

    public void seeAllCompanies() {
        if (company.isEmpty()) {
            System.out.println("Aucune entreprise dans l'annuaire.");
        } else {
            for (Company c : company) {
                System.out.println(c);
            }
        }
    }

    public Company searchByName(String name) {
        for (Company c : company) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}
