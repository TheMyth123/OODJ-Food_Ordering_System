package oodj.food_ordering_system.designUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.models.Credit;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.utils.CreateTopupPDF;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.UserHandling;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TopUpRequests extends javax.swing.JPanel {
    private String receiptImagePath;
    private String creditID;
        public TopUpRequests(String creditID, String customerID, String amount, String lastUpdated, String receiptImagePath) {
            initComponents();
            CustomerIDField.setText(customerID);
            AmountField.setText(amount);
            LastDateField.setText(lastUpdated);
            this.creditID = creditID;
            this.receiptImagePath = receiptImagePath;
    }
                     
    private void initComponents() {

        CustomerIDLabel = new javax.swing.JLabel();
        AmountLabel = new javax.swing.JLabel();
        LastDateLabel = new javax.swing.JLabel();
        CustomerIDField = new javax.swing.JLabel();
        AmountField = new javax.swing.JLabel();
        LastDateField = new javax.swing.JLabel();
        btn_ViewReceipt = new javax.swing.JButton();
        btn_Approve = new javax.swing.JButton();
        btn_Reject = new javax.swing.JButton();

        setBackground(new java.awt.Color(42, 42, 42));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(880, 110));
        setMinimumSize(new java.awt.Dimension(850, 110));
        setPreferredSize(new java.awt.Dimension(850, 110));

        CustomerIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CustomerIDLabel.setForeground(new java.awt.Color(255, 178, 102));
        CustomerIDLabel.setText("Customer ID: ");

        AmountLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AmountLabel.setForeground(new java.awt.Color(255, 178, 102));
        AmountLabel.setText("Amount: ");

        LastDateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LastDateLabel.setForeground(new java.awt.Color(255, 178, 102));
        LastDateLabel.setText("Last Updated: ");

        CustomerIDField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CustomerIDField.setForeground(new java.awt.Color(211, 211, 211));
        CustomerIDField.setText("CS00000");

        AmountField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AmountField.setForeground(new java.awt.Color(211, 211, 211));
        AmountField.setText("1000000");

        LastDateField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LastDateField.setForeground(new java.awt.Color(211, 211, 211));
        LastDateField.setText("2024-01-01");

        btn_ViewReceipt.setBackground(new java.awt.Color(90, 155, 213));
        btn_ViewReceipt.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_ViewReceipt.setText("View Receipt");
        btn_ViewReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewReceiptActionPerformed(evt);
            }
        });

        btn_Approve.setBackground(new java.awt.Color(76, 175, 80));
        btn_Approve.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_Approve.setText("Approve");
        btn_Approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ApproveActionPerformed(evt);
            }
        });

        btn_Reject.setBackground(new java.awt.Color(180, 45, 40));
        btn_Reject.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_Reject.setText("Reject");
        btn_Reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RejectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btn_ViewReceipt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(CustomerIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerIDField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AmountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmountField))
                    .addComponent(btn_Approve, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_Reject)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LastDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastDateField)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastDateLabel)
                    .addComponent(AmountLabel)
                    .addComponent(CustomerIDField)
                    .addComponent(AmountField)
                    .addComponent(LastDateField)
                    .addComponent(CustomerIDLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ViewReceipt)
                    .addComponent(btn_Approve)
                    .addComponent(btn_Reject))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void btn_ViewReceiptActionPerformed(java.awt.event.ActionEvent evt) {   
        JFrame receiptFrame = new JFrame("Receipt Image");
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        receiptFrame.setSize(800, 500);
        receiptFrame.getContentPane().setBackground(new Color(31, 31, 31));
    
        ImageIcon receiptIcon = new ImageIcon(receiptImagePath);
    
        int frameWidth = receiptFrame.getWidth();
        int frameHeight = receiptFrame.getHeight();
    
        int imageWidth = receiptIcon.getIconWidth();
        int imageHeight = receiptIcon.getIconHeight();
    
        double widthRatio = (double) frameWidth / imageWidth;
        double heightRatio = (double) frameHeight / imageHeight;
        double scaleFactor = Math.min(widthRatio, heightRatio);
    
        int newWidth = (int) (imageWidth * scaleFactor);
        int newHeight = (int) (imageHeight * scaleFactor);
    
        Image scaledImage = receiptIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    
        JLabel receiptLabel = new JLabel(new ImageIcon(scaledImage));
        receiptLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        receiptFrame.add(receiptLabel);
        receiptFrame.setLocationRelativeTo(null);
        receiptFrame.setVisible(true);
    }
                               

    private void btn_ApproveActionPerformed(java.awt.event.ActionEvent evt) {                                          
        UpdateCreditStatus("Accepted", creditID);
        UpdateNotificationStatus(creditID);
        btn_Approve.setEnabled(false);
        btn_Approve.setBackground(new java.awt.Color(169, 169, 169)); // Light grey
        btn_Reject.setEnabled(false);
        btn_Reject.setBackground(new java.awt.Color(169, 169, 169)); // Light grey
        CreateTopupPDF.createPDF(creditID);
        Credit credit = UserHandling.getTopUpByID(creditID);
        Customer customer = UserHandling.getCustomerByID(credit.getCustomerID());
        String customerID = customer.getID();
        String type = "Top Up Request Accepted";
        String content = "Your top-up request has been confirmed. Please check the transaction details below.";
        String title = "Top Up Approved";
        String actionlink = creditID;
        NotificationUtils.NotificationCreator(customerID, type, content, title, actionlink);
        try {
            UpdateBalance(creditID);
        } catch (IOException e) {
            DialogBox.errorMessage("Failed to update balance. Please try again.", "IO Error");
        }
    }                                           

    private void btn_RejectActionPerformed(java.awt.event.ActionEvent evt) { 
        UpdateCreditStatus("Rejected", creditID);
        UpdateNotificationStatus(creditID);
        btn_Approve.setEnabled(false);
        btn_Approve.setBackground(new java.awt.Color(169, 169, 169)); // Light grey
        btn_Reject.setEnabled(false);
        btn_Reject.setBackground(new java.awt.Color(169, 169, 169)); // Light grey
        Credit credit = UserHandling.getTopUpByID(creditID);
        Customer customer = UserHandling.getCustomerByID(credit.getCustomerID());
        String customerID = customer.getID();
        String type = "Top Up Request Rejected";
        String content = "Sorry, your top-up request has been rejected.";
        String title = "Top Up Rejected";
        String actionlink = creditID;
        NotificationUtils.NotificationCreator(customerID, type, content, title, actionlink);
    }                                              

    // Variables declaration - do not modify                     
    private javax.swing.JLabel AmountField;
    private javax.swing.JLabel AmountLabel;
    private javax.swing.JLabel CustomerIDField;
    private javax.swing.JLabel CustomerIDLabel;
    private javax.swing.JLabel LastDateField;
    private javax.swing.JLabel LastDateLabel;
    private javax.swing.JButton btn_Approve;
    private javax.swing.JButton btn_Reject;
    private javax.swing.JButton btn_ViewReceipt;
    // End of variables declaration    
    
    private void UpdateCreditStatus(String status, String creditID){
        try {                                          
            String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\topup.txt";
            FileHandling.checkFile(filePath);
    
            JSONArray topupArray;
            File file = new File(filePath);
    
            if (file.length() > 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    topupArray = new JSONArray(content.toString());
                }
            } else {
                DialogBox.errorMessage("No topup data found to edit.", "Error");
                return;
            }
    
            boolean creditFound = false;
            for (int i = 0; i < topupArray.length(); i++) {
                JSONObject credit = topupArray.getJSONObject(i);
                if (credit.getString("CreditID").equals(creditID)) {
                    credit.put("Status", status);
                    creditFound = true;
                    break;
                }
            }
    
            if (!creditFound) {
                DialogBox.errorMessage("Top Up request with ID " + creditID + " not found.", "Error");
                return;
            }
    
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(topupArray.toString(2)); // Pretty print with indentation
                fileWriter.flush();
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }

    private void UpdateNotificationStatus(String creditID){
        try {                                          
            String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\notification.txt";
            FileHandling.checkFile(filePath);
    
            JSONArray notificationArray;
            File file = new File(filePath);
    
            if (file.length() > 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    notificationArray = new JSONArray(content.toString());
                }
            } else {
                DialogBox.errorMessage("No notification data found to edit.", "Error");
                return;
            }
    
            boolean notificationFound = false;
            for (int i = 0; i < notificationArray.length(); i++) {
                JSONObject credit = notificationArray.getJSONObject(i);
                if (credit.getString("ActionLink").equals(creditID)) {
                    credit.put("ReadStatus", "True");
                    notificationFound = true;
                    break;
                }
            }
    
            if (!notificationFound) {
                DialogBox.errorMessage("Notification with creditID " + creditID + " not found.", "Error");
                return;
            }
    
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(notificationArray.toString(2)); // Pretty print with indentation
                fileWriter.flush();
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }

    private void UpdateBalance(String creditID) throws IOException {
        Credit credit = UserHandling.getTopUpByID(creditID);
        Customer customer = UserHandling.getCustomerByID(credit.getCustomerID());
        String customerID = customer.getID();

        double newBalance = customer.getBalance() + credit.getAmount();
        String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\customer.txt";
        FileHandling.checkFile(filePath);

        JSONArray customerArray;
        File file = new File(filePath);

        if (file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                customerArray = new JSONArray(content.toString());
            }
        } else {
            DialogBox.errorMessage("No customer data found to edit.", "Error");
            return;
        }

        boolean customerFound = false;
        for (int i = 0; i < customerArray.length(); i++) {
            JSONObject customers = customerArray.getJSONObject(i);
            if (customers.getString("CustomerID").equals(customerID)) {
                // Update the customer's data
                customers.put("Balance", newBalance);
                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            DialogBox.errorMessage("Customer with ID " + customerID + " not found.", "Error");
            return;
        }

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(customerArray.toString(2)); // Pretty print with indentation
            fileWriter.flush();
        }
    }
}