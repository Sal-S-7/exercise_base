package org.example.exerciseJDBC.exercice1;


import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;

import java.sql.*;
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

                    try {
                        connection = ConnectionUtils.getSQLConnection();
                        String request2 = "SELECT * FROM students";
                        Statement statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(request2);
                        System.out.println("Voici la liste des étudiants : ");
                        while (resultSet.next()) {
                            System.out.print(" Prenom : " + resultSet.getString("first_name"));
                            System.out.print(" Nom : " + resultSet.getString("last_name"));
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        try {
                            connection.close();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 3:

                    try {
                        connection = ConnectionUtils.getSQLConnection();
                        String request1 = "SELECT * FROM students where class_id = ? ";
                        PreparedStatement statement = connection.prepareStatement(request1);

                        System.out.println("Entrez le numéro de la classe recherché : ");
                        int getId = scanner.nextInt();
                        statement.setInt(1, getId);
                        System.out.println("Voici la liste des étudiants dans le numéro de classe " + getId + " : ");
                        ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                            System.out.println(resultSet.getString("first_name"));
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        try {
                            connection.close();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 4:

                    try {
                        connection = ConnectionUtils.getSQLConnection();
                        String request3 = "DELETE FROM students WHERE id = ? ";
                        PreparedStatement statement = connection.prepareStatement(request3);

                        System.out.println("Entrez l'id de l'étudiant : ");
                        int getId = scanner.nextInt();
                        statement.setInt(1, getId);
                        System.out.println("Vous avez supprimez l'étudiant " + getId);

                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    } finally {
                        try {
                            connection.close();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
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
