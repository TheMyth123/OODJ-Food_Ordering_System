// package oodj.food_ordering_system.designUI;

// import javax.swing.*;
// import java.awt.*;
// import java.util.HashMap;

// public class RestaurantApp extends javax.swing.JFrame {

//     // Restaurants and menu data
//     String[][] restaurants = {
//         {"Burger Heaven", "Best burgers in town"},
//         {"Pasta Paradise", "Authentic Italian pasta"},
//         {"Sushi World", "Fresh and delicious sushi"}
//     };

//     HashMap<String, String[][]> restaurantMenus = new HashMap<>() {{
//         put("Burger Heaven", new String[][] {
//             {"Cheeseburger", "Tasty beef with cheese", "200g", "$5"},
//             {"Bacon Burger", "Crispy bacon delight", "220g", "$6"}
//         });
//         put("Pasta Paradise", new String[][] {
//             {"Spaghetti Bolognese", "Rich meat sauce", "300g", "$8"},
//             {"Penne Alfredo", "Creamy Alfredo sauce", "250g", "$7"}
//         });
//         put("Sushi World", new String[][] {
//             {"California Roll", "Classic sushi roll", "200g", "$10"},
//             {"Salmon Nigiri", "Fresh salmon on rice", "150g", "$12"}
//         });
//     }};

//     // Panels
//     private JPanel restaurantsPanel;
//     private JPanel menu;

//     public RestaurantApp() {
//         initComponents();
//     }

//     private void initComponents() {
//         jPanel1 = new javax.swing.JPanel();
//         Sidebar = new javax.swing.JPanel();
//         // btn_container1 = new javax.swing.JPanel();
//         btn_home = new javax.swing.JButton();
//         btn_menu = new javax.swing.JButton();
//         btn_cart = new javax.swing.JButton();
//         btn_history = new javax.swing.JButton();
//         btn_logout = new javax.swing.JButton();
//         Line = new javax.swing.JPanel();
//         Main = new javax.swing.JPanel();

//         // Frame settings
//         setResizable(false);
//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//         // Sidebar
//         Sidebar.setBackground(new java.awt.Color(31, 31, 31));
//         Sidebar.setPreferredSize(new java.awt.Dimension(300, 670));
//         Sidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));

//         // Sidebar buttons
//         btn_home.setText("Home");
//         btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_home.setBackground(new java.awt.Color(43, 43, 43));
//         btn_home.setForeground(new java.awt.Color(255, 169, 140));
//         btn_home.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18));
//         btn_home.setFocusable(false);
//         btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         Sidebar.add(btn_home);

//         btn_menu.setText("Menu");
//         btn_menu.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_menu.setBackground(new java.awt.Color(31, 31, 31));
//         btn_menu.setForeground(new java.awt.Color(245, 251, 254));
//         btn_menu.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
//         btn_menu.setFocusable(false);
//         btn_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         btn_menu.addActionListener(evt -> showRestaurantsPage());
//         Sidebar.add(btn_menu);

//         btn_cart.setText("Cart");
//         btn_cart.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_cart.setBackground(new java.awt.Color(31, 31, 31));
//         btn_cart.setForeground(new java.awt.Color(245, 251, 254));
//         btn_cart.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
//         btn_cart.setFocusable(false);
//         btn_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         Sidebar.add(btn_cart);

//         btn_history.setText("Order History");
//         btn_history.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_history.setBackground(new java.awt.Color(31, 31, 31));
//         btn_history.setForeground(new java.awt.Color(245, 251, 254));
//         btn_history.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
//         btn_history.setFocusable(false);
//         btn_history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         Sidebar.add(btn_history);

//         btn_logout.setText("Logout");
//         btn_logout.setPreferredSize(new java.awt.Dimension(250, 40));
//         btn_logout.setBackground(new java.awt.Color(31, 31, 31));
//         btn_logout.setForeground(new java.awt.Color(245, 251, 254));
//         btn_logout.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
//         btn_logout.setFocusable(false);
//         btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         Sidebar.add(btn_logout);

//         // Divider line
//         Line.setBackground(new java.awt.Color(50, 50, 50));
//         Line.setPreferredSize(new java.awt.Dimension(2, 670));

//         // Main panel with CardLayout
//         Main.setLayout(new CardLayout());
//         Main.setPreferredSize(new java.awt.Dimension(700, 670));

//         // Restaurants page
//         restaurantsPanel = new JPanel();
//         restaurantsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));
//         restaurantsPanel.setBackground(new Color(31, 31, 31));

//         for (String[] restaurant : restaurants) {
//             JButton restaurantButton = new JButton("<html><b>" + restaurant[0] + "</b><br>" + restaurant[1] + "</html>");
//             restaurantButton.setPreferredSize(new Dimension(300, 100));
//             restaurantButton.setBackground(new Color(43, 43, 43));
//             restaurantButton.setForeground(new Color(255, 169, 140));
//             restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//             restaurantButton.setFocusPainted(false);
//             restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

//             // Add action listener to navigate to menu page
//             restaurantButton.addActionListener(evt -> showMenu(restaurant[0]));

//             restaurantsPanel.add(restaurantButton);
//         }

//         Main.add(restaurantsPanel, "RestaurantsPage");

//         // Menu page
//         menu = new JPanel();
//         menu.setBackground(new Color(31, 31, 31));
//         menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
//         Main.add(menu, "MenuPage");

//         // Add components to main container
//         jPanel1.setLayout(new BorderLayout());
//         jPanel1.add(Sidebar, BorderLayout.WEST);
//         jPanel1.add(Line, BorderLayout.CENTER);
//         jPanel1.add(Main, BorderLayout.EAST);

//         getContentPane().add(jPanel1);

//         pack();
//     }

//     private void showRestaurantsPage() {
//         CardLayout cl = (CardLayout) Main.getLayout();
//         cl.show(Main, "RestaurantsPage");
//     }

