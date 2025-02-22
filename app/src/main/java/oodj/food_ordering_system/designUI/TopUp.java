package oodj.food_ordering_system.designUI;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.utils.OrderHandling;





public class TopUp extends javax.swing.JFrame {


    private Customer endUser;

    private String receiptImagePath;


    public TopUp(Customer endUser) {
        this.endUser = endUser;              
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
        m3.setMaximumSize(new java.awt.Dimension(800, 250));
        m3.setMinimumSize(new java.awt.Dimension(800, 250));
        m3.setPreferredSize(new java.awt.Dimension(800, 250));

        
        m3.setLayout(new javax.swing.BoxLayout(m3, javax.swing.BoxLayout.Y_AXIS));

        JLabel amountLabel = new JLabel("Enter Top-Up Amount:");
        amountLabel.setForeground(new Color(255, 169, 140));
        amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(amountLabel);

        amountField = new JTextField();
        amountField.setPreferredSize(new Dimension(200, 30));
        amountField.setMaximumSize(new Dimension(200, 30));
        amountField.setMinimumSize(new Dimension(200, 30));
        amountField.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(amountField);

        JLabel textLabel = new JLabel("Please upload a screenshot of the receipt here.");
        textLabel.setForeground(new Color(255, 169, 140));
        textLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(Box.createRigidArea(new Dimension(0, 50)));
        m3.add(textLabel);


        JLabel uploadLabel = new JLabel("Upload Receipt:");
        uploadLabel.setForeground(new Color(255, 169, 140));
        uploadLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        uploadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m3.add(uploadLabel);

        uploadButton = new JButton("Upload");
        uploadButton.setPreferredSize(new Dimension(100, 30));
        uploadButton.setMaximumSize(new Dimension(100, 30));
        uploadButton.setMinimumSize(new Dimension(100, 30));
        uploadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadReceipt();
            }
        });
        m3.add(uploadButton);

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
            @Override
            public void actionPerformed(ActionEvent e) {
                submitTopUpRequest();
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
    
    private void uploadReceipt() {
        // Implement upload receipt functionality
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Handle file selection
            receiptImagePath = fileChooser.getSelectedFile().getPath();
            System.out.println("Receipt uploaded: " + receiptImagePath);
        }
    }


    private void submitTopUpRequest() {
        // Implement submit top-up request functionality
        String amount = amountField.getText();
        
        if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the top-up amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (receiptImagePath == null || receiptImagePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please upload the receipt.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate file type
        if (!receiptImagePath.toLowerCase().endsWith(".pdf")) {
            JOptionPane.showMessageDialog(this, "Only PDF files are accepted for the receipt.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Create a new Credit object
        String creditID = "CR" + String.format("%05d", OrderHandling.getCRid() + 1);
    
        double creditAmount = Double.parseDouble(amount);
        LocalDate lastUpdated = LocalDate.now();
        String status = "Pending";
        String receiptPath = OrderHandling.RECEIPT_FOLDER + creditID + ".pdf"; // Save as PDF
    
        Credit newCredit = new Credit(creditID, endUser.getID(), creditAmount, lastUpdated, status, receiptPath);
    
        // Get existing credits and add the new credit
        ArrayList<Credit> credits = OrderHandling.getCredits();
        credits.add(newCredit);
    
        // Save the updated credits
        OrderHandling.saveCredits(newCredit, receiptImagePath);
    
        JOptionPane.showMessageDialog(this, "Request has successfully been sent to admin.", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
    

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
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
    private JTextField amountField;
    private JButton uploadButton;
    // End of variables declaration  
    
    
    
}

