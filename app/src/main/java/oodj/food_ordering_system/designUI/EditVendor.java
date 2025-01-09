package oodj.food_ordering_system.designUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.models.Vendor;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.validation;

public class EditVendor extends javax.swing.JFrame {

    private ManageVendor parent;
    private Vendor vendor;

    public EditVendor(ManageVendor parent, Vendor vendor) {
        this.parent = parent;
        this.vendor = vendor;
        initComponents();
        displayVendorDetails();
    }

    public EditVendor(ManageVendor parent, String vendorID, String vendorname, String username, String email, String contactnumber, String foodcourtname, String dob, String password, Boolean status) {
        this.parent = parent;
        this.vendor = new Vendor(vendorID, vendorname, foodcourtname, contactnumber, username, password, status, dob, email);
        initComponents();
        displayVendorDetails();
    }

    private void displayVendorDetails() {
        IDOutput.setText(vendor.getID());
        usernameTextField.setText(vendor.getUsername());
        vendornameTextField.setText(vendor.getName());
        emailTextField.setText(vendor.getEmail());
        contactNumberTextField.setText(vendor.getContactnumber());
        PasswordField.setText(vendor.getPassword());
        foodcourtnameTextField.setText(vendor.getFoodCourtName());
        dobOutput.setText(vendor.getDOB());
    }

    public void updateVendor() {
        String vendorID = IDOutput.getText();
        String username = usernameTextField.getText();
        String vendorname = vendornameTextField.getText();
        String email = emailTextField.getText();
        String contactnumber = contactNumberTextField.getText();
        String dob = dobOutput.getText();
        String password = new String(PasswordField.getPassword());
        String foodcourtname = foodcourtnameTextField.getText();

        try {
            if (username.equals("") || vendorname.equals("") || contactnumber.equals("") || password.equals("") || email.equals("") || foodcourtname.equals("")) {
                DialogBox.reminderMessage("Please ensure everything is filled up!", "Reminder");

            } else if (!validation.checkUsernameWithId(username, vendorID)) {
                usernameTextField.setText("");
                DialogBox.errorMessage("Please Change another username", "Username exists!");

            } else if (!validation.nameFormat(vendorname)) {
                vendornameTextField.setText("");
                DialogBox.errorMessage("Please re-enter your vendor name!", "Spaces more than once");

            } else if (!validation.isValidEmail(email)) {
                emailTextField.setText("");
                DialogBox.errorMessage("Please re-enter your email!", "Invalid email format");

            } else if (!validation.checkEmailWithId(email, vendorID)) {
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
                    DialogBox.errorMessage("No vendor data found to edit.", "Error");
                    return;
                }

                boolean vendorFound = false;
                for (int i = 0; i < vendorArray.length(); i++) {
                    JSONObject vendor = vendorArray.getJSONObject(i);
                    if (vendor.getString("VendorID").equals(vendorID)) {
                        // Update the vendor's data
                        vendor.put("Username", username);
                        vendor.put("VendorName", vendorname);
                        vendor.put("ContactNumber", contactnumber);
                        vendor.put("Password", password);
                        vendor.put("DateRegistered", dob);
                        vendor.put("Email", email);
                        vendor.put("FoodCourtName", foodcourtname);
                        vendorFound = true;
                        break;
                    }
                }

                if (!vendorFound) {
                    DialogBox.errorMessage("Vendor with ID " + vendorID + " not found.", "Error");
                    return;
                }

                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(vendorArray.toString(2)); // Pretty print with indentation
                    fileWriter.flush();
                }

                DialogBox.successMessage("Vendor data updated successfully.", "Success");
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
        m3 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        cardDetails = new javax.swing.JPanel();
        details_1 = new javax.swing.JPanel();
        UsernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        details_2 = new javax.swing.JPanel();
        VendorNameLabel = new javax.swing.JLabel();
        vendornameTextField = new javax.swing.JTextField();
        details_3 = new javax.swing.JPanel();
        EmailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        details_4 = new javax.swing.JPanel();
        PhoneLabel = new javax.swing.JLabel();
        contactNumberTextField = new javax.swing.JTextField();
        DOBLabel = new javax.swing.JLabel();
        details_6 = new javax.swing.JPanel();
        DOBLabel = new javax.swing.JLabel();
        dobOutput = new javax.swing.JLabel();
        details_7 = new javax.swing.JPanel();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        details_8 = new javax.swing.JPanel();
        FoodCourtNameLabel = new javax.swing.JLabel();
        foodcourtnameTextField = new javax.swing.JTextField();
        btnContainer = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        details_0 = new javax.swing.JPanel();
        VendorIDLabel = new javax.swing.JLabel();
        IDOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        wrapper.setBackground(new java.awt.Color(25, 25, 25));
        wrapper.setMaximumSize(new java.awt.Dimension(960, 600));
        wrapper.setMinimumSize(new java.awt.Dimension(960, 600));
        wrapper.setPreferredSize(new java.awt.Dimension(960, 600));
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
        title.setText("Edit Vendor Details");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(694, 50));
        title.setMinimumSize(new java.awt.Dimension(694, 50));
        title.setPreferredSize(new java.awt.Dimension(694, 50));
        back_icon.add(title);

