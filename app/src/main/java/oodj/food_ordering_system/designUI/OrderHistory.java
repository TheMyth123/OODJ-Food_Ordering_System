package oodj.food_ordering_system.designUI;


import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.CusOrder;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.models.Payment;
import oodj.food_ordering_system.models.Rating;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.OrderHandling;
import oodj.food_ordering_system.utils.UserHandling;
import raven.glasspanepopup.*;

import static oodj.food_ordering_system.designUI.LoginPage.loginID;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JScrollPane;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
// TODO make the table refresh
// TODO design have done yet, discard items will affect the cart.txt json format
public class OrderHistory extends javax.swing.JFrame {

    private Customer endUser;
    private JTable historyTable;



    public OrderHistory(Customer endUser) {
        this.endUser = endUser;            
        System.out.println("CusDash initialized with customerID: " + endUser.getID()); // Debugging statement
        initComponents();
        ArrayList<Payment> payment = OrderHandling.getOrderHistory(); // Fetch cart items
        displayHistory(payment, endUser.getID()); // Display cart items
        // addWindowFocusListener(new java.awt.event.WindowFocusListener() {
        //     @Override
        //     public void windowGainedFocus(java.awt.event.WindowEvent evt) {
        //         // refreshCart();
        //     }
        //     @Override
        //     public void windowLostFocus(java.awt.event.WindowEvent evt) {
        //         // Do nothing
        //     }
        // });
        
    }


