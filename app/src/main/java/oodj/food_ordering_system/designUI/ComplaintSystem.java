// package oodj.food_ordering_system.designUI;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// class Complaint1 {
//     private String user;
//     private List<String> messages;
//     private boolean resolved;

//     public Complaint1(String user, String message) {
//         this.user = user;
//         this.messages = new java.util.ArrayList<>();
//         this.messages.add("User: " + message);
//         this.resolved = false;
//     }

//     public String getUser() {
//         return user;
//     }

//     public void addMessage(String sender, String message) {
//         if (!resolved) {
//             messages.add(sender + ": " + message);
//         }
//     }

//     public List<String> getMessages() {
//         return messages;
//     }

//     public boolean isResolved() {
//         return resolved;
//     }

//     public void resolve() {
//         resolved = true;
//         messages.add("System: This complaint has been resolved.");
//     }
// }

// public class ComplaintSystem extends JFrame {
//     private JTable complaintTable;
//     private DefaultTableModel tableModel;
//     static Map<String, Complaint1> complaintMap = new HashMap<>();
//     private JTextArea chatArea;
//     private JTextField inputField;
//     private JButton sendButton, resolveButton;
//     private Complaint1 selectedComplaint;
//     private static ComplaintSystem instance;
//     private static CustomerComplaint customerInterface;

//     public ComplaintSystem() {
//         instance = this;
//         setTitle("Complaint Management System");
//         setSize(600, 500);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         tableModel = new DefaultTableModel(new Object[]{"Customer", "Status"}, 0);
//         complaintTable = new JTable(tableModel);
//         JScrollPane tableScrollPane = new JScrollPane(complaintTable);
//         add(tableScrollPane, BorderLayout.WEST);

//         JPanel chatPanel = new JPanel(new BorderLayout());
//         chatArea = new JTextArea();
//         chatArea.setEditable(false);
//         JScrollPane chatScrollPane = new JScrollPane(chatArea);
//         chatPanel.add(chatScrollPane, BorderLayout.CENTER);

//         JPanel inputPanel = new JPanel(new BorderLayout());
//         inputField = new JTextField();
//         sendButton = new JButton("Send");
//         resolveButton = new JButton("Resolve Case");
//         resolveButton.setEnabled(false);

//         inputPanel.add(inputField, BorderLayout.CENTER);
//         inputPanel.add(sendButton, BorderLayout.EAST);
//         inputPanel.add(resolveButton, BorderLayout.SOUTH);
//         chatPanel.add(inputPanel, BorderLayout.SOUTH);
//         add(chatPanel, BorderLayout.CENTER);

//         complaintTable.getSelectionModel().addListSelectionListener(e -> {
//             int selectedRow = complaintTable.getSelectedRow();
//             if (selectedRow != -1) {
//                 String customer = (String) tableModel.getValueAt(selectedRow, 0);
//                 selectedComplaint = complaintMap.get(customer);
//                 updateChat(selectedComplaint);
//                 resolveButton.setEnabled(!selectedComplaint.isResolved());
//             }
//         });

//         sendButton.addActionListener(e -> sendMessage());
//         resolveButton.addActionListener(e -> resolveComplaint());
//     }

//     public static void addComplaint(String user, String message) {
//         String complaintId = user + System.currentTimeMillis();
//         Complaint1 complaint = new Complaint1(user, message);
//         complaintMap.put(complaintId, complaint);
//         instance.tableModel.addRow(new Object[]{complaintId, "Ongoing"});
//         if (customerInterface != null) {
//             customerInterface.updateTable();
//         }
//     }

//     private void sendMessage() {
//         String message = inputField.getText().trim();
//         if (!message.isEmpty()) {
//             int selectedRow = complaintTable.getSelectedRow();
//             if (selectedRow != -1) {  // If a complaint is selected, continue chat
//                 String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
//                 Complaint1 complaint = ComplaintSystem.complaintMap.get(complaintId);
//                 if (complaint != null && !complaint.isResolved()) {
//                     complaint.addMessage("User", message);
//                     inputField.setText("");
//                     updateChat(complaintId);
//                 }
//             } else { // Otherwise, create a new complaint
//                 ComplaintSystem.addComplaint("Customer1", message);
//                 updateTable();
//             }
//         }
//     }
    
        

//     private void resolveComplaint() {
//         if (selectedComplaint != null && !selectedComplaint.isResolved()) {
//             selectedComplaint.resolve();
//             updateChat(selectedComplaint.getUser());
//             resolveButton.setEnabled(false);
//             updateTable(); // Ensure the table reflects the resolved status
//         }
//     }
    
    

