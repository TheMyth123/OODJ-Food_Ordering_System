package oodj.food_ordering_system.designUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.json.JSONArray;
import oodj.food_ordering_system.utils.VendorHandling;

public class VendorRevenueDashboardPopup extends JPanel {
    private String vendorId;
    
    public VendorRevenueDashboardPopup(String vendorId) {
        this.vendorId = vendorId;
        // Disable lightweight popups so the combo box dropdown shows correctly over the glass pane
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        
        setBackground(new Color(31, 31, 31));
        setPreferredSize(new Dimension(350, 120));
        placeComponents();
    }
    
    private void placeComponents() {
        // Use a layout manager; if you need absolute positioning, ensure there's enough space.
        setLayout(null);
    
        JLabel periodLabel = new JLabel("Select Period:");
        periodLabel.setBounds(10, 20, 150, 25);
        periodLabel.setForeground(new Color(255, 165, 0)); // Orange
        add(periodLabel);
    
        String[] periods = {"Daily", "Monthly", "Quarterly"};
        JComboBox<String> periodDropdown = new JComboBox<>(periods);
        periodDropdown.setBounds(150, 20, 150, 25);
        add(periodDropdown);
    
        JButton checkButton = new JButton("Check History");
        checkButton.setBounds(150, 60, 150, 25);
        add(checkButton);
    
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPeriod = (String) periodDropdown.getSelectedItem();
                JSONArray history = VendorHandling.getVendorOrderHistory(vendorId, selectedPeriod);
                VendorHandling.createRevenueChart(history);
            }
        });
    }
}
