package org.example.exerciseJDBC.exercice2Bank.dao;
import org.example.exerciseJDBC.exercice2Bank.utils.DatabaseManager;
import org.example.exerciseJDBC.exercice2Bank.entity.Operation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO {

    public Operation createOperation(Operation operation) throws SQLException {
        String sql = "INSERT INTO Operation (amount, status, account_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, operation.getAmount());
            preparedStatement.setString(2, operation.getStatus().name());
            preparedStatement.setInt(3, operation.getAccountId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) throw new SQLException("Échec de l'opération.");

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    operation.setId(generatedKeys.getInt(1));
                }
            }
        }
        return operation;
    }

    public List<Operation> findByAccountId(int accountId) throws SQLException {
        String sql = "SELECT * FROM Operation WHERE account_id = ?";
        List<Operation> operations = new ArrayList<>();
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    Operation operation = new Operation();
                    operation.setId(resultSet.getInt("id"));
                    operation.setAmount(resultSet.getDouble("amount"));
                    operation.setStatus(Operation.OperationStatus.valueOf(resultSet.getString("status")));
                    operation.setAccountId(resultSet.getInt("account_id"));
                    operations.add(operation);
                }
            }
        }
        return operations;
    }
}
