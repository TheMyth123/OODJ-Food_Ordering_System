package oodj.food_ordering_system.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.utils.FileHandling;

public class Order {

    // File Paths
    private static final String PAYMENT = FileHandling.filePath.PAYMENT_PATH.getValue();
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();

    // Attributes
    private String orderID;
    private String menuNames; 
    private String serviceType;
    private String orderStatus;

    // Constructor
    public Order(String orderID, String menuNames, String serviceType, String orderStatus) {
        this.orderID = orderID;
        this.menuNames = menuNames;
        this.serviceType = serviceType;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getMenuNames() {
        return menuNames;
    }

    public void setMenuNames(String menuNames) {
        this.menuNames = menuNames;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Method to read orders from payment.txt
    public static List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
    
        try {
            // Read the entire JSON array from payment.txt
            String content = new String(Files.readAllBytes(Paths.get(PAYMENT)));
            JSONArray jsonArray = new JSONArray(content);
    
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
    
                String orderID = jsonObject.getString("OrderID");
                String serviceType = jsonObject.getString("ServiceType");
                String orderStatus = jsonObject.getString("OrderStatus");
    
                // Get Order Items and format Menu Names
                JSONArray orderItemsArray = jsonObject.getJSONArray("OrderItems");
                Map<String, Integer> menuCountMap = new HashMap<>();
    
                if (orderItemsArray.length() > 0) {
                    for (int j = 0; j < orderItemsArray.length(); j++) {
                        JSONObject item = orderItemsArray.getJSONObject(j);
    
                        // Check if menuID exists before accessing it
                        // if (item.has("menuID")) {
                        //     String menuID = item.getString("menuID");
                        //     int quantity = item.getInt("quantity");
    
                        //     String menuName = getMenuName(menuID);
                        //     menuCountMap.put(menuName, menuCountMap.getOrDefault(menuName, 0) + quantity);
                        // } else {
                        //     System.out.println("menuID not found in: " + item.toString());
                        // }

                        // Check if menuID exists before accessing it
                        if (item.has("menuID")) {
                            String menuID = item.optString("menuID", "UnknownID");
                            int quantity = item.optInt("quantity", 0);

                            // Debugging information
                            System.out.println("Reading menuID: " + menuID + ", Quantity: " + quantity);

                            if (!menuID.equals("UnknownID") && quantity > 0) {
                                String menuName = getMenuName(menuID);
                                menuCountMap.put(menuName, menuCountMap.getOrDefault(menuName, 0) + quantity);
                            } else {
                                System.out.println("Invalid menuID or quantity for: " + item.toString());
                            }
                        } else {
                            System.out.println("menuID not found in: " + item.toString());
                        }
                    }
                } else {
                    System.out.println("OrderItems is empty for OrderID: " + orderID);
                }
    
                String formattedMenuNames = formatMenuNames(menuCountMap);
    
                // Create Order object
                Order order = new Order(orderID, formattedMenuNames, serviceType, orderStatus);
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    
        return orders;
    }
    
    // Method to get menu name from menuID by reading menu.txt
    private static String getMenuName(String menuID) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menuArray = new JSONArray(content);

            for (int i = 0; i < menuArray.length(); i++) {
                JSONObject menuObject = menuArray.getJSONObject(i);

                // Compare with "id" instead of "menuID"
                if (menuObject.getString("id").equals(menuID)) {
                    // Get the name of the menu item
                    return menuObject.getString("name");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unknown Item";
    }

    // Method to format menu names as required
    private static String formatMenuNames(Map<String, Integer> menuCountMap) {
        StringBuilder formattedMenuNames = new StringBuilder();
        for (Map.Entry<String, Integer> entry : menuCountMap.entrySet()) {
            formattedMenuNames.append(entry.getKey()).append(" x").append(entry.getValue()).append(", ");
        }
        // Remove the last comma and space
        if (formattedMenuNames.length() > 0) {
            formattedMenuNames.setLength(formattedMenuNames.length() - 2);
        }
        return formattedMenuNames.toString();
    }

    // Debugging method to test the output
    public static void main(String[] args) {
        List<Order> orders = getAllOrders();
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Menu Names: " + order.getMenuNames());
            System.out.println("Service Type: " + order.getServiceType());
            System.out.println("Order Status: " + order.getOrderStatus());
            System.out.println("----------------------------------------");
        }
    }
}