//     private void showMenu(String restaurantName) {
//         menu.removeAll(); // Clear previous menu

//         // Title
//         JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.CENTER);
//         titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         titleLabel.setForeground(new Color(255, 169, 140));
//         titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         menu.add(titleLabel);

//         // Menu items
//         String[][] foods = restaurantMenus.get(restaurantName);
//         if (foods != null) {
//             JPanel menuGrid = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
//             menuGrid.setBackground(new Color(31, 31, 31));

//             for (String[] food : foods) {
//                 JPanel foodCard = new JPanel();
//                 foodCard.setLayout(new BorderLayout());
//                 foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//                 foodCard.setBackground(Color.WHITE);
//                 foodCard.setPreferredSize(new Dimension(200, 150));

//                 JButton nameButton = new JButton(food[0]);
//                 nameButton.setForeground(Color.BLACK);
//                 nameButton.setBackground(Color.WHITE);

//                 JButton descriptionButton = new JButton("<html><small>" + food[1] + "</small></html>");
//                 descriptionButton.setForeground(Color.DARK_GRAY);
//                 descriptionButton.setBackground(Color.WHITE);

//                 JButton weightPriceButton = new JButton(food[2] + " | " + food[3]);
//                 weightPriceButton.setForeground(Color.BLACK);
//                 weightPriceButton.setBackground(Color.WHITE);

//                 foodCard.add(nameButton, BorderLayout.NORTH);
//                 foodCard.add(descriptionButton, BorderLayout.CENTER);
//                 foodCard.add(weightPriceButton, BorderLayout.SOUTH);

//                 menuGrid.add(foodCard);
//             }

//             menu.add(menuGrid);
//         }

//         // Back button
//         JButton backButton = new JButton("Back");
//         backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//         backButton.setPreferredSize(new Dimension(150, 40));
//         backButton.setBackground(new Color(43, 43, 43));
//         backButton.setForeground(new Color(255, 169, 140));
//         backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         backButton.addActionListener(evt -> showRestaurantsPage());
//         menu.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
//         menu.add(backButton);

//         // Show menu page
//         CardLayout cl = (CardLayout) Main.getLayout();
//         cl.show(Main, "MenuPage");

//         menu.revalidate();
//         menu.repaint();
//     }

//     public static void main(String args[]) {
//         java.awt.EventQueue.invokeLater(() -> new RestaurantApp().setVisible(true));
//     }

//     private javax.swing.JPanel Line;
//     private javax.swing.JPanel Sidebar;
//     private javax.swing.JPanel Main;
//     private javax.swing.JButton btn_home;
//     private javax.swing.JButton btn_menu;
//     private javax.swing.JButton btn_cart;
//     private javax.swing.JButton btn_history;
//     private javax.swing.JButton btn_logout;
//     private javax.swing.JPanel jPanel1;
// }


// start

package oodj.food_ordering_system.designUI;

import javax.swing.*;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.NotificationUtils;
import raven.glasspanepopup.DefaultLayoutCallBack;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;

import java.awt.*;
import java.util.HashMap;
import java.util.List;


// public class CusDash extends javax.swing.JFrame {

//     String[][] restaurants = {
//         {"Burger Heaven", "Best burgers in town"},
//         {"Pasta Paradise", "Authentic Italian pasta"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"}
//     };

//     HashMap<String, String[][]> restaurantMenus = new HashMap<>() {{
//         put("Burger Heaven", new String[][] {
//             {"Cheeseburger", "Tasty beef with cheese", "200g", "$5"},
//             {"Bacon Burger", "Crispy bacon delight", "220g", "$6"}
//         });
//         put("Pasta Paradise", new String[][] {
//             {"Spaghetti Bolognese", "Rich meat sauce", "300g", "$8"},
//             {"Penne Alfredo", "Creamy Alfredo sauce", "250g", "$7"}
//         });
//         put("Sushi World", new String[][] {
//             {"California Roll", "Classic sushi roll", "200g", "$10"},
//             {"Salmon Nigiri", "Fresh salmon on rice", "150g", "$12"}
//         });
//     }};

//     public CusDash() {
//         initComponents();
//     }

    
//     private void initComponents() {

//         // restaurantsPanel = new javax.swing.JPanel();

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
//         title_container = new javax.swing.JPanel();
//         title = new javax.swing.JLabel();
//         jPanel2 = new javax.swing.JPanel();
//         jPanel3 = new javax.swing.JPanel();
//         menu = new javax.swing.JPanel();
//         restaurant = new javax.swing.JPanel();
//         m5 = new javax.swing.JPanel();
//         Line = new javax.swing.JPanel();
//         Sidebar = new javax.swing.JPanel();
//         Logo_container = new javax.swing.JPanel();
//         systemName = new javax.swing.JLabel();
//         margin2 = new javax.swing.JPanel();
//         btn_container1 = new javax.swing.JPanel();
        
//         margin3 = new javax.swing.JPanel();
//         btn_container2 = new javax.swing.JPanel();
//         btn_logout = new javax.swing.JButton();
//         Main = new javax.swing.JPanel();
//         title_container = new javax.swing.JPanel();
//         m5 = new javax.swing.JPanel();
//         welcome = new javax.swing.JLabel();
//         customer_username = new javax.swing.JLabel();
        
//         btn_Noti = new oodj.food_ordering_system.designUI.Button();





//         // setResizable(false);
//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//         jPanel1.setBackground(new java.awt.Color(31, 31, 31));
//         jPanel1.setMaximumSize(new java.awt.Dimension(1300, 700));
//         jPanel1.setMinimumSize(new java.awt.Dimension(1300, 700));
//         jPanel1.setName(""); // NOI18N
//         jPanel1.setLayout(null);

        
//         Sidebar.setBackground(new java.awt.Color(31, 31, 31));
//         Sidebar.setPreferredSize(new java.awt.Dimension(300, 670));
//         Sidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));

