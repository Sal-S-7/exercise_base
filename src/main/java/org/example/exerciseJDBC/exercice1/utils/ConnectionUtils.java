package org.example.exerciseJDBC.exercice1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getSQLConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/users_demo_ex1";
        String username = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}