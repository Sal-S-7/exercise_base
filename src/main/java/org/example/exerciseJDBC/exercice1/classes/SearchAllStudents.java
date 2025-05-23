package org.example.exerciseJDBC.exercice1.classes;

import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchAllStudents {
    public static Connection connection() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

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
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}
