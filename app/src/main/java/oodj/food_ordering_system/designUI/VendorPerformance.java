package oodj.food_ordering_system.designUI;

import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import raven.glasspanepopup.*;

import java.util.List;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

public class VendorPerformance extends javax.swing.JFrame {


    public VendorPerformance() {
        initComponents();
        GlassPanePopup.install(this);
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
        btn_VendorPerformance = new javax.swing.JButton();
        btn_RunnerPerformance = new javax.swing.JButton();
        btn_ManageComplaints = new javax.swing.JButton();
        btn_ModerateVItems = new javax.swing.JButton();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Main = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        // Instead of contentPanel and scrollPane, we add a JTabbedPane
        tabbedPane = new javax.swing.JTabbedPane();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Menu");
        setBackground(new java.awt.Color(25, 25, 25));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(null);

        // ---------- Sidebar ----------
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

        btn_VendorPerformance.setBackground(new java.awt.Color(43, 43, 43));
        btn_VendorPerformance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_VendorPerformance.setForeground(new java.awt.Color(225, 169, 140));
        btn_VendorPerformance.setText("Vendor Performance");
        btn_VendorPerformance.setBorder(null);
        btn_VendorPerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_VendorPerformance.setFocusable(false);
        btn_VendorPerformance.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_VendorPerformance.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_VendorPerformance.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_VendorPerformance.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_VendorPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VendorPerformanceActionPerformed(evt);
            }
        });
        btn_container1.add(btn_VendorPerformance);

        btn_RunnerPerformance.setBackground(new java.awt.Color(31, 31, 31));
        btn_RunnerPerformance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_RunnerPerformance.setForeground(new java.awt.Color(245, 251, 254));
        btn_RunnerPerformance.setText("Runner Performance");
        btn_RunnerPerformance.setBorder(null);
        btn_RunnerPerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RunnerPerformance.setFocusable(false);
        btn_RunnerPerformance.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_RunnerPerformance.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_RunnerPerformance.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_RunnerPerformance.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_RunnerPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RunnerPerformanceActionPerformed(evt);
            }
        });
        btn_container1.add(btn_RunnerPerformance);

        btn_ManageComplaints.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageComplaints.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageComplaints.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageComplaints.setText("Manage Complaints");
        btn_ManageComplaints.setBorder(null);
        btn_ManageComplaints.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageComplaints.setFocusable(false);
        btn_ManageComplaints.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageComplaints.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageComplaints.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageComplaints.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageComplaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageComplaintsActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageComplaints);

        btn_ModerateVItems.setBackground(new java.awt.Color(31, 31, 31));
        btn_ModerateVItems.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ModerateVItems.setForeground(new java.awt.Color(245, 254, 254));
        btn_ModerateVItems.setText("Moderate Vendor Items");
        btn_ModerateVItems.setBorder(null);
        btn_ModerateVItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ModerateVItems.setFocusable(false);
        btn_ModerateVItems.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ModerateVItems.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ModerateVItems.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ModerateVItems.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ModerateVItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModerateVItemsActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ModerateVItems);
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

        // ---------- Line Separator ----------
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

        // ---------- Main Content Area ----------
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
        title.setText("View Vendor Performance");
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

        // ---------- Setting Up the Tabbed Pane ----------
        tabbedPane.setPreferredSize(new java.awt.Dimension(880, 480));

        // Create tab panels with BorderLayout
        JPanel vendorRevenuePanel = new JPanel(new BorderLayout());
        vendorRevenuePanel.add(new VendorAnalysisPanel("Vendor Revenue"), BorderLayout.CENTER);

        JPanel bestSellingPanel = new JPanel(new BorderLayout());
        bestSellingPanel.add(new VendorAnalysisPanel("Best Selling Items"), BorderLayout.CENTER);

        JPanel orderTypesPanel = new JPanel(new BorderLayout());
        orderTypesPanel.add(new VendorAnalysisPanel("Order Types Breakdown"), BorderLayout.CENTER);

        JPanel customerFrequencyPanel = new JPanel(new BorderLayout());
        customerFrequencyPanel.add(new VendorAnalysisPanel("Customer Order Frequency"), BorderLayout.CENTER);

        JPanel vendorRevenueDashboard = new JPanel(new BorderLayout());
        vendorRevenueDashboard.add(new VendorAnalysisPanel("Vendor Revenue Dashboard"), BorderLayout.CENTER);


        tabbedPane.addTab("Vendor Revenue", vendorRevenuePanel);
        tabbedPane.addTab("Best Selling Items", bestSellingPanel);
        tabbedPane.addTab("Order Types Breakdown", orderTypesPanel);
        tabbedPane.addTab("Customer Order Frequency", customerFrequencyPanel);
        tabbedPane.addTab("Vendor Revenue Dashboard", vendorRevenueDashboard);

        
        Main.add(tabbedPane);
        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    List<Notification> notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications(), "Manager", false);

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

    private void btn_VendorPerformanceActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btn_RunnerPerformanceActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new RunnerPerformance().setVisible(true);
    }

    private void btn_ManageComplaintsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new ManageComplaints().setVisible(true);
    }

    private void btn_ModerateVItemsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new ModerateVendorItems().setVisible(true);
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
    private javax.swing.JButton btn_RunnerPerformance;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_ManageComplaints;
    private javax.swing.JButton btn_VendorPerformance;
    private javax.swing.JButton btn_ModerateVItems;
    private javax.swing.JButton btn_logout;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin3;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JLabel systemName;
    private javax.swing.JPanel title_container;
    private javax.swing.JLabel title;
    private javax.swing.JTabbedPane tabbedPane;
    private oodj.food_ordering_system.designUI.Button btn_Noti;
    // End of variables declaration
}