//         // margin1.setBackground(new java.awt.Color(31, 31, 31));

//         // javax.swing.GroupLayout margin1Layout = new javax.swing.GroupLayout(margin1);
//         // margin1.setLayout(margin1Layout);
//         // margin1Layout.setHorizontalGroup(
//         //     margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//         //     .addGap(0, 0, Short.MAX_VALUE)
//         // );
//         // margin1Layout.setVerticalGroup(
//         //     margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//         //     .addGap(0, 0, Short.MAX_VALUE)
//         // );

//         // Sidebar.add(margin1);


        

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
//         btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
//         btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
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
//         // btn_home.setMaximumSize(new java.awt.Dimension(250, 40));
//         // btn_home.setMinimumSize(new java.awt.Dimension(250, 40));
//         btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
        
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
//         // btn_menu.setMaximumSize(new java.awt.Dimension(250, 40));
//         // btn_menu.setMinimumSize(new java.awt.Dimension(250, 40));
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
//         Main.setMaximumSize(new java.awt.Dimension(1300, 700));
//         Main.setMinimumSize(new java.awt.Dimension(1300, 700));
//         Main.setPreferredSize(new java.awt.Dimension(1300, 700));

//         Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

//         //  test for noti
//         title_container.setBackground(new java.awt.Color(31, 31, 31));
//         title_container.setMaximumSize(new java.awt.Dimension(1000, 50));
//         title_container.setMinimumSize(new java.awt.Dimension(1000, 50));
//         title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
//         title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

//         m5.setBackground(new java.awt.Color(31, 31, 31));
//         m5.setMaximumSize(new java.awt.Dimension(60, 50));
//         m5.setMinimumSize(new java.awt.Dimension(60, 50));
//         m5.setPreferredSize(new java.awt.Dimension(60, 50));

//         javax.swing.GroupLayout m5Layout = new javax.swing.GroupLayout(m5);
//         m5.setLayout(m5Layout);
//         m5Layout.setHorizontalGroup(
//             m5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 60, Short.MAX_VALUE)
//         );
//         m5Layout.setVerticalGroup(
//             m5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 50, Short.MAX_VALUE)
//         );

//         title_container.add(m5);

//         welcome.setBackground(new java.awt.Color(31, 31, 31));
//         welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         welcome.setForeground(new java.awt.Color(255, 169, 140));
//         welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         welcome.setText("Hi,");
//         welcome.setAlignmentX(0.5F);
//         welcome.setMaximumSize(new java.awt.Dimension(50, 50));
//         welcome.setMinimumSize(new java.awt.Dimension(50, 50));
//         welcome.setPreferredSize(new java.awt.Dimension(50, 50));
//         title_container.add(welcome);

//         customer_username.setBackground(new java.awt.Color(31, 31, 31));
//         customer_username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         customer_username.setForeground(new java.awt.Color(255, 169, 140));
//         customer_username.setText("< customer_username >, ");
//         customer_username.setMaximumSize(new java.awt.Dimension(300, 50));
//         customer_username.setMinimumSize(new java.awt.Dimension(300, 50));
//         customer_username.setPreferredSize(new java.awt.Dimension(750, 50));
//         title_container.add(customer_username);

//         btn_Noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noti.png"))); // NOI18N
//         btn_Noti.setPreferredSize(new java.awt.Dimension(50, 50));
//         btn_Noti.setFocusPainted(false);
//         btn_Noti.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 // btn_NotiActionPerformed(evt);
//             }
//         });
//         title_container.add(btn_Noti);

//         Main.add(title_container);

  
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

//         // Add the credit bar and the line below to the Main panel
//         Main.add(creditBar); // Add the credit bar first
//         Main.add(lineBelow); // Add the line directly below


//         title_container.setBackground(new java.awt.Color(31, 31, 31));
//         title_container.setMaximumSize(new java.awt.Dimension(1000, 50));
//         title_container.setMinimumSize(new java.awt.Dimension(1000, 50));
//         title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
//         title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

//         title.setBackground(new java.awt.Color(31, 31, 31));
//         title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         title.setForeground(new java.awt.Color(255, 169, 140));
//         title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         title.setText("Restaurant Name");
//         title.setAlignmentX(0.5F);
//         title.setMaximumSize(new java.awt.Dimension(200, 50));
//         title.setMinimumSize(new java.awt.Dimension(200, 50));
//         title.setPreferredSize(new java.awt.Dimension(200, 50));
//         title_container.add(title);


    
//         Main.add(title_container);

//         jPanel2.setBackground(new java.awt.Color(31, 31, 31));
//         jPanel2.setMaximumSize(new java.awt.Dimension(900, 30));
//         jPanel2.setMinimumSize(new java.awt.Dimension(900, 30));

//         javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//         jPanel2.setLayout(jPanel2Layout);
//         jPanel2Layout.setHorizontalGroup(
//             jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 900, Short.MAX_VALUE)
//         );
//         jPanel2Layout.setVerticalGroup(
//             jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 30, Short.MAX_VALUE)
//         );

//         Main.add(jPanel2);

//         jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));        
//         jPanel3.setBackground(new java.awt.Color(31, 31, 31));
//         jPanel3.setMaximumSize(new java.awt.Dimension(700, 670));
//         jPanel3.setMinimumSize(new java.awt.Dimension(700, 670));
//         jPanel3.setPreferredSize(new java.awt.Dimension(700, 670));
        
             
//         restaurant.setBackground(new Color(31, 31, 31));

//         restaurant.setPreferredSize(new java.awt.Dimension(700, 670));

//         // Restaurants page
//         restaurantsPanel = new JPanel();
//         restaurantsPanel.setLayout(new GridLayout(0, 2, 50, 50)); // 2 columns, dynamic rows, 50px horizontal and vertical gaps

