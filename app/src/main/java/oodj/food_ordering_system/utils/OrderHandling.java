package oodj.food_ordering_system.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrderHandling {

    private static final String ORDER = FileHandling.filePath.ORDER_PATH.getValue();

    // dine in status: Order placed > Kitchen is preparing > Order is being served > Payment completed
    // takeaway status: Order placed > Kitchen is preparing > Order is ready for pickup > Order picked up > Order completed
    // delivery status: Order received > Kitchen is preparing > Order is ready for pickup > Rider has picked up the order > Order delivered > Order completed

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


    // test the code
    public static void main(String[] args) {
        // updateOrderStatus("ORD001", "Kitchen is preparing");
    }
}
