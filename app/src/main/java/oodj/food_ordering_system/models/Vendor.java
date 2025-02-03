package oodj.food_ordering_system.models;

public class Vendor {
    // Attributes
    private int vendorID;
    private String vendorName;
    private String foodCourtName;
    private String contactNumber;
    private String username;
    private String password;
    private boolean status; // true for active, false for inactive
    private String dateRegistered;

    // Constructor
    public Vendor(int vendorID, String vendorName, String foodCourtName, String contactNumber, 
                  String username, String password, boolean status, String dateRegistered) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.foodCourtName = foodCourtName;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        this.status = status;
        this.dateRegistered = dateRegistered;
    }

    // Getters and Setters
    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getFoodCourtName() {
        return foodCourtName;
    }

    public void setFoodCourtName(String foodCourtName) {
        this.foodCourtName = foodCourtName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    // Methods
    public void activateVendor() {
        this.status = true;
    }

    public void deactivateVendor() {
        this.status = false;
    }

    public String displayVendorInfo() {
        return "VendorID: " + vendorID + 
               "\nVendorName: " + vendorName + 
               "\nFoodCourtName: " + foodCourtName + 
               "\nContactNumber: " + contactNumber + 
               "\nStatus: " + (status ? "Active" : "Inactive") +
               "\nDateRegistered: " + dateRegistered;
    }
}