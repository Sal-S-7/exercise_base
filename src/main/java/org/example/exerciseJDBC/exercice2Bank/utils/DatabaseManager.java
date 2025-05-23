package org.example.exerciseJDBC.exercice2Bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static String URI = "jdbc:mysql://localhost:3306/bank_ex2";
    private static String USER = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
