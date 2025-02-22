package oodj.food_ordering_system.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.checkerframework.checker.units.qual.C;
import org.json.JSONArray;

import java.io.File;
import java.io.FileWriter;

public class FileHandling {

    public enum filePath {
        MANAGER_PATH("Manager", "app\\src\\main\\resources\\databases\\manager.txt"),
        ADMIN_PATH("Admin", "app\\src\\main\\resources\\databases\\admin.txt"),
        CUSTOMER_PATH("Customer", "app\\src\\main\\resources\\databases\\customer.txt"),
        DELIVERY_PATH("Delivery", "app\\src\\main\\resources\\databases\\delivery_runner.txt"),
        VENDOR_PATH("Vendor", "app\\src\\main\\resources\\databases\\vendor.txt"),
        MENU_PATH("Menu", "app\\src\\main\\resources\\databases\\menu.txt"),
        CART_PATH("Cart", "app\\src\\main\\resources\\databases\\cart.txt"),
        TOPUP_PATH("Topup", "app\\src\\main\\resources\\databases\\topup.txt"),
        //CREDIT_PATH("Credit", "app\\src\\main\\resources\\databases\\credit.txt"),
        PAYMENT_PATH("Payment", "app\\src\\main\\resources\\databases\\payment.txt"),
        RATING_PATH("Rating", "app\\src\\main\\resources\\databases\\rating.txt"),
        COMPLAINT_PATH("Complaint", "app\\src\\main\\resources\\databases\\complaint.txt"),
        NOTIFICATION_PATH("Notification", "app\\src\\main\\resources\\databases\\notification.txt"),
        ORDER_PATH("Order", "app\\src\\main\\resources\\databases\\order.txt"),
        TASK_PATH("Task", "app\\src\\main\\resources\\databases\\delivery_runner_task.txt");

        private final String key, value;

        filePath(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public static void checkFile(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            file.createNewFile();
        }
    }
    
    public static void writeToFile(String filePath, JSONArray jsonArray, boolean append) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(jsonArray.toString(4)); // Pretty print with indentation
            writer.newLine();
            writer.flush();
        }
    }

    public static ArrayList<String> readLines(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            DialogBox.errorMessage(filePath + " could not be found.", "File not found");
        }
        return lines;
    }

    public static void saveToFile(JSONArray cartArray, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(cartArray.toString(2)); // Pretty print with indentation
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
