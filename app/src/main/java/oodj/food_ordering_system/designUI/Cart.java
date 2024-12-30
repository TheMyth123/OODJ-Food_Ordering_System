package oodj.food_ordering_system.designUI;


import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.models.Vendor;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.OrderHandling;
import oodj.food_ordering_system.utils.UserHandling;
import raven.glasspanepopup.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;


// TODO design have done yet
public class Cart extends javax.swing.JFrame {
    private JPanel cartListPanel;
    private JTextArea cartTextArea;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Cart().setVisible(true);
        });
    }

    public Cart() {
        initComponents();
        displayCartItems();
        // GlassPanePopup.install(this);
        // loadName();
    }

    // private void loadName() {
    //     // Admin endUserAd = LoginPage.getEndUserAd();
    //     // admin_username.setText(endUserAd.getUsername());
    //     // TODO LOAD ADMIN USERNAME
    //     admin_username.setText("Admin");
    // }

    private void displayCartItems() {
        List<String> cartItems = OrderHandling.getCart();
        title_container1.removeAll();

        title_container1.setLayout(new BoxLayout(title_container1, BoxLayout.Y_AXIS));
        title_container1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        for (String item : cartItems) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));
            itemPanel.setPreferredSize(new Dimension(630, 40));
            itemPanel.setMaximumSize(new Dimension(630, 40));
            itemPanel.setMinimumSize(new Dimension(630, 40));
            itemPanel.setBackground(new Color(31, 31, 31));
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
            // Extract quantity from item string (assuming item string contains quantity information)
            String[] itemParts = item.split(", ");
            String quantity = itemParts[0].split(": ")[1];
    
            JTextField quantityField = new JTextField(quantity);
            quantityField.setPreferredSize(new Dimension(50, 30));
            quantityField.setMaximumSize(new Dimension(50, 30));
            quantityField.setMinimumSize(new Dimension(50, 30));
            quantityField.setForeground(new Color(255, 169, 140)); // Set text color
            quantityField.setBackground(new Color(31, 31, 31));
            quantityField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            quantityField.setOpaque(true);
            quantityField.setEditable(false); // Initially not editable
            itemPanel.add(quantityField);
    
            JLabel itemLabel = new JLabel(item.replaceFirst("quantity: \\d+, ", ""));
            itemLabel.setPreferredSize(new Dimension(570, 30)); // Adjust size to fit remaining text
            itemLabel.setMaximumSize(new Dimension(570, 30));
            itemLabel.setMinimumSize(new Dimension(570, 30));
            itemLabel.setForeground(new Color(255, 169, 140)); // Set text color
            itemLabel.setBackground(new Color(31, 31, 31));
            itemLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            itemLabel.setOpaque(true);
            itemPanel.add(itemLabel);
    
            // Button panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setPreferredSize(new Dimension(350, 40));
            buttonPanel.setMaximumSize(new Dimension(350, 40));
            buttonPanel.setMinimumSize(new Dimension(350, 40));
            buttonPanel.setBackground(new Color(43, 43, 43));
    
            JButton editButton = new JButton("Edit");
            JButton payButton = new JButton("Pay");
            JButton discardButton = new JButton("Discard");
            JButton plusButton = new JButton("+");
            JButton minusButton = new JButton("-");
    
            // Set uniform button sizes
            Dimension buttonSize = new Dimension(80, 30);
            editButton.setPreferredSize(buttonSize);
            editButton.setMaximumSize(buttonSize);
            editButton.setMinimumSize(buttonSize);
    
            payButton.setPreferredSize(buttonSize);
            payButton.setMaximumSize(buttonSize);
            payButton.setMinimumSize(buttonSize);
    
            discardButton.setPreferredSize(buttonSize);
            discardButton.setMaximumSize(buttonSize);
            discardButton.setMinimumSize(buttonSize);
    
            plusButton.setPreferredSize(buttonSize);
            plusButton.setMaximumSize(buttonSize);
            plusButton.setMinimumSize(buttonSize);
            plusButton.setEnabled(false); // Initially disabled
    
            minusButton.setPreferredSize(buttonSize);
            minusButton.setMaximumSize(buttonSize);
            minusButton.setMinimumSize(buttonSize);
            minusButton.setEnabled(false); // Initially disabled
    
            editButton.addActionListener(evt -> {
                if (editButton.getText().equals("Edit")) {
                    quantityField.setEditable(true);
                    plusButton.setEnabled(true);
                    minusButton.setEnabled(true);
                    editButton.setText("Save");
                } else {
                    quantityField.setEditable(false);
                    plusButton.setEnabled(false);
                    minusButton.setEnabled(false);
                    editButton.setText("Edit");
                }
            });
    
            plusButton.addActionListener(evt -> {
                int currentQuantity = Integer.parseInt(quantityField.getText());
                quantityField.setText(String.valueOf(currentQuantity + 1));
            });
    
            minusButton.addActionListener(evt -> {
                int currentQuantity = Integer.parseInt(quantityField.getText());
                if (currentQuantity > 1) {
                    quantityField.setText(String.valueOf(currentQuantity - 1));
                }
            });
    
            // payButton.addActionListener(evt -> payForItem(item));
            discardButton.addActionListener(evt -> {
                discardItem(item);
                displayCartItems(); // Refresh the cart display
            });
    
            buttonPanel.add(editButton);
            buttonPanel.add(Box.createRigidArea(new Dimension(5, 0))); // Space between buttons
            buttonPanel.add(payButton);
            buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
            buttonPanel.add(discardButton);
            buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
            buttonPanel.add(plusButton);
            buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
            buttonPanel.add(minusButton);
    
            // Combined panel
            JPanel combinedPanel = new JPanel();
            combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.X_AXIS));
            combinedPanel.setPreferredSize(new Dimension(900, 40));
            combinedPanel.setMaximumSize(new Dimension(900, 40));
            combinedPanel.setMinimumSize(new Dimension(900, 40));
            combinedPanel.setBackground(new Color(31, 31, 31));
            combinedPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
            combinedPanel.add(itemPanel);
            combinedPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Space between itemPanel and buttonPanel
            combinedPanel.add(buttonPanel);
    
            title_container1.add(combinedPanel);
            title_container1.add(Box.createRigidArea(new Dimension(0, 5))); // Add space between items
        }

        // for (String item : cartItems) {

        //     JPanel itemPanel = new JPanel();
        //     itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));
        //     itemPanel.setPreferredSize(new Dimension(630, 40));
        //     itemPanel.setMaximumSize(new Dimension(630, 40));
        //     itemPanel.setMinimumSize(new Dimension(630, 40));
        //     itemPanel.setBackground(new Color(31, 31, 31));
        //     itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //     JLabel itemLabel = new JLabel(item);
        //     itemLabel.setPreferredSize(new Dimension(620, 30)); // Slightly smaller to account for padding
        //     itemLabel.setMaximumSize(new Dimension(620, 30));
        //     itemLabel.setMinimumSize(new Dimension(620, 30));
        //     itemLabel.setForeground(new Color(255, 169, 140)); // Set text color
        //     itemLabel.setBackground(new Color(31, 31, 31));
        //     itemLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //     itemLabel.setOpaque(true);
        //     itemPanel.add(itemLabel);

        //     // Button panel
        //     JPanel buttonPanel = new JPanel();
        //     buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        //     buttonPanel.setPreferredSize(new Dimension(250, 40));
        //     buttonPanel.setMaximumSize(new Dimension(250, 40));
        //     buttonPanel.setMinimumSize(new Dimension(250, 40));
        //     buttonPanel.setBackground(new Color(43, 43, 43));

        //     JButton editButton = new JButton("Edit");
        //     JButton payButton = new JButton("Pay");
        //     JButton discardButton = new JButton("Discard");

        //     // Set uniform button sizes
        //     Dimension buttonSize = new Dimension(80, 30);
        //     editButton.setPreferredSize(buttonSize);
        //     editButton.setMaximumSize(buttonSize);
        //     editButton.setMinimumSize(buttonSize);

        //     payButton.setPreferredSize(buttonSize);
        //     payButton.setMaximumSize(buttonSize);
        //     payButton.setMinimumSize(buttonSize);

        //     discardButton.setPreferredSize(buttonSize);
        //     discardButton.setMaximumSize(buttonSize);
        //     discardButton.setMinimumSize(buttonSize);

        //     buttonPanel.add(editButton);
        //     buttonPanel.add(Box.createRigidArea(new Dimension(5, 0))); // Space between buttons
        //     buttonPanel.add(payButton);
        //     buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        //     buttonPanel.add(discardButton);

        //     // Combined panel
        //     JPanel combinedPanel = new JPanel();
        //     combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.X_AXIS));
        //     combinedPanel.setPreferredSize(new Dimension(900, 40));
        //     combinedPanel.setMaximumSize(new Dimension(900, 40));
        //     combinedPanel.setMinimumSize(new Dimension(900, 40));
        //     combinedPanel.setBackground(new Color(31, 31, 31));
        //     combinedPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //     combinedPanel.add(itemPanel);
        //     combinedPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Space between itemPanel and buttonPanel
        //     combinedPanel.add(buttonPanel);

        //     title_container1.add(combinedPanel);
        //     title_container1.add(Box.createRigidArea(new Dimension(0, 5))); // Space between rows

        title_container1.revalidate();
        title_container1.repaint();
        

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
        btn_cart = new javax.swing.JButton();
        btn_history = new javax.swing.JButton();
        btn_Page4 = new javax.swing.JButton();
        margin3 = new javax.swing.JPanel();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Main = new javax.swing.JPanel();
        margin4 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        m5 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        admin_username = new javax.swing.JLabel();
        title_container1 = new javax.swing.JPanel();
        m8 = new javax.swing.JPanel();
        welcome3 = new javax.swing.JLabel();
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
        btn_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cartActionPerformed(evt);
            }
        });
        btn_container1.add(btn_cart);

        btn_history.setBackground(new java.awt.Color(31, 31, 31));
        btn_history.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_history.setForeground(new java.awt.Color(245, 251, 254));
        btn_history.setText("Page 3");
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

        btn_Page4.setBackground(new java.awt.Color(31, 31, 31));
        btn_Page4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Page4.setForeground(new java.awt.Color(245, 251, 254));
        btn_Page4.setText("Page 4");
        btn_Page4.setBorder(null);
        btn_Page4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Page4.setDoubleBuffered(true);
        btn_Page4.setFocusable(false);
        btn_Page4.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_Page4.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_Page4.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_Page4.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_Page4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Page4ActionPerformed(evt);
            }
        });
        btn_container1.add(btn_Page4);

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

        // welcome3.setBackground(new java.awt.Color(31, 31, 31));
        // welcome3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        // welcome3.setForeground(new java.awt.Color(245, 251, 254));
        // welcome3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // welcome3.setText("This is the default page");
        // welcome3.setAlignmentX(0.5F);
        // welcome3.setMaximumSize(new java.awt.Dimension(275, 50));
        // welcome3.setMinimumSize(new java.awt.Dimension(275, 50));
        // welcome3.setPreferredSize(new java.awt.Dimension(275, 50));
        // title_container1.add(welcome3);

        // TODO add cart content in title container 1

        // title_container1.add(cartTextArea);

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

    //TODO I USED ADMIN DATA TO GET NOTIFICATIONS. CHANGE TO OWN DATA
    List<Notification> notifications = NotificationUtils.getAdminUnreadNotifications(NotificationUtils.getAllNotifications());
    
    private void btn_NotiActionPerformed(java.awt.event.ActionEvent evt) {                                  
        GlassPanePopup.showPopup(new NotificationPanel(notifications), new DefaultOption(){
            @Override
            public float opacity() {
                return 0;
            }

            @Override
            public LayoutCallback getLayoutCallBack(java.awt.Component parent) {
                return new DefaultLayoutCallBack(parent){
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()){
                            java.awt.Point pl = parent.getLocationOnScreen();
                            java.awt.Point bl = btn_Noti.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            cw.setBounds(x - cw.getWidth() + btn_Noti.getWidth(), y + btn_Noti.getHeight(), cw.getWidth(), cw.getHeight());
                        } else {
                            super.correctBounds(cw);
                        }
                    }
                };
            }

        });
    }   


    private void discardItem(String item) {
        // Read the current cart items from the file
        List<String> cartItems = OrderHandling.getCart();
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

    private void btn_cartActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //dispose();
        //TODO CALL PAGE 2
        System.out.println("Page 2");
    }                                           

    private void btn_historyActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //dispose();
        //TODO CALL PAGE 3
        System.out.println("Page 3");
    }                                                                          

    private void btn_Page4ActionPerformed(java.awt.event.ActionEvent evt) {                                        
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
    private javax.swing.JButton btn_Page4;
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel admin_username;
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
    private javax.swing.JLabel welcome3;
    private javax.swing.JButton btn_Noti;
    // End of variables declaration                   
}


