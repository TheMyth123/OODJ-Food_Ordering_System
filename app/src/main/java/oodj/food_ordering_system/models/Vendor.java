package oodj.food_ordering_system.models;

public class Vendor extends User {
    private String ID, name, foodcourtname, DOB, contactnumber, email;    
    private Boolean status;
    private double rating; // Added missing rating variable
    private String runnerID;


    public Vendor(String ID, String name, String foodcourtname, String contactnumber, String username, String password, Boolean status, String DOB, String email) {
        super(username, password); // Use the superclass User constructor
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
        this.contactnumber = contactnumber;
        this.foodcourtname = foodcourtname;
        this.status = status;
        this.email = email;
        // this.rating = 0.0; // Initialize rating
    }

    

    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }  
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDOB() {
        return DOB;
    }
    
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    
    public String getContactnumber() { // Renamed method to follow Java naming conventions
        return contactnumber;
    }
    
    public void setContactnumber(String contactnumber) { // Renamed method
        this.contactnumber = contactnumber;
    }  

    public String getFoodCourtName() {
        return foodcourtname;
    }
    
    public void setFoodCourtName(String foodcourtname) {
        this.foodcourtname = foodcourtname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public double getRating() { // Added missing rating getter
        return rating;
    }

    public void setRating(double rating) { // Added missing rating setter
        this.rating = rating;
    }

    // Methods
    public void activateVendor() {
        this.status = true;
    }

    public void deactivateVendor() {
        this.status = false;
    }


    public String displayVendorInfo() {
        return "VendorID: " + ID + 
               "\nVendorName: " + name + 
               "\nFoodCourtName: " + foodcourtname + 
               "\nContactNumber: " + contactnumber + 
               "\nStatus: " + (status ? "Active" : "Inactive") +
               "\nDateRegistered: " + DOB;
    }
}