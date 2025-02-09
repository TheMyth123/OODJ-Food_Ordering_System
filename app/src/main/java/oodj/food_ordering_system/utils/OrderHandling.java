package oodj.food_ordering_system.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OrderHandling {

    private static final String ORDER = FileHandling.filePath.ORDER_PATH.getValue();

    // Update order status manually
    public static void updateOrderStatus(String orderID, String newStatus) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ORDER)));
            JSONArray ordersArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);

            boolean orderUpdated = false;

            for (int i = 0; i < ordersArray.length(); i++) {
                JSONObject orderData = ordersArray.getJSONObject(i);

                if (orderData.getString("OrderID").equals(orderID)) {
                    orderData.put("Status", newStatus);
                    orderUpdated = true;
                    break;
                }
            }

            if (orderUpdated) {
                FileHandling.writeToFile(ORDER, ordersArray.toString(4), false);
                DialogBox.successMessage("Order " + orderID + " status updated to: " + newStatus, "Success");
            } else {
                DialogBox.errorMessage("Order with ID " + orderID + " not found!", "Error");
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error updating order status: " + e.getMessage(), "Error");
        }
    }

    // Automatically progress order status based on order type
    public static void progressOrder(String orderID) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ORDER)));
            JSONArray ordersArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);

            boolean orderUpdated = false;

            for (int i = 0; i < ordersArray.length(); i++) {
                JSONObject orderData = ordersArray.getJSONObject(i);

                if (orderData.getString("OrderID").equals(orderID)) {
                    String currentStatus = orderData.getString("Status");
                    String orderType = orderData.getString("OrderType");
                    String nextStatus = getNextStatus(currentStatus, orderType);

                    if (nextStatus != null) {
                        orderData.put("Status", nextStatus);
                        orderUpdated = true;
                        break;
                    }
                }
            }

            if (orderUpdated) {
                FileHandling.writeToFile(ORDER, ordersArray.toString(4), false);
                DialogBox.successMessage("Order " + orderID + " status updated successfully!", "Success");
            } else {
                DialogBox.errorMessage("Order with ID " + orderID + " not found or status cannot be progressed!", "Error");
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error progressing order status: " + e.getMessage(), "Error");
        }
    }

    // Determine the next status based on current order status and type
    private static String getNextStatus(String currentStatus, String orderType) {
        switch (orderType) {
            case "Dine-in":
                switch (currentStatus) {
                    case "Order Placed": return "Kitchen is Preparing";
                    case "Kitchen is Preparing": return "Order is Being Served";
                    case "Order is Being Served": return "Payment Completed";
                }
                break;

            case "Take-away":
                switch (currentStatus) {
                    case "Order Placed": return "Kitchen is Preparing";
                    case "Kitchen is Preparing": return "Order is Ready for Pickup";
                    case "Order is Ready for Pickup": return "Order Picked Up";
                    case "Order Picked Up": return "Order Completed";
                }
                break;

            case "Delivery":
                switch (currentStatus) {
                    case "Order Received": return "Kitchen is Preparing";
                    case "Kitchen is Preparing": return "Order is Ready for Pickup";
                    case "Order is Ready for Pickup": return "Rider Has Picked Up the Order";
                    case "Rider Has Picked Up the Order": return "Order Delivered";
                    case "Order Delivered": return "Order Completed";
                }
                break;
        }
        return null;
    }
}
