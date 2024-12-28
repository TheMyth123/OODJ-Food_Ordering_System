package oodj.food_ordering_system.designUI;

import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;
// TODO import dialog box after added cart
// import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.OrderHandling;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// quantity calculation error
public class CusMenu extends javax.swing.JFrame {

    private JPanel menuPanel;
    // private Map<String, String[][]> restaurantMenus;
    // private static String restaurantName;
    private String[] selectedItem;
    private List<String[]> cart;
    private JPanel selectedItemPanel;
    private String customerID;
    private Map<String, Integer> itemQuantities;

    // private static String vendorID;
    
    
    
    public CusMenu(String vendorID) {
        this.customerID = LoginPage.getLoginID();

        cart = new ArrayList<>();
        selectedItemPanel = null;
        selectedItem = null;
        // CusMenu.vendorID = vendorID;
        itemQuantities = new HashMap<>();


        initComponents(vendorID);
    }

    // TODO check again
    private void addToCart() {
        String filePath = FileHandling.filePath.CART_PATH.getValue();
        JSONArray cartArray = new JSONArray();

        // Read existing cart items from the file
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            if (!content.isEmpty()) {
                cartArray = new JSONArray(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add new items to the cart array
        for (String[] item : cart) {
            if (item.length < 6) {
                System.err.println("Invalid item array length: " + item.length);
                continue;
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("MenuID", item[0]);
            jsonObject.put("CustomerID", customerID); // Use the customerID field
            jsonObject.put("name", item[1]);
            jsonObject.put("description", item[2]);
            jsonObject.put("quantity", item[3]);
            jsonObject.put("price", item[4]);
            jsonObject.put("imagePath", item[5]);

            cartArray.put(jsonObject);
        }

        // Write the updated cart array back to the file
        FileHandling.saveToFile(cartArray, filePath);
        cart.clear();
    }

    
    private void initComponents(String vendorID) {
        menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBackground(new Color(31, 31, 31));

        
        wrapper = new javax.swing.JPanel();
        back_icon = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        m2 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        m3 = new javax.swing.JPanel();
        
        addContainer = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
    
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
        title.setText("Menu");
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
        // JPanel itemsPanel = new JPanel();
        // itemsPanel.setLayout(new GridLayout(0, 2, 10, 10));
        // itemsPanel.setBackground(new Color(31, 31, 31));

        // String[][] menuItems = restaurantMenus.get(restaurantName);
        // if (menuItems != null) {
        //     for (String[] item : menuItems) {
        //         JPanel itemPanel = new JPanel();
        //         itemPanel.setLayout(new BorderLayout());
        //         itemPanel.setBackground(new Color(43, 43, 43));
        //         itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //         itemPanel.setPreferredSize(new Dimension(300, 100));

        //         JLabel itemLabel = new JLabel("<html><b>" + item[0] + "</b><br>" + item[1] + "<br>Weight: " + item[2] + "<br>Price: " + item[3] + "</html>");
        //         itemLabel.setForeground(new Color(255, 169, 140));
        //         itemLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //         itemPanel.add(itemLabel, BorderLayout.CENTER);

        //         itemPanel.addMouseListener(new MouseAdapter() {
        //             @Override
        //             public void mouseClicked(MouseEvent e) {
        //                 // Deselect previously selected item
        //                 if (selectedItemPanel != null) {
        //                     selectedItemPanel.setBackground(new Color(43, 43, 43));
        //                 }


        //                 selectedItem = item;
        //                 selectedItemPanel = itemPanel;
        //                 itemPanel.setBackground(new Color(63, 63, 63));
        //             }
        //         });


        //         itemsPanel.add(itemPanel);
        //     }
        // }

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(0, 2, 10, 10));
        itemsPanel.setBackground(new Color(31, 31, 31));

        try {
            List<JSONObject> menuItems = OrderHandling.readMenuFile(vendorID);
            for (JSONObject item : menuItems) {
                JPanel itemPanel = new JPanel();
                itemPanel.setLayout(new BorderLayout());
                itemPanel.setBackground(new Color(43, 43, 43));
                itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                itemPanel.setPreferredSize(new Dimension(300, 100));

                JLabel itemLabel = new JLabel("<html><b>" + item.getString("name") + "</b><br>" + item.getString("description") +  "<br>Price: " + item.getString("price") + "</html>");
                itemLabel.setForeground(new Color(255, 169, 140));
                itemLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                itemPanel.add(itemLabel, BorderLayout.CENTER);

                itemPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // Deselect previously selected item
                        if (selectedItemPanel != null) {
                            selectedItemPanel.setBackground(new Color(43, 43, 43));
                        }

                        selectedItem = new String[] { item.getString("id"), item.getString("name"), item.getString("description"), item.getString("price"), item.getString("imagePath") };
                        selectedItemPanel = itemPanel;
                        itemPanel.setBackground(new Color(63, 63, 63));
                    }
                });

                itemsPanel.add(itemPanel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        menuPanel.add(itemsPanel, BorderLayout.CENTER);
        
        wrapper.add(menuPanel);
    
        addContainer.setBackground(new java.awt.Color(25, 25, 25));
        addContainer.setMaximumSize(new java.awt.Dimension(800, 40));
        addContainer.setMinimumSize(new java.awt.Dimension(800, 40));
        addContainer.setPreferredSize(new java.awt.Dimension(800, 50));
        addContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));
    
        addButton.setBackground(new java.awt.Color(255, 169, 140));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(31, 31, 31));
        addButton.setText("Add to Cart");
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setMargin(null);
        addButton.setMaximumSize(new java.awt.Dimension(200, 40));
        addButton.setMinimumSize(new java.awt.Dimension(200, 40));
        addButton.setPreferredSize(new java.awt.Dimension(170, 40));
        // addButton.addActionListener(evt -> {
        //     if (selectedItem != null) {
        //         cart.add(selectedItem);
        //         selectedItem = null;
        //         if (selectedItemPanel != null) {
        //             selectedItemPanel.setBackground(new Color(43, 43, 43));
        //             selectedItemPanel = null;

