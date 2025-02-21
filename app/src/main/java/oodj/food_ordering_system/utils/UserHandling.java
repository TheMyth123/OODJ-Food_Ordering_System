package oodj.food_ordering_system.utils;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import static oodj.food_ordering_system.designUI.LoginPage.loginID;
import oodj.food_ordering_system.models.Admin;
import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.DeliveryRunner;
import oodj.food_ordering_system.models.Manager;
import oodj.food_ordering_system.models.Menu;
import oodj.food_ordering_system.models.Vendor;

public class UserHandling {

    private static final String ADMIN = FileHandling.filePath.ADMIN_PATH.getValue();
    private static final String CUSTOMER = FileHandling.filePath.CUSTOMER_PATH.getValue();
    private static final String MANAGER = FileHandling.filePath.MANAGER_PATH.getValue();
    private static final String DELIVERY = FileHandling.filePath.DELIVERY_PATH.getValue();
    private static final String VENDOR = FileHandling.filePath.VENDOR_PATH.getValue();
    private static final String TOPUP = FileHandling.filePath.TOPUP_PATH.getValue();
    private static final String NOTIFICATION = FileHandling.filePath.NOTIFICATION_PATH.getValue();
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();


    public static int getCUid() {
        int tempCount = 0;
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(CUSTOMER)));
            JSONArray customersArray = new JSONArray(jsonData);
    
            for (int i = 0; i < customersArray.length(); i++) {
                JSONObject customerData = customersArray.getJSONObject(i);
                String customerID = customerData.getString("CustomerID");
                if (customerID.contains("CS")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            // Display error if file reading or parsing fails
            DialogBox.errorMessage("Error reading or parsing customer JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }
    

    public static int getADid() {
        int tempCount = 0;

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ADMIN)));
            JSONArray adminsArray = new JSONArray(jsonData);
    
            for (int i = 0; i < adminsArray.length(); i++) {
                JSONObject adminData = adminsArray.getJSONObject(i);
                String adminID = adminData.getString("AdminID");
                if (adminID.contains("AD")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            // Display error if file reading or parsing fails
            DialogBox.errorMessage("Error reading or parsing admin JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    public static int getMId() {
        int tempCount = 0;

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MANAGER)));
            JSONArray managersArray = new JSONArray(jsonData);
    
            for (int i = 0; i < managersArray.length(); i++) {
                JSONObject managerData = managersArray.getJSONObject(i);
                String managerID = managerData.getString("ManagerID");
                if (managerID.contains("MG")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing manager JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    public static int getDRId() {
        int tempCount = 0;

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(DELIVERY)));
            JSONArray deliveriesArray = new JSONArray(jsonData);
    
            for (int i = 0; i < deliveriesArray.length(); i++) {
                JSONObject deliveryData = deliveriesArray.getJSONObject(i);
                String deliveryID = deliveryData.getString("RunnerID");
                if (deliveryID.contains("DR")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing delivery JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    public static int getVId() {
        int tempCount = 0;

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(VENDOR)));
            JSONArray vendorsArray = new JSONArray(jsonData);
    
            for (int i = 0; i < vendorsArray.length(); i++) {
                JSONObject vendorData = vendorsArray.getJSONObject(i);
                String vendorID = vendorData.getString("VendorID");
                if (vendorID.contains("VD")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing vendor JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    public static int getNTId() {
        int tempCount = 0;

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(NOTIFICATION)));
            JSONArray notificationsArray = new JSONArray(jsonData);
    
            for (int i = 0; i < notificationsArray.length(); i++) {
                JSONObject notificationData = notificationsArray.getJSONObject(i);
                String notificationID = notificationData.getString("NotificationID");
                if (notificationID.contains("NT")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing vendor JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    public static ArrayList<Admin> getAdmins() {
        ArrayList<Admin> buffer = new ArrayList<>();

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ADMIN)));
            JSONArray adminsArray = new JSONArray(jsonData);

            for (int i = 0; i < adminsArray.length(); i++) {
                JSONObject adminData = adminsArray.getJSONObject(i);

                String adminID = adminData.getString("AdminID");
                String username = adminData.getString("Username");
                String password = adminData.getString("Password");
                String name = adminData.getString("Name");
                String email = adminData.getString("Email");
                Boolean status = adminData.getBoolean("Status");

                Admin admin = new Admin(adminID, username, password, name, email, status);
                buffer.add(admin);
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing admin JSON file: " + e.getMessage(), "Error");
        }

        return buffer;
    }

    public static PieDataset createDataCus() {
        DefaultPieDataset dataset = new DefaultPieDataset();
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(CUSTOMER)));
            JSONArray customersArray = new JSONArray(jsonData);
            Map<String, Integer> genderCount = new HashMap<>();
    
            for (int i = 0; i < customersArray.length(); i++) {
                JSONObject customerData = customersArray.getJSONObject(i);
    
                String gender = customerData.getString("Gender").trim();
    
                genderCount.put(gender, genderCount.getOrDefault(gender, 0) + 1);
            }
    
            for (Map.Entry<String, Integer> entry : genderCount.entrySet()) {
                dataset.setValue(entry.getKey(), entry.getValue());
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing customer JSON file: " + e.getMessage(), "Error");
        }
    
        return dataset;
    }
    

    public static ArrayList<Customer> getCustomers() {
        ArrayList<Customer> buffer = new ArrayList<>();
    
        try {
            
            String jsonData = new String(Files.readAllBytes(Paths.get(CUSTOMER)));
            JSONArray customersArray = new JSONArray(jsonData);

            for (int i = 0; i < customersArray.length(); i++) {
                JSONObject customerData = customersArray.getJSONObject(i);
    
                String customerID = customerData.getString("CustomerID");
                if (customerID.startsWith("CS")) {
                    String username = customerData.getString("Username");
                    String name = customerData.getString("Name");
                    String phone = customerData.getString("Phone");
                    String password = customerData.getString("Password");
                    String gender = customerData.getString("Gender");
                    String dob = customerData.getString("DOB");
                    String email = customerData.getString("Email");
                    String address = customerData.getString("Address");
                    Boolean status = customerData.getBoolean("Status");
                    double balance = customerData.getDouble("Balance");
    
                    Customer customer = new Customer(customerID, username, name, phone, password, gender, dob, email, address, status, balance);
                    buffer.add(customer);
                } else {
                    System.out.println("Invalid CustomerID: " + customerID);
    
                    DialogBox.errorMessage("Invalid data or format for customer: " + customerID, "Error");
                }
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing customer JSON file: " + e.getMessage(), "Error");
        }
    
        return buffer;
    }
    

    public static void UpdateCustomer(String customerId, String updatedContactNumber, String updatedPassword) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(CUSTOMER)));
            JSONArray customersArray = new JSONArray(jsonData);

            boolean isUpdated = false;
    
            for (int i = 0; i < customersArray.length(); i++) {
                JSONObject customerData = customersArray.getJSONObject(i);
    
                if (customerData.getString("CustomerID").equals(customerId)) {
                    customerData.put("Phone", updatedContactNumber);
                    customerData.put("Password", updatedPassword);
                    isUpdated = true;
                    break;
                }
            }
    
            if (isUpdated) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER))) {
                    writer.write(customersArray.toString(4)); // Pretty-print JSON with 4 spaces indentation
                }
            } else {
                System.out.println("Customer ID not found: " + customerId);
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Manager> getManagers() {
        ArrayList<Manager> buffer = new ArrayList<>();
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(MANAGER)));
            JSONArray managersArray = new JSONArray(jsonData);

            for (int i = 0; i < managersArray.length(); i++) {
                JSONObject managerdata = managersArray.getJSONObject(i);
    
                String managerID = managerdata.getString("ManagerID");
                if (managerID.startsWith("MG")) {
                    String username = managerdata.getString("Username");
                    String name = managerdata.getString("Name");
                    String password = managerdata.getString("Password");
                    String email = managerdata.getString("Email");
                    Boolean status = managerdata.getBoolean("Status");
    
                    Manager manager = new Manager(managerID, username, password, name, email, status);
                    buffer.add(manager);
                } else {
                    System.out.println("Invalid ManagerID: " + managerID);
    
                    DialogBox.errorMessage("Invalid data or format for manager: " + managerID, "Error");
                }
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing manager JSON file: " + e.getMessage(), "Error");
        }
    
        return buffer;
    }
    
    public static ArrayList<DeliveryRunner> getDeliveries() {
        ArrayList<DeliveryRunner> buffer = new ArrayList<>();
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(DELIVERY)));
            JSONArray deliveriesArray = new JSONArray(jsonData);

            for (int i = 0; i < deliveriesArray.length(); i++) {
                JSONObject deliveryData = deliveriesArray.getJSONObject(i);
    
                String runnerID = deliveryData.getString("RunnerID");
                if (runnerID.startsWith("DR")) {
                    String username = deliveryData.getString("Username");
                    String name = deliveryData.getString("Name");
                    String phone = deliveryData.getString("Phone");
                    String password = deliveryData.getString("Password");
                    String gender = deliveryData.getString("Gender");
                    String dob = deliveryData.getString("DOB");
                    String email = deliveryData.getString("Email");
                    String vehicle = deliveryData.getString("VehicleType");
                    String license = deliveryData.getString("LicensePlate");
                    Boolean status = deliveryData.getBoolean("Status");
                    Double balance = deliveryData.getDouble("Balance");
    
                    DeliveryRunner delivery = new DeliveryRunner(runnerID, username, name, phone, password, gender, dob, email, vehicle, license, status, balance);
                    buffer.add(delivery);
                } else {
                    System.out.println("Invalid DeliveryID: " + runnerID);
    
                    DialogBox.errorMessage("Invalid data or format for delivery: " + runnerID, "Error");
                }
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing delivery JSON file: " + e.getMessage(), "Error");
        }
    
        return buffer;
    }

    public static ArrayList<Vendor> getVendors() {
        ArrayList<Vendor> buffer = new ArrayList<>();
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(VENDOR)));
            JSONArray vendorsArray = new JSONArray(jsonData);

            for (int i = 0; i < vendorsArray.length(); i++) {
                JSONObject vendorData = vendorsArray.getJSONObject(i);
    
                String vendorID = vendorData.getString("VendorID");
                if (vendorID.startsWith("VD")) {
                    String username = vendorData.getString("Username");
                    String name = vendorData.getString("VendorName");
                    String phone = vendorData.getString("ContactNumber");
                    String password = vendorData.getString("Password");
                    Boolean status = vendorData.getBoolean("Status");
                    String foodcourtname = vendorData.getString("FoodCourtName");
                    String DOB = vendorData.getString("DateRegistered");
                    String email = vendorData.getString("Email");
    
                    Vendor vendor = new Vendor(vendorID, name, foodcourtname, phone, username, password, status, DOB, email);
                    buffer.add(vendor);
                } else {
                    System.out.println("Invalid VendorID: " + vendorID);
    
                    DialogBox.errorMessage("Invalid data or format for vendor: " + vendorID, "Error");
                }
            }
    
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing vendor JSON file: " + e.getMessage(), "Error");
        }
    
        return buffer;
    }
    

    public static ArrayList<String> getUsernames() {
        ArrayList<String> usernames = new ArrayList<>();

        for (Manager manager : getManagers()) {
            usernames.add(manager.getUsername());
        }

        for (Admin admin : getAdmins()) {
            usernames.add(admin.getUsername());
        }

        for (Customer customer : getCustomers()) {
            usernames.add(customer.getUsername());
        }

        for (DeliveryRunner delivery : getDeliveries()) {
            usernames.add(delivery.getUsername());
        }

        for (Vendor vendor : getVendors()) {
            usernames.add(vendor.getUsername());
        }

        return usernames;
    }

    public static Map<String, String> getUsernamesWithIds() {
        Map<String, String> usernamesWithIds = new HashMap<>();
    
        for (Manager manager : getManagers()) {
            usernamesWithIds.put(manager.getID(), manager.getUsername());
        }
    
        for (Admin admin : getAdmins()) {
            usernamesWithIds.put(admin.getID(), admin.getUsername());
        }
    
        for (Customer customer : getCustomers()) {
            usernamesWithIds.put(customer.getID(), customer.getUsername());
        }
    
        for (DeliveryRunner delivery : getDeliveries()) {
            usernamesWithIds.put(delivery.getID(), delivery.getUsername());
        }
    
        for (Vendor vendor : getVendors()) {
            usernamesWithIds.put(vendor.getID(), vendor.getUsername());
        }
    
        return usernamesWithIds;
    }

    public static ArrayList<String> getEmails() {
        ArrayList<String> emails = new ArrayList<>();

        for (Manager manager : getManagers()) {
            emails.add(manager.getEmail());
        }

        for (Admin admin : getAdmins()) {
            emails.add(admin.getEmail());
        }

        for (Customer customer : getCustomers()) {
            emails.add(customer.getEmail());
        }

        for (DeliveryRunner delivery : getDeliveries()) {
            emails.add(delivery.getEmail());
        }

        for (Vendor vendor : getVendors()) {
            emails.add(vendor.getEmail());
        }

        return emails;
    }

    public static Map<String, String> getEmailsWithIds() {
        Map<String, String> emailsWithIds = new HashMap<>();
    
        for (Manager manager : getManagers()) {
            emailsWithIds.put(manager.getID(), manager.getEmail());
        }
    
        for (Admin admin : getAdmins()) {
            emailsWithIds.put(admin.getID(), admin.getEmail());
        }
    
        for (Customer customer : getCustomers()) {
            emailsWithIds.put(customer.getID(), customer.getEmail());
        }
    
        for (DeliveryRunner delivery : getDeliveries()) {
            emailsWithIds.put(delivery.getID(), delivery.getEmail());
        }
    
        for (Vendor vendor : getVendors()) {
            emailsWithIds.put(vendor.getID(), vendor.getEmail());
        }
    
        return emailsWithIds;
    }

    public static String getName() {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(CUSTOMER)));
            JSONArray customersArray = new JSONArray(jsonData);

            for (int i = 0; i < customersArray.length(); i++) {
                JSONObject customerData = customersArray.getJSONObject(i);

                if (customerData.getString("CustomerID").startsWith("CS")) {
                    return customerData.getString("Name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return "Customer";
    }
    

    public static String getUserRole() {
        if (loginID == null) {
            return "Error";
        }

        if (loginID.startsWith("AD")) {
            return "Admin";
        } else if (loginID.startsWith("CS")) {
            return "Customer";
        } else if (loginID.startsWith("MG")) {
            return "Manager";
        } else if (loginID.startsWith("DR")) {
            return "Delivery Runner";
        } else if (loginID.startsWith("VD")) {
            return "Vendor";
        }

        return "Guest";
    }

    public static void logout() {
        loginID = null;
    }


    public static int getTotalCustomers() {
        ArrayList<Customer> customers = getCustomers();
        return customers.size();
    }

    public static ArrayList<Admin> searchAdmins(String query) {
        ArrayList<Admin> allAdmins = getAdmins();
        return allAdmins.stream()
                .filter(admin -> admin.getID().contains(query) || admin.getUsername().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Customer> searchCustomers(String query) {
        ArrayList<Customer> customers = getCustomers();
        return customers.stream()
                .filter(customer -> customer.getID().contains(query) || customer.getUsername().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<DeliveryRunner> searchDeliveries(String query) {
        ArrayList<DeliveryRunner> deliveries = getDeliveries();
        return deliveries.stream()
                .filter(delivery -> delivery.getID().contains(query) || delivery.getUsername().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public static ArrayList<Manager> searchManagers(String query) {
        ArrayList<Manager> managers = getManagers();
        return managers.stream()
                .filter(manager -> manager.getID().contains(query) || manager.getUsername().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Vendor> searchVendors(String query) {
        ArrayList<Vendor> vendors = getVendors();
        return vendors.stream()
                .filter(vendor -> vendor.getID().contains(query) || vendor.getUsername().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Customer getCustomerByID(String customerID) {
        try {
            // Read the JSON file
            String jsonData = new String(Files.readAllBytes(Paths.get(CUSTOMER)));
            JSONArray customersArray = new JSONArray(jsonData);
    
            // Iterate through the customer data to find the matching ID
            for (int i = 0; i < customersArray.length(); i++) {
                JSONObject customerData = customersArray.getJSONObject(i);
    
                // Check if the CustomerID matches
                if (customerData.getString("CustomerID").equals(customerID)) {
                    String username = customerData.getString("Username");
                    String name = customerData.getString("Name");
                    String phone = customerData.getString("Phone");
                    String password = customerData.getString("Password");
                    String gender = customerData.getString("Gender");
                    String dob = customerData.getString("DOB");
                    String email = customerData.getString("Email");
                    String address = customerData.getString("Address");
                    Boolean status = customerData.getBoolean("Status");
                    double balance = customerData.getDouble("Balance");
    
                    // Create and return the Customer object
                    return new Customer(customerID, username, name, phone, password, gender, dob, email, address, status, balance);
                }
            }
    
            // If no matching customer is found
            DialogBox.errorMessage("Customer with ID " + customerID + " not found.", "Error");
            return null;
    
        } catch (Exception e) {
            // Handle any errors (e.g., file reading or JSON parsing)
            DialogBox.errorMessage("Error reading or parsing customer JSON file: " + e.getMessage(), "Error");
            return null;
        }
    }    

    public static Vendor getVendorByID(String vendorID) {
        try {
            // Read the JSON file
            String jsonData = new String(Files.readAllBytes(Paths.get(VENDOR)));
            JSONArray vendorsArray = new JSONArray(jsonData);
    
            // Iterate through the vendor data to find the matching ID
            for (int i = 0; i < vendorsArray.length(); i++) {
                JSONObject vendordata = vendorsArray.getJSONObject(i);
    
                // Check if the vendor matches
                if (vendordata.getString("VendorID").equals(vendorID)) {
                    String username = vendordata.getString("Username");
                    String vendorname = vendordata.getString("VendorName");
                    String phone = vendordata.getString("ContactNumber");
                    String password = vendordata.getString("Password");
                    Boolean status = vendordata.getBoolean("Status");
                    String foodcourtname = vendordata.getString("FoodCourtName");
                    String email = vendordata.getString("Email");
                    String DOB = vendordata.getString("DateRegistered");
    
                    // Create and return the vendor object
                    return new Vendor(vendorID, vendorname, foodcourtname, phone, username, password, status, DOB, email);
                }
            }
    
            // If no matching vendor is found
            DialogBox.errorMessage("Vendor with ID " + vendorID + " not found.", "Error");
            return null;
    
        } catch (Exception e) {
            // Handle any errors (e.g., file reading or JSON parsing)
            DialogBox.errorMessage("Error reading or parsing vendor JSON file: " + e.getMessage(), "Error");
            return null;
        }
    }

    public static String getLoggedInVendorID() {
        // Check if the user is logged in and is a vendor
        if (loginID != null && loginID.startsWith("VD")) {
            return loginID;
        }
        return null;
    }
    

    public static DeliveryRunner getDeliveryRunnerByID(String runnerID) {
        try {
            // Read the JSON file
            String jsonData = new String(Files.readAllBytes(Paths.get(DELIVERY)));
            JSONArray runnersArray = new JSONArray(jsonData);
    
            // Iterate through the runner data to find the matching ID
            for (int i = 0; i < runnersArray.length(); i++) {
                JSONObject runnerData = runnersArray.getJSONObject(i);
    
                // Check if the runnerID matches
                if (runnerData.getString("RunnerID").equals(runnerID)) {
                    String username = runnerData.getString("Username");
                    String name = runnerData.getString("Name");
                    String phone = runnerData.getString("Phone");
                    String password = runnerData.getString("Password");
                    String gender = runnerData.getString("Gender");
                    String dob = runnerData.getString("DOB");
                    String email = runnerData.getString("Email");
                    String vehicle = runnerData.getString("VehicleType");
                    String license = runnerData.getString("LicensePlate");
                    Boolean status = runnerData.getBoolean("Status");
                    Double balance = runnerData.getDouble("Balance");
    
                    // Create and return the runner object
                    return new DeliveryRunner(runnerID, username, name, phone, password, gender, dob, email, vehicle, license, status, balance);
                }
            }
    
            // If no matching runner is found
            DialogBox.errorMessage("Delivery Runner with ID " + runnerID + " not found.", "Error");
            return null;
    
        } catch (Exception e) {
            // Handle any errors (e.g., file reading or JSON parsing)
            DialogBox.errorMessage("Error reading or parsing runner JSON file: " + e.getMessage(), "Error");
            return null;
        }
    }   

    public static Credit getTopUpByID(String creditID) {
        try {
            // Read the JSON file
            String jsonData = new String(Files.readAllBytes(Paths.get(TOPUP)));
            JSONArray creditsArray = new JSONArray(jsonData);
    
            // Iterate through the topup data to find the matching ID
            for (int i = 0; i < creditsArray.length(); i++) {
                JSONObject creditData = creditsArray.getJSONObject(i);
    
                // Check if the creditID matches
                if (creditData.getString("CreditID").equals(creditID)) {
                    String status = creditData.getString("Status");
                    String receiptpath = creditData.getString("ReceiptImagePath");
                    Double amount = creditData.getDouble("CreditAmount");
                    String customerID = creditData.getString("CustomerID");
                    String lastupdated = creditData.getString("LastUpdated");

                    LocalDate lastUpdatedDate = LocalDate.parse(lastupdated, DateTimeFormatter.ISO_DATE);
                    return new Credit(creditID, customerID, amount, lastUpdatedDate, status, receiptpath);
                }
            }
    
            // If no matching topup is found
            DialogBox.errorMessage("Topup request with ID " + creditID + " not found.", "Error");
            return null;
    
        } catch (Exception e) {
            // Handle any errors (e.g., file reading or JSON parsing)
            DialogBox.errorMessage("Error reading or parsing topup JSON file: " + e.getMessage(), "Error");
            return null;
        }
    }   

    public static Menu getMenuByID(String menuID) {
        try {
            // Read the JSON file
            String jsonData = new String(Files.readAllBytes(Paths.get(MENU)));
            JSONArray itemsArray = new JSONArray(jsonData);
    
            // Iterate through the menu data to find the matching ID
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject itemData = itemsArray.getJSONObject(i);
    
                // Check if the menuID matches
                if (itemData.getString("id").equals(menuID)) {
                    String status = itemData.getString("Status");
                    String vendorID = itemData.getString("VendorID");
                    String name = itemData.getString("name");
                    String description = itemData.getString("description");
                    String price = itemData.getString("price");
                    String imagePath = itemData.getString("imagePath");
                    return new Menu(status, menuID, vendorID, name, description, price, imagePath);
                }
            }
    
            // If no matching topup is found
            DialogBox.errorMessage("Menu item with ID " + menuID + " not found.", "Error");
            return null;
    
        } catch (Exception e) {
            // Handle any errors (e.g., file reading or JSON parsing)
            DialogBox.errorMessage("Error reading or parsing menu JSON file: " + e.getMessage(), "Error");
            return null;
        }
    }   
}
