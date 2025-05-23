package org.example.exerciseJDBC.exercice2Bank.utils;

import org.example.exerciseJDBC.exercice2Bank.entity.BankAccount;
import org.example.exerciseJDBC.exercice2Bank.entity.Operation;
import org.example.exerciseJDBC.exercice2Bank.service.BankService;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuIhm {

    public static void start() {
        boolean running = true;
        BankService service = new BankService();
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("---------------------------");
            System.out.println("---------BIENVENUE---------");
            System.out.println("---------------------------");
            System.out.println("\n1. Créer un compte client.");
            System.out.println("2. Déposer de l'argent");
            System.out.println("3. Retirer de l'argent");
            System.out.println("4. Afficher un compte");
            System.out.println("0. Quitter");
            System.out.print("Choisissez votre option : ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Prénom : ");
                        String fn = scanner.nextLine();
                        System.out.print("Nom : ");
                        String ln = scanner.nextLine();
                        System.out.print("Numéro de téléphone : ");
                        String phone = scanner.nextLine();

                        BankAccount account = service.createCustomer(fn, ln, phone);
                        System.out.println("Compte bancaire client créer avec l'id numéro : " + account.getId());
                    }
                    case 2 -> {
                        System.out.print("ID du compte : ");
                        int accId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Dépôt total : ");
                        double amount = Double.parseDouble(scanner.nextLine());

                        service.deposit(accId, amount);
                        System.out.println("Opération déposer réalisée avec succès.");
                    }
                    case 3 -> {
                        System.out.print("ID du compte : ");
                        int accId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Retrait total : ");
                        double amount = Double.parseDouble(scanner.nextLine());

                        service.withdraw(accId, amount);
                        System.out.println("Opération retrait réalisée avec succès.");
                    }
                    case 4 -> {
                        System.out.print("ID du compte : ");
                        int accId = Integer.parseInt(scanner.nextLine());

                        BankAccount account = service.getAccountDetails(accId);
                        if (account == null) {
                            System.out.println("Compte non trouvé.");
                        } else {
                            System.out.println("ID du compte : " + account.getId());
                            System.out.println("Client : " + account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName());
                            System.out.println("Numéro de téléphone : " + account.getCustomer().getPhone());
                            System.out.println("Montant total : " + account.getTotalAmount());
                            System.out.println("Opérations :");
                            for (Operation operation : account.getOperations()) {
                                System.out.println(" - " + operation.getStatus() == "Dépôt" + " de " + operation.getAmount());
                            }
                        }
                    }
                    case 0 -> {
                        System.out.println("Quitter...");
                        return;
                    }
                    default -> System.out.println("Option non valide.");
                }
            } catch (SQLException | IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}

