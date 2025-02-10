package oodj.food_ordering_system.designUI;

// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import java.util.List;
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.IOException;

// // public class foodDetails extends JFrame {

// //     private String Username;
// //     private String carID;
// //     private ImageIcon icon;
    
// //     public foodDetails(String carID, String Username) {
// //         this.Username = Username;
// //         this.carID = carID;
// //         setTitle(getCarName(carID) + " Details, " + Username);
// //         setSize(1000, 600);
// //         setLocationRelativeTo(null);
// //         setDefaultCloseOperation(EXIT_ON_CLOSE);
// //         setVisible(true);
// //         initComponents();
// //     }

// //     private void initComponents() {

// //         jLabel1 = new javax.swing.JLabel();
// //         jButton1 = new javax.swing.JButton();
// //         jSeparator2 = new javax.swing.JSeparator();
// //         jLabel3 = new javax.swing.JLabel();
// //         jLabel4 = new javax.swing.JLabel();
// //         jLabel5 = new javax.swing.JLabel();
// //         jLabel6 = new javax.swing.JLabel();
// //         jLabel7 = new javax.swing.JLabel();
// //         jLabel8 = new javax.swing.JLabel();
// //         jLabel9 = new javax.swing.JLabel();
// //         jButton3 = new javax.swing.JButton();

// //         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
// //         setPreferredSize(new java.awt.Dimension(1000, 600));
// //         setSize(new java.awt.Dimension(1000, 600));

// //         jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
// //         jLabel1.setText("HyperExo Car Rental");

// //         ImageIcon icon1 = new ImageIcon(getClass().getResource("images\\icons\\Back Icon.png"));
// //         jButton1.setIcon(icon1);
// //         jButton1.addActionListener(e -> {
// //             new UserDashboard(this.Username);
// //             dispose();
// //         });

// //         jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
// //         jLabel3.setText("Ford Mustang Shelby GT500");

// //         String imagePath = findCarImage(carID);
// //         JLabel jLabel2;
// //         if (imagePath != null) {
// //             ImageIcon icon = new ImageIcon(imagePath);
// //             jLabel2 = new JLabel(icon);
// //         } else {
// //             ImageIcon defaultIcon = new ImageIcon(getClass().getResource("images/Car Images/default.jpg"));
// //             jLabel2 = new JLabel(defaultIcon);
// //         }

// //         jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
// //         jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
// //         jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
// //         jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
// //         jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
// //         jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

// //         jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
// //         jButton3.setText("BOOK NOW!");
// //         jButton3.addActionListener(new java.awt.event.ActionListener() {
// //             public void actionPerformed(java.awt.event.ActionEvent evt) {
// //                 new booking(carID, Username);
// //                 dispose();
// //             }
// //         });

// //         List<String[]> carList = UtilityFunctions.loadSpecificCarInfo("src/data/carInfo.txt", carID);
// //         if (carList.size() > 0) {
// //             String[] carData = carList.get(0);
// //             jLabel3.setText(carData[1]); // Car Name
// //             jLabel4.setText("Year Made: " + carData[2]);
// //             jLabel5.setText("Doors: " + carData[3]);
// //             jLabel6.setText("Transmission: " + carData[4]);
// //             jLabel7.setText("Price Per Day: RM " + carData[7]);
// //             jLabel8.setText("Fuel: " + carData[5]);
// //             jLabel9.setText("Engine Capacity: " + carData[6] + "L");
// //         }

// //         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        
// //         getContentPane().setLayout(layout);
// //         layout.setHorizontalGroup(
// //             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
// //             .addGroup(layout.createSequentialGroup()
// //                 .addGap(58, 58, 58)
// //                 .addComponent(jButton1)
// //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
// //                 .addComponent(jLabel1)
// //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
// //                 .addGap(58, 58, 58))
// //             .addComponent(jSeparator2)
// //             .addGroup(layout.createSequentialGroup()
// //                 .addGap(50, 50, 50)
// //                 .addComponent(jLabel3)
// //                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
// //             .addGroup(layout.createSequentialGroup()
// //                 .addContainerGap()
// //                 .addComponent(jLabel2)
// //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
// //                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
// //                     .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
// //                     .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
// //                     .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
// //                     .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
// //                     .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
// //                     .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
// //                     .addGroup(layout.createSequentialGroup()
// //                         .addGap(15, 15, 15)
// //                         .addComponent(jButton3)))
// //                 .addGap(43, 43, 43))
// //         );
// //         layout.setVerticalGroup(
// //             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
// //             .addGroup(layout.createSequentialGroup()
// //                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
// //                     .addGroup(layout.createSequentialGroup()
// //                         .addGap(32, 32, 32)
// //                         .addComponent(jLabel1))
// //                     .addGroup(layout.createSequentialGroup()
// //                         .addGap(23, 23, 23)
// //                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
// //                             .addComponent(jButton1))))
// //                 .addGap(23, 23, 23)
// //                 .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
// //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
// //                 .addComponent(jLabel3)
// //                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
// //                     .addGroup(layout.createSequentialGroup()
// //                         .addGap(12, 12, 12)
// //                         .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
// //                     .addGroup(layout.createSequentialGroup()
// //                         .addGap(32, 32, 32)
// //                         .addComponent(jLabel4)
// //                         .addGap(24, 24, 24)
// //                         .addComponent(jLabel5)
// //                         .addGap(24, 24, 24)
// //                         .addComponent(jLabel6)
// //                         .addGap(24, 24, 24)
// //                         .addComponent(jLabel8)
// //                         .addGap(24, 24, 24)
// //                         .addComponent(jLabel9)
// //                         .addGap(24, 24, 24)
// //                         .addComponent(jLabel7)
// //                         .addGap(26, 26, 26)
// //                         .addComponent(jButton3)))
// //                 .addContainerGap(90, Short.MAX_VALUE))
// //         );
// //         jLabel3.setHorizontalAlignment(JLabel.CENTER);
// //         pack();
// //     }

