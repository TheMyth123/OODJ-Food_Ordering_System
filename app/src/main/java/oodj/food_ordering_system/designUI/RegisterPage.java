package oodj.food_ordering_system.designUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import oodj.food_ordering_system.utils.DialogBox;

import oodj.food_ordering_system.utils.validation;
import javax.swing.ButtonGroup;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.UserHandling;

public class RegisterPage extends javax.swing.JFrame {

    private String formattedDate;

    public RegisterPage() {
        initComponents();
        jDateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date date = jDateChooser.getDate();
                    if (date != null) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy");
                        formattedDate = formatter.format(date);
                    } else {
                        formattedDate = null;
                    }
                }
            }
        });
    }

    public void start() {
        new RegisterPage().setVisible(true);
    }

    private String selectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    private void appendUser() {
        String username = usernameTextField.getText();
        String fullname = fullnameTextField.getText();
        String gender = selectedButtonText(buttonGroup);
        String date = formattedDate;
        String contactnumber = contactNumberTextField.getText();
        String password = new String(PasswordField.getPassword());
        String email = emailTextField.getText();
        String address = addressTextField.getText();

        try {
            if (username.equals("") || fullname.equals("") || contactnumber.equals("") || password.equals("") || gender == null || date.equals("" ) || email.equals("") || address.equals("")) {
                DialogBox.reminderMessage("Please ensure everything is filled up!", "Reminder");

            } else if (!validation.checkUsername(username)) {
                usernameTextField.setText("");
                DialogBox.errorMessage("Please Change another username", "Username exists!");

            } else if (!validation.nameFormat(fullname)) {
                fullnameTextField.setText("");
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
                String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\customer.txt";
                FileHandling.checkFile(filePath);

                String customerID = "CS" + String.format("%05d", UserHandling.getCUid() + 1);

                JSONObject newCustomer = new JSONObject();
                newCustomer.put("CustomerID", customerID);
                newCustomer.put("Username", username);
                newCustomer.put("Name", fullname);
                newCustomer.put("Phone", contactnumber);
                newCustomer.put("Password", password);
                newCustomer.put("Gender", gender);
                newCustomer.put("DOB", date);
                newCustomer.put("Email", email);
                newCustomer.put("Address", address);
                newCustomer.put("Status", "True");

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
                    customerArray = new JSONArray();
                }
                customerArray.put(newCustomer);

                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(customerArray.toString(2)); // Pretty print with indentation
                    fileWriter.flush();
                }

                DialogBox.successMessage("Congratulations, you have successfully created an account", "Success");
                setVisible(false);
                new LoginPage().setVisible(true);
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel21 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        fullnameLabel = new javax.swing.JLabel();
        fullnameTextField = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        contactnumberLabel = new javax.swing.JLabel();
        contactNumberTextField = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        DOBlabel = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        genderLabel = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        Male = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        Female = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        jPanel16 = new javax.swing.JPanel();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setSize(900,680);
        setBackground(new java.awt.Color(31, 31, 31));
        setMinimumSize(new java.awt.Dimension(900, 680));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, -1));

        jPanel21.setBackground(new java.awt.Color(31, 31, 31));
        jPanel21.setMaximumSize(new java.awt.Dimension(900, 30));
        jPanel21.setMinimumSize(new java.awt.Dimension(900, 30));
        jPanel21.setPreferredSize(new java.awt.Dimension(900, 30));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel21);

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 100));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 18, 18));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 169, 140));
        jLabel1.setText("Sign Up");
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 52));
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 52));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 52));
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);

        jPanel3.setBackground(new java.awt.Color(31, 31, 31));
        jPanel3.setMaximumSize(new java.awt.Dimension(900, 450));
        jPanel3.setMinimumSize(new java.awt.Dimension(900, 450));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 420));

        jPanel4.setBackground(new java.awt.Color(31, 31, 31));
        jPanel4.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel4.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel4.setPreferredSize(new java.awt.Dimension(485, 40));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(245, 251, 254));
        usernameLabel.setText("Username : ");
        usernameLabel.setAlignmentX(0.5F);
        usernameLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        usernameLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        usernameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel4.add(usernameLabel);

        usernameTextField.setBackground(new java.awt.Color(43, 43, 43));
        usernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(245, 251, 254));
        usernameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        usernameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        usernameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        usernameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        usernameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        jPanel4.add(usernameTextField);

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(31, 31, 31));
        jPanel5.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel5.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel5.setPreferredSize(new java.awt.Dimension(485, 45));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        fullnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        fullnameLabel.setForeground(new java.awt.Color(245, 251, 254));
        fullnameLabel.setText("Full Name : ");
        fullnameLabel.setAlignmentX(0.5F);
        fullnameLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        fullnameLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        fullnameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel5.add(fullnameLabel);

        fullnameTextField.setBackground(new java.awt.Color(43, 43, 43));
        fullnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        fullnameTextField.setForeground(new java.awt.Color(245, 251, 254));
        fullnameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fullnameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        fullnameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        fullnameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        fullnameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        fullnameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        fullnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameTextFieldActionPerformed(evt);
            }
        });
        jPanel5.add(fullnameTextField);

        jPanel3.add(jPanel5);

        jPanel15.setBackground(new java.awt.Color(31, 31, 31));
        jPanel15.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel15.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel15.setPreferredSize(new java.awt.Dimension(485, 45));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(245, 251, 254));
        emailLabel.setText("Email:");
        emailLabel.setAlignmentX(0.5F);
        emailLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        emailLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        emailLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel15.add(emailLabel);

        emailTextField.setBackground(new java.awt.Color(43, 43, 43));
        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(245, 251, 254));
        emailTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emailTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        emailTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        emailTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        emailTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        emailTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        jPanel15.add(emailTextField);

        jPanel3.add(jPanel15);

        jPanel8.setBackground(new java.awt.Color(31, 31, 31));
        jPanel8.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel8.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel8.setPreferredSize(new java.awt.Dimension(485, 45));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        contactnumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        contactnumberLabel.setForeground(new java.awt.Color(245, 251, 254));
        contactnumberLabel.setText("Contact Number : ");
        contactnumberLabel.setAlignmentX(0.5F);
        contactnumberLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        contactnumberLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        contactnumberLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel8.add(contactnumberLabel);

        contactNumberTextField.setBackground(new java.awt.Color(43, 43, 43));
        contactNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        contactNumberTextField.setForeground(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contactNumberTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        contactNumberTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        contactNumberTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        contactNumberTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        contactNumberTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        contactNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberTextFieldActionPerformed(evt);
            }
        });
        jPanel8.add(contactNumberTextField);

        jPanel3.add(jPanel8);

        jPanel12.setBackground(new java.awt.Color(31, 31, 31));
        jPanel12.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel12.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel12.setPreferredSize(new java.awt.Dimension(485, 45));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        DOBlabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        DOBlabel.setForeground(new java.awt.Color(245, 251, 254));
        DOBlabel.setText("Date of Birth : ");
        DOBlabel.setAlignmentX(0.5F);
        DOBlabel.setMaximumSize(new java.awt.Dimension(200, 30));
        DOBlabel.setMinimumSize(new java.awt.Dimension(200, 30));
        DOBlabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel12.add(DOBlabel);

        jDateChooser.setBackground(new java.awt.Color(43, 43, 43));
        jDateChooser.setForeground(new java.awt.Color(245, 251, 254));
        jDateChooser.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Calendar minDate = Calendar.getInstance();
        minDate.add(Calendar.YEAR, -100);

        // Calculate the maximum date (13 years ago)
        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.YEAR, -13);
        jDateChooser.setMinSelectableDate(minDate.getTime());
        jDateChooser.setMaxSelectableDate(maxDate.getTime());
        jDateChooser.setMaximumSize(new java.awt.Dimension(280, 35));
        jDateChooser.setMinimumSize(new java.awt.Dimension(280, 35));
        jDateChooser.setPreferredSize(new java.awt.Dimension(280, 35));
        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });
        jPanel12.add(jDateChooser);

        jPanel3.add(jPanel12);

        jPanel11.setBackground(new java.awt.Color(31, 31, 31));
        jPanel11.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel11.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel11.setPreferredSize(new java.awt.Dimension(485, 45));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(245, 251, 254));
        genderLabel.setText("Gender : ");
        genderLabel.setAlignmentX(0.5F);
        genderLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        genderLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        genderLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel11.add(genderLabel);

        jPanel13.setBackground(new java.awt.Color(31, 31, 31));
        jPanel13.setMaximumSize(new java.awt.Dimension(10, 50));
        jPanel13.setMinimumSize(new java.awt.Dimension(10, 50));
        jPanel13.setPreferredSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel13);

        Male.setBackground(new java.awt.Color(31, 31, 31));
        buttonGroup.add(Male);
        Male.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Male.setForeground(new java.awt.Color(245, 251, 254));
        Male.setText("Male");
        Male.setMaximumSize(new java.awt.Dimension(65, 50));
        Male.setMinimumSize(new java.awt.Dimension(65, 50));
        Male.setPreferredSize(new java.awt.Dimension(65, 50));
        jPanel11.add(Male);

        jPanel14.setBackground(new java.awt.Color(31, 31, 31));
        jPanel14.setMaximumSize(new java.awt.Dimension(30, 50));
        jPanel14.setMinimumSize(new java.awt.Dimension(30, 50));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel14);

        Female.setBackground(new java.awt.Color(31, 31, 31));
        buttonGroup.add(Female);
        Female.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Female.setForeground(new java.awt.Color(245, 251, 254));
        Female.setText("Female");
        Female.setMaximumSize(new java.awt.Dimension(83, 50));
        Female.setMinimumSize(new java.awt.Dimension(83, 50));
        Female.setPreferredSize(new java.awt.Dimension(83, 50));
        jPanel11.add(Female);

        jPanel3.add(jPanel11);

        jPanel9.setBackground(new java.awt.Color(31, 31, 31));
        jPanel9.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel9.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel9.setPreferredSize(new java.awt.Dimension(485, 45));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(245, 251, 254));
        passwordLabel.setText("Password : ");
        passwordLabel.setAlignmentX(0.5F);
        passwordLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        passwordLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        passwordLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel9.add(passwordLabel);

        PasswordField.setBackground(new java.awt.Color(43, 43, 43));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(245, 251, 254));
        PasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PasswordField.setCaretColor(new java.awt.Color(245, 251, 254));
        PasswordField.setMaximumSize(new java.awt.Dimension(280, 35));
        PasswordField.setMinimumSize(new java.awt.Dimension(280, 35));
        PasswordField.setPreferredSize(new java.awt.Dimension(280, 35));
        jPanel9.add(PasswordField);

        jPanel3.add(jPanel9);

        jPanel16.setBackground(new java.awt.Color(31, 31, 31));
        jPanel16.setMaximumSize(new java.awt.Dimension(485, 45));
        jPanel16.setMinimumSize(new java.awt.Dimension(485, 45));
        jPanel16.setPreferredSize(new java.awt.Dimension(485, 45));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(245, 251, 254));
        addressLabel.setText("Address:");
        addressLabel.setAlignmentX(0.5F);
        addressLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        addressLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        addressLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel16.add(addressLabel);

        addressTextField.setBackground(new java.awt.Color(43, 43, 43));
        addressTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        addressTextField.setForeground(new java.awt.Color(245, 251, 254));
        addressTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addressTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        addressTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        addressTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        addressTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        addressTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });
        jPanel16.add(addressTextField);

        jPanel3.add(jPanel16);

        getContentPane().add(jPanel3);

        jPanel17.setBackground(new java.awt.Color(31, 31, 31));
        jPanel17.setAlignmentX(0.0F);
        jPanel17.setAlignmentY(0.0F);
        jPanel17.setMaximumSize(new java.awt.Dimension(900, 90));
        jPanel17.setMinimumSize(new java.awt.Dimension(900, 90));
        jPanel17.setPreferredSize(new java.awt.Dimension(900, 90));
        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jPanel19.setBackground(new java.awt.Color(31, 31, 31));
        jPanel19.setMaximumSize(new java.awt.Dimension(900, 50));
        jPanel19.setMinimumSize(new java.awt.Dimension(900, 50));
        jPanel19.setPreferredSize(new java.awt.Dimension(900, 50));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        registerButton.setBackground(new java.awt.Color(255, 169, 140));
        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(73, 0, 0));
        registerButton.setText("Register");
        registerButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, new java.awt.Color(27, 28, 30), java.awt.Color.black, java.awt.Color.black));
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton.setMaximumSize(new java.awt.Dimension(180, 45));
        registerButton.setMinimumSize(new java.awt.Dimension(180, 45));
        registerButton.setPreferredSize(new java.awt.Dimension(180, 45));
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        jPanel19.add(registerButton);

        jPanel17.add(jPanel19);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(245, 251, 254));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Already have an account?");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(new java.awt.Dimension(190, 50));
        jLabel2.setMinimumSize(new java.awt.Dimension(190, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(190, 50));
        jPanel17.add(jLabel2);

        loginButton.setBackground(new java.awt.Color(31, 31, 31));
        loginButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 169, 140));
        loginButton.setText("Go to Login");
        loginButton.setBorder(null);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel17.add(loginButton);

        getContentPane().add(jPanel17);

        jPanel20.setBackground(new java.awt.Color(31, 31, 31));
        jPanel20.setMaximumSize(new java.awt.Dimension(900, 50));
        jPanel20.setMinimumSize(new java.awt.Dimension(900, 50));
        jPanel20.setPreferredSize(new java.awt.Dimension(900, 50));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel20);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    }                                                 

    private void fullnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    }                                                 

    private void contactNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                       
    }                                                      

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {                                            
    }                                           

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        appendUser();
    }                                              

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
        new LoginPage().start();
    }                                           

    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {                                            

    }                                           

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                        
    }                                                       

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                        
    }                                                       

    // public static void main(String args[]) {

    //     java.awt.EventQueue.invokeLater(() -> {
    //         new RegisterPage().setVisible(true);

    //     });
    // }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel DOBlabel;
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel contactnumberLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel fullnameLabel;
    private javax.swing.JTextField fullnameTextField;
    private javax.swing.JLabel genderLabel;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration                   
}
