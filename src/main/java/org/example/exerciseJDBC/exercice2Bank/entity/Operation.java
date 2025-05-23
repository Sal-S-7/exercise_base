package org.example.exerciseJDBC.exercice2Bank.entity;

public class Operation {
    public Operation() {

    }

    public enum OperationStatus {DEPOSIT, WITHDRAWAL}

    private int id;
    private double amount;
    private OperationStatus status;
    private int accountId;

    public Operation(int id, double amount, OperationStatus status, int accountId) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}