//     public void updateChat(String user) {
//         chatArea.setText("");
//         for (Complaint1 complaint : ComplaintSystem.complaintMap.values()) {
//             if (complaint.getUser().equals(user)) {
//                 for (String message : complaint.getMessages()) {
//                     chatArea.append(message + "\n");
//                 }
//             }
//         }
//     }
    
    
    

//     public static void setCustomerInterface(CustomerComplaint customerInterface) {
//         ComplaintSystem.customerInterface = customerInterface;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             ComplaintSystem managerInterface = new ComplaintSystem();
//             managerInterface.setVisible(true);
            
//             CustomerComplaint customerInterface = new CustomerComplaint();
//             setCustomerInterface(customerInterface);
//             customerInterface.setVisible(true);
//         });
//     }
// }

// class CustomerComplaint extends JFrame {
//     private JTable complaintTable;
//     private DefaultTableModel tableModel;
//     private JTextArea chatArea;
//     private JTextField inputField;
//     private JButton sendButton, newComplaintButton;

//     public CustomerComplaint() {
//         setTitle("Customer Complaint Interface");
//         setSize(500, 350);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         tableModel = new DefaultTableModel(new Object[]{"Your Complaints", "Status"}, 0);
//         complaintTable = new JTable(tableModel);
//         JScrollPane tableScrollPane = new JScrollPane(complaintTable);
//         add(tableScrollPane, BorderLayout.WEST);

//         chatArea = new JTextArea();
//         chatArea.setEditable(false);
//         JScrollPane chatScrollPane = new JScrollPane(chatArea);
//         add(chatScrollPane, BorderLayout.CENTER);

//         JPanel inputPanel = new JPanel(new BorderLayout());
//         inputField = new JTextField();
//         sendButton = new JButton("Send Message");
//         newComplaintButton = new JButton("New Complaint");
//         inputPanel.add(inputField, BorderLayout.CENTER);
//         inputPanel.add(sendButton, BorderLayout.EAST);
//         inputPanel.add(newComplaintButton, BorderLayout.SOUTH);
//         add(inputPanel, BorderLayout.SOUTH);

//         sendButton.addActionListener(e -> sendMessage());
//         newComplaintButton.addActionListener(e -> createNewComplaint());
//     }

//     private void sendMessage() {
//         String message = inputField.getText().trim();
//         if (!message.isEmpty()) {
//             ComplaintSystem.addComplaint("Customer1", message);
//             inputField.setText("");
//             updateChat("Customer1");
//         }
//     }

//     private void createNewComplaint() {
//         String newComplaint = JOptionPane.showInputDialog(this, "Enter your new complaint:");
//         if (newComplaint != null && !newComplaint.trim().isEmpty()) {
//             ComplaintSystem.addComplaint("Customer1", newComplaint);
//             updateTable();
//         }
//     }

//     public void updateChat(String complaintId) {
//         chatArea.setText("");
//         Complaint1 complaint = ComplaintSystem.complaintMap.get(complaintId);
//         if (complaint != null) {
//             for (String message : complaint.getMessages()) {
//                 chatArea.append(message + "\n");
//             }
//         }
//     }



    

//     public void updateTable() {
//         tableModel.setRowCount(0);
//         for (Map.Entry<String, Complaint1> entry : ComplaintSystem.complaintMap.entrySet()) {
//             tableModel.addRow(new Object[]{entry.getValue().getUser(), entry.getValue().isResolved() ? "Resolved" : "Ongoing"});
//         }
//     }
    
// }