        wrapper.add(back_icon);

        m3.setBackground(new java.awt.Color(25, 25, 25));
        m3.setMaximumSize(new java.awt.Dimension(800, 15));
        m3.setMinimumSize(new java.awt.Dimension(800, 15));

        javax.swing.GroupLayout m3Layout = new javax.swing.GroupLayout(m3);
        m3.setLayout(m3Layout);
        m3Layout.setHorizontalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        m3Layout.setVerticalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        wrapper.add(m3);

        cardDetails.setBackground(new java.awt.Color(25, 25, 25));
        cardDetails.setMaximumSize(new java.awt.Dimension(800, 200));
        cardDetails.setMinimumSize(new java.awt.Dimension(800, 200));
        cardDetails.setPreferredSize(new java.awt.Dimension(800, 440));
        cardDetails.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        details_0.setBackground(new java.awt.Color(25, 25, 25));
        details_0.setMaximumSize(new java.awt.Dimension(435, 50));
        details_0.setMinimumSize(new java.awt.Dimension(435, 50));
        details_0.setPreferredSize(new java.awt.Dimension(450, 45));
        details_0.setLayout(new javax.swing.BoxLayout(details_0, javax.swing.BoxLayout.LINE_AXIS));

        VendorIDLabel.setBackground(new java.awt.Color(25, 25, 25));
        VendorIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        VendorIDLabel.setForeground(new java.awt.Color(245, 251, 254));
        VendorIDLabel.setText("Vendor ID :");
        VendorIDLabel.setAlignmentX(0.5F);
        VendorIDLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        VendorIDLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        VendorIDLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_0.add(VendorIDLabel);

        IDOutput.setBackground(new java.awt.Color(25, 25, 25));
        IDOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDOutput.setForeground(new java.awt.Color(245, 251, 254));
        IDOutput.setAlignmentX(0.5F);
        IDOutput.setMaximumSize(new java.awt.Dimension(280, 35));
        IDOutput.setMinimumSize(new java.awt.Dimension(280, 35));
        IDOutput.setPreferredSize(new java.awt.Dimension(280, 35));
        details_0.add(IDOutput);

        cardDetails.add(details_0);

        details_1.setBackground(new java.awt.Color(25, 25, 25));
        details_1.setMaximumSize(new java.awt.Dimension(435, 50));
        details_1.setMinimumSize(new java.awt.Dimension(435, 50));
        details_1.setPreferredSize(new java.awt.Dimension(450, 45));
        details_1.setLayout(new javax.swing.BoxLayout(details_1, javax.swing.BoxLayout.LINE_AXIS));

