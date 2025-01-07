package oodj.food_ordering_system.models;

public class Vendor {

    private String username, password, name, address, contactNo;

    public Vendor(String username, String password, String name, String address, String contactNo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
    @Override
    public String toString() {
        return "Vendor{" + "username=" + username + ", password=" + password + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo + '}';
    }
    
}
