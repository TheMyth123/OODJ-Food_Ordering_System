package oodj.food_ordering_system.utils;

import oodj.food_ordering_system.models.Admin;
import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.CusOrder;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Menu;
import oodj.food_ordering_system.models.Payment;
import oodj.food_ordering_system.models.Rating;
import oodj.food_ordering_system.models.Rating.RatingType;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

// change to OOP
public class OrderHandling {
    
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();
    private static final String CART = FileHandling.filePath.CART_PATH.getValue();
    // private static final String CREDIT = FileHandling.filePath.CREDIT_PATH.getValue();
    private static final String PAYMENT = FileHandling.filePath.PAYMENT_PATH.getValue();
    public static final String RECEIPT_FOLDER = "app/src/main/resources/receipts/";
    private static final String TOPUP = FileHandling.filePath.TOPUP_PATH.getValue();
    private static final String RATING = FileHandling.filePath.RATING_PATH.getValue();
    private static final String ORDER = FileHandling.filePath.ORDER_PATH.getValue();

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

// USE OOP
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
                    price = Double.parseDouble(item.getString("price").replace("RM", ""));
                } else {
                    price = item.getDouble("price");
                }
                String name = item.getString("name");

                String customerID = item.getString("CustomerID"); // Retrieve CustomerID as a string

            // Retrieve the Customer object using customerID
                Customer customer = UserHandling.getCustomerByID(customerID);
                // Retrieve the Customer object using the customerID string
    
                CusOrder order = new CusOrder(menuID, quantity, price, name, customer);
                cartItems.add(order);
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
    

//  need OOP
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

//  need OOP

    public static void savePayment(String orderID, String customerID, JSONArray orderItems, 
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
                Payment payment = new Payment(orderID, customerID, serviceType, totalAmount, paymentStatus, address, dateString, orderStatus);
                paymentList.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return paymentList;
    }

     
// need OOP
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
//  this function will be added to vendor
    private void AcceptOrderStatus(String orderID) {
        try {
            String filePath = ORDER;
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
            for (int i = 0; i < orderArray.length(); i++) {
                JSONObject order = orderArray.getJSONObject(i);
                if (order.getString("OrderID").equals(orderID)) {
                    order.put("Status", "Accepted");
                    orderFound = true;
                    break;
                }
            }
    
            if (!orderFound) {
                DialogBox.errorMessage("Order with ID " + orderID + " not found.", "Error");
                return;
            }
    
            FileHandling.saveToFile(orderArray, filePath);
    
            DialogBox.successMessage("Order " + orderID + " status updated to: Accepted", "Success");
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }

    private void CancelOrderStatus(String orderID) {
        try {
            String filePath = ORDER;
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
            for (int i = 0; i < orderArray.length(); i++) {
                JSONObject order = orderArray.getJSONObject(i);
                if (order.getString("OrderID").equals(orderID)) {
                    order.put("Status", "Cancelled");
                    orderFound = true;
                    break;
                }
            }

            if (!orderFound) {
                DialogBox.errorMessage("Order with ID " + orderID + " not found.", "Error");
                return;
            }

            FileHandling.saveToFile(orderArray, filePath);

            DialogBox.successMessage("Order " + orderID + " status updated to: Cancelled", "Success");
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }


    public static Payment getPaymentByID(String orderID) {
        try {
            // Read the JSON file
            String jsonData = new String(Files.readAllBytes(Paths.get(PAYMENT)));
            JSONArray customersArray = new JSONArray(jsonData);
    
            // Iterate through the customer data to find the matching ID
            for (int i = 0; i < customersArray.length(); i++) {
                JSONObject customerData = customersArray.getJSONObject(i);
    
                // Check if the CustomerID matches
                if (customerData.getString("OrderID").equals(orderID)) {
                    String customerID = customerData.getString("CustomerID");
                    String serviceType = customerData.getString("ServiceType");
                    double totalAmount = customerData.getDouble("TotalAmount");
                    String paymentStatus = customerData.getString("PaymentStatus");
                    String address = customerData.getString("DeliveryAddress");
                    String dateString = customerData.getString("Date");
                    String orderStatus = customerData.getString("OrderStatus");

    
                    // Extract order items array
    
                    // Create Payment object and return
                    return new Payment(orderID, customerID, serviceType, totalAmount, paymentStatus, address, dateString, orderStatus);
                }
            }
    
            // If no matching customer is found
            // DialogBox.errorMessage("Customer with ID " + customerID + " not found.", "Error");
            return null;
    
        } catch (Exception e) {
            // Handle any errors (e.g., file reading or JSON parsing)
            DialogBox.errorMessage("Error reading or parsing customer JSON file: " + e.getMessage(), "Error");
            return null;
        }
    } 

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
                FileHandling.writeToFile(ORDER, ordersArray, false);
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
