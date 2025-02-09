package oodj.food_ordering_system.models;

public class Item {
    private String itemID;
    private String vendorID;
    private String itemName;
    private String category;
    private double price;
    private boolean status; // true for available, false for unavailable

    public Item(String itemID, String vendorID, String itemName, String category, double price, boolean status) {
        this.itemID = itemID;
        this.vendorID = vendorID;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.status = status;
    }

    public String getItemID() {
        return itemID;
    }

    public String getVendorID() {
        return vendorID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    // Methods
    public void activateItem() {
        this.status = true;
    }

    public void deactivateItem() {
        this.status = false;
    }

    public String displayItemInfo() {
        return "ItemID: " + itemID +
               "\nVendorID: " + vendorID +
               "\nItemName: " + itemName +
               "\nCategory: " + category +
               "\nPrice: $" + price +
               "\nAvailability: " + (status ? "Available" : "Unavailable");
    }
}
