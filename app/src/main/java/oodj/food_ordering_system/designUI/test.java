package oodj.food_ordering_system.designUI;

import javax.swing.*;
import java.awt.*;


public class test extends javax.swing.JFrame {
    public test() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Sidebar = new javax.swing.JPanel();
        margin1 = new javax.swing.JPanel();
        Logo_container = new javax.swing.JPanel();
        systemName = new javax.swing.JLabel();
        margin2 = new javax.swing.JPanel();
        btn_container1 = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_history = new javax.swing.JButton();
        btn_cart = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();
        margin3 = new javax.swing.JPanel();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Line = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();


        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 670));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 670));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        Sidebar.setBackground(new java.awt.Color(31, 31, 31));
        Sidebar.setAlignmentX(0.0F);
        Sidebar.setAlignmentY(0.0F);
        Sidebar.setMaximumSize(new java.awt.Dimension(300, 670));
        Sidebar.setMinimumSize(new java.awt.Dimension(300, 670));
        Sidebar.setPreferredSize(new java.awt.Dimension(300, 670));

        margin1.setBackground(new java.awt.Color(31, 31, 31));

        javax.swing.GroupLayout margin1Layout = new javax.swing.GroupLayout(margin1);
        margin1.setLayout(margin1Layout);
        margin1Layout.setHorizontalGroup(
            margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        margin1Layout.setVerticalGroup(
            margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout margin2Layout = new javax.swing.GroupLayout(margin2);
        margin2.setLayout(margin2Layout);
        margin2Layout.setHorizontalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        margin2Layout.setVerticalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Sidebar.add(margin2);

        btn_container1.setBackground(new java.awt.Color(31, 31, 31));
        // btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
        // btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 320));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_home.setBackground(new java.awt.Color(43, 43, 43));
        btn_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 169, 140)); 
        btn_home.setText("Home");
        btn_home.setBorder(null);
        btn_home.setBorderPainted(false);
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.setFocusable(false);
        btn_home.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_home.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_home.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btn_homeActionPerformed(evt);
            }
        });
        btn_container1.add(btn_home);
        btn_menu.setBackground(new java.awt.Color(31, 31, 31));
        btn_menu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(245, 251, 254));
        btn_menu.setText("Menu");
        btn_menu.setBorder(null);
        btn_menu.setBorderPainted(false);
        btn_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_menu.setFocusable(false);
        btn_menu.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_menu.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_menu.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_menu.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });
        
        btn_container1.add(btn_menu);

        btn_cart.setBackground(new java.awt.Color(31, 31, 31));
        btn_cart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_cart.setForeground(new java.awt.Color(245, 251, 254));
        btn_cart.setText("Cart");
        btn_cart.setBorder(null);
        btn_cart.setBorderPainted(false);
        btn_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cart.setFocusable(false);
        btn_cart.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_cart.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_cart.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_cart.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btn_cartActionPerformed(evt);
            }
        });
        btn_container1.add(btn_cart);

        btn_history.setBackground(new java.awt.Color(31, 31, 31));
        btn_history.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_history.setForeground(new java.awt.Color(245, 251, 254));
        btn_history.setText("Order History");
        btn_history.setBorder(null);
        btn_history.setBorderPainted(false);
        btn_history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_history.setFocusable(false);
        btn_history.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_history.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_history.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_history.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btn_historyActionPerformed(evt);
            }
        });
        btn_container1.add(btn_history);

        

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
            .addGap(0, 0, Short.MAX_VALUE)
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
        btn_logout.setBorderPainted(false);
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.setFocusable(false);
        btn_logout.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_logout.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_logout.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_logout.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btn_logoutActionPerformed(evt);
            }
        });
        btn_container2.add(btn_logout);

        Sidebar.add(btn_container2);


        jPanel1.add(Sidebar);
        Sidebar.setBounds(0, 0, 300, 670);
        Sidebar.getAccessibleContext().setAccessibleParent(this);

        Line.setBackground(new java.awt.Color(50, 50, 50));
        Line.setMaximumSize(new java.awt.Dimension(2, 670));
        Line.setMinimumSize(new java.awt.Dimension(2, 670));

        javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
        Line.setLayout(LineLayout);
        LineLayout.setHorizontalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        LineLayout.setVerticalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel1.add(Line);
        Line.setBounds(300, 0, 2, 670);
        

        Main.setBackground(new java.awt.Color(31, 31, 31));
        Main.setAlignmentX(0.0F);
        Main.setAlignmentY(0.0F);
        Main.setMaximumSize(new java.awt.Dimension(1000, 670));
        Main.setMinimumSize(new java.awt.Dimension(1000, 670));
        Main.setPreferredSize(new java.awt.Dimension(1000, 670));
        Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        
        // Create the credit bar
        JPanel creditBar = new JPanel(new BorderLayout());
        creditBar.setBackground(new java.awt.Color(31, 31, 31)); // Dark gray background
        creditBar.setPreferredSize(new java.awt.Dimension(800, 50)); // Height of the bar

        // Create a bottom border for the credit bar (line included)
        creditBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, java.awt.Color.GRAY));

        // Create the "credit" label
        JLabel creditLabel = new JLabel("<credit>");
        creditLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // Bold font, size 24
        creditLabel.setForeground(new java.awt.Color(255, 255, 255)); // White text
        creditLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
        creditLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Add right margin
        creditBar.add(creditLabel, BorderLayout.EAST);

        // Create a thin panel to act as the line below the creditBar
        JPanel lineBelow = new JPanel();
        lineBelow.setBackground(new java.awt.Color(50, 50, 50)); // Line color
        lineBelow.setMaximumSize(new java.awt.Dimension(1000, 2));
        lineBelow.setMinimumSize(new java.awt.Dimension(1000, 2));
        lineBelow.setPreferredSize(new java.awt.Dimension(1000, 2)); // 1px height for the line

        // Add the credit bar and the line below to the Main panel
        Main.add(creditBar); // Add the credit bar first
        Main.add(lineBelow); // Add the line directly below

        jPanel1.add(Main);
        Main.setBounds(200, 0, 1000, 670);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        pack();
    

    }

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your button action logic here
        setVisible(false);
        new CusMenu().setVisible(true);

    }

    public static void main(String args[]) {       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CusDash().setVisible(true);
            }
        });
    }

    private javax.swing.JPanel Line;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_cart;
    private javax.swing.JButton btn_history;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_logout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin3;
    private javax.swing.JLabel systemName;
}