package oodj.food_ordering_system.designUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Complaint1 {
    private String user;
    private List<String> messages;
    private boolean resolved;

    public Complaint1(String user, String message) {
        this.user = user;
        this.messages = new java.util.ArrayList<>();
        this.messages.add("User: " + message);
        this.resolved = false;
    }

    public String getUser() {
        return user;
    }

    public void addMessage(String sender, String message) {
        if (!resolved) {
            messages.add(sender + ": " + message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void resolve() {
        resolved = true;
        messages.add("System: This complaint has been resolved.");
    }
}

public class ComplaintSystem extends JFrame {
    private JTable complaintTable;
    private DefaultTableModel tableModel;
    static Map<String, Complaint1> complaintMap = new HashMap<>();
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton, resolveButton;
    private Complaint1 selectedComplaint;
    private static ComplaintSystem instance;
    private static CustomerComplaint customerInterface;

    public ComplaintSystem() {
        instance = this;
        setTitle("Complaint Management System");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
        complaintTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(complaintTable);
        add(tableScrollPane, BorderLayout.WEST);

        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatPanel.add(chatScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");
        resolveButton = new JButton("Resolve Case");
        // resolveButton.setEnabled(false);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.add(resolveButton, BorderLayout.SOUTH);
        chatPanel.add(inputPanel, BorderLayout.SOUTH);
        add(chatPanel, BorderLayout.CENTER);


        complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        complaintTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = complaintTable.getSelectedRow();
                if (selectedRow != -1) {
                    String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                    updateChat(complaintId);
                } else {
                    chatArea.setText(""); // Clear chat when unselected
                }
            }
        });

        sendButton.addActionListener(e -> sendMessage());
        resolveButton.addActionListener(e -> resolveComplaint());
    }

    public static void addComplaint(String user, String message) {
        String complaintId = user + System.currentTimeMillis();
        Complaint1 complaint = new Complaint1(user, message);
        complaintMap.put(complaintId, complaint);
        instance.tableModel.addRow(new Object[]{complaintId, "Ongoing"});
        if (customerInterface != null) {
            customerInterface.updateTable();
        }
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            int selectedRow = complaintTable.getSelectedRow();
            if (selectedRow != -1) {
                String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                Complaint1 complaint = complaintMap.get(complaintId);
                if (complaint != null && !complaint.isResolved()) {
                    complaint.addMessage("Manager", message);
                    inputField.setText("");
                    updateChat(complaintId);
                    if (customerInterface != null) {
                        customerInterface.updateChat(complaintId);
                    }
                }
            } else {
                addComplaint("Customer1", message);
                customerInterface.updateTable();
            }
        }
    }

    private void resolveComplaint() {
        if (selectedComplaint != null && !selectedComplaint.isResolved()) {
            selectedComplaint.resolve();
            updateChat(selectedComplaint.getUser());
            resolveButton.setEnabled(false);
            customerInterface.updateTable();
  // ✅ Use instance instead of static call
        }
    }
    

    private void updateChat(String complaintId) {
        chatArea.setText("");
        Complaint1 complaint = complaintMap.get(complaintId);
        if (complaint != null) {
            for (String message : complaint.getMessages()) {
                chatArea.append(message + "\n");
            }
        }
    }

    public static void setCustomerInterface(CustomerComplaint customerInterface) {
        ComplaintSystem.customerInterface = customerInterface;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ComplaintSystem managerInterface = new ComplaintSystem();
            managerInterface.setVisible(true);
            
            CustomerComplaint customerInterface = new CustomerComplaint();
            setCustomerInterface(customerInterface);
            customerInterface.setVisible(true);
        });
    }
}

class CustomerComplaint extends JFrame {
    private JTable complaintTable;
    private DefaultTableModel tableModel;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;


    

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
    
    //     chatArea = new JTextArea();
    //     chatArea.setEditable(false);
    //     JScrollPane chatScrollPane = new JScrollPane(chatArea);
    //     add(chatScrollPane, BorderLayout.CENTER);
    
    //     // 🔹 ADD CHAT INPUT FIELD & SEND BUTTON
    //     JPanel inputPanel = new JPanel(new BorderLayout());
    //     JTextField inputField = new JTextField();
    //     JButton sendButton = new JButton("Send Message");
    
    //     sendButton.addActionListener(e -> sendMessage(inputField));
    
    //     inputPanel.add(inputField, BorderLayout.CENTER);
    //     inputPanel.add(sendButton, BorderLayout.EAST);
    //     add(inputPanel, BorderLayout.SOUTH);
    // }
    
