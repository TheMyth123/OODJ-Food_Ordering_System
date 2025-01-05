package oodj.food_ordering_system.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.models.Credit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderHandling {
    
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();
    private static final String CART = FileHandling.filePath.CART_PATH.getValue();
    private static final String CREDIT = FileHandling.filePath.CREDIT_PATH.getValue();
    private static final String PAYMENT = FileHandling.filePath.PAYMENT_PATH.getValue();


    public static List<JSONObject> readMenuFile(String vendorID) throws IOException {
         // Path to the menu file
        ArrayList<String> lines = FileHandling.readLines(MENU);
        StringBuilder jsonData = new StringBuilder();
        for (String line : lines) {
            jsonData.append(line);
        }
        JSONArray menuArray = new JSONArray(jsonData.toString());
        List<JSONObject> menuItems = new ArrayList<>();
        for (int i = 0; i < menuArray.length(); i++) {
            menuItems.add(menuArray.getJSONObject(i));
        }
        return filterMenuByVendor(menuItems, vendorID);
    }

    public static List<JSONObject> filterMenuByVendor(List<JSONObject> menuItems, String vendorID) {
        List<JSONObject> filteredMenu = new ArrayList<>();
         // Convert vendorID to string for comparison
        for (JSONObject item : menuItems) {
            if (item.getString("VendorID").equals(vendorID)) {
                filteredMenu.add(item);
            }
        }
        return filteredMenu;
    }
// TODO filter when the data already pass to order.txt
    public static ArrayList<String> getCart() {
        ArrayList<String> cartItems = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(CART)));
            if (!content.isEmpty()) {
                JSONArray cartArray = new JSONArray(content);
                for (int i = 0; i < cartArray.length(); i++) {
                    JSONObject item = cartArray.getJSONObject(i);
                    String itemDetails = "quantity: " + item.getString("quantity") + ", " +
                                         "price: " + item.getString("price") + ", " +
                                         "imagePath: " + item.getString("imagePath") + ", " +
                                         "name: " + item.getString("name");
                    cartItems.add(itemDetails);
                }
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Error reading or parsing the JSON file: " + e.getMessage(), "Error");
        }
        return cartItems;
    }

    public static void saveCart(List<String> cartItems) {
        JSONArray cartArray = new JSONArray();
        for (String item : cartItems) {
            String[] itemParts = item.split(", ");
            JSONObject jsonObject = new JSONObject();
            for (String part : itemParts) {
                String[] keyValue = part.split(": ");
                jsonObject.put(keyValue[0], keyValue[1]);
            }
            cartArray.put(jsonObject);
        }
        try {
            Files.write(Paths.get(CART), cartArray.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Credit> getCredits() {
        List<Credit> buffer = new ArrayList<>();

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(CREDIT)));
            JSONArray creditsArray = new JSONArray(jsonData);

            for (int i = 0; i < creditsArray.length(); i++) {
                JSONObject creditData = creditsArray.getJSONObject(i);

                String customerID = creditData.getString("CustomerID");
                double amount = creditData.getDouble("CreditAmount");
                String lastUpdatedStr = creditData.getString("LastUpdated");
                LocalDate lastUpdated = LocalDate.parse(lastUpdatedStr, DateTimeFormatter.ISO_DATE);

                Credit credit = new Credit(customerID, amount, lastUpdated);
                buffer.add(credit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }

    public static void saveCredits(List<Credit> credits) {
        JSONArray creditsArray = new JSONArray();

        for (Credit credit : credits) {
            JSONObject creditData = new JSONObject();
            creditData.put("CustomerID", credit.getCustomerID());
            creditData.put("CreditAmount", credit.getAmount());
            creditData.put("LastUpdated", credit.getDate().toString());

            creditsArray.put(creditData);
        }

        try {
            Files.write(Paths.get(CREDIT), creditsArray.toString(4).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void savePayment(String orderID, String customerID, String foodName, String quantity, double totalAmount, String address) {
        JSONArray paymentsArray = new JSONArray();

        try {
            // Load existing payments
            if (Files.exists(Paths.get(PAYMENT))) {
                String jsonData = new String(Files.readAllBytes(Paths.get(PAYMENT)));
                if (!jsonData.trim().isEmpty()) {
                    paymentsArray = new JSONArray(jsonData);
                }
            }

            // Create new payment record
            JSONObject paymentData = new JSONObject();
            paymentData.put("OrderID", orderID);
            paymentData.put("CustomerID", customerID);
            paymentData.put("FoodName", foodName);
            paymentData.put("Quantity", quantity);
            paymentData.put("TotalAmount", totalAmount);
            paymentData.put("Address", address);
            paymentData.put("Date", LocalDate.now().toString());

            // Add new payment record to array
            paymentsArray.put(paymentData);

            // Save updated payments array to file
            Files.write(Paths.get(PAYMENT), paymentsArray.toString(7).getBytes()); // Indent with 4 spaces
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