// package oodj.food_ordering_system.designUI;

// import javax.swing.*;
// import java.awt.*;


// public class CusDash extends javax.swing.JFrame {
//     public CusDash() {
//         initComponents();
//     }

    
//     private void initComponents() {

//         String[][] foods = {
//             {"Hummus", "spinach, tomato, pita bread", "200g", "$9.89"},
//             {"Chicken liver pate", "persimmon, toasts", "210g", "$8.69"},
//             {"Beef tartare", "gherkins, toasts", "210g", "$11.15"},
//             {"Salmon tartare", "avocado, toasts", "190g", "$15.99"},
//             {"Bruschetta with mozzarella", "baked tomatoes, guacamole", "190g", "$6.55"},
//             {"Bruschetta with shrimps", "tomatoes, avocado", "180g", "$12.56"}
//         };

//         jPanel1 = new javax.swing.JPanel();
//         Sidebar = new javax.swing.JPanel();
//         margin1 = new javax.swing.JPanel();
//         Logo_container = new javax.swing.JPanel();
//         systemName = new javax.swing.JLabel();
//         margin2 = new javax.swing.JPanel();
//         btn_container1 = new javax.swing.JPanel();
//         btn_home = new javax.swing.JButton();
//         btn_history = new javax.swing.JButton();
//         btn_cart = new javax.swing.JButton();
//         btn_menu = new javax.swing.JButton();
//         margin3 = new javax.swing.JPanel();
//         btn_container2 = new javax.swing.JPanel();
//         btn_logout = new javax.swing.JButton();
//         Line = new javax.swing.JPanel();
//         Main = new javax.swing.JPanel();


