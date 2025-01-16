package oodj.food_ordering_system.designUI;

import oodj.food_ordering_system.models.Admin;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import raven.glasspanepopup.*;

import java.util.List;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

public class MenuTemplate extends javax.swing.JFrame {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuTemplate().setVisible(true);
        });
    }

    public MenuTemplate() {
        initComponents();
        GlassPanePopup.install(this);
        loadName();
    }

    private void loadName() {
        // Admin endUserAd = LoginPage.getEndUserAd();
        // admin_username.setText(endUserAd.getUsername());
        // TODO LOAD ADMIN USERNAME
        admin_username.setText("Admin");
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
        btn_Page1 = new javax.swing.JButton();
        btn_Page2 = new javax.swing.JButton();
        btn_Page3 = new javax.swing.JButton();
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
        setTitle("Admin Menu");
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

        btn_Page1.setBackground(new java.awt.Color(43, 43, 43));
        btn_Page1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Page1.setForeground(new java.awt.Color(255, 169, 140));
        btn_Page1.setText("Page 1");
        btn_Page1.setBorder(null);
        btn_Page1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Page1.setFocusable(false);
        btn_Page1.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_Page1.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_Page1.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_Page1.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_Page1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Page1ActionPerformed(evt);
            }
        });
        btn_container1.add(btn_Page1);

        btn_Page2.setBackground(new java.awt.Color(31, 31, 31));
        btn_Page2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Page2.setForeground(new java.awt.Color(245, 251, 254));
        btn_Page2.setText("Page 2");
        btn_Page2.setBorder(null);
        btn_Page2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Page2.setFocusable(false);
        btn_Page2.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_Page2.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_Page2.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_Page2.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_Page2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Page2ActionPerformed(evt);
            }
        });
        btn_container1.add(btn_Page2);

        btn_Page3.setBackground(new java.awt.Color(31, 31, 31));
        btn_Page3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Page3.setForeground(new java.awt.Color(245, 251, 254));
        btn_Page3.setText("Page 3");
        btn_Page3.setBorder(null);
        btn_Page3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Page3.setFocusable(false);
        btn_Page3.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_Page3.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_Page3.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_Page3.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_Page3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Page3ActionPerformed(evt);
            }
        });
        btn_container1.add(btn_Page3);

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

        admin_username.setBackground(new java.awt.Color(31, 31, 31));
        admin_username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        admin_username.setForeground(new java.awt.Color(255, 169, 140));
        admin_username.setText("< admin_username >, ");
        admin_username.setMaximumSize(new java.awt.Dimension(300, 50));
        admin_username.setMinimumSize(new java.awt.Dimension(300, 50));
        admin_username.setPreferredSize(new java.awt.Dimension(750, 50));
        title_container.add(admin_username);

        btn_Noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noti.png"))); // NOI18N
        btn_Noti.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_Noti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotiActionPerformed(evt);
            }
        });
        title_container.add(btn_Noti);

        Main.add(title_container);

        title_container1.setBackground(new java.awt.Color(31, 31, 31));
        title_container1.setMaximumSize(new java.awt.Dimension(1000, 80));
        title_container1.setMinimumSize(new java.awt.Dimension(1000, 80));
        title_container1.setPreferredSize(new java.awt.Dimension(1000, 80));
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

        welcome3.setBackground(new java.awt.Color(31, 31, 31));
        welcome3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        welcome3.setForeground(new java.awt.Color(245, 251, 254));
        welcome3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome3.setText("This is the default page");
        welcome3.setAlignmentX(0.5F);
        welcome3.setMaximumSize(new java.awt.Dimension(275, 50));
        welcome3.setMinimumSize(new java.awt.Dimension(275, 50));
        welcome3.setPreferredSize(new java.awt.Dimension(275, 50));
        title_container1.add(welcome3);

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

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            dispose();
            new LoginPage().setVisible(true);
        }
    }                                          

    private void btn_Page1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void btn_Page2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //dispose();
        //TODO CALL PAGE 2
        System.out.println("Page 2");
    }                                           

    private void btn_Page3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
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
    private javax.swing.JButton btn_Page2;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_Page3;
    private javax.swing.JButton btn_Page1;
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

