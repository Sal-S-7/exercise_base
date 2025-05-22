package org.example.exerciseJDBC.exercice1;

import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class AddStudent {
    public static Connection connection() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
        connection = ConnectionUtils.getSQLConnection();
        System.out.println("--- WELCOME ---");
        System.out.println("Saisir le prénom de l'élève :");
        String firstname = scanner.nextLine();
        System.out.println("Saisir le nom de l'élève :");
        String lastname = scanner.nextLine();
        System.out.println("Saisir le numéro de classe :");
        int classId = scanner.nextInt();
        System.out.println("Saisir la date de diplôme :");
        String diplomaDate = scanner.next();

        String request = "INSERT INTO students (first_name,last_name,class_id,diploma_date) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setInt(3, classId);
        preparedStatement.setString(4, diplomaDate);

        preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }
}
