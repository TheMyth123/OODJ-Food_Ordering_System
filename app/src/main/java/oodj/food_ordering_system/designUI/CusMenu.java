
// public class FoodMenuWithImages {
//     public static void main(String[] args) {
//         // Food data with image file paths
//         String[][] foods = {
//             {"Hummus", "images/hummus.jpg", "200g", "$9.89"},
//             {"Chicken liver pate", "images/chicken_liver.jpg", "210g", "$8.69"},
//             {"Beef tartare", "images/beef_tartare.jpg", "210g", "$11.15"},
//             {"Salmon tartare", "images/salmon_tartare.jpg", "190g", "$15.99"},
//             {"Bruschetta with mozzarella", "images/bruschetta_mozzarella.jpg", "190g", "$6.55"},
//             {"Bruschetta with shrimps", "images/bruschetta_shrimps.jpg", "180g", "$12.56"}
//         };

//         // Create frame
//         JFrame frame = new JFrame("Food Menu");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(800, 600);

//         // Create panel for the food menu
//         JPanel foodPanel = new JPanel();
//         foodPanel.setLayout(new GridLayout(0, 3, 10, 10)); // Grid with 3 columns

//         for (String[] food : foods) {
//             JPanel foodCard = new JPanel();
//             foodCard.setLayout(new BorderLayout());
//             foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//             foodCard.setBackground(Color.WHITE);

//             // Food name
//             JLabel nameLabel = new JLabel(food[0], SwingConstants.CENTER);

//             // Food image
//             JLabel imageLabel = new JLabel();
//             ImageIcon foodImage = new ImageIcon(food[1]); // Path to the image file
//             Image scaledImage = foodImage.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
//             imageLabel.setIcon(new ImageIcon(scaledImage));

//             // Weight and price
//             JLabel weightPriceLabel = new JLabel(food[2] + " | " + food[3], SwingConstants.CENTER);

//             // Add quantity panel
//             JPanel quantityPanel = new JPanel();
//             quantityPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//             JButton minusButton = new JButton("-");
//             JLabel quantityLabel = new JLabel("0");
//             JButton plusButton = new JButton("+");

//             // Action listeners for buttons
//             plusButton.addActionListener(e -> {
//                 int quantity = Integer.parseInt(quantityLabel.getText());
//                 quantityLabel.setText(String.valueOf(quantity + 1));
//             });
//             minusButton.addActionListener(e -> {
//                 int quantity = Integer.parseInt(quantityLabel.getText());
//                 if (quantity > 0) {
//                     quantityLabel.setText(String.valueOf(quantity - 1));
//                 }
//             });

//             quantityPanel.add(minusButton);
//             quantityPanel.add(quantityLabel);
//             quantityPanel.add(plusButton);

//             // Add components to the food card
//             foodCard.add(nameLabel, BorderLayout.NORTH);
//             foodCard.add(imageLabel, BorderLayout.CENTER);
//             foodCard.add(weightPriceLabel, BorderLayout.SOUTH);
//             foodCard.add(quantityPanel, BorderLayout.PAGE_END);

//             foodPanel.add(foodCard);
//         }

//         // Add scroll pane for better viewing
//         JScrollPane scrollPane = new JScrollPane(foodPanel);
//         frame.add(scrollPane);

//         frame.setVisible(true);
//     }
// }


