package oodj.food_ordering_system.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandling {

    public enum filePath {
        MANAGER_PATH("Manager", "app\\src\\main\\resources\\databases\\manager.txt"),
        ADMIN_PATH("Admin", "app\\src\\main\\resources\\databases\\admin.txt"),
        CUSTOMER_PATH("Customer", "app\\src\\main\\resources\\databases\\customer.txt"),
        VENDOR_PATH("Vendor", "app\\src\\main\\resources\\databases\\vendor.txt"),
        ITEM_PATH("Item", "app\\src\\main\\resources\\databases\\item.txt"),
        ORDER_PATH("Order", "app\\src\\main\\resources\\databases\\order.txt");
        
        
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
    
    public static void writeToFile(String filePath, String data, boolean append) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(data);
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
}
