package oodj.food_ordering_system.models;

import java.time.LocalDate;

public class Credit {
    private String creditID;
    private String customerID;
    private double amount;
    private LocalDate date;
    private String status;
    private String receiptImagePath;

    public Credit(String creditID, String customerID, double amount, LocalDate date, String status, String receiptImagePath) {
        this.creditID = creditID;
        this.customerID = customerID;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.receiptImagePath = receiptImagePath;
    }

    public String getCreditID() {
        return creditID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getReceiptImagePath() {
        return receiptImagePath;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReceiptImagePath(String receiptImagePath) {
        this.receiptImagePath = receiptImagePath;
    }
}