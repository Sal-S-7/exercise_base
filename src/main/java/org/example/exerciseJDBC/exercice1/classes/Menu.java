package org.example.exerciseJDBC.exercice1.classes;


import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class Menu {

    public Menu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("--- Menu Annuaire ---");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Voir tout les étudiants");
            System.out.println("3. Afficher les étudiants d'une classe");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("0. Quitter");
            System.out.println("----------------------");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AddStudent.connection();
                    break;

                case 2:
                    SearchAllStudents.connection();
                    break;

                case 3:
                    SearchClassStudent.connection();
                    break;

                case 4:
                    RemoveStudent.connection();
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
