package oodj.food_ordering_system.designUI;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.models.Vendor;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.UserHandling;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerMenuItems extends JPanel {
    private JLabel ImageLabel;
    private JLabel NameLabel;
    private JLabel DescriptionLabel;
    private JLabel PriceLabel;
    private JLabel VendorNameLabel;
    private JButton btnDelete;
    private String id;

    public ManagerMenuItems(String id, String name, String description, double price, String imagePath, String status, String vendorID) {
        this.id = id;
        // Set panel properties similar to your original code
        setBackground(new Color(42, 42, 42));
        setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        setMaximumSize(new Dimension(880, 150));
        setMinimumSize(new Dimension(850, 150));
        setPreferredSize(new Dimension(850, 150));
        setLayout(new BorderLayout(10, 10));  // 10px horizontal & vertical gaps

        // Create and add the image label on the left
        ImageLabel = new JLabel();
        ImageLabel.setPreferredSize(new Dimension(150, 150));
        // Load the image icon from the given path and scale it to fit the label
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageLabel.setIcon(new ImageIcon(scaledImage));
        add(ImageLabel, BorderLayout.WEST);

        // Create a panel for displaying the details (center)
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBackground(new Color(42, 42, 42));
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

        NameLabel = new JLabel(id + ": " + name);
        NameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        NameLabel.setForeground(new Color(255, 178, 102));

        DescriptionLabel = new JLabel("Description: " + description);
        DescriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        DescriptionLabel.setForeground(new Color(211, 211, 211));

        PriceLabel = new JLabel("Price: RM " + price);
        PriceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        PriceLabel.setForeground(new Color(211, 211, 211));

        Vendor Vendor = UserHandling.getVendorByID(vendorID);
        String vendorname = Vendor.getName();

        VendorNameLabel = new JLabel("Vendor: " + vendorname);
        VendorNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        VendorNameLabel.setForeground(new Color(211, 211, 211));

        // Add the detail labels to the details panel
        detailsPanel.add(Box.createVerticalStrut(22));
        detailsPanel.add(NameLabel);
        detailsPanel.add(Box.createVerticalStrut(7));
        detailsPanel.add(DescriptionLabel);
        detailsPanel.add(Box.createVerticalStrut(7));
        detailsPanel.add(PriceLabel);
        detailsPanel.add(Box.createVerticalStrut(7));
        detailsPanel.add(VendorNameLabel);
        detailsPanel.add(Box.createVerticalGlue());

        add(detailsPanel, BorderLayout.CENTER);

        // Create and add the delete button on the right
        btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(180, 45, 40));
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setPreferredSize(new Dimension(100, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, BorderLayout.EAST);
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) { 
        UpdateItemStatus("False", id);
        btnDelete.setEnabled(false);
        btnDelete.setBackground(new java.awt.Color(169, 169, 169)); // Light grey
        oodj.food_ordering_system.models.Menu menu = UserHandling.getMenuByID(id);
        Vendor vendor = UserHandling.getVendorByID(menu.getVendorID());
        String vendorID = vendor.getID();
        String type = "Vendor Item Removed";
        String content = "Your item has been taken down. Please contact the manager if you have any questions.";
        String title = "Item Removed";
        String actionlink = "null";
        NotificationUtils.NotificationCreator(vendorID, type, content, title, actionlink);
    }   

    private void UpdateItemStatus(String status, String itemID){
        try {                                          
            String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\menu.txt";
            FileHandling.checkFile(filePath);
    
            JSONArray menuArray;
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
            } else {
                DialogBox.errorMessage("No item data found to edit.", "Error");
                return;
            }
    
            boolean itemFound = false;
            for (int i = 0; i < menuArray.length(); i++) {
                JSONObject menu = menuArray.getJSONObject(i);
                if (menu.getString("id").equals(itemID)) {
                    menu.put("Status", status);
                    itemFound = true;
                    break;
                }
            }
    
            if (!itemFound) {
                DialogBox.errorMessage("Top Up request with ID " + itemID + " not found.", "Error");
                return;
            }
    
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(menuArray.toString(2)); // Pretty print with indentation
                fileWriter.flush();
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }
}