//         // setResizable(false);
//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//         jPanel1.setBackground(new java.awt.Color(31, 31, 31));
//         jPanel1.setMaximumSize(new java.awt.Dimension(1000, 670));
//         jPanel1.setMinimumSize(new java.awt.Dimension(1000, 670));
//         jPanel1.setName(""); // NOI18N
//         jPanel1.setLayout(null);

//         Sidebar.setBackground(new java.awt.Color(31, 31, 31));
//         Sidebar.setAlignmentX(0.0F);
//         Sidebar.setAlignmentY(0.0F);
//         Sidebar.setMaximumSize(new java.awt.Dimension(300, 670));
//         Sidebar.setMinimumSize(new java.awt.Dimension(300, 670));
//         Sidebar.setPreferredSize(new java.awt.Dimension(300, 670));

//         margin1.setBackground(new java.awt.Color(31, 31, 31));

//         javax.swing.GroupLayout margin1Layout = new javax.swing.GroupLayout(margin1);
//         margin1.setLayout(margin1Layout);
//         margin1Layout.setHorizontalGroup(
//             margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 0, Short.MAX_VALUE)
//         );
//         margin1Layout.setVerticalGroup(
//             margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 0, Short.MAX_VALUE)
//         );

//         Sidebar.add(margin1);

//         Logo_container.setBackground(new java.awt.Color(31, 31, 31));
//         Logo_container.setMaximumSize(new java.awt.Dimension(300, 100));
//         Logo_container.setMinimumSize(new java.awt.Dimension(300, 100));
//         Logo_container.setPreferredSize(new java.awt.Dimension(300, 100));
//         Logo_container.setLayout(new javax.swing.BoxLayout(Logo_container, javax.swing.BoxLayout.LINE_AXIS));

//         systemName.setBackground(new java.awt.Color(31, 31, 31));
//         systemName.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
//         systemName.setForeground(new java.awt.Color(255, 169, 140));
//         systemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         systemName.setText("Car Connect");
//         systemName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
//         systemName.setAlignmentX(0.5F);
//         systemName.setMaximumSize(new java.awt.Dimension(300, 50));
//         systemName.setMinimumSize(new java.awt.Dimension(300, 50));
//         systemName.setPreferredSize(new java.awt.Dimension(300, 50));
//         Logo_container.add(systemName);

//         Sidebar.add(Logo_container);

//         margin2.setBackground(new java.awt.Color(31, 31, 31));
//         margin2.setMaximumSize(new java.awt.Dimension(300, 50));
//         margin2.setMinimumSize(new java.awt.Dimension(300, 50));

//         javax.swing.GroupLayout margin2Layout = new javax.swing.GroupLayout(margin2);
//         margin2.setLayout(margin2Layout);
//         margin2Layout.setHorizontalGroup(
//             margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 0, Short.MAX_VALUE)
//         );
//         margin2Layout.setVerticalGroup(
//             margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 0, Short.MAX_VALUE)
//         );

//         Sidebar.add(margin2);

//         btn_container1.setBackground(new java.awt.Color(31, 31, 31));
//         // btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
//         // btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
//         btn_container1.setPreferredSize(new java.awt.Dimension(300, 320));
//         btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