// //     private javax.swing.JButton jButton1;
// //     private javax.swing.JButton jButton3;
// //     private javax.swing.JLabel jLabel1;
// //     private javax.swing.JLabel jLabel3;
// //     private javax.swing.JLabel jLabel4;
// //     private javax.swing.JLabel jLabel5;
// //     private javax.swing.JLabel jLabel6;
// //     private javax.swing.JLabel jLabel7;
// //     private javax.swing.JLabel jLabel8;
// //     private javax.swing.JLabel jLabel9;
// //     private javax.swing.JSeparator jSeparator2;

// //     private String findCarImage(String carID) {
// //         String imagePath = "src/images/Car Images/";
// //         File folder = new File(imagePath);
// //         File[] files = folder.listFiles();
        
// //         if (files != null) {
// //             for (File file : files) {
// //                 if (file.isFile()) {
// //                     String fileName = file.getName();
// //                     if (fileName.startsWith(carID + "-")) {
// //                         return imagePath + fileName;
// //                     }
// //                 }
// //             }
// //         }
// //         return null;
// //     }

// //     private String getCarName(String carID) {
// //         try {
// //             BufferedReader reader = new BufferedReader(new FileReader("src/data/carInfo.txt"));
// //             String line;
// //             while ((line = reader.readLine()) != null) {
// //                 String[] carData = line.split(",");
// //                 if (carData.length > 0 && carData[0].equals(carID)) {
// //                     reader.close();
// //                     return carData[1]; // Assuming the car name is at index 1
// //                 }
// //             }
// //             reader.close();
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         }
// //         return "Car Name";
// //     }



// import java.io.IOException;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.util.List;

// public class foodDetails extends javax.swing.JFrame {

//     private String menuID;

//     public foodDetails(String menuID) {
//         this.menuID = menuID;
//         initComponents();

//     }


//     @SuppressWarnings("unchecked")
//     // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//     private void initComponents() {

//         wrapper = new javax.swing.JPanel();
//         back_icon = new javax.swing.JPanel();
//         m1 = new javax.swing.JPanel();
//         m2 = new javax.swing.JPanel();
//         backBtn = new javax.swing.JButton();
//         title = new javax.swing.JLabel();
//         m3 = new javax.swing.JPanel();
//         choices = new javax.swing.JPanel();
//         payContainer = new javax.swing.JPanel();
//         payButton = new javax.swing.JButton();

//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//         setBackground(new java.awt.Color(31, 31, 31));
//         setMinimumSize(new java.awt.Dimension(800, 500));
//         setUndecorated(true);
//         setResizable(false);
//         setType(java.awt.Window.Type.POPUP);
//         getContentPane().setLayout(null);

//         wrapper.setBackground(new java.awt.Color(25, 25, 25));
//         wrapper.setMaximumSize(new java.awt.Dimension(800, 500));
//         wrapper.setMinimumSize(new java.awt.Dimension(800, 500));
//         wrapper.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

//         back_icon.setBackground(new java.awt.Color(25, 25, 25));
//         back_icon.setMaximumSize(new java.awt.Dimension(800, 70));
//         back_icon.setMinimumSize(new java.awt.Dimension(800, 70));
//         back_icon.setPreferredSize(new java.awt.Dimension(800, 70));
//         back_icon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

//         m1.setBackground(new java.awt.Color(25, 25, 25));
//         m1.setMaximumSize(new java.awt.Dimension(800, 10));
//         m1.setMinimumSize(new java.awt.Dimension(800, 10));
//         m1.setPreferredSize(new java.awt.Dimension(800, 10));

//         javax.swing.GroupLayout m1Layout = new javax.swing.GroupLayout(m1);
//         m1.setLayout(m1Layout);
//         m1Layout.setHorizontalGroup(
//             m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 800, Short.MAX_VALUE)
//         );
//         m1Layout.setVerticalGroup(
//             m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 10, Short.MAX_VALUE)
//         );

//         back_icon.add(m1);

