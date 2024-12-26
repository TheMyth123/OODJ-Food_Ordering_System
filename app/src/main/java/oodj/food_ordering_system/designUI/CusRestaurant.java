package oodj.food_ordering_system.designUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CusRestaurant extends javax.swing.JFrame {

    private JPanel mainPanel;
    private JPanel restaurantListPanel;
    private String restaurantName;
    private String[][] restaurants = {
        {"Burger Heaven", "Best burgers in town"},
        {"Pasta Paradise", "Authentic Italian pasta"},
        {"Sushi World", "Fresh and delicious sushi"},
        {"Pizza Planet", "Out of this world pizza"},
        {"Taco Town", "Tasty tacos and more"},
        {"Salad Station", "Fresh and healthy salads"}
    };

    public CusRestaurant() {
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel(new CardLayout());
        restaurantListPanel = new JPanel();
        restaurantListPanel.setLayout(new GridLayout(0, 2, 50, 50)); // 2 columns, dynamic rows, 50px horizontal and vertical gaps
        restaurantListPanel.setBackground(new Color(31, 31, 31));

        for (String[] restaurant : restaurants) {
            JButton restaurantButton = new JButton("<html><b>" + restaurant[0] + "</b><br>" + restaurant[1] + "</html>");
            restaurantButton.setPreferredSize(new Dimension(250, 100));
            restaurantButton.setBackground(new Color(43, 43, 43));
            restaurantButton.setForeground(new Color(255, 169, 140));
            restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
            restaurantButton.setFocusPainted(false);
            restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Add action listener to navigate to menu page
            restaurantButton.addActionListener(evt -> {
                new CusMenu(restaurantName).setVisible(true);
                
            });

            restaurantListPanel.add(restaurantButton);
        }

        mainPanel.add(restaurantListPanel, "RestaurantListPanel");
        add(mainPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}