package oodj.food_ordering_system.designUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
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

public class RunnerRevenueDashboard extends javax.swing.JFrame {
        private DeliveryRunner endUser;
        private String runnerID;
        private List<Notification> notifications;

    public RunnerRevenueDashboard() {
        GlassPanePopup.install(this);
        this.endUser = LoginPage.getEndUserDr();
        this.runnerID = endUser.getID();
        initComponents();
        runner_name.setText(endUser.getUsername());
        loadDetails();
        notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications(), runnerID, false);
    }

    // ck
    // private void loadDetails() {
    //     totalDeliveriesLabel.setText("1");
    //     totalEarningsLabel.setText("2");
    //     averageDeliveryTimeLabel.setText("3");
    //     averageDeliveryFeeLabel.setText("4");
    // }

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
                    // If parsing fails, default to 0 minutes.
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
        btn_profile = new javax.swing.JButton();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Line = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();
        margin2 = new javax.swing.JPanel();
        margin4 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        margin5 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        runner_name = new javax.swing.JLabel();
        data_container = new javax.swing.JPanel();
        margin7 = new javax.swing.JPanel();
        data1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        totalDeliveriesLabel = new javax.swing.JLabel();
        margin13 = new javax.swing.JPanel();
        data2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        totalEarningsLabel = new javax.swing.JLabel();
        margin14 = new javax.swing.JPanel();
        data3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        averageDeliveryTimeLabel = new javax.swing.JLabel();
        margin11 = new javax.swing.JPanel();
        data4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        averageDeliveryFeeLabel = new javax.swing.JLabel();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car Connect - Admin");
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

        btn_RevenueDashboard.setBackground(new java.awt.Color(43, 43, 43));
        btn_RevenueDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_RevenueDashboard.setForeground(new java.awt.Color(255, 169, 140));
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

        btn_reviews.setBackground(new java.awt.Color(31, 31, 31));
        btn_reviews.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_reviews.setForeground(new java.awt.Color(245, 251, 254));
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

        btn_profile.setBackground(new java.awt.Color(31, 31, 31));
        btn_profile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_profile.setForeground(new java.awt.Color(245, 251, 254));
        btn_profile.setText("Profile");
        btn_profile.setBorder(null);
        btn_profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_profile.setFocusable(false);
        btn_profile.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_profile.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_profile.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_profile.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profileActionPerformed(evt);
            }
        });
        btn_container1.add(btn_profile);

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

        welcome.setBackground(new java.awt.Color(31, 31, 31));
        welcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 169, 140));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Welcome, ");
        welcome.setAlignmentX(0.5F);
        welcome.setMaximumSize(new java.awt.Dimension(130, 50));
        welcome.setMinimumSize(new java.awt.Dimension(130, 50));
        welcome.setPreferredSize(new java.awt.Dimension(130, 50));
        title_container.add(welcome);

        runner_name.setBackground(new java.awt.Color(31, 31, 31));
        runner_name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        runner_name.setForeground(new java.awt.Color(255, 169, 140));
        runner_name.setText("< runner_name >");
        runner_name.setMaximumSize(new java.awt.Dimension(300, 50));
        runner_name.setMinimumSize(new java.awt.Dimension(300, 50));
        runner_name.setPreferredSize(new java.awt.Dimension(600, 50));
        title_container.add(runner_name);

        btn_Noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noti.png"))); // NOI18N
        btn_Noti.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_Noti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotiActionPerformed(evt);
            }
        });
        title_container.add(btn_Noti);

        Main.add(title_container);

        data_container.setBackground(new java.awt.Color(31, 31, 31));
        data_container.setMaximumSize(new java.awt.Dimension(1000, 380));
        data_container.setMinimumSize(new java.awt.Dimension(1000, 380));
        data_container.setPreferredSize(new java.awt.Dimension(1000, 380));
        data_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        margin7.setBackground(new java.awt.Color(31, 31, 31));
        margin7.setMaximumSize(new java.awt.Dimension(60, 350));
        margin7.setMinimumSize(new java.awt.Dimension(60, 350));
        margin7.setPreferredSize(new java.awt.Dimension(60, 350));

        javax.swing.GroupLayout margin7Layout = new javax.swing.GroupLayout(margin7);
        margin7.setLayout(margin7Layout);
        margin7Layout.setHorizontalGroup(
            margin7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        margin7Layout.setVerticalGroup(
            margin7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        data_container.add(margin7);

        data1.setBackground(new java.awt.Color(43, 43, 43));
        data1.setMaximumSize(new java.awt.Dimension(200, 200));
        data1.setMinimumSize(new java.awt.Dimension(200, 200));
        data1.setPreferredSize(new java.awt.Dimension(200, 200));
        data1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        data1.add(jPanel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 251, 254));
        jLabel1.setText("Total Deliveries");
        data1.add(jLabel1);

        jPanel4.setBackground(new java.awt.Color(43, 43, 43));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        data1.add(jPanel4);

        totalDeliveriesLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        totalDeliveriesLabel.setForeground(new java.awt.Color(255, 169, 140));
        totalDeliveriesLabel.setText("999");
        data1.add(totalDeliveriesLabel);

        data_container.add(data1);

        margin13.setBackground(new java.awt.Color(31, 31, 31));
        margin13.setMaximumSize(new java.awt.Dimension(25, 350));
        margin13.setMinimumSize(new java.awt.Dimension(25, 350));
        margin13.setPreferredSize(new java.awt.Dimension(25, 350));

        javax.swing.GroupLayout margin13Layout = new javax.swing.GroupLayout(margin13);
        margin13.setLayout(margin13Layout);
        margin13Layout.setHorizontalGroup(
            margin13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        margin13Layout.setVerticalGroup(
            margin13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        data_container.add(margin13);

        data2.setBackground(new java.awt.Color(43, 43, 43));
        data2.setMaximumSize(new java.awt.Dimension(200, 200));
        data2.setMinimumSize(new java.awt.Dimension(200, 200));
        data2.setPreferredSize(new java.awt.Dimension(200, 200));
        data2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jPanel5.setBackground(new java.awt.Color(43, 43, 43));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        data2.add(jPanel5);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(245, 251, 254));
        jLabel3.setText("Total Earnings");
        data2.add(jLabel3);

        jPanel6.setBackground(new java.awt.Color(43, 43, 43));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        data2.add(jPanel6);

        totalEarningsLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        totalEarningsLabel.setForeground(new java.awt.Color(255, 169, 140));
        totalEarningsLabel.setText("999");
        data2.add(totalEarningsLabel);

        data_container.add(data2);

        margin14.setBackground(new java.awt.Color(31, 31, 31));
        margin14.setMaximumSize(new java.awt.Dimension(25, 350));
        margin14.setMinimumSize(new java.awt.Dimension(25, 350));
        margin14.setPreferredSize(new java.awt.Dimension(25, 350));

        javax.swing.GroupLayout margin14Layout = new javax.swing.GroupLayout(margin14);
        margin14.setLayout(margin14Layout);
        margin14Layout.setHorizontalGroup(
            margin14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        margin14Layout.setVerticalGroup(
            margin14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        data_container.add(margin14);

        data3.setBackground(new java.awt.Color(43, 43, 43));
        data3.setMaximumSize(new java.awt.Dimension(200, 200));
        data3.setMinimumSize(new java.awt.Dimension(200, 200));
        data3.setPreferredSize(new java.awt.Dimension(200, 200));
        data3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jPanel7.setBackground(new java.awt.Color(43, 43, 43));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        data3.add(jPanel7);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(245, 251, 254));
        jLabel5.setText("Average Delivery Time");
        data3.add(jLabel5);

        jPanel8.setBackground(new java.awt.Color(43, 43, 43));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        data3.add(jPanel8);

        averageDeliveryTimeLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        averageDeliveryTimeLabel.setForeground(new java.awt.Color(255, 169, 140));
        averageDeliveryTimeLabel.setText("999");
        data3.add(averageDeliveryTimeLabel);

        data_container.add(data3);

        margin11.setBackground(new java.awt.Color(31, 31, 31));
        margin11.setMaximumSize(new java.awt.Dimension(25, 350));
        margin11.setMinimumSize(new java.awt.Dimension(25, 350));
        margin11.setPreferredSize(new java.awt.Dimension(25, 350));

        javax.swing.GroupLayout margin11Layout = new javax.swing.GroupLayout(margin11);
        margin11.setLayout(margin11Layout);
        margin11Layout.setHorizontalGroup(
            margin11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        margin11Layout.setVerticalGroup(
            margin11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        data_container.add(margin11);

        data4.setBackground(new java.awt.Color(43, 43, 43));
        data4.setMaximumSize(new java.awt.Dimension(200, 200));
        data4.setMinimumSize(new java.awt.Dimension(200, 200));
        data4.setPreferredSize(new java.awt.Dimension(200, 200));
        data4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jPanel9.setBackground(new java.awt.Color(43, 43, 43));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        data4.add(jPanel9);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(245, 251, 254));
        jLabel7.setText("Average Delivery Fee");
        data4.add(jLabel7);

        jPanel12.setBackground(new java.awt.Color(43, 43, 43));
        jPanel12.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        data4.add(jPanel12);

        jPanel11.setBackground(new java.awt.Color(43, 43, 43));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 5));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        data4.add(jPanel11);

        averageDeliveryFeeLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        averageDeliveryFeeLabel.setForeground(new java.awt.Color(255, 169, 140));
        averageDeliveryFeeLabel.setText("999");
        data4.add(averageDeliveryFeeLabel);

        data_container.add(data4);

        Main.add(data_container);

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

    }                                                                

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // dispose();
        // new AdminData().setVisible(true);
    }                                           

    private void btn_reviewsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // dispose();
        // new BookingAD().setVisible(true);
    }                                           

    private void btn_ManageTasksActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // dispose();
        // new ModifyCar().setVisible(true);
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JLabel runner_name;
    private javax.swing.JButton btn_reviews;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_RevenueDashboard;
    private javax.swing.JButton btn_ManageTasks;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_profile;
    private javax.swing.JPanel data1;
    private javax.swing.JPanel data2;
    private javax.swing.JPanel data3;
    private javax.swing.JPanel data4;
    private javax.swing.JPanel data_container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin11;
    private javax.swing.JPanel margin13;
    private javax.swing.JPanel margin14;
    private javax.swing.JPanel margin4;
    private javax.swing.JPanel margin5;
    private javax.swing.JPanel margin7;
    private javax.swing.JLabel averageDeliveryTimeLabel;
    private javax.swing.JLabel systemName;
    private javax.swing.JPanel title_container;
    private javax.swing.JLabel averageDeliveryFeeLabel;
    private javax.swing.JLabel totalEarningsLabel;
    private javax.swing.JLabel totalDeliveriesLabel;
    private javax.swing.JLabel welcome;
    private oodj.food_ordering_system.designUI.Button btn_Noti;
    // End of variables declaration                   
}

