package oodj.food_ordering_system.utils;

import oodj.food_ordering_system.models.Item;
import oodj.food_ordering_system.models.Vendor;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ItemHandling {

    private static final String ITEM = FileHandling.filePath.ITEM_PATH.getValue();

    public static String getItemID() {
        int tempCount = 0;
        
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ITEM)));
            JSONArray itemsArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject itemData = itemsArray.getJSONObject(i);
                
                String itemID = itemData.getString("ItemID");
                if (itemID.startsWith("IT")) {
                    tempCount++;
                } else {
                    System.out.println("Invalid ItemID: " + itemID);
    
                    DialogBox.errorMessage("Invalid data or format for item: " + itemID, "Error");
                }
                
            }
        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing item JSON file: " + e.getMessage(), "Error");
        }
        return "IT" + String.format("%03d", tempCount + 1);
    }

    public static void createItem(Vendor vendor, String itemName, String category, double price, boolean status) {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ITEM)));
            JSONArray itemsArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);

            String itemID = getItemID();
            Item item = new Item(itemID, String.valueOf(vendor.getVendorID()), itemName, category, price, status);

            JSONObject itemObject = new JSONObject();
            itemObject.put("ItemID", item.getItemID());
            itemObject.put("VendorID", item.getVendorID());
            itemObject.put("ItemName", item.getItemName());
            itemObject.put("Category", item.getCategory());
            itemObject.put("Price", item.getPrice());
            itemObject.put("Status", item.isStatus());

            // Add new item to array
            itemsArray.put(itemObject);

//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ITEM))) {
//                writer.write(itemsArray.toString(4));
//            }
            FileHandling.writeToFile(ITEM, itemsArray.toString(4), false);
            DialogBox.successMessage("Item " + itemName + " added successfully!", "Success");

        } catch (Exception e) {
            DialogBox.errorMessage("Error adding item: " + e.getMessage(), "Error");
        }
    }
    
    public static ArrayList<Item> getItem() {
        ArrayList<Item> items = new ArrayList<>();
        
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ITEM)));
            JSONArray itemsArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject itemData = itemsArray.getJSONObject(i);
                
                String itemID = itemData.getString("ItemID");
                String vendorID = itemData.getString("VendorID");
                String itemName = itemData.getString("ItemName");
                String category = itemData.getString("Category");
                double price = itemData.getDouble("Price");
                boolean status = itemData.getBoolean("Status");

                Item item = new Item(itemID, vendorID, itemName, category, price, status);
                items.add(item);
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error retrieving items: " + e.getMessage(), "Error");
        }
        
        return items;
    }
    
     public static void updateItemInfo(String itemID, String newItemName, String newCategory, double newPrice, boolean newStatus) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ITEM)));
            JSONArray itemsArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);

            boolean itemUpdated = false;

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject itemData = itemsArray.getJSONObject(i);

                if (itemData.getString("ItemID").equals(itemID)) {
                    itemData.put("ItemName", newItemName);
                    itemData.put("Category", newCategory);
                    itemData.put("Price", newPrice);
                    itemData.put("Status", newStatus);
                    itemUpdated = true;
                    break;
                }
            }

            if (itemUpdated) {
                FileHandling.writeToFile(ITEM, itemsArray.toString(4), false);
                DialogBox.successMessage("Item " + itemID + " updated successfully!", "Success");
            } else {
                DialogBox.errorMessage("Item with ID " + itemID + " not found!", "Error");
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error updating item: " + e.getMessage(), "Error");
        }
    }
     
    public static void deleteItem(String itemID) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(ITEM)));
            JSONArray itemsArray = jsonData.trim().isEmpty() ? new JSONArray() : new JSONArray(jsonData);

            boolean itemDeleted = false;

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject itemData = itemsArray.getJSONObject(i);

                if (itemData.getString("ItemID").equals(itemID)) {
                    itemsArray.remove(i);
                    itemDeleted = true;
                    break;
                }
            }

            if (itemDeleted) {
                FileHandling.writeToFile(ITEM, itemsArray.toString(4), false);
                DialogBox.successMessage("Item " + itemID + " deleted successfully!", "Success");
            } else {
                DialogBox.errorMessage("Item with ID " + itemID + " not found!", "Error");
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error deleting item: " + e.getMessage(), "Error");
        }
    }


    
 
}