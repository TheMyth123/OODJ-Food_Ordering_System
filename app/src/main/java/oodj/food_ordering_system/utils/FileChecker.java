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
        File paymentFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\payment.txt");
        File ratingFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\rating.txt"); 
        File complaintFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\complaint.txt");
        // TODO : ADD EVERY DATABASE FILE HERE

        if (!managerFile.exists() || !adminFile.exists() || !customerFile.exists() || !deliveryFile.exists() || !vendorFile.exists() || !notificationFile.exists() || !menuFile.exists() || !cartFile.exists() || !paymentFile.exists() || !ratingFile.exists() || !complaintFile.exists()) {
            if (!managerFile.exists()) {
                managerFile.createNewFile();
                writeEmptyJsonArray(managerFile);
            }
            if (!adminFile.exists()) {
                adminFile.createNewFile();
                writeEmptyJsonArray(adminFile);
            }
            if (!customerFile.exists()) {
                customerFile.createNewFile();
                writeEmptyJsonArray(customerFile);
            }
            if (!deliveryFile.exists()) {
                deliveryFile.createNewFile();
                writeEmptyJsonArray(deliveryFile);
            }
            if (!vendorFile.exists()) {
                vendorFile.createNewFile();
                writeEmptyJsonArray(vendorFile);
            }
            if (!notificationFile.exists()) {
                notificationFile.createNewFile();
                writeEmptyJsonArray(notificationFile);
            }
            if (!menuFile.exists()) {
                menuFile.createNewFile();
                writeEmptyJsonArray(menuFile);
            }
            if (!cartFile.exists()) {
                cartFile.createNewFile();
                writeEmptyJsonArray(cartFile);
            }

            if (!paymentFile.exists()) {
                paymentFile.createNewFile();
                writeEmptyJsonArray(paymentFile);
            }

            if (!ratingFile.exists()) {
                ratingFile.createNewFile();
                writeEmptyJsonArray(ratingFile);
            }

            if (!complaintFile.exists()) {
                complaintFile.createNewFile();
                writeEmptyJsonArray(complaintFile);
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
