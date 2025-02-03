package oodj.food_ordering_system.models;
// TODO add status

public class Rating {
    private Payment orderID;
    private Customer customerID;
    private int rating;

    public Rating(Payment orderID, Customer customerID, int rating) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.rating = rating;
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
}