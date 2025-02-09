package oodj.food_ordering_system.models;

public class Rating {
    private Payment orderID;
    private Customer customerID;
    private int rating;
    private Boolean status;


    public Rating(Payment orderID, Customer customerID, int rating, Boolean status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.rating = rating;
        this.status = status;
    }

    // Getter and Setter methods

    public Payment getOrderID() {
        return orderID;
    }

    public void setOrderID(Payment orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}