//         restaurantsPanel.setBackground(new Color(31, 31, 31));

//         for (String[] restaurant : restaurants) {
//             JButton restaurantButton = new JButton("<html><b>" + restaurant[0] + "</b><br>" + restaurant[1] + "</html>");
//             restaurantButton.setPreferredSize(new Dimension(250, 100));
//             restaurantButton.setBackground(new Color(43, 43, 43));
//             restaurantButton.setForeground(new Color(255, 169, 140));
//             restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//             restaurantButton.setFocusPainted(false);
//             restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

//             // Add action listener to navigate to menu page
//             restaurantButton.addActionListener(evt -> showMenu(restaurant[0]));

//             restaurantsPanel.add(restaurantButton);
//         }

//         restaurant.add(restaurantsPanel, "RestaurantsPage");

//         jPanel3.add(restaurant);

//         // Menu page
//         menu = new JPanel();
//         menu.setBackground(new Color(31, 31, 31));
//         menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
//         menu.setAlignmentX(Component.LEFT_ALIGNMENT);
//         menu.setAlignmentY(Component.TOP_ALIGNMENT);
//         menu.setPreferredSize(new Dimension(1000, 670));
//         menu.setMaximumSize(new Dimension(1000, 670));
//         Main.add(menu);

        



//         Main.add(jPanel3);

//         jPanel1.add(Main);
//         Main.setBounds(250, 0, 1300, 700);

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

//         pack();

//         restaurantsPanel.setVisible(true);
//         menu.setVisible(false);
    

//     }

// // test back button
//     private void showMenu(String restaurantName) {
//         restaurantsPanel.setVisible(false);
//         menu.setVisible(true);
//         menu.removeAll(); // Clear previous menu

//         // Set BoxLayout to stack components vertically
//         menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

//         // Title
//         // JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.CENTER);
//         // titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         // titleLabel.setForeground(new Color(255, 169, 140));
//         // titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         // menu.add(titleLabel);

//         // JButton backButton = new JButton("Back");
//         // backButton.setPreferredSize(new Dimension(150, 40));
//         // backButton.setBackground(new Color(43, 43, 43));
//         // backButton.setForeground(new Color(255, 169, 140));
//         // backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         // backButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
//         // backButton.addActionListener(evt -> {
//         //     menu.setVisible(false);
//         //     restaurantsPanel.setVisible(true);
//         // });
//         // menu.add(backButton);
//         // Panel to hold the titleLabel and backButton in one horizontal line
//         JPanel headerPanel = new JPanel();
//         headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS)); // Horizontal layout
//         headerPanel.setBackground(new Color(31, 31, 31)); // Match the background color of the main menu panel

//         headerPanel.setPreferredSize(new Dimension(600, 50)); // Set the preferred size (width: 800px, height: 50px)
//         headerPanel.setMinimumSize(new Dimension(600, 50));   // Optional: Ensure the panel is never smaller than this size
//         headerPanel.setMaximumSize(new Dimension(600, 50));
//         // Title Label
//         JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.LEFT); // Align text to the left
//         titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         titleLabel.setForeground(new Color(255, 169, 140));
//         titleLabel.setAlignmentY(Component.CENTER_ALIGNMENT); // Align vertically in the middle
//         headerPanel.add(titleLabel); // Add to the horizontal panel

//         // Spacer between the title and the back button
//         headerPanel.add(Box.createHorizontalGlue()); // Push components to opposite ends

//         // Back Button
//         JButton backButton = new JButton("Back");
//         backButton.setPreferredSize(new Dimension(80, 40));
//         backButton.setBackground(new Color(43, 43, 43));
//         backButton.setForeground(new Color(255, 169, 140));
//         backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         backButton.setAlignmentY(Component.CENTER_ALIGNMENT); // Align vertically in the middle
//         backButton.addActionListener(evt -> {
//             menu.setVisible(false);
//             restaurantsPanel.setVisible(true);
//         });
//         headerPanel.add(backButton); // Add to the horizontal panel

//         // Add the headerPanel to the menu panel
//         menu.add(headerPanel);

        

//         // Spacer after title
//         menu.add(Box.createRigidArea(new Dimension(0, 20)));

//         // Menu items
//         String[][] foods = restaurantMenus.get(restaurantName);
//         if (foods != null) {
//             // Panel to hold all food cards
//             JPanel menuGrid = new JPanel();
//             menuGrid.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//             menuGrid.setBackground(new Color(31, 31, 31));

//             for (String[] food : foods) {
//                 JPanel foodCard = new JPanel();
//                 foodCard.setLayout(new BorderLayout());
//                 foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//                 foodCard.setBackground(Color.WHITE);
//                 foodCard.setPreferredSize(new Dimension(200, 150));

//                 JButton nameButton = new JButton(food[0]);
//                 nameButton.setForeground(Color.BLACK);
//                 nameButton.setBackground(Color.WHITE);

//                 JButton descriptionButton = new JButton("<html><small>" + food[1] + "</small></html>");
//                 descriptionButton.setForeground(Color.DARK_GRAY);
//                 descriptionButton.setBackground(Color.WHITE);

//                 JButton weightPriceButton = new JButton(food[2] + " | " + food[3]);
//                 weightPriceButton.setForeground(Color.BLACK);
//                 weightPriceButton.setBackground(Color.WHITE);

//                 foodCard.add(nameButton, BorderLayout.NORTH);
//                 foodCard.add(descriptionButton, BorderLayout.CENTER);
//                 foodCard.add(weightPriceButton, BorderLayout.SOUTH);

//                 menuGrid.add(foodCard);
//             }

//             // Wrap the menu grid in a scroll pane
//             JScrollPane scrollPane = new JScrollPane(menuGrid);
//             scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//             scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//             scrollPane.setBorder(BorderFactory.createEmptyBorder());
//             scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
//             scrollPane.setPreferredSize(new Dimension(800, 400)); // Adjust size as needed
//             menu.add(scrollPane);

            
//         }

        

        

        
//     }

    



