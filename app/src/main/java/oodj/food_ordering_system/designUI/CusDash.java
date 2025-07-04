package oodj.food_ordering_system.designUI;

import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.models.Vendor;
// import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.UserHandling;
// import oodj.food_ordering_system.utils.NotificationUtils;
import raven.glasspanepopup.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

// import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

//  dine in, take-away or request for delivery service from the vendor.

public class CusDash extends javax.swing.JFrame {


    private Customer endUser;
    private List<Notification> notifications;
    private JTextField searchField;
    private JButton searchButton;
    private ArrayList<Vendor> vendors;



    public CusDash() {

        this.endUser = LoginPage.getEndUser();      
        vendors = UserHandling.getVendors(); 
        if (vendors == null) {
            vendors = new ArrayList<>(); 
        }  

        initComponents();
        GlassPanePopup.install(this);
        loadName();
        addRestaurantPanel();

    }

    private void loadName() {
        customer_username.setText(endUser.getUsername());
    }

    private void searchFCourt() {
        String name = searchField.getText().trim().toLowerCase(); // Convert to lowercase for case-insensitive search
        List<Vendor> filteredVendors = new ArrayList<>();
    
        for (Vendor vendor : vendors) {
            if (name.isEmpty() || vendor.getFoodCourtName().toLowerCase().contains(name)) { // Partial search
                filteredVendors.add(vendor);
            }
        }
    
        if (filteredVendors.isEmpty()) {
            DialogBox.errorMessage("No matches found.", "Error");
            CusFCourt.displayVendors(vendors); // Reset to all vendors if no match
        } else {
            CusFCourt.displayVendors(filteredVendors);
        }
    }
    

    private void addRestaurantPanel() {
        searchField = new JTextField();
        searchField.setPreferredSize(new java.awt.Dimension(200, 30));

        searchButton = new JButton("Search");
        searchButton.addActionListener(evt -> searchFCourt());

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
    
        title_container1.add(searchPanel, BorderLayout.NORTH);


        CusFCourt cusRestaurant = new CusFCourt();
        JPanel mainPanel = cusRestaurant.getMainPanel();
        title_container1.add(mainPanel);

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
        btn_wallet = new javax.swing.JButton();
        btn_complaint = new javax.swing.JButton();

        btn_history = new javax.swing.JButton();
        btn_cart = new javax.swing.JButton();
        btn_profile = new javax.swing.JButton();
        margin3 = new javax.swing.JPanel();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Main = new javax.swing.JPanel();
        margin4 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        m5 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        customer_username = new javax.swing.JLabel();
        title_container1 = new javax.swing.JPanel();
        m8 = new javax.swing.JPanel();
        m6 = new javax.swing.JPanel();
        margin5 = new javax.swing.JPanel();
        m7 = new javax.swing.JPanel();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        // TODO double confirm resize
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Dashboard");
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

        btn_home.setBackground(new java.awt.Color(43, 43, 43));
        btn_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 169, 140));
        btn_home.setText("Home");
        btn_home.setBorder(null);
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.setFocusable(false);
        btn_home.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_home.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_home.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
        
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

        welcome.setBackground(new java.awt.Color(31, 31, 31));
        welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 169, 140));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Hi,");
        welcome.setAlignmentX(0.5F);
        welcome.setMaximumSize(new java.awt.Dimension(50, 50));
        welcome.setMinimumSize(new java.awt.Dimension(50, 50));
        welcome.setPreferredSize(new java.awt.Dimension(50, 50));
        title_container.add(welcome);

        customer_username.setBackground(new java.awt.Color(31, 31, 31));
        customer_username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        customer_username.setForeground(new java.awt.Color(255, 169, 140));
        customer_username.setText("< customer_username >, ");
        customer_username.setMaximumSize(new java.awt.Dimension(480, 50));
        customer_username.setMinimumSize(new java.awt.Dimension(480, 50));
        customer_username.setPreferredSize(new java.awt.Dimension(480, 50));
        title_container.add(customer_username);

        amount = new javax.swing.JLabel();
        amount.setBackground(new java.awt.Color(31, 31, 31));
        amount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 169, 140));
        amount.setText("Balance: RM " + endUser.getBalance());
        amount.setMaximumSize(new java.awt.Dimension(220, 50));
        amount.setMinimumSize(new java.awt.Dimension(220, 50));
        amount.setPreferredSize(new java.awt.Dimension(220, 50));
        title_container.add(amount);


        btn_Noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noti.png"))); // NOI18N
        btn_Noti.setPreferredSize(new java.awt.Dimension(50, 50));
        // TODO check again

        btn_Noti.setFocusPainted(false);


        btn_Noti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btn_NotiActionPerformed(evt);
            }
        });



        title_container.add(btn_Noti);

        Main.add(title_container);

        title_container1.setBackground(new java.awt.Color(31, 31, 31));
        title_container1.setMaximumSize(new java.awt.Dimension(1000, 700));
        title_container1.setMinimumSize(new java.awt.Dimension(1000, 700));
        title_container1.setPreferredSize(new java.awt.Dimension(1000, 700));
        title_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

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

        // add the restaurant here

        

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

    
    
    private List<Notification> getNotifications() {
        if (notifications == null) {
            notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications(), endUser.getID(), false);
        }
        return notifications;
    }



    private void btn_NotiActionPerformed(java.awt.event.ActionEvent evt) {                                  
        GlassPanePopup.showPopup(new NotificationPanel(getNotifications()), new DefaultOption(){
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


    

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            dispose();
            new LoginPage().setVisible(true);
        }
    }                                          

    
    private void btn_cartActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new Cart(endUser).setVisible(true);
    } 

    private void btn_historyActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new OrderHistory(endUser).setVisible(true);
        //TODO CALL PAGE 2
    } 
                                              
                                              
    private void btn_walletActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
        new CusWallet(endUser).setVisible(true);
    }

    private void btn_complaintActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new CustomerComplaint(endUser).setVisible(true);
    }

                                                                             

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
        new CustomerProfile(endUser).setVisible(true);
    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton btn_history;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_cart;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_wallet;
    private javax.swing.JButton btn_profile;
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel customer_username;
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
    private javax.swing.JLabel amount;
    private javax.swing.JButton btn_complaint;
    // End of variables declaration                   
}