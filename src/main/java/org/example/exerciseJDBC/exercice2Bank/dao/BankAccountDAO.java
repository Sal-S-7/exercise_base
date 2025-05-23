package org.example.exerciseJDBC.exercice2Bank.dao;
import org.example.exerciseJDBC.exercice2Bank.utils.DatabaseManager;
import org.example.exerciseJDBC.exercice2Bank.entity.BankAccount;

import java.sql.*;

public class BankAccountDAO {
    public BankAccount createAccount(int customerId) throws SQLException {
        String sql = "INSERT INTO bankaccount (customer_id, total_amount) VALUES (?, 0)";
        BankAccount account = new BankAccount();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, customerId);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) throw new SQLException("Échec de création de compte.");
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    account.setId(generatedKeys.getInt(1));
                    account.setCustomerId(customerId);
                    account.setTotalAmount(0);
                }
            }
        }
        return account;
    }

    public BankAccount findById(int id) throws SQLException {
        String sql = "SELECT * FROM bankaccount WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    BankAccount account = new BankAccount();
                    account.setId(resultSet.getInt("id"));
                    account.setCustomerId(resultSet.getInt("customer_id"));
                    account.setTotalAmount(resultSet.getDouble("total_amount"));
                    return account;
                }
            }
        }
        return null;
    }

    public void updateTotalAmount(int accountId, double newTotal) throws SQLException {
        String sql = "UPDATE bankaccount SET total_amount = ? WHERE id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, newTotal);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        }
    }
}