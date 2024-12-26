package oodj.food_ordering_system.designUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class CusMenu extends javax.swing.JFrame {

    private JPanel menuPanel;
    private Map<String, String[][]> restaurantMenus;
    private static String restaurantName;
    
        public CusMenu(String restaurantName) {
            initComponents(restaurantName);
        }
    
        
        private void initComponents(String restaurantName) {
            menuPanel = new JPanel();
            menuPanel.setLayout(new BorderLayout());
            menuPanel.setBackground(new Color(31, 31, 31));
    
            restaurantMenus = new HashMap<>();
    
            // Sample data for restaurant menus
            restaurantMenus.put("Burger Heaven", new String[][]{
                {"Classic Burger", "Juicy beef patty with lettuce, tomato, and cheese", "200g", ".99"},
                {"Cheese Burger", "Beef patty with double cheese", "220g", ".99"},
                {"Veggie Burger", "Grilled veggie patty with avocado", "180g", ".99"}
            });
    
            restaurantMenus.put("Pasta Paradise", new String[][]{
                {"Spaghetti Carbonara", "Classic Italian pasta with pancetta", "350g", ".99"},
                {"Lasagna", "Layered pasta with meat and cheese", "400g", ".99"},
                {"Penne Arrabbiata", "Pasta in a spicy tomato sauce", "300g", ".99"}
            });
    
            restaurantMenus.put("Sushi World", new String[][]{
                {"Salmon Sushi", "Fresh salmon on rice", "100g", ".99"},
                {"Tuna Sushi", "Fresh tuna on rice", "100g", ".99"},
                {"Eel Sushi", "Grilled eel on rice", "100g", ".99"}
            });
    
        wrapper = new javax.swing.JPanel();
        back_icon = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        m2 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        m3 = new javax.swing.JPanel();
        
        payContainer = new javax.swing.JPanel();
        payButton = new javax.swing.JButton();
    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 31, 31));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);
    
        wrapper.setBackground(new java.awt.Color(25, 25, 25));
        wrapper.setMaximumSize(new java.awt.Dimension(800, 500));
        wrapper.setMinimumSize(new java.awt.Dimension(800, 500));
        wrapper.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
    
        back_icon.setBackground(new java.awt.Color(25, 25, 25));
        back_icon.setMaximumSize(new java.awt.Dimension(800, 70));
        back_icon.setMinimumSize(new java.awt.Dimension(800, 70));
        back_icon.setPreferredSize(new java.awt.Dimension(800, 70));
        back_icon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
    
        m1.setBackground(new java.awt.Color(25, 25, 25));
        m1.setMaximumSize(new java.awt.Dimension(800, 10));
        m1.setMinimumSize(new java.awt.Dimension(800, 10));
        m1.setPreferredSize(new java.awt.Dimension(800, 10));
    
        javax.swing.GroupLayout m1Layout = new javax.swing.GroupLayout(m1);
        m1.setLayout(m1Layout);
        m1Layout.setHorizontalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        m1Layout.setVerticalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
    
        back_icon.add(m1);
    
        m2.setBackground(new java.awt.Color(25, 25, 25));
        m2.setMaximumSize(new java.awt.Dimension(10, 43));
        m2.setMinimumSize(new java.awt.Dimension(10, 43));
        m2.setPreferredSize(new java.awt.Dimension(10, 43));
    
        javax.swing.GroupLayout m2Layout = new javax.swing.GroupLayout(m2);
        m2.setLayout(m2Layout);
        m2Layout.setHorizontalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        m2Layout.setVerticalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );
    
        back_icon.add(m2);
    
        backBtn.setBackground(new java.awt.Color(25, 25, 25));
        backBtn.setForeground(new java.awt.Color(245, 251, 254));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backIcon.png"))); // NOI18N
        backBtn.setBorder(null);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        back_icon.add(backBtn);
    
        title.setBackground(new java.awt.Color(25, 25, 25));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 169, 140));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Pay By");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(694, 50));
        title.setMinimumSize(new java.awt.Dimension(694, 50));
        title.setPreferredSize(new java.awt.Dimension(694, 50));
        back_icon.add(title);
    
        wrapper.add(back_icon);
    
        m3.setBackground(new java.awt.Color(25, 25, 25));
        m3.setMaximumSize(new java.awt.Dimension(800, 30));
        m3.setMinimumSize(new java.awt.Dimension(800, 30));
        m3.setPreferredSize(new java.awt.Dimension(800, 20));
    
        javax.swing.GroupLayout m3Layout = new javax.swing.GroupLayout(m3);
        m3.setLayout(m3Layout);
        m3Layout.setHorizontalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        m3Layout.setVerticalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
    
        wrapper.add(m3);
    
        // test
    
        payContainer.setBackground(new java.awt.Color(25, 25, 25));
        payContainer.setMaximumSize(new java.awt.Dimension(800, 40));
        payContainer.setMinimumSize(new java.awt.Dimension(800, 40));
        payContainer.setPreferredSize(new java.awt.Dimension(800, 50));
        payContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
    
        payButton.setBackground(new java.awt.Color(255, 169, 140));
        payButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        payButton.setForeground(new java.awt.Color(31, 31, 31));
        payButton.setText("Pay");
        payButton.setBorder(null);
        payButton.setBorderPainted(false);
        payButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payButton.setFocusable(false);
        payButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payButton.setMargin(null);
        payButton.setMaximumSize(new java.awt.Dimension(200, 40));
        payButton.setMinimumSize(new java.awt.Dimension(200, 40));
        payButton.setPreferredSize(new java.awt.Dimension(170, 40));
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // payButtonActionPerformed(evt);
            }
        });
        payContainer.add(payButton);
    
        wrapper.add(payContainer);
    
        
    
        // Create a panel to display the menu items
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(0, 1, 10, 10));
        itemsPanel.setBackground(new Color(31, 31, 31));
    
        // Add menu items to the itemsPanel
        String[][] menuItems = restaurantMenus.get(restaurantName);
        if (menuItems != null) {
            for (String[] item : menuItems) {
                JLabel itemLabel = new JLabel("<html><b>" + item[0] + "</b><br>" + item[1] + "<br>Weight: " + item[2] + "<br>Price: " + item[3] + "</html>");
                itemLabel.setForeground(new Color(255, 169, 140));
                itemLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                itemsPanel.add(itemLabel);
            }
        }
    
        
        menuPanel.add(itemsPanel, BorderLayout.CENTER);
        
        wrapper.add(menuPanel);
    
    
        getContentPane().add(wrapper);
        wrapper.setBounds(0, 0, 800, 500);
    
        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
        }// </editor-fold>    
    
        private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
            dispose();
        } 
        public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(() -> {
                new CusMenu(restaurantName).setVisible(true); // Replace with a valid restaurant name
        });
    }

  
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel back_icon;
   
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JPanel m3;
  
    private javax.swing.JButton payButton;
    private javax.swing.JPanel payContainer;
    private javax.swing.JLabel title;
 
    private javax.swing.JPanel wrapper;
    // End of variables declaration                   
}