    public CustomerComplaint() {
        setTitle("Customer Complaint Interface");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                    } else {
                        chatArea.setText(""); // Clear chat when unselected
                        sendButton.setText("Create Complaint");
                    }
                }
            }
        });

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        add(chatScrollPane, BorderLayout.CENTER);

        // Add chat input field & send button
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Create Complaint");

        sendButton.addActionListener(e -> sendMessage(inputField));

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);
    }
    

    public void updateTable() {
        tableModel.setRowCount(0);
        for (Map.Entry<String, Complaint1> entry : ComplaintSystem.complaintMap.entrySet()) {
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().isResolved() ? "Resolved" : "Ongoing"});
        }
    }


    public void updateChat(String complaintId) {
        chatArea.setText("");
        Complaint1 complaint = ComplaintSystem.complaintMap.get(complaintId);
        if (complaint != null) {
            for (String message : complaint.getMessages()) {
                chatArea.append(message + "\n");
            }
        }
    }

    private void sendComplaint() {
        String message = JOptionPane.showInputDialog(this, "Enter your complaint:");
        if (message != null && !message.trim().isEmpty()) {
            ComplaintSystem.addComplaint("Customer1", message);
            updateTable();
        }
    }

    private void sendMessage(JTextField inputField) {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            int selectedRow = complaintTable.getSelectedRow();
            if (selectedRow != -1) { // If a complaint is selected, continue chat
                String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
                Complaint1 complaint = ComplaintSystem.complaintMap.get(complaintId);
                if (complaint != null && !complaint.isResolved()) {
                    complaint.addMessage("User", message);
                    inputField.setText("");
                    updateChat(complaintId);
                }
            } else { // Otherwise, create a new complaint
                sendComplaint();
            }
        }
    }
    
    
}

//     public CustomerComplaint() {
//         setTitle("Customer Complaint Interface");
//         setSize(500, 350);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         tableModel = new DefaultTableModel(new Object[]{"Complaint ID", "Status"}, 0);
//         complaintTable = new JTable(tableModel);
//         JScrollPane tableScrollPane = new JScrollPane(complaintTable);
//         add(tableScrollPane, BorderLayout.WEST);

//         chatArea = new JTextArea();
//         chatArea.setEditable(false);
//         JScrollPane chatScrollPane = new JScrollPane(chatArea);
//         add(chatScrollPane, BorderLayout.CENTER);

//         // 🔹 Create input field and buttons
//         JPanel inputPanel = new JPanel(new BorderLayout());
//         JTextField inputField = new JTextField();
//         JButton actionButton = new JButton("Create New Complaint"); // Default action
//         inputPanel.add(inputField, BorderLayout.CENTER);
//         inputPanel.add(actionButton, BorderLayout.EAST);
//         add(inputPanel, BorderLayout.SOUTH);

//         // 🔹 Table selection listener to toggle button behavior
//         complaintTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//         complaintTable.getSelectionModel().addListSelectionListener(e -> {
//             if (!e.getValueIsAdjusting()) {
//                 int selectedRow = complaintTable.getSelectedRow();
//                 if (selectedRow != -1) {
//                     String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
//                     updateChat(complaintId);
//                     actionButton.setText("Send Message"); // Change to send message
//                 } else {
//                     chatArea.setText(""); // Clear chat when unselected
//                     actionButton.setText("Create New Complaint"); // Change back to create new complaint
//                 }
//             }
//         });

//         // 🔹 Set button action based on selection
//         actionButton.addActionListener(e -> {
//             int selectedRow = complaintTable.getSelectedRow();
//             if (selectedRow != -1) {
//                 sendMessage(inputField);
//             } else {
//                 sendComplaint();
//             }
//         });

//         private void sendComplaint() {
//             String message = JOptionPane.showInputDialog(this, "Enter your complaint:");
//             if (message != null && !message.trim().isEmpty()) {
//                 String complaintId = "Customer1_" + System.currentTimeMillis();
//                 ComplaintSystem.addComplaint(complaintId, message);
//                 updateTable();
//             }
//         }

//         private void sendMessage(JTextField inputField) {
//             String message = inputField.getText().trim();
//             if (!message.isEmpty()) {
//                 int selectedRow = complaintTable.getSelectedRow();
//                 if (selectedRow != -1) {
//                     String complaintId = (String) tableModel.getValueAt(selectedRow, 0);
//                     Complaint1 complaint = ComplaintSystem.complaintMap.get(complaintId);
//                     if (complaint != null && !complaint.isResolved()) {
//                         complaint.addMessage("User", message);
//                         inputField.setText("");
//                         updateChat(complaintId);
//                     }
//                 }
//             }
//         }

//         public void updateTable() {
//             tableModel.setRowCount(0);
//             for (Map.Entry<String, Complaint1> entry : ComplaintSystem.complaintMap.entrySet()) {
//                 tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().isResolved() ? "Resolved" : "Ongoing"});
//             }
//         }

//     }

//     public void updateChat(String complaintId) {
//         chatArea.setText("");
//         Complaint1 complaint = ComplaintSystem.complaintMap.get(complaintId);
//         if (complaint != null) {
//             for (String message : complaint.getMessages()) {
//                 chatArea.append(message + "\n");
//             }
//         }
//     }
    
// }
