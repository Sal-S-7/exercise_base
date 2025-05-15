package org.example.exercisesPoo.ex06Annuaire;

import java.util.Scanner;

public class Menu {

    public Menu() {

        Scanner scanner = new Scanner(System.in);
        Directory directory = new Directory();
        int choice;

        do {
            System.out.println("--- Menu Annuaire ---");
            System.out.println("1. Ajouter une entreprise");
            System.out.println("2. Voir toutes les entreprises");
            System.out.println("3. Rechercher une entreprise par nom");
            System.out.println("0. Quitter");
            System.out.println("----------------------");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nom de l'entreprise : ");
                    String name = scanner.nextLine();
                    System.out.print("Numéro de siret : ");
                    int number = scanner.nextInt();
                    System.out.print("Adresse : ");
                    String address = scanner.next();
                    System.out.print("Site web : ");
                    String site = scanner.next();

                    Company c = new Company(name, number, address, site);
                    directory.addCompany(c);
                    System.out.println("Entreprise ajoutée");
                    break;

                case 2:
                    directory.seeAllCompanies();
                    break;

                case 3:
                    System.out.print("Nom de l'entreprise à rechercher : ");
                    String search = scanner.next();
                    Company found = directory.searchByName(search);
                    if (found != null) {
                        System.out.println("Entreprise trouvée :" + found);
                    } else {
                        System.out.println("Entreprise non trouvée.");
                    }
                    break;

                case 0:
                    System.out.println("Au revoir");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        } while (choice != 0);
    }
}
