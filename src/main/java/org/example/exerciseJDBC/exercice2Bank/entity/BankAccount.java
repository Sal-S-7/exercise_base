package org.example.exerciseJDBC.exercice2Bank.entity;

import java.util.List;

public class BankAccount {
    private int id;
    private int customerId;
    private Customer customer;
    private List<Operation> operations;
    private double totalAmount;

    public BankAccount(int id, int customerId, Customer customer, List<Operation> operations, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.customer = customer;
        this.operations = operations;
        this.totalAmount = totalAmount;
    }

    public BankAccount() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}


