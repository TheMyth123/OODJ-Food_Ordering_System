package oodj.food_ordering_system.models;

public class CusOrder {
    // public enum OrderType {
    //     DINE_IN(0),
    //     TAKE_AWAY(1),
    //     DELIVERY(2);

    //     private final int value;

    //     OrderType(int value) {
    //         this.value = value;
    //     }

    //     public int getValue() {
    //         return value;
    //     }

    //     public static OrderType fromValue(int value) {
    //         for (OrderType type : values()) {
    //             if (type.value == value) {
    //                 return type;
    //             }
    //         }
    //         throw new IllegalArgumentException("Unknown order type value: " + value);
    //     }
    // }

    // private OrderType orderType;

    // public Cart(int orderTypeValue) {
    //     this.orderType = OrderType.fromValue(orderTypeValue);
    // }

    // public OrderType getOrderType() {
    //     return orderType;
    // }

    // public void setOrderType(int orderTypeValue) {
    //     this.orderType = OrderType.fromValue(orderTypeValue);
    // }


        private String menuID;
        private int quantity;
        private double price;
        private String imagePath;
        private String name;
        private String description;
        private Customer customer;
    
        // Constructor
        public CusOrder(String menuID, int quantity, double price, String imagePath, 
                        String name, String description, Customer customer) {
            this.menuID = menuID;
            this.quantity = quantity;
            this.price = price;
            this.imagePath = imagePath;
            this.name = name;
            this.description = description;
            this.customer = customer;
        }

        public CusOrder(String menuID, int quantity, double price,
                        String name) {
            this.menuID = menuID;
            this.quantity = quantity;
            this.price = price;
            this.name = name;
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
    
        
        
    
    
}
