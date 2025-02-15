package oodj.food_ordering_system.models;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Date;

public class Payment {
    private String orderID;
    private String customerID;
    private String serviceType;
    private double totalAmount;
    private String paymentStatus;
    private String address;
    private String date;
    private String orderStatus;
    private ArrayList<CusOrder> orderItems; // ✅ Added to store order items

    // ✅ Updated constructor to include order items
    public Payment(String orderID, String customerID, String serviceType, double totalAmount,
                   String paymentStatus, String address, String date, String orderStatus,
                   ArrayList<CusOrder> orderItems) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.serviceType = serviceType;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.address = address;
        this.date = date;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems; // ✅ Assign order items
    }

    // ✅ Getter method for order items
    public ArrayList<CusOrder> getOrderItems() {
        return orderItems;
    }



    // Getter and Setter methods



    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

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

    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // public JSONArray getOrderItems() {
    //     return this.orderItems; // Ensure 'orderItems' is a valid field in Payment
    // }

    

}