//     // private void showMenu(String restaurantName) {
//     //     restaurantsPanel.setVisible(false);
//     //     menu.setVisible(true);
//     //     menu.removeAll(); // Clear previous menu

//     //     // Title
//     //     JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.CENTER);
//     //     titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//     //     titleLabel.setForeground(new Color(255, 169, 140));
//     //     titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//     //     menu.add(titleLabel);

//     //     // Menu items
//     //     String[][] foods = restaurantMenus.get(restaurantName);
//     //     if (foods != null) {
//     //         // JPanel menuGrid = new JPanel(new GridLayout(0, 2, 50, 50));
//     //         JPanel menuGrid = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
//     //         menuGrid.setBackground(new Color(31, 31, 31));

//     //         for (String[] food : foods) {
//     //             JPanel foodCard = new JPanel();
//     //             foodCard.setLayout(new BorderLayout());
//     //             foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//     //             foodCard.setBackground(Color.WHITE);
//     //             foodCard.setPreferredSize(new Dimension(200, 150));

//     //             JButton nameButton = new JButton(food[0]);
//     //             nameButton.setForeground(Color.BLACK);
//     //             nameButton.setBackground(Color.WHITE);

//     //             JButton descriptionButton = new JButton("<html><small>" + food[1] + "</small></html>");
//     //             descriptionButton.setForeground(Color.DARK_GRAY);
//     //             descriptionButton.setBackground(Color.WHITE);

//     //             JButton weightPriceButton = new JButton(food[2] + " | " + food[3]);
//     //             weightPriceButton.setForeground(Color.BLACK);
//     //             weightPriceButton.setBackground(Color.WHITE);

//     //             foodCard.add(nameButton, BorderLayout.NORTH);
//     //             foodCard.add(descriptionButton, BorderLayout.CENTER);
//     //             foodCard.add(weightPriceButton, BorderLayout.SOUTH);

//     //             menuGrid.add(foodCard);
//     //         }

//     //         menu.add(menuGrid);
//     //     }

//     //     // Back button
//     //     JButton backButton = new JButton("Back");
//     //     backButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
//     //     backButton.setPreferredSize(new Dimension(150, 40));
//     //     backButton.setBackground(new Color(43, 43, 43));
//     //     backButton.setForeground(new Color(255, 169, 140));
//     //     backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//     //     // backButton.addActionListener(evt -> showRestaurantsPage());
//     //     backButton.addActionListener(evt -> {
//     //         menu.setVisible(false);
//     //         restaurantsPanel.setVisible(true);
//     //     });
//     //     menu.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
//     //     menu.add(backButton);


        

//     //     // Show menu page
//     //     // CardLayout cl = (CardLayout) Main.getLayout();
//     //     // cl.show(Main, "MenuPage");

//     //     // menu.revalidate();
//     //     // menu.repaint();
//     // }

// //     JScrollPane scrollPane = new JScrollPane(menu);
// // Main.add(scrollPane);

    

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
//     private javax.swing.JPanel margin2;
//     private javax.swing.JPanel margin3;
//     private javax.swing.JLabel systemName;
//     private javax.swing.JPanel title_container;
//     private javax.swing.JLabel title;
//     private javax.swing.JPanel jPanel2;
//     private javax.swing.JPanel jPanel3;
//     private javax.swing.JPanel menu;
//     private javax.swing.JPanel restaurant;
//     private javax.swing.JPanel restaurantsPanel;
//     private javax.swing.JLabel welcome;
//     private javax.swing.JLabel customer_username;
//     private javax.swing.JButton btn_Noti;
//     private javax.swing.JPanel m5;
//     private javax.swing.JPanel margin1;
    

// }


// test2

// package oodj.food_ordering_system.designUI;

// import javax.swing.*;

// import net.miginfocom.layout.ComponentWrapper;
// import net.miginfocom.layout.LayoutCallback;
// import oodj.food_ordering_system.models.Notification;
// import oodj.food_ordering_system.utils.NotificationUtils;
// import raven.glasspanepopup.DefaultLayoutCallBack;
// import raven.glasspanepopup.DefaultOption;
// import raven.glasspanepopup.GlassPanePopup;

// import java.awt.*;
// import java.util.HashMap;
// import java.util.List;


// public class CusDash extends javax.swing.JFrame {

//     String[][] restaurants = {
//         {"Burger Heaven", "Best burgers in town"},
//         {"Pasta Paradise", "Authentic Italian pasta"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"},
//         {"Sushi World", "Fresh and delicious sushi"}
//     };

//     HashMap<String, String[][]> restaurantMenus = new HashMap<>() {{
//         put("Burger Heaven", new String[][] {
//             {"Cheeseburger", "Tasty beef with cheese", "200g", "$5"},
//             {"Bacon Burger", "Crispy bacon delight", "220g", "$6"}
//         });
//         put("Pasta Paradise", new String[][] {
//             {"Spaghetti Bolognese", "Rich meat sauce", "300g", "$8"},
//             {"Penne Alfredo", "Creamy Alfredo sauce", "250g", "$7"}
//         });
//         put("Sushi World", new String[][] {
//             {"California Roll", "Classic sushi roll", "200g", "$10"},
//             {"Salmon Nigiri", "Fresh salmon on rice", "150g", "$12"}
//         });
//     }};

//     public CusDash() {
//         initComponents();
//     }

    
//     private void initComponents() {

//         // restaurantsPanel = new javax.swing.JPanel();

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
//         title_container = new javax.swing.JPanel();
//         title = new javax.swing.JLabel();
//         jPanel2 = new javax.swing.JPanel();
//         jPanel3 = new javax.swing.JPanel();
//         menu = new javax.swing.JPanel();
//         restaurant = new javax.swing.JPanel();
//         m5 = new javax.swing.JPanel();
//         Line = new javax.swing.JPanel();
//         Sidebar = new javax.swing.JPanel();
//         Logo_container = new javax.swing.JPanel();
//         systemName = new javax.swing.JLabel();
//         margin2 = new javax.swing.JPanel();
//         btn_container1 = new javax.swing.JPanel();
        
