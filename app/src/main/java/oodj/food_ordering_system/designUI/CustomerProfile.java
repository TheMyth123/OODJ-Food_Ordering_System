package oodj.food_ordering_system.designUI;

import javax.swing.JOptionPane;

import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.UserHandling;
import oodj.food_ordering_system.utils.validation;


public class CustomerProfile extends javax.swing.JFrame {

    private Customer endUser;

    public CustomerProfile(Customer endUser) {
        this.endUser = endUser;
        initComponents();
        displayData();
    }
    
    private void displayData() {
        if (endUser != null) {

            usernameOutput.setText(endUser.getUsername());
            fullnameOutput.setText(endUser.getName());
            contactNumberTextField.setText(endUser.getContactnumber());
            PasswordField.setText(endUser.getPassword());
            genderOutput.setText(endUser.getGender());
            dateOutput.setText(endUser.getDOB());
            emailTextField1.setText(endUser.getEmail());
            addressTextField2.setText(endUser.getAddress());


            jTextField1.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "No customer logged in");
        }
    }

    private boolean saveChanges() {
        String updatedContactNumber = contactNumberTextField.getText();
        String updatedPassword = jTextField1.getText();

        String updatedEmail = emailTextField1.getText();
        String updatedAddress = addressTextField2.getText();
        
        Customer customer = LoginPage.getEndUser();
        if (customer == null) {
            DialogBox.errorMessage("No customer found!", "Error");
            return false;
        }

        if (updatedContactNumber.isEmpty() || updatedPassword.isEmpty() || updatedEmail.isEmpty() || updatedAddress.isEmpty()) {
            DialogBox.reminderMessage("Fields cannot be empty", "Reminder");
            return false;
        } else if (!validation.isValidPhone(updatedContactNumber)) {
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
            return false;
        } else if (!validation.isValidPassword(updatedPassword)) {
            jTextField1.setText("");
            DialogBox.errorMessage("Password must be at least 6 characters long and include both letters and numbers.", "Error");
            return false;
        } else if (!validation.isValidEmail(updatedEmail)) {
            emailTextField1.setText("");
            DialogBox.errorMessage("Invalid email format!", "Error");
            return false;
        } else {
            customer.setContactnumber(updatedContactNumber);
            customer.setPassword(updatedPassword);
            customer.setEmail(updatedEmail);
            customer.setAddress(updatedAddress);
            // UserHandling.UpdateCustomer(customer.getID(), updatedContactNumber, updatedPassword, updatedEmail, updatedAddress);
            
            PasswordField.setText(updatedPassword);

            contactNumberTextField.setEditable(false);
            contactNumberTextField.getCaret().setVisible(false);
            contactNumberTextField.setEnabled(false);
            jTextField1.setVisible(false);
            PasswordField.setEditable(false);
            PasswordField.getCaret().setVisible(false);
            PasswordField.setEnabled(false);
            PasswordField.setVisible(true);
            emailTextField1.setEditable(false);
            emailTextField1.getCaret().setVisible(false);
            emailTextField1.setEnabled(false);
            addressTextField2.setEditable(false);
            addressTextField2.getCaret().setVisible(false);
            addressTextField2.setEnabled(false);

            DialogBox.successMessage("Changes have been saved successfully.", "Save Successful");
            return true;
        }
    }

    private void initComponents() {

        Sidebar = new javax.swing.JPanel();
        margin1 = new javax.swing.JPanel();
        Logo_container = new javax.swing.JPanel();
        systemName = new javax.swing.JLabel();
        margin2 = new javax.swing.JPanel();
        btn_container1 = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_booking = new javax.swing.JButton();
        btn_history = new javax.swing.JButton();
        btn_idk = new javax.swing.JButton();
        margin3 = new javax.swing.JPanel();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Sidebar1 = new javax.swing.JPanel();
        margin4 = new javax.swing.JPanel();
        Logo_container1 = new javax.swing.JPanel();
        systemName1 = new javax.swing.JLabel();
        margin5 = new javax.swing.JPanel();
        btn_container3 = new javax.swing.JPanel();
        btn_home1 = new javax.swing.JButton();
        btn_booking1 = new javax.swing.JButton();
        btn_history1 = new javax.swing.JButton();
        btn_idk1 = new javax.swing.JButton();
        margin6 = new javax.swing.JPanel();
        btn_container4 = new javax.swing.JPanel();
        btn_logout1 = new javax.swing.JButton();
        Line = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();
        m4 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        txtbox1 = new javax.swing.JPanel();
        usernameOutput = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        fullnameLabel = new javax.swing.JLabel();
        txtbox2 = new javax.swing.JPanel();
        fullnameOutput = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        contactnumberLabel = new javax.swing.JLabel();
        txtbox3 = new javax.swing.JPanel();
        contactNumberTextField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        txtbox4 = new javax.swing.JPanel();
        PasswordField = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        txtbox7 = new javax.swing.JPanel();
        emailTextField1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        addressLabel1 = new javax.swing.JLabel();
        txtbox8 = new javax.swing.JPanel();
        addressTextField2 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        genderLabel = new javax.swing.JLabel();
        txtbox5 = new javax.swing.JPanel();
        genderOutput = new javax.swing.JLabel();
        m1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        DOBlabel = new javax.swing.JLabel();
        txtbox6 = new javax.swing.JPanel();
        dateOutput = new javax.swing.JLabel();
        m7 = new javax.swing.JPanel();
        Button = new javax.swing.JButton();
        btn_history = new javax.swing.JButton();
        btn_wallet = new javax.swing.JButton();
        btn_cart = new javax.swing.JButton();
        btn_complaint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Connect");
        setBackground(new java.awt.Color(31, 31, 31));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        Sidebar.setBackground(new java.awt.Color(31, 31, 31));
        Sidebar.setAlignmentX(0.0F);
        Sidebar.setAlignmentY(0.0F);
        Sidebar.setMaximumSize(new java.awt.Dimension(300, 670));
        Sidebar.setMinimumSize(new java.awt.Dimension(300, 670));
        Sidebar.setPreferredSize(new java.awt.Dimension(300, 670));
        Sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        margin1.setBackground(new java.awt.Color(31, 31, 31));

        javax.swing.GroupLayout margin1Layout = new javax.swing.GroupLayout(margin1);
        margin1.setLayout(margin1Layout);
        margin1Layout.setHorizontalGroup(
            margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        margin1Layout.setVerticalGroup(
            margin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Sidebar.add(margin1);

        Logo_container.setBackground(new java.awt.Color(31, 31, 31));
        Logo_container.setMaximumSize(new java.awt.Dimension(300, 100));
        Logo_container.setMinimumSize(new java.awt.Dimension(300, 100));
        Logo_container.setPreferredSize(new java.awt.Dimension(300, 100));
        Logo_container.setLayout(new javax.swing.BoxLayout(Logo_container, javax.swing.BoxLayout.LINE_AXIS));

        systemName.setBackground(new java.awt.Color(31, 31, 31));
        systemName.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        systemName.setForeground(new java.awt.Color(255, 169, 140));
        systemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        systemName.setText("Car Connect");
        systemName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        systemName.setAlignmentX(0.5F);
        systemName.setMaximumSize(new java.awt.Dimension(300, 50));
        systemName.setMinimumSize(new java.awt.Dimension(300, 50));
        systemName.setPreferredSize(new java.awt.Dimension(300, 50));
        Logo_container.add(systemName);

        Sidebar.add(Logo_container);

        margin2.setBackground(new java.awt.Color(31, 31, 31));
        margin2.setMaximumSize(new java.awt.Dimension(300, 50));
        margin2.setMinimumSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout margin2Layout = new javax.swing.GroupLayout(margin2);
        margin2.setLayout(margin2Layout);
        margin2Layout.setHorizontalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        margin2Layout.setVerticalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Sidebar.add(margin2);

        btn_container1.setBackground(new java.awt.Color(31, 31, 31));
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 320));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_home.setBackground(new java.awt.Color(31, 31, 31));
        btn_home.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(245, 251, 254));
        btn_home.setText("Home");
        btn_home.setBorder(null);
        btn_home.setBorderPainted(false);
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.setFocusable(false);
        btn_home.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_home.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_home.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_home.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        btn_container1.add(btn_home);

        btn_wallet.setBackground(new java.awt.Color(31, 31, 31));
        btn_wallet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_wallet.setForeground(new java.awt.Color(245, 251, 254));
        btn_wallet.setText("Wallet");
        btn_wallet.setBorder(null);
        btn_wallet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_wallet.setFocusable(false);
        btn_wallet.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_wallet.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_wallet.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_wallet.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_wallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_walletActionPerformed(evt);
            }
        });
        btn_container1.add(btn_wallet);

        btn_cart.setBackground(new java.awt.Color(31, 31, 31));
        btn_cart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_cart.setForeground(new java.awt.Color(245, 251, 254));
        btn_cart.setText("Cart");
        btn_cart.setBorder(null);
        btn_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cart.setFocusable(false);
        btn_cart.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_cart.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_cart.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_cart.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cartActionPerformed(evt);
            }
        });
        btn_container1.add(btn_cart);

        btn_history.setBackground(new java.awt.Color(31, 31, 31));
        btn_history.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_history.setForeground(new java.awt.Color(245, 251, 254));
        btn_history.setText("Order History");
        btn_history.setBorder(null);
        btn_history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_history.setFocusable(false);
        btn_history.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_history.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_history.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_history.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historyActionPerformed(evt);
            }
        });
        btn_container1.add(btn_history);

        btn_complaint.setBackground(new java.awt.Color(31, 31, 31));
        btn_complaint.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_complaint.setForeground(new java.awt.Color(245, 251, 254));
        btn_complaint.setText("Complaint");
        btn_complaint.setBorder(null);
        btn_complaint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_complaint.setDoubleBuffered(true);
        btn_complaint.setFocusable(false);
        btn_complaint.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_complaint.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_complaint.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_complaint.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_complaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_complaintActionPerformed(evt);
            }
        });
        btn_container1.add(btn_complaint);

        Sidebar.add(btn_container1);

        margin3.setBackground(new java.awt.Color(31, 31, 31));
        margin3.setMaximumSize(new java.awt.Dimension(300, 100));
        margin3.setMinimumSize(new java.awt.Dimension(300, 100));
        margin3.setPreferredSize(new java.awt.Dimension(300, 80));

        javax.swing.GroupLayout margin3Layout = new javax.swing.GroupLayout(margin3);
        margin3.setLayout(margin3Layout);
        margin3Layout.setHorizontalGroup(
            margin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        margin3Layout.setVerticalGroup(
            margin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Sidebar.add(margin3);

        btn_container2.setBackground(new java.awt.Color(31, 31, 31));
        btn_container2.setMaximumSize(new java.awt.Dimension(300, 50));
        btn_container2.setMinimumSize(new java.awt.Dimension(300, 50));
        btn_container2.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_container2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        btn_logout.setBackground(new java.awt.Color(31, 31, 31));
        btn_logout.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(245, 251, 254));
        btn_logout.setText("Logout");
        btn_logout.setBorder(null);
        btn_logout.setBorderPainted(false);
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.setFocusable(false);
        btn_logout.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_logout.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_logout.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_logout.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        btn_container2.add(btn_logout);

        Sidebar.add(btn_container2);

        Sidebar1.setBackground(new java.awt.Color(31, 31, 31));
        Sidebar1.setAlignmentX(0.0F);
        Sidebar1.setAlignmentY(0.0F);
        Sidebar1.setMaximumSize(new java.awt.Dimension(300, 670));
        Sidebar1.setMinimumSize(new java.awt.Dimension(300, 670));
        Sidebar1.setPreferredSize(new java.awt.Dimension(300, 670));
        Sidebar1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        margin4.setBackground(new java.awt.Color(31, 31, 31));

        javax.swing.GroupLayout margin4Layout = new javax.swing.GroupLayout(margin4);
        margin4.setLayout(margin4Layout);
        margin4Layout.setHorizontalGroup(
            margin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        margin4Layout.setVerticalGroup(
            margin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Sidebar1.add(margin4);

        Logo_container1.setBackground(new java.awt.Color(31, 31, 31));
        Logo_container1.setMaximumSize(new java.awt.Dimension(300, 100));
        Logo_container1.setMinimumSize(new java.awt.Dimension(300, 100));
        Logo_container1.setPreferredSize(new java.awt.Dimension(300, 100));
        Logo_container1.setLayout(new javax.swing.BoxLayout(Logo_container1, javax.swing.BoxLayout.LINE_AXIS));

        systemName1.setBackground(new java.awt.Color(31, 31, 31));
        systemName1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        systemName1.setForeground(new java.awt.Color(255, 169, 140));
        systemName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        systemName1.setText("Car Connect");
        systemName1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        systemName1.setAlignmentX(0.5F);
        systemName1.setMaximumSize(new java.awt.Dimension(300, 50));
        systemName1.setMinimumSize(new java.awt.Dimension(300, 50));
        systemName1.setPreferredSize(new java.awt.Dimension(300, 50));
        Logo_container1.add(systemName1);

        Sidebar1.add(Logo_container1);

        margin5.setBackground(new java.awt.Color(31, 31, 31));
        margin5.setMaximumSize(new java.awt.Dimension(300, 50));
        margin5.setMinimumSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout margin5Layout = new javax.swing.GroupLayout(margin5);
        margin5.setLayout(margin5Layout);
        margin5Layout.setHorizontalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        margin5Layout.setVerticalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Sidebar1.add(margin5);

        btn_container3.setBackground(new java.awt.Color(31, 31, 31));
        btn_container3.setMaximumSize(new java.awt.Dimension(300, 320));
        btn_container3.setMinimumSize(new java.awt.Dimension(300, 320));
        btn_container3.setPreferredSize(new java.awt.Dimension(300, 320));
        btn_container3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_home1.setBackground(new java.awt.Color(31, 31, 31));
        btn_home1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_home1.setForeground(new java.awt.Color(245, 251, 254));
        btn_home1.setText("Home");
        btn_home1.setBorder(null);
        btn_home1.setBorderPainted(false);
        btn_home1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home1.setFocusable(false);
        btn_home1.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_home1.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_home1.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_home1.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_home1ActionPerformed(evt);
            }
        });
        btn_container3.add(btn_home1);

        btn_booking1.setBackground(new java.awt.Color(31, 31, 31));
        btn_booking1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_booking1.setForeground(new java.awt.Color(245, 251, 254));
        btn_booking1.setText("Make Booking");
        btn_booking1.setBorder(null);
        btn_booking1.setBorderPainted(false);
        btn_booking1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_booking1.setFocusable(false);
        btn_booking1.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_booking1.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_booking1.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_booking1.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_booking1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_booking1ActionPerformed(evt);
            }
        });
        btn_container3.add(btn_booking1);

        btn_history1.setBackground(new java.awt.Color(31, 31, 31));
        btn_history1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_history1.setForeground(new java.awt.Color(245, 251, 254));
        btn_history1.setText("History");
        btn_history1.setBorder(null);
        btn_history1.setBorderPainted(false);
        btn_history1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_history1.setFocusable(false);
        btn_history1.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_history1.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_history1.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_history1.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_history1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_history1ActionPerformed(evt);
            }
        });
        btn_container3.add(btn_history1);

        btn_idk1.setBackground(new java.awt.Color(43, 43, 43));
        btn_idk1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_idk1.setForeground(new java.awt.Color(255, 169, 140));
        btn_idk1.setText("Profile");
        btn_idk1.setBorder(null);
        btn_idk1.setBorderPainted(false);
        btn_idk1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_idk1.setFocusable(false);
        btn_idk1.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_idk1.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_idk1.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_idk1.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_idk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_idk1ActionPerformed(evt);
            }
        });
        btn_container3.add(btn_idk1);

        Sidebar1.add(btn_container3);

        margin6.setBackground(new java.awt.Color(31, 31, 31));
        margin6.setMaximumSize(new java.awt.Dimension(300, 100));
        margin6.setMinimumSize(new java.awt.Dimension(300, 100));
        margin6.setPreferredSize(new java.awt.Dimension(300, 80));

        javax.swing.GroupLayout margin6Layout = new javax.swing.GroupLayout(margin6);
        margin6.setLayout(margin6Layout);
        margin6Layout.setHorizontalGroup(
            margin6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        margin6Layout.setVerticalGroup(
            margin6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Sidebar1.add(margin6);

        btn_container4.setBackground(new java.awt.Color(31, 31, 31));
        btn_container4.setMaximumSize(new java.awt.Dimension(300, 50));
        btn_container4.setMinimumSize(new java.awt.Dimension(300, 50));
        btn_container4.setPreferredSize(new java.awt.Dimension(300, 50));
        btn_container4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        btn_logout1.setBackground(new java.awt.Color(31, 31, 31));
        btn_logout1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_logout1.setForeground(new java.awt.Color(245, 251, 254));
        btn_logout1.setText("Logout");
        btn_logout1.setBorder(null);
        btn_logout1.setBorderPainted(false);
        btn_logout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout1.setFocusable(false);
        btn_logout1.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_logout1.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_logout1.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_logout1.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout1ActionPerformed(evt);
            }
        });
        btn_container4.add(btn_logout1);

        Sidebar1.add(btn_container4);

        Sidebar.add(Sidebar1);

        getContentPane().add(Sidebar);
        Sidebar.setBounds(0, 0, 300, 670);

        Line.setBackground(new java.awt.Color(50, 50, 50));
        Line.setMaximumSize(new java.awt.Dimension(2, 670));
        Line.setMinimumSize(new java.awt.Dimension(2, 670));

        javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
        Line.setLayout(LineLayout);
        LineLayout.setHorizontalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        LineLayout.setVerticalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        getContentPane().add(Line);
        Line.setBounds(300, 0, 2, 670);

        Main.setBackground(new java.awt.Color(31, 31, 31));
        Main.setAlignmentX(0.0F);
        Main.setAlignmentY(0.0F);
        Main.setMaximumSize(new java.awt.Dimension(1000, 670));
        Main.setMinimumSize(new java.awt.Dimension(1000, 670));
        Main.setPreferredSize(new java.awt.Dimension(1000, 670));
        Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        m4.setBackground(new java.awt.Color(31, 31, 31));
        m4.setMaximumSize(new java.awt.Dimension(1000, 50));
        m4.setMinimumSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout m4Layout = new javax.swing.GroupLayout(m4);
        m4.setLayout(m4Layout);
        m4Layout.setHorizontalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m4Layout.setVerticalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Main.add(m4);

        title_container.setBackground(new java.awt.Color(31, 31, 31));
        title_container.setMaximumSize(new java.awt.Dimension(1000, 50));
        title_container.setMinimumSize(new java.awt.Dimension(1000, 50));
        title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
        title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        title.setBackground(new java.awt.Color(31, 31, 31));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 169, 140));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("My Profile");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(200, 50));
        title.setMinimumSize(new java.awt.Dimension(200, 50));
        title.setPreferredSize(new java.awt.Dimension(200, 50));
        title_container.add(title);

        Main.add(title_container);

        jPanel2.setBackground(new java.awt.Color(31, 31, 31));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 30));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(31, 31, 31));
        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 450));
        jPanel3.setMinimumSize(new java.awt.Dimension(1000, 450));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 450));

        jPanel4.setBackground(new java.awt.Color(31, 31, 31));
        jPanel4.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel4.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel4.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(245, 251, 254));
        usernameLabel.setText("Username : ");
        usernameLabel.setAlignmentX(0.5F);
        usernameLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        usernameLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        usernameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel4.add(usernameLabel);

        txtbox1.setBackground(new java.awt.Color(31, 31, 31));
        txtbox1.setFocusable(false);
        txtbox1.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox1.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox1.setLayout(null);

        usernameOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameOutput.setForeground(new java.awt.Color(245, 251, 254));
        usernameOutput.setText("<cus_data>");
        usernameOutput.setMaximumSize(new java.awt.Dimension(280, 40));
        usernameOutput.setMinimumSize(new java.awt.Dimension(280, 40));
        usernameOutput.setPreferredSize(new java.awt.Dimension(280, 40));
        txtbox1.add(usernameOutput);
        usernameOutput.setBounds(0, 0, 280, 40);

        jPanel4.add(txtbox1);

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(31, 31, 31));
        jPanel5.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel5.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel5.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        fullnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fullnameLabel.setForeground(new java.awt.Color(245, 251, 254));
        fullnameLabel.setText("Full Name : ");
        fullnameLabel.setAlignmentX(0.5F);
        fullnameLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        fullnameLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        fullnameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel5.add(fullnameLabel);

        txtbox2.setBackground(new java.awt.Color(31, 31, 31));
        txtbox2.setFocusable(false);
        txtbox2.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox2.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox2.setLayout(null);

        fullnameOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fullnameOutput.setForeground(new java.awt.Color(245, 251, 254));
        fullnameOutput.setText("<cus_data>");
        fullnameOutput.setMaximumSize(new java.awt.Dimension(280, 40));
        fullnameOutput.setMinimumSize(new java.awt.Dimension(280, 40));
        fullnameOutput.setPreferredSize(new java.awt.Dimension(280, 40));
        txtbox2.add(fullnameOutput);
        fullnameOutput.setBounds(0, 0, 280, 40);

        jPanel5.add(txtbox2);

        jPanel3.add(jPanel5);

        jPanel8.setBackground(new java.awt.Color(31, 31, 31));
        jPanel8.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel8.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel8.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        contactnumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contactnumberLabel.setForeground(new java.awt.Color(245, 251, 254));
        contactnumberLabel.setText("Contact Number : ");
        contactnumberLabel.setAlignmentX(0.5F);
        contactnumberLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        contactnumberLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        contactnumberLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel8.add(contactnumberLabel);

        txtbox3.setBackground(new java.awt.Color(31, 31, 31));
        txtbox3.setFocusable(false);
        txtbox3.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox3.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox3.setLayout(null);

        contactNumberTextField.setEditable(false);
        contactNumberTextField.setBackground(new java.awt.Color(43, 43, 43));
        contactNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contactNumberTextField.setForeground(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setText("<cus_data>");
        contactNumberTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contactNumberTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setEnabled(false);
        contactNumberTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        contactNumberTextField.setMaximumSize(new java.awt.Dimension(280, 40));
        contactNumberTextField.setMinimumSize(new java.awt.Dimension(280, 40));
        contactNumberTextField.setPreferredSize(new java.awt.Dimension(280, 40));
        contactNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberTextFieldActionPerformed(evt);
            }
        });
        txtbox3.add(contactNumberTextField);
        contactNumberTextField.setBounds(0, 0, 280, 40);

        jPanel8.add(txtbox3);

        jPanel3.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(31, 31, 31));
        jPanel9.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel9.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel9.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(245, 251, 254));
        passwordLabel.setText("Password : ");
        passwordLabel.setAlignmentX(0.5F);
        passwordLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        passwordLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        passwordLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel9.add(passwordLabel);

        txtbox4.setBackground(new java.awt.Color(31, 31, 31));
        txtbox4.setFocusable(false);
        txtbox4.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox4.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox4.setLayout(null);

        PasswordField.setBackground(new java.awt.Color(43, 43, 43));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(245, 251, 254));
        PasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PasswordField.setCaretColor(new java.awt.Color(245, 251, 254));
        PasswordField.setEnabled(false);
        PasswordField.setMaximumSize(new java.awt.Dimension(280, 40));
        PasswordField.setMinimumSize(new java.awt.Dimension(280, 40));
        PasswordField.setPreferredSize(new java.awt.Dimension(280, 40));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        txtbox4.add(PasswordField);
        PasswordField.setBounds(0, 0, 280, 40);

        jTextField1.setBackground(new java.awt.Color(43, 43, 43));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(245, 251, 254));
        jTextField1.setText("jTextField1");
        jTextField1.setCaretColor(new java.awt.Color(245, 251, 254));
        jTextField1.setCaretPosition(0);
        jTextField1.setEnabled(false);
        jTextField1.setMaximumSize(new java.awt.Dimension(280, 40));
        jTextField1.setMinimumSize(new java.awt.Dimension(280, 40));
        jTextField1.setName(""); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(280, 40));
        txtbox4.add(jTextField1);
        jTextField1.setBounds(0, 0, 280, 40);

        jPanel9.add(txtbox4);

        jPanel3.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(31, 31, 31));
        jPanel10.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel10.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel10.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(245, 251, 254));
        emailLabel.setText("Email : ");
        emailLabel.setAlignmentX(0.5F);
        emailLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        emailLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        emailLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel10.add(emailLabel);

        txtbox7.setBackground(new java.awt.Color(31, 31, 31));
        txtbox7.setFocusable(false);
        txtbox7.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox7.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox7.setLayout(null);

        contactNumberTextField.setEditable(false);
        emailTextField1.setBackground(new java.awt.Color(43, 43, 43));
        emailTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailTextField1.setForeground(new java.awt.Color(245, 251, 254));
        emailTextField1.setText("<cus_data>");
        emailTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emailTextField1.setCaretColor(new java.awt.Color(245, 251, 254));
        emailTextField1.setEnabled(false);
        emailTextField1.setMargin(new java.awt.Insets(4, 10, 4, 6));
        emailTextField1.setMaximumSize(new java.awt.Dimension(280, 40));
        emailTextField1.setMinimumSize(new java.awt.Dimension(280, 40));
        emailTextField1.setPreferredSize(new java.awt.Dimension(280, 40));
        emailTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextField1ActionPerformed(evt);
            }
        });
        txtbox7.add(emailTextField1);
        emailTextField1.setBounds(0, 0, 280, 40);

        jPanel10.add(txtbox7);

        jPanel3.add(jPanel10);

        jPanel13.setBackground(new java.awt.Color(31, 31, 31));
        jPanel13.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel13.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel13.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        addressLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressLabel1.setForeground(new java.awt.Color(245, 251, 254));
        addressLabel1.setText("Address : ");
        addressLabel1.setAlignmentX(0.5F);
        addressLabel1.setMaximumSize(new java.awt.Dimension(200, 30));
        addressLabel1.setMinimumSize(new java.awt.Dimension(200, 30));
        addressLabel1.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel13.add(addressLabel1);

        txtbox8.setBackground(new java.awt.Color(31, 31, 31));
        txtbox8.setFocusable(false);
        txtbox8.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox8.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox8.setLayout(null);

        contactNumberTextField.setEditable(false);
        addressTextField2.setBackground(new java.awt.Color(43, 43, 43));
        addressTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressTextField2.setForeground(new java.awt.Color(245, 251, 254));
        addressTextField2.setText("<cus_data>");
        addressTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addressTextField2.setCaretColor(new java.awt.Color(245, 251, 254));
        addressTextField2.setEnabled(false);
        addressTextField2.setMargin(new java.awt.Insets(4, 10, 4, 6));
        addressTextField2.setMaximumSize(new java.awt.Dimension(280, 40));
        addressTextField2.setMinimumSize(new java.awt.Dimension(280, 40));
        addressTextField2.setPreferredSize(new java.awt.Dimension(280, 40));
        addressTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextField2ActionPerformed(evt);
            }
        });
        txtbox8.add(addressTextField2);
        addressTextField2.setBounds(0, 0, 280, 40);

        jPanel13.add(txtbox8);

        jPanel3.add(jPanel13);

        jPanel11.setBackground(new java.awt.Color(31, 31, 31));
        jPanel11.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel11.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel11.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(245, 251, 254));
        genderLabel.setText("Gender : ");
        genderLabel.setAlignmentX(0.5F);
        genderLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        genderLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        genderLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel11.add(genderLabel);

        txtbox5.setBackground(new java.awt.Color(31, 31, 31));
        txtbox5.setFocusable(false);
        txtbox5.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox5.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox5.setLayout(null);

        genderOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        genderOutput.setForeground(new java.awt.Color(245, 251, 254));
        genderOutput.setText("<cus_data>");
        genderOutput.setMaximumSize(new java.awt.Dimension(280, 40));
        genderOutput.setMinimumSize(new java.awt.Dimension(280, 40));
        genderOutput.setPreferredSize(new java.awt.Dimension(280, 40));
        txtbox5.add(genderOutput);
        genderOutput.setBounds(0, 0, 280, 40);

        m1.setBackground(new java.awt.Color(31, 31, 31));
        m1.setMaximumSize(new java.awt.Dimension(10, 40));
        m1.setMinimumSize(new java.awt.Dimension(10, 40));
        m1.setPreferredSize(new java.awt.Dimension(10, 40));

        javax.swing.GroupLayout m1Layout = new javax.swing.GroupLayout(m1);
        m1.setLayout(m1Layout);
        m1Layout.setHorizontalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        m1Layout.setVerticalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        txtbox5.add(m1);
        m1.setBounds(0, 0, 10, 40);

        jPanel11.add(txtbox5);

        jPanel3.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(31, 31, 31));
        jPanel12.setMaximumSize(new java.awt.Dimension(525, 50));
        jPanel12.setMinimumSize(new java.awt.Dimension(525, 50));
        jPanel12.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        DOBlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DOBlabel.setForeground(new java.awt.Color(245, 251, 254));
        DOBlabel.setText("Date of Born : ");
        DOBlabel.setAlignmentX(0.5F);
        DOBlabel.setMaximumSize(new java.awt.Dimension(200, 30));
        DOBlabel.setMinimumSize(new java.awt.Dimension(200, 30));
        DOBlabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel12.add(DOBlabel);

        txtbox6.setBackground(new java.awt.Color(31, 31, 31));
        txtbox6.setFocusable(false);
        txtbox6.setMaximumSize(new java.awt.Dimension(280, 40));
        txtbox6.setMinimumSize(new java.awt.Dimension(280, 40));
        txtbox6.setLayout(null);

        dateOutput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateOutput.setForeground(new java.awt.Color(245, 251, 254));
        dateOutput.setText("<cus_data>");
        dateOutput.setMaximumSize(new java.awt.Dimension(280, 40));
        dateOutput.setMinimumSize(new java.awt.Dimension(280, 40));
        dateOutput.setPreferredSize(new java.awt.Dimension(280, 40));
        txtbox6.add(dateOutput);
        dateOutput.setBounds(0, 0, 280, 40);

        jPanel12.add(txtbox6);

        jPanel3.add(jPanel12);

        Main.add(jPanel3);

        m7.setBackground(new java.awt.Color(31, 31, 31));
        m7.setMaximumSize(new java.awt.Dimension(1000, 55));
        m7.setMinimumSize(new java.awt.Dimension(1000, 55));
        m7.setPreferredSize(new java.awt.Dimension(1000, 55));
        m7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        Button.setBackground(new java.awt.Color(255, 169, 140));
        Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Button.setForeground(new java.awt.Color(31, 31, 31));
        Button.setText("Edit");
        Button.setBorder(null);
        Button.setBorderPainted(false);
        Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button.setFocusable(false);
        Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button.setMargin(null);
        Button.setMaximumSize(new java.awt.Dimension(250, 50));
        Button.setMinimumSize(new java.awt.Dimension(250, 50));
        Button.setPreferredSize(new java.awt.Dimension(250, 50));
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });
        m7.add(Button);

        Main.add(m7);

        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if ("Edit".equals(Button.getText())) {
            contactNumberTextField.setEnabled(true);
            contactNumberTextField.getCaret().setVisible(true);
            contactNumberTextField.setEditable(true);

            jTextField1.setText(new String(PasswordField.getPassword()));
            jTextField1.setVisible(true);
            jTextField1.setEnabled(true);
            jTextField1.getCaret().setVisible(true);
            jTextField1.setEditable(true);

            PasswordField.setVisible(false);

            Button.setText("Save");
        } else {
            boolean saveSuccessful = saveChanges();
            if (saveSuccessful) {
                Button.setText("Edit");
            }
        }
    }                                      

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
        // new CarRS().setVisible(true);
    }                                        

    private void btn_bookingActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        // new BookingCU().setVisible(true);
    }                                           

    private void btn_historyActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        // new BookingDetailCU().setVisible(true);
    }                                           

    private void btn_idkActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            dispose();
            new LoginPage().setVisible(true);
        }
    }                                          

    private void contactNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btn_home1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btn_booking1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void btn_history1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void btn_idk1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void btn_logout1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void emailTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void addressTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 


    // Variables declaration - do not modify                     
    private javax.swing.JButton Button;
    private javax.swing.JLabel DOBlabel;
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Logo_container1;
    private javax.swing.JPanel Main;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Sidebar1;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JTextField addressTextField2;
    private javax.swing.JButton btn_booking;
    private javax.swing.JButton btn_booking1;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JPanel btn_container3;
    private javax.swing.JPanel btn_container4;
    private javax.swing.JButton btn_history;
    private javax.swing.JButton btn_history1;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_home1;
    private javax.swing.JButton btn_idk;
    private javax.swing.JButton btn_idk1;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_logout1;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JLabel contactnumberLabel;
    private javax.swing.JLabel dateOutput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField1;
    private javax.swing.JLabel fullnameLabel;
    private javax.swing.JLabel fullnameOutput;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel genderOutput;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m4;
    private javax.swing.JPanel m7;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin3;
    private javax.swing.JPanel margin4;
    private javax.swing.JPanel margin5;
    private javax.swing.JPanel margin6;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel systemName;
    private javax.swing.JLabel systemName1;
    private javax.swing.JLabel title;
    private javax.swing.JPanel title_container;
    private javax.swing.JPanel txtbox1;
    private javax.swing.JPanel txtbox2;
    private javax.swing.JPanel txtbox3;
    private javax.swing.JPanel txtbox4;
    private javax.swing.JPanel txtbox5;
    private javax.swing.JPanel txtbox6;
    private javax.swing.JPanel txtbox7;
    private javax.swing.JPanel txtbox8;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameOutput;
    private javax.swing.JButton btn_complaint;
    private javax.swing.JButton btn_wallet;
    private javax.swing.JButton btn_profile;
    // End of variables declaration                   
}