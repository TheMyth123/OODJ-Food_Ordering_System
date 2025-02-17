package oodj.food_ordering_system.designUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oodj.food_ordering_system.models.Complaint;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.utils.ComplaintHandling;
import oodj.food_ordering_system.utils.UserHandling;



// public class ComplaintSystem extends JFrame {
//     private JTable complaintTable;
//     private DefaultTableModel tableModel;
//     static Map<String, Complaint> complaintMap = new HashMap<>();
//     private JTextArea chatArea;
//     private JTextField inputField;
//     private JButton sendButton, resolveButton;
//     private Complaint selectedComplaint;
//     private static ComplaintSystem instance;
//     private static CustomerComplaint customerInterface;


//     private static Customer endUser;
    
    // public static ComplaintSystem getInstance() {
    //     if (instance == null) {
    //         System.out.println("ERROR: ComplaintSystem instance is null. Creating new instance.");
    //         instance = new CustomerComplaint(endUser);
    //     }
    //     return instance;
    // }
    


    // public ComplaintSystem(Customer endUser) {
    //     // this.endUser = endUser;            
    //     // instance = this;
    //     setTitle("Complaint Management System");
    //     setSize(600, 500);
    //     setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     setLayout(new BorderLayout());

    //     tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
    //     complaintTable = new JTable(tableModel);
    //     JScrollPane tableScrollPane = new JScrollPane(complaintTable);
    //     add(tableScrollPane, BorderLayout.WEST);

    //     instance = this; // ✅ Ensure instance is set


    //     JPanel chatPanel = new JPanel(new BorderLayout());
    //     chatArea = new JTextArea();
    //     chatArea.setEditable(false);
    //     JScrollPane chatScrollPane = new JScrollPane(chatArea);
    //     chatPanel.add(chatScrollPane, BorderLayout.CENTER);

    //     JPanel inputPanel = new JPanel(new BorderLayout());
    //     inputField = new JTextField();
    //     sendButton = new JButton("Send");
    //     resolveButton = new JButton("Resolve Case");
    //     // resolveButton.setEnabled(false);

    //     inputPanel.add(inputField, BorderLayout.CENTER);
    //     inputPanel.add(sendButton, BorderLayout.EAST);
    //     inputPanel.add(resolveButton, BorderLayout.SOUTH);
    //     chatPanel.add(inputPanel, BorderLayout.SOUTH);
    //     add(chatPanel, BorderLayout.CENTER);


    //     complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //     complaintTable.getSelectionModel().addListSelectionListener(e -> {
    //         if (!e.getValueIsAdjusting()) {
    //             int selectedRow = complaintTable.getSelectedRow();
    //             if (selectedRow != -1) {
    //                 String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //                 updateChat(complaintId);
    //             } else {
    //                 chatArea.setText(""); // Clear chat when unselected
    //             }
    //         }
    //     });

    //     sendButton.addActionListener(e -> sendMessage());
    //     resolveButton.addActionListener(e -> resolveComplaint());
    // }
    
    // // public static void addComplaint(String user, String message) {
        
    // //     Complaint complaint = new Complaint(user, message);
    // //     complaintMap.put(complaint.getId(), complaint);
    // //     instance.tableModel.addRow(new Object[]{complaint.getId(), "Ongoing"});
    // //     if (customerInterface != null) {
    // //         customerInterface.updateTable();
    // //     }
    // // }
    
    // public static void addComplaint(String user, String message) {
    //     ComplaintSystem system = getInstance(); // ✅ Ensure instance exists
    //     if (system == null) {
    //         System.out.println("Error: ComplaintSystem is not initialized!");
    //         return;
    //     }

    //     Complaint complaint = new Complaint(user, message);
    //     complaintMap.put(complaint.getId(), complaint);
    //     system.tableModel.addRow(new Object[]{complaint.getId(), "Ongoing"});

    //     if (customerInterface != null) {
    //         customerInterface.updateTable();
    //     }
    // }
    
    // private void sendMessage() {
    //     String message = inputField.getText().trim();
    //     if (!message.isEmpty()) {
    //         int selectedRow = complaintTable.getSelectedRow();
    //         if (selectedRow != -1) {
    //             String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //             Complaint complaint = complaintMap.get(complaintId);
    //             if (complaint != null && !complaint.isResolved()) {
    //                 complaint.addMessage("Manager", message);
    //                 inputField.setText("");
    //                 updateChat(complaintId);
    //                 if (customerInterface != null) {
    //                     customerInterface.updateChat(complaintId);
    //                 }
    //             }
    //         } else {
    //             addComplaint("Customer1", message);
    //             customerInterface.updateTable();
    //         }
    //     }
    // }

    // private void resolveComplaint() {
    //     if (selectedComplaint != null && !selectedComplaint.isResolved()) {
    //         selectedComplaint.resolve();
    //         updateChat(selectedComplaint.getUser());
    //         resolveButton.setEnabled(false);
    //         customerInterface.updateTable();
    // // ✅ Use instance instead of static call
    //     }
    // }
    

    // private void updateChat(String complaintId) {
    //     chatArea.setText("");
    //     Complaint complaint = complaintMap.get(complaintId);
    //     if (complaint != null) {
    //         for (String message : complaint.getMessages()) {
    //             chatArea.append(message + "\n");
    //         }
    //     }
    // }

    // public static void setCustomerInterface(CustomerComplaint customerInterface) {
    //     ComplaintSystem.customerInterface = customerInterface;
    // }
    
    // // public static void main(String[] args) {
    // //     SwingUtilities.invokeLater(() -> {
    // //         ComplaintSystem managerInterface = new ComplaintSystem(endUser);
    // //     managerInterface.setVisible(true);
        
    // //     CustomerComplaint customerInterface = new CustomerComplaint();
    // //     setCustomerInterface(customerInterface);
    // //     customerInterface.setVisible(true);

    // //     });
    // // }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         instance = new ComplaintSystem(endUser); // ✅ Set instance when program starts
    //         instance.setVisible(true);
    //     });
    // }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         ComplaintSystem managerInterface = getInstance(); // ✅ Ensure instance is created
    //         managerInterface.setVisible(true);
    //     });
    // }