//         m2.setBackground(new java.awt.Color(25, 25, 25));
//         m2.setMaximumSize(new java.awt.Dimension(10, 43));
//         m2.setMinimumSize(new java.awt.Dimension(10, 43));
//         m2.setPreferredSize(new java.awt.Dimension(10, 43));

//         javax.swing.GroupLayout m2Layout = new javax.swing.GroupLayout(m2);
//         m2.setLayout(m2Layout);
//         m2Layout.setHorizontalGroup(
//             m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 10, Short.MAX_VALUE)
//         );
//         m2Layout.setVerticalGroup(
//             m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 43, Short.MAX_VALUE)
//         );

//         back_icon.add(m2);

//         backBtn.setBackground(new java.awt.Color(25, 25, 25));
//         backBtn.setForeground(new java.awt.Color(245, 251, 254));
//         backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backIcon.png"))); // NOI18N
//         backBtn.setBorder(null);
//         backBtn.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 backBtnActionPerformed(evt);
//             }
//         });
//         back_icon.add(backBtn);

//         title.setBackground(new java.awt.Color(25, 25, 25));
//         title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         title.setForeground(new java.awt.Color(255, 169, 140));
//         title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         title.setText("Pay By");
//         title.setAlignmentX(0.5F);
//         title.setMaximumSize(new java.awt.Dimension(694, 50));
//         title.setMinimumSize(new java.awt.Dimension(694, 50));
//         title.setPreferredSize(new java.awt.Dimension(694, 50));
//         back_icon.add(title);

//         wrapper.add(back_icon);

//         m3.setBackground(new java.awt.Color(25, 25, 25));
//         m3.setMaximumSize(new java.awt.Dimension(800, 30));
//         m3.setMinimumSize(new java.awt.Dimension(800, 30));
//         m3.setPreferredSize(new java.awt.Dimension(800, 20));

//         javax.swing.GroupLayout m3Layout = new javax.swing.GroupLayout(m3);
//         m3.setLayout(m3Layout);
//         m3Layout.setHorizontalGroup(
//             m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 800, Short.MAX_VALUE)
//         );
//         m3Layout.setVerticalGroup(
//             m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 30, Short.MAX_VALUE)
//         );

//         wrapper.add(m3);

//         choices.setBackground(new java.awt.Color(25, 25, 25));
//         choices.setMaximumSize(new java.awt.Dimension(800, 50));
//         choices.setMinimumSize(new java.awt.Dimension(800, 50));
//         choices.setPreferredSize(new java.awt.Dimension(800, 50));
//         choices.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

//         payContainer.setBackground(new java.awt.Color(25, 25, 25));
//         payContainer.setMaximumSize(new java.awt.Dimension(800, 40));
//         payContainer.setMinimumSize(new java.awt.Dimension(800, 40));
//         payContainer.setPreferredSize(new java.awt.Dimension(800, 50));
//         payContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

//         payButton.setBackground(new java.awt.Color(255, 169, 140));
//         payButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//         payButton.setForeground(new java.awt.Color(31, 31, 31));
//         payButton.setText("Pay");
//         payButton.setBorder(null);
//         payButton.setBorderPainted(false);
//         payButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         payButton.setFocusable(false);
//         payButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//         payButton.setMargin(null);
//         payButton.setMaximumSize(new java.awt.Dimension(200, 40));
//         payButton.setMinimumSize(new java.awt.Dimension(200, 40));
//         payButton.setPreferredSize(new java.awt.Dimension(170, 40));
//         payButton.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 payButtonActionPerformed(evt);
//             }
//         });
//         payContainer.add(payButton);

//         wrapper.add(payContainer);

//         getContentPane().add(wrapper);
//         wrapper.setBounds(0, 0, 800, 500);

//         setSize(new java.awt.Dimension(800, 500));
//         setLocationRelativeTo(null);
//     }// </editor-fold>                        

//     private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
//         dispose();
//     }                                       
                                       

//     private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
//         // payment();
//     }         
    
//     public static void main(String[] args) {
//         new foodDetails("MN000001").setVisible(true);
//     }


//     // Variables declaration - do not modify                     
//     private javax.swing.JButton backBtn;
//     private javax.swing.JPanel back_icon;
//     private javax.swing.JPanel choices;
//     private javax.swing.JPanel m1;
//     private javax.swing.JPanel m2;
//     private javax.swing.JPanel m3;
//     private javax.swing.JButton payButton;
//     private javax.swing.JPanel payContainer;
//     private javax.swing.JLabel title;
//     private javax.swing.JPanel wrapper;
//     // End of variables declaration                   
// }


import javax.swing.*;
import java.awt.*;

public class DetailPopup {
    public static void showDetails(String itemName, String imagePath) {
        // Create a JDialog (modal pop-up)
        JDialog dialog = new JDialog();
        dialog.setTitle(itemName);
        dialog.setSize(350, 400);
        dialog.setLayout(new BorderLayout());
        dialog.setModal(true); // Ensures the user interacts with the pop-up first

        // Load Image
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add Image to Dialog
        dialog.add(imageLabel, BorderLayout.CENTER);

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
