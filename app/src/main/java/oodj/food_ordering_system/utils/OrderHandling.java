package oodj.food_ordering_system.utils;

import oodj.food_ordering_system.models.Credit;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderHandling {
    
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();
    private static final String CART = FileHandling.filePath.CART_PATH.getValue();
    private static final String CREDIT = FileHandling.filePath.CREDIT_PATH.getValue();
    private static final String PAYMENT = FileHandling.filePath.PAYMENT_PATH.getValue();
    public static final String RECEIPT_FOLDER = "app/src/main/resources/receipts/";
    private static final String TOPUP = FileHandling.filePath.TOPUP_PATH.getValue();

    public static int getCRid() {
        int tempCount = 0;
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(TOPUP)));
            JSONArray topUpArray = new JSONArray(jsonData);
    
            for (int i = 0; i < topUpArray.length(); i++) {
                JSONObject topUpData = topUpArray.getJSONObject(i);
                String creditID = topUpData.getString("CustomerID");
                if (creditID.contains("CS")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            // Display error if file reading or parsing fails
            DialogBox.errorMessage("Error reading or parsing customer JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    public static ArrayList<JSONObject> readMenuFile(String vendorID) throws IOException {
        // Path to the menu file
        ArrayList<String> lines = FileHandling.readLines(MENU);
        StringBuilder jsonData = new StringBuilder();
        for (String line : lines) {
            jsonData.append(line);
        }
        JSONArray menuArray = new JSONArray(jsonData.toString());
        ArrayList<JSONObject> menuItems = new ArrayList<>();
        for (int i = 0; i < menuArray.length(); i++) {
            menuItems.add(menuArray.getJSONObject(i));
        }
        return filterMenuByVendor(menuItems, vendorID);
    }

    public static ArrayList<JSONObject> filterMenuByVendor(ArrayList<JSONObject> menuItems, String vendorID) {
        ArrayList<JSONObject> filteredMenu = new ArrayList<>();
        // Convert vendorID to string for comparison
        for (JSONObject item : menuItems) {
            if (item.getString("VendorID").equals(vendorID)) {
                filteredMenu.add(item);
            }
        }
        return filteredMenu;
    }

    public static ArrayList<String> getCart() {
        ArrayList<String> lines = FileHandling.readLines(CART);

        ArrayList<String> cartItems = new ArrayList<>();
        StringBuilder jsonData = new StringBuilder();
        for (String line : lines) {
            jsonData.append(line);
        }
        if (!jsonData.toString().isEmpty()) {
            try {
                JSONArray cartArray = new JSONArray(jsonData.toString());
                for (int i = 0; i < cartArray.length(); i++) {
                    JSONObject item = cartArray.getJSONObject(i);
                    String itemDetails = "quantity: " + item.getString("quantity") + ", " +
                                         "price: " + item.getString("price") + ", " +
                                         "imagePath: " + item.getString("imagePath") + ", " +
                                         "name: " + item.getString("name");
                    cartItems.add(itemDetails);
                }
            } catch (Exception e) {
                DialogBox.errorMessage("Error reading or parsing the JSON file: " + e.getMessage(), "Error");
            }
        }
        return cartItems;
    }

    public static void saveCart(ArrayList<String> cartItems) {
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
        FileHandling.saveToFile(cartArray, CART);
    }

    public static ArrayList<Credit> getCredits() {
        ArrayList<Credit> buffer = new ArrayList<>();

        try {
            ArrayList<String> lines = FileHandling.readLines(TOPUP);
            StringBuilder jsonData = new StringBuilder();
            for (String line : lines) {
                jsonData.append(line);
            }
            JSONArray creditsArray = new JSONArray(jsonData.toString());

            for (int i = 0; i < creditsArray.length(); i++) {
                JSONObject creditData = creditsArray.getJSONObject(i);

                String creditID = creditData.getString("CreditID");
                String customerID = creditData.getString("CustomerID");
                double amount = creditData.getDouble("CreditAmount");
                String lastUpdatedStr = creditData.getString("LastUpdated");
                LocalDate lastUpdated = LocalDate.parse(lastUpdatedStr, DateTimeFormatter.ISO_DATE);
                String status = creditData.getString("Status");
                String receiptImagePath = creditData.getString("ReceiptImagePath");

                Credit credit = new Credit(creditID, customerID, amount, lastUpdated, status, receiptImagePath);
                buffer.add(credit);
            }
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing the JSON file: " + e.getMessage(), "Error");
        }

        return buffer;
    }

    // public static void saveCredits(ArrayList<Credit> credits) {
    //     JSONArray creditsArray = new JSONArray();

    //     for (Credit credit : credits) {
    //         JSONObject creditData = new JSONObject();
    //         creditData.put("CreditID", credit.getCreditID());
    //         creditData.put("CustomerID", credit.getCustomerID());
    //         creditData.put("CreditAmount", credit.getAmount());
    //         creditData.put("LastUpdated", credit.getDate().toString());
    //         creditData.put("Status", credit.getStatus());
    //         creditData.put("ReceiptImagePath", RECEIPT_FOLDER + credit.getCreditID());

    //         creditsArray.put(creditData);
    //     }

    //     FileHandling.saveToFile(creditsArray, CREDIT);
    // }

    public static void saveCredits(Credit credit, String receiptImagePath) {
        // Get existing credits
        ArrayList<Credit> credits = getCredits();
        
        // Add the new credit
        credits.add(credit);
        
        // Save the updated credits
        JSONArray creditsArray = new JSONArray();

        for (Credit c : credits) {
            JSONObject creditData = new JSONObject();
            creditData.put("CreditID", c.getCreditID());
            creditData.put("CustomerID", c.getCustomerID());
            creditData.put("CreditAmount", c.getAmount());
            creditData.put("LastUpdated", c.getDate().toString());
            creditData.put("Status", c.getStatus());
            creditData.put("ReceiptImagePath", RECEIPT_FOLDER + c.getCreditID() + ".jpg");

            creditsArray.put(creditData);
        }

        try {
            FileHandling.writeToFile(TOPUP, creditsArray, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Copy the receipt image to the specified folder
        try {
            if (receiptImagePath == null) {
                throw new NullPointerException("Receipt image path is null");
            }
            File sourceFile = new File(receiptImagePath);
            if (!sourceFile.exists()) {
                throw new IOException("Source file does not exist: " + receiptImagePath);
            }
            File destFile = new File(RECEIPT_FOLDER + credit.getCreditID() + ".jpg");
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Receipt image copied to: " + destFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePayment(String orderID, String customerID, String foodName, String quantity, double totalAmount, String address) {
        JSONArray paymentsArray = new JSONArray();

        try {
            // Load existing payments
            if (Files.exists(Paths.get(PAYMENT))) {
                ArrayList<String> lines = FileHandling.readLines(PAYMENT);
                StringBuilder jsonData = new StringBuilder();
                for (String line : lines) {
                    jsonData.append(line);
                }
                if (!jsonData.toString().trim().isEmpty()) {
                    paymentsArray = new JSONArray(jsonData.toString());
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
            FileHandling.saveToFile(paymentsArray, PAYMENT);
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing the JSON file: " + e.getMessage(), "Error");
        }
    }
}