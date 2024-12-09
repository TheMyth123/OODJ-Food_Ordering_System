package oodj.food_ordering_system.utils;


import static oodj.food_ordering_system.designUI.LoginPage.adminID;
import static oodj.food_ordering_system.designUI.LoginPage.managerID;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import oodj.food_ordering_system.models.Admin;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Manager;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class UserHandling {

    private static final String ADMIN = FileHandling.filePath.ADMIN_PATH.getValue();
    private static final String CUSTOMER = FileHandling.filePath.CUSTOMER_PATH.getValue();
    private static final String MANAGER = FileHandling.filePath.MANAGER_PATH.getValue();


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
                    Boolean status = customerData.getBoolean("Status");
    
                    Customer customer = new Customer(customerID, username, name, phone, password, gender, dob, email, status);
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

        return usernames;
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

        if (managerID != null) {
            return "manager";
        } else if (adminID != null) {
            return "admin";
        }
                return null;
    }

    public static void logout() {
        managerID = null;
        adminID = null;
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
}