// }

// class CustomerComplaint extends JFrame {
//     private JTable complaintTable;
//     private DefaultTableModel tableModel;
//     private JTextArea chatArea;
//     private JTextField inputField;
//     private JButton sendButton;


    // public CustomerComplaint() {

    //     setTitle("Customer Complaint Interface");
    //     setSize(500, 350);
    //     setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     setLayout(new BorderLayout());

    //     tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
    //     complaintTable = new JTable(tableModel);
    //     JScrollPane tableScrollPane = new JScrollPane(complaintTable);
    //     add(tableScrollPane, BorderLayout.WEST);

    //     complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //     complaintTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    //         @Override
    //         public void valueChanged(ListSelectionEvent e) {
    //             if (!e.getValueIsAdjusting()) {
    //                 int selectedRow = complaintTable.getSelectedRow();
    //                 if (selectedRow != -1) {
    //                     String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //                     updateChat(complaintId);
    //                     sendButton.setText("Send Message");
    //                 } else {
    //                     chatArea.setText(""); // Clear chat when unselected
    //                     sendButton.setText("Create Complaint");
    //                 }
    //             }
    //         }
    //     });

    //     chatArea = new JTextArea();
    //     chatArea.setEditable(false);
    //     JScrollPane chatScrollPane = new JScrollPane(chatArea);
    //     add(chatScrollPane, BorderLayout.CENTER);

    //     // Add chat input field & send button
    //     JPanel inputPanel = new JPanel(new BorderLayout());
    //     inputField = new JTextField();
    //     sendButton = new JButton("Create Complaint");

    //     sendButton.addActionListener(e -> sendMessage(inputField));

    //     inputPanel.add(inputField, BorderLayout.CENTER);
    //     inputPanel.add(sendButton, BorderLayout.EAST);
    //     add(inputPanel, BorderLayout.SOUTH);

    //     // Load existing complaints
    //     loadComplaints();
    // }

    // private void loadComplaints() {
    //     try {
    //         ArrayList<Complaint> complaints = ComplaintHandling.readComplaints();
    //         for (Complaint complaint : complaints) {
    //             tableModel.addRow(new Object[]{complaint.getId(), complaint.isResolved() ? "Resolved" : "Ongoing"});
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public void updateTable() {
    //     tableModel.setRowCount(0);
    //     try {
    //         ArrayList<Complaint> complaints = ComplaintHandling.readComplaints();
    //         for (Complaint complaint : complaints) {
    //             tableModel.addRow(new Object[]{complaint.getId(), complaint.isResolved() ? "Resolved" : "Ongoing"});
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public void updateChat(String complaintId) {
    //     chatArea.setText("");
    //     Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
    //     if (complaint != null) {
    //         for (String message : complaint.getMessages()) {
    //             chatArea.append(message + "\n");
    //         }
    //     }
    // }

    // // private void sendComplaint() {
    // //     String message = JOptionPane.showInputDialog(this, "Enter your complaint:");
    // //     if (message != null && !message.trim().isEmpty()) {
    // //         ComplaintSystem.addComplaint("Customer" + UserHandling.getCUid(), message);
    // //         updateTable();
    // //     }
    // // }

    // private void sendComplaint() {
    //     System.out.println("DEBUG: sendComplaint() was called");
    
    //     String message = JOptionPane.showInputDialog(this, "Enter your complaint:");
    //     if (message != null && !message.trim().isEmpty()) {
    //         System.out.println("User entered a complaint: " + message);
    
    //         ComplaintSystem complaintSystem = ComplaintSystem.getInstance();
    //         if (complaintSystem != null) {
    //             // ✅ Create a new Complaint object
    //             Complaint newComplaint = new Complaint("Customer" + UserHandling.getCUid(), message);
    
    //             // ✅ Call addNewComplaint() with a Complaint object
    //             ComplaintHandling.addNewComplaint(newComplaint);
                
    //             System.out.println("Complaint passed to ComplaintHandling.addNewComplaint()");
    //             updateTable();
    //         } else {
    //             System.out.println("ERROR: ComplaintSystem instance is null.");
    //         }
    //     } else {
    //         System.out.println("User did not enter a valid complaint.");
    //     }
    // }
    
    
    

    // private void sendMessage(JTextField inputField) {
    //     String message = inputField.getText().trim();
    //     if (!message.isEmpty()) {
    //         int selectedRow = complaintTable.getSelectedRow();
    //         if (selectedRow != -1) { // If a complaint is selected, continue chat
    //             String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //             Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
    //             if (complaint != null && !complaint.isResolved()) {
    //                 complaint.addMessage("User", message);
    //                 ComplaintHandling.updateComplaint(complaint);
    //                 inputField.setText("");
    //                 updateChat(complaintId);
    //             }
    //         } 
    //         // } else { // Otherwise, create a new complaint
    //         //     sendComplaint();
    //         // }
    //     }
    // }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         // ✅ Ensure ComplaintSystem is initialized first
    //         ComplaintSystem.getInstance().setVisible(true);
    
    //         // ✅ Then open CustomerComplaint
    //         CustomerComplaint customerComplaint = new CustomerComplaint();
    //         customerComplaint.setVisible(true);
    //     });
    // }

    // public CustomerComplaint() {
    //     setTitle("Customer Complaint Interface");
    //     setSize(500, 350);
    //     setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     setLayout(new BorderLayout());

    //     tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
    //     complaintTable = new JTable(tableModel);
    //     JScrollPane tableScrollPane = new JScrollPane(complaintTable);
    //     add(tableScrollPane, BorderLayout.WEST);

    //     complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //     complaintTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    //         @Override
    //         public void valueChanged(ListSelectionEvent e) {
    //             if (!e.getValueIsAdjusting()) {
    //                 int selectedRow = complaintTable.getSelectedRow();
    //                 // if (selectedRow != -1) {
    //                 //     String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //                 //     updateChat(complaintId);
    //                 //     sendButton.setText("Send Message");
    //                 // } else {
    //                 //     chatArea.setText(""); // Clear chat when unselected
    //                 //     sendButton.setText("Create Complaint");
    //                 // }
    //                 if (selectedRow != -1) {
    //                     String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //                     updateChat(complaintId);
    //                     sendButton.setText("Send Message");
    //                     inputField.setVisible(true);
    //                     chatArea.setVisible(true);
    //                 } else {
    //                     chatArea.setVisible(false); // Make chat area invisible when unselected
    //                     sendButton.setText("Create Complaint");
    //                     inputField.setVisible(false);
    //                 }
    //             }
    //         }
    //     });

    //     chatArea = new JTextArea();
    //     chatArea.setVisible(false); // Make chat area invisible when unselected                
    //     JScrollPane chatScrollPane = new JScrollPane(chatArea);
    //     add(chatScrollPane, BorderLayout.CENTER);

    //     // Add chat input field & send button
    //     JPanel inputPanel = new JPanel(new BorderLayout());
    //     inputField = new JTextField();
    //     inputField.setVisible(false);
    //     sendButton = new JButton("Create Complaint");

    //     sendButton.addActionListener(e -> handleSendButton());

    //     inputPanel.add(inputField, BorderLayout.CENTER);
    //     inputPanel.add(sendButton, BorderLayout.EAST);
    //     add(inputPanel, BorderLayout.SOUTH);

    //     // Load existing complaints
    //     loadComplaints();
    // }

    // private void loadComplaints() {
    //     try {
    //         ArrayList<Complaint> complaints = ComplaintHandling.readComplaints();
    //         for (Complaint complaint : complaints) {
    //             tableModel.addRow(new Object[]{complaint.getId(), complaint.isResolved() ? "Resolved" : "Ongoing"});
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public void updateTable() {
    //     tableModel.setRowCount(0);
    //     try {
    //         ArrayList<Complaint> complaints = ComplaintHandling.readComplaints();
    //         for (Complaint complaint : complaints) {
    //             tableModel.addRow(new Object[]{complaint.getId(), complaint.isResolved() ? "Resolved" : "Ongoing"});
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public void updateChat(String complaintId) {
    //     chatArea.setText("");
    //     Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
    //     if (complaint != null) {
    //         for (String message : complaint.getMessages()) {
    //             chatArea.append(message + "\n");
    //         }
    //     }
    // }

    // private void sendComplaint() {
    //     String message = JOptionPane.showInputDialog(this, "Enter your complaint:");
    //     if (message != null && !message.trim().isEmpty()) {
    //         ComplaintSystem.addComplaint("Customer1" + UserHandling.getCUid(), message);
    //         updateTable();
    //     }
    // }

    // private void handleSendButton() {
    //     int selectedRow = complaintTable.getSelectedRow();
    //     if (selectedRow != -1) { // If a complaint is selected, continue chat
    //         sendMessage();
    //     } else { // Otherwise, create a new complaint
    //         sendComplaint();
    //     }
    // }

    // private void sendMessage() {
    //     String message = inputField.getText().trim();
    //     if (!message.isEmpty()) {
    //         int selectedRow = complaintTable.getSelectedRow();
    //         if (selectedRow != -1) {
    //             String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //             Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
    //             if (complaint != null && !complaint.isResolved()) {
    //                 complaint.addMessage("User", message);
    //                 ComplaintHandling.updateComplaint(complaint);
    //                 inputField.setText("");
    //                 updateChat(complaintId);
    //             }
    //         }
    //     }
    // }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         CustomerComplaint customerComplaint = new CustomerComplaint();
    //         customerComplaint.setVisible(true);
    //     });
    // }

    // public CustomerComplaint(Customer endUser) {
    //     setTitle("Customer Complaint Interface");
    //     setSize(500, 350);
    //     setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     setLayout(new BorderLayout());

    //     tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
    //     complaintTable = new JTable(tableModel);
    //     JScrollPane tableScrollPane = new JScrollPane(complaintTable);
    //     add(tableScrollPane, BorderLayout.WEST);

    //     complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //     complaintTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    //         @Override
    //         public void valueChanged(ListSelectionEvent e) {
    //             if (!e.getValueIsAdjusting()) {
    //                 int selectedRow = complaintTable.getSelectedRow();
    //                 if (selectedRow != -1) {
    //                     String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
    //                     updateChat(complaintId);
    //                     sendButton.setText("Send Message");
    //                     inputField.setVisible(true);
    //                     chatArea.setVisible(true);
    //                 } else {
    //                     chatArea.setVisible(false); // Make chat area invisible when unselected
    //                     sendButton.setText("Create Complaint");
    //                     inputField.setVisible(false);
    //                 }
    //             }
    //         }
    //     });

    //     chatArea = new JTextArea();
    //     chatArea.setVisible(false); // Make chat area invisible when unselected                
    //     JScrollPane chatScrollPane = new JScrollPane(chatArea);
    //     add(chatScrollPane, BorderLayout.CENTER);

    //     // Add chat input field & send button
    //     JPanel inputPanel = new JPanel(new BorderLayout());
    //     inputField = new JTextField();
    //     inputField.setVisible(false);
    //     sendButton = new JButton("Create Complaint");


    //     sendButton.addActionListener(e -> handleSendButton());

    //     inputPanel.add(inputField, BorderLayout.CENTER);
    //     inputPanel.add(sendButton, BorderLayout.EAST);
    //     add(inputPanel, BorderLayout.SOUTH);

    //     // Load existing complaints
    //     loadComplaints();
    // }

    

public class CustomerComplaintPanel extends JPanel {
    private JTable complaintTable;
    private DefaultTableModel tableModel;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public CustomerComplaintPanel(Customer endUser) {
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
        complaintTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(complaintTable);
        add(tableScrollPane, BorderLayout.WEST);

        complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        complaintTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = complaintTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                        updateChat(complaintId);
                        sendButton.setText("Send Message");
                        inputField.setVisible(true);
                        chatArea.setVisible(true);
                    } else {
                        chatArea.setVisible(false);
                        sendButton.setText("Create Complaint");
                        inputField.setVisible(false);
                    }
                }
            }
        });

        chatArea = new JTextArea();
        chatArea.setVisible(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        add(chatScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        inputField.setVisible(false);
        sendButton = new JButton("Create Complaint");
        sendButton.addActionListener(e -> handleSendButton());

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        loadComplaints();
    }

    private void loadComplaints() {
        try {
            ArrayList<Complaint> complaints = ComplaintHandling.readComplaints();
            for (Complaint complaint : complaints) {
                tableModel.addRow(new Object[]{complaint.getId(), complaint.isResolved() ? "Resolved" : "Ongoing"});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTable() {
        tableModel.setRowCount(0);
        try {
            ArrayList<Complaint> complaints = ComplaintHandling.readComplaints();
            for (Complaint complaint : complaints) {
                tableModel.addRow(new Object[]{complaint.getId(), complaint.isResolved() ? "Resolved" : "Ongoing"});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateChat(String complaintId) {
        chatArea.setText("");
        Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
        if (complaint != null) {
            for (String message : complaint.getMessages()) {
                chatArea.append(message + "\n");
            }
        }
    }


    private void sendComplaint() {
        System.out.println("DEBUG: sendComplaint() was called");
    
        String message = JOptionPane.showInputDialog(this, "Enter your complaint:");
        if (message != null && !message.trim().isEmpty()) {
            System.out.println("User entered a complaint: " + message);
    
            // Create a new Complaint object
            Complaint newComplaint = new Complaint("Customer" + UserHandling.getCUid(), message);
    
            // Call addNewComplaint() with a Complaint object
            ComplaintHandling.addNewComplaint(newComplaint);
    
            System.out.println("Complaint passed to ComplaintHandling.addComplaint()");
            updateTable();
        } else {
            System.out.println("User did not enter a valid complaint.");
        }
    }

    private void handleSendButton() {
        int selectedRow = complaintTable.getSelectedRow();
        if (selectedRow != -1) { // If a complaint is selected, continue chat
            sendMessage();
        } else { // Otherwise, create a new complaint
            sendComplaint();
        }
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            int selectedRow = complaintTable.getSelectedRow();
            if (selectedRow != -1) {
                String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
                if (complaint != null && !complaint.isResolved()) {
                    complaint.addMessage("User", message);
                    ComplaintHandling.updateComplaint(complaint);
                    inputField.setText("");
                    updateChat(complaintId);
                }
            }
        }
    }

    public JPanel getPanel() {
        return this;
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         CustomerComplaint customerComplaint = new CustomerComplaint(Customer endUser);
    //         customerComplaint.setVisible(true);
    //     });
    // }   
}


