package oodj.food_ordering_system.models;

import org.json.JSONObject;
import org.json.JSONArray;

public class Payment {
    private String customerID;
    private String serviceType;
    private double totalAmount;
    private String paymentStatus;
    private JSONArray orderItems;
    private Credit credit;

    public Payment(String customerID, String serviceType, double totalAmount, String paymentStatus, JSONArray orderItems, Credit credit) {
        this.customerID = customerID;
        this.serviceType = serviceType;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.orderItems = orderItems;
        this.credit = credit;
    }

    // Getter and Setter methods

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public JSONArray getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(JSONArray orderItems) {
        this.orderItems = orderItems;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

}
