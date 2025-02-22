package oodj.food_ordering_system.designUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.utils.UserHandling;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.validation;

public class AddRunner extends javax.swing.JFrame {
    

    private String formattedDate;
    private ManageRunner parent;

    public AddRunner(ManageRunner parent) {
        this.parent = parent;
        initComponents();
        setUpDateChooser();
    }

    public AddRunner() {
        initComponents();
        setUpDateChooser();
    }

    private void setUpDateChooser() {
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

    private String selectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public void appendRunner() {
        String username = usernameTextField.getText();
        String fullname = fullnameTextField.getText();
        String email = emailTextField.getText();
        String contactnumber = contactNumberTextField.getText();
        String date = formattedDate;
        String gender = selectedButtonText(buttonGroup);
        String password = new String(PasswordField.getPassword());
        String vehicle = selectedButtonText(buttonGroup1);
        String license = licenseTextField.getText();

        try {
            if (username.equals("") || fullname.equals("") || contactnumber.equals("") || password.equals("") || gender == null || date.equals("" ) || email.equals("") || vehicle.equals("")) {
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
                String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\delivery_runner.txt";
                FileHandling.checkFile(filePath);

                String runnerID = "DR" + String.format("%05d", UserHandling.getDRId() + 1);

                JSONObject newRunner = new JSONObject();
                newRunner.put("RunnerID", runnerID);
                newRunner.put("Username", username);
                newRunner.put("Name", fullname);
                newRunner.put("Phone", contactnumber);
                newRunner.put("Password", password);
                newRunner.put("Gender", gender);
                newRunner.put("DOB", date);
                newRunner.put("Email", email);
                newRunner.put("VehicleType", vehicle);
                newRunner.put("LicensePlate", license);
                newRunner.put("Status", "True");

                JSONArray runnerArray;
                File file = new File(filePath);

                if (file.length() > 0) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line);
                        }
                        runnerArray = new JSONArray(content.toString());
                    }
                } else {
                    runnerArray = new JSONArray();
                }
                runnerArray.put(newRunner);

                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(runnerArray.toString(2)); // Pretty print with indentation
                    fileWriter.flush();
                }

                DialogBox.successMessage("Congratulations, you have successfully added a new runner.", "Success");
                // setVisible(false);
                // new ManageRunner().setVisible(true);
                parent.refreshDeliveryRunnerInfo();
                dispose();
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        wrapper = new javax.swing.JPanel();
        back_icon = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        m2 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        cardDetails = new javax.swing.JPanel();
        details_1 = new javax.swing.JPanel();
        UsernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        details_2 = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        fullnameTextField = new javax.swing.JTextField();
        details_3 = new javax.swing.JPanel();
        EmailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        details_4 = new javax.swing.JPanel();
        PhoneLabel = new javax.swing.JLabel();
        contactNumberTextField = new javax.swing.JTextField();
        details_5 = new javax.swing.JPanel();
        DOBLabel = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        details_6 = new javax.swing.JPanel();
        GenderLabel = new javax.swing.JLabel();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        details_7 = new javax.swing.JPanel();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        details_8 = new javax.swing.JPanel();
        VehicleLabel = new javax.swing.JLabel();
        Car = new javax.swing.JRadioButton();
        Motorcycle = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        details_9 = new javax.swing.JPanel();
        LicenseLabel = new javax.swing.JLabel();
        licenseTextField = new javax.swing.JTextField();
        btnContainer = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();

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
        title.setText("Add New Runner");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(694, 50));
        title.setMinimumSize(new java.awt.Dimension(694, 50));
        title.setPreferredSize(new java.awt.Dimension(694, 50));
        back_icon.add(title);

        wrapper.add(back_icon);

        cardDetails.setBackground(new java.awt.Color(25, 25, 25));
        cardDetails.setMaximumSize(new java.awt.Dimension(800, 200));
        cardDetails.setMinimumSize(new java.awt.Dimension(800, 200));
        cardDetails.setPreferredSize(new java.awt.Dimension(800, 471));
        cardDetails.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

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

        NameLabel.setBackground(new java.awt.Color(25, 25, 25));
        NameLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(245, 251, 254));
        NameLabel.setText("Full Name : ");
        NameLabel.setAlignmentX(0.5F);
        NameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        NameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        NameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_2.add(NameLabel);

        fullnameTextField.setBackground(new java.awt.Color(43, 43, 43));
        fullnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        fullnameTextField.setForeground(new java.awt.Color(245, 251, 254));
        fullnameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fullnameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        fullnameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fullnameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        fullnameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        fullnameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        fullnameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_2.add(fullnameTextField);

        cardDetails.add(details_2);

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

        details_5.setBackground(new java.awt.Color(25, 25, 25));
        details_5.setMaximumSize(new java.awt.Dimension(435, 50));
        details_5.setMinimumSize(new java.awt.Dimension(435, 50));
        details_5.setPreferredSize(new java.awt.Dimension(450, 45));
        details_5.setLayout(new javax.swing.BoxLayout(details_5, javax.swing.BoxLayout.LINE_AXIS));

        DOBLabel.setBackground(new java.awt.Color(25, 25, 25));
        DOBLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        DOBLabel.setForeground(new java.awt.Color(245, 251, 254));
        DOBLabel.setText("Date of Birth :");
        DOBLabel.setAlignmentX(0.5F);
        DOBLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        DOBLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        DOBLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_5.add(DOBLabel);

        jDateChooser.setBackground(new java.awt.Color(43, 43, 43));
        jDateChooser.setForeground(new java.awt.Color(245, 251, 254));
        jDateChooser.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Calendar minDate = Calendar.getInstance();
        minDate.add(Calendar.YEAR, -100);

        jDateChooser.setMinSelectableDate(minDate.getTime());
        jDateChooser.setMaximumSize(new java.awt.Dimension(280, 35));
        jDateChooser.setMinimumSize(new java.awt.Dimension(280, 35));
        jDateChooser.setPreferredSize(new java.awt.Dimension(280, 35));
        details_5.add(jDateChooser);

        cardDetails.add(details_5);

        details_6.setBackground(new java.awt.Color(25, 25, 25));
        details_6.setMaximumSize(new java.awt.Dimension(435, 50));
        details_6.setMinimumSize(new java.awt.Dimension(435, 50));
        details_6.setPreferredSize(new java.awt.Dimension(450, 45));
        details_6.setLayout(new javax.swing.BoxLayout(details_6, javax.swing.BoxLayout.LINE_AXIS));

        GenderLabel.setBackground(new java.awt.Color(25, 25, 25));
        GenderLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        GenderLabel.setForeground(new java.awt.Color(245, 251, 254));
        GenderLabel.setText("Gender :");
        GenderLabel.setAlignmentX(0.5F);
        GenderLabel.setMaximumSize(new java.awt.Dimension(170, 30));
        GenderLabel.setMinimumSize(new java.awt.Dimension(170, 30));
        GenderLabel.setPreferredSize(new java.awt.Dimension(170, 30));
        details_6.add(GenderLabel);

        Male.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        buttonGroup.add(Male);
        Male.setForeground(new java.awt.Color(245, 251, 254));
        Male.setBackground(new java.awt.Color(25, 25, 25));
        Male.setText("Male");
        details_6.add(Male);

        jPanel14.setBackground(new java.awt.Color(25, 25, 25));
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

        details_6.add(jPanel14);

        Female.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        buttonGroup.add(Female);
        Female.setForeground(new java.awt.Color(245, 251, 254));
        Female.setBackground(new java.awt.Color(25, 25, 25));
        Female.setText("Female");
        details_6.add(Female);

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

        details_8.setBackground(new java.awt.Color(25, 25, 25));
        details_8.setMaximumSize(new java.awt.Dimension(435, 50));
        details_8.setMinimumSize(new java.awt.Dimension(435, 50));
        details_8.setPreferredSize(new java.awt.Dimension(450, 45));
        details_8.setLayout(new javax.swing.BoxLayout(details_8, javax.swing.BoxLayout.LINE_AXIS));

        VehicleLabel.setBackground(new java.awt.Color(25, 25, 25));
        VehicleLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        VehicleLabel.setForeground(new java.awt.Color(245, 251, 254));
        VehicleLabel.setText("Vehicle Type :");
        VehicleLabel.setAlignmentX(0.5F);
        VehicleLabel.setMaximumSize(new java.awt.Dimension(170, 30));
        VehicleLabel.setMinimumSize(new java.awt.Dimension(170, 30));
        VehicleLabel.setPreferredSize(new java.awt.Dimension(170, 30));
        details_8.add(VehicleLabel);

        Car.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        buttonGroup1.add(Car);
        Car.setForeground(new java.awt.Color(245, 251, 254));
        Car.setBackground(new java.awt.Color(25, 25, 25));
        Car.setText("Car");
        details_8.add(Car);

        jPanel15.setBackground(new java.awt.Color(25, 25, 25));
        jPanel15.setMaximumSize(new java.awt.Dimension(30, 50));
        jPanel15.setMinimumSize(new java.awt.Dimension(30, 50));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        details_8.add(jPanel15);

        Motorcycle.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        buttonGroup1.add(Motorcycle);
        Motorcycle.setForeground(new java.awt.Color(245, 251, 254));
        Motorcycle.setBackground(new java.awt.Color(25, 25, 25));
        Motorcycle.setText("Motorcycle");
        details_8.add(Motorcycle);

        cardDetails.add(details_8);

        details_9.setBackground(new java.awt.Color(25, 25, 25));
        details_9.setMaximumSize(new java.awt.Dimension(435, 50));
        details_9.setMinimumSize(new java.awt.Dimension(435, 50));
        details_9.setPreferredSize(new java.awt.Dimension(450, 45));
        details_9.setLayout(new javax.swing.BoxLayout(details_9, javax.swing.BoxLayout.LINE_AXIS));

        LicenseLabel.setBackground(new java.awt.Color(25, 25, 25));
        LicenseLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        LicenseLabel.setForeground(new java.awt.Color(245, 251, 254));
        LicenseLabel.setText("License Plate :");
        LicenseLabel.setAlignmentX(0.5F);
        LicenseLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        LicenseLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        LicenseLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        details_9.add(LicenseLabel);

        licenseTextField.setBackground(new java.awt.Color(43, 43, 43));
        licenseTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        licenseTextField.setForeground(new java.awt.Color(245, 251, 254));
        licenseTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        licenseTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        licenseTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        licenseTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        licenseTextField.setMaximumSize(new java.awt.Dimension(280, 35));
        licenseTextField.setMinimumSize(new java.awt.Dimension(280, 35));
        licenseTextField.setPreferredSize(new java.awt.Dimension(280, 35));
        details_9.add(licenseTextField);

        cardDetails.add(details_9);

        wrapper.add(cardDetails);

        btnContainer.setBackground(new java.awt.Color(25, 25, 25));
        btnContainer.setMaximumSize(new java.awt.Dimension(800, 40));
        btnContainer.setMinimumSize(new java.awt.Dimension(800, 40));
        btnContainer.setPreferredSize(new java.awt.Dimension(800, 40));
        btnContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        addButton.setBackground(new java.awt.Color(255, 169, 140));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(31, 31, 31));
        addButton.setText("Add Runner");
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
        appendRunner();
    }                                                                        

    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField fullnameTextField;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel VehicleLabel;
    private javax.swing.JLabel LicenseLabel;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JTextField licenseTextField;
    private javax.swing.JLabel DOBLabel;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JRadioButton Car;
    private javax.swing.JRadioButton Motorcycle;
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
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
    private javax.swing.JPanel details_5;
    private javax.swing.JPanel details_6;
    private javax.swing.JPanel details_7;
    private javax.swing.JPanel details_8;
    private javax.swing.JPanel details_9;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JLabel title;
    private javax.swing.JPanel wrapper;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration                   

}