//         margin3 = new javax.swing.JPanel();
//         btn_container2 = new javax.swing.JPanel();
//         btn_logout = new javax.swing.JButton();
//         Main = new javax.swing.JPanel();
//         title_container = new javax.swing.JPanel();
//         m5 = new javax.swing.JPanel();
//         welcome = new javax.swing.JLabel();
//         customer_username = new javax.swing.JLabel();
        
//         btn_Noti = new oodj.food_ordering_system.designUI.Button();





//         // setResizable(false);
//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//         jPanel1.setBackground(new java.awt.Color(31, 31, 31));
//         jPanel1.setMaximumSize(new java.awt.Dimension(1300, 700));
//         jPanel1.setMinimumSize(new java.awt.Dimension(1300, 700));
//         jPanel1.setName(""); // NOI18N
//         jPanel1.setLayout(null);

        
//         Sidebar.setBackground(new java.awt.Color(31, 31, 31));
//         Sidebar.setPreferredSize(new java.awt.Dimension(300, 700));
//         Sidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));

//         // margin1.setBackground(new java.awt.Color(31, 31, 31));

//         // javax.swing.GroupLayout margin1Layout = new javax.swing.GroupLayout(margin1);
//         // margin1.setLayout(margin1Layout);
//         // margin1Layout.setHorizontalGroup(
//         //     margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//         //     .addGap(0, 0, Short.MAX_VALUE)
//         // );
//         // margin1Layout.setVerticalGroup(
//         //     margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//         //     .addGap(0, 0, Short.MAX_VALUE)
//         // );

//         // Sidebar.add(margin1);


        

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
//         btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
//         btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
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
//         margin3.setPreferredSize(new java.awt.Dimension(300, 100));

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
//         Sidebar.setBounds(0, 0, 300, 700);
//         Sidebar.getAccessibleContext().setAccessibleParent(this);

//         Line.setBackground(new java.awt.Color(50, 50, 50));
//         Line.setMaximumSize(new java.awt.Dimension(2, 700));
//         Line.setMinimumSize(new java.awt.Dimension(2, 700));

//         javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
//         Line.setLayout(LineLayout);
//         LineLayout.setHorizontalGroup(
//             LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 2, Short.MAX_VALUE)
//         );
//         LineLayout.setVerticalGroup(
//             LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 700, Short.MAX_VALUE)
//         );

//         jPanel1.add(Line);
//         Line.setBounds(300, 0, 2, 700);
        

//         Main.setBackground(new java.awt.Color(31, 31, 31));
//         Main.setAlignmentX(0.0F);
//         Main.setAlignmentY(0.0F);
//         Main.setMaximumSize(new java.awt.Dimension(1300, 700));
//         Main.setMinimumSize(new java.awt.Dimension(1300, 700));
//         Main.setPreferredSize(new java.awt.Dimension(1300, 700));

//         // Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

//         //  test for noti
//         title_container.setBackground(new java.awt.Color(31, 31, 31));
//         title_container.setMaximumSize(new java.awt.Dimension(1000, 50));
//         title_container.setMinimumSize(new java.awt.Dimension(1000, 50));
//         title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
//         title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

//         m5.setBackground(new java.awt.Color(31, 31, 31));
//         m5.setMaximumSize(new java.awt.Dimension(60, 50));
//         m5.setMinimumSize(new java.awt.Dimension(60, 50));
//         m5.setPreferredSize(new java.awt.Dimension(60, 50));

//         javax.swing.GroupLayout m5Layout = new javax.swing.GroupLayout(m5);
//         m5.setLayout(m5Layout);
//         m5Layout.setHorizontalGroup(
//             m5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 60, Short.MAX_VALUE)
//         );
//         m5Layout.setVerticalGroup(
//             m5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 50, Short.MAX_VALUE)
//         );

//         title_container.add(m5);

//         welcome.setBackground(new java.awt.Color(31, 31, 31));
//         welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         welcome.setForeground(new java.awt.Color(255, 169, 140));
//         welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         welcome.setText("Hi,");
//         welcome.setAlignmentX(0.5F);
//         welcome.setMaximumSize(new java.awt.Dimension(50, 50));
//         welcome.setMinimumSize(new java.awt.Dimension(50, 50));
//         welcome.setPreferredSize(new java.awt.Dimension(50, 50));
//         title_container.add(welcome);

//         customer_username.setBackground(new java.awt.Color(31, 31, 31));
//         customer_username.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         customer_username.setForeground(new java.awt.Color(255, 169, 140));
//         customer_username.setText("< customer_username >, ");
//         customer_username.setMaximumSize(new java.awt.Dimension(300, 50));
//         customer_username.setMinimumSize(new java.awt.Dimension(300, 50));
//         customer_username.setPreferredSize(new java.awt.Dimension(750, 50));
//         title_container.add(customer_username);

//         btn_Noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noti.png"))); // NOI18N
//         btn_Noti.setPreferredSize(new java.awt.Dimension(50, 50));
//         btn_Noti.setFocusPainted(false);
//         btn_Noti.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 // btn_NotiActionPerformed(evt);
//             }
//         });
//         title_container.add(btn_Noti);

//         Main.add(title_container);

  
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

//         // Add the credit bar and the line below to the Main panel
//         Main.add(creditBar); // Add the credit bar first
//         Main.add(lineBelow); // Add the line directly below


//         title_container.setBackground(new java.awt.Color(31, 31, 31));
//         title_container.setMaximumSize(new java.awt.Dimension(1000, 50));
//         title_container.setMinimumSize(new java.awt.Dimension(1000, 50));
//         title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
//         title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

