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


    

public class CustomerComplaintPanel extends JPanel {
    private JTable complaintTable;
    private DefaultTableModel tableModel;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    // private Customer endUser;

    public CustomerComplaintPanel(Customer endUser) {
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
        complaintTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(complaintTable);
        tableScrollPane.setPreferredSize(new Dimension(700, 300));

        
        add(tableScrollPane, BorderLayout.WEST);


        complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        complaintTable.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if (isSelectedIndex(index0)) {
                    removeSelectionInterval(index0, index1);  // Deselect if already selected
                } else {
                    super.setSelectionInterval(index0, index1);  // Select if not selected
                }
            }
        });

        // Add ListSelectionListener
        complaintTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = complaintTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                        updateChat(complaintId);
                        boolean isResolved = "Resolved".equals(tableModel.getValueAt(selectedRow, 1));
                        if (isResolved) {
                            sendButton.setText("Resolved");
                            sendButton.setEnabled(false);
                            inputField.setVisible(false);
                        } else {
                            sendButton.setText("Send Message");
                            sendButton.setEnabled(true);
                            inputField.setVisible(true);
                        }
                        chatArea.setVisible(true);
                    } else {
                        chatArea.setVisible(false);
                        sendButton.setText("Create Complaint");
                        sendButton.setEnabled(true);
                        inputField.setVisible(false);
                    }
                }
            }
        });



        chatArea = new JTextArea();
        // chatArea.setVisible(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatScrollPane.setPreferredSize(new Dimension(180, 400)); // Set preferred size for chat area
        add(chatScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        inputField.setVisible(false);
        sendButton = new JButton("Create Complaint");
        sendButton.addActionListener(e -> handleSendButton());

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        loadComplaints(endUser);
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

    private void loadComplaints(Customer endUser) {
        try {
            ArrayList<Complaint> complaints = ComplaintHandling.readComplaints();
            tableModel.setRowCount(0); // Clear table before adding data
    
            System.out.println("Loading complaints for customer: " + endUser.getID());
            for (Complaint complaint : complaints) {
                System.out.println("Checking complaint: " + complaint.getId() + " - Resolved: " + complaint.isResolved());
    
                if (complaint.getUser().equals(endUser.getID())) { // Display all complaints
                    String status = complaint.isResolved() ? "Resolved" : "Ongoing";
                    System.out.println("Adding complaint to table: " + complaint.getId() + " - Status: " + status);
                    tableModel.addRow(new Object[]{complaint.getId(), status});
                }
            }
    
            tableModel.fireTableDataChanged(); // Refresh table display
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    

    

    // public void updateChat(String complaintId) {
    //     chatArea.setText("");
    //     Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
    //     if (complaint != null) {
    //         for (String message : complaint.getMessages()) {
    //             chatArea.append(message + "\n");
    //         }
    //     }
    // }

    public void updateChat(String complaintId) {
        chatArea.setText("");
        Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
        
        if (complaint != null) {
            for (String message : complaint.getMessages()) {
                chatArea.append(message + "\n");
            }
    
            if (complaint.isResolved()) { //  If complaint is resolved
                chatArea.setEditable(false);
                sendButton.setText("Resolved");
                sendButton.setEnabled(false);
                inputField.setVisible(false);
            } else { //  Allow chat if unresolved
                chatArea.setEditable(true);
                sendButton.setText("Send Message");
                sendButton.setEnabled(true);
                inputField.setVisible(true);
            }
        }
    }
    

    // public void updateChat(String complaintId) {
    //     chatArea.setText("");
    //     Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
    //     if (complaint != null) {
    //         for (String message : complaint.getMessages()) {
    //             chatArea.append(message + "\n");
    //         }
    //         boolean isResolved = complaint.isResolved();
    //         if (isResolved) {
    //             chatArea.setEditable(false);
    //             sendButton.setText("Resolved");
    //             sendButton.setEnabled(false);
    //             inputField.setVisible(false);
    //         } else {
    //             chatArea.setEditable(true);
    //             sendButton.setText("Send Message");
    //             sendButton.setEnabled(true);
    //             inputField.setVisible(true);
    //         }
    //     }
    // }


    private void sendComplaint() {
        System.out.println("DEBUG: sendComplaint() was called");
    
        String message = JOptionPane.showInputDialog(this, "Enter your complaint:");
        if (message != null && !message.trim().isEmpty()) {
            System.out.println("User entered a complaint: " + message);
    
            // Create a new Complaint object
            Complaint newComplaint = new Complaint("Customer" + UserHandling.getCUid(), message);
            String customerID = LoginPage.getEndUser().getID();; // Get the ID of the current
            
            
            // Call addNewComplaint() with a Complaint object
            ComplaintHandling.addNewComplaint(newComplaint, customerID);
    
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

    private void sendMessage() {
        int selectedRow = complaintTable.getSelectedRow();
        if (selectedRow != -1) {
            String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
            Complaint complaint = ComplaintHandling.getComplaintById(complaintId);
    
            if (complaint != null && complaint.isResolved()) { //  Prevent sending if resolved
                JOptionPane.showMessageDialog(this, "This complaint is resolved. You cannot send messages.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
    
            String message = inputField.getText().trim();
            if (!message.isEmpty()) {
                complaint.addMessage("User", message);
                ComplaintHandling.updateComplaint(complaint);
                inputField.setText("");
                updateChat(complaintId);
            }
        }
    }
    

    public JPanel getPanel() {
        return this;
    }

    
}


