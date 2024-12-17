package oodj.food_ordering_system.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

public class FileHandling {

    public enum filePath {
        MANAGER_PATH("Manager", "app\\src\\main\\resources\\databases\\manager.txt"),
        ADMIN_PATH("Admin", "app\\src\\main\\resources\\databases\\admin.txt"),
        CUSTOMER_PATH("Customer", "app\\src\\main\\resources\\databases\\customer.txt"),
        DELIVERY_PATH("Delivery", "app\\src\\main\\resources\\databases\\delivery_runner.txt"),
        VENDOR_PATH("Vendor", "app\\src\\main\\resources\\databases\\vendor.txt");
        
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
