package oodj.food_ordering_system.designUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import oodj.food_ordering_system.models.DeliveryRunner;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.FileHandling;
import oodj.food_ordering_system.utils.NotificationUtils;
import oodj.food_ordering_system.utils.UserHandling;
import oodj.food_ordering_system.utils.validation;
import raven.glasspanepopup.DefaultLayoutCallBack;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;

public class ManageRunner extends javax.swing.JFrame {

    // TODO FOR DEVELOPMENT PURPOSES ONLY, REMOVE THIS LATER
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageRunner().setVisible(true);
        });
    }

    public static ArrayList<DeliveryRunner> allDeliveryRunners = readDeliveryRunnerDetails();

    public ManageRunner() {
        GlassPanePopup.install(this);
        initComponents();

        DeliveryRunnerInfo.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel model = validation.nonEditTable(new Object[]{"RunnerID", "Delivery Runner Name", "Username", "Email", "Phone", "Vehicle Type", "License Plate"}, 0);

        DeliveryRunnerInfo.setModel(model);

        refreshDeliveryRunnerInfo();
        displayDeliveryRunners(allDeliveryRunners);

    }

    private void displayDeliveryRunners(ArrayList<DeliveryRunner> DeliveryRunners) {

        DefaultTableModel model = (DefaultTableModel) DeliveryRunnerInfo.getModel();
        model.setRowCount(0);

        for (DeliveryRunner DeliveryRunner : DeliveryRunners) {
            model.addRow(new Object[]{
                DeliveryRunner.getID(),
                DeliveryRunner.getName(),
                DeliveryRunner.getUsername(),
                DeliveryRunner.getEmail(),
                DeliveryRunner.getContactnumber(),
                DeliveryRunner.getVehicle(),
                DeliveryRunner.getLicense()
            });
        }
        
        int rowCount = model.getRowCount();
        int rowHeight = DeliveryRunnerInfo.getRowHeight();
        int preferredHeight = rowCount * rowHeight;
        if (preferredHeight < 377){
            preferredHeight = 377;
        }

        DeliveryRunnerInfo.setPreferredSize(new java.awt.Dimension(
            jScrollPane1.getWidth(), Math.min(preferredHeight, 8000) // Max height is 400
        ));

        DeliveryRunnerInfo.getColumnModel().getColumn(0).setPreferredWidth(25);
        DeliveryRunnerInfo.getColumnModel().getColumn(4).setPreferredWidth(100);

        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeliveryRunnerInfo.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        DeliveryRunnerInfo.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        DeliveryRunnerInfo.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        

        DeliveryRunnerInfo.revalidate();
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
    }

    private static ArrayList<DeliveryRunner> readDeliveryRunnerDetails() {
        String DeliveryRunner = FileHandling.filePath.DELIVERY_PATH.getValue();
        ArrayList<DeliveryRunner> DeliveryRunners = new ArrayList<>();
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(DeliveryRunner)));
            JSONArray DeliveryRunnersArray = new JSONArray(jsonData);
            for (int i = 0; i < DeliveryRunnersArray.length(); i++) {
                JSONObject DeliveryRunnerData = DeliveryRunnersArray.getJSONObject(i);
    
                // Check if Status is true before adding to the list
                if (DeliveryRunnerData.getBoolean("Status")) {
                    String DeliveryRunnerID = DeliveryRunnerData.getString("RunnerID");
                    String deliveryrunnername = DeliveryRunnerData.getString("Name");
                    String username = DeliveryRunnerData.getString("Username");
                    String password = DeliveryRunnerData.getString("Password");
                    String email = DeliveryRunnerData.getString("Email");
                    String phone = DeliveryRunnerData.getString("Phone");
                    String gender = DeliveryRunnerData.getString("Gender");
                    String dob = DeliveryRunnerData.getString("DOB");
                    String vehicle = DeliveryRunnerData.getString("VehicleType");
                    String license = DeliveryRunnerData.getString("LicensePlate");
    
                    DeliveryRunner deliveryrunner = new DeliveryRunner(DeliveryRunnerID, username, deliveryrunnername, phone, password, gender, dob, email, vehicle, license, true);
                    DeliveryRunners.add(deliveryrunner);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DeliveryRunners;
    }
    

    private void performSearch() {
        String name = nameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        ArrayList<DeliveryRunner> filteredDeliveryRunners = new ArrayList<>();

        for (DeliveryRunner DeliveryRunner : allDeliveryRunners) {
            if ((name.isEmpty() || DeliveryRunner.getName().equalsIgnoreCase(name))
                    && (email.isEmpty() || DeliveryRunner.getEmail().equalsIgnoreCase(email))) {
                filteredDeliveryRunners.add(DeliveryRunner);
            }
        }

        if (filteredDeliveryRunners.isEmpty()) {
            DialogBox.errorMessage("No matches found.", "Error");
            displayDeliveryRunners(allDeliveryRunners);
        } else {
            displayDeliveryRunners(filteredDeliveryRunners);
        }
    }

    public void refreshDeliveryRunnerInfo() {
        allDeliveryRunners = readDeliveryRunnerDetails();
        displayDeliveryRunners(allDeliveryRunners);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Sidebar = new javax.swing.JPanel();
        margin1 = new javax.swing.JPanel();
        Logo_container = new javax.swing.JPanel();
        systemName = new javax.swing.JLabel();
        btn_container1 = new javax.swing.JPanel();
        btn_ManageCus = new javax.swing.JButton();
        btn_ManageVen = new javax.swing.JButton();
        btn_ManageRun = new javax.swing.JButton();
        btn_topup = new javax.swing.JButton();
        btn_container2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        Line = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();
        m1 = new javax.swing.JPanel();
        title_container = new javax.swing.JPanel();
        margin2 = new javax.swing.JPanel();
        margin3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        m2 = new javax.swing.JPanel();
        Line1 = new javax.swing.JPanel();
        m4 = new javax.swing.JPanel();
        searchBar = new javax.swing.JPanel();
        margin5 = new javax.swing.JPanel();
        brandLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        margin6 = new javax.swing.JPanel();
        modelLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        margin7 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        m3 = new javax.swing.JPanel();
        m6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DeliveryRunnerInfo = new javax.swing.JTable();
        m7 = new javax.swing.JPanel();
        btn_container = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        m10 = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        m11 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        btn_Noti = new oodj.food_ordering_system.designUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Menu");
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
        btn_container1.setPreferredSize(new java.awt.Dimension(300, 320));
        btn_container1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        btn_ManageCus.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageCus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageCus.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageCus.setText("Manage Customer");
        btn_ManageCus.setBorder(null);
        btn_ManageCus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageCus.setFocusable(false);
        btn_ManageCus.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageCus.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageCus.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageCus.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageCusActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageCus);

        btn_ManageVen.setBackground(new java.awt.Color(31, 31, 31));
        btn_ManageVen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ManageVen.setForeground(new java.awt.Color(245, 251, 254));
        btn_ManageVen.setText("Manage Vendor");
        btn_ManageVen.setBorder(null);
        btn_ManageVen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageVen.setFocusable(false);
        btn_ManageVen.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageVen.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageVen.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageVen.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageVenActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageVen);

        btn_ManageRun.setBackground(new java.awt.Color(43, 43, 43));
        btn_ManageRun.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_ManageRun.setForeground(new java.awt.Color(255, 169, 140));
        btn_ManageRun.setText("Manage Runner");
        btn_ManageRun.setBorder(null);
        btn_ManageRun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ManageRun.setFocusable(false);
        btn_ManageRun.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_ManageRun.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_ManageRun.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_ManageRun.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_ManageRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ManageRunActionPerformed(evt);
            }
        });
        btn_container1.add(btn_ManageRun);

        btn_topup.setBackground(new java.awt.Color(31, 31, 31));
        btn_topup.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_topup.setForeground(new java.awt.Color(245, 251, 254));
        btn_topup.setText("Manage Top-Up Requests");
        btn_topup.setBorder(null);
        btn_topup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_topup.setFocusable(false);
        btn_topup.setMargin(new java.awt.Insets(15, 50, 15, 50));
        btn_topup.setMaximumSize(new java.awt.Dimension(250, 40));
        btn_topup.setMinimumSize(new java.awt.Dimension(250, 40));
        btn_topup.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_topup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_topupActionPerformed(evt);
            }
        });
        btn_container1.add(btn_topup);

        Sidebar.add(btn_container1);

        margin3.setBackground(new java.awt.Color(31, 31, 31));
        margin3.setMaximumSize(new java.awt.Dimension(300, 100));
        margin3.setMinimumSize(new java.awt.Dimension(300, 100));
        margin3.setPreferredSize(new java.awt.Dimension(300, 80));

        javax.swing.GroupLayout margin3Layout = new javax.swing.GroupLayout(margin3);
        margin3.setLayout(margin3Layout);
        margin3Layout.setHorizontalGroup(
            margin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        m1.setBackground(new java.awt.Color(31, 31, 31));
        m1.setMaximumSize(new java.awt.Dimension(1000, 30));
        m1.setMinimumSize(new java.awt.Dimension(1000, 30));

        javax.swing.GroupLayout m1Layout = new javax.swing.GroupLayout(m1);
        m1.setLayout(m1Layout);
        m1Layout.setHorizontalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m1Layout.setVerticalGroup(
            m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main.add(m1);

        title_container.setBackground(new java.awt.Color(31, 31, 31));
        title_container.setMaximumSize(new java.awt.Dimension(1000, 100));
        title_container.setMinimumSize(new java.awt.Dimension(1000, 100));
        title_container.setPreferredSize(new java.awt.Dimension(1000, 50));
        title_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        title.setBackground(new java.awt.Color(31, 31, 31));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 169, 140));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Manage DeliveryRunner");
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

        m2.setBackground(new java.awt.Color(31, 31, 31));
        m2.setMaximumSize(new java.awt.Dimension(1000, 5));
        m2.setMinimumSize(new java.awt.Dimension(1000, 5));
        m2.setPreferredSize(new java.awt.Dimension(1000, 7));

        Line1.setBackground(new java.awt.Color(50, 50, 50));
        Line1.setMaximumSize(new java.awt.Dimension(300, 2));
        Line1.setMinimumSize(new java.awt.Dimension(300, 2));
        Line1.setPreferredSize(new java.awt.Dimension(300, 2));

        javax.swing.GroupLayout Line1Layout = new javax.swing.GroupLayout(Line1);
        Line1.setLayout(Line1Layout);
        Line1Layout.setHorizontalGroup(
            Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Line1Layout.setVerticalGroup(
            Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout m2Layout = new javax.swing.GroupLayout(m2);
        m2.setLayout(m2Layout);
        m2Layout.setHorizontalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m2Layout.createSequentialGroup()
                    .addContainerGap(367, Short.MAX_VALUE)
                    .addComponent(Line1, 267, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(366, Short.MAX_VALUE)))
        );
        m2Layout.setVerticalGroup(
            m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
            .addGroup(m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Main.add(m2);

        m4.setBackground(new java.awt.Color(31, 31, 31));
        m4.setMaximumSize(new java.awt.Dimension(1000, 13));
        m4.setMinimumSize(new java.awt.Dimension(1000, 13));
        m4.setPreferredSize(new java.awt.Dimension(1000, 13));

        javax.swing.GroupLayout m4Layout = new javax.swing.GroupLayout(m4);
        m4.setLayout(m4Layout);
        m4Layout.setHorizontalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m4Layout.setVerticalGroup(
            m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        Main.add(m4);

        searchBar.setBackground(new java.awt.Color(31, 31, 31));
        searchBar.setMaximumSize(new java.awt.Dimension(1000, 50));
        searchBar.setMinimumSize(new java.awt.Dimension(1000, 50));
        searchBar.setPreferredSize(new java.awt.Dimension(1000, 50));
        searchBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        margin5.setBackground(new java.awt.Color(31, 31, 31));
        margin5.setMaximumSize(new java.awt.Dimension(60, 50));
        margin5.setMinimumSize(new java.awt.Dimension(60, 50));

        javax.swing.GroupLayout margin5Layout = new javax.swing.GroupLayout(margin5);
        margin5.setLayout(margin5Layout);
        margin5Layout.setHorizontalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        margin5Layout.setVerticalGroup(
            margin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        searchBar.add(margin5);

        brandLabel.setBackground(new java.awt.Color(31, 31, 31));
        brandLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        brandLabel.setForeground(new java.awt.Color(255, 169, 140));
        brandLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brandLabel.setText("Search by Name: ");
        brandLabel.setAlignmentX(0.5F);
        brandLabel.setMaximumSize(new java.awt.Dimension(173, 50));
        brandLabel.setMinimumSize(new java.awt.Dimension(173, 50));
        brandLabel.setPreferredSize(new java.awt.Dimension(173, 50));
        searchBar.add(brandLabel);

        nameTextField.setBackground(new java.awt.Color(43, 43, 43));
        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameTextField.setForeground(new java.awt.Color(245, 251, 254));
        nameTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nameTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        nameTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        nameTextField.setMaximumSize(new java.awt.Dimension(180, 40));
        nameTextField.setMinimumSize(new java.awt.Dimension(180, 40));
        nameTextField.setPreferredSize(new java.awt.Dimension(180, 40));
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        searchBar.add(nameTextField);

        margin6.setBackground(new java.awt.Color(31, 31, 31));
        margin6.setMaximumSize(new java.awt.Dimension(20, 50));
        margin6.setMinimumSize(new java.awt.Dimension(20, 50));

        javax.swing.GroupLayout margin6Layout = new javax.swing.GroupLayout(margin6);
        margin6.setLayout(margin6Layout);
        margin6Layout.setHorizontalGroup(
            margin6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        margin6Layout.setVerticalGroup(
            margin6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        searchBar.add(margin6);

        modelLabel.setBackground(new java.awt.Color(31, 31, 31));
        modelLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        modelLabel.setForeground(new java.awt.Color(255, 169, 140));
        modelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modelLabel.setText("Search by Email: ");
        modelLabel.setAlignmentX(0.5F);
        modelLabel.setMaximumSize(new java.awt.Dimension(173, 50));
        modelLabel.setMinimumSize(new java.awt.Dimension(173, 50));
        modelLabel.setPreferredSize(new java.awt.Dimension(173, 50));
        searchBar.add(modelLabel);

        emailTextField.setBackground(new java.awt.Color(43, 43, 43));
        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(245, 251, 254));
        emailTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emailTextField.setCaretColor(new java.awt.Color(245, 251, 254));
        emailTextField.setMargin(new java.awt.Insets(4, 10, 4, 6));
        emailTextField.setMaximumSize(new java.awt.Dimension(180, 40));
        emailTextField.setMinimumSize(new java.awt.Dimension(180, 40));
        emailTextField.setPreferredSize(new java.awt.Dimension(180, 40));
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        searchBar.add(emailTextField);

        margin7.setBackground(new java.awt.Color(31, 31, 31));
        margin7.setMaximumSize(new java.awt.Dimension(50, 50));
        margin7.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout margin7Layout = new javax.swing.GroupLayout(margin7);
        margin7.setLayout(margin7Layout);
        margin7Layout.setHorizontalGroup(
            margin7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        margin7Layout.setVerticalGroup(
            margin7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        searchBar.add(margin7);

        searchButton.setBackground(new java.awt.Color(255, 169, 140));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(31, 31, 31));
        searchButton.setText("Search");
        searchButton.setBorder(null);
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setFocusable(false);
        searchButton.setMargin(new java.awt.Insets(15, 50, 15, 50));
        searchButton.setMaximumSize(new java.awt.Dimension(100, 40));
        searchButton.setMinimumSize(new java.awt.Dimension(100, 40));
        searchButton.setPreferredSize(new java.awt.Dimension(100, 40));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchBar.add(searchButton);

        Main.add(searchBar);

        m3.setBackground(new java.awt.Color(31, 31, 31));
        m3.setMaximumSize(new java.awt.Dimension(1000, 30));
        m3.setMinimumSize(new java.awt.Dimension(1000, 30));
        m3.setPreferredSize(new java.awt.Dimension(1000, 10));

        javax.swing.GroupLayout m3Layout = new javax.swing.GroupLayout(m3);
        m3.setLayout(m3Layout);
        m3Layout.setHorizontalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m3Layout.setVerticalGroup(
            m3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main.add(m3);

        m6.setBackground(new java.awt.Color(31, 31, 31));
        m6.setMaximumSize(new java.awt.Dimension(60, 50));
        m6.setMinimumSize(new java.awt.Dimension(60, 50));

        javax.swing.GroupLayout m6Layout = new javax.swing.GroupLayout(m6);
        m6.setLayout(m6Layout);
        m6Layout.setHorizontalGroup(
            m6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        m6Layout.setVerticalGroup(
            m6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Main.add(m6);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(880, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(880, 400));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(880, 400));
        

        DeliveryRunnerInfo.setBackground(new java.awt.Color(43, 43, 43));
        DeliveryRunnerInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeliveryRunnerInfo.setForeground(new java.awt.Color(245, 251, 254));
        DeliveryRunnerInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        DeliveryRunnerInfo.setFocusable(false);
        DeliveryRunnerInfo.setGridColor(new java.awt.Color(31, 31, 31));
        DeliveryRunnerInfo.setMaximumSize(new java.awt.Dimension(880, 2000));
        DeliveryRunnerInfo.setMinimumSize(new java.awt.Dimension(880, 2000));
        DeliveryRunnerInfo.setPreferredSize(new java.awt.Dimension(880, 2000));
        DeliveryRunnerInfo.setRowHeight(35);
        DeliveryRunnerInfo.setSelectionBackground(new java.awt.Color(255, 169, 140));
        DeliveryRunnerInfo.setSelectionForeground(new java.awt.Color(31, 31, 31));
        DeliveryRunnerInfo.setShowGrid(true);
        DeliveryRunnerInfo.setShowVerticalLines(false);
        jScrollPane1.setViewportView(DeliveryRunnerInfo);

        Main.add(jScrollPane1);

        m7.setBackground(new java.awt.Color(31, 31, 31));
        m7.setMaximumSize(new java.awt.Dimension(1000, 30));
        m7.setMinimumSize(new java.awt.Dimension(1000, 30));

        javax.swing.GroupLayout m7Layout = new javax.swing.GroupLayout(m7);
        m7.setLayout(m7Layout);
        m7Layout.setHorizontalGroup(
            m7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        m7Layout.setVerticalGroup(
            m7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Main.add(m7);

        btn_container.setBackground(new java.awt.Color(31, 31, 31));
        btn_container.setMaximumSize(new java.awt.Dimension(1000, 55));
        btn_container.setMinimumSize(new java.awt.Dimension(1000, 55));
        btn_container.setPreferredSize(new java.awt.Dimension(1000, 55));
        btn_container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        addButton.setBackground(new java.awt.Color(255, 169, 140));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(31, 31, 31));
        addButton.setText("New Runner");
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setMargin(null);
        addButton.setMaximumSize(new java.awt.Dimension(150, 50));
        addButton.setMinimumSize(new java.awt.Dimension(150, 50));
        addButton.setPreferredSize(new java.awt.Dimension(150, 50));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        btn_container.add(addButton);

        m10.setBackground(new java.awt.Color(31, 31, 31));
        m10.setMaximumSize(new java.awt.Dimension(30, 55));
        m10.setMinimumSize(new java.awt.Dimension(30, 55));
        m10.setPreferredSize(new java.awt.Dimension(30, 55));

        javax.swing.GroupLayout m10Layout = new javax.swing.GroupLayout(m10);
        m10.setLayout(m10Layout);
        m10Layout.setHorizontalGroup(
            m10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        m10Layout.setVerticalGroup(
            m10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        btn_container.add(m10);

        editButton.setBackground(new java.awt.Color(255, 169, 140));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(31, 31, 31));
        editButton.setText("Edit");
        editButton.setBorder(null);
        editButton.setBorderPainted(false);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setMargin(null);
        editButton.setMaximumSize(new java.awt.Dimension(150, 50));
        editButton.setMinimumSize(new java.awt.Dimension(150, 50));
        editButton.setPreferredSize(new java.awt.Dimension(150, 50));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        btn_container.add(editButton);

        m11.setBackground(new java.awt.Color(31, 31, 31));
        m11.setMaximumSize(new java.awt.Dimension(30, 55));
        m11.setMinimumSize(new java.awt.Dimension(30, 55));
        m11.setPreferredSize(new java.awt.Dimension(30, 55));

        javax.swing.GroupLayout m11Layout = new javax.swing.GroupLayout(m11);
        m11.setLayout(m11Layout);
        m11Layout.setHorizontalGroup(
            m11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        m11Layout.setVerticalGroup(
            m11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        btn_container.add(m11);

        deleteButton.setBackground(new java.awt.Color(255, 169, 140));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(31, 31, 31));
        deleteButton.setText("Delete");
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMargin(null);
        deleteButton.setMaximumSize(new java.awt.Dimension(150, 50));
        deleteButton.setMinimumSize(new java.awt.Dimension(150, 50));
        deleteButton.setPreferredSize(new java.awt.Dimension(150, 50));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        btn_container.add(deleteButton);

        Main.add(btn_container);

        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>     
    
    List<Notification> notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications());
    
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

    private void btn_ManageCusActionPerformed(java.awt.event.ActionEvent evt) {      
        dispose();
        new ManageCustomer().setVisible(true);                                   
    }                            
    
    private void btn_ManageVenActionPerformed(java.awt.event.ActionEvent evt) {  
        dispose();
        new ManageVendor().setVisible(true);   
    }                                           

    private void btn_ManageRunActionPerformed(java.awt.event.ActionEvent evt) {  
    }     

    private void btn_topupActionPerformed(java.awt.event.ActionEvent evt) {       
        dispose();
        new ManageTopUp().setVisible(true);
    }                                                                                       

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            UserHandling.logout();
            dispose();
            new LoginPage().setVisible(true);
        }
    }                                          

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
        ManageRunner ManageRunner = new ManageRunner();
        ManageRunner.setVisible(true);
        ManageRunner.setEnabled(false);

        AddRunner addRunner = new AddRunner(ManageRunner);

        addRunner.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                ManageRunner.setEnabled(true);
                ManageRunner.toFront();
                ManageRunner.refreshDeliveryRunnerInfo();
            }
        });

        addRunner.setVisible(true);
    }                                         

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int selectedRow = DeliveryRunnerInfo.getSelectedRow();
        if (selectedRow == -1) {
            DialogBox.reminderMessage("Please select a Runner to edit!", "Error");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) DeliveryRunnerInfo.getModel();
        String DeliveryRunnerID = model.getValueAt(selectedRow, 0).toString();
        DeliveryRunner DeliveryRunner = UserHandling.getDeliveryRunnerByID(DeliveryRunnerID);
        String name = DeliveryRunner.getName();
        String username = DeliveryRunner.getUsername();
        String email = DeliveryRunner.getEmail();
        String phone = DeliveryRunner.getContactnumber();
        String gender = DeliveryRunner.getGender();
        String vehicle = DeliveryRunner.getVehicle();
        String license = DeliveryRunner.getLicense();
        String dob = DeliveryRunner.getDOB();
        String password = DeliveryRunner.getPassword();
        Boolean status = DeliveryRunner.getStatus();


        dispose();
        ManageRunner ManageRunner = new ManageRunner();
        ManageRunner.setVisible(true);
        ManageRunner.setEnabled(false);

        EditRunner editRunner = new EditRunner(ManageRunner, DeliveryRunnerID, name, username, email, phone, gender, vehicle, license, dob, password, status);

        editRunner.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                ManageRunner.setEnabled(true);
                ManageRunner.toFront();
                ManageRunner.refreshDeliveryRunnerInfo();

            }
        });

        editRunner.setVisible(true);
    }               
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int selectedRow = DeliveryRunnerInfo.getSelectedRow();
        if (selectedRow == -1) {
            DialogBox.reminderMessage("Please select a Delivery Runner to delete!", "Error");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) DeliveryRunnerInfo.getModel();
        String DeliveryRunnerID = model.getValueAt(selectedRow, 0).toString();
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to delete this Delivery Runner?", "Delete DeliveryR unner");
        if (confirm) {
            String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\delivery_runner.txt";

            JSONArray DeliveryRunnerArray;
            File file = new File(filePath);

            if (file.length() > 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    DeliveryRunnerArray = new JSONArray(content.toString());
                } catch (IOException e) {
                    DialogBox.errorMessage("Error reading Delivery Runner data file.", "Error");
                    e.printStackTrace();
                    return;
                }
            } else {
                DialogBox.errorMessage("No Delivery Runner data found.", "Error");
                return;
            }

            boolean DeliveryRunnerFound = false;
            for (int i = 0; i < DeliveryRunnerArray.length(); i++) {
                JSONObject DeliveryRunner = DeliveryRunnerArray.getJSONObject(i);
                if (DeliveryRunner.getString("RunnerID").equals(DeliveryRunnerID)) {
                    // Set the Status to false to "delete" the DeliveryRunner
                    DeliveryRunner.put("Status", "False");
                    DeliveryRunnerFound = true;
                    break;
                }
            }

            if (!DeliveryRunnerFound) {
                DialogBox.errorMessage("DeliveryRunner with ID " + DeliveryRunnerID + " not found.", "Error");
                return;
            }

            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(DeliveryRunnerArray.toString(2)); // Pretty print with indentation
                fileWriter.flush();
            } catch (IOException e) {
                DialogBox.errorMessage("Error updating DeliveryRunner data file.", "Error");
                e.printStackTrace();
                return;
            }

            DialogBox.successMessage("DeliveryRunner deleted successfully.", "Success");
            refreshDeliveryRunnerInfo();
        }
    }
  

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
        performSearch();
    }                                              

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
        performSearch();
    }                                              

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        performSearch();
    }                                            

    // Variables declaration - do not modify                     
    private javax.swing.JTable DeliveryRunnerInfo;
    private javax.swing.JPanel Line;
    private javax.swing.JPanel Line1;
    private javax.swing.JPanel Logo_container;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton btn_ManageVen;
    private javax.swing.JPanel btn_container;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JButton btn_topup;
    private javax.swing.JButton btn_ManageCus;
    private javax.swing.JButton btn_ManageRun;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton editButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m10;
    private javax.swing.JPanel m11;
    private javax.swing.JPanel m2;
    private javax.swing.JPanel m3;
    private javax.swing.JPanel m4;
    private javax.swing.JPanel m6;
    private javax.swing.JPanel m7;
    private javax.swing.JPanel margin1;
    private javax.swing.JPanel margin2;
    private javax.swing.JPanel margin3;
    private javax.swing.JPanel margin5;
    private javax.swing.JPanel margin6;
    private javax.swing.JPanel margin7;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JPanel searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel systemName;
    private javax.swing.JLabel title;
    private javax.swing.JPanel title_container;
    private javax.swing.JButton btn_Noti;
    // End of variables declaration                   
}
