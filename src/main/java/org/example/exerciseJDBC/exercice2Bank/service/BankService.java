package org.example.exerciseJDBC.exercice2Bank.service;

import org.example.exerciseJDBC.exercice2Bank.dao.BankAccountDAO;
import org.example.exerciseJDBC.exercice2Bank.dao.CustomerDAO;
import org.example.exerciseJDBC.exercice2Bank.dao.OperationDAO;
import org.example.exerciseJDBC.exercice2Bank.entity.BankAccount;
import org.example.exerciseJDBC.exercice2Bank.entity.Customer;
import org.example.exerciseJDBC.exercice2Bank.entity.Operation;

import java.sql.SQLException;
import java.util.List;

public class BankService {
    private CustomerDAO customerDAO = new CustomerDAO();
    private BankAccountDAO accountDAO = new BankAccountDAO();
    private OperationDAO operationDAO = new OperationDAO();

    public BankAccount createCustomer(String firstName, String lastName, String phone) throws SQLException {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);

        customer = customerDAO.createCustomer(customer);

        BankAccount account = accountDAO.createAccount(customer.getId());
        account.setCustomer(customer);
        return account;
    }

    public void deposit(int accountId, double amount) throws SQLException {
        if (amount <= 0) throw new IllegalArgumentException("Le dépôt doît être positive.");

        BankAccount account = accountDAO.findById(accountId);
        if (account == null) throw new IllegalArgumentException("Compte non trouvée.");

        Operation op = new Operation();
        op.setAmount(amount);
        op.setStatus(Operation.OperationStatus.DEPOSIT);
        op.setAccountId(accountId);
        operationDAO.createOperation(op);

        double newTotal = account.getTotalAmount() + amount;
        accountDAO.updateTotalAmount(accountId, newTotal);
    }

    public void withdraw(int accountId, double amount) throws SQLException {
        if (amount <= 0) throw new IllegalArgumentException("Le retrait doît être positive.");

        BankAccount account = accountDAO.findById(accountId);
        if (account == null) throw new IllegalArgumentException("Compte non trouvée.");

        if (account.getTotalAmount() < amount) throw new IllegalArgumentException("Fonds insuffisant.");

        Operation op = new Operation();
        op.setAmount(amount);
        op.setStatus(Operation.OperationStatus.WITHDRAWAL);
        op.setAccountId(accountId);
        operationDAO.createOperation(op);

        double newTotal = account.getTotalAmount() - amount;
        accountDAO.updateTotalAmount(accountId, newTotal);
    }

    public BankAccount getAccountDetails(int accountId) throws SQLException {
        BankAccount account = accountDAO.findById(accountId);
        if (account == null) return null;

        Customer customer = customerDAO.findById(account.getCustomerId());
        account.setCustomer(customer);

        List<Operation> ops = operationDAO.findByAccountId(accountId);
        account.setOperations(ops);

        return account;
    }
}
