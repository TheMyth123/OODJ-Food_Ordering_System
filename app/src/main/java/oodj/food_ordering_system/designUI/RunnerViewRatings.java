package oodj.food_ordering_system.designUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import oodj.food_ordering_system.models.DeliveryRunner;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.UserHandling;
import raven.glasspanepopup.DefaultLayoutCallBack;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;

public class RunnerViewRatings extends javax.swing.JFrame {
    private DeliveryRunner endUser;
    private String runnerID;
    private List<Notification> notifications;

    public RunnerViewRatings() {
        GlassPanePopup.install(this);
        this.endUser = LoginPage.getEndUserDr();
        this.runnerID = endUser.getID();
        initComponents();
        loadDetails();
        loadRatingsTable();  // Load and display the ratings table below the title
        notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications(), runnerID, false);
    }

    private void loadDetails() {
        // Initialize counters for the calculations
        int completedDeliveries = 0;
        double totalEarnings = 0.0;
        int totalDeliveryTime = 0; // in minutes

        // Specify the file path for the delivery tasks data
        String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\delivery_runner_task.txt";
        JSONArray taskArray;
        File file = new File(filePath);

        // Read the file if it's not empty
        if (file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                taskArray = new JSONArray(content.toString());
            } catch (IOException e) {
                DialogBox.errorMessage("Error reading delivery task data file.", "Error");
                e.printStackTrace();
                return;
            }
        } else {
            DialogBox.errorMessage("No delivery task data found.", "Error");
            return;
        }

        // Process each task in the JSON array
        for (int i = 0; i < taskArray.length(); i++) {
            JSONObject task = taskArray.getJSONObject(i);
            String taskRunnerID = task.getString("RunnerID");
            String taskStatus = task.getString("TaskStatus");

            // Only consider tasks for this runner that are completed
            if (taskRunnerID.equals(this.runnerID) && "completed".equalsIgnoreCase(taskStatus)) {
                completedDeliveries++;
                totalEarnings += task.getDouble("DeliveryFee");

                // Extract the numeric part from EstimatedTime (e.g., "35 minutes")
                String estimatedTime = task.getString("EstimatedTime");
                int minutes = 0;
                try {
                    minutes = Integer.parseInt(estimatedTime.replaceAll("[^0-9]", ""));
                } catch (NumberFormatException e) {
                    minutes = 0;
                }
                totalDeliveryTime += minutes;
            }
        }

        // Calculate averages (guard against division by zero)
        int averageDeliveryTime = completedDeliveries > 0 ? totalDeliveryTime / completedDeliveries : 0;
        double averageDeliveryFee = completedDeliveries > 0 ? totalEarnings / completedDeliveries : 0.0;

        // Update the UI labels with the calculated data
        totalDeliveriesLabel.setText(String.valueOf(completedDeliveries));
        totalEarningsLabel.setText(String.format("%.2f", totalEarnings));
        averageDeliveryTimeLabel.setText(String.valueOf(averageDeliveryTime));
        averageDeliveryFeeLabel.setText(String.format("%.2f", averageDeliveryFee));
    }

    private void loadRatingsTable() {
        // Create a set to hold OrderIDs for the current runner from delivery_runner_task.txt
        Set<String> runnerOrderIDs = new HashSet<>();
        String taskFilePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\delivery_runner_task.txt";
        JSONArray taskArray;
        File taskFile = new File(taskFilePath);
        if (taskFile.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(taskFilePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                taskArray = new JSONArray(content.toString());
                for (int i = 0; i < taskArray.length(); i++) {
                    JSONObject task = taskArray.getJSONObject(i);
                    if (task.getString("RunnerID").equals(this.runnerID)) {
                        runnerOrderIDs.add(task.getString("OrderID"));
                    }
                }
            } catch (IOException e) {
                DialogBox.errorMessage("Error reading delivery task data file.", "Error");
                e.printStackTrace();
                return;
            }
        } else {
            DialogBox.errorMessage("No delivery task data found.", "Error");
            return;
        }
    
        // Read rating.txt and filter for entries with RatingType "RUNNER" for the runner's orders
        String ratingFilePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\rating.txt";
        JSONArray ratingArray;
        File ratingFile = new File(ratingFilePath);
        List<Object[]> rows = new ArrayList<>();
        if (ratingFile.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ratingFilePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                ratingArray = new JSONArray(content.toString());
                for (int i = 0; i < ratingArray.length(); i++) {
                    JSONObject ratingObj = ratingArray.getJSONObject(i);
                    if (ratingObj.getString("RatingType").equalsIgnoreCase("RUNNER") &&
                        runnerOrderIDs.contains(ratingObj.getString("OrderID"))) {
                        String orderId = ratingObj.getString("OrderID");
                        String ratingType = ratingObj.getString("RatingType");
                        int ratingValue = ratingObj.getInt("Rating");
                        rows.add(new Object[]{orderId, ratingType, ratingValue});
                    }
                }
            } catch (IOException e) {
                DialogBox.errorMessage("Error reading rating data file.", "Error");
                e.printStackTrace();
                return;
            }
        } else {
            DialogBox.errorMessage("No rating data found.", "Error");
            return;
        }
    
        // Create the table model and add the rows
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("OrderID");
        model.addColumn("Rating Type");
        model.addColumn("Rating (out of 5)");
        for (Object[] row : rows) {
            model.addRow(row);
        }
    
        // Create the table and add it to a scroll pane with an increased preferred size
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new java.awt.Dimension(900, 450));
    
        // Create a container panel with BorderLayout to center the scrollPane
        javax.swing.JPanel containerPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
        containerPanel.setBackground(Main.getBackground());
        // Add an empty border to add some margin on the left and right (50 pixels each)
        containerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 50, 0, 50));
        containerPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
    
        // Add the container panel to the Main panel
        Main.add(containerPanel);
        Main.revalidate();
        Main.repaint();
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Sidebar = new javax.swing.JPanel();
        margin1 = new javax.swing.JPanel();
        Logo_container = new javax.swing.JPanel();
        systemName = new javax.swing.JLabel();
        btn_container1 = new javax.swing.JPanel();
        btn_RevenueDashboard = new javax.swing.JButton();
        btn_reviews = new javax.swing.JButton();
        btn_ManageTasks = new javax.swing.JButton();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Line = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();
        margin2 = new javax.swing.JPanel();
        margin4 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        margin5 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        totalDeliveriesLabel = new javax.swing.JLabel();
        totalEarningsLabel = new javax.swing.JLabel();
        averageDeliveryTimeLabel = new javax.swing.JLabel();
        averageDeliveryFeeLabel = new javax.swing.JLabel();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Connect - Admin");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(25, 25, 25));
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
        systemName.setText("Food Connect");
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
        margin2.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout margin2Layout = new javax.swing.GroupLayout(margin2);
        margin2.setLayout(margin2Layout);
        margin2Layout.setHorizontalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        margin2Layout.setVerticalGroup(
            margin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Sidebar.add(margin2);

        btn_container1.setBackground(new java.awt.Color(31, 31, 31));
        btn_container1.setMaximumSize(new java.awt.Dimension(300, 320));
        btn_container1.setMinimumSize(new java.awt.Dimension(300, 320));
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 370));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_RevenueDashboard.setBackground(new java.awt.Color(31, 31, 31));
        btn_RevenueDashboard.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_RevenueDashboard.setForeground(new java.awt.Color(245, 251, 254));
        btn_RevenueDashboard.setText("Revenue Dashboard");
        btn_RevenueDashboard.setBorder(null);
        btn_RevenueDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RevenueDashboard.setFocusable(false);
        btn_RevenueDashboard.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_RevenueDashboard.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_RevenueDashboard.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_RevenueDashboard.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_RevenueDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RevenueDashboardActionPerformed(evt);
            }
        });
        btn_container1.add(btn_RevenueDashboard);

        btn_reviews.setBackground(new java.awt.Color(43, 43, 43));
        btn_reviews.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_reviews.setForeground(new java.awt.Color(255, 169, 140));
        btn_reviews.setText("Customer Reviews");
        btn_reviews.setBorder(null);
        btn_reviews.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reviews.setFocusable(false);
        btn_reviews.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_reviews.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_reviews.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_reviews.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_reviews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reviewsActionPerformed(evt);
            }
        });
        btn_container1.add(btn_reviews);

        btn_ManageTasks.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageTasks.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageTasks.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageTasks.setText("Manage Tasks");
        btn_ManageTasks.setBorder(null);
        btn_ManageTasks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageTasks.setFocusable(false);
        btn_ManageTasks.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageTasks.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageTasks.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageTasks.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageTasksActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageTasks);

        Sidebar.add(btn_container1);

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

        getContentPane().add(Sidebar);
        Sidebar.setBounds(0, 0, 300, 670);

        Line.setBackground(new java.awt.Color(50, 50, 50));
        Line.setMaximumSize(new java.awt.Dimension(300, 700));
        Line.setMinimumSize(new java.awt.Dimension(300, 700));

        javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
        Line.setLayout(LineLayout);
        LineLayout.setHorizontalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        LineLayout.setVerticalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(Line);
        Line.setBounds(300, 0, 2, 700);

        Main.setBackground(new java.awt.Color(31, 31, 31));
        Main.setAlignmentX(0.0F);
        Main.setAlignmentY(0.0F);
        Main.setMaximumSize(new java.awt.Dimension(1000, 670));
        Main.setMinimumSize(new java.awt.Dimension(1000, 670));
        Main.setPreferredSize(new java.awt.Dimension(1000, 670));
        Main.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        margin4.setBackground(new java.awt.Color(31, 31, 31));
        margin4.setMaximumSize(new java.awt.Dimension(1000, 50));
        margin4.setMinimumSize(new java.awt.Dimension(1000, 50));
        margin4.setPreferredSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout margin4Layout = new javax.swing.GroupLayout(margin4);
        margin4.setLayout(margin4Layout);
        margin4Layout.setHorizontalGroup(
            margin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        margin4Layout.setVerticalGroup(
            margin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Main.add(margin4);

        title_container.setBackground(new java.awt.Color(31, 31, 31));
        title_container.setMaximumSize(new java.awt.Dimension(1000, 100));
        title_container.setMinimumSize(new java.awt.Dimension(1000, 100));
        title_container.setPreferredSize(new java.awt.Dimension(1000, 100));
        title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        margin5.setBackground(new java.awt.Color(31, 31, 31));
        margin5.setMaximumSize(new java.awt.Dimension(60, 100));
        margin5.setMinimumSize(new java.awt.Dimension(60, 100));
        margin5.setPreferredSize(new java.awt.Dimension(60, 100));

        javax.swing.GroupLayout margin5Layout = new javax.swing.GroupLayout(margin5);
        margin5.setLayout(margin5Layout);
        margin5Layout.setHorizontalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        margin5Layout.setVerticalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        title_container.add(margin5);

        title.setBackground(new java.awt.Color(31, 31, 31));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 169, 140));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Runner Ratings");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new java.awt.Dimension(130, 50));
        title.setMinimumSize(new java.awt.Dimension(130, 50));
        title.setPreferredSize(new java.awt.Dimension(800, 50));
        title_container.add(title);

        btn_Noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noti.png"))); // NOI18N
        btn_Noti.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_Noti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotiActionPerformed(evt);
            }
        });
        title_container.add(btn_Noti);

        Main.add(title_container);

        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void btn_NotiActionPerformed(java.awt.event.ActionEvent evt) {                                  
        GlassPanePopup.showPopup(new NotificationPanel(notifications), new DefaultOption(){
            @Override
            public float opacity() {
                return 0;
            }
            @Override
            public LayoutCallback getLayoutCallBack(java.awt.Component parent) {
                return new DefaultLayoutCallBack(parent){
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()){
                            java.awt.Point pl = parent.getLocationOnScreen();
                            java.awt.Point bl = btn_Noti.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            cw.setBounds(x - cw.getWidth() + btn_Noti.getWidth(), y + btn_Noti.getHeight(), cw.getWidth(), cw.getHeight());
                        } else {
                            super.correctBounds(cw);
                        }
                    }
                };
            }
        });
    }   

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            UserHandling.logout();
            dispose();
            new LoginPage().setVisible(true);
        }
    }                                          

    private void btn_RevenueDashboardActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
        new RunnerRevenueDashboard().setVisible(true);
    }                                                                                          

    private void btn_reviewsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Customer Reviews button action
    }                                           

    private void btn_ManageTasksActionPerformed(java.awt.event.ActionEvent evt) {                                              
        dispose();
        new RunnerManageTask().setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton btn_reviews;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_RevenueDashboard;
    private javax.swing.JButton btn_ManageTasks;
    private javax.swing.JButton btn_logout;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin4;
    private javax.swing.JPanel margin5;
    private javax.swing.JLabel averageDeliveryTimeLabel;
    private javax.swing.JLabel systemName;
    private javax.swing.JPanel title_container;
    private javax.swing.JLabel averageDeliveryFeeLabel;
    private javax.swing.JLabel totalEarningsLabel;
    private javax.swing.JLabel totalDeliveriesLabel;
    private javax.swing.JLabel title;
    private oodj.food_ordering_system.designUI.Button btn_Noti;
    // End of variables declaration                   
}
