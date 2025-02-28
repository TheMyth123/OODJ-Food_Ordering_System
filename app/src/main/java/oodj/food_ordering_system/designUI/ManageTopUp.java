package oodj.food_ordering_system.designUI;

import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.models.Credit;
import raven.glasspanepopup.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONObject;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

public class ManageTopUp extends javax.swing.JFrame {


    public ManageTopUp() {
        initComponents();
        GlassPanePopup.install(this);
        loadrequests();
    }

    private void loadrequests() {
        String jsonText = getAllTopUpRequests();
        List<Credit> pendingRequests = getPendingTopUpRequests(jsonText);
        
        for (Credit credit : pendingRequests) {
            contentPanel.add(new TopUpRequests(
                credit.getCreditID(),
                credit.getCustomerID(),
                String.valueOf(credit.getAmount()),
                credit.getDate().toString(),
                credit.getReceiptImagePath()
            ));
        }
    }
    

    public static String getAllTopUpRequests() {
        try {
            String path = "app\\src\\main\\resources\\databases\\topup.txt";
            File file = new File(path);

            if (file.exists()) {
                // Read all lines from the file into a single string
                return new String(Files.readAllBytes(Paths.get(path)));
            } else {
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static List<Credit> getPendingTopUpRequests(String jsonText){
        List<Credit> credits = new ArrayList<>();
        
        JSONArray creditsArray = new JSONArray(jsonText);

        for (int i = 0; i < creditsArray.length(); i++) {
            JSONObject creditObject = creditsArray.getJSONObject(i);

            String status = creditObject.getString("Status");

            if ("Pending".equals(status)) {
                String creditID = creditObject.getString("CreditID");
                String customerID = creditObject.getString("CustomerID");
                double amount = creditObject.getDouble("CreditAmount");
                String lastUpdatedStr = creditObject.getString("LastUpdated");
                LocalDate lastUpdated = LocalDate.parse(lastUpdatedStr);
                String receiptImagePath = creditObject.getString("ReceiptImagePath");

                Credit credit = new Credit(creditID, customerID, amount, lastUpdated, status, receiptImagePath);
                credits.add(credit);
            }
        }
        return credits;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Line = new javax.swing.JPanel();
        Sidebar = new javax.swing.JPanel();
        margin1 = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        m2 = new javax.swing.JPanel();
        Logo_container = new javax.swing.JPanel();
        systemName = new javax.swing.JLabel();
        margin2 = new javax.swing.JPanel();
        margin3 = new javax.swing.JPanel();
        btn_container1 = new javax.swing.JPanel();
        btn_ManageCus = new javax.swing.JButton();
        btn_ManageVen = new javax.swing.JButton();
        btn_ManageRun = new javax.swing.JButton();
        btn_topup = new javax.swing.JButton();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Main = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Menu");
        setBackground(new java.awt.Color(25, 25, 25));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setSize(new java.awt.Dimension(1300, 700));
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
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 320));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_ManageCus.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageCus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageCus.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageCus.setText("Manage Customer");
        btn_ManageCus.setBorder(null);
        btn_ManageCus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageCus.setFocusable(false);
        btn_ManageCus.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageCus.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageCus.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageCus.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageCusActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageCus);

        btn_ManageVen.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageVen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageVen.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageVen.setText("Manage Vendor");
        btn_ManageVen.setBorder(null);
        btn_ManageVen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageVen.setFocusable(false);
        btn_ManageVen.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageVen.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageVen.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageVen.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageVenActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageVen);

        btn_ManageRun.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageRun.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageRun.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageRun.setText("Manage Runner");
        btn_ManageRun.setBorder(null);
        btn_ManageRun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageRun.setFocusable(false);
        btn_ManageRun.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageRun.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageRun.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageRun.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageRunActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageRun);

        btn_topup.setBackground(new java.awt.Color(43, 43, 43));
        btn_topup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_topup.setForeground(new java.awt.Color(255, 169, 140));
        btn_topup.setText("Manage Top-Up Requests");
        btn_topup.setBorder(null);
        btn_topup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_topup.setFocusable(false);
        btn_topup.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_topup.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_topup.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_topup.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_topup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_topupActionPerformed(evt);
            }
        });
        btn_container1.add(btn_topup);

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
        Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

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
        title.setText("Manage Top-Up Requests");
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
        m2.setMaximumSize(new java.awt.Dimension(1000, 50));
        m2.setMinimumSize(new java.awt.Dimension(1000, 50));
        m2.setPreferredSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout m2Layout = new javax.swing.GroupLayout(m2);
        m2.setLayout(m2Layout);
        m2Layout.setHorizontalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m2Layout.setVerticalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main.add(m2);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new java.awt.Color(31, 31, 31));
        
        Border roundedBorder = BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80), 3, true);
        contentPanel.setBorder(roundedBorder);

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new java.awt.Dimension(880, 480));
        scrollPane.getVerticalScrollBar().setUnitIncrement(10); // Adjust for smoothness


        Main.add(scrollPane);

        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>    

    List<Notification> notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications(), "Admin", true);
    
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

    private void btn_ManageCusActionPerformed(java.awt.event.ActionEvent evt) {  
        dispose();
        new ManageCustomer().setVisible(true);                                       
    }   
    
    private void btn_ManageVenActionPerformed(java.awt.event.ActionEvent evt) {     
        dispose();
        new ManageVendor().setVisible(true);
    }                                           

    private void btn_ManageRunActionPerformed(java.awt.event.ActionEvent evt) {  
        dispose();
        new ManageRunner().setVisible(true);
    }     

    private void btn_topupActionPerformed(java.awt.event.ActionEvent evt) {       
    }                                                                        

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            dispose();
            new LoginPage().setVisible(true);
        }
    }                                                                             

    // Variables declaration - do not modify                     
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton btn_ManageVen;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_ManageRun;
    private javax.swing.JButton btn_ManageCus;
    private javax.swing.JButton btn_topup;
    private javax.swing.JButton btn_logout;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin3;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JLabel systemName;
    private javax.swing.JPanel title_container;
    private javax.swing.JLabel title;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton btn_Noti;
    // End of variables declaration                   
}

