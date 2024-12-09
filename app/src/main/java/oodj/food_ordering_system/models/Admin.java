package oodj.food_ordering_system.models;

public class Admin extends User{
    private String name;
    private String ID;
    private String email;
    private boolean status;
    public Admin(String ID, String username, String password, String name, String email, boolean status) {
        super(username, password);
        this.name = name;
        this.ID = ID;
        this.status = status;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
