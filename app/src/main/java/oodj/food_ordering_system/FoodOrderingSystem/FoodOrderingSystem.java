
package oodj.food_ordering_system.FoodOrderingSystem;

import java.io.IOException;
import javax.swing.SwingUtilities;

import oodj.food_ordering_system.designUI.LoginPage;
import oodj.food_ordering_system.utils.FileChecker;

public class FoodOrderingSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                if (firstTimeSetup()) { 
                    new LoginPage().start();
                } else {
                    new LoginPage().start();;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static boolean firstTimeSetup() throws IOException {
        return FileChecker.systemInitialized();
    }

}


