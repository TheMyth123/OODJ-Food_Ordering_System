package oodj.food_ordering_system.designUI;


import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.TransactionHandling;
// import oodj.food_ordering_system.utils.NotificationUtils;

import java.util.List;


import javax.swing.JButton;
import javax.swing.JLabel;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class CusWallet extends javax.swing.JFrame {


    private Customer endUser;
    private List<Notification> notifications;



    public CusWallet(Customer endUser) {
        this.endUser = endUser;

        initComponents();
        // GlassPanePopup.install(this);
        loadTransactionHistory();

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
        btn_wallet = new javax.swing.JButton();
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
        wallet = new javax.swing.JPanel();
        balanceLabel = new javax.swing.JLabel();
        transactionTable = new javax.swing.JTable();
        tableModel = new DefaultTableModel();
        refresh = new javax.swing.JPanel();
        
        btn_complaint = new javax.swing.JButton();
        topUpTable = new javax.swing.JTable();
        topUpModel = new DefaultTableModel();
        transactionModel = new DefaultTableModel();
       
      

        setTitle("Customer Wallet - Transaction Log");
        setSize(1300, 700);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // setTitle("Customer Cart");
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

        btn_wallet.setBackground(new java.awt.Color(43, 43, 43));
        btn_wallet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_wallet.setForeground(new java.awt.Color(255, 169, 140));
        btn_wallet.setText("Wallet");
        btn_wallet.setBorder(null);
        btn_wallet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_wallet.setFocusable(false);
        btn_wallet.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_wallet.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_wallet.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_wallet.setPreferredSize(new java.awt.Dimension(250, 40));
   
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

        // TODO title container add credit

        welcome.setBackground(new java.awt.Color(31, 31, 31));
        welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 169, 140));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Wallet");
        welcome.setAlignmentX(0.5F);
        welcome.setMaximumSize(new java.awt.Dimension(200, 50));
        welcome.setMinimumSize(new java.awt.Dimension(200, 50));
        welcome.setPreferredSize(new java.awt.Dimension(200, 50));
        title_container.add(welcome);

        

        Main.add(title_container);

        title_container1.setBackground(new java.awt.Color(31, 31, 31));
        title_container1.setMaximumSize(new java.awt.Dimension(1000, 670));
        title_container1.setMinimumSize(new java.awt.Dimension(1000, 670));
        title_container1.setPreferredSize(new java.awt.Dimension(1000, 670));

        refresh.setBackground(new java.awt.Color(31, 31, 31));
        refresh.setMaximumSize(new java.awt.Dimension(1000, 60));
        refresh.setMinimumSize(new java.awt.Dimension(1000, 60));
        refresh.setPreferredSize(new java.awt.Dimension(1000, 60));

        // Balance Label (Positioned on top of the table)
        balanceLabel = new JLabel("Balance: RM " + endUser.getBalance());
        balanceLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));
        balanceLabel.setForeground(new java.awt.Color(255, 169, 140)); // Make text visible
        JButton btnTopUp = new JButton("Top-Up");
        btnTopUp.setPreferredSize(new Dimension(100, 35));
        btnTopUp.addActionListener(e -> btn_plusActionPerformed(e));
        
            
        refresh.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 125, 0));
        refresh.add(balanceLabel); // Add to wallet panel
        refresh.add(btnTopUp);
        

        wallet.setBackground(new java.awt.Color(31, 31, 31));
        wallet.setMaximumSize(new java.awt.Dimension(1000, 670));
        wallet.setMinimumSize(new java.awt.Dimension(1000, 670));
        wallet.setPreferredSize(new java.awt.Dimension(1000, 670));
        

        // **Tables Initialization**
        String[] topUpColumns = {"Date", "Amount (RM)", "Status", "Transaction ID"};
        topUpModel = new DefaultTableModel(topUpColumns, 0);
        topUpTable = new JTable(topUpModel);
        topUpTable.setPreferredScrollableViewportSize(new Dimension(900, 100));

        String[] transactionColumns = {"Date", "Type", "Amount (RM)", "Status", "Order ID"};
        transactionModel = new DefaultTableModel(transactionColumns, 0);
        transactionTable = new JTable(transactionModel);
        transactionTable.setPreferredScrollableViewportSize(new Dimension(900, 100));

        // **Add ScrollPane**
        JScrollPane topUpScrollPane = new JScrollPane(topUpTable);
        JScrollPane transactionScrollPane = new JScrollPane(transactionTable);

        

        JButton btnDownload = new JButton("Download PDF");
        btnDownload.setPreferredSize(new Dimension(150, 35));
        btnDownload.setEnabled(false); // Initially disabled

        // Add button to a panel below the Top-Up table
        JPanel downloadPanel = new JPanel();
        downloadPanel.setBackground(new Color(31, 31, 31));
        downloadPanel.add(btnDownload);
        
        topUpTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = topUpTable.getSelectedRow();
                if (selectedRow != -1) {
                    String status = (String) topUpModel.getValueAt(selectedRow, 2); // Status column
                    btnDownload.setEnabled("Accepted".equalsIgnoreCase(status)); // Enable only for "Accepted" top-ups
                } else {
                    btnDownload.setEnabled(false);
                }
            }
        });

        // **Action Listener for Download Button**
        btnDownload.addActionListener(e -> {
            int selectedRow = topUpTable.getSelectedRow();
            if (selectedRow != -1) {
                String crId = (String) topUpModel.getValueAt(selectedRow, 3); // CR ID column
                downloadFile(crId);
            }
        });


        TableRowSorter<DefaultTableModel> topUpSorter = new TableRowSorter<>(topUpModel);
        TableRowSorter<DefaultTableModel> transactionSorter = new TableRowSorter<>(transactionModel);
        topUpTable.setRowSorter(topUpSorter);
        transactionTable.setRowSorter(transactionSorter);

        // **Panel for Top-ups**
        JPanel topUpPanel = new JPanel(new BorderLayout());
        topUpPanel.setBackground(new Color(31, 31, 31));

        // **Top-Up Label Panel**
        JPanel topUpLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topUpLabelPanel.setBackground(new Color(31, 31, 31));
        JLabel topUpLabel = new JLabel("Top-Up History");
        topUpLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        topUpLabel.setForeground(new Color(255, 169, 140));
        topUpLabelPanel.add(topUpLabel);

        JPanel topUpSearchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topUpSearchPanel.setBackground(new Color(31, 31, 31));
        JTextField topUpSearchField = new JTextField();
        topUpSearchField.setPreferredSize(new Dimension(200, 35));
        JButton topUpSearchButton = new JButton("Search");
        topUpSearchPanel.add(topUpSearchField);
        topUpSearchPanel.add(topUpSearchButton);

        // Add label and search to top
        JPanel topUpHeaderPanel = new JPanel(new BorderLayout());
        topUpHeaderPanel.setBackground(new Color(31, 31, 31));
        topUpHeaderPanel.add(topUpLabelPanel, BorderLayout.NORTH);
        topUpHeaderPanel.add(topUpSearchPanel, BorderLayout.SOUTH);

        topUpPanel.add(topUpHeaderPanel, BorderLayout.NORTH);
        topUpPanel.add(topUpScrollPane, BorderLayout.CENTER);
        topUpPanel.add(downloadPanel, BorderLayout.SOUTH);

        // **Panel for Transactions**
        JPanel transactionPanel = new JPanel(new BorderLayout());
        transactionPanel.setBackground(new Color(31, 31, 31));

        // **Transaction Label Panel**
        JPanel transactionLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        transactionLabelPanel.setBackground(new Color(31, 31, 31));
        JLabel transactionLabel = new JLabel("Transaction History");
        transactionLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        transactionLabel.setForeground(new Color(255, 169, 140));
        transactionLabelPanel.add(transactionLabel);

        JPanel transactionSearchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        transactionSearchPanel.setBackground(new Color(31, 31, 31));
        JTextField transactionSearchField = new JTextField();
        transactionSearchField.setPreferredSize(new Dimension(200, 35));
        JButton transactionSearchButton = new JButton("Search");
        transactionSearchPanel.add(transactionSearchField);
        transactionSearchPanel.add(transactionSearchButton);

        // Add label and search to top
        JPanel transactionHeaderPanel = new JPanel(new BorderLayout());
        transactionHeaderPanel.setBackground(new Color(31, 31, 31));
        transactionHeaderPanel.add(transactionLabelPanel, BorderLayout.NORTH);
        transactionHeaderPanel.add(transactionSearchPanel, BorderLayout.SOUTH);

        transactionPanel.add(transactionHeaderPanel, BorderLayout.NORTH);
        transactionPanel.add(transactionScrollPane, BorderLayout.CENTER);

        // **Add Panels to Main Wallet Panel**
        wallet.add(topUpPanel, BorderLayout.WEST);
        wallet.add(transactionPanel, BorderLayout.EAST);
        



        // **Search Functionality for Top-Up Table**
        topUpSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = topUpSearchField.getText().trim();
                if (searchTerm.isEmpty()) {
                    topUpSorter.setRowFilter(null); // Show all rows if search is empty
                } else {
                    topUpSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // Case-insensitive search
                }
            }
        });

        topUpSearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTerm = topUpSearchField.getText().trim();
                if (searchTerm.isEmpty()) {
                    topUpSorter.setRowFilter(null); // Show all rows if search is empty
                } else {
                    topUpSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // Case-insensitive search
                }
            }
        });

        // **Search Functionality for Transaction Table**
        transactionSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = transactionSearchField.getText().trim();
                if (searchTerm.isEmpty()) {
                    transactionSorter.setRowFilter(null); // Show all rows if search is empty
                } else {
                    transactionSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // Case-insensitive search
                }
            }
        });

        transactionSearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTerm = transactionSearchField.getText().trim();
                if (searchTerm.isEmpty()) {
                    transactionSorter.setRowFilter(null); // Show all rows if search is empty
                } else {
                    transactionSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm)); // Case-insensitive search
                }
            }
        });


        

        
        title_container1.add(refresh);
    
        

        title_container1.add(wallet);

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

    
    private List<Notification> getNotifications() {
        if (notifications == null) {
            notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications(), endUser.getID(), false);
        }
        return notifications;
    }
  


    private void btn_plusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Disable the current CusDash window
        this.setEnabled(false);
    
        // Create and show the TopUp window
        TopUp topup = new TopUp(endUser);
    
        // Add a window listener to re-enable CusDash when TopUp is closed
        topup.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                CusWallet.this.setEnabled(true);
                CusWallet.this.toFront();
            }
        });
    
        topup.setVisible(true);
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

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new CusDash().setVisible(true);
    }

    private void btn_historyActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new OrderHistory(endUser).setVisible(true);
        //TODO CALL PAGE 2
    } 

    private void btn_complaintActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new CustomerComplaint(endUser).setVisible(true);
    }
                                                                                                                      

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
        new CustomerProfile(endUser).setVisible(true);
    }   
    

    private void loadTransactionHistory() {
        topUpModel.setRowCount(0); // Clear existing data
        transactionModel.setRowCount(0);
        balanceLabel.setText("Balance: RM " + endUser.getBalance());
    
        List<Object[]> transactions = TransactionHandling.getTransactionLog(endUser.getID());
    
        for (Object[] transaction : transactions) {
            String type = (String) transaction[1];
            if ("Top-Up".equalsIgnoreCase(type)) {
                topUpModel.addRow(new Object[]{transaction[0], transaction[2], transaction[3], transaction[4]});
            } else {
                transactionModel.addRow(new Object[]{transaction[0], transaction[1], transaction[2], transaction[3], transaction[5]});
            }
        }
    }



    private void downloadFile(String crId) {
        String resourcePath = "topupPDF/" + crId + ".pdf"; 
        String outputPath = System.getProperty("user.home") + "/Downloads/" + crId + ".pdf";
    
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                System.out.println("PDF not found in resources: " + resourcePath);
                return;
            }
    
            Files.copy(inputStream, Paths.get(outputPath), StandardCopyOption.REPLACE_EXISTING);
            DialogBox.successMessage("PDF downloaded successfully", "Download Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private javax.swing.JPanel wallet;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTable transactionTable;
    private DefaultTableModel tableModel;
    private javax.swing.JPanel refresh;
    
    private JButton btn_complaint;
    private JTable topUpTable;
    private DefaultTableModel topUpModel;
    private DefaultTableModel transactionModel;
  
    
    // End of variables declaration                   
}
