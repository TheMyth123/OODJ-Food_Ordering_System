package oodj.food_ordering_system.models;

import java.time.LocalDate;

public class Credit {
    private String customerID;
    private double amount;
    private LocalDate date;

    public Credit(String customerID, double amount, LocalDate date) {
        this.customerID = customerID;
        this.amount = amount;
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}