//         btn_home.setBackground(new java.awt.Color(43, 43, 43));
//         btn_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//         btn_home.setForeground(new java.awt.Color(255, 169, 140)); 
//         btn_home.setText("Home");
//         btn_home.setBorder(null);
//         btn_home.setBorderPainted(false);
//         btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         btn_home.setFocusable(false);
//         btn_home.setMargin(new java.awt.Insets(15, 50, 15, 50));
//         btn_home.setMaximumSize(new java.awt.Dimension(250, 40));
//         btn_home.setMinimumSize(new java.awt.Dimension(250, 40));
//         btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_home.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 // btn_homeActionPerformed(evt);
//             }
//         });
//         btn_container1.add(btn_home);
//         btn_menu.setBackground(new java.awt.Color(31, 31, 31));
//         btn_menu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//         btn_menu.setForeground(new java.awt.Color(245, 251, 254));
//         btn_menu.setText("Menu");
//         btn_menu.setBorder(null);
//         btn_menu.setBorderPainted(false);
//         btn_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         btn_menu.setFocusable(false);
//         btn_menu.setMargin(new java.awt.Insets(15, 50, 15, 50));
//         btn_menu.setMaximumSize(new java.awt.Dimension(250, 40));
//         btn_menu.setMinimumSize(new java.awt.Dimension(250, 40));
//         btn_menu.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_menu.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btn_menuActionPerformed(evt);
//             }
//         });
        
//         btn_container1.add(btn_menu);

//         btn_cart.setBackground(new java.awt.Color(31, 31, 31));
//         btn_cart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//         btn_cart.setForeground(new java.awt.Color(245, 251, 254));
//         btn_cart.setText("Cart");
//         btn_cart.setBorder(null);
//         btn_cart.setBorderPainted(false);
//         btn_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         btn_cart.setFocusable(false);
//         btn_cart.setMargin(new java.awt.Insets(15, 50, 15, 50));
//         btn_cart.setMaximumSize(new java.awt.Dimension(250, 40));
//         btn_cart.setMinimumSize(new java.awt.Dimension(250, 40));
//         btn_cart.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_cart.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 // btn_cartActionPerformed(evt);
//             }
//         });
//         btn_container1.add(btn_cart);

//         btn_history.setBackground(new java.awt.Color(31, 31, 31));
//         btn_history.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//         btn_history.setForeground(new java.awt.Color(245, 251, 254));
//         btn_history.setText("Order History");
//         btn_history.setBorder(null);
//         btn_history.setBorderPainted(false);
//         btn_history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         btn_history.setFocusable(false);
//         btn_history.setMargin(new java.awt.Insets(15, 50, 15, 50));
//         btn_history.setMaximumSize(new java.awt.Dimension(250, 40));
//         btn_history.setMinimumSize(new java.awt.Dimension(250, 40));
//         btn_history.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_history.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 // btn_historyActionPerformed(evt);
//             }
//         });
//         btn_container1.add(btn_history);

        

//         Sidebar.add(btn_container1);

//         margin3.setBackground(new java.awt.Color(31, 31, 31));
//         margin3.setMaximumSize(new java.awt.Dimension(300, 100));
//         margin3.setMinimumSize(new java.awt.Dimension(300, 100));
//         margin3.setPreferredSize(new java.awt.Dimension(300, 80));

//         javax.swing.GroupLayout margin3Layout = new javax.swing.GroupLayout(margin3);
//         margin3.setLayout(margin3Layout);
//         margin3Layout.setHorizontalGroup(
//             margin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 0, Short.MAX_VALUE)
//         );
//         margin3Layout.setVerticalGroup(
//             margin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 0, Short.MAX_VALUE)
//         );

//         Sidebar.add(margin3);

//         btn_container2.setBackground(new java.awt.Color(31, 31, 31));
//         btn_container2.setMaximumSize(new java.awt.Dimension(300, 50));
//         btn_container2.setMinimumSize(new java.awt.Dimension(300, 50));
//         btn_container2.setPreferredSize(new java.awt.Dimension(300, 50));
//         btn_container2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

