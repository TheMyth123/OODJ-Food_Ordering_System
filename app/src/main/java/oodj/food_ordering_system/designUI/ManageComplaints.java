package oodj.food_ordering_system.designUI;

import oodj.food_ordering_system.models.Complaint;
import oodj.food_ordering_system.models.Notification;
import oodj.food_ordering_system.utils.DialogBox;
import oodj.food_ordering_system.utils.NotificationUtils;
import raven.glasspanepopup.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageComplaints extends javax.swing.JFrame {

    private JPanel Line;
    private JPanel Logo_container;
    private JPanel Main;
    private JPanel Sidebar;
    private JButton btn_VendorPerformance;
    private JPanel btn_container1;
    private JPanel btn_container2;
    private JButton btn_ManageComplaints;
    private JButton btn_RunnerPerformance;
    private JButton btn_ModerateVItems;
    private JButton btn_logout;
    private JPanel margin1;
    private JPanel margin2;
    private JPanel margin3;
    private JPanel m1;
    private JPanel m2;
    private JLabel systemName;
    private JPanel title_container;
    private JLabel title;
    private Button btn_Noti;
    private DefaultTableModel tableModel;
    private JTable complaintTable;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton resolveButton;
    private Map<String, Complaint> complaintMap = new HashMap<>();
    List<Notification> notifications = NotificationUtils.getUnreadNotifications(NotificationUtils.getAllNotifications(), "Manager", false);

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageComplaints().setVisible(true);
        });
    }

    public ManageComplaints() {
        initComponents();
        GlassPanePopup.install(this);
        loadComplaints();
        updateComplaintTable();
    }

    private void loadComplaints() {
        String jsonText = getAllComplaints();
        List<Complaint> complaints = getValidComplaints(jsonText);
        for (Complaint c : complaints) {
            complaintMap.put(c.getId(), c);
        }
    }

    private String getAllComplaints() {
        try {
            String path = "app\\src\\main\\resources\\databases\\complaint.txt";
            File file = new File(path);
            if (file.exists()) {
                return new String(Files.readAllBytes(Paths.get(path)));
            } else {
                System.out.println("File not found: " + path);
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private List<Complaint> getValidComplaints(String jsonText) {
        List<Complaint> complaints = new ArrayList<>();
        if (jsonText == null || jsonText.isEmpty()) {
            return complaints;
        }
        JSONArray complaintsArray = new JSONArray(jsonText);
        for (int i = 0; i < complaintsArray.length(); i++) {
            JSONObject obj = complaintsArray.getJSONObject(i);
            String complaintID = obj.getString("ComplaintID");
            boolean resolved = obj.getBoolean("Resolved");
            String customerID = obj.getString("CustomerID");
            JSONArray messagesArray = obj.getJSONArray("Messages");
            List<String> messages = new ArrayList<>();
            for (int j = 0; j < messagesArray.length(); j++) {
                messages.add(messagesArray.getString(j));
            }
            Complaint complaint = new Complaint(complaintID, customerID, messages);
            if (resolved) {
                complaint.resolve();
            }
            complaints.add(complaint);
        }
        return complaints;
    }

    private void updateComplaintTable() {
        tableModel.setRowCount(0);
        for (Complaint complaint : complaintMap.values()) {
            if (!complaint.isResolved()) {
                tableModel.addRow(new Object[]{complaint.getId(), complaint.getUser()});
            }
        }
    }

    private void updateDatabase() {
        JSONArray arr = new JSONArray();
        for (Complaint complaint : complaintMap.values()) {
            JSONObject obj = new JSONObject();
            obj.put("ComplaintID", complaint.getId());
            obj.put("CustomerID", complaint.getUser());
            obj.put("Resolved", complaint.isResolved());
            obj.put("Messages", complaint.getMessages());
            arr.put(obj);
        }
        try {
            String path = "app\\src\\main\\resources\\databases\\complaint.txt";
            Files.write(Paths.get(path), arr.toString(4).getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        Line = new JPanel();
        Sidebar = new JPanel();
        margin1 = new JPanel();
        m1 = new JPanel();
        m2 = new JPanel();
        Logo_container = new JPanel();
        systemName = new JLabel();
        margin2 = new JPanel();
        margin3 = new JPanel();
        btn_container1 = new JPanel();
        btn_VendorPerformance = new JButton();
        btn_RunnerPerformance = new JButton();
        btn_ManageComplaints = new JButton();
        btn_ModerateVItems = new JButton();
        btn_container2 = new JPanel();
        btn_logout = new JButton();
        Main = new JPanel();
        title_container = new JPanel();
        title = new JLabel();
        btn_Noti = new Button();
        tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "CustomerID"}, 0);
        complaintTable = new JTable(tableModel);
        complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        complaintTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = complaintTable.getSelectedRow();
                if (selectedRow != -1) {
                    String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                    updateChat(complaintId);
                } else {
                    chatArea.setText("");
                }
            }
        });
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        inputField = new JTextField();
        sendButton = new JButton("Send");
        resolveButton = new JButton("Resolve Case");
        sendButton.addActionListener(e -> {
            sendMessage();
            updateDatabase();
        });
        resolveButton.addActionListener(e -> {
            resolveComplaint();
            updateDatabase();
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Menu");
        setBackground(new Color(25, 25, 25));
        setMinimumSize(new Dimension(1300, 700));
        setSize(new Dimension(1300, 700));
        getContentPane().setLayout(null);
        Sidebar.setBackground(new Color(31, 31, 31));
        Sidebar.setAlignmentX(0.0F);
        Sidebar.setAlignmentY(0.0F);
        Sidebar.setMaximumSize(new Dimension(300, 670));
        Sidebar.setMinimumSize(new Dimension(300, 670));
        Sidebar.setPreferredSize(new Dimension(300, 670));
        Sidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        margin1.setBackground(new Color(31, 31, 31));
        GroupLayout margin1Layout = new GroupLayout(margin1);
        margin1.setLayout(margin1Layout);
        margin1Layout.setHorizontalGroup(
            margin1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );
        margin1Layout.setVerticalGroup(
            margin1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 50, Short.MAX_VALUE)
        );
        Sidebar.add(margin1);
        Logo_container.setBackground(new Color(31, 31, 31));
        Logo_container.setMaximumSize(new Dimension(300, 100));
        Logo_container.setMinimumSize(new Dimension(300, 100));
        Logo_container.setPreferredSize(new Dimension(300, 100));
        Logo_container.setLayout(new BoxLayout(Logo_container, BoxLayout.LINE_AXIS));
        systemName.setBackground(new Color(31, 31, 31));
        systemName.setFont(new Font("Segoe Print", 1, 36));
        systemName.setForeground(new Color(255, 169, 140));
        systemName.setHorizontalAlignment(SwingConstants.CENTER);
        systemName.setText("Food Connect");
        systemName.setVerticalAlignment(SwingConstants.TOP);
        systemName.setAlignmentX(0.5F);
        systemName.setMaximumSize(new Dimension(300, 50));
        systemName.setMinimumSize(new Dimension(300, 50));
        systemName.setPreferredSize(new Dimension(300, 50));
        Logo_container.add(systemName);
        Sidebar.add(Logo_container);
        margin2.setBackground(new Color(31, 31, 31));
        margin2.setMaximumSize(new Dimension(300, 50));
        margin2.setMinimumSize(new Dimension(300, 50));
        margin2.setPreferredSize(new Dimension(300, 50));
        GroupLayout margin2Layout = new GroupLayout(margin2);
        margin2.setLayout(margin2Layout);
        margin2Layout.setHorizontalGroup(
            margin2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );
        margin2Layout.setVerticalGroup(
            margin2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 50, Short.MAX_VALUE)
        );
        Sidebar.add(margin2);
        btn_container1.setBackground(new Color(31, 31, 31));
        btn_container1.setMaximumSize(new Dimension(300, 320));
        btn_container1.setMinimumSize(new Dimension(300, 320));
        btn_container1.setPreferredSize(new Dimension(300, 320));
        btn_container1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        btn_VendorPerformance.setBackground(new Color(31, 31, 31));
        btn_VendorPerformance.setFont(new Font("Segoe UI", 0, 18));
        btn_VendorPerformance.setForeground(new Color(245, 251, 254));
        btn_VendorPerformance.setText("Vendor Performance");
        btn_VendorPerformance.setBorder(null);
        btn_VendorPerformance.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_VendorPerformance.setFocusable(false);
        btn_VendorPerformance.setMargin(new Insets(15, 50, 15, 50));
        btn_VendorPerformance.setMaximumSize(new Dimension(250, 40));
        btn_VendorPerformance.setMinimumSize(new Dimension(250, 40));
        btn_VendorPerformance.setPreferredSize(new Dimension(250, 40));
        btn_VendorPerformance.addActionListener(evt -> btn_VendorPerformanceActionPerformed(evt));
        btn_container1.add(btn_VendorPerformance);
        btn_RunnerPerformance.setBackground(new Color(31, 31, 31));
        btn_RunnerPerformance.setFont(new Font("Segoe UI", 0, 18));
        btn_RunnerPerformance.setForeground(new Color(245, 251, 254));
        btn_RunnerPerformance.setText("Runner Performance");
        btn_RunnerPerformance.setBorder(null);
        btn_RunnerPerformance.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_RunnerPerformance.setFocusable(false);
        btn_RunnerPerformance.setMargin(new Insets(15, 50, 15, 50));
        btn_RunnerPerformance.setMaximumSize(new Dimension(250, 40));
        btn_RunnerPerformance.setMinimumSize(new Dimension(250, 40));
        btn_RunnerPerformance.setPreferredSize(new Dimension(250, 40));
        btn_RunnerPerformance.addActionListener(evt -> btn_RunnerPerformanceActionPerformed(evt));
        btn_container1.add(btn_RunnerPerformance);
        btn_ManageComplaints.setBackground(new Color(43, 43, 43));
        btn_ManageComplaints.setFont(new Font("Segoe UI", 1, 18));
        btn_ManageComplaints.setForeground(new Color(225, 169, 140));
        btn_ManageComplaints.setText("Manage Complaints");
        btn_ManageComplaints.setBorder(null);
        btn_ManageComplaints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ManageComplaints.setFocusable(false);
        btn_ManageComplaints.setMargin(new Insets(15, 50, 15, 50));
        btn_ManageComplaints.setMaximumSize(new Dimension(250, 40));
        btn_ManageComplaints.setMinimumSize(new Dimension(250, 40));
        btn_ManageComplaints.setPreferredSize(new Dimension(250, 40));
        btn_ManageComplaints.addActionListener(evt -> btn_ManageComplaintsActionPerformed(evt));
        btn_container1.add(btn_ManageComplaints);
        btn_ModerateVItems.setBackground(new Color(31, 31, 31));
        btn_ModerateVItems.setFont(new Font("Segoe UI", 0, 18));
        btn_ModerateVItems.setForeground(new Color(245, 254, 254));
        btn_ModerateVItems.setText("Moderate Vendor Items");
        btn_ModerateVItems.setBorder(null);
        btn_ModerateVItems.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ModerateVItems.setFocusable(false);
        btn_ModerateVItems.setMargin(new Insets(15, 50, 15, 50));
        btn_ModerateVItems.setMaximumSize(new Dimension(250, 40));
        btn_ModerateVItems.setMinimumSize(new Dimension(250, 40));
        btn_ModerateVItems.setPreferredSize(new Dimension(250, 40));
        btn_ModerateVItems.addActionListener(evt -> btn_ModerateVItemsActionPerformed(evt));
        btn_container1.add(btn_ModerateVItems);
        Sidebar.add(btn_container1);
        margin3.setBackground(new Color(31, 31, 31));
        margin3.setMaximumSize(new Dimension(300, 100));
        margin3.setMinimumSize(new Dimension(300, 100));
        margin3.setPreferredSize(new Dimension(300, 80));
        GroupLayout margin3Layout = new GroupLayout(margin3);
        margin3.setLayout(margin3Layout);
        margin3Layout.setHorizontalGroup(
            margin3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );
        margin3Layout.setVerticalGroup(
            margin3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        Sidebar.add(margin3);
        btn_container2.setBackground(new Color(31, 31, 31));
        btn_container2.setMaximumSize(new Dimension(300, 50));
        btn_container2.setMinimumSize(new Dimension(300, 50));
        btn_container2.setPreferredSize(new Dimension(300, 50));
        btn_container2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        btn_logout.setBackground(new Color(31, 31, 31));
        btn_logout.setFont(new Font("Segoe UI", 0, 18));
        btn_logout.setForeground(new Color(245, 251, 254));
        btn_logout.setText("Logout");
        btn_logout.setBorder(null);
        btn_logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_logout.setFocusable(false);
        btn_logout.setMargin(new Insets(15, 50, 15, 50));
        btn_logout.setMaximumSize(new Dimension(250, 40));
        btn_logout.setMinimumSize(new Dimension(250, 40));
        btn_logout.setPreferredSize(new Dimension(250, 40));
        btn_logout.addActionListener(evt -> btn_logoutActionPerformed(evt));
        btn_container2.add(btn_logout);
        Sidebar.add(btn_container2);
        getContentPane().add(Sidebar);
        Sidebar.setBounds(0, 0, 300, 670);
        Line.setBackground(new Color(50, 50, 50));
        Line.setMaximumSize(new Dimension(300, 700));
        Line.setMinimumSize(new Dimension(300, 700));
        GroupLayout LineLayout = new GroupLayout(Line);
        Line.setLayout(LineLayout);
        LineLayout.setHorizontalGroup(
            LineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );
        LineLayout.setVerticalGroup(
            LineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 700, Short.MAX_VALUE)
        );
        getContentPane().add(Line);
        Line.setBounds(300, 0, 2, 700);
        Main.setBackground(new Color(31, 31, 31));
        Main.setAlignmentX(0.0F);
        Main.setAlignmentY(0.0F);
        Main.setMaximumSize(new Dimension(1000, 670));
        Main.setMinimumSize(new Dimension(1000, 670));
        Main.setPreferredSize(new Dimension(1000, 670));
        Main.setLayout(new BorderLayout());
        m1.setBackground(new Color(31, 31, 31));
        m1.setMaximumSize(new Dimension(1000, 30));
        m1.setMinimumSize(new Dimension(1000, 30));
        GroupLayout m1Layout = new GroupLayout(m1);
        m1.setLayout(m1Layout);
        m1Layout.setHorizontalGroup(
            m1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 1000, Short.MAX_VALUE)
        );
        m1Layout.setVerticalGroup(
            m1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 30, Short.MAX_VALUE)
        );
        title_container.setBackground(new Color(31, 31, 31));
        title_container.setMaximumSize(new Dimension(1000, 100));
        title_container.setMinimumSize(new Dimension(1000, 100));
        title_container.setPreferredSize(new Dimension(1000, 50));
        title_container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        title.setBackground(new Color(31, 31, 31));
        title.setFont(new Font("Segoe UI", 1, 24));
        title.setForeground(new Color(255, 169, 140));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Manage Customer Complaints");
        title.setAlignmentX(0.5F);
        title.setMaximumSize(new Dimension(130, 50));
        title.setMinimumSize(new Dimension(130, 50));
        title.setPreferredSize(new Dimension(800, 50));
        title_container.add(title);
        btn_Noti.setIcon(new ImageIcon(getClass().getResource("/images/noti.png")));
        btn_Noti.setPreferredSize(new Dimension(50, 50));
        btn_Noti.addActionListener(evt -> btn_NotiActionPerformed(evt));
        title_container.add(btn_Noti);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(m1);
        topPanel.add(title_container);
        topPanel.add(m2);
        Main.add(topPanel, BorderLayout.NORTH);
        m2.setBackground(new Color(31, 31, 31));
        m2.setMaximumSize(new Dimension(1000, 50));
        m2.setMinimumSize(new Dimension(1000, 50));
        m2.setPreferredSize(new Dimension(1000, 50));
        GroupLayout m2Layout = new GroupLayout(m2);
        m2.setLayout(m2Layout);
        m2Layout.setHorizontalGroup(
            m2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 1000, Short.MAX_VALUE)
        );
        m2Layout.setVerticalGroup(
            m2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 30, Short.MAX_VALUE)
        );
        JPanel complaintPanel = new JPanel(new BorderLayout(10, 10));
        complaintPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        complaintPanel.setPreferredSize(new Dimension(880, 480));
        complaintTable.setRowHeight(30);
        complaintTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        complaintTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        complaintTable.setBackground(new Color(250, 250, 250));
        complaintTable.setForeground(Color.BLACK);
        complaintTable.setGridColor(new Color(80, 80, 80));
        complaintTable.setSelectionBackground(new Color(255, 169, 140));
        JScrollPane tableScrollPane = new JScrollPane(complaintTable);
        tableScrollPane.setPreferredSize(new Dimension(250, 480));
        tableScrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(80, 80, 80)));
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        chatArea.setForeground(Color.BLACK);
        chatArea.setBackground(new Color(245, 245, 245));
        chatArea.setMargin(new Insets(10, 15, 10, 15));
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatScrollPane.setBorder(BorderFactory.createEmptyBorder());
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        inputField.setForeground(Color.BLACK);
        inputField.setBackground(new Color(240, 240, 240));
        inputField.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(10),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        Dimension buttonSize = new Dimension(120, 40);
        sendButton.setFont(buttonFont);
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(new Color(76, 175, 80));
        sendButton.setPreferredSize(buttonSize);
        sendButton.setBorder(new RoundedBorder(10));
        resolveButton.setFont(buttonFont);
        resolveButton.setForeground(Color.WHITE);
        resolveButton.setBackground(new Color(244, 67, 54));
        resolveButton.setPreferredSize(buttonSize);
        resolveButton.setBorder(new RoundedBorder(10));
        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.add(inputField, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(sendButton);
        buttonPanel.add(resolveButton);
        inputPanel.add(buttonPanel, BorderLayout.EAST);
        JPanel chatContainer = new JPanel(new BorderLayout());
        chatContainer.setBackground(new Color(245, 245, 245));
        chatContainer.add(chatScrollPane, BorderLayout.CENTER);
        chatContainer.add(inputPanel, BorderLayout.SOUTH);
        chatContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(80, 80, 80)));
        complaintPanel.add(tableScrollPane, BorderLayout.WEST);
        complaintPanel.add(chatContainer, BorderLayout.CENTER);
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        centerPanel.setOpaque(false);
        centerPanel.add(complaintPanel);
        Main.add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(Main);
        Main.setBounds(300, 0, 1000, 670);
        pack();
        setLocationRelativeTo(null);
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            int selectedRow = complaintTable.getSelectedRow();
            if (selectedRow != -1) {
                String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                Complaint complaint = complaintMap.get(complaintId);
                if (complaint != null && !complaint.isResolved()) {
                    complaint.addMessage("Manager", message);
                    inputField.setText("");
                    updateChat(complaintId);
                }
            } else {
                addComplaint("Customer1", message);
            }
        }
    }

    private void addComplaint(String user, String message) {
        Complaint complaint = new Complaint(user, message);
        complaintMap.put(complaint.getId(), complaint);
        tableModel.addRow(new Object[]{complaint.getId(), complaint.getUser()});
    }

    private void resolveComplaint() {
        int selectedRow = complaintTable.getSelectedRow();
        if (selectedRow != -1) {
            String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
            Complaint complaint = complaintMap.get(complaintId);
            if (complaint != null && !complaint.isResolved()) {
                complaint.resolve();
                updateChat(complaintId);
                tableModel.removeRow(selectedRow);
            }
        }
    }

    private void updateChat(String complaintId) {
        chatArea.setText("");
        Complaint complaint = complaintMap.get(complaintId);
        if (complaint != null) {
            for (String msg : complaint.getMessages()) {
                chatArea.append(msg + "\n");
            }
        }
    }

    private void btn_NotiActionPerformed(java.awt.event.ActionEvent evt) {
        GlassPanePopup.showPopup(new NotificationPanel(notifications), new DefaultOption() {
            @Override
            public float opacity() {
                return 0;
            }
            @Override
            public LayoutCallback getLayoutCallBack(Component parent) {
                return new DefaultLayoutCallBack(parent) {
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()) {
                            Point pl = parent.getLocationOnScreen();
                            Point bl = btn_Noti.getLocationOnScreen();
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

    private void btn_VendorPerformanceActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new VendorPerformance().setVisible(true);
    }

    private void btn_RunnerPerformanceActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new RunnerPerformance().setVisible(true);
    }

    private void btn_ManageComplaintsActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btn_ModerateVItemsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new ModerateVendorItems().setVisible(true);
    }

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {
        boolean confirm = DialogBox.confirmMessage("Are you sure you want to logout?", "Logout");
        if (confirm) {
            dispose();
            new LoginPage().setVisible(true);
        }
    }
}

class RoundedBorder implements javax.swing.border.Border {
    private int radius;
    public RoundedBorder(int radius) {
        this.radius = radius;
    }
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(c.getForeground());
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }
}