        //         }
        //         addToCart();
        //         JOptionPane.showMessageDialog(this, "Selected item added to cart.");

        //     } else {
        //         JOptionPane.showMessageDialog(this, "No item selected.");
        //     }
        // });

        addButton.addActionListener(evt -> {
            if (selectedItem != null) {
                String itemId = selectedItem[0];
                int currentQuantity = itemQuantities.getOrDefault(itemId, 0) + 1;
                itemQuantities.put(itemId, currentQuantity);
                String quantity = String.valueOf(currentQuantity);
                selectedItem = new String[] { selectedItem[0], selectedItem[1], selectedItem[2], quantity, selectedItem[3], selectedItem[4] };
                cart.add(selectedItem);
                selectedItem = null;
                if (selectedItemPanel != null) {
                    selectedItemPanel.setBackground(new Color(43, 43, 43));
                    selectedItemPanel = null;
                }
                addToCart();
                JOptionPane.showMessageDialog(this, "Selected item added to cart.");
            } else {
                JOptionPane.showMessageDialog(this, "No item selected.");
            }
        });

        addContainer.add(addButton);
    
        wrapper.add(addContainer);
        
        getContentPane().add(wrapper);
        wrapper.setBounds(0, 0, 800, 500);
    
        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
        }// </editor-fold>    
    
        private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
            dispose();
        } 
    
        public List<String[]> getCart() {
            return cart;
        }
        // TODO remove this 
        // public static void main(String[] args) {
            
        //     java.awt.EventQueue.invokeLater(() -> {
        //         JFrame frame = new JFrame("Restaurant Menu");
            
    
        //         CusMenu menuPanel = new CusMenu(OrderHandling.readMenuFile(vendorID));
        //     frame.add(menuPanel);
        // });
        // }

  
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel back_icon;
   
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JPanel m3;
  
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addContainer;
    private javax.swing.JLabel title;
 
    private javax.swing.JPanel wrapper;
    // End of variables declaration                   
}