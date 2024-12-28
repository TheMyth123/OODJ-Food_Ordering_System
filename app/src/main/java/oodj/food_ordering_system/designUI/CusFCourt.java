package oodj.food_ordering_system.designUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import oodj.food_ordering_system.models.Vendor;
import oodj.food_ordering_system.utils.UserHandling;

public class CusFCourt extends javax.swing.JFrame {

    private JPanel mainPanel;
    private JPanel restaurantListPanel;
    // private int vendorID;
    

    public CusFCourt() {
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel(new CardLayout());
        restaurantListPanel = new JPanel();
        restaurantListPanel.setLayout(new GridLayout(0, 2, 50, 50)); // 2 columns, dynamic rows, 50px horizontal and vertical gaps
        restaurantListPanel.setBackground(new Color(31, 31, 31));
// TODO check again what error
        List<Vendor> vendors = UserHandling.getVendors();
        for (Vendor vendor : vendors) {
            String foodCourtName = vendor.getFoodCourtName();
            String vendorID = vendor.getID();
            JButton restaurantButton = new JButton("<html><b>" + foodCourtName + "</b><br></html>");
            restaurantButton.setPreferredSize(new Dimension(250, 100));
            restaurantButton.setBackground(new Color(43, 43, 43));
            restaurantButton.setForeground(new Color(255, 169, 140));
            restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
            restaurantButton.setFocusPainted(false);
            restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Add action listener to navigate to menu page
            restaurantButton.addActionListener(evt -> {
                new CusMenu(vendorID).setVisible(true);
            });

            // restaurantButton.addActionListener(evt -> {
            //     // JFrame menuFrame = new JFrame("Restaurant Menu");
            //     CusMenu menuPanel = new CusMenu(vendorID);
            //     menuFrame.add(menuPanel);
            //     menuFrame.setSize(800, 500);
            //     menuFrame.setLocationRelativeTo(null);
            //     menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //     menuFrame.setVisible(true);
            // });

            restaurantListPanel.add(restaurantButton);
        }

        mainPanel.add(restaurantListPanel, "RestaurantListPanel");
        add(mainPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}