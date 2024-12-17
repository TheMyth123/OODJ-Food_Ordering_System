package oodj.food_ordering_system.models;

public class DeliveryRunner extends User{
    private String ID, name, gender, DOB, contactnumber, email, vehicle, license;    
    private Boolean status;
    public DeliveryRunner(String ID, String username, String name, String contactnumber, String password, String gender,String DOB, String email, String vehicle, String license, Boolean status){
        super(username, password);
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
        this.contactnumber = contactnumber;
        this.email = email;
        this.vehicle = vehicle;
        this.license = license;
        this.status = status;
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
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
    
    public Boolean getStatus(){
        return status;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }
}