        UsernameLabel.setBackground(new java.awt.Color(25, 25, 25));
        UsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(245, 251, 254));
        UsernameLabel.setText("Username :");
        UsernameLabel.setAlignmentX(0.5F);
        UsernameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        UsernameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        UsernameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_1.add(UsernameLabel);

        usernameTextField.setBackground(new java.awt.Color(43, 43, 43));
        usernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
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
        VendorNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        VendorNameLabel.setForeground(new java.awt.Color(245, 251, 254));
        VendorNameLabel.setText("Vendor Name : ");
        VendorNameLabel.setAlignmentX(0.5F);
        VendorNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        VendorNameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        VendorNameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_2.add(VendorNameLabel);

        vendornameTextField.setBackground(new java.awt.Color(43, 43, 43));
        vendornameTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
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

        details_8.setBackground(new java.awt.Color(25, 25, 25));
        details_8.setMaximumSize(new java.awt.Dimension(435, 50));
        details_8.setMinimumSize(new java.awt.Dimension(435, 50));
        details_8.setPreferredSize(new java.awt.Dimension(450, 45));
        details_8.setLayout(new javax.swing.BoxLayout(details_8, javax.swing.BoxLayout.LINE_AXIS));

        FoodCourtNameLabel.setBackground(new java.awt.Color(25, 25, 25));
        FoodCourtNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        FoodCourtNameLabel.setForeground(new java.awt.Color(245, 251, 254));
        FoodCourtNameLabel.setText("Address :");
        FoodCourtNameLabel.setAlignmentX(0.5F);
        FoodCourtNameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        FoodCourtNameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        FoodCourtNameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_8.add(FoodCourtNameLabel);

        foodcourtnameTextField.setBackground(new java.awt.Color(43, 43, 43));
        foodcourtnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        foodcourtnameTextField.setForeground(new java.awt.Color(245, 251, 254));
        foodcourtnameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        foodcourtnameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        foodcourtnameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        foodcourtnameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        foodcourtnameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        foodcourtnameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        foodcourtnameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_8.add(foodcourtnameTextField);

        cardDetails.add(details_8);

        details_3.setBackground(new java.awt.Color(25, 25, 25));
        details_3.setMaximumSize(new java.awt.Dimension(435, 50));
        details_3.setMinimumSize(new java.awt.Dimension(435, 50));
        details_3.setPreferredSize(new java.awt.Dimension(450, 45));
        details_3.setLayout(new javax.swing.BoxLayout(details_3, javax.swing.BoxLayout.LINE_AXIS));

        EmailLabel.setBackground(new java.awt.Color(25, 25, 25));
        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(245, 251, 254));
        EmailLabel.setText("Email :");
        EmailLabel.setAlignmentX(0.5F);
        EmailLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        EmailLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        EmailLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_3.add(EmailLabel);

        emailTextField.setBackground(new java.awt.Color(43, 43, 43));
        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(245, 251, 254));
        emailTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emailTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        emailTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        emailTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        emailTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        emailTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_3.add(emailTextField);

        cardDetails.add(details_3);

        details_4.setBackground(new java.awt.Color(25, 25, 25));
        details_4.setMaximumSize(new java.awt.Dimension(435, 50));
        details_4.setMinimumSize(new java.awt.Dimension(435, 50));
        details_4.setPreferredSize(new java.awt.Dimension(450, 45));
        details_4.setLayout(new javax.swing.BoxLayout(details_4, javax.swing.BoxLayout.LINE_AXIS));

        PhoneLabel.setBackground(new java.awt.Color(25, 25, 25));
        PhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        PhoneLabel.setForeground(new java.awt.Color(245, 251, 254));
        PhoneLabel.setText("Contact Number :");
        PhoneLabel.setAlignmentX(0.5F);
        PhoneLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        PhoneLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        PhoneLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_4.add(PhoneLabel);

        contactNumberTextField.setBackground(new java.awt.Color(43, 43, 43));
        contactNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        contactNumberTextField.setForeground(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contactNumberTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactNumberTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        contactNumberTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        contactNumberTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        contactNumberTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_4.add(contactNumberTextField);

        cardDetails.add(details_4);

        details_6.setBackground(new java.awt.Color(25, 25, 25));
        details_6.setMaximumSize(new java.awt.Dimension(435, 50));
        details_6.setMinimumSize(new java.awt.Dimension(435, 50));
        details_6.setPreferredSize(new java.awt.Dimension(450, 45));
        details_6.setLayout(new javax.swing.BoxLayout(details_6, javax.swing.BoxLayout.LINE_AXIS));

        DOBLabel.setBackground(new java.awt.Color(25, 25, 25));
        DOBLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        DOBLabel.setForeground(new java.awt.Color(245, 251, 254));
        DOBLabel.setText("Date Registered :");
        DOBLabel.setAlignmentX(0.5F);
        DOBLabel.setMaximumSize(new java.awt.Dimension(170, 30));
        DOBLabel.setMinimumSize(new java.awt.Dimension(170, 30));
        DOBLabel.setPreferredSize(new java.awt.Dimension(170, 30));
        details_6.add(DOBLabel);

        dobOutput.setBackground(new java.awt.Color(25, 25, 25));
        dobOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dobOutput.setForeground(new java.awt.Color(245, 251, 254));
        dobOutput.setAlignmentX(0.5F);
        dobOutput.setMaximumSize(new java.awt.Dimension(280, 35));
        dobOutput.setMinimumSize(new java.awt.Dimension(280, 35));
        dobOutput.setPreferredSize(new java.awt.Dimension(280, 35));
        details_6.add(dobOutput);

        cardDetails.add(details_6);

        details_7.setBackground(new java.awt.Color(25, 25, 25));
        details_7.setMaximumSize(new java.awt.Dimension(435, 50));
        details_7.setMinimumSize(new java.awt.Dimension(435, 50));
        details_7.setPreferredSize(new java.awt.Dimension(450, 45));
        details_7.setLayout(new javax.swing.BoxLayout(details_7, javax.swing.BoxLayout.LINE_AXIS));

        PasswordLabel.setBackground(new java.awt.Color(25, 25, 25));
        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(245, 251, 254));
        PasswordLabel.setText("Password :");
        PasswordLabel.setAlignmentX(0.5F);
        PasswordLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        PasswordLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        PasswordLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_7.add(PasswordLabel);

        PasswordField.setBackground(new java.awt.Color(43, 43, 43));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(245, 251, 254));
        PasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PasswordField.setCaretColor(new java.awt.Color(245, 251, 254));
        PasswordField.setMaximumSize(new java.awt.Dimension(280, 35));
        PasswordField.setMinimumSize(new java.awt.Dimension(280, 35));
        PasswordField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_7.add(PasswordField);

        cardDetails.add(details_7);

        wrapper.add(cardDetails);

        btnContainer.setBackground(new java.awt.Color(25, 25, 25));
        btnContainer.setMaximumSize(new java.awt.Dimension(800, 40));
        btnContainer.setMinimumSize(new java.awt.Dimension(800, 40));
        btnContainer.setPreferredSize(new java.awt.Dimension(800, 40));
        btnContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        addButton.setBackground(new java.awt.Color(255, 169, 140));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(31, 31, 31));
        addButton.setText("Edit Vendor");
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
        wrapper.setBounds(0, 0, 960, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
    }                                       

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        updateVendor();
    }                                                                        

    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel VendorNameLabel;
    private javax.swing.JTextField vendornameTextField;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel FoodCourtNameLabel;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JTextField foodcourtnameTextField;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JLabel dobOutput;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel back_icon;
    private javax.swing.JPanel btnContainer;
    private javax.swing.JPanel cardDetails;
    private javax.swing.JPanel details_1;
    private javax.swing.JPanel details_2;
    private javax.swing.JPanel details_3;
    private javax.swing.JPanel details_4;
    private javax.swing.JPanel details_6;
    private javax.swing.JPanel details_7;
    private javax.swing.JPanel details_8;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JPanel m3;
    private javax.swing.JLabel title;
    private javax.swing.JPanel wrapper;
    private javax.swing.JPanel details_0;
    private javax.swing.JLabel VendorIDLabel;
    private javax.swing.JLabel IDOutput;
    // End of variables declaration                   

}