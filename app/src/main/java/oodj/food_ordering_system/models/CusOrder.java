package oodj.food_ordering_system.models;

public class CusOrder {
    private String menuID;
    private int quantity;
    private double price;
    private String imagePath;
    private String name;
    private String description;
    private Customer customer;
    private String orderType;
    private Vendor vendor;



    // public CusOrder(String menuID, int quantity, double price,
    //                 String name, Customer customer) {
    //     this.menuID = menuID;
    //     this.quantity = quantity;
    //     this.price = price;
    //     this.name = name;
    //     this.customer = customer;


    // }

    public CusOrder(String menuID, int quantity, double price, String name, Customer customer, Vendor vendor) {
        this.menuID = menuID;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.customer = customer;
        this.vendor = vendor;
    }

    

    // Getters and Setters
    public String getMenuID() { 
        return menuID; 
    }
    public void setMenuID(String menuID) {
        this.menuID = menuID; 
    }

    public int getQuantity() { 
        return quantity; 
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    public double getPrice() { 
        return price; 
    }
    public void setPrice(double price) { 
        this.price = price; 
    }

    public String getImagePath() { 
        return imagePath; 
    }

    public void setImagePath(String imagePath) { 
        this.imagePath = imagePath; 
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRunnerID() {
        return vendor.getRunnerID(); // Always get runner ID from the vendor
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
      
}
