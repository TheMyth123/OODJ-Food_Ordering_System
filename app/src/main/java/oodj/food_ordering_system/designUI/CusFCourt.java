package oodj.food_ordering_system.designUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import oodj.food_ordering_system.models.Vendor;
import oodj.food_ordering_system.utils.UserHandling;

public class CusFCourt extends javax.swing.JFrame {

    private JPanel mainPanel;
    private static JPanel restaurantListPanel;
        
        
    
    public CusFCourt() {
        initComponents();
    }

    // private void initComponents() {
    //     mainPanel = new JPanel(new CardLayout());
    //     restaurantListPanel = new JPanel();
    //     restaurantListPanel.setLayout(new GridLayout(0, 3, 50, 50)); // 2 columns, dynamic rows, 50px horizontal and vertical gaps
    //     restaurantListPanel.setBackground(new Color(31, 31, 31));
    //     restaurantListPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0)); // 50px top gap, 0px left, bottom, and right gaps

        
    //     // TODO check again what error
    //     List<Vendor> vendors = UserHandling.getVendors();
    //     for (Vendor vendor : vendors) {
    //         String foodCourtName = vendor.getFoodCourtName();
    //         String vendorID = vendor.getID();
    //         JButton restaurantButton = new JButton("<html><b>" + foodCourtName + "</b><br></html>");
    //         restaurantButton.setPreferredSize(new Dimension(250, 100));
    //         restaurantButton.setBackground(new Color(43, 43, 43));
    //         restaurantButton.setForeground(new Color(255, 169, 140));
    //         restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
    //         restaurantButton.setFocusPainted(false);
    //         restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    //         // Add action listener to navigate to menu page
    //         restaurantButton.addActionListener(evt -> {
    //             new CusMenu(vendorID).setVisible(true);
    //         });

            

    //         restaurantListPanel.add(restaurantButton);
    //     }

    //     mainPanel.add(restaurantListPanel, "RestaurantListPanel");
    //     add(mainPanel);
    // }

    // private void initComponents() {
    //     mainPanel = new JPanel(new CardLayout());
    //     restaurantListPanel = new JPanel();
    //     restaurantListPanel.setLayout(new GridLayout(0, 3, 50, 50)); // 3 columns, dynamic rows, 50px horizontal and vertical gaps
    //     restaurantListPanel.setBackground(new Color(31, 31, 31));
    //     restaurantListPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0)); // 50px top gap, 0px left, bottom, and right gaps
    
    //     // TODO check again what error
    //     List<Vendor> vendors = UserHandling.getVendors();
    //     for (Vendor vendor : vendors) {
    //         String foodCourtName = vendor.getFoodCourtName();
    //         String vendorID = vendor.getID();
    //         JButton restaurantButton = new JButton("<html><b>" + foodCourtName + "</b><br></html>");
    //         restaurantButton.setPreferredSize(new Dimension(250, 100));
    //         restaurantButton.setBackground(new Color(43, 43, 43));
    //         restaurantButton.setForeground(new Color(255, 169, 140));
    //         restaurantButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
    //         restaurantButton.setFocusPainted(false);
    //         restaurantButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
    //         // Add action listener to navigate to menu page
    //         restaurantButton.addActionListener(evt -> {
    //             new CusMenu(vendorID).setVisible(true);
    //         });
    
    //         restaurantListPanel.add(restaurantButton);
    //     }
    
    //     JScrollPane scrollPane = new JScrollPane(restaurantListPanel);
    //     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    //     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    //     scrollPane.setOpaque(false);
    //     scrollPane.getViewport().setOpaque(false);
    //     scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
    //     mainPanel.add(scrollPane, "RestaurantListPanel");
    //     add(mainPanel);
    // }

    private void initComponents() {
        mainPanel = new JPanel(new CardLayout());
        restaurantListPanel = new JPanel();
        restaurantListPanel.setLayout(new GridLayout(0, 3, 50, 50)); // 3 columns, dynamic rows
        restaurantListPanel.setBackground(new Color(31, 31, 31));
        restaurantListPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0)); // Padding
    
        // ✅ Retrieve and filter vendors with status true
        List<Vendor> vendors = UserHandling.getVendors().stream()
                .filter(Vendor::getStatus) // ✅ Only include vendors with status true
                .collect(Collectors.toList());
    
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
    
            restaurantListPanel.add(restaurantButton);
        }
    
        JScrollPane scrollPane = new JScrollPane(restaurantListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        mainPanel.add(scrollPane, "RestaurantListPanel");
        add(mainPanel);
    }
    

        
    
    
    public JPanel getMainPanel() {
        return mainPanel;
    }

    // public static void displayVendors(List<Vendor> filteredVendors) {
    //     restaurantListPanel.removeAll(); // Clear previous results

    // for (Vendor vendor : filteredVendors) {
    //     JButton vendorButton = new JButton("<html><b>" + vendor.getFoodCourtName() + "</b></html>");
    //     vendorButton.setPreferredSize(new Dimension(250, 100));
    //     vendorButton.setBackground(new Color(43, 43, 43));
    //     vendorButton.setForeground(new Color(255, 169, 140));
    //     vendorButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
    //     vendorButton.setFocusPainted(false);
    //     vendorButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    //     // Button action to open the selected food court menu
    //     vendorButton.addActionListener(evt -> new CusMenu(vendor.getID()).setVisible(true));

    //     restaurantListPanel.add(vendorButton);
    // }

    // restaurantListPanel.revalidate(); // Ensure UI updates
    // restaurantListPanel.repaint();
    // }

    public static void displayVendors(List<Vendor> filteredVendors) {
        restaurantListPanel.removeAll(); // Clear previous results
    
        // ✅ Only show vendors with status true
        List<Vendor> activeVendors = filteredVendors.stream()
                .filter(Vendor::getStatus)
                .collect(Collectors.toList());
    
        for (Vendor vendor : activeVendors) {
            JButton vendorButton = new JButton("<html><b>" + vendor.getFoodCourtName() + "</b></html>");
            vendorButton.setPreferredSize(new Dimension(250, 100));
            vendorButton.setBackground(new Color(43, 43, 43));
            vendorButton.setForeground(new Color(255, 169, 140));
            vendorButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
            vendorButton.setFocusPainted(false);
            vendorButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
            // Button action to open the selected food court menu
            vendorButton.addActionListener(evt -> new CusMenu(vendor.getID()).setVisible(true));
    
            restaurantListPanel.add(vendorButton);
        }
    
        restaurantListPanel.revalidate(); // Ensure UI updates
        restaurantListPanel.repaint();
    }
    
    
}