//         btn_logout.setBackground(new java.awt.Color(31, 31, 31));
//         btn_logout.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//         btn_logout.setForeground(new java.awt.Color(245, 251, 254));
//         btn_logout.setText("Logout");
//         btn_logout.setBorder(null);
//         btn_logout.setBorderPainted(false);
//         btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         btn_logout.setFocusable(false);
//         btn_logout.setMargin(new java.awt.Insets(15, 50, 15, 50));
//         btn_logout.setMaximumSize(new java.awt.Dimension(250, 40));
//         btn_logout.setMinimumSize(new java.awt.Dimension(250, 40));
//         btn_logout.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_logout.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 // btn_logoutActionPerformed(evt);
//             }
//         });
//         btn_container2.add(btn_logout);

//         Sidebar.add(btn_container2);


//         jPanel1.add(Sidebar);
//         Sidebar.setBounds(0, 0, 300, 670);
//         Sidebar.getAccessibleContext().setAccessibleParent(this);

//         Line.setBackground(new java.awt.Color(50, 50, 50));
//         Line.setMaximumSize(new java.awt.Dimension(2, 670));
//         Line.setMinimumSize(new java.awt.Dimension(2, 670));

//         javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
//         Line.setLayout(LineLayout);
//         LineLayout.setHorizontalGroup(
//             LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 2, Short.MAX_VALUE)
//         );
//         LineLayout.setVerticalGroup(
//             LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 670, Short.MAX_VALUE)
//         );

//         jPanel1.add(Line);
//         Line.setBounds(300, 0, 2, 670);
        

//         Main.setBackground(new java.awt.Color(31, 31, 31));
//         Main.setAlignmentX(0.0F);
//         Main.setAlignmentY(0.0F);
//         Main.setMaximumSize(new java.awt.Dimension(1000, 670));
//         Main.setMinimumSize(new java.awt.Dimension(1000, 670));
//         Main.setPreferredSize(new java.awt.Dimension(1000, 670));
//         Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        
//         // Create the credit bar
//         JPanel creditBar = new JPanel(new BorderLayout());
//         creditBar.setBackground(new java.awt.Color(31, 31, 31)); // Dark gray background
//         creditBar.setPreferredSize(new java.awt.Dimension(800, 50)); // Height of the bar

//         // Create a bottom border for the credit bar (line included)
//         creditBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, java.awt.Color.GRAY));

//         // Create the "credit" label
//         JLabel creditLabel = new JLabel("<credit>");
//         creditLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // Bold font, size 24
//         creditLabel.setForeground(new java.awt.Color(255, 255, 255)); // White text
//         creditLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
//         creditLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Add right margin
//         creditBar.add(creditLabel, BorderLayout.EAST);

//         // Create a thin panel to act as the line below the creditBar
//         JPanel lineBelow = new JPanel();
//         lineBelow.setBackground(new java.awt.Color(50, 50, 50)); // Line color
//         lineBelow.setMaximumSize(new java.awt.Dimension(1000, 2));
//         lineBelow.setMinimumSize(new java.awt.Dimension(1000, 2));
//         lineBelow.setPreferredSize(new java.awt.Dimension(1000, 2)); // 1px height for the line

//         Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS));

//         // Add the credit bar and the line below to the Main panel
//         Main.add(creditBar); // Add the credit bar first
//         Main.add(lineBelow); // Add the line directly below

//         // Create a new JPanel to hold all the food items
//         JPanel foodPanel = new JPanel();
//         foodPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10)); // Horizontal flow with padding between items

//         // Loop through the foods array and create a panel for each food item
//         for (String[] food : foods) {
//             // Create a panel for each food item (acting as a "card")
//             JPanel foodCard = new JPanel();
//             foodCard.setLayout(new BorderLayout());  // Use BorderLayout to organize the content inside the card
//             foodCard.setPreferredSize(new Dimension(200, 150));  // Fixed size for each food card
//             foodCard.setBackground(new Color(43, 43, 43));  // Dark background for the card
//             foodCard.setBorder(BorderFactory.createLineBorder(new Color(255, 169, 140), 2));  // Border around the card

//             // Create labels for the food name, description, weight, and price
//             JLabel foodName = new JLabel(food[0]);
//             foodName.setFont(new Font("Segoe UI", Font.BOLD, 18));  // Bold font for the name
//             foodName.setForeground(Color.WHITE);

