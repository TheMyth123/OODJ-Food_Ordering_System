package oodj.food_ordering_system.designUI;


import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.CusOrder;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.OrderHandling;


import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.json.JSONArray;
import org.json.JSONObject;


public class Cart extends javax.swing.JFrame {

    private Customer endUser;
    private JTable cartTable;
    private ArrayList<String> selectedMenuIDs = new ArrayList<>(); // Ensure it's always initialized



    public Cart(Customer endUser) {
        this.endUser = endUser;   
        
    
        
        initComponents();
        ArrayList<CusOrder> cart = OrderHandling.getCart(); // Fetch cart items
        displayCart(cart, endUser); // Display cart items
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

    
    
    
    private void displayCart(ArrayList<CusOrder> cart, Customer endUser) {
        // Ensure cartTable is initialized
        if (cartTable == null) {
            cartTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Menu ID", "Quantity", "Unit Price", "Name"}
            ));
        
            // Enable multiple row selection
            cartTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            cartTable.setRowSelectionAllowed(true);
            cartTable.setColumnSelectionAllowed(false);
        } else {
            cartTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }
    
        // Modify selection model to allow multiple selections without Ctrl and allow deselecting
        cartTable.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if (super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);  // Deselect if already selected
                } else {
                    super.addSelectionInterval(index0, index1);  // Select if not selected
                }
            }
        });
    
        // Get the table model
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
    
        // Clear existing rows
        model.setRowCount(0);
    
        for (CusOrder order : cart) {
            
        
            if (order.getCustomer().getID().equals(endUser.getID())) {
                model.addRow(new Object[]{
                    order.getMenuID(),
                    order.getQuantity(),
                    order.getPrice(),
                    order.getName(),
                });
            }
        }
    
        // **Search Field and Button**
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
    
        JButton searchButton = new JButton("Search");
    
        // **Set TableRowSorter (AFTER initializing cartTable)**
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        cartTable.setRowSorter(rowSorter);
    
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().trim();
                if (searchTerm.isEmpty()) {
                    rowSorter.setRowFilter(null); // Show all rows if search is empty
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // Case-insensitive search
                }
            }
        });

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTerm = searchField.getText().trim();
        
                if (searchTerm.isEmpty()) {
                    rowSorter.setRowFilter(null); //  Show all rows when search is cleared
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
    
        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setPreferredSize(new Dimension(500, 200));
    
        // **Pay Button**
        JButton payButton = new JButton("Pay");
        payButton.addActionListener(evt -> {
            int[] selectedRows = cartTable.getSelectedRows();
            
            if (selectedRows.length > 0) {
                double totalAmount = 0; // Initialize total amount
                DefaultTableModel tableModel = (DefaultTableModel) cartTable.getModel();
                
                JSONArray orderItems = new JSONArray();
                selectedMenuIDs.clear(); // Clear selectedMenuIDs before adding new ones

        
                for (int row : selectedRows) {
                    String menuID = tableModel.getValueAt(row, 0).toString();  // Get MenuID
                    int quantity = Integer.parseInt(tableModel.getValueAt(row, 1).toString());
                    double price = Double.parseDouble(tableModel.getValueAt(row, 2).toString());
        
                    double itemTotal = quantity * price;  // Calculate item total
                    totalAmount += itemTotal;  // Add to total amount
                    
                    JSONObject orderItem = new JSONObject();
                    orderItem.put("menuID", menuID);
                    orderItem.put("quantity", quantity);
                    orderItem.put("price", price);
                    orderItem.put("totalPrice", itemTotal);
        
                    orderItems.put(orderItem);
                    selectedMenuIDs.add(menuID); // Store MenuID for reference
                    
                }
        
                
        
                JOptionPane.showMessageDialog(null, "Total Amount: RM" + totalAmount);
        
                try {
                    checkout(orderItems, totalAmount);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        
            } else {
                JOptionPane.showMessageDialog(null, "Please select items to pay for.");
            }
        });
        
    
        // **Discard Button**
        JButton discardButton = new JButton("Discard");
        discardButton.addActionListener(evt -> {
            int[] selectedRows = cartTable.getSelectedRows();
            if (selectedRows.length > 0) {
                DefaultTableModel tableModel = (DefaultTableModel) cartTable.getModel();
                selectedMenuIDs.clear();


                for (int row : selectedRows) {
                    String menuID = tableModel.getValueAt(row, 0).toString();
                    selectedMenuIDs.add(menuID);
                }

                boolean confirm = DialogBox.confirmMessage("Are you sure you want to discard item?", "Discard");

                if (confirm) {

                    ArrayList<CusOrder> cartItems = OrderHandling.getCart();

                    OrderHandling.updateCart(cartItems, endUser.getID(), selectedMenuIDs);


                    SwingUtilities.invokeLater(() -> displayCart(OrderHandling.getCart(), endUser));
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Please select items to discard.");
            }
        });





        
        JButton editButton = new JButton("Edit Quantity");
        editButton.addActionListener(evt -> editQuantity());


    
        // **Button Panel**
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(payButton);
        buttonPanel.add(discardButton);
        buttonPanel.add(editButton);
    
        // **Fix: Remove Everything and Re-add Properly**
        title_container1.removeAll();  // Clear previous content
        title_container1.setLayout(new BorderLayout());  // Set layout manager
        title_container1.add(searchPanel, BorderLayout.NORTH); // **Make sure search panel is re-added**
        title_container1.add(scrollPane, BorderLayout.CENTER); // Add table
        title_container1.add(buttonPanel, BorderLayout.SOUTH); // Add buttons
    
        title_container1.revalidate(); // **Refresh UI**
        title_container1.repaint();   // **Update UI**
    }
    

    
    private void editQuantity() {
    
        int selectedRow = cartTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        String menuID = model.getValueAt(selectedRow, 0).toString();
        int currentQuantity = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
    
        String newQuantityStr = JOptionPane.showInputDialog(this, 
            "Enter new quantity for " + menuID + ":", currentQuantity);
    
        if (newQuantityStr != null) {
            try {
                int newQuantity = Integer.parseInt(newQuantityStr);
    
                if (newQuantity < 1) {
                    JOptionPane.showMessageDialog(this, "Quantity must be at least 1.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                ArrayList<CusOrder> cartItems = OrderHandling.getCart();
                boolean updated = false;
    
                for (CusOrder item : cartItems) {
                    if (item.getMenuID().equals(menuID) && 
                        item.getCustomer().getID().equals(endUser.getID())) {
                        
                        item.setQuantity(newQuantity);
                        updated = true;
                        break;
                    }
                }
    
                if (updated) {
    
                    OrderHandling.saveCart(cartItems);
    
    
                    refreshCart();
                } else {
                }
    
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    

    
    public void refreshCart() {
        title_container1.removeAll();  // Clear the cart UI components
        ArrayList<CusOrder> cart = OrderHandling.getCart();
        displayCart(cart, endUser);            // Reload the cart items
        title_container1.revalidate();  // Refresh layout
        title_container1.repaint();     // Repaint UI
    }
    

    private void checkout(JSONArray orderItems, double totalAmount) throws IOException {
        if (orderItems.length() == 0) {
            JOptionPane.showMessageDialog(this, "No items selected!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        // Prompt user for service type
        String[] options = {"Dine In", "Take-Away", "Request for Delivery"};
        int choice = JOptionPane.showOptionDialog(
            this,
            "Please select an order type:",
            "Order Type",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );
    
        if (choice == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this, "No order type selected.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    
        String serviceType = options[choice];
    
        // Create payment summary
        JSONObject paymentSummary = new JSONObject();
        paymentSummary.put("CustomerID", endUser.getID());
        paymentSummary.put("ServiceType", serviceType);
        paymentSummary.put("TotalAmount", totalAmount);
        paymentSummary.put("PaymentStatus", "Pending");
        paymentSummary.put("OrderItems", orderItems);
    
        // Fetch customer credit
        Credit customerCredit = null;
        for (Credit credit : OrderHandling.getCredits()) {
            if (credit.getCustomerID().equals(endUser.getID())) {
                customerCredit = credit;
                break;
            }
        }
    
        if (customerCredit != null) {

            if (selectedMenuIDs == null) {
                selectedMenuIDs = new ArrayList<>(); 
            }
    
    
            // ** Fix: Pass `itemsToRemove` correctly**
            ArrayList<CusOrder> cartItems = OrderHandling.getCart();      

    
            // Open payment window
            CusPayment paymentWindow = new CusPayment(
                "OR" + String.format("%05d", OrderHandling.getORid() + 1), // Auto-generate Order ID
                orderItems, endUser,
                totalAmount,
                "Pending",
                serviceType
            );
    

            paymentWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    String paymentStatus = paymentWindow.getPaymentStatus(); // Store status
            
                    // 🛠 Ensure only "Completed" payments clear the cart
                    if ("Completed".equals(paymentStatus) && endUser.getBalance() >= totalAmount) { 
                        cartItems.removeIf(order -> 
                            order.getCustomer().getID().equals(endUser.getID()) && 
                            selectedMenuIDs.contains(order.getMenuID())
                        );
            
                        OrderHandling.updateCart(cartItems, endUser.getID(), selectedMenuIDs); 
                        
                        // Refresh UI after payment
                        SwingUtilities.invokeLater(() -> refreshCart());
                    } else {
                        DialogBox.errorMessage("Payment not completed or insufficient balance. No items removed from cart.", "Error");
                    }
                }
            });
            
            
    
            paymentWindow.setVisible(true);
    
        } else {
            JOptionPane.showMessageDialog(this, "Credit information not found for customer ID: " + endUser.getID(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
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
        btn_wallet = new javax.swing.JButton();
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
        title_container1 = new javax.swing.JPanel();
        m8 = new javax.swing.JPanel();
        m6 = new javax.swing.JPanel();
        margin5 = new javax.swing.JPanel();
        m7 = new javax.swing.JPanel();
        btn_complaint = new javax.swing.JButton();

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
        systemName.setText("Food Connect");
        //TODO CHANGE SYSTEM NAME
        systemName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        systemName.setAlignmentX(0.5F);
        systemName.setMaximumSize(new java.awt.Dimension(300, 50));
        systemName.setMinimumSize(new java.awt.Dimension(300, 50));
        systemName.setPreferredSize(new java.awt.Dimension(300, 50));
        Logo_container.add(systemName);

        Sidebar.add(Logo_container);

        margin2.setBackground(new java.awt.Color(31, 31, 31));
        margin2.setMaximumSize(new java.awt.Dimension(300, 10));
        margin2.setMinimumSize(new java.awt.Dimension(300, 10));
        margin2.setPreferredSize(new java.awt.Dimension(300, 10));

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
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 420));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 420));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 420));
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

        btn_complaint.setBackground(new java.awt.Color(31, 31, 31));
        btn_complaint.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_complaint.setForeground(new java.awt.Color(245, 251, 254));
        btn_complaint.setText("Complaint");
        btn_complaint.setBorder(null);
        btn_complaint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_complaint.setDoubleBuffered(true);
        btn_complaint.setFocusable(false);
        btn_complaint.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_complaint.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_complaint.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_complaint.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_complaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_complaintActionPerformed(evt);
            }
        });
        btn_container1.add(btn_complaint);

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
        margin3.setMaximumSize(new java.awt.Dimension(300, 40));
        margin3.setMinimumSize(new java.awt.Dimension(300, 40));
        margin3.setPreferredSize(new java.awt.Dimension(300, 40));

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


        JLabel welcome = new JLabel();
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
    }                                                                          

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
        new CustomerProfile(endUser).setVisible(true);
    }      
    
    private void btn_walletActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
        new CusWallet(endUser).setVisible(true);
    }

    private void btn_complaintActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new CustomerComplaint(endUser).setVisible(true);
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
    private javax.swing.JButton btn_complaint;
    private javax.swing.JButton btn_wallet;
    // End of variables declaration  

}

