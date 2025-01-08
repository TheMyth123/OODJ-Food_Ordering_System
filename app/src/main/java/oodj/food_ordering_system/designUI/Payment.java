package oodj.food_ordering_system.designUI;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.utils.OrderHandling;

// TODO after payment successfull dispose the payment page
public class Payment extends javax.swing.JFrame {

    private String orderID;
    private String foodName;
    private String quantity;
    private String totalAmount;
    private JTextField addressField;
    private Credit credit;
    private String receiptImagePath;


    

    public Payment(String orderID, String foodName, String quantity, String totalAmount, Credit credit) {
        this.orderID = orderID;
        this.foodName = foodName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.credit = credit;
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        wrapper = new javax.swing.JPanel();
        back_icon = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        m2 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        m3 = new javax.swing.JPanel();
        m4 = new javax.swing.JPanel();
        payContainer = new javax.swing.JPanel();
        payButton = new javax.swing.JButton();
        m6 = new javax.swing.JPanel();

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
        m3.setMaximumSize(new java.awt.Dimension(800, 200));
        m3.setMinimumSize(new java.awt.Dimension(800, 200));
        m3.setPreferredSize(new java.awt.Dimension(800, 200));
        m3.setLayout(new BoxLayout(m3, BoxLayout.Y_AXIS));

// Food Name
        JLabel foodNameLabel = new JLabel("Food Name: " + foodName);
        foodNameLabel.setForeground(new Color(255, 169, 140));
        foodNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        foodNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(foodNameLabel);

        // Quantity
        JLabel quantityLabel = new JLabel("Quantity: " + quantity);
        quantityLabel.setForeground(new Color(255, 169, 140));
        quantityLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        quantityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(quantityLabel);

        // Total Amount
        JLabel totalAmountLabel = new JLabel("Total Amount: " + totalAmount);
        totalAmountLabel.setForeground(new Color(255, 169, 140));
        totalAmountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        totalAmountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(totalAmountLabel);

        JLabel addressLabel = new JLabel("Enter Address:");
        addressLabel.setForeground(new Color(255, 169, 140));
        addressLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(addressLabel);

        addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 30));
        addressField.setMaximumSize(new Dimension(200, 30));
        addressField.setMinimumSize(new Dimension(200, 30));
        addressField.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(addressField);

        
        wrapper.add(m3);

        m4.setBackground(new java.awt.Color(25, 25, 25));
        m4.setMaximumSize(new java.awt.Dimension(800, 30));
        m4.setMinimumSize(new java.awt.Dimension(800, 30));
        m4.setPreferredSize(new java.awt.Dimension(800, 40));

        javax.swing.GroupLayout m4Layout = new javax.swing.GroupLayout(m4);
        m4.setLayout(m4Layout);
        m4Layout.setHorizontalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        m4Layout.setVerticalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        wrapper.add(m4);

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
                payButtonActionPerformed(evt);
            }
        });
        payContainer.add(payButton);

        wrapper.add(payContainer);

        m6.setBackground(new java.awt.Color(25, 25, 25));
        m6.setMaximumSize(new java.awt.Dimension(800, 30));
        m6.setMinimumSize(new java.awt.Dimension(800, 30));
        m6.setPreferredSize(new java.awt.Dimension(800, 40));

        javax.swing.GroupLayout m6Layout = new javax.swing.GroupLayout(m6);
        m6.setLayout(m6Layout);
        m6Layout.setHorizontalGroup(
            m6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        m6Layout.setVerticalGroup(
            m6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        wrapper.add(m6);

        getContentPane().add(wrapper);
        wrapper.setBounds(0, 0, 800, 500);

        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
    }                                       

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Check if the user entered a valid address
        String address = addressField.getText();
        if (address != null && !address.trim().isEmpty()) {
            // Proceed with the payment process
            payment(address);
        } else {
            JOptionPane.showMessageDialog(this, "Address is required to proceed with the payment.", "Invalid Address", JOptionPane.ERROR_MESSAGE);
        }
    } 

    private void payment(String address) {
        // Validate and clean totalAmount
        double totalAmountDouble;
        try {
            String cleanedTotalAmount = totalAmount.replaceAll("[^\\d.]", ""); // Remove non-numeric characters
            totalAmountDouble = Double.parseDouble(cleanedTotalAmount);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid total amount.", "Payment Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the credit object is not null
        if (credit == null) {
            JOptionPane.showMessageDialog(this, "Credit information is missing.", "Payment Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the customer has enough credit
        if (credit.getAmount() >= totalAmountDouble) {
            // Deduct the total amount from the customer's credit
            credit.setAmount(credit.getAmount() - totalAmountDouble);
            credit.setDate(LocalDate.now());

            // Save updated credit information
            ArrayList<Credit> credits = OrderHandling.getCredits();
            for (Credit c : credits) {
                if (c.getCustomerID().equals(credit.getCustomerID())) {
                    c.setAmount(credit.getAmount());
                    c.setDate(credit.getDate());
                    break;
                }
            }
            // TODO edit this
            OrderHandling.saveCredits(credit, receiptImagePath);

            OrderHandling.savePayment(orderID, credit.getCustomerID(), foodName, quantity, totalAmountDouble, address);


            System.out.println("Payment processed for address: " + address);
            JOptionPane.showMessageDialog(this, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the Payment page
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient credit to complete the payment.", "Payment Failed", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel back_icon;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JPanel m3;
    private javax.swing.JPanel m4;
    private javax.swing.JPanel m6;
    private javax.swing.JButton payButton;
    private javax.swing.JPanel payContainer;
    private javax.swing.JLabel title;
    private javax.swing.JPanel wrapper;
    // End of variables declaration                   
}