//         title.setBackground(new java.awt.Color(31, 31, 31));
//         title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         title.setForeground(new java.awt.Color(255, 169, 140));
//         title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         title.setText("Restaurant Name");
//         title.setAlignmentX(0.5F);
//         title.setMaximumSize(new java.awt.Dimension(200, 50));
//         title.setMinimumSize(new java.awt.Dimension(200, 50));
//         title.setPreferredSize(new java.awt.Dimension(200, 50));
//         title_container.add(title);


    
//         Main.add(title_container);

//         // jPanel2.setBackground(new java.awt.Color(31, 31, 31));
//         // jPanel2.setMaximumSize(new java.awt.Dimension(900, 30));
//         // jPanel2.setMinimumSize(new java.awt.Dimension(900, 30));

//         // javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//         // jPanel2.setLayout(jPanel2Layout);
//         // jPanel2Layout.setHorizontalGroup(
//         //     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//         //     .addGap(0, 900, Short.MAX_VALUE)
//         // );
//         // jPanel2Layout.setVerticalGroup(
//         //     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//         //     .addGap(0, 30, Short.MAX_VALUE)
//         // );

//         // Main.add(jPanel2);

//         jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));        
//         jPanel3.setBackground(new java.awt.Color(31, 31, 31));
//         jPanel3.setMaximumSize(new java.awt.Dimension(700, 670));
//         jPanel3.setMinimumSize(new java.awt.Dimension(700, 670));
//         jPanel3.setPreferredSize(new java.awt.Dimension(700, 670));
        
             
//         restaurant.setBackground(new Color(31, 31, 31));

//         restaurant.setPreferredSize(new java.awt.Dimension(700, 670));

//         // Restaurants page
//         restaurantsPanel = new JPanel();
//         restaurantsPanel.setLayout(new GridLayout(0, 2, 50, 50)); // 2 columns, dynamic rows, 50px horizontal and vertical gaps

//         restaurantsPanel.setBackground(new Color(31, 31, 31));

//         for (String[] restaurant : restaurants) {
//             JButton restaurantButton = new JButton("<html><b>" + restaurant[0] + "</b><br>" + restaurant[1] + "</html>");
//             restaurantButton.setPreferredSize(new Dimension(250, 100));
//             restaurantButton.setBackground(new Color(43, 43, 43));
//             restaurantButton.setForeground(new Color(255, 169, 140));
//             restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//             restaurantButton.setFocusPainted(false);
//             restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

//             // Add action listener to navigate to menu page
//             restaurantButton.addActionListener(evt -> showMenu(restaurant[0]));

//             restaurantsPanel.add(restaurantButton);
//         }

//         restaurant.add(restaurantsPanel, "RestaurantsPage");

//         jPanel3.add(restaurant);

//         // Menu page
//         menu = new JPanel();
//         menu.setBackground(new Color(31, 31, 31));
//         menu.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));        

//         // menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
//         menu.setAlignmentX(Component.LEFT_ALIGNMENT);
//         menu.setAlignmentY(Component.TOP_ALIGNMENT);
//         menu.setPreferredSize(new Dimension(700, 670));
//         menu.setMaximumSize(new Dimension(700, 670));
//         Main.add(menu);

        



//         Main.add(jPanel3);

//         jPanel1.add(Main);
//         Main.setBounds(0, 0, 1300, 700);

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

//         pack();

//         restaurantsPanel.setVisible(true);
//         menu.setVisible(false);
    

//     }

// // test back button
//     private void showMenu(String restaurantName) {
//         restaurantsPanel.setVisible(false);
//         menu.setVisible(true);
//         menu.removeAll(); // Clear previous menu

//         // Set BoxLayout to stack components vertically
//         menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

//         // Title
//         // JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.CENTER);
//         // titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         // titleLabel.setForeground(new Color(255, 169, 140));
//         // titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         // menu.add(titleLabel);

//         // JButton backButton = new JButton("Back");
//         // backButton.setPreferredSize(new Dimension(150, 40));
//         // backButton.setBackground(new Color(43, 43, 43));
//         // backButton.setForeground(new Color(255, 169, 140));
//         // backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         // backButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
//         // backButton.addActionListener(evt -> {
//         //     menu.setVisible(false);
//         //     restaurantsPanel.setVisible(true);
//         // });
//         // menu.add(backButton);
//         // Panel to hold the titleLabel and backButton in one horizontal line
//         JPanel headerPanel = new JPanel();
//         headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS)); // Horizontal layout
//         headerPanel.setBackground(new Color(31, 31, 31)); // Match the background color of the main menu panel

//         headerPanel.setPreferredSize(new Dimension(700, 50)); // Set the preferred size (width: 800px, height: 50px)
//         headerPanel.setMinimumSize(new Dimension(700, 50));   // Optional: Ensure the panel is never smaller than this size
//         headerPanel.setMaximumSize(new Dimension(700, 50));
//         // Title Label
//         JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.LEFT); // Align text to the left
//         titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         titleLabel.setForeground(new Color(255, 169, 140));
//         titleLabel.setAlignmentY(Component.CENTER_ALIGNMENT); // Align vertically in the middle
//         headerPanel.add(titleLabel); // Add to the horizontal panel

//         // Spacer between the title and the back button
//         headerPanel.add(Box.createHorizontalGlue()); // Push components to opposite ends

//         // Back Button
//         JButton backButton = new JButton("Back");
//         backButton.setPreferredSize(new Dimension(80, 40));
//         backButton.setBackground(new Color(43, 43, 43));
//         backButton.setForeground(new Color(255, 169, 140));
//         backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         backButton.setAlignmentY(Component.CENTER_ALIGNMENT); // Align vertically in the middle
//         backButton.addActionListener(evt -> {
//             menu.setVisible(false);
//             restaurantsPanel.setVisible(true);
//         });
//         headerPanel.add(backButton); // Add to the horizontal panel