//             JLabel foodDescription = new JLabel("<html><i>" + food[1] + "</i></html>");  // Italic for description
//             foodDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//             foodDescription.setForeground(Color.LIGHT_GRAY);

//             JLabel foodWeight = new JLabel(food[2]);
//             foodWeight.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//             foodWeight.setForeground(Color.WHITE);

//             JLabel foodPrice = new JLabel(food[3]);
//             foodPrice.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//             foodPrice.setForeground(new Color(255, 169, 140));  // Price in a different color

//             // Add the labels to the food card panel
//             JPanel textPanel = new JPanel();
//             textPanel.setLayout(new GridLayout(2, 1));   // Vertical layout for text
//             textPanel.setOpaque(false);  // Transparent background for the text panel
//             textPanel.add(foodName);
//             textPanel.add(foodDescription);
//             textPanel.add(foodWeight);
//             textPanel.add(foodPrice);

//             foodCard.add(textPanel, BorderLayout.CENTER);  // Add textPanel in the center of the card

//             // Add the food card to the food panel
//             foodPanel.add(foodCard);
//         }

//         // Create a new JPanel to wrap the foodPanel
//         JPanel resName = new JPanel();
//         resName.setLayout(new BorderLayout());  // You can choose a different layout if needed

//         // Set a fixed size for the resName panel (width, height)
//         resName.setPreferredSize(new Dimension(500, 600));  // Example size, 500px width, 600px height

//         // Optionally, set some background color or border for resName
//         resName.setBackground(new Color(30, 30, 30));  // Dark background for the wrapper panel
//         resName.setBorder(BorderFactory.createTitledBorder("Restaurant Menu"));  // Example title


//         // Add the foodPanel to the resName panel (wrap the foodPanel inside resName)
//         resName.add(foodPanel, BorderLayout.CENTER);

//         // Optionally, you can add a label or other components to the resName panel
//         JLabel restaurantName = new JLabel("Restaurant Name");
//         restaurantName.setFont(new Font("Segoe UI", Font.BOLD, 20));
//         restaurantName.setForeground(Color.WHITE);

//         // Add the restaurant name label to the top of the resName panel
//         resName.add(restaurantName, BorderLayout.NORTH);

//         // Now, add the resName panel to your main layout (Main or any other parent panel)
//         // JPanel Main = new JPanel();  // Ensure you define this as a JPanel if not already defined
//         // Main.setLayout(new BorderLayout());
//         // Main.add(resName, BorderLayout.CENTER);  // Add the resName panel here

//         // Add the Main panel to jPanel1 (parent container)
//         jPanel1.add(Main);
//         Main.setBounds(200, 0, 1000, 670);

//         // Set up GroupLayout for the content pane
//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
//         );

//         // Pack the frame to apply the layout changes
//         pack();


//     }

//     private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {
//         // Add your button action logic here
//         setVisible(false);
//         new CusMenu().setVisible(true);

//     }

//     public static void main(String args[]) {       
//         java.awt.EventQueue.invokeLater(new Runnable() {
//             public void run() {
//                 new CusDash().setVisible(true);
//             }
//         });
//     }

//     private javax.swing.JPanel Line;
//     private javax.swing.JPanel Logo_container;
//     private javax.swing.JPanel Main;
//     private javax.swing.JPanel Sidebar;
//     private javax.swing.JPanel btn_container1;
//     private javax.swing.JPanel btn_container2;
//     private javax.swing.JButton btn_cart;
//     private javax.swing.JButton btn_history;
//     private javax.swing.JButton btn_home;
//     private javax.swing.JButton btn_menu;
//     private javax.swing.JButton btn_logout;
//     private javax.swing.JPanel jPanel1;
//     private javax.swing.JPanel margin1;
//     private javax.swing.JPanel margin2;
//     private javax.swing.JPanel margin3;
//     private javax.swing.JLabel systemName;
// }