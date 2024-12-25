package oodj.food_ordering_system.designUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class RestaurantApp extends javax.swing.JFrame {

    // Restaurants and menu data
    String[][] restaurants = {
        {"Burger Heaven", "Best burgers in town"},
        {"Pasta Paradise", "Authentic Italian pasta"},
        {"Sushi World", "Fresh and delicious sushi"}
    };

    HashMap<String, String[][]> restaurantMenus = new HashMap<>() {{
        put("Burger Heaven", new String[][] {
            {"Cheeseburger", "Tasty beef with cheese", "200g", "$5"},
            {"Bacon Burger", "Crispy bacon delight", "220g", "$6"}
        });
        put("Pasta Paradise", new String[][] {
            {"Spaghetti Bolognese", "Rich meat sauce", "300g", "$8"},
            {"Penne Alfredo", "Creamy Alfredo sauce", "250g", "$7"}
        });
        put("Sushi World", new String[][] {
            {"California Roll", "Classic sushi roll", "200g", "$10"},
            {"Salmon Nigiri", "Fresh salmon on rice", "150g", "$12"}
        });
    }};

    // Panels
    private JPanel restaurantsPanel;
    private JPanel menu;

    public RestaurantApp() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        Sidebar = new javax.swing.JPanel();
        // btn_container1 = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();
        btn_cart = new javax.swing.JButton();
        btn_history = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        Line = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();

        // Frame settings
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Sidebar
        Sidebar.setBackground(new java.awt.Color(31, 31, 31));
        Sidebar.setPreferredSize(new java.awt.Dimension(300, 670));
        Sidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));

        // Sidebar buttons
        btn_home.setText("Home");
        btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_home.setBackground(new java.awt.Color(43, 43, 43));
        btn_home.setForeground(new java.awt.Color(255, 169, 140));
        btn_home.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18));
        btn_home.setFocusable(false);
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sidebar.add(btn_home);

        btn_menu.setText("Menu");
        btn_menu.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_menu.setBackground(new java.awt.Color(31, 31, 31));
        btn_menu.setForeground(new java.awt.Color(245, 251, 254));
        btn_menu.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
        btn_menu.setFocusable(false);
        btn_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_menu.addActionListener(evt -> showRestaurantsPage());
        Sidebar.add(btn_menu);

        btn_cart.setText("Cart");
        btn_cart.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_cart.setBackground(new java.awt.Color(31, 31, 31));
        btn_cart.setForeground(new java.awt.Color(245, 251, 254));
        btn_cart.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
        btn_cart.setFocusable(false);
        btn_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sidebar.add(btn_cart);

        btn_history.setText("Order History");
        btn_history.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_history.setBackground(new java.awt.Color(31, 31, 31));
        btn_history.setForeground(new java.awt.Color(245, 251, 254));
        btn_history.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
        btn_history.setFocusable(false);
        btn_history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sidebar.add(btn_history);

        btn_logout.setText("Logout");
        btn_logout.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_logout.setBackground(new java.awt.Color(31, 31, 31));
        btn_logout.setForeground(new java.awt.Color(245, 251, 254));
        btn_logout.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18));
        btn_logout.setFocusable(false);
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sidebar.add(btn_logout);

        // Divider line
        Line.setBackground(new java.awt.Color(50, 50, 50));
        Line.setPreferredSize(new java.awt.Dimension(2, 670));

        // Main panel with CardLayout
        Main.setLayout(new CardLayout());
        Main.setPreferredSize(new java.awt.Dimension(700, 670));

        // Restaurants page
        restaurantsPanel = new JPanel();
        restaurantsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));
        restaurantsPanel.setBackground(new Color(31, 31, 31));

        for (String[] restaurant : restaurants) {
            JButton restaurantButton = new JButton("<html><b>" + restaurant[0] + "</b><br>" + restaurant[1] + "</html>");
            restaurantButton.setPreferredSize(new Dimension(300, 100));
            restaurantButton.setBackground(new Color(43, 43, 43));
            restaurantButton.setForeground(new Color(255, 169, 140));
            restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
            restaurantButton.setFocusPainted(false);
            restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Add action listener to navigate to menu page
            restaurantButton.addActionListener(evt -> showMenu(restaurant[0]));

            restaurantsPanel.add(restaurantButton);
        }

        Main.add(restaurantsPanel, "RestaurantsPage");

        // Menu page
        menu = new JPanel();
        menu.setBackground(new Color(31, 31, 31));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        Main.add(menu, "MenuPage");

        // Add components to main container
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(Sidebar, BorderLayout.WEST);
        jPanel1.add(Line, BorderLayout.CENTER);
        jPanel1.add(Main, BorderLayout.EAST);

        getContentPane().add(jPanel1);

        pack();
    }

    private void showRestaurantsPage() {
        CardLayout cl = (CardLayout) Main.getLayout();
        cl.show(Main, "RestaurantsPage");
    }

    private void showMenu(String restaurantName) {
        menu.removeAll(); // Clear previous menu

        // Title
        JLabel titleLabel = new JLabel(restaurantName + " Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 169, 140));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(titleLabel);

        // Menu items
        String[][] foods = restaurantMenus.get(restaurantName);
        if (foods != null) {
            JPanel menuGrid = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
            menuGrid.setBackground(new Color(31, 31, 31));

            for (String[] food : foods) {
                JPanel foodCard = new JPanel();
                foodCard.setLayout(new BorderLayout());
                foodCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                foodCard.setBackground(Color.WHITE);
                foodCard.setPreferredSize(new Dimension(200, 150));

                JButton nameButton = new JButton(food[0]);
                nameButton.setForeground(Color.BLACK);
                nameButton.setBackground(Color.WHITE);

                JButton descriptionButton = new JButton("<html><small>" + food[1] + "</small></html>");
                descriptionButton.setForeground(Color.DARK_GRAY);
                descriptionButton.setBackground(Color.WHITE);

                JButton weightPriceButton = new JButton(food[2] + " | " + food[3]);
                weightPriceButton.setForeground(Color.BLACK);
                weightPriceButton.setBackground(Color.WHITE);

                foodCard.add(nameButton, BorderLayout.NORTH);
                foodCard.add(descriptionButton, BorderLayout.CENTER);
                foodCard.add(weightPriceButton, BorderLayout.SOUTH);

                menuGrid.add(foodCard);
            }

            menu.add(menuGrid);
        }

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setPreferredSize(new Dimension(150, 40));
        backButton.setBackground(new Color(43, 43, 43));
        backButton.setForeground(new Color(255, 169, 140));
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backButton.addActionListener(evt -> showRestaurantsPage());
        menu.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        menu.add(backButton);

        // Show menu page
        CardLayout cl = (CardLayout) Main.getLayout();
        cl.show(Main, "MenuPage");

        menu.revalidate();
        menu.repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RestaurantApp().setVisible(true));
    }

    private javax.swing.JPanel Line;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Main;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_cart;
    private javax.swing.JButton btn_history;
    private javax.swing.JButton btn_logout;
    private javax.swing.JPanel jPanel1;
}
