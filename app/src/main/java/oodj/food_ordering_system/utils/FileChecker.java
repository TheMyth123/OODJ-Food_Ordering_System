package oodj.food_ordering_system.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileChecker {
    public static boolean systemInitialized()throws IOException {
        File managerFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\manager.txt");
        File adminFile = new File("app\\src\\main\\resources\\databases\\admin.txt");
        File customerFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\customer.txt");
        File deliveryFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\delivery_runner.txt");
        File vendorFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\vendor.txt");
        File notificationFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\notification.txt");
        File menuFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\menu.txt");
        File cartFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\cart.txt");
        
        // TODO : ADD EVERY DATABASE FILE HERE

        if (!managerFile.exists() || !adminFile.exists() || !customerFile.exists() || !deliveryFile.exists() || !vendorFile.exists() || !notificationFile.exists()) {
            if (!managerFile.exists()) {
                managerFile.createNewFile();
                writeEmptyJsonArray(managerFile);
                System.out.println("Manager file created successfully");
            }
            if (!adminFile.exists()) {
                adminFile.createNewFile();
                writeEmptyJsonArray(adminFile);
                System.out.println("Admin file created successfully");
            }
            if (!customerFile.exists()) {
                customerFile.createNewFile();
                writeEmptyJsonArray(customerFile);
                System.out.println("Customer file created successfully");
            }
            if (!deliveryFile.exists()) {
                deliveryFile.createNewFile();
                writeEmptyJsonArray(deliveryFile);
                System.out.println("Delivery file created successfully");
            }
            if (!vendorFile.exists()) {
                vendorFile.createNewFile();
                writeEmptyJsonArray(vendorFile);
                System.out.println("Vendor file created successfully");
            }
            if (!notificationFile.exists()) {
                notificationFile.createNewFile();
                writeEmptyJsonArray(notificationFile);
                System.out.println("Notification file created successfully");
            }
            if (!menuFile.exists()) {
                menuFile.createNewFile();
                writeEmptyJsonArray(menuFile);
                System.out.println("Menu file created successfully");
            }
            if (!cartFile.exists()) {
                cartFile.createNewFile();
                writeEmptyJsonArray(cartFile);
                System.out.println("Cart file created successfully");
            }

            
            return true;
        }
        return false;
    }

    private static void writeEmptyJsonArray(File file) throws IOException {
        // Write an empty JSON array "[]"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("[]");
        }
    }
}
