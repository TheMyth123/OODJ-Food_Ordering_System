package oodj.food_ordering_system.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.models.Vendor;


public class FoodCourtHandling {
    private static final String VENDOR = FileHandling.filePath.VENDOR_PATH.getValue();

    public static ArrayList<Vendor> getCourtNames() {
        ArrayList<Vendor> vendors = new ArrayList<>();

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(VENDOR)));
            JSONArray foodCourtArray = new JSONArray(jsonData);

            for (int i = 0; i < foodCourtArray.length(); i++) {
                JSONObject foodCourtData = foodCourtArray.getJSONObject(i);
                String vendorID = foodCourtData.getString("VendorID");
                String foodCourtName = foodCourtData.getString("FoodCourtName");
                vendors.add(new Vendor(vendorID, foodCourtName));
            }

        } catch (Exception e) {
            DialogBox.errorMessage("Error reading or parsing vendor JSON file: " + e.getMessage(), "Error");
        }

        return vendors;
    }


    
}
