package org.example.exerciseJDBC.exercice1.classes;

import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchClassStudent {
    public static Connection connection() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

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
