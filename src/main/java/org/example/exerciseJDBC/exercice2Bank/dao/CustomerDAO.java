package org.example.exerciseJDBC.exercice2Bank.dao;
import org.example.exerciseJDBC.exercice2Bank.utils.DatabaseManager;
import org.example.exerciseJDBC.exercice2Bank.entity.Customer;

import java.sql.*;

public class CustomerDAO {
    public Customer createCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (first_name, last_name, phone) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhone());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) throw new SQLException("Échec de création de compte client.");

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Échec de création de compte client, pas d'ID obtenu");
                }
            }
        }
        return customer;
    }

    public Customer findById(int id) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Customer c = new Customer();
                    c.setId(resultSet.getInt("id"));
                    c.setFirstName(resultSet.getString("first_name"));
                    c.setLastName(resultSet.getString("last_name"));
                    c.setPhone(resultSet.getString("phone"));
                    return c;
                }
            }
        }
        return null;
    }
}
