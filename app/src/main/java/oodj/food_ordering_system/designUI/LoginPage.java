package oodj.food_ordering_system.designUI;

import oodj.food_ordering_system.models.Manager;
import oodj.food_ordering_system.models.Admin;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.models.DeliveryRunner;
import oodj.food_ordering_system.models.Vendor;
import java.util.ArrayList;
import oodj.food_ordering_system.utils.UserHandling;


public class LoginPage extends javax.swing.JFrame {

    private static Manager endUserMa;

    private static DeliveryRunner endUserDr;

    private static Vendor endUserVD;

    private static Customer endUser;
    //private static CarRS carRS;

    private static Admin endUserAd;

    public static String loginID = "";

    
    public static void setLoginID(String loginID) {
        LoginPage.loginID = loginID;
    }

    //private CarAD CarAD;

    public LoginPage() {
        initComponents();

    }

    public void start() {
        new LoginPage().setVisible(true);
    }

    public int defineUser(String username, String password) {

        ArrayList<Manager> managers = UserHandling.getManagers();
        for (Manager manager : managers) {
            if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())) {
                loginID = manager.getID();
                endUserMa = manager;
                return 1;
            }
        }
        
        
        ArrayList<Admin> admins = UserHandling.getAdmins();

        for (Admin admin : admins) {
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                loginID = admin.getID();
                endUserAd = admin;
                return 2;

            }
        }

        ArrayList<Customer> customers = UserHandling.getCustomers();

        for (Customer customer : customers) {
            if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                loginID = customer.getID();
                endUser = customer;
                return 3;
            }
        }

        ArrayList<DeliveryRunner> deliver = UserHandling.getDeliveries();

        for (DeliveryRunner delivery : deliver) {
            if (username.equals(delivery.getUsername()) && password.equals(delivery.getPassword())) {
                loginID = delivery.getID();
                endUserDr = delivery;
                return 4;
            }
        }

        ArrayList<Vendor> vendors = UserHandling.getVendors();

        for (Vendor vendor : vendors) {
            if (username.equals(vendor.getUsername()) && password.equals(vendor.getPassword())) {
                loginID = vendor.getID();
                endUserVD = vendor;
                return 5;
            }
        }

        return 0;
    }

    public void checkUserExists() {
        String username = usernameTextField.getText();
        String password = new String(PasswordField.getPassword());

        if (username.equals("") || password.equals("")) {
            DialogBox.reminderMessage("Please fill in everything", "Reminder");
            usernameTextField.requestFocus();
        } else {
            switch (defineUser(username, password)) {
                case 1:
                    //setVisible(false);
                    // CarAD = new CarAD();
                    // CarAD.setVisible(true);
                    // TODO Develop Manager Main Menu
                    System.out.println("Manager: "+username+" Logged In");
                    break;
                case 2:
                    setVisible(false);
                    new ManageCustomer().setVisible(true);
                    System.out.println("Admin: "+username+" Logged In");
                    break;
                case 3:
                    DialogBox.successMessage("Welcome back, " + username + "!", "Customer Login Success!");
                    setVisible(false);
                    new CusDash().setVisible(true); 

                    // TODO Develop Customer Main Menu
                    // test

                    System.out.println("Customer: "+username+" Logged In");
                    break;
                case 4:
                    //setVisible(false);
                    //TODO Develop Delivery Runner Main Menu
                    System.out.println("Delivery Runner: "+username+" Logged In");
                    break;
                case 5:
                    //setVisible(false);
                    //TODO Develop Vendor Main Menu
                    setVisible(false);
                    //new VendorTest(loginID).setVisible(true); 
                    System.out.println("Vendor: "+username+" Logged In");
                    break;
                default:
                    DialogBox.errorMessage("Invalid user, please try again", "No user found!");
                    usernameTextField.setText("");
                    PasswordField.setText("");
                    usernameTextField.requestFocus();
                    break;
            }
        }
    }

    public static Customer getEndUser() {
        return endUser;
    }

    // public static CarRS getCarRS() {
    //     return carRS;
    // }

    // public static void setCarRS(CarRS carRS) {
    //     LoginPage.carRS = carRS;
    // }

    public static Admin getEndUserAd() {
        return endUserAd;
    }

    public static Manager getEndUserMa() {
        return endUserMa;
    }

    public static DeliveryRunner getEndUserDr() {
        return endUserDr;
    }

    public static Vendor getEndUserVD() {
        return endUserVD;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        jPanel8 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(25, 25, 25));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(245, 251, 254));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 600));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/food_mobile.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(450, 600));
        jLabel1.setMinimumSize(new java.awt.Dimension(450, 600));
        jLabel1.setPreferredSize(new java.awt.Dimension(450, 600));
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(31, 31, 31));
        jPanel2.setMaximumSize(new java.awt.Dimension(450, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(450, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(450, 600));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jPanel6.setBackground(new java.awt.Color(31, 31, 31));
        jPanel6.setMaximumSize(new java.awt.Dimension(450, 100));
        jPanel6.setMinimumSize(new java.awt.Dimension(450, 100));
        jPanel6.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6);

        jPanel4.setBackground(new java.awt.Color(31, 31, 31));
        jPanel4.setPreferredSize(new java.awt.Dimension(450, 100));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 18, 18));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 169, 140));
        jLabel3.setText("Login");
        jLabel3.setMaximumSize(new java.awt.Dimension(28, 50));
        jPanel4.add(jLabel3);

        jPanel2.add(jPanel4);

        jPanel7.setBackground(new java.awt.Color(31, 31, 31));
        jPanel7.setMaximumSize(new java.awt.Dimension(450, 60));
        jPanel7.setMinimumSize(new java.awt.Dimension(450, 60));
        jPanel7.setName(""); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(450, 60));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7);

        jPanel3.setBackground(new java.awt.Color(31, 31, 31));
        jPanel3.setMaximumSize(new java.awt.Dimension(450, 50));
        jPanel3.setMinimumSize(new java.awt.Dimension(450, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(450, 50));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(245, 251, 254));
        usernameLabel.setText("      Username : ");
        usernameLabel.setAlignmentX(0.5F);
        usernameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        usernameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        usernameLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel3.add(usernameLabel);

        usernameTextField.setBackground(new java.awt.Color(43, 43, 43));
        usernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(245, 251, 254));
        usernameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        usernameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        usernameTextField.setMaximumSize(new java.awt.Dimension(280, 40));
        usernameTextField.setMinimumSize(new java.awt.Dimension(280, 40));
        usernameTextField.setPreferredSize(new java.awt.Dimension(280, 40));
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(usernameTextField);

        jPanel2.add(jPanel3);

        jPanel5.setBackground(new java.awt.Color(31, 31, 31));
        jPanel5.setMaximumSize(new java.awt.Dimension(450, 50));
        jPanel5.setMinimumSize(new java.awt.Dimension(450, 50));
        jPanel5.setPreferredSize(new java.awt.Dimension(450, 50));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(245, 251, 254));
        passwordLabel.setText("      Password : ");
        passwordLabel.setAlignmentX(0.5F);
        passwordLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        passwordLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        passwordLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel5.add(passwordLabel);

        PasswordField.setBackground(new java.awt.Color(43, 43, 43));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(245, 251, 254));
        PasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PasswordField.setCaretColor(new java.awt.Color(245, 251, 254));
        PasswordField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        PasswordField.setMaximumSize(new java.awt.Dimension(280, 40));
        PasswordField.setMinimumSize(new java.awt.Dimension(280, 40));
        PasswordField.setPreferredSize(new java.awt.Dimension(280, 40));
        jPanel5.add(PasswordField);

        jPanel2.add(jPanel5);

        jPanel8.setBackground(new java.awt.Color(31, 31, 31));
        jPanel8.setMaximumSize(new java.awt.Dimension(450, 60));
        jPanel8.setMinimumSize(new java.awt.Dimension(450, 60));
        jPanel8.setName(""); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(450, 60));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8);

        loginButton.setBackground(new java.awt.Color(255, 169, 140));
        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(73, 0, 0));
        loginButton.setText("Login");
        loginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, new java.awt.Color(27, 28, 30), java.awt.Color.black, java.awt.Color.black));
        loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginButton.setMaximumSize(new java.awt.Dimension(230, 45));
        loginButton.setMinimumSize(new java.awt.Dimension(230, 45));
        loginButton.setPreferredSize(new java.awt.Dimension(230, 45));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });
        jPanel2.add(loginButton);

        jPanel9.setBackground(new java.awt.Color(31, 31, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(245, 251, 254));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("New Customer?");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 50));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanel9.add(jLabel2);

        signUpButton.setBackground(new java.awt.Color(31, 31, 31));
        signUpButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 169, 140));
        signUpButton.setText("Sign Up Here!");
        signUpButton.setBorder(null);
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        jPanel9.add(signUpButton);

        jPanel2.add(jPanel9);

        getContentPane().add(jPanel2);

        pack();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(loginButton);
    }// </editor-fold>                        

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    }                                                 

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        checkUserExists();
    }                

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        dispose();
        new RegisterPage().setVisible(true);
        // DialogBox.successMessage("Register Page is not available yet", "Reminder");
    }                                            

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {     
        checkUserExists();                                       
    }                                           

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {                                       

    }                                      

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration                   

    

	
}
