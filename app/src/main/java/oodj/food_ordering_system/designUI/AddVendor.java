package oodj.food_ordering_system.designUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.utils.UserHandling;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.validation;

public class AddVendor extends javax.swing.JFrame {
    
    private ManageVendor parent;

    public AddVendor(ManageVendor parent) {
        this.parent = parent;
        initComponents();
    }

    public AddVendor() {
        initComponents();
    }   

    public void appendVendor() {
        String username = usernameTextField.getText();
        String vendorname = vendornameTextField.getText();
        String email = emailTextField.getText();
        String contactnumber = contactNumberTextField.getText();
        String password = new String(PasswordField.getPassword());
        String foodcourtname = foodcourtnameTextField.getText();
        String date = new SimpleDateFormat("dd/MMMM/yyyy").format(new Date());

        try {
            if (username.equals("") || vendorname.equals("") || contactnumber.equals("") || password.equals("") || date.equals("" ) || email.equals("") || foodcourtname.equals("")) {
                DialogBox.reminderMessage("Please ensure everything is filled up!", "Reminder");

            } else if (!validation.checkUsername(username)) {
                usernameTextField.setText("");
                DialogBox.errorMessage("Please Change another username", "Username exists!");

            } else if (!validation.nameFormat(vendorname)) {
                vendornameTextField.setText("");
                DialogBox.errorMessage("Please re-enter your name!", "Spaces more than once");

            } else if (!validation.isValidEmail(email)) {
                emailTextField.setText("");
                DialogBox.errorMessage("Please re-enter your email!", "Invalid email format");

            } else if (!validation.checkEmail(email)) {
                emailTextField.setText("");
                DialogBox.errorMessage("Please Change another email", "Email exists!");

            } else if (!validation.isValidPhone(contactnumber)) {
                contactNumberTextField.setText("");
                DialogBox.errorMessage(
                        "Please re-enter your contact number! Valid formats include:\n"
                        + "- +6010-2345678 (7 digits after 010, with optional + and optional dash)\n"
                        + "- 6012-3456789 (7 digits after 012, without +, with optional dash)\n"
                        + "- 013-4567890 (7 digits after 013, no country code or +, with optional dash)\n"
                        + "- +6011-23456789 (8 digits after 011, with +, with optional dash)\n"
                        + "- 01134567890 (8 digits after 011, no dashes)",
                        "Invalid contact number format!"
                );

            } else if (!validation.isValidPassword(password)) {
                PasswordField.setText("");
                DialogBox.errorMessage("Password must be at least 6 characters long and include both letters and numbers.", "Error");
            } else {
                String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\vendor.txt";
                FileHandling.checkFile(filePath);

                String vendorID = "VD" + String.format("%05d", UserHandling.getVId() + 1);

                JSONObject newVendor = new JSONObject();
                newVendor.put("VendorID", vendorID);
                newVendor.put("Username", username);
                newVendor.put("VendorName", vendorname);
                newVendor.put("ContactNumber", contactnumber);
                newVendor.put("Password", password);
                newVendor.put("DateRegistered", date);
                newVendor.put("Email", email);
                newVendor.put("FoodCourtName", foodcourtname);
                newVendor.put("Status", "True");

                JSONArray vendorArray;
                File file = new File(filePath);

                if (file.length() > 0) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line);
                        }
                        vendorArray = new JSONArray(content.toString());
                    }
                } else {
                    vendorArray = new JSONArray();
                }
                vendorArray.put(newVendor);

                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(vendorArray.toString(2)); // Pretty print with indentation
                    fileWriter.flush();
                }

                DialogBox.successMessage("Congratulations, you have successfully added a new vendor.", "Success");
                // setVisible(false);
                // new ManageVendor().setVisible(true);
                parent.refreshVendorInfo();
                dispose();
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        wrapper = new javax.swing.JPanel();
        back_icon = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        m2 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        m3 = new javax.swing.JPanel();
        cardDetails = new javax.swing.JPanel();
        details_1 = new javax.swing.JPanel();
        UsernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        details_2 = new javax.swing.JPanel();
        VendorNameLabel = new javax.swing.JLabel();
        vendornameTextField = new javax.swing.JTextField();
        details_4 = new javax.swing.JPanel();
        EmailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        details_5 = new javax.swing.JPanel();
        ContactNumberLabel = new javax.swing.JLabel();
        contactNumberTextField = new javax.swing.JTextField();
        details_5 = new javax.swing.JPanel();
        details_6 = new javax.swing.JPanel();
        details_6 = new javax.swing.JPanel();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        details_3 = new javax.swing.JPanel();
        FoodCourtNameLabel = new javax.swing.JLabel();
        foodcourtnameTextField = new javax.swing.JTextField();
        btnContainer = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        wrapper.setBackground(new java.awt.Color(25, 25, 25));
        wrapper.setMaximumSize(new java.awt.Dimension(800, 500));
        wrapper.setMinimumSize(new java.awt.Dimension(800, 500));
        wrapper.setPreferredSize(new java.awt.Dimension(800, 550));
        wrapper.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        back_icon.setBackground(new java.awt.Color(25, 25, 25));
        back_icon.setMaximumSize(new java.awt.Dimension(800, 70));
        back_icon.setMinimumSize(new java.awt.Dimension(800, 70));
        back_icon.setPreferredSize(new java.awt.Dimension(800, 70));
        back_icon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        m1.setBackground(new java.awt.Color(25, 25, 25));
        m1.setMaximumSize(new java.awt.Dimension(800, 10));
        m1.setMinimumSize(new java.awt.Dimension(800, 10));

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
        title.setText("Add New Vendor");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(694, 50));
        title.setMinimumSize(new java.awt.Dimension(694, 50));
        title.setPreferredSize(new java.awt.Dimension(694, 50));
        back_icon.add(title);

        wrapper.add(back_icon);

        m3.setBackground(new java.awt.Color(25, 25, 25));
        m3.setMaximumSize(new java.awt.Dimension(800, 25));
        m3.setMinimumSize(new java.awt.Dimension(800, 25));

        javax.swing.GroupLayout m3Layout = new javax.swing.GroupLayout(m3);
        m3.setLayout(m3Layout);
        m3Layout.setHorizontalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        m3Layout.setVerticalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        wrapper.add(m3);

        cardDetails.setBackground(new java.awt.Color(25, 25, 25));
        cardDetails.setMaximumSize(new java.awt.Dimension(800, 200));
        cardDetails.setMinimumSize(new java.awt.Dimension(800, 200));
        cardDetails.setPreferredSize(new java.awt.Dimension(800, 335));
        cardDetails.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        details_1.setBackground(new java.awt.Color(25, 25, 25));
        details_1.setMaximumSize(new java.awt.Dimension(435, 50));
        details_1.setMinimumSize(new java.awt.Dimension(435, 50));
        details_1.setPreferredSize(new java.awt.Dimension(450, 45));
        details_1.setLayout(new javax.swing.BoxLayout(details_1, javax.swing.BoxLayout.LINE_AXIS));

        UsernameLabel.setBackground(new java.awt.Color(25, 25, 25));
        UsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(245, 251, 254));
        UsernameLabel.setText("Username :");
        UsernameLabel.setAlignmentX(0.5F);
        UsernameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        UsernameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        UsernameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_1.add(UsernameLabel);

        usernameTextField.setBackground(new java.awt.Color(43, 43, 43));
        usernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(245, 251, 254));
        usernameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        usernameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        usernameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        usernameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        usernameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_1.add(usernameTextField);

        cardDetails.add(details_1);

        details_2.setBackground(new java.awt.Color(25, 25, 25));
        details_2.setMaximumSize(new java.awt.Dimension(435, 50));
        details_2.setMinimumSize(new java.awt.Dimension(435, 50));
        details_2.setPreferredSize(new java.awt.Dimension(450, 45));
        details_2.setLayout(new javax.swing.BoxLayout(details_2, javax.swing.BoxLayout.LINE_AXIS));

        VendorNameLabel.setBackground(new java.awt.Color(25, 25, 25));
        VendorNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        VendorNameLabel.setForeground(new java.awt.Color(245, 251, 254));
        VendorNameLabel.setText("Vendor Name : ");
        VendorNameLabel.setAlignmentX(0.5F);
        VendorNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        VendorNameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        VendorNameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_2.add(VendorNameLabel);

        vendornameTextField.setBackground(new java.awt.Color(43, 43, 43));
        vendornameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vendornameTextField.setForeground(new java.awt.Color(245, 251, 254));
        vendornameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        vendornameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        vendornameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        vendornameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        vendornameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        vendornameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        vendornameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_2.add(vendornameTextField);

        cardDetails.add(details_2);

        details_3.setBackground(new java.awt.Color(25, 25, 25));
        details_3.setMaximumSize(new java.awt.Dimension(435, 50));
        details_3.setMinimumSize(new java.awt.Dimension(435, 50));
        details_3.setPreferredSize(new java.awt.Dimension(450, 45));
        details_3.setLayout(new javax.swing.BoxLayout(details_3, javax.swing.BoxLayout.LINE_AXIS));

        FoodCourtNameLabel.setBackground(new java.awt.Color(25, 25, 25));
        FoodCourtNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FoodCourtNameLabel.setForeground(new java.awt.Color(245, 251, 254));
        FoodCourtNameLabel.setText("Food Court Name :");
        FoodCourtNameLabel.setAlignmentX(0.5F);
        FoodCourtNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        FoodCourtNameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        FoodCourtNameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_3.add(FoodCourtNameLabel);

        foodcourtnameTextField.setBackground(new java.awt.Color(43, 43, 43));
        foodcourtnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        foodcourtnameTextField.setForeground(new java.awt.Color(245, 251, 254));
        foodcourtnameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        foodcourtnameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        foodcourtnameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        foodcourtnameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        foodcourtnameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        foodcourtnameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        foodcourtnameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_3.add(foodcourtnameTextField);

        cardDetails.add(details_3);

        details_4.setBackground(new java.awt.Color(25, 25, 25));
        details_4.setMaximumSize(new java.awt.Dimension(435, 50));
        details_4.setMinimumSize(new java.awt.Dimension(435, 50));
        details_4.setPreferredSize(new java.awt.Dimension(450, 45));
        details_4.setLayout(new javax.swing.BoxLayout(details_4, javax.swing.BoxLayout.LINE_AXIS));

        EmailLabel.setBackground(new java.awt.Color(25, 25, 25));
        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(245, 251, 254));
        EmailLabel.setText("Email :");
        EmailLabel.setAlignmentX(0.5F);
        EmailLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        EmailLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        EmailLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_4.add(EmailLabel);

        emailTextField.setBackground(new java.awt.Color(43, 43, 43));
        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(245, 251, 254));
        emailTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emailTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        emailTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        emailTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        emailTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        emailTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_4.add(emailTextField);

        cardDetails.add(details_4);

        details_5.setBackground(new java.awt.Color(25, 25, 25));
        details_5.setMaximumSize(new java.awt.Dimension(435, 50));
        details_5.setMinimumSize(new java.awt.Dimension(435, 50));
        details_5.setPreferredSize(new java.awt.Dimension(450, 45));
        details_5.setLayout(new javax.swing.BoxLayout(details_5, javax.swing.BoxLayout.LINE_AXIS));

        ContactNumberLabel.setBackground(new java.awt.Color(25, 25, 25));
        ContactNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ContactNumberLabel.setForeground(new java.awt.Color(245, 251, 254));
        ContactNumberLabel.setText("Contact Number :");
        ContactNumberLabel.setAlignmentX(0.5F);
        ContactNumberLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        ContactNumberLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        ContactNumberLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_5.add(ContactNumberLabel);

        contactNumberTextField.setBackground(new java.awt.Color(43, 43, 43));
        contactNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contactNumberTextField.setForeground(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contactNumberTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactNumberTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        contactNumberTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        contactNumberTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        contactNumberTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_5.add(contactNumberTextField);

        cardDetails.add(details_5);

        details_6.setBackground(new java.awt.Color(25, 25, 25));
        details_6.setMaximumSize(new java.awt.Dimension(435, 50));
        details_6.setMinimumSize(new java.awt.Dimension(435, 50));
        details_6.setPreferredSize(new java.awt.Dimension(450, 45));
        details_6.setLayout(new javax.swing.BoxLayout(details_6, javax.swing.BoxLayout.LINE_AXIS));

        PasswordLabel.setBackground(new java.awt.Color(25, 25, 25));
        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(245, 251, 254));
        PasswordLabel.setText("Password :");
        PasswordLabel.setAlignmentX(0.5F);
        PasswordLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        PasswordLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        PasswordLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_6.add(PasswordLabel);

        PasswordField.setBackground(new java.awt.Color(43, 43, 43));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(245, 251, 254));
        PasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PasswordField.setCaretColor(new java.awt.Color(245, 251, 254));
        PasswordField.setMaximumSize(new java.awt.Dimension(280, 35));
        PasswordField.setMinimumSize(new java.awt.Dimension(280, 35));
        PasswordField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_6.add(PasswordField);

        cardDetails.add(details_6);

        wrapper.add(cardDetails);

        btnContainer.setBackground(new java.awt.Color(25, 25, 25));
        btnContainer.setMaximumSize(new java.awt.Dimension(800, 40));
        btnContainer.setMinimumSize(new java.awt.Dimension(800, 40));
        btnContainer.setPreferredSize(new java.awt.Dimension(800, 40));
        btnContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        addButton.setBackground(new java.awt.Color(255, 169, 140));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(31, 31, 31));
        addButton.setText("Add Vendor");
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setMargin(null);
        addButton.setMaximumSize(new java.awt.Dimension(200, 40));
        addButton.setMinimumSize(new java.awt.Dimension(200, 40));
        addButton.setPreferredSize(new java.awt.Dimension(170, 40));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        btnContainer.add(addButton);

        wrapper.add(btnContainer);

        getContentPane().add(wrapper);
        wrapper.setBounds(0, 0, 800, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
    }                                       

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        appendVendor();
    }                                                                        

    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel VendorNameLabel;
    private javax.swing.JTextField vendornameTextField;
    private javax.swing.JLabel ContactNumberLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel FoodCourtNameLabel;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JTextField foodcourtnameTextField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel back_icon;
    private javax.swing.JPanel btnContainer;
    private javax.swing.JPanel cardDetails;
    private javax.swing.JPanel details_1;
    private javax.swing.JPanel details_2;
    private javax.swing.JPanel details_4;
    private javax.swing.JPanel details_5;
    private javax.swing.JPanel details_6;
    private javax.swing.JPanel details_3;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JLabel title;
    private javax.swing.JPanel wrapper;
    private javax.swing.JPanel m3;
    // End of variables declaration                   

}
