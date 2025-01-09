package oodj.food_ordering_system.models;

public class Vendor extends User{
    private String ID, name, foodcourtname, DOB, contactnumber, email;    
    private Boolean status;
    public Vendor(String ID, String name, String foodcourtname, String contactnumber, String username, String password, Boolean status, String DOB, String email){
        super(username, password);
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
        this.contactnumber = contactnumber;
        this.foodcourtname = foodcourtname;
        this.status = status;
        this.email = email;
    }
    
    public Vendor(String ID, String foodCourtName) {
        super("", "");
        this.ID = ID;
        this.foodcourtname = foodCourtName;
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
    
    public String getContactnumber() {
        return contactnumber;
    }
    
    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }  

    public String getFoodCourtName(){
        return foodcourtname;
    }
    
    public void setFoodCourtName(String foodcourtname){
        this.foodcourtname = foodcourtname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public Boolean getStatus(){
        return status;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }
}