    private void displayHistory(ArrayList<Payment> paymentList, String endUserID) {
        if (historyTable == null) {
            historyTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Order ID", "Service Type", "Delivery Address", "Total Amount", "Date", "Order Status", "Payment Status"}
            ));
        }
    
        DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
        model.setRowCount(0); // Clear table before populating
    
        for (Payment payment : paymentList) {
            if (payment.getCustomerID().equals(endUserID)) {
                model.addRow(new Object[]{
                    payment.getOrderID(),
                    payment.getServiceType(),
                    payment.getAddress(),
                    payment.getTotalAmount(),
                    payment.getDate(),
                    payment.getOrderStatus(),
                    payment.getPaymentStatus()
                });
            }
        }

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));

        JButton searchButton = new JButton("Search");

        // **Set TableRowSorter for Filtering**
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        historyTable.setRowSorter(rowSorter);

        // **Search Button Click Event**
        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText().trim();
            if (searchTerm.isEmpty()) {
                rowSorter.setRowFilter(null); // ✅ Show all rows when search is empty
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // Case-insensitive search
            }
        });

        // **Real-Time Search (While Typing)**
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTerm = searchField.getText().trim();
                if (searchTerm.isEmpty()) {
                    rowSorter.setRowFilter(null); // ✅ Show all rows when search is cleared
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // Case-insensitive search
                }
            }
        });

        // **Create Search Panel**
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

    
        // **Scroll Pane for Order History Table**
        JScrollPane scrollPane = new JScrollPane(historyTable);
        scrollPane.setPreferredSize(new Dimension(500, 200));

        JButton rateButton = new JButton("Rate");
        rateButton.addActionListener(e -> {
            int selectedRow = historyTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedOrderID = model.getValueAt(selectedRow, 0).toString();
                showRatingDialog(selectedOrderID);
            } else {
                JOptionPane.showMessageDialog(null, "Please select an order to rate.");
            }
        });
    
        // **Reorder Button**
        JButton reorderButton = new JButton("Reorder");
        reorderButton.addActionListener(e -> {
            int selectedRow = historyTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedOrderID = model.getValueAt(selectedRow, 0).toString();
                reorderItems(selectedOrderID);
            } else {
                JOptionPane.showMessageDialog(null, "Please select an order to reorder.");
            }
        });
    
        // **View Receipt Button**
        JButton viewReceiptButton = new JButton("View Receipt");
        viewReceiptButton.addActionListener(e -> {
            int selectedRow = historyTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedOrderID = model.getValueAt(selectedRow, 0).toString();
                showReceipt(selectedOrderID);
            } else {
                JOptionPane.showMessageDialog(null, "Please select an order to view the receipt.");
            }
        });

        JButton viewFeedbackButton = new JButton("View Feedback");
        viewFeedbackButton.addActionListener(e -> {
            int selectedRow = historyTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedOrderID = model.getValueAt(selectedRow, 0).toString();
                showFeedback(selectedOrderID);
            } else {
                JOptionPane.showMessageDialog(null, "Please select an order to view feedback.");
            }
        });
    
        // **Button Panel**
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rateButton);
        buttonPanel.add(reorderButton);
        buttonPanel.add(viewFeedbackButton);
        buttonPanel.add(viewReceiptButton);
    
        // **Update UI**
        title_container1.removeAll();
        title_container1.setLayout(new BorderLayout());
        title_container1.add(searchPanel, BorderLayout.NORTH); 
        title_container1.add(scrollPane, BorderLayout.CENTER);
        title_container1.add(buttonPanel, BorderLayout.SOUTH);
        title_container1.revalidate();
        title_container1.repaint();
    }

    private void showFeedback(String orderID) {
        // Fetch ratings for the selected orderID
        ArrayList<Rating> ratings = OrderHandling.getRatings();
        StringBuilder feedback = new StringBuilder();
    
        for (Rating rating : ratings) {
            if (rating.getOrderID().equals(orderID)) {
                feedback.append("Customer ID: ").append(rating.getCustomerID()).append("\n");
                feedback.append("Rating: ").append(rating.getRating()).append("\n");
                feedback.append("Rating Type: ").append(rating.getRatingType()).append("\n");
            }
        }
    
        if (feedback.length() == 0) {
            feedback.append("No feedback available for this order.");
        }
    
        JOptionPane.showMessageDialog(null, feedback.toString(), "Feedback for Order " + orderID, JOptionPane.INFORMATION_MESSAGE);
    }


    private void reorderItems(String orderID) {
        Payment payment = OrderHandling.getPaymentByID(orderID);
        if (payment == null) {
            JOptionPane.showMessageDialog(null, "Order not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        int confirm = JOptionPane.showConfirmDialog(
            null, "Do you want to reorder this order?", "Reorder Confirmation",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // ✅ Step 1: Get current cart
            ArrayList<CusOrder> cartItems = OrderHandling.getCart();
    
            // ✅ Step 2: Loop through ordered items and update quantity if exists
            for (CusOrder newItem : payment.getOrderItems()) {
                boolean itemExists = false;
    
                for (CusOrder cartItem : cartItems) {
                    if (cartItem.getMenuID().equals(newItem.getMenuID())) {
                        // ✅ Update quantity instead of adding a new row
                        cartItem.setQuantity(cartItem.getQuantity() + newItem.getQuantity());
                        itemExists = true;
                        break;
                    }
                }
    
                // ✅ Step 3: If item doesn't exist, add it
                if (!itemExists) {
                    cartItems.add(new CusOrder(
                        newItem.getMenuID(), newItem.getQuantity(), newItem.getPrice(), newItem.getName(), newItem.getCustomer()
                    ));
                }
            }
    
            // ✅ Step 4: Save updated cart
            OrderHandling.saveCart(cartItems);
    
            // ✅ Step 5: Show success message
            JOptionPane.showMessageDialog(null, "Items added to cart successfully!", "Reorder Success", JOptionPane.INFORMATION_MESSAGE);
    
            // ✅ Step 6: Refresh Cart Page (if needed)
            // goToCartPage();
        }
    }


    
    
    
    private void showReceipt(String orderID) {
        Payment payment = OrderHandling.getPaymentByID(orderID);
        if (payment == null) {
            JOptionPane.showMessageDialog(null, "Order not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Open a new receipt window
        CusReceipt receiptWindow = new CusReceipt(orderID);
        receiptWindow.setVisible(true);
    }
    
    
    


    // private void showRatingDialog(String orderID) {
    //     String[] ratings = {"1", "2", "3", "4", "5"};
    //     String ratingStr = (String) JOptionPane.showInputDialog(
    //             null,
    //             "Rate Order ID: " + orderID,
    //             "Order Rating",
    //             JOptionPane.QUESTION_MESSAGE,
    //             null,
    //             ratings,
    //             ratings[4] // Default rating is 5
    //     );
    
    //     if (ratingStr != null) {
    //         int rating = Integer.parseInt(ratingStr); // Convert String to int
    
    //         JOptionPane.showMessageDialog(null, "You rated Order " + orderID + " with " + rating + " stars.");
            
    //         Payment payment = OrderHandling.getPaymentByID(orderID); 
    //         Customer customer = UserHandling.getCustomerByID(endUser.getID()); 
    
    //         OrderHandling.saveRating(payment, customer, rating); 
    //         // Store the rating in the database or update the order history
    //     }
    // }

    // private void showRatingDialog(String orderID) {
    //     String[] ratings = {"1", "2", "3", "4", "5"};

    //     // Step 1: Get the Food Rating
    //     String foodRatingStr = (String) JOptionPane.showInputDialog(
    //             null,
    //             "Rate the FOOD for Order ID: " + orderID,
    //             "Food Rating",
    //             JOptionPane.QUESTION_MESSAGE,
    //             null,
    //             ratings,
    //             ratings[4] // Default rating is 5
    //     );

    //     // Step 2: Get the Vendor Rating
    //     String vendorRatingStr = (String) JOptionPane.showInputDialog(
    //             null,
    //             "Rate the VENDOR service for Order ID: " + orderID,
    //             "Vendor Rating",
    //             JOptionPane.QUESTION_MESSAGE,
    //             null,
    //             ratings,
    //             ratings[4]
    //     );

    //     // Step 3: Get the Runner Rating
    //     String runnerRatingStr = (String) JOptionPane.showInputDialog(
    //             null,
    //             "Rate the DELIVERY RUNNER for Order ID: " + orderID,
    //             "Runner Rating",
    //             JOptionPane.QUESTION_MESSAGE,
    //             null,
    //             ratings,
    //             ratings[4]
    //     );

    //     if (foodRatingStr != null && vendorRatingStr != null && runnerRatingStr != null) {
    //         int foodRating = Integer.parseInt(foodRatingStr);
    //         int vendorRating = Integer.parseInt(vendorRatingStr);
    //         int runnerRating = Integer.parseInt(runnerRatingStr);

    //         JOptionPane.showMessageDialog(null,
    //                 "Your Ratings for Order " + orderID + ":\n"
    //                         + "Food: " + foodRating + " stars\n"
    //                         + "Vendor: " + vendorRating + " stars\n"
    //                         + "Runner: " + runnerRating + " stars");

    //         Payment payment = OrderHandling.getPaymentByID(orderID);
    //         Customer customer = UserHandling.getCustomerByID(endUser.getID());

    //         // Step 4: Save each rating separately

    //         OrderHandling.saveRating(payment, customer, foodRating, Rating.RatingType.FOOD);
    //         OrderHandling.saveRating(payment, customer, vendorRating, Rating.RatingType.VENDOR);
    //         OrderHandling.saveRating(payment, customer, runnerRating, Rating.RatingType.RUNNER);

    //     }
    // }

    private void showRatingDialog(String orderID) {
        String[] ratings = {"1", "2", "3", "4", "5"};
    
        Payment payment = OrderHandling.getPaymentByID(orderID);
        if (payment == null) {
            JOptionPane.showMessageDialog(null, "Order not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        String serviceType = payment.getServiceType();
    
        // Step 1: Get the Food Rating
        String foodRatingStr = (String) JOptionPane.showInputDialog(
                null,
                "Rate the FOOD for Order ID: " + orderID,
                "Food Rating",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ratings,
                ratings[4] // Default rating is 5
        );
    
        // Step 2: Get the Vendor Rating
        String vendorRatingStr = (String) JOptionPane.showInputDialog(
                null,
                "Rate the VENDOR service for Order ID: " + orderID,
                "Vendor Rating",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ratings,
                ratings[4]
        );
    
        // Step 3: Get the Runner Rating if serviceType is "Request for delivery"
        String runnerRatingStr = null;
        if ("Request for delivery".equals(serviceType)) {
            runnerRatingStr = (String) JOptionPane.showInputDialog(
                    null,
                    "Rate the DELIVERY RUNNER for Order ID: " + orderID,
                    "Runner Rating",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    ratings,
                    ratings[4]
            );
        }
    
        if (foodRatingStr != null && vendorRatingStr != null && (runnerRatingStr != null || !"Request for delivery".equals(serviceType))) {
            int foodRating = Integer.parseInt(foodRatingStr);
            int vendorRating = Integer.parseInt(vendorRatingStr);
            Integer runnerRating = runnerRatingStr != null ? Integer.parseInt(runnerRatingStr) : null;
    
            StringBuilder ratingMessage = new StringBuilder();
            ratingMessage.append("Your Ratings for Order ").append(orderID).append(":\n")
                    .append("Food: ").append(foodRating).append(" stars\n")
                    .append("Vendor: ").append(vendorRating).append(" stars\n");
    
            if (runnerRating != null) {
                ratingMessage.append("Runner: ").append(runnerRating).append(" stars\n");
            }
    
            JOptionPane.showMessageDialog(null, ratingMessage.toString());
    
            Customer customer = UserHandling.getCustomerByID(endUser.getID());
    
            // Step 4: Save each rating separately
            OrderHandling.saveRating(payment, customer, foodRating, Rating.RatingType.FOOD);
            OrderHandling.saveRating(payment, customer, vendorRating, Rating.RatingType.VENDOR);
            if (runnerRating != null) {
                OrderHandling.saveRating(payment, customer, runnerRating, Rating.RatingType.RUNNER);
            }
        }
    }

    
    



    

// TODO add at title_container1

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
        btn_wallet = new javax.swing.JButton();
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
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 350));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 350));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 350));
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

        btn_wallet.setBackground(new java.awt.Color(31, 31, 31));
        btn_wallet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_wallet.setForeground(new java.awt.Color(245, 251, 254));
        btn_wallet.setText("Wallet");
        btn_wallet.setBorder(null);
        btn_wallet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_wallet.setFocusable(false);
        btn_wallet.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_wallet.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_wallet.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_wallet.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_wallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_walletActionPerformed(evt);
            }
        });
        btn_container1.add(btn_wallet);

        btn_cart.setBackground(new java.awt.Color(31, 31, 31));
        btn_cart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_cart.setForeground(new java.awt.Color(245, 251, 254));
        btn_cart.setText("Cart");
        btn_cart.setBorder(null);
        btn_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cart.setFocusable(false);
        btn_cart.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_cart.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_cart.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_cart.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cartActionPerformed(evt);
            }
        });
        btn_container1.add(btn_cart);

        btn_history.setBackground(new java.awt.Color(43, 43, 43));
        btn_history.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_history.setForeground(new java.awt.Color(255, 169, 140));
        btn_history.setText("Order History");
        btn_history.setBorder(null);
        btn_history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_history.setFocusable(false);
        btn_history.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_history.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_history.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_history.setPreferredSize(new java.awt.Dimension(250, 40));
        
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
        margin3.setMaximumSize(new java.awt.Dimension(300, 60));
        margin3.setMinimumSize(new java.awt.Dimension(300, 60));
        margin3.setPreferredSize(new java.awt.Dimension(300, 60));

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
        welcome.setText("Order History");
        welcome.setAlignmentX(0.5F);
        welcome.setMaximumSize(new java.awt.Dimension(200, 50));
        welcome.setMinimumSize(new java.awt.Dimension(200, 50));
        welcome.setPreferredSize(new java.awt.Dimension(200, 50));
        title_container.add(welcome);

        

        Main.add(title_container);

        title_container1.setBackground(new java.awt.Color(31, 31, 31));
        title_container1.setMaximumSize(new java.awt.Dimension(1000, 400));
        title_container1.setMinimumSize(new java.awt.Dimension(1000, 400));
        title_container1.setPreferredSize(new java.awt.Dimension(1000, 400));
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
        // ArrayList<String> cartItems = OrderHandling.getCart();
        // // Remove the selected item from the list
        // cartItems.remove(item);
        // // Write the updated list back to the file
        // OrderHandling.saveCart(cartItems);
        // System.out.println("Discard item: " + item);
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

    private void btn_cartActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new Cart(endUser).setVisible(true);
    }     
    
    private void btn_walletActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
        new CusWallet(endUser).setVisible(true);
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
    private javax.swing.JButton btn_wallet;
    // End of variables declaration                   
}


