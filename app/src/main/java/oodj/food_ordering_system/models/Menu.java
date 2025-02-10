package oodj.food_ordering_system.models;

public class Menu {
    private String status;
    private String id;
    private String vendorID;
    private String name;
    private String description;
    private String price;
    private String imagePath;

    public Menu(String status, String id, String vendorID, String name, String description, String price, String imagePath) {
        this.status = status;
        this.id = id;
        this.vendorID = vendorID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}