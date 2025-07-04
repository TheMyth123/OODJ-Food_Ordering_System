package oodj.food_ordering_system.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import oodj.food_ordering_system.designUI.ManageMenu;
import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.CusOrder;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Menu;
import oodj.food_ordering_system.models.Payment;
import oodj.food_ordering_system.models.Rating;
import oodj.food_ordering_system.models.Rating.RatingType;
import oodj.food_ordering_system.models.Vendor;

public class OrderHandling {
    
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();
    private static final String CART = FileHandling.filePath.CART_PATH.getValue();
    private static final String PAYMENT = FileHandling.filePath.PAYMENT_PATH.getValue();
    public static final String RECEIPT_FOLDER = "app/src/main/resources/receipts/";
    private static final String TOPUP = FileHandling.filePath.TOPUP_PATH.getValue();
    private static final String RATING = FileHandling.filePath.RATING_PATH.getValue();
    private static final String ORDER = FileHandling.filePath.ORDER_PATH.getValue();
    private static final String TASK = FileHandling.filePath.TASK_PATH.getValue();

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
    
    

    public static int getORid() {
        int tempCount = 0;
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(PAYMENT)));
            JSONArray topUpArray = new JSONArray(jsonData);
    
            for (int i = 0; i < topUpArray.length(); i++) {
                JSONObject topUpData = topUpArray.getJSONObject(i);
                String orderID = topUpData.getString("OrderID");
                if (orderID.contains("OR")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            // Display error if file reading or parsing fails
            DialogBox.errorMessage("Error reading or parsing order JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    public static String getImagePathByMenuID(String menuID) {
        try {
            // Read JSON file content
            String content = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menuArray = new JSONArray(content);

            // Iterate over the JSON array
            for (int i = 0; i < menuArray.length(); i++) {
                JSONObject menuItem = menuArray.getJSONObject(i);

                // Check if the current item's ID matches the given menuID
                if (menuItem.getString("id").equals(menuID)) {
                    return "/images/" + menuItem.getString("imagePath"); // Ensure classpath format
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if not found
    }


    public static ArrayList<Menu> readMenuFile(String vendorID) throws IOException {
        ArrayList<Menu> menuItems = new ArrayList<>();

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menuArray = new JSONArray(jsonData);

            for (int i = 0; i < menuArray.length(); i++) {
                JSONObject menuObject = menuArray.getJSONObject(i);
                if (menuObject.getString("VendorID").equals(vendorID)) {
                    Menu menuItem = new Menu(
                        menuObject.getString("Status"),
                        menuObject.getString("id"),
                        menuObject.getString("VendorID"),
                        menuObject.getString("name"),
                        menuObject.getString("description"),
                        menuObject.getString("price"),
                        menuObject.getString("imagePath")
                    );
                    menuItems.add(menuItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuItems;
    }

    public static String getFoodNameByMenuID(String menuID) {
        try {
            // Read the JSON file containing menu items
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU))); // Ensure the correct file path
            JSONArray menuArray = new JSONArray(jsonData);
    
            // Iterate through the menu data to find the matching menuID
            for (int i = 0; i < menuArray.length(); i++) {
                JSONObject menuItem = menuArray.getJSONObject(i);
    
                // Check if menuID matches
                if (menuItem.getString("id").equals(menuID)) {
                    return menuItem.getString("name"); // Return the food name
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading or parsing menu JSON file: " + e.getMessage());
        }
    
        return "Unknown Item"; // If not found, return a default name
    }

    public static String[] getTaskDetailsByOrderID(String orderID) {
        try {
            // Step 1: Read file content
            String content = new String(Files.readAllBytes(Paths.get(TASK)));

            //  Step 2: Parse JSON array
            JSONArray taskArray = new JSONArray(content);

            //  Step 3: Loop through tasks and find matching OrderID
            for (int i = 0; i < taskArray.length(); i++) {
                JSONObject task = taskArray.getJSONObject(i);

                if (task.getString("OrderID").equals(orderID)) {
                    //  Get Task Status and Runner ID
                    String taskStatus = task.getString("TaskStatus");
                    String runnerID = task.getString("RunnerID");

                    return new String[]{taskStatus, runnerID}; //  Return as array
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String[]{"Unknown", "No Runner Assigned"}; //  Return default if not found
    }
    

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
                double price = item.optDouble("price", 0.0); //  Use `optDouble` to avoid errors
                String name = item.getString("name");
                String customerID = item.getString("CustomerID"); //  Ensure this exists
    
                Customer customer = UserHandling.getCustomerByID(customerID);
                cartItems.add(new CusOrder(menuID, quantity, price, name, customer));
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return cartItems;
    }
    


    public static CusOrder getFoodByID(String menuID) {
        ArrayList<CusOrder> cartItems = getCart(); // Get the full cart list
    
        for (CusOrder item : cartItems) {
            if (item.getMenuID().equals(menuID)) {
                return item; // Return the matching food item
            }
        }
    
        return null; // Return null if no matching item is found
    }
    

    public static void saveCart(ArrayList<CusOrder> cartItems) {
        JSONArray cartArray = new JSONArray();

        for (CusOrder order : cartItems) {
            JSONObject obj = new JSONObject();
            obj.put("MenuID", order.getMenuID());
            obj.put("quantity", order.getQuantity());
            obj.put("price", order.getPrice());
            obj.put("name", order.getName());
            obj.put("CustomerID", order.getCustomer().getID()); // Save only the ID, not the object reference

            cartArray.put(obj);
        }

        FileHandling.saveToFile(cartArray, CART); // Write updated cart list
    }

    

    public static void updateCart(ArrayList<CusOrder> allCartItems, String customerID, ArrayList<String> itemsToRemove) {
        
    
        if (itemsToRemove.isEmpty()) {
            DialogBox.errorMessage("WARNING: No items were selected for removal.", "Error");
            return; 
        }
    
        JSONArray cartArray = new JSONArray();
    
        
        for (CusOrder order : allCartItems) {
            // Compare order's customer ID with the given `customerID`
            if (!customerID.equals(order.getCustomer().getID())) {
                continue;
            } else if (itemsToRemove.contains(order.getMenuID())) {
                continue; // Skip adding this item
            } 
        
            
    
            JSONObject obj = new JSONObject();
            obj.put("MenuID", order.getMenuID());
            obj.put("quantity", order.getQuantity());
            obj.put("price", order.getPrice());
            obj.put("name", order.getName());
            obj.put("CustomerID", order.getCustomer().getID());
    
            cartArray.put(obj);
        }
    
    
        if (cartArray.length() == 0) {
        }
    
        FileHandling.saveToFile(cartArray, CART); // Update the cart file
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
            creditData.put("ReceiptImagePath", RECEIPT_FOLDER + c.getCreditID() + ".pdf");

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
            File destFile = new File(RECEIPT_FOLDER + credit.getCreditID() + ".pdf");
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void savePayment(String status, String orderID, String customerID, JSONArray orderItems, 
        double totalAmount, String paymentStatus, String serviceType, 
        String deliveryAddress, String orderStatus) {
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
        paymentData.put("Status", status); 
        paymentData.put("OrderID", orderID);
        paymentData.put("CustomerID", customerID);
        paymentData.put("ServiceType", serviceType); // Corrected order
        paymentData.put("TotalAmount", totalAmount);
        paymentData.put("PaymentStatus", paymentStatus);
        paymentData.put("DeliveryAddress", deliveryAddress);
        paymentData.put("Date", LocalDate.now().toString()); // Ensures date is passed
        paymentData.put("OrderStatus", orderStatus);
        paymentData.put("OrderItems", orderItems); // Add order items last

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

    public static ArrayList<Payment> getOrderHistory() {
        ArrayList<String> lines = FileHandling.readLines(PAYMENT);
        StringBuilder jsonData = new StringBuilder();
    
        for (String line : lines) {
            jsonData.append(line);
        }
    
        ArrayList<Payment> paymentList = new ArrayList<>();
    
        try {
            JSONArray ordersArray = new JSONArray(jsonData.toString()); // Assuming the file contains an array of orders
    
            for (int i = 0; i < ordersArray.length(); i++) {
                JSONObject orderObject = ordersArray.getJSONObject(i);
    
                String orderID = orderObject.getString("OrderID");
                String customerID = orderObject.getString("CustomerID");
                double totalAmount = orderObject.getDouble("TotalAmount");
                String paymentStatus = orderObject.getString("PaymentStatus");
                String serviceType = orderObject.getString("ServiceType");
                String address = orderObject.getString("DeliveryAddress");
                String dateString = orderObject.getString("Date");
                String orderStatus = orderObject.getString("OrderStatus");

    
                // Extract order items array
    
                // Create Payment object and add to list
                Payment payment = new Payment(orderID, customerID, serviceType, totalAmount, paymentStatus, address, dateString, orderStatus, null);
                paymentList.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return paymentList;
    }

     
    public static void saveRating(Payment orderID, Customer customerID, int rating, RatingType ratingType) {
        ArrayList<String> lines = FileHandling.readLines(RATING);
        StringBuilder jsonData = new StringBuilder();

        for (String line : lines) {
            jsonData.append(line);
        }

        try {
            JSONArray ratingsArray;

            // If the file is empty, create a new JSON array
            if (jsonData.length() == 0) {
                ratingsArray = new JSONArray();
            } else {
                ratingsArray = new JSONArray(jsonData.toString());
            }

            // Create a new rating JSON object
            JSONObject ratingObject = new JSONObject();
            ratingObject.put("OrderID", orderID.getOrderID());
            ratingObject.put("CustomerID", customerID.getID());
            ratingObject.put("Rating", rating);
            ratingObject.put("RatingType", ratingType.toString()); // Store the rating category
            ratingObject.put("Status", true);

            // Add the new rating to the array
            ratingsArray.put(ratingObject);

            // Write updated JSON array back to the file
            FileHandling.saveToFile(ratingsArray, RATING);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Rating> getRatings() {
        ArrayList<String> lines = FileHandling.readLines(RATING);
        StringBuilder jsonData = new StringBuilder();
    
        for (String line : lines) {
            jsonData.append(line);
        }
    
        ArrayList<Rating> ratingList = new ArrayList<>();
    
        try {
            JSONArray ratingsArray = new JSONArray(jsonData.toString());
    
            for (int i = 0; i < ratingsArray.length(); i++) {
                JSONObject ratingObject = ratingsArray.getJSONObject(i);
    
                String orderID = ratingObject.getString("OrderID");
                String customerID = ratingObject.getString("CustomerID");
                String vendorID = ratingObject.optString("VendorID", "Unknown"); // Default value if VendorID is missing
                int rating = ratingObject.getInt("Rating");
                RatingType ratingType = RatingType.valueOf(ratingObject.getString("RatingType"));
                boolean status = ratingObject.getBoolean("Status");
    
                // Only add to list if VendorID is present or set to "Unknown"
                Rating ratingItem = new Rating(orderID, customerID, vendorID, rating, ratingType, status);
                ratingList.add(ratingItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return ratingList;
    }
    
    
    

    public static String getMenuIDFromOrder(String orderID) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(PAYMENT)));
            JSONArray payments = new JSONArray(jsonData);
    
            for (Object obj : payments) {
                JSONObject payment = (JSONObject) obj;
    
                if (payment.getString("OrderID").equals(orderID)) {
                    //  Check if "OrderItems" array exists
                    if (!payment.has("OrderItems")) {
                        return null;
                    }
    
                    JSONArray orderItems = payment.getJSONArray("OrderItems");
    
                    //  Extract menuID from the first order item (assuming at least one exists)
                    if (orderItems.length() > 0) {
                        JSONObject firstItem = orderItems.getJSONObject(0);
    
                        if (!firstItem.has("menuID")) {
                            return null;
                        }
    
                        return firstItem.getString("menuID"); //  Extract and return menuID
                    } else {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    

    public static String getVendorIDFromMenu(String menuID) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menuItems = new JSONArray(jsonData);
    
            for (Object obj : menuItems) {
                //  Cast the object correctly instead of creating a new JSONObject
                JSONObject menuItem = (JSONObject) obj;
    
                
    
                if (menuItem.has("id") && menuItem.getString("id").equals(menuID)) {
                    return menuItem.getString("VendorID");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    public static List<Rating> getVendorRatings(String vendorID) {
        ArrayList<Rating> ratings = getRatings(); // Get all ratings
        List<Rating> vendorRatings = new ArrayList<>();
    
        
    
        try {
            for (Rating rating : ratings) {
                
    
                // Get MenuID from OrderID
                String menuID = getMenuIDFromOrder(rating.getOrderID());
    
                // Get VendorID from MenuID
                String linkedVendorID = getVendorIDFromMenu(menuID);
    
    
                if (linkedVendorID != null && linkedVendorID.equals(vendorID) && Boolean.TRUE.equals(rating.getStatus())) {
                    vendorRatings.add(rating);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
        return vendorRatings;
    }
      
    public static String getMenuNameByID(String menuID) {
    ArrayList<Menu> allMenus = ManageMenu.allMenus;

    for (Menu menu : allMenus) {
        if (menu.getId().equalsIgnoreCase(menuID)) {
            return menu.getName();
        }
    }
    return "Unknown Item";
    }

//  this function will be added to vendor
public static void AcceptOrderStatus(String orderID) {
    try {
        String filePath = PAYMENT;
        FileHandling.checkFile(filePath);

        JSONArray orderArray;
        File file = new File(filePath);

        if (file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                orderArray = new JSONArray(content.toString());
            }
        } else {
            DialogBox.errorMessage("No order data found to edit.", "Error");
            return;
        }

        boolean orderFound = false;
        JSONObject updatedOrder = null;
        for (int i = 0; i < orderArray.length(); i++) {
            JSONObject order = orderArray.getJSONObject(i);
            if (order.getString("OrderID").equals(orderID)) {
                String currentStatus = order.getString("OrderStatus");

                // Check if the status is "Order Completed"
                if (currentStatus.equalsIgnoreCase("Order Completed")) {
                    DialogBox.errorMessage("The order has been completed, no changes can be made.", "Action Denied");
                    return;
                }
                
                if (currentStatus.equalsIgnoreCase("Accepted")) {
                    DialogBox.errorMessage("The order has been accepted, no changes can be made.", "Action Denied");
                    return;
                }
                // Proceed to accept the order if it's not completed
                order.put("Status", "Accepted");
                order.put("OrderStatus", "Order preparing");
                updatedOrder = order;
                orderFound = true;
                break;
            }
        }

        if (!orderFound) {
            DialogBox.errorMessage("Order with ID " + orderID + " not found.", "Error");
            return;
        }

        FileHandling.saveToFile(orderArray, filePath);

        // Send notification to the customer
        if (updatedOrder != null) {
            String customerID = updatedOrder.getString("CustomerID");
            String type = "Order Accepted";
            String content = "Your order has been accepted. You can track the status in your order history.";
            String title = "Order Approved";
            String actionlink = orderID;
            
            NotificationUtils.NotificationCreator(customerID, type, content, title, actionlink);
        }

        DialogBox.successMessage("Order " + orderID + " status updated to: Accepted", "Success");
    } catch (IOException e) {
        DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
    }
}

    
        
    
    
    public static void CancelOrderStatus(String orderID) {
        try {
            String filePath = PAYMENT;
            FileHandling.checkFile(filePath);
    
            JSONArray orderArray;
            File file = new File(filePath);
    
            if (file.length() > 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    orderArray = new JSONArray(content.toString());
                }
            } else {
                DialogBox.errorMessage("No order data found to edit.", "Error");
                return;
            }
    
            boolean orderFound = false;
            JSONObject updatedOrder = null;
            for (int i = 0; i < orderArray.length(); i++) {
                JSONObject order = orderArray.getJSONObject(i);
                if (order.getString("OrderID").equals(orderID)) {
                    String currentStatus = order.getString("OrderStatus");
    
                    // Check if the status is "Order Completed"
                    if (currentStatus.equalsIgnoreCase("Order Completed")) {
                        DialogBox.errorMessage("The order has been completed, no changes can be made.", "Action Denied");
                        return;
                    }

                    if (currentStatus.equalsIgnoreCase("Cancelled")) {
                        DialogBox.errorMessage("The order has been cancelled, no changes can be made.", "Action Denied");
                        return;
                    }
    
                    // If not completed, proceed to cancel the order
                    order.put("Status", "Cancelled");
                    order.put("OrderStatus", "Cancelled");
                    updatedOrder = order;
                    orderFound = true;
                    break;
                }
            }
    
            if (!orderFound) {
                DialogBox.errorMessage("Order with ID " + orderID + " not found.", "Error");
                return;
            }
    
            FileHandling.saveToFile(orderArray, filePath);
    
            // Send notification to the customer
            if (updatedOrder != null) {
                String customerID = updatedOrder.getString("CustomerID");
                String type = "Order Cancelled";
                String content = "Your order has been cancelled. If you have any concerns, please contact support.";
                String title = "Order Cancelled";
                String actionlink = orderID;
    
                NotificationUtils.NotificationCreator(customerID, type, content, title, actionlink);
            }
    
            DialogBox.successMessage("Order " + orderID + " status updated to: Cancelled", "Success");
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }
    

    public static void UpdateOrderStatus(String orderID) {
        try {
            String filePath = PAYMENT;
            FileHandling.checkFile(filePath);
    
            JSONArray orderArray;
            File file = new File(filePath);
    
            if (file.length() > 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    orderArray = new JSONArray(content.toString());
                }
            } else {
                DialogBox.errorMessage("No order data found to update.", "Error");
                return;
            }
    
            boolean orderFound = false;
            JSONObject updatedOrder = null;
            for (int i = 0; i < orderArray.length(); i++) {
                JSONObject order = orderArray.getJSONObject(i);
                if (order.getString("OrderID").equals(orderID)) {
                    String serviceType = order.getString("ServiceType");
                    String orderStatus = order.getString("OrderStatus");
    
                    // Check if the status is "Pending"
                    if (orderStatus.equalsIgnoreCase("Pending")) {
                        DialogBox.reminderMessage("Please accept the order before updating the status.", "Pending Order");
                        return;
                    }

                    if (orderStatus.equalsIgnoreCase("Order Completed")) {
                        DialogBox.errorMessage("The order has been completed, no changes can be made.", "Action Denied");
                        return;
                    }
                    
                    if (orderStatus.equalsIgnoreCase("Cancelled")) {
                        DialogBox.errorMessage("The order has been cancelled, no changes can be made.", "Action Denied");
                        return;
                    }

                    // Update Status based on Service Type and Current Status
                    switch (serviceType) {
                        case "Dine In":
                            if (orderStatus.equalsIgnoreCase("Order preparing")) {
                                order.put("OrderStatus", "Order is being served");
                            } else if (orderStatus.equalsIgnoreCase("Order is being served")) {
                                order.put("OrderStatus", "Order completed");
                            }
                            break;
    
                        case "Take-Away":
                            if (orderStatus.equalsIgnoreCase("Order preparing")) {
                                order.put("OrderStatus", "Order is ready for pickup");
                            } else if (orderStatus.equalsIgnoreCase("Order is ready for pickup")) {
                                order.put("OrderStatus", "Order completed");
                            }
                            break;
    
                        case "Request for Delivery":
                            if (orderStatus.equalsIgnoreCase("Order preparing")) {
                                order.put("OrderStatus", "Order is ready for pickup");
                            } else if (orderStatus.equalsIgnoreCase("Order is ready for pickup")) {
                                order.put("OrderStatus", "Runner has picked up the order");
                            } else if (orderStatus.equalsIgnoreCase("Runner has picked up the order")) {
                                order.put("OrderStatus", "Order completed");
                            }
                            break;
                        
                        default:
                            DialogBox.errorMessage("Unknown service type. Unable to update status.", "Error");
                            return;
                    }
                    
                    updatedOrder = order;
                    orderFound = true;
                    break;
                }
            }
    
            if (!orderFound) {
                DialogBox.errorMessage("Order with ID " + orderID + " not found.", "Error");
                return;
            }
    
            FileHandling.saveToFile(orderArray, filePath);
    
            // Send notification to the customer
            if (updatedOrder != null) {
                String customerID = updatedOrder.getString("CustomerID");
                String type = "Order Status Updated";
                String content = "The status of your order has been updated. Check your order history for details.";
                String title = "Order Status Updated";
                String actionlink = orderID;
    
                NotificationUtils.NotificationCreator(customerID, type, content, title, actionlink);
            }
    
            DialogBox.successMessage("Order " + orderID + " status updated successfully.", "Success");
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }
    
    


    public static Payment getPaymentByID(String orderID) {
        try {
            //  Read JSON file (ensure UTF-8 encoding)
            String jsonData = new String(Files.readAllBytes(Paths.get(PAYMENT)), StandardCharsets.UTF_8);
    
            //  Parse JSON array
            JSONArray paymentArray = new JSONArray(jsonData);
    
            //  Loop through payment records to find matching OrderID
            for (int i = 0; i < paymentArray.length(); i++) {
                JSONObject paymentData = paymentArray.getJSONObject(i);
    
                if (paymentData.getString("OrderID").equals(orderID)) {
    
                    //  Extract payment details
                    String customerID = paymentData.getString("CustomerID");
                    String serviceType = paymentData.getString("ServiceType");
                    double totalAmount = paymentData.getDouble("TotalAmount");
                    String paymentStatus = paymentData.getString("PaymentStatus");
                    String address = paymentData.getString("DeliveryAddress");
                    String dateString = paymentData.getString("Date");
                    String orderStatus = paymentData.getString("OrderStatus");
    
                    //  Extract ordered items
                    ArrayList<CusOrder> orderItems = new ArrayList<>();
                    JSONArray orderItemsArray = paymentData.optJSONArray("OrderItems");
    
                    if (orderItemsArray == null) {
                        System.err.println("ERROR: No 'OrderItems' found for order: " + orderID);
                        return null;
                    }
    
                    for (int j = 0; j < orderItemsArray.length(); j++) {
                        JSONObject jsonItem = orderItemsArray.getJSONObject(j);
    
                        
    
                        //  Ensure 'menuID' exists
                        if (!jsonItem.has("menuID")) {
                            continue;
                        }
    
                        String menuID = jsonItem.optString("menuID", "").trim();
                        int quantity = jsonItem.getInt("quantity");
                        double price = jsonItem.getDouble("price");
    
                        //  Fetch item name using menuID
                        String itemName = getFoodNameByMenuID(menuID);
                        
                        //  Retrieve Customer object using customerID
                        Customer customer = UserHandling.getCustomerByID(customerID);
    
                        //  Create CusOrder object and add to list
                        CusOrder item = new CusOrder(menuID, quantity, price, itemName, customer);
                        orderItems.add(item);
                    }
    
                    //  Create and return the Payment object
                    return new Payment(orderID, customerID, serviceType, totalAmount, paymentStatus, address, dateString, orderStatus, orderItems);
                }
            }
    
            //  If no matching order is found
            System.err.println("ERROR: Order with ID " + orderID + " not found.");
            return null;
    
        } catch (Exception e) {
            //  Handle any file reading or JSON parsing errors
            System.err.println("ERROR: Failed to read/parse payment JSON file: " + e.getMessage());
            return null;
        }
    }
    
    
    

    // dine in status: Order placed > Order preparing > Order is being served > Payment completed
    // takeaway status: Order placed > Order preparing > Order is ready for pickup > Order picked up > Order completed
    // delivery status: Order received > Order preparing > Order is ready for pickup > Runner has picked up the order > Order delivered > Order completed

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
                FileHandling.writeToFile(ORDER, ordersArray, false);
                DialogBox.successMessage("Order " + orderID + " status updated to: " + newStatus, "Success");
            } else {
                DialogBox.errorMessage("Order with ID " + orderID + " not found!", "Error");
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error updating order status: " + e.getMessage(), "Error");
        }
    }


    // CRUD menu 

    public static String getMenuID() {
        int highestID = 0;
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menusArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);
    
            for (int i = 0; i < menusArray.length(); i++) {
                JSONObject menuData = menusArray.getJSONObject(i);
    
                String menuID = menuData.getString("id");
                if (menuID.startsWith("MN")) {
                    try {
                        int number = Integer.parseInt(menuID.substring(2));
                        if (number > highestID) {
                            highestID = number; // Update the ID
                        }
                    } catch (NumberFormatException e) {
                        DialogBox.errorMessage("Invalid data or format for menu: " + menuID, "Error");
                    }
                }
            }
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing menu JSON file: " + e.getMessage(), "Error");
        }
    
        return "MN" + String.format("%05d", highestID + 1);
    }

    public static Menu getMenuByID(String menuID) {
        try {
            // Read the JSON file
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menusArray = new JSONArray(jsonData);
    
            // Iterate through the menu data to find the matching ID
            for (int i = 0; i < menusArray.length(); i++) {
                JSONObject menuData = menusArray.getJSONObject(i);
    
                // Check if the MenuID matches
                if (menuData.getString("id").equals(menuID)) {
                    String status = menuData.getString("Status");
                    String vendorID = menuData.getString("VendorID");
                    String name = menuData.getString("name");
                    String desc = menuData.getString("description");
                    String price = menuData.getString("price");
                    String image = menuData.getString("imagePath");
    
                    // Create and return the Menu object
                    return new Menu(status, menuID, vendorID, name, desc, price, image);
                }
            }
    
            // If no matching menu is found
            DialogBox.errorMessage("Menu with ID " + menuID + " not found.", "Error");
            return null;
    
        } catch (Exception e) {
            // Handle any errors (e.g., file reading or JSON parsing)
            DialogBox.errorMessage("Error reading or parsing menu JSON file: " + e.getMessage(), "Error");
            return null;
        }
    }    
    

    public static void createMenu(Vendor vendor, String name, String description, String price, String imagePath, boolean status) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menusArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);
    
            String id = getMenuID();
    
            JSONObject menuObject = new JSONObject();
            menuObject.put("id", id);
            menuObject.put("VendorID", vendor.getID());
            menuObject.put("name", name);
            menuObject.put("description", description);
            menuObject.put("price", price); 
            menuObject.put("imagePath", imagePath);
            menuObject.put("Status", String.valueOf(status));
    
            menusArray.put(menuObject);
            FileHandling.writeToFile(MENU, menusArray, false);

            DialogBox.successMessage("Menu " + name + " added successfully!", "Success");
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error adding menu: " + e.getMessage(), "Error");
        }
    }

    public static ArrayList<Menu> getMenu() {
        ArrayList<Menu> menus = new ArrayList<>();
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menusArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);
    
            for (int i = 0; i < menusArray.length(); i++) {
                JSONObject menuData = menusArray.getJSONObject(i);
    
                String id = menuData.getString("id"); 
                String vendorID = menuData.getString("VendorID"); 
                String name = menuData.getString("name");
                String description = menuData.getString("description"); 
                String price = menuData.getString("price");
                String imagePath = menuData.getString("imagePath"); 
                String status = menuData.getString("Status"); 
    
                Menu menu = new Menu(status, id, vendorID, name, description, price, imagePath);
                menus.add(menu);
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error retrieving menus: " + e.getMessage(), "Error");
        }
    
        return menus;
    }

    public static void updateMenuInfo(String menuID, String newName, String newDescription, String newPrice, String newImagePath, boolean newStatus) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menusArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);
    
            boolean menuUpdated = false;
    
            for (int i = 0; i < menusArray.length(); i++) {
                JSONObject menuData = menusArray.getJSONObject(i);
    
                if (menuData.getString("id").equals(menuID)) { 
                    menuData.put("name", newName);
                    menuData.put("description", newDescription);
                    menuData.put("price", newPrice);
                    menuData.put("imagePath", newImagePath);
                    menuData.put("Status", String.valueOf(newStatus));
    
                    menuUpdated = true;
                    break;
                }
            }
    
            if (menuUpdated) {
                FileHandling.writeToFile(MENU, menusArray, false);
                DialogBox.successMessage("Menu " + menuID + " - " + newName + " updated successfully!", "Success");
            } else {
                DialogBox.errorMessage("Menu with ID " + menuID + " not found!", "Error");
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error updating menu: " + e.getMessage(), "Error");
        }
    }

    public static void deleteMenu(String menuID, String name) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray menusArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);
    
            boolean menuDeleted = false;
    
            for (int i = 0; i < menusArray.length(); i++) {
                JSONObject menuData = menusArray.getJSONObject(i);
    
                if (menuData.getString("id").equals(menuID)) { // Match the correct key
                    menusArray.remove(i);
                    menuDeleted = true;
                    break;
                }
            }
    
            if (menuDeleted) {
                FileHandling.writeToFile(MENU, menusArray, false);
                DialogBox.successMessage("Menu " + menuID + " - " + name + " deleted successfully!", "Success");
            } else {
                DialogBox.errorMessage("Menu with ID " + menuID + " not found!", "Error");
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error deleting menu: " + e.getMessage(), "Error");
        }
    }


    
    

    
    
}
