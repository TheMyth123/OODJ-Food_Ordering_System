package oodj.food_ordering_system.models;

public class Customer extends User{
    private String ID, name, gender, DOB, contactnumber, email;    
    private Boolean status;
    public Customer(String ID, String username, String name, String contactnumber, String password, String gender,String DOB, String email, Boolean status){
        super(username, password);
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
        this.contactnumber = contactnumber;
        this.email = email;
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
    
    public Boolean getStatus(){
        return status;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }
}