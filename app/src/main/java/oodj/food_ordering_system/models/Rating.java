package oodj.food_ordering_system.models;

public class Rating {
    private String orderID;
    private String customerID;
    private String vendorID; // NEW: Vendor ID for filtering
    private int rating;
    private Boolean status;
    private RatingType ratingType; // New field to categorize ratings

    // Enum for Rating Categories
    public enum RatingType {
        FOOD, VENDOR, RUNNER
    }

    public Rating(String orderID, String customerID, String vendorID, int rating, RatingType ratingType, boolean status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.rating = rating;
        this.status = status;
        this.ratingType = ratingType;
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

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
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

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }
}
