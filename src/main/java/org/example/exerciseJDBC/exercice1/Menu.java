package org.example.exerciseJDBC.exercice1;


import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {

    public Menu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        AddStudent addStudent = new AddStudent();

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
            scanner.nextLine(); // Consommer la touche entrée

            switch (choice) {
                case 1:
                    AddStudent.connection();
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

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