//         // Add the headerPanel to the menu panel
//         menu.add(headerPanel);

        

//         // Spacer after title
//         menu.add(Box.createRigidArea(new Dimension(0, 20)));

//         // Menu items
//         String[][] foods = restaurantMenus.get(restaurantName);
//         if (foods != null) {
//             // Panel to hold all food cards
//             JPanel menuGrid = new JPanel();
//             menuGrid.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//             menuGrid.setPreferredSize(new Dimension(700, 700));

//             menuGrid.setBackground(new Color(31, 31, 31));

//             for (String[] food : foods) {
//                 JPanel foodCard = new JPanel();
//                 foodCard.setLayout(new BorderLayout());
//                 foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//                 foodCard.setBackground(Color.WHITE);
//                 foodCard.setPreferredSize(new Dimension(200, 150));

//                 JButton nameButton = new JButton(food[0]);
//                 nameButton.setForeground(Color.BLACK);
//                 nameButton.setBackground(Color.WHITE);

//                 JButton descriptionButton = new JButton("<html><small>" + food[1] + "</small></html>");
//                 descriptionButton.setForeground(Color.DARK_GRAY);
//                 descriptionButton.setBackground(Color.WHITE);

//                 JButton weightPriceButton = new JButton(food[2] + " | " + food[3]);
//                 weightPriceButton.setForeground(Color.BLACK);
//                 weightPriceButton.setBackground(Color.WHITE);

//                 foodCard.add(nameButton, BorderLayout.NORTH);
//                 foodCard.add(descriptionButton, BorderLayout.CENTER);
//                 foodCard.add(weightPriceButton, BorderLayout.SOUTH);

//                 menuGrid.add(foodCard);
//             }

//             // Wrap the menu grid in a scroll pane
//             JScrollPane scrollPane = new JScrollPane(menuGrid);
//             scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//             scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//             scrollPane.setBorder(BorderFactory.createEmptyBorder());
//             scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
//             scrollPane.setPreferredSize(new Dimension(800, 400)); // Adjust size as needed
//             menu.add(scrollPane);

            
//         }

        

        

        
//     }

    



//     // private void showMenu(String restaurantName) {
//     //     restaurantsPanel.setVisible(false);
//     //     menu.setVisible(true);
//     //     menu.removeAll(); // Clear previous menu

//     //     // Title
//     //     JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.CENTER);
//     //     titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//     //     titleLabel.setForeground(new Color(255, 169, 140));
//     //     titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//     //     menu.add(titleLabel);

//     //     // Menu items
//     //     String[][] foods = restaurantMenus.get(restaurantName);
//     //     if (foods != null) {
//     //         // JPanel menuGrid = new JPanel(new GridLayout(0, 2, 50, 50));
//     //         JPanel menuGrid = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
//     //         menuGrid.setBackground(new Color(31, 31, 31));

//     //         for (String[] food : foods) {
//     //             JPanel foodCard = new JPanel();
//     //             foodCard.setLayout(new BorderLayout());
//     //             foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//     //             foodCard.setBackground(Color.WHITE);
//     //             foodCard.setPreferredSize(new Dimension(200, 150));

//     //             JButton nameButton = new JButton(food[0]);
//     //             nameButton.setForeground(Color.BLACK);
//     //             nameButton.setBackground(Color.WHITE);

//     //             JButton descriptionButton = new JButton("<html><small>" + food[1] + "</small></html>");
//     //             descriptionButton.setForeground(Color.DARK_GRAY);
//     //             descriptionButton.setBackground(Color.WHITE);

//     //             JButton weightPriceButton = new JButton(food[2] + " | " + food[3]);
//     //             weightPriceButton.setForeground(Color.BLACK);
//     //             weightPriceButton.setBackground(Color.WHITE);

//     //             foodCard.add(nameButton, BorderLayout.NORTH);
//     //             foodCard.add(descriptionButton, BorderLayout.CENTER);
//     //             foodCard.add(weightPriceButton, BorderLayout.SOUTH);

//     //             menuGrid.add(foodCard);
//     //         }

//     //         menu.add(menuGrid);
//     //     }

//     //     // Back button
//     //     JButton backButton = new JButton("Back");
//     //     backButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
//     //     backButton.setPreferredSize(new Dimension(150, 40));
//     //     backButton.setBackground(new Color(43, 43, 43));
//     //     backButton.setForeground(new Color(255, 169, 140));
//     //     backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//     //     // backButton.addActionListener(evt -> showRestaurantsPage());
//     //     backButton.addActionListener(evt -> {
//     //         menu.setVisible(false);
//     //         restaurantsPanel.setVisible(true);
//     //     });
//     //     menu.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
//     //     menu.add(backButton);


        

//     //     // Show menu page
//     //     // CardLayout cl = (CardLayout) Main.getLayout();
//     //     // cl.show(Main, "MenuPage");

//     //     // menu.revalidate();
//     //     // menu.repaint();
//     // }

// //     JScrollPane scrollPane = new JScrollPane(menu);
// // Main.add(scrollPane);

    

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
//     private javax.swing.JPanel margin2;
//     private javax.swing.JPanel margin3;
//     private javax.swing.JLabel systemName;
//     private javax.swing.JPanel title_container;
//     private javax.swing.JLabel title;
//     private javax.swing.JPanel jPanel2;
//     private javax.swing.JPanel jPanel3;
//     private javax.swing.JPanel menu;
//     private javax.swing.JPanel restaurant;
//     private javax.swing.JPanel restaurantsPanel;
//     private javax.swing.JLabel welcome;
//     private javax.swing.JLabel customer_username;
//     private javax.swing.JButton btn_Noti;
//     private javax.swing.JPanel m5;
//     private javax.swing.JPanel margin1;
    

// }

