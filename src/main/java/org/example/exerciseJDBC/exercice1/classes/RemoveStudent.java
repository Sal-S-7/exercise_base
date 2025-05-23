package org.example.exerciseJDBC.exercice1.classes;

import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class RemoveStudent {
    public static Connection connection() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            connection = ConnectionUtils.getSQLConnection();
            String request3 = "DELETE FROM students WHERE id = ? ";
            PreparedStatement statement = connection.prepareStatement(request3);

            System.out.println("Entrez l'id de l'étudiant : ");
            int getId = scanner.nextInt();
            statement.setInt(1, getId);
            statement.executeUpdate();
            System.out.println("Vous avez supprimez l'étudiant " + getId);


        } catch (SQLException e) {
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
