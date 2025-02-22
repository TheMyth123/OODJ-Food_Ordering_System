package oodj.food_ordering_system.utils;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONObject;

public class VendorHandling {
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();
    private static final String PAYMENT = FileHandling.filePath.PAYMENT_PATH.getValue();
                
                

    public static JSONArray getVendorOrderHistory(String vendorID, String period) {
        try {
            String filePath = PAYMENT;
            FileHandling.checkFile(filePath);
            JSONArray orderArray = new JSONArray();
            File file = new File(filePath);
    
            if (file.length() > 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    orderArray = new JSONArray(content.toString());
                }
            }
    
            JSONArray filteredOrders = new JSONArray();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
    
            switch (period.toLowerCase()) {
                case "daily":
                    cal.add(Calendar.DAY_OF_YEAR, -1);
                    break;
                case "monthly":
                    cal.add(Calendar.MONTH, -1);
                    break;
                case "quarterly":
                    cal.add(Calendar.MONTH, -3);
                    break;
            }
    
            Date cutoffDate = cal.getTime();
    
            for (int i = 0; i < orderArray.length(); i++) {
                JSONObject order = orderArray.getJSONObject(i);
    
                // Check if order status is "Completed"
                String orderStatus = order.optString("OrderStatus", ""); 
                if (!orderStatus.equals("Completed")) {
                    continue; // Skip non-completed orders
                }
    
                
                JSONArray orderItems = order.getJSONArray("OrderItems");
                for (int j = 0; j < orderItems.length(); j++) {
                    JSONObject item = orderItems.getJSONObject(j);
                    String menuID = item.getString("menuID");
                    JSONObject menuItem = getMenuItem(menuID);
                    
                    if (!menuItem.has("VendorID")) continue;
                    
                    if (menuItem.getString("VendorID").equals(vendorID)) {
                        Date orderDate = sdf.parse(order.getString("Date"));
    
                        if (!orderDate.before(cutoffDate)) {
                            filteredOrders.put(order);
                        }
                    }
                }
            }
            return filteredOrders;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }
    

    public static JSONObject getMenuItem(String menuID) {
    try {
        String filePath = MENU;
        FileHandling.checkFile(filePath);
        JSONArray menuArray = new JSONArray();
        File file = new File(filePath);

        if (file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                menuArray = new JSONArray(content.toString());
            }
        }

        for (int i = 0; i < menuArray.length(); i++) {
            JSONObject menuItem = menuArray.getJSONObject(i);
            if (menuItem.getString("id").equals(menuID)) {
                return menuItem;
            }
        }
    } catch (Exception e) {
        DialogBox.errorMessage("Error fetching menu item.", "Error");
    }
    return new JSONObject();
}

    // UI Dropdown for selecting period
    JComboBox<String> periodDropdown = new JComboBox<>(new String[]{"Daily", "Monthly", "Quarterly"});
    String selectedPeriod = (String) periodDropdown.getSelectedItem();
    JSONArray history = getVendorOrderHistory("VD00001", selectedPeriod);
    // System.out.println(selectedPeriod + " order history: " + history.toString());



    public static void createRevenueChart(JSONArray history) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < history.length(); i++) {
            JSONObject order = history.getJSONObject(i);
            String date = order.getString("Date");
            double totalAmount = order.getDouble("TotalAmount");
            dataset.addValue(totalAmount, "Revenue", date);
        }

        JFreeChart chart = ChartFactory.createLineChart(
            "Revenue Over Time", "Date", "Revenue",
            dataset);
        
        JFrame chartFrame = new JFrame("Revenue Chart");
        chartFrame.setSize(600, 400);
        chartFrame.add(new ChartPanel(chart));
        chartFrame.setVisible(true);
    }
}
