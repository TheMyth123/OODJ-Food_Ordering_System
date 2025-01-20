package oodj.food_ordering_system.designUI;


import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.OrderHandling;
import raven.glasspanepopup.*;

import static oodj.food_ordering_system.designUI.LoginPage.loginID;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
// TODO design have done yet, discard items will affect the cart.txt json format
// set on more can choose which food to pay
// need to add refresh page
public class Cart extends javax.swing.JFrame {

    private Customer endUser;



    public Cart(Customer endUser) {
        this.endUser = endUser;            
        System.out.println("CusDash initialized with customerID: " + endUser.getID()); // Debugging statement
        initComponents();
        displayCartItems();
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            @Override
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                refreshCart();
            }
            @Override
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                // Do nothing
            }
        });
        
    }
    // private void updateCartQuantity(String foodName, int newQuantity) {
    //         String filePath = FileHandling.filePath.CART_PATH.getValue();
    //         try {
    //             String content = new String(Files.readAllBytes(Paths.get(filePath)));
    //             JSONArray cartArray = new JSONArray(content);
    //             for (int i = 0; i < cartArray.length(); i++) {
    //                 JSONObject item = cartArray.getJSONObject(i);
    //                 if (item.getString("name").equals(foodName)) {
    //                     System.out.println("Updating quantity for " + foodName + " to " + newQuantity); // Debugging statement
    //                     item.put("quantity", j);
    //                 break;
    //             }
    //         }
    //         FileHandling.saveToFile(cartArray, filePath);
    //         System.out.println("Cart updated successfully."); // Debugging statement
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    

    
    // Method to update the quantity in the cart
    public void displayCartItems() {
        List<String> cartItems = OrderHandling.getCart();
    
        title_container1.setLayout(new BoxLayout(title_container1, BoxLayout.Y_AXIS));
        title_container1.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        for (String item : cartItems) {
            System.out.println("Item received: " + item);
    
            try {
                int quantity = 0;
                double price = 0.0;
                String imagePath = "";
                String foodName = "";
    
                // Check if the item is in JSON format or plain text
                if (item.trim().startsWith("{")) {
                    // If JSON, parse it
                    JSONObject jsonItem = new JSONObject(item);
    
                    quantity = jsonItem.optInt("quantity", 0);
                    String priceStr = jsonItem.optString("price").replace("$", "");
                    price = Double.parseDouble(priceStr);
                    imagePath = jsonItem.optString("imagePath");
                    foodName = jsonItem.optString("name");
    
                } else {
                    // If plain string, parse it manually
                    String[] itemParts = item.split(", ");
                    if (itemParts.length < 4) {
                        System.err.println("Invalid item format: " + item);
                        continue;
                    }
    
                    quantity = Integer.parseInt(itemParts[0].split(": ")[1].trim());
                    price = Double.parseDouble(itemParts[1].split(": ")[1].replace("$", "").trim());
                    imagePath = itemParts[2].split(": ")[1].trim();
                    foodName = itemParts[3].split(": ")[1].trim();
                }
    
                double totalAmount = quantity * price;
    
                JPanel itemPanel = new JPanel();
                itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));
                itemPanel.setPreferredSize(new Dimension(900, 80));
                itemPanel.setMaximumSize(new Dimension(900, 80));
                itemPanel.setBackground(Color.WHITE);
                itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
                // Quantity field
                JTextField quantityField = new JTextField(String.valueOf(quantity));
                quantityField.setPreferredSize(new Dimension(50, 30));
                quantityField.setMaximumSize(new Dimension(50, 30));
                quantityField.setForeground(new Color(255, 169, 140));
                quantityField.setBackground(new Color(31, 31, 31));
                quantityField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                quantityField.setEditable(true);
    
                // Total amount label
                JLabel totalAmountLabel = new JLabel(String.format("$%.2f", totalAmount));
                totalAmountLabel.setPreferredSize(new Dimension(100, 30));
                totalAmountLabel.setForeground(new Color(255, 169, 140));
                totalAmountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    
                // Plus and Minus buttons
                JButton minusButton = new JButton("-");
                JButton plusButton = new JButton("+");
    
                // minusButton.addActionListener(e -> updateCartQuantity(foodName, -1, quantityField, totalAmountLabel, price));
                // plusButton.addActionListener(e -> updateCartQuantity(foodName, 1, quantityField, totalAmountLabel, price));
    
                JPanel quantityPanel = new JPanel();
                quantityPanel.add(minusButton);
                quantityPanel.add(quantityField);
                quantityPanel.add(plusButton);
                itemPanel.add(quantityPanel);
    
                itemPanel.add(totalAmountLabel);
    
                // Delete button
                JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(evt -> {
                    discardItem(item);
                    displayCartItems();
                });
                itemPanel.add(deleteButton);
    
                title_container1.add(itemPanel);
                title_container1.add(Box.createRigidArea(new Dimension(0, 10)));
    
            } catch (Exception e) {
                System.err.println("Invalid item format: " + item);
                e.printStackTrace();
            }
        }
    
        // Checkout Panel
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.X_AXIS));
        checkoutPanel.setPreferredSize(new Dimension(900, 50));
        checkoutPanel.setBackground(new Color(31, 31, 31));
    
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(evt -> {
            try {
                checkout();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error during checkout process.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
        checkoutPanel.add(checkoutButton);
    
        title_container1.add(checkoutPanel);

        title_container1.revalidate();
        title_container1.repaint();
    }
    
    
    // Method to update the quantity in the cart
    private void updateCartQuantity(String foodName, int delta, JTextField quantityField, JLabel totalAmountLabel, double price) {
        String filePath = FileHandling.filePath.CART_PATH.getValue();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray cartArray = new JSONArray(content);
            for (int i = 0; i < cartArray.length(); i++) {
                JSONObject item = cartArray.getJSONObject(i);
                if (item.getString("name").equals(foodName)) {
                    int currentQuantity = item.getInt("quantity");
                    int newQuantity = Math.max(currentQuantity + delta, 0);
                    item.put("quantity", newQuantity);
                    quantityField.setText(String.valueOf(newQuantity));
                    double newTotalAmount = newQuantity * price;
                    totalAmountLabel.setText(String.format("$%.2f", newTotalAmount));
                    break;
                }
            }
            FileHandling.saveToFile(cartArray, filePath);
            System.out.println("Cart updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void refreshCart() {
        title_container1.removeAll();  // Clear the cart UI components
        displayCartItems();            // Reload the cart items
        title_container1.revalidate();  // Refresh layout
        title_container1.repaint();     // Repaint UI
    }
    

    private void checkout() throws IOException {
        String cartFilePath = FileHandling.filePath.CART_PATH.getValue();
        JSONArray cartArray = new JSONArray();
    
        // Read existing cart items from the file
        try {
            String content = new String(Files.readAllBytes(Paths.get(cartFilePath)));
            if (!content.isEmpty()) {
                cartArray = new JSONArray(content);
            } else {
                JOptionPane.showMessageDialog(null, "Cart is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading cart file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid JSON format in cart file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Prompt the user to select the service type
        String[] options = {"Dine In", "Take-Away", "Request for Delivery"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "Please select an order type:",
            "Order Type",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );
    
        if (choice == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "No order type selected. Please try again.");
            return;
        }
    
        String serviceType = options[choice];
    
        // Prepare payment summary
        JSONObject paymentSummary = new JSONObject();
        JSONArray orderItems = new JSONArray();
        double totalAmount = 0;
    
        for (int i = 0; i < cartArray.length(); i++) {
            JSONObject item = cartArray.getJSONObject(i);
            
            int quantity = Integer.parseInt(item.get("quantity").toString());
            double price = Double.parseDouble(item.getString("price").replace("$", ""));
            double itemTotal = quantity * price;
    
            totalAmount += itemTotal;
    
            JSONObject orderItem = new JSONObject();
            orderItem.put("name", item.getString("name"));
            orderItem.put("quantity", quantity);
            orderItem.put("price", price);
            orderItem.put("totalPrice", itemTotal);
    
            orderItems.put(orderItem);
        }
    
        paymentSummary.put("CustomerID", endUser.getID());
        paymentSummary.put("ServiceType", serviceType);
        paymentSummary.put("TotalAmount", totalAmount);
        paymentSummary.put("PaymentStatus", "Pending");
        paymentSummary.put("OrderItems", orderItems);
    
        // Check customer credit balance
        List<Credit> credits = OrderHandling.getCredits();
        Credit customerCredit = null;
        for (Credit credit : credits) {
            if (credit.getCustomerID().equals(endUser.getID())) {
                customerCredit = credit;
                break;
            }
        }
    
        if (customerCredit != null) {
            // Open Payment Page with summarized order data
            new CusPayment(
                "ORDER" + System.currentTimeMillis(),  // Auto-generate Order ID
                "Multiple Items", 
                String.valueOf(cartArray.length()), 
                String.format("%.2f", totalAmount),  
                customerCredit,
                serviceType, paymentSummary // Passing payment summary
            ).setVisible(true);


            
        } else {
            JOptionPane.showMessageDialog(this, "Credit information not found for customer ID: " + endUser.getID(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    
    

    



    // private void displayCartItems() {
    //     List<String> cartItems = OrderHandling.getCart();
    //     title_container1.removeAll();

    //     title_container1.setLayout(new BoxLayout(title_container1, BoxLayout.Y_AXIS));
    //     title_container1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
    //     for (String item : cartItems) {
    //         JPanel itemPanel = new JPanel();
    //         itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));
    //         itemPanel.setPreferredSize(new Dimension(630, 40));
    //         itemPanel.setMaximumSize(new Dimension(630, 40));
    //         itemPanel.setMinimumSize(new Dimension(630, 40));
    //         itemPanel.setBackground(new Color(31, 31, 31));
    //         itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    //         // TODO orderID
    //         // Extract details from item string (assuming item string contains these details)
    //         String[] itemParts = item.split(", ");
    //         String orderID = itemParts[2].split(": ")[1];
    //         String quantity = itemParts[0].split(": ")[1];
    //         String foodName = itemParts[3].split(": ")[1];
    //         String totalAmount = itemParts[1].split(": ")[1];

    //         // Quantity
    //         JTextField quantityField = new JTextField(quantity);
    //         quantityField.setPreferredSize(new Dimension(50, 30));
    //         quantityField.setMaximumSize(new Dimension(50, 30));
    //         quantityField.setMinimumSize(new Dimension(50, 30));
    //         quantityField.setForeground(new Color(255, 169, 140)); // Set text color
    //         quantityField.setBackground(new Color(31, 31, 31));
    //         quantityField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    //         quantityField.setOpaque(true);
    //         quantityField.setEditable(true); // Make it editable
    //         // quantityField.addActionListener(new ActionListener() {
    //         //     @Override
    //         //     public void actionPerformed(ActionEvent e) {
    //         //         String newQuantity = quantityField.getText();
    //         //         // Update the quantity in the cart
    //         //         updateCartQuantity(foodName, newQuantity);
    //         //     }
    //         // });
    //         itemPanel.add(quantityField);


    //         // Food Name
    //         JLabel foodNameLabel = new JLabel(foodName);
    //         foodNameLabel.setPreferredSize(new Dimension(200, 30));
    //         foodNameLabel.setMaximumSize(new Dimension(200, 30));
    //         foodNameLabel.setMinimumSize(new Dimension(200, 30));
    //         foodNameLabel.setForeground(new Color(255, 169, 140)); // Set text color
    //         foodNameLabel.setBackground(new Color(31, 31, 31));
    //         foodNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    //         foodNameLabel.setOpaque(true);
    //         itemPanel.add(foodNameLabel);

    //         // Total Amount
    //         JLabel totalAmountLabel = new JLabel(totalAmount);
    //         totalAmountLabel.setPreferredSize(new Dimension(100, 30));
    //         totalAmountLabel.setMaximumSize(new Dimension(100, 30));
    //         totalAmountLabel.setMinimumSize(new Dimension(100, 30));
    //         totalAmountLabel.setForeground(new Color(255, 169, 140)); // Set text color
    //         totalAmountLabel.setBackground(new Color(31, 31, 31));
    //         totalAmountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    //         totalAmountLabel.setOpaque(true);
    //         itemPanel.add(totalAmountLabel);

    //         // Button panel
    //         JPanel buttonPanel = new JPanel();
    //         buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    //         buttonPanel.setPreferredSize(new Dimension(350, 40));
    //         buttonPanel.setMaximumSize(new Dimension(350, 40));
    //         buttonPanel.setMinimumSize(new Dimension(350, 40));
    //         buttonPanel.setBackground(new Color(43, 43, 43));

    //         JButton editButton = new JButton("Edit");
    //         JButton payButton = new JButton("Pay");
    //         JButton discardButton = new JButton("Discard");
    //         // JButton plusButton = new JButton("+");
    //         // JButton minusButton = new JButton("-");

    //         // Set uniform button sizes
    //         Dimension buttonSize = new Dimension(80, 30);
    //         editButton.setPreferredSize(buttonSize);
    //         editButton.setMaximumSize(buttonSize);
    //         editButton.setMinimumSize(buttonSize);

    //         payButton.setPreferredSize(buttonSize);
    //         payButton.setMaximumSize(buttonSize);
    //         payButton.setMinimumSize(buttonSize);

    //         discardButton.setPreferredSize(buttonSize);
    //         discardButton.setMaximumSize(buttonSize);
    //         discardButton.setMinimumSize(buttonSize);

    //         // plusButton.setPreferredSize(buttonSize);
    //         // plusButton.setMaximumSize(buttonSize);
    //         // plusButton.setMinimumSize(buttonSize);
    //         // plusButton.setEnabled(false); // Initially disabled

    //         // minusButton.setPreferredSize(buttonSize);
    //         // minusButton.setMaximumSize(buttonSize);
    //         // minusButton.setMinimumSize(buttonSize);
    //         // minusButton.setEnabled(false); // Initially disabled

    //         editButton.addActionListener(evt -> {
    //             if (editButton.getText().equals("Edit")) {
    //                 quantityField.setEditable(true);
    //                 editButton.setText("Save");
    //             } else {
    //                 quantityField.setEditable(false);
    //                 String newQuantity = quantityField.getText();
    //                 updateCartQuantity(foodName, newQuantity);
    //                 editButton.setText("Edit");
    //             }
    //         });
            

    //         // plusButton.addActionListener(evt -> {
    //         //     int currentQuantity = Integer.parseInt(quantityField.getText());
    //         //     quantityField.setText(String.valueOf(currentQuantity + 1));
    //         // });

    //         // minusButton.addActionListener(evt -> {
    //         //     int currentQuantity = Integer.parseInt(quantityField.getText());
    //         //     if (currentQuantity > 1) {
    //         //         quantityField.setText(String.valueOf(currentQuantity - 1));
    //         //     }
    //         // });

    //         payButton.addActionListener(evt -> {
    //         // Load credits
    //         List<Credit> credits = OrderHandling.getCredits();
    //         Credit customerCredit = null;
    //         for (Credit credit : credits) {
    //             if (credit.getCustomerID().equals(endUser.getID())) {
    //                 customerCredit = credit;
    //                 break;
    //             }
    //         }

    //         if (customerCredit != null) {
    //             // Pass details to Payment page
    //              // Convert JLabel to String
    //             new Payment(orderID, foodName, quantityField.getText(), totalAmountLabel.getText(), customerCredit).setVisible(true);
    //             dispose(); // Close the Cart page
    //         } else {
    //             JOptionPane.showMessageDialog(this, "Credit information not found for customer ID: " + endUser.getID(), "Error", JOptionPane.ERROR_MESSAGE);
    //         }
    //     });

    //         discardButton.addActionListener(evt -> {
    //             discardItem(item);
    //             displayCartItems(); // Refresh the cart display
    //         });

    //         buttonPanel.add(editButton);
    //         buttonPanel.add(Box.createRigidArea(new Dimension(5, 0))); // Space between buttons
    //         buttonPanel.add(payButton);
    //         buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
    //         buttonPanel.add(discardButton);
    //         buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
    //         // buttonPanel.add(plusButton);
    //         buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
    //         // buttonPanel.add(minusButton);

    //         // Combined panel
    //         JPanel combinedPanel = new JPanel();
    //         combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.X_AXIS));
    //         combinedPanel.setPreferredSize(new Dimension(900, 40));
    //         combinedPanel.setMaximumSize(new Dimension(900, 40));
    //         combinedPanel.setMinimumSize(new Dimension(900, 40));
    //         combinedPanel.setBackground(new Color(31, 31, 31));
    //         combinedPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    //         combinedPanel.add(itemPanel);
    //         combinedPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Space between itemPanel and buttonPanel
    //         combinedPanel.add(buttonPanel);

    //         title_container1.add(combinedPanel);
    //         title_container1.add(Box.createRigidArea(new Dimension(0, 5))); // Add space between items
    //     }

    //     title_container1.revalidate();
    //     title_container1.repaint();     

    // }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Line = new javax.swing.JPanel();
        Sidebar = new javax.swing.JPanel();
        margin1 = new javax.swing.JPanel();
        Logo_container = new javax.swing.JPanel();
        systemName = new javax.swing.JLabel();
        margin2 = new javax.swing.JPanel();
        btn_container1 = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_cart = new javax.swing.JButton();
        btn_history = new javax.swing.JButton();
        btn_profile = new javax.swing.JButton();
        margin3 = new javax.swing.JPanel();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Main = new javax.swing.JPanel();
        margin4 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        m5 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        title_container1 = new javax.swing.JPanel();
        m8 = new javax.swing.JPanel();
        m6 = new javax.swing.JPanel();
        margin5 = new javax.swing.JPanel();
        m7 = new javax.swing.JPanel();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Cart");
        setBackground(new java.awt.Color(25, 25, 25));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(null);

        Line.setBackground(new java.awt.Color(50, 50, 50));
        Line.setMaximumSize(new java.awt.Dimension(300, 670));
        Line.setMinimumSize(new java.awt.Dimension(300, 670));
        Line.setPreferredSize(new java.awt.Dimension(300, 670));

        javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
        Line.setLayout(LineLayout);
        LineLayout.setHorizontalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        LineLayout.setVerticalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        getContentPane().add(Line);
        Line.setBounds(300, 0, 2, 670);

        Sidebar.setBackground(new java.awt.Color(31, 31, 31));
        Sidebar.setAlignmentX(0.0F);
        Sidebar.setAlignmentY(0.0F);
        Sidebar.setMaximumSize(new java.awt.Dimension(300, 670));
        Sidebar.setMinimumSize(new java.awt.Dimension(300, 670));
        Sidebar.setPreferredSize(new java.awt.Dimension(300, 670));
        Sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        margin1.setBackground(new java.awt.Color(31, 31, 31));

        javax.swing.GroupLayout margin1Layout = new javax.swing.GroupLayout(margin1);
        margin1.setLayout(margin1Layout);
        margin1Layout.setHorizontalGroup(
            margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        margin1Layout.setVerticalGroup(
            margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Sidebar.add(margin1);

        Logo_container.setBackground(new java.awt.Color(31, 31, 31));
        Logo_container.setMaximumSize(new java.awt.Dimension(300, 100));
        Logo_container.setMinimumSize(new java.awt.Dimension(300, 100));
        Logo_container.setPreferredSize(new java.awt.Dimension(300, 100));
        Logo_container.setLayout(new javax.swing.BoxLayout(Logo_container, javax.swing.BoxLayout.LINE_AXIS));

        systemName.setBackground(new java.awt.Color(31, 31, 31));
        systemName.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        systemName.setForeground(new java.awt.Color(255, 169, 140));
        systemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        systemName.setText("Car Connect");
        //TODO CHANGE SYSTEM NAME
        systemName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        systemName.setAlignmentX(0.5F);
        systemName.setMaximumSize(new java.awt.Dimension(300, 50));
        systemName.setMinimumSize(new java.awt.Dimension(300, 50));
        systemName.setPreferredSize(new java.awt.Dimension(300, 50));
        Logo_container.add(systemName);

        Sidebar.add(Logo_container);

        margin2.setBackground(new java.awt.Color(31, 31, 31));
        margin2.setMaximumSize(new java.awt.Dimension(300, 50));
        margin2.setMinimumSize(new java.awt.Dimension(300, 50));
        margin2.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout margin2Layout = new javax.swing.GroupLayout(margin2);
        margin2.setLayout(margin2Layout);
        margin2Layout.setHorizontalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        margin2Layout.setVerticalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Sidebar.add(margin2);

        btn_container1.setBackground(new java.awt.Color(31, 31, 31));
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 320));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_home.setBackground(new java.awt.Color(31, 31, 31));
        btn_home.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(245, 251, 254));
        btn_home.setText("Home");
        btn_home.setBorder(null);
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.setFocusable(false);
        btn_home.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_home.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_home.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        btn_container1.add(btn_home);

        btn_cart.setBackground(new java.awt.Color(43, 43, 43));
        btn_cart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cart.setForeground(new java.awt.Color(255, 169, 140));
        btn_cart.setText("Cart");
        btn_cart.setBorder(null);
        btn_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cart.setFocusable(false);
        btn_cart.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_cart.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_cart.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_cart.setPreferredSize(new java.awt.Dimension(250, 40));
    
        btn_container1.add(btn_cart);

        btn_history.setBackground(new java.awt.Color(31, 31, 31));
        btn_history.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_history.setForeground(new java.awt.Color(245, 251, 254));
        btn_history.setText("Order History");
        btn_history.setBorder(null);
        btn_history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_history.setFocusable(false);
        btn_history.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_history.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_history.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_history.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historyActionPerformed(evt);
            }
        });
        btn_container1.add(btn_history);

        btn_profile.setBackground(new java.awt.Color(31, 31, 31));
        btn_profile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_profile.setForeground(new java.awt.Color(245, 251, 254));
        btn_profile.setText("Profile");
        btn_profile.setBorder(null);
        btn_profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_profile.setDoubleBuffered(true);
        btn_profile.setFocusable(false);
        btn_profile.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_profile.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_profile.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_profile.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profileActionPerformed(evt);
            }
        });
        btn_container1.add(btn_profile);

        Sidebar.add(btn_container1);

        margin3.setBackground(new java.awt.Color(31, 31, 31));
        margin3.setMaximumSize(new java.awt.Dimension(300, 100));
        margin3.setMinimumSize(new java.awt.Dimension(300, 100));
        margin3.setPreferredSize(new java.awt.Dimension(300, 80));

        javax.swing.GroupLayout margin3Layout = new javax.swing.GroupLayout(margin3);
        margin3.setLayout(margin3Layout);
        margin3Layout.setHorizontalGroup(
            margin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        margin3Layout.setVerticalGroup(
            margin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Sidebar.add(margin3);

        btn_container2.setBackground(new java.awt.Color(31, 31, 31));
        btn_container2.setMaximumSize(new java.awt.Dimension(300, 50));
        btn_container2.setMinimumSize(new java.awt.Dimension(300, 50));
        btn_container2.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_container2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        btn_logout.setBackground(new java.awt.Color(31, 31, 31));
        btn_logout.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(245, 251, 254));
        btn_logout.setText("Logout");
        btn_logout.setBorder(null);
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.setFocusable(false);
        btn_logout.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_logout.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_logout.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_logout.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        btn_container2.add(btn_logout);

        Sidebar.add(btn_container2);

        getContentPane().add(Sidebar);
        Sidebar.setBounds(0, 0, 300, 670);

        Main.setBackground(new java.awt.Color(31, 31, 31));
        Main.setAlignmentX(0.0F);
        Main.setAlignmentY(0.0F);
        Main.setMaximumSize(new java.awt.Dimension(1000, 670));
        Main.setMinimumSize(new java.awt.Dimension(1000, 670));
        Main.setPreferredSize(new java.awt.Dimension(1000, 670));
        Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        margin4.setBackground(new java.awt.Color(31, 31, 31));
        margin4.setMaximumSize(new java.awt.Dimension(1000, 50));
        margin4.setMinimumSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout margin4Layout = new javax.swing.GroupLayout(margin4);
        margin4.setLayout(margin4Layout);
        margin4Layout.setHorizontalGroup(
            margin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        margin4Layout.setVerticalGroup(
            margin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Main.add(margin4);

        title_container.setBackground(new java.awt.Color(31, 31, 31));
        title_container.setMaximumSize(new java.awt.Dimension(1000, 50));
        title_container.setMinimumSize(new java.awt.Dimension(1000, 50));
        title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
        title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        

        m5.setBackground(new java.awt.Color(31, 31, 31));
        m5.setMaximumSize(new java.awt.Dimension(60, 50));
        m5.setMinimumSize(new java.awt.Dimension(60, 50));
        m5.setPreferredSize(new java.awt.Dimension(60, 50));

        javax.swing.GroupLayout m5Layout = new javax.swing.GroupLayout(m5);
        m5.setLayout(m5Layout);
        m5Layout.setHorizontalGroup(
            m5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        m5Layout.setVerticalGroup(
            m5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        title_container.add(m5);

        // TODO title container add credit

        welcome.setBackground(new java.awt.Color(31, 31, 31));
        welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 169, 140));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Cart");
        welcome.setAlignmentX(0.5F);
        welcome.setMaximumSize(new java.awt.Dimension(50, 50));
        welcome.setMinimumSize(new java.awt.Dimension(50, 50));
        welcome.setPreferredSize(new java.awt.Dimension(50, 50));
        title_container.add(welcome);

        

        Main.add(title_container);

        title_container1.setBackground(new java.awt.Color(31, 31, 31));
        title_container1.setMaximumSize(new java.awt.Dimension(1000, 670));
        title_container1.setMinimumSize(new java.awt.Dimension(1000, 670));
        title_container1.setPreferredSize(new java.awt.Dimension(1000, 670));
        // title_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        m8.setBackground(new java.awt.Color(31, 31, 31));
        m8.setMaximumSize(new java.awt.Dimension(60, 60));
        m8.setMinimumSize(new java.awt.Dimension(60, 60));
        m8.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout m8Layout = new javax.swing.GroupLayout(m8);
        m8.setLayout(m8Layout);
        m8Layout.setHorizontalGroup(
            m8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        m8Layout.setVerticalGroup(
            m8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        title_container1.add(m8);


        Main.add(title_container1);

        m6.setBackground(new java.awt.Color(31, 31, 31));
        m6.setMaximumSize(new java.awt.Dimension(60, 50));
        m6.setMinimumSize(new java.awt.Dimension(60, 50));

        javax.swing.GroupLayout m6Layout = new javax.swing.GroupLayout(m6);
        m6.setLayout(m6Layout);
        m6Layout.setHorizontalGroup(
            m6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        m6Layout.setVerticalGroup(
            m6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Main.add(m6);

        margin5.setBackground(new java.awt.Color(31, 31, 31));
        margin5.setMaximumSize(new java.awt.Dimension(1000, 50));
        margin5.setMinimumSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout margin5Layout = new javax.swing.GroupLayout(margin5);
        margin5.setLayout(margin5Layout);
        margin5Layout.setHorizontalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        margin5Layout.setVerticalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Main.add(margin5);

        m7.setBackground(new java.awt.Color(31, 31, 31));
        m7.setMaximumSize(new java.awt.Dimension(1000, 50));
        m7.setMinimumSize(new java.awt.Dimension(1000, 50));
        m7.setPreferredSize(new java.awt.Dimension(1000, 50));
        m7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        Main.add(m7);

        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>    

    // //TODO I USED ADMIN DATA TO GET NOTIFICATIONS. CHANGE TO OWN DATA
    // List<Notification> notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications());
    
    // private void btn_NotiActionPerformed(java.awt.event.ActionEvent evt) {                                  
    //     GlassPanePopup.showPopup(new NotificationPanel(notifications), new DefaultOption(){
    //         @Override
    //         public float opacity() {
    //             return 0;
    //         }

    //         @Override
    //         public LayoutCallback getLayoutCallBack(java.awt.Component parent) {
    //             return new DefaultLayoutCallBack(parent){
    //                 @Override
    //                 public void correctBounds(ComponentWrapper cw) {
    //                     if (parent.isVisible()){
    //                         java.awt.Point pl = parent.getLocationOnScreen();
    //                         java.awt.Point bl = btn_Noti.getLocationOnScreen();
    //                         int x = bl.x - pl.x;
    //                         int y = bl.y - pl.y;
    //                         cw.setBounds(x - cw.getWidth() + btn_Noti.getWidth(), y + btn_Noti.getHeight(), cw.getWidth(), cw.getHeight());
    //                     } else {
    //                         super.correctBounds(cw);
    //                     }
    //                 }
    //             };
    //         }

    //     });
    // }   


    private void discardItem(String item) {
        // Read the current cart items from the file
        ArrayList<String> cartItems = OrderHandling.getCart();
        // Remove the selected item from the list
        cartItems.remove(item);
        // Write the updated list back to the file
        OrderHandling.saveCart(cartItems);
        System.out.println("Discard item: " + item);
    }

    

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            dispose();
            new LoginPage().setVisible(true);
        }
    }                                          

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
        new CusDash().setVisible(true);
    }                                        

    private void btn_historyActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new OrderHistory(endUser).setVisible(true);
        //TODO CALL PAGE 3
        System.out.println("Page 3");
    }                                                                          

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {                                        
        //dispose();
        //TODO CALL PAGE 4
        System.out.println("Page 4");
    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton btn_cart;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_history;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_profile;
    private javax.swing.JButton btn_logout;
    private javax.swing.JPanel m5;
    private javax.swing.JPanel m6;
    private javax.swing.JPanel m7;
    private javax.swing.JPanel m8;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin3;
    private javax.swing.JPanel margin4;
    private javax.swing.JPanel margin5;
    private javax.swing.JLabel systemName;
    private javax.swing.JPanel title_container;
    private javax.swing.JPanel title_container1;
    private javax.swing.JLabel welcome;
    private javax.swing.JButton btn_Noti;
    // End of variables declaration                   
}


