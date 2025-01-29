package oodj.food_ordering_system.utils;

import oodj.food_ordering_system.models.Admin;
import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.CusOrder;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Payment;

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

// change to OOP
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
//  need OOP
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
//  need OOP
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
//  need OOP
    // public static ArrayList<String> getCart() {
    //     ArrayList<String> lines = FileHandling.readLines(CART);

    //     ArrayList<String> cartItems = new ArrayList<>();
    //     StringBuilder jsonData = new StringBuilder();
        
    //     for (String line : lines) {
    //         jsonData.append(line);
    //     }

    //     if (!jsonData.toString().isEmpty()) {
    //         try {
    //             JSONArray cartArray = new JSONArray(jsonData.toString());
    //             for (int i = 0; i < cartArray.length(); i++) {
    //                 JSONObject item = cartArray.getJSONObject(i);

    //                 // Handle quantity safely as integer
    //                 int quantity = item.has("quantity") ? item.optInt("quantity", -1) : -1;

    //                 // Fallback to string if needed
    //                 if (quantity == -1) {
    //                     try {
    //                         quantity = Integer.parseInt(item.optString("quantity", "0"));
    //                     } catch (NumberFormatException e) {
    //                         quantity = 0; // Default value if conversion fails
    //                     }
    //                 }

    //                 // Ensure all required fields exist before accessing
    //                 String price = item.optString("price", "N/A");
    //                 String imagePath = item.optString("imagePath", "N/A");
    //                 String name = item.optString("name", "Unknown");

    //                 // Format the item details
    //                 String itemDetails = "quantity: " + quantity + ", " +
    //                                     "price: " + price + ", " +
    //                                     "imagePath: " + imagePath + ", " +
    //                                     "name: " + name;
    //                 cartItems.add(itemDetails);
    //             }
    //         } catch (Exception e) {
    //             DialogBox.errorMessage("Error reading or parsing the JSON file: " + e.getMessage(), "Error");
    //         }
    //     }
    //     return cartItems;
    // }

    public static ArrayList<CusOrder> getCart() {
        ArrayList<String> lines = FileHandling.readLines(CART);
        StringBuilder jsonData = new StringBuilder();
    
        for (String line : lines) {
            jsonData.append(line);
        }
    
        ArrayList<CusOrder> cartItems = new ArrayList<>();
        try {
            JSONArray cartArray = new JSONArray(jsonData.toString());
            for (int i = 0; i < cartArray.length(); i++) {
                JSONObject item = cartArray.getJSONObject(i);
                String menuID = item.getString("MenuID");
                int quantity = item.getInt("quantity");
                double price = 0.0;
                if (item.get("price") instanceof String) {
                    price = Double.parseDouble(item.getString("price").replace("$", ""));
                } else {
                    price = item.getDouble("price");
                }
                String name = item.getString("name");
    
                // Retrieve the Customer object using the customerID string
    
                CusOrder order = new CusOrder(menuID, quantity, price, name);
                cartItems.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return cartItems;
    }

//  need OOP
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

    // public static ArrayList<Payment> getPayments() {
    //     ArrayList<Payment> buffer = new ArrayList<>();
    
    //     // try {
                    
    
    //     //     for (int i = 0; i < paymentsArray.length(); i++) {
    //     //         JSONObject paymentData = paymentsArray.getJSONObject(i);
    
    //     //         String customerID = paymentData.getString("CustomerID");
    //     //         String serviceType = paymentData.getString("ServiceType");
    //     //         double totalAmount = paymentData.getDouble("TotalAmount");
    //     //         String paymentStatus = paymentData.getString("PaymentStatus");
    //     //         JSONArray orderItemsArray = paymentData.getJSONArray("OrderItems");
    //     //         String deliveryAddress = paymentData.getString("DeliveryAddress");
    
    //     //         // Convert orderItemsArray to a suitable data structure if needed
    //     //         // JSONArray orderItemsArray = new JSONArray(jsonData); // Removed duplicate declaration
    //     //         ArrayList<CusOrder> orderItems = new ArrayList<>();

                

    //     //         for (int j = 0; j < orderItemsArray.length(); j++) {
    //     //             JSONObject item = orderItemsArray.getJSONObject(j);
    //     //             String customerIDStr = item.getString("CustomerID");
    //     //             Customer customer = UserHandling.getCustomerByID(customerIDStr);

    //     //             CusOrder orderItem = new CusOrder(
    //     //                 item.getString("MenuID"),   // Correct syntax
    //     //                 item.getInt("quantity"),    // Correct syntax
    //     //                 Double.parseDouble(item.getString("price").replace("$", "")), // Correct syntax for replacing $
    //     //                 item.getString("imagePath"),
    //     //                 item.getString("name"),
    //     //                 item.getString("description"),
    //     //                 customer                    
    //     //             );

    //     //             orderItems.add(orderItem);
    //     //         }
    
    //     //         // Payment payment = new Payment(customerID, serviceType, totalAmount, paymentStatus, orderItems, deliveryAddress);
    //     //         // buffer.add(payment);
    //     //     }
    
    //     // } catch (Exception e) {
    //     //     DialogBox.errorMessage("Error reading or parsing payment JSON file: " + e.getMessage(), "Error");
    //     // }
    
    //     // return buffer;
    // }

    public static void savePayment(String orderID, String customerID, JSONArray orderItems, double totalAmount, String paymentStatus, String serviceType, String deliveryAddress) {
        JSONArray paymentsArray = new JSONArray();
    
        try {
            // Load existing payments from the file
            if (Files.exists(Paths.get(PAYMENT))) {
                String jsonData = new String(Files.readAllBytes(Paths.get(PAYMENT)));
                if (!jsonData.trim().isEmpty()) {
                    paymentsArray = new JSONArray(jsonData); // Parse existing payments
                }
            }
    
            // Create new payment record
            JSONObject paymentData = new JSONObject();
            paymentData.put("OrderID", orderID);
            paymentData.put("CustomerID", customerID);
            paymentData.put("OrderItems", orderItems); // Add order items
            paymentData.put("TotalAmount", totalAmount);
            paymentData.put("PaymentStatus", paymentStatus);
            paymentData.put("ServiceType", serviceType);
            paymentData.put("DeliveryAddress", deliveryAddress);
            paymentData.put("Date", LocalDate.now().toString());
    
            // Add the new payment to the array
            paymentsArray.put(paymentData);
    
            // Save updated payments array back to the file
            Files.write(Paths.get(PAYMENT), paymentsArray.toString(2).getBytes());
        } catch (Exception e) {
            DialogBox.errorMessage("Error saving payment: " + e.getMessage(), "Error");
        }
    }


    public static void updateCustomerBalance(String customerID, double newBalance) {
        try {
            String filePath = FileHandling.filePath.CUSTOMER_PATH.getValue();
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray customerArray = new JSONArray(content);
    
            for (int i = 0; i < customerArray.length(); i++) {
                JSONObject customerObject = customerArray.getJSONObject(i);
                if (customerObject.getString("CustomerID").equals(customerID)) {
                    customerObject.put("Balance", newBalance);
                    break;
                }
            }
    
            Files.write(Paths.get(filePath), customerArray.toString(2).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void savePayment(String orderID, String receiptImagePath, String string, String address,
            double totalAmountDouble, String address2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savePayment'");
    }
}