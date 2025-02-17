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

// Testing
public class VendorHandling {
    private static final String MENU = FileHandling.filePath.MENU_PATH.getValue();
    private static final String PAYMENT = FileHandling.filePath.PAYMENT_PATH.getValue();


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order History Checker");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel periodLabel = new JLabel("Select Period:");
        periodLabel.setBounds(10, 20, 150, 25);
        panel.add(periodLabel);

        String[] periods = {"Daily", "Monthly", "Quarterly"};
        JComboBox<String> periodDropdown = new JComboBox<>(periods);
        periodDropdown.setBounds(150, 20, 150, 25);
        panel.add(periodDropdown);

        JButton checkButton = new JButton("Check History");
        checkButton.setBounds(150, 60, 150, 25);
        panel.add(checkButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 100, 360, 50);
        panel.add(resultArea);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPeriod = (String) periodDropdown.getSelectedItem();
                JSONArray history = getVendorOrderHistory("VD00001", selectedPeriod);
                resultArea.setText(selectedPeriod + " order history: " + history.toString());
                createRevenueChart(history);

            }
        });
    }
                
                
    private static JSONArray getVendorOrderHistory(String vendorID, String period) {
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
            System.out.println("Cutoff Date: " + cutoffDate); // Debugging

            for (int i = 0; i < orderArray.length(); i++) {
                JSONObject order = orderArray.getJSONObject(i);
                System.out.println("Processing Order: " + order.toString(2)); // Debugging
                
                JSONArray orderItems = order.getJSONArray("OrderItems");
                for (int j = 0; j < orderItems.length(); j++) {
                    JSONObject item = orderItems.getJSONObject(j);
                    String menuID = item.getString("menuID");
                    JSONObject menuItem = getMenuItem(menuID);
                    
                    if (!menuItem.has("VendorID")) continue;
                    System.out.println("Menu Item: " + menuItem.toString(2)); // Debugging
                    
                    if (menuItem.getString("VendorID").equals(vendorID)) {
                        Date orderDate = sdf.parse(order.getString("Date"));
                        System.out.println("Order Date: " + orderDate); // Debugging

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

    private static JSONObject getMenuItem(String menuID) {
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



    private static void createRevenueChart(JSONArray history) {
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
