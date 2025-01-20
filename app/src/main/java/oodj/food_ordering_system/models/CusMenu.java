package oodj.food_ordering_system.models;



public class CusMenu {
    private String menuID;
    private int quantity;
    private String price;
    private String imagePath;
    private String name;
    private String description;
    private String customerID;
    private String orderType;

    public CusMenu(String menuID, int quantity, String price, String imagePath, String name, String description, String customerID, String orderType) {
        this.menuID = menuID;
        this.quantity = quantity;
        this.price = price;
        this.imagePath = imagePath;
        this.name = name;
        this.description = description;
        this.customerID = customerID;
        this.orderType = orderType;
    }

    // public CartItem(JSONObject jsonObject) {
    //     this.menuID = jsonObject.getString("MenuID");
    //     this.quantity = jsonObject.getString("quantity");
    //     this.price = jsonObject.getString("price");
    //     this.imagePath = jsonObject.getString("imagePath");
    //     this.name = jsonObject.getString("name");
    //     this.description = jsonObject.getString("description");
    //     this.customerID = jsonObject.getString("CustomerID");
    //     this.orderType = jsonObject.getString("orderType");
    // }

    // public JSONObject toJson() {
    //     JSONObject jsonObject = new JSONObject();
    //     jsonObject.put("MenuID", menuID);
    //     jsonObject.put("quantity", quantity);
    //     jsonObject.put("price", price);
    //     jsonObject.put("imagePath", imagePath);
    //     jsonObject.put("name", name);
    //     jsonObject.put("description", description);
    //     jsonObject.put("CustomerID", customerID);
    //     jsonObject.put("orderType", orderType);
    //     return jsonObject;
    // }

    // Getters and setters
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}