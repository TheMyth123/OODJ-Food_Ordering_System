package oodj.food_ordering_system.designUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.models.Rating;
import oodj.food_ordering_system.models.Rating.RatingType;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.OrderHandling;
import oodj.food_ordering_system.utils.UserHandling;
import raven.glasspanepopup.DefaultLayoutCallBack;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;



public class CusReview extends javax.swing.JFrame {

    private String vendorID; // Declare vendorID here

    public CusReview() {
        GlassPanePopup.install(this);
        initComponents();
    
        // Get the logged-in vendor's ID
        vendorID = UserHandling.getLoggedInVendorID(); 
    
        // Check if vendorID is properly obtained
        if (vendorID != null && !vendorID.isEmpty()) {
            displayRatings(vendorID); 
        } else {
            DialogBox.errorMessage("Error: Unable to retrieve Vendor ID. Please log in again.", "Error");
        }
    }
    
    private void displayRatings(String vendorID) {
        List<Rating> vendorRatings = OrderHandling.getVendorRatings(vendorID);
    
        // Filter to show only ratings of type VENDOR
        List<Rating> vendorTypeRatings = new ArrayList<>();
        for (Rating rating : vendorRatings) {
            if (rating.getRatingType() == RatingType.VENDOR) {
                vendorTypeRatings.add(rating);
            }
        }
    
        // Update column names (No Vendor ID)
        String[] columnNames = {"Order ID", "Customer ID", "Rating"};
    
        // Adjust data array for 3 columns
        String[][] data = new String[vendorTypeRatings.size()][3];
        for (int i = 0; i < vendorTypeRatings.size(); i++) {
            Rating rating = vendorTypeRatings.get(i);
            data[i][0] = rating.getOrderID();
            data[i][1] = rating.getCustomerID();
            data[i][2] = String.valueOf(rating.getRating());
        }
    
        ratingTable.setModel(new DefaultTableModel(data, columnNames));
    
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    
        // Adjust rendering for 3 columns
        ratingTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ratingTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        ratingTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    
        ratingTable.getTableHeader().setReorderingAllowed(false);
    }
    
    
    
    
    


    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        Sidebar = new javax.swing.JPanel();
        margin1 = new javax.swing.JPanel();
        Logo_container = new javax.swing.JPanel();
        systemName = new javax.swing.JLabel();
        margin2 = new javax.swing.JPanel();
        btn_container1 = new javax.swing.JPanel();
        btn_ManageOrder = new javax.swing.JButton();
        btn_ManageMenu = new javax.swing.JButton();
        btn_OrderHis = new javax.swing.JButton();
        btn_CusReview = new javax.swing.JButton();
        btn_Revenue = new javax.swing.JButton();
        margin3 = new javax.swing.JPanel();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Line = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        m2 = new javax.swing.JPanel();
        Line1 = new javax.swing.JPanel();
        m4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderInfo = new javax.swing.JTable();
        // searchBar = new javax.swing.JPanel();
        // margin5 = new javax.swing.JPanel();
        // nameLabel = new javax.swing.JLabel();
        // nameTextField = new javax.swing.JTextField();
        // margin6 = new javax.swing.JPanel();
        // modelLabel = new javax.swing.JLabel();
        // emailTextField = new javax.swing.JTextField();
        // margin7 = new javax.swing.JPanel();
        // searchButton = new javax.swing.JButton();
        // m3 = new javax.swing.JPanel();
        // m6 = new javax.swing.JPanel();
        // m7 = new javax.swing.JPanel();
        // btn_container = new javax.swing.JPanel();
        // addButton = new javax.swing.JButton();
        // m10 = new javax.swing.JPanel();
        // editButton = new javax.swing.JButton();
        // m11 = new javax.swing.JPanel();
        // deleteButton = new javax.swing.JButton();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendor Menu");
        setBackground(new java.awt.Color(25, 25, 25));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setResizable(false);
        getContentPane().setLayout(null);

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
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 360));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 360));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 360));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_ManageOrder.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageOrder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageOrder.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageOrder.setText("Manage Order");
        btn_ManageOrder.setBorder(null);
        btn_ManageOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageOrder.setFocusable(false);
        btn_ManageOrder.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageOrder.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageOrder.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageOrder.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageOrderActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageOrder);
        
        btn_ManageMenu.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageMenu.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageMenu.setText("Manage Menu");
        btn_ManageMenu.setBorder(null);
        btn_ManageMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageMenu.setFocusable(false);
        btn_ManageMenu.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageMenu.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageMenu.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageMenu.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageMenuActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageMenu);

        btn_OrderHis.setBackground(new java.awt.Color(31, 31, 31));
        btn_OrderHis.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_OrderHis.setForeground(new java.awt.Color(245, 251, 254));
        btn_OrderHis.setText("Order History");
        btn_OrderHis.setBorder(null);
        btn_OrderHis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_OrderHis.setFocusable(false);
        btn_OrderHis.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_OrderHis.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_OrderHis.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_OrderHis.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_OrderHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OrderHisActionPerformed(evt);
            }
        });
        btn_container1.add(btn_OrderHis);

        btn_CusReview.setBackground(new java.awt.Color(43, 43, 43));
        btn_CusReview.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_CusReview.setForeground(new java.awt.Color(255, 169, 140));
        btn_CusReview.setText("Customer Review");
        btn_CusReview.setBorder(null);
        btn_CusReview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CusReview.setFocusable(false);
        btn_CusReview.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_CusReview.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_CusReview.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_CusReview.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_CusReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CusReviewActionPerformed(evt);
            }
        });
        btn_container1.add(btn_CusReview);
        
        btn_Revenue.setBackground(new java.awt.Color(31, 31, 31));
        btn_Revenue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Revenue.setForeground(new java.awt.Color(245, 251, 254));
        btn_Revenue.setText("Revenue");
        btn_Revenue.setBorder(null);
        btn_Revenue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Revenue.setFocusable(false);
        btn_Revenue.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_Revenue.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_Revenue.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_Revenue.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_Revenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RevenueActionPerformed(evt);
            }
        });
        btn_container1.add(btn_Revenue);

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

        Line.setBackground(new java.awt.Color(50, 50, 50));
        Line.setMaximumSize(new java.awt.Dimension(300, 700));
        Line.setMinimumSize(new java.awt.Dimension(300, 700));

        javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
        Line.setLayout(LineLayout);
        LineLayout.setHorizontalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        LineLayout.setVerticalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(Line);
        Line.setBounds(300, 0, 2, 700);

        Main.setBackground(new java.awt.Color(31, 31, 31));
        Main.setAlignmentX(0.0F);
        Main.setAlignmentY(0.0F);
        Main.setMaximumSize(new java.awt.Dimension(1000, 670));
        Main.setMinimumSize(new java.awt.Dimension(1000, 670));
        Main.setPreferredSize(new java.awt.Dimension(1000, 670));
        Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        m1.setBackground(new java.awt.Color(31, 31, 31));
        m1.setMaximumSize(new java.awt.Dimension(1000, 30));
        m1.setMinimumSize(new java.awt.Dimension(1000, 30));

        javax.swing.GroupLayout m1Layout = new javax.swing.GroupLayout(m1);
        m1.setLayout(m1Layout);
        m1Layout.setHorizontalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m1Layout.setVerticalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main.add(m1);

        title_container.setBackground(new java.awt.Color(31, 31, 31));
        title_container.setMaximumSize(new java.awt.Dimension(1000, 100));
        title_container.setMinimumSize(new java.awt.Dimension(1000, 100));
        title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
        title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        title.setBackground(new java.awt.Color(31, 31, 31));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 169, 140));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Customer Review");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(130, 50));
        title.setMinimumSize(new java.awt.Dimension(130, 50));
        title.setPreferredSize(new java.awt.Dimension(800, 50));
        title_container.add(title);

        btn_Noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noti.png"))); // NOI18N
        btn_Noti.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_Noti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotiActionPerformed(evt);
            }
        });
        title_container.add(btn_Noti);

        Main.add(title_container);

        m2.setBackground(new java.awt.Color(31, 31, 31));
        m2.setMaximumSize(new java.awt.Dimension(1000, 5));
        m2.setMinimumSize(new java.awt.Dimension(1000, 5));
        m2.setPreferredSize(new java.awt.Dimension(1000, 7));

        Line1.setBackground(new java.awt.Color(50, 50, 50));
        Line1.setMaximumSize(new java.awt.Dimension(300, 2));
        Line1.setMinimumSize(new java.awt.Dimension(300, 2));
        Line1.setPreferredSize(new java.awt.Dimension(300, 2));

        javax.swing.GroupLayout Line1Layout = new javax.swing.GroupLayout(Line1);
        Line1.setLayout(Line1Layout);
        Line1Layout.setHorizontalGroup(
            Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Line1Layout.setVerticalGroup(
            Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout m2Layout = new javax.swing.GroupLayout(m2);
        m2.setLayout(m2Layout);
        m2Layout.setHorizontalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m2Layout.createSequentialGroup()
                    .addContainerGap(367, Short.MAX_VALUE)
                    .addComponent(Line1, 267, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(366, Short.MAX_VALUE)))
        );
        m2Layout.setVerticalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
            .addGroup(m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Main.add(m2);

        m4.setBackground(new java.awt.Color(31, 31, 31));
        m4.setMaximumSize(new java.awt.Dimension(1000, 13));
        m4.setMinimumSize(new java.awt.Dimension(1000, 13));
        m4.setPreferredSize(new java.awt.Dimension(1000, 13));

        javax.swing.GroupLayout m4Layout = new javax.swing.GroupLayout(m4);
        m4.setLayout(m4Layout);
        m4Layout.setHorizontalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m4Layout.setVerticalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        Main.add(m4);
    
        ratingPanel = new javax.swing.JPanel();
        ratingPanel.setBackground(new java.awt.Color(31, 31, 31));
        ratingPanel.setMaximumSize(new java.awt.Dimension(1000, 500));
        ratingPanel.setMinimumSize(new java.awt.Dimension(1000, 500));
        ratingPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        ratingPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        
        ratingScrollPane = new javax.swing.JScrollPane();
        ratingScrollPane.setMaximumSize(new java.awt.Dimension(880, 500));
        ratingScrollPane.setMinimumSize(new java.awt.Dimension(880, 500));
        ratingScrollPane.setPreferredSize(new java.awt.Dimension(880, 500));
        
        ratingTable = new javax.swing.JTable();
        ratingTable.setBackground(new java.awt.Color(43, 43, 43));
        ratingTable.setFont(new java.awt.Font("Segoe UI", 0, 16));
        ratingTable.setForeground(new java.awt.Color(245, 251, 254));
        ratingTable.setFocusable(false);
        ratingTable.setGridColor(new java.awt.Color(31, 31, 31));
        ratingTable.setMaximumSize(new java.awt.Dimension(880, 2000));
        ratingTable.setMinimumSize(new java.awt.Dimension(880, 2000));
        ratingTable.setPreferredSize(new java.awt.Dimension(880, 2000));
        ratingTable.setRowHeight(35);
        ratingTable.setSelectionBackground(new java.awt.Color(255, 169, 140));
        ratingTable.setSelectionForeground(new java.awt.Color(31, 31, 31));
        ratingTable.setShowGrid(true);
        ratingTable.setShowVerticalLines(false);
        
        ratingScrollPane.setViewportView(ratingTable);
        ratingPanel.add(ratingScrollPane);
        
        Main.add(ratingPanel);
        
        
















        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);

        pack();
        setLocationRelativeTo(null);

    }// </editor-fold>  

    List<Notification> notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications());
    
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

    private void btn_ManageOrderActionPerformed(java.awt.event.ActionEvent evt) {   
        dispose();
        new ManageOrder().setVisible(true);                                    
    } 

    private void btn_ManageMenuActionPerformed(java.awt.event.ActionEvent evt) {      
        dispose();
        new ManageMenu().setVisible(true);                                       
    } 

    private void btn_OrderHisActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new VendorOrderHistoryPage().setVisible(true);                                         
    } 
    
    private void btn_CusReviewActionPerformed(java.awt.event.ActionEvent evt) {                                      
    } 
    
    private void btn_RevenueActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new RevenueDashboardView().setVisible(true);                                         
    } 
    
    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            UserHandling.logout();
            dispose();
            new LoginPage().setVisible(true);
        }                                   
    } 

        // Variables declaration - do not modify                     
        private javax.swing.JPanel Sidebar;
        private javax.swing.JPanel margin1;
        private javax.swing.JPanel Logo_container;
        private javax.swing.JLabel systemName;
        private javax.swing.JPanel btn_container1;
        private javax.swing.JButton btn_ManageOrder;
        private javax.swing.JButton btn_ManageMenu;
        private javax.swing.JButton btn_OrderHis;
        private javax.swing.JButton btn_CusReview;
        private javax.swing.JButton btn_Revenue;
        private javax.swing.JPanel btn_container2;
        private javax.swing.JButton btn_logout;
        private javax.swing.JPanel Line;
        private javax.swing.JPanel Main;
        private javax.swing.JPanel m1;
        private javax.swing.JPanel title_container;
        private javax.swing.JPanel margin2;
        private javax.swing.JPanel margin3;
        private javax.swing.JLabel title;
        private javax.swing.JPanel m2;
        private javax.swing.JPanel Line1;
        private javax.swing.JPanel m4;

        private javax.swing.JPanel ratingPanel;
        private javax.swing.JTable ratingTable;
        private javax.swing.JScrollPane ratingScrollPane;

        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable OrderInfo;
        private javax.swing.JPanel searchBar;
        private javax.swing.JButton addButton;
        private javax.swing.JLabel nameLabel;
        private javax.swing.JTextField nameTextField;
        // private javax.swing.JButton btn_ManageVen;
        private javax.swing.JPanel btn_container;
        // private javax.swing.JButton btn_topup;
        // private javax.swing.JButton btn_ManageRun;
        private javax.swing.JButton editButton;
        private javax.swing.JButton deleteButton;
        private javax.swing.JPanel m10;
        private javax.swing.JPanel m11;
        private javax.swing.JPanel m3;
        private javax.swing.JPanel m6;
        private javax.swing.JPanel m7;
        private javax.swing.JPanel margin5;
        // private javax.swing.JPanel margin6;
        private javax.swing.JPanel margin7;
        // private javax.swing.JLabel modelLabel;
        // private javax.swing.JTextField emailTextField;
        private javax.swing.JButton searchButton;
        private javax.swing.JButton btn_Noti;
        // End of variables declaration

}