package oodj.food_ordering_system.designUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class CusMenu extends javax.swing.JFrame {

    String[][] foods = {
        {"Hummus", "spinage, tomato, pita bread", "200g", "$9.89"},
        {"Chicken liver pate", "persimmon, toasts", "210g", "$8.69"},
        {"Beef tartare", "gherkins, toasts", "210g", "$11.15"},
        {"Salmon tartare", "avocado, toasts", "190g", "$15.99"},
        {"Bruschetta with mozzarella", "baked tomatoes, guacamole", "190g", "$6.55"},
        {"Bruschetta with shrimps", "tomatoes, avocado", "180g", "$12.56"}
    };


    public CusMenu() {
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
        m4 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        m7 = new javax.swing.JPanel();
        Button = new javax.swing.JButton();

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
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 320));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));
        // btn_container1.setLayout(new BoxLayout(btn_container1, BoxLayout.Y_AXIS));

        btn_home.setBackground(new java.awt.Color(31, 31, 31));
        btn_home.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(245, 251, 254));
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

        btn_menu.setBackground(new java.awt.Color(43, 43, 43));
        btn_menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(255, 169, 140));
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




        // Main.setBackground(new java.awt.Color(31, 31, 31));
        // Main.setAlignmentX(0.0F);
        // Main.setAlignmentY(0.0F);
        // Main.setMaximumSize(new java.awt.Dimension(1000, 670));
        // Main.setMinimumSize(new java.awt.Dimension(1000, 670));
        // Main.setPreferredSize(new java.awt.Dimension(1000, 670));
        // Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        

        Main.setBackground(new java.awt.Color(31, 31, 31));
        Main.setAlignmentX(0.0F);
        Main.setAlignmentY(0.0F);
        Main.setMaximumSize(new java.awt.Dimension(1000, 670));
        Main.setMinimumSize(new java.awt.Dimension(1000, 670));
        Main.setPreferredSize(new java.awt.Dimension(1000, 670));
        Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));


        // Add the credit bar above the title_container
        // JPanel creditBar = new JPanel(new BorderLayout());
        // creditBar.setBackground(new java.awt.Color(31, 31, 31)); // Light gray background

        // // TO DO add a line below the credit bar
        // creditBar.setPreferredSize(new java.awt.Dimension(1000, 50)); // Height of the bar

        // JLabel creditLabel = new JLabel("credit");
        // creditLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // Regular font, size 12
        // creditLabel.setForeground(new java.awt.Color(255, 169, 140));
        // creditLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        // creditLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Right margin
        // creditBar.add(creditLabel, BorderLayout.EAST);


        
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
        lineBelow.setBackground(java.awt.Color.GRAY); // Line color
        lineBelow.setPreferredSize(new java.awt.Dimension(1000, 1)); // 1px height for the line

        // Add the credit bar and the line below to the Main panel
        Main.add(creditBar); // Add the credit bar first
        Main.add(lineBelow); // Add the line directly below

        

        m4.setBackground(new java.awt.Color(31, 31, 31));
        m4.setMaximumSize(new java.awt.Dimension(1000, 50));
        m4.setMinimumSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout m4Layout = new javax.swing.GroupLayout(m4);
        m4.setLayout(m4Layout);
        m4Layout.setHorizontalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m4Layout.setVerticalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Main.add(m4);

        title_container.setBackground(new java.awt.Color(31, 31, 31));
        title_container.setMaximumSize(new java.awt.Dimension(1000, 50));
        title_container.setMinimumSize(new java.awt.Dimension(1000, 50));
        title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
        title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        title.setBackground(new java.awt.Color(31, 31, 31));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 169, 140));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Menu");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(200, 50));
        title.setMinimumSize(new java.awt.Dimension(200, 50));
        title.setPreferredSize(new java.awt.Dimension(200, 50));
        title_container.add(title);


        btn_menu.setBackground(new java.awt.Color(43, 43, 43));
        btn_menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(255, 169, 140));
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

        

        Main.add(title_container);

        jPanel2.setBackground(new java.awt.Color(31, 31, 31));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 30));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main.add(jPanel2);

        jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));        
        jPanel3.setBackground(new java.awt.Color(31, 31, 31));
        jPanel3.setMaximumSize(new java.awt.Dimension(800, 450));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 450));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 450));

        
        
        menu.setBackground(new java.awt.Color(31, 31, 31));
        menu.setMaximumSize(new java.awt.Dimension(800, 1500));
        menu.setMinimumSize(new java.awt.Dimension(800, 1500));
        menu.setPreferredSize(new java.awt.Dimension(800, 1500));
        jPanel3.add(menu);

        for (String[] food : foods) {
        // Configure the food card directly within the menu panel
        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the menu panel
        JPanel foodCard = new JPanel(); 

        foodCard.setLayout(new BorderLayout());
        foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        foodCard.setBackground(Color.WHITE);
        foodCard.setPreferredSize(new java.awt.Dimension(200, 150));
        // Food details
        JLabel nameLabel = new JLabel(food[0], SwingConstants.CENTER);
        nameLabel.setForeground(Color.BLACK);
        JLabel descriptionLabel = new JLabel("<html><small>" + food[1] + "</small></html>", SwingConstants.CENTER);
        descriptionLabel.setForeground(Color.DARK_GRAY);
        JLabel weightPriceLabel = new JLabel(food[2] + " | " + food[3], SwingConstants.CENTER);
        weightPriceLabel.setForeground(Color.BLACK);

        // Add quantity panel
        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton minusButton = new JButton("-");
        JLabel quantityLabel = new JLabel("0");
        JButton plusButton = new JButton("+");

        // Action listeners for buttons
        plusButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityLabel.getText());
            quantityLabel.setText(String.valueOf(quantity + 1));
        });
        minusButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityLabel.getText());
            if (quantity > 0) {
                quantityLabel.setText(String.valueOf(quantity - 1));
            }
        });

        quantityPanel.add(minusButton);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(plusButton);

        // Add components to the food card
        foodCard.add(nameLabel, BorderLayout.NORTH);
        foodCard.add(descriptionLabel, BorderLayout.CENTER);
        foodCard.add(weightPriceLabel, BorderLayout.SOUTH);
        foodCard.add(quantityPanel, BorderLayout.PAGE_END);

        // Add the food card directly to the menu panel
        menu.add(foodCard);
    }


        Main.add(jPanel3);

        m7.setBackground(new java.awt.Color(31, 31, 31));
        m7.setMaximumSize(new java.awt.Dimension(1000, 55));
        m7.setMinimumSize(new java.awt.Dimension(1000, 55));
        m7.setPreferredSize(new java.awt.Dimension(1000, 55));
        m7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 323, 0));

        Button.setBackground(new java.awt.Color(255, 169, 140));
        Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Button.setForeground(new java.awt.Color(31, 31, 31));
        Button.setText("Add to cart");

        Button.setBorder(null);
        Button.setBorderPainted(false);
        Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button.setFocusable(false);
        Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button.setMargin(null);
        Button.setMaximumSize(new java.awt.Dimension(250, 50));
        Button.setMinimumSize(new java.awt.Dimension(250, 50));
        Button.setPreferredSize(new java.awt.Dimension(250, 50));
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // ButtonActionPerformed(evt);
            }
        });
        m7.add(Button);
        Button.getAccessibleContext().setAccessibleName("Add to cart");

        Main.add(m7);

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
    }// </editor-fold>                        

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your button action logic here
        System.out.println("Button clicked!");
    }
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CusMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Button;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel m4;
    private javax.swing.JPanel m7;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin3;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel systemName;
    private javax.swing.JLabel title;
    private javax.swing.JPanel title_container;
    // End of variables declaration                   
}

