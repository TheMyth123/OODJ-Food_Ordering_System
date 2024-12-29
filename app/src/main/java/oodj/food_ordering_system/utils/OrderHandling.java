package oodj.food_ordering_system.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderHandling {
    
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();
    private static final String CART = FileHandling.filePath.CART_PATH.getValue();



    public static List<JSONObject> readMenuFile(String vendorID) throws IOException {
         // Path to the menu file
        ArrayList<String> lines = FileHandling.readLines(MENU);
        StringBuilder jsonData = new StringBuilder();
        for (String line : lines) {
            jsonData.append(line);
        }
        JSONArray menuArray = new JSONArray(jsonData.toString());
        List<JSONObject> menuItems = new ArrayList<>();
        for (int i = 0; i < menuArray.length(); i++) {
            menuItems.add(menuArray.getJSONObject(i));
        }
        return filterMenuByVendor(menuItems, vendorID);
    }

    public static List<JSONObject> filterMenuByVendor(List<JSONObject> menuItems, String vendorID) {
        List<JSONObject> filteredMenu = new ArrayList<>();
         // Convert vendorID to string for comparison
        for (JSONObject item : menuItems) {
            if (item.getString("VendorID").equals(vendorID)) {
                filteredMenu.add(item);
            }
        }
        return filteredMenu;
    }

    public static ArrayList<String> getCart() {
        ArrayList<String> cartItems = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(CART)));
            if (!content.isEmpty()) {
                JSONArray cartArray = new JSONArray(content);
                for (int i = 0; i < cartArray.length(); i++) {
                    JSONObject item = cartArray.getJSONObject(i);
                    String itemDetails = "quantity: " + item.getString("quantity") + ", " +
                                         "price: " + item.getString("price") + ", " +
                                         "imagePath: " + item.getString("imagePath") + ", " +
                                         "name: " + item.getString("name");
                    cartItems.add(itemDetails);
                }
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Error reading or parsing the JSON file: " + e.getMessage(), "Error");
        }
        return cartItems;
    }

   
}
