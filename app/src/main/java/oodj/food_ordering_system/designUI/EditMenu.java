package oodj.food_ordering_system.designUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONArray;
import org.json.JSONObject;

import oodj.food_ordering_system.models.Menu;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.validation;

public class EditMenu extends javax.swing.JFrame {

    private ManageMenu parent;
    private Menu menu;

    // public EditMenu(ManageMenu parent, Menu menu) {
    //     this.parent = parent;
    //     this.menu = menu;
    //     initComponents();
    //     displayMenuDetails();
    // }

    public EditMenu(ManageMenu parent, String status, String menuID, String vendorID, String name, String description, String price, String imagePath) {
        this.parent = parent;
        this.menu = new Menu(menuID, status, vendorID, name, description, price, imagePath);
        initComponents();
        displayMenuDetails();
    }

    private void displayMenuDetails() {
        IDOutput.setText(menu.getId());
        nameTextField.setText(menu.getName());
        descTextField.setText(menu.getDescription());
        priceTextField.setText(menu.getPrice());
        imageTextField.setText(menu.getImagePath());
    }
    
    public void updateMenu() {
        String menuID = IDOutput.getText();
        String name = nameTextField.getText();
        String desc = descTextField.getText();
        String price = priceTextField.getText();
        String image = imageTextField.getText();

        try {
            if (name.equals("") || desc.equals("") || price.equals("") || image.equals("")) {
                DialogBox.reminderMessage("Please ensure everything is filled up!", "Reminder");

            } else if (!validation.nameFormat(name)) {
                nameTextField.setText("");
                DialogBox.errorMessage("Please re-enter menu name!", "Spaces more than once");

            } else if (!validation.nameFormat(desc)) {
                descTextField.setText("");
                DialogBox.errorMessage("Please re-enter description!", "Spaces more than once");

            } else if (!validation.nameFormat(price)) {
                priceTextField.setText("");
                DialogBox.errorMessage("Please re-enter menu price", "Invalid menu price!");

            } else if (!validation.nameFormat(image)) {
                imageTextField.setText("");
                DialogBox.errorMessage("xxx", "Error uploading image");

            } else {
                String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\menu.txt";
                FileHandling.checkFile(filePath);

                JSONArray menuArray;
                File file = new File(filePath);

                if (file.length() > 0) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line);
                        }
                        menuArray = new JSONArray(content.toString());
                    }
                } else {
                    DialogBox.errorMessage("No menu data found to edit.", "Error");
                    return;
                }

                boolean menuFound = false;
                for (int i = 0; i < menuArray.length(); i++) {
                    JSONObject menu = menuArray.getJSONObject(i);
                    if (menu.getString("id").equals(menuID)) {
                        // Update the menu's data
                        menu.put("name", name);
                        menu.put("description", desc);
                        menu.put("price", price);
                        menu.put("image", image);
                        menuFound = true;
                        break;
                    }
                }

                if (!menuFound) {
                    DialogBox.errorMessage("Menu with ID " + menuID + " not found.", "Error");
                    return;
                }

                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(menuArray.toString(2)); // Pretty print with indentation
                    fileWriter.flush();
                }

                DialogBox.successMessage("Menu data updated successfully.", "Success");
                parent.refreshMenuInfo();
                dispose();
            }
        } catch (IOException e) {
            DialogBox.errorMessage("Something went wrong, please try again...", "IO Error");
        }
    }

    private void browseImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an Image");
        
        // Set file filter to only allow images
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            imageTextField.setText(filePath);

            // Copy image to project folder (Optional)
            saveImageToProject(selectedFile);
        }
    }

    private void saveImageToProject(File file) {
        try {
            Path source = file.toPath();
            Path destination = Paths.get("app/src/main/resources/images/" + file.getName()); // Change destination path as needed

            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            imageTextField.setText(destination.toString()); // Update field with new path
        } catch (Exception e) {
            DialogBox.errorMessage("Failed to save image.", "Error");
            e.printStackTrace();
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
        cardDetails = new javax.swing.JPanel();
        details_1 = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        // usernameTextField = new javax.swing.JTextField();
        details_2 = new javax.swing.JPanel();
        DescLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        details_3 = new javax.swing.JPanel();
        PriceLabel = new javax.swing.JLabel();
        // descTextField = new javax.swing.JTextField();
        descTextField = new javax.swing.JTextArea();
        details_4 = new javax.swing.JPanel();
        ImageLabel = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        // details_5 = new javax.swing.JPanel();
        // DOBLabel = new javax.swing.JLabel();
        // jDateChooser = new com.toedter.calendar.JDateChooser();
        // details_6 = new javax.swing.JPanel();
        // GenderLabel = new javax.swing.JLabel();
        // GenderOutput = new javax.swing.JLabel();
        // details_7 = new javax.swing.JPanel();
        // PasswordLabel = new javax.swing.JLabel();
        // PasswordField = new javax.swing.JPasswordField();
        // details_8 = new javax.swing.JPanel();
        // AddressLabel = new javax.swing.JLabel();
        imageTextField = new javax.swing.JTextField();
        btnContainer = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        details_0 = new javax.swing.JPanel();
        MenuIDLabel = new javax.swing.JLabel();
        IDOutput = new javax.swing.JLabel();
        btnBrowseImage = new javax.swing.JButton();

    

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
    title.setText("Edit Menu Details");
    title.setAlignmentX(0.5F);
    title.setMaximumSize(new java.awt.Dimension(694, 50));
    title.setMinimumSize(new java.awt.Dimension(694, 50));
    title.setPreferredSize(new java.awt.Dimension(694, 50));
    back_icon.add(title);

    wrapper.add(back_icon);

    cardDetails.setBackground(new java.awt.Color(25, 25, 25));
    cardDetails.setMaximumSize(new java.awt.Dimension(800, 200));
    cardDetails.setMinimumSize(new java.awt.Dimension(800, 200));
    cardDetails.setPreferredSize(new java.awt.Dimension(800, 470));
    cardDetails.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

    details_0.setBackground(new java.awt.Color(25, 25, 25));
    details_0.setMaximumSize(new java.awt.Dimension(435, 50));
    details_0.setMinimumSize(new java.awt.Dimension(435, 50));
    details_0.setPreferredSize(new java.awt.Dimension(450, 45));
    details_0.setLayout(new javax.swing.BoxLayout(details_0, javax.swing.BoxLayout.LINE_AXIS));

    MenuIDLabel.setBackground(new java.awt.Color(25, 25, 25));
    MenuIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
    MenuIDLabel.setForeground(new java.awt.Color(245, 251, 254));
    MenuIDLabel.setText("Menu ID :");
    MenuIDLabel.setAlignmentX(0.5F);
    MenuIDLabel.setMaximumSize(new java.awt.Dimension(150, 30));
    MenuIDLabel.setMinimumSize(new java.awt.Dimension(150, 30));
    MenuIDLabel.setPreferredSize(new java.awt.Dimension(200, 30));
    details_0.add(MenuIDLabel);

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

    NameLabel.setBackground(new java.awt.Color(25, 25, 25));
    NameLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
    NameLabel.setForeground(new java.awt.Color(245, 251, 254));
    NameLabel.setText("Name :");
    NameLabel.setAlignmentX(0.5F);
    NameLabel.setMaximumSize(new java.awt.Dimension(150, 30));
    NameLabel.setMinimumSize(new java.awt.Dimension(150, 30));
    NameLabel.setPreferredSize(new java.awt.Dimension(200, 30));
    details_1.add(NameLabel);

    nameTextField.setBackground(new java.awt.Color(43, 43, 43));
    nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
    nameTextField.setForeground(new java.awt.Color(245, 251, 254));
    nameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    nameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
    nameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    nameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
    nameTextField.setMaximumSize(new java.awt.Dimension(280, 35));
    nameTextField.setMinimumSize(new java.awt.Dimension(280, 35));
    nameTextField.setPreferredSize(new java.awt.Dimension(280, 35));
    details_1.add(nameTextField);

    cardDetails.add(details_1);

    details_2.setBackground(new java.awt.Color(25, 25, 25));
    details_2.setMaximumSize(new java.awt.Dimension(435, 50));
    details_2.setMinimumSize(new java.awt.Dimension(435, 50));
    details_2.setPreferredSize(new java.awt.Dimension(450, 110));
    details_2.setLayout(new javax.swing.BoxLayout(details_2, javax.swing.BoxLayout.LINE_AXIS));

    DescLabel.setBackground(new java.awt.Color(25, 25, 25));
    DescLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
    DescLabel.setForeground(new java.awt.Color(245, 251, 254));
    DescLabel.setText("Description : ");
    DescLabel.setAlignmentX(0.5F);
    DescLabel.setMaximumSize(new java.awt.Dimension(150, 30));
    DescLabel.setMinimumSize(new java.awt.Dimension(150, 30));
    DescLabel.setPreferredSize(new java.awt.Dimension(200, 30));
    details_2.add(DescLabel);

    // descTextField.setBackground(new java.awt.Color(43, 43, 43));
    // descTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
    // descTextField.setForeground(new java.awt.Color(245, 251, 254));
    // descTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    // descTextField.setCaretColor(new java.awt.Color(245, 251, 254));
    // descTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    // descTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
    // descTextField.setMaximumSize(new java.awt.Dimension(280, 35));
    // descTextField.setMinimumSize(new java.awt.Dimension(280, 35));
    // descTextField.setPreferredSize(new java.awt.Dimension(280, 35));
    // details_2.add(descTextField);

    descTextField = new javax.swing.JTextArea();
    descTextField.setBackground(new java.awt.Color(43, 43, 43));
    descTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // Match font style
    descTextField.setForeground(new java.awt.Color(245, 251, 254));
    descTextField.setLineWrap(true); // Enable text wrapping
    descTextField.setWrapStyleWord(true); // Wrap by words
    descTextField.setCaretColor(new java.awt.Color(245, 251, 254));
    descTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    descTextField.setAlignmentX(0.5F);
    descTextField.setMaximumSize(new java.awt.Dimension(280, 100)); 
    descTextField.setMinimumSize(new java.awt.Dimension(280, 100));
    descTextField.setPreferredSize(new java.awt.Dimension(280, 100)); 
    details_2.add(descTextField);    

    cardDetails.add(details_2);

    details_3.setBackground(new java.awt.Color(25, 25, 25));
    details_3.setMaximumSize(new java.awt.Dimension(435, 50));
    details_3.setMinimumSize(new java.awt.Dimension(435, 50));
    details_3.setPreferredSize(new java.awt.Dimension(450, 45));
    details_3.setLayout(new javax.swing.BoxLayout(details_3, javax.swing.BoxLayout.LINE_AXIS));

    PriceLabel.setBackground(new java.awt.Color(25, 25, 25));
    PriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
    PriceLabel.setForeground(new java.awt.Color(245, 251, 254));
    PriceLabel.setText("Price :");
    PriceLabel.setAlignmentX(0.5F);
    PriceLabel.setMaximumSize(new java.awt.Dimension(150, 30));
    PriceLabel.setMinimumSize(new java.awt.Dimension(150, 30));
    PriceLabel.setPreferredSize(new java.awt.Dimension(200, 30));
    details_3.add(PriceLabel);

    priceTextField.setBackground(new java.awt.Color(43, 43, 43));
    priceTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
    priceTextField.setForeground(new java.awt.Color(245, 251, 254));
    priceTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    priceTextField.setCaretColor(new java.awt.Color(245, 251, 254));
    priceTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    priceTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
    priceTextField.setMaximumSize(new java.awt.Dimension(280, 35));
    priceTextField.setMinimumSize(new java.awt.Dimension(280, 35));
    priceTextField.setPreferredSize(new java.awt.Dimension(280, 35));
    details_3.add(priceTextField);

    cardDetails.add(details_3);

    details_4.setBackground(new java.awt.Color(25, 25, 25));
    details_4.setMaximumSize(new java.awt.Dimension(435, 50));
    details_4.setMinimumSize(new java.awt.Dimension(435, 50));
    details_4.setPreferredSize(new java.awt.Dimension(450, 45));
    details_4.setLayout(new javax.swing.BoxLayout(details_4, javax.swing.BoxLayout.LINE_AXIS));

    ImageLabel.setBackground(new java.awt.Color(25, 25, 25));
        ImageLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        ImageLabel.setForeground(new java.awt.Color(245, 251, 254));
        ImageLabel.setText("Image :");
        ImageLabel.setPreferredSize(new java.awt.Dimension(200, 30));

        details_4.add(ImageLabel);

        imageTextField.setBackground(new java.awt.Color(43, 43, 43));
        imageTextField.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        imageTextField.setForeground(new java.awt.Color(245, 251, 254));
        imageTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imageTextField.setEditable(false);
        imageTextField.setPreferredSize(new java.awt.Dimension(280, 35));

        details_4.add(imageTextField);

        btnBrowseImage.setBackground(new java.awt.Color(255, 169, 140));
        btnBrowseImage.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnBrowseImage.setForeground(new java.awt.Color(31, 31, 31));
        btnBrowseImage.setText("Browse");
        btnBrowseImage.setBorder(null);
        btnBrowseImage.setPreferredSize(new java.awt.Dimension(50, 35));
        btnBrowseImage.addActionListener(evt -> browseImage());

    details_4.add(btnBrowseImage);

    cardDetails.add(details_4);

    wrapper.add(cardDetails);

    btnContainer.setBackground(new java.awt.Color(25, 25, 25));
    btnContainer.setMaximumSize(new java.awt.Dimension(800, 40));
    btnContainer.setMinimumSize(new java.awt.Dimension(800, 40));
    btnContainer.setPreferredSize(new java.awt.Dimension(800, 40));
    btnContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

    editButton.setBackground(new java.awt.Color(255, 169, 140));
    editButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    editButton.setForeground(new java.awt.Color(31, 31, 31));
    editButton.setText("Edit Menu");
    editButton.setBorder(null);
    editButton.setBorderPainted(false);
    editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    editButton.setFocusable(false);
    editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    editButton.setMargin(null);
    editButton.setMaximumSize(new java.awt.Dimension(200, 40));
    editButton.setMinimumSize(new java.awt.Dimension(200, 40));
    editButton.setPreferredSize(new java.awt.Dimension(170, 40));
    editButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addButtonActionPerformed(evt);
        }
    });
    btnContainer.add(editButton);

    wrapper.add(btnContainer);

    getContentPane().add(wrapper);
    wrapper.setBounds(0, 0, 960, 600);

    pack();
    setLocationRelativeTo(null);

    } // </editor-fold> 

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
    }                                       

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        updateMenu();
    }   

    // Variables declaration - do not modify                     
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel DescLabel;
    // private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel PriceLabel;
    //private javax.swing.JTextField descTextField;
    private javax.swing.JTextArea descTextField;
    // private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel ImageLabel;
    // private javax.swing.JLabel GenderLabel;
    // private javax.swing.JLabel PasswordLabel;
    // private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTextField imageTextField;
    // private javax.swing.JLabel DOBLabel;
    // private com.toedter.calendar.JDateChooser jDateChooser;
    // private javax.swing.JLabel GenderOutput;
    // private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton editButton;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel back_icon;
    private javax.swing.JPanel btnContainer;
    private javax.swing.JPanel cardDetails;
    private javax.swing.JPanel details_1;
    private javax.swing.JPanel details_2;
    private javax.swing.JPanel details_3;
    private javax.swing.JPanel details_4;
    // private javax.swing.JPanel details_5;
    // private javax.swing.JPanel details_6;
    // private javax.swing.JPanel details_7;
    // private javax.swing.JPanel details_8;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JLabel title;
    private javax.swing.JPanel wrapper;
    private javax.swing.JPanel details_0;
    private javax.swing.JLabel MenuIDLabel;
    private javax.swing.JLabel IDOutput;
    private javax.swing.JButton btnBrowseImage;
    // End of variables declaration   

}            