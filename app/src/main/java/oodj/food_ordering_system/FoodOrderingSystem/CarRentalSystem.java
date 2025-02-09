
package oodj.food_ordering_system.FoodOrderingSystem;


import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;

import oodj.food_ordering_system.designUI.LoginPage;

public class CarRentalSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                if (firstTimeSetup()) {
                    System.out.println("This is the first time setup");
                } else {
                    new LoginPage().start();;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static boolean systemInitialized()throws IOException {
        File managerFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\manager.txt");
        File adminFile = new File("app\\src\\main\\resources\\databases\\admin.txt");
        File customerFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\customer.txt");
        File vendorFile = new File("app\\\\src\\\\main\\\\resources\\\\databases\\\\vendor.txt");

        if (!managerFile.exists() || !adminFile.exists() || !customerFile.exists() || !vendorFile.exists()) {
            if (!managerFile.exists()) {
                managerFile.createNewFile();
            }
            if (!adminFile.exists()) {
                adminFile.createNewFile();
            }
            if (!customerFile.exists()) {
                customerFile.createNewFile();
            }
            if (!vendorFile.exists()) {
                vendorFile.createNewFile();
            }
            return true;
        }
        return false;
    }

    public static boolean firstTimeSetup() throws IOException {
        return systemInitialized();
    }

}


