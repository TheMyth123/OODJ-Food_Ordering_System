package oodj.food_ordering_system.designUI;

import oodj.food_ordering_system.models.Payment;
import oodj.food_ordering_system.models.CusOrder;
import oodj.food_ordering_system.utils.OrderHandling;
import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.util.ArrayList;

public class CusReceipt extends JFrame {

    private String orderID;
    private JTextArea receiptArea; // To display receipt content

    public CusReceipt(String orderID) {
        this.orderID = orderID;
        setTitle("Receipt - Order " + orderID);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        initComponents();
        displayReceipt();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Header
        JLabel titleLabel = new JLabel("Order Receipt", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.CENTER);

        // Receipt Content
        receiptArea = new JTextArea();
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton("Print");
        JButton closeButton = new JButton("Close");

        // Print button logic
        printButton.addActionListener(e -> {
            try {
                receiptArea.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Failed to print receipt!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Close button logic
        closeButton.addActionListener(e -> dispose());

        buttonPanel.add(printButton);
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }


    
    

    private void displayReceipt() {
        Payment payment = OrderHandling.getPaymentByID(orderID);
        if (payment == null) {
            receiptArea.setText("Order not foun  d!");
            return;
        }
    
        StringBuilder receipt = new StringBuilder();
        receipt.append("============================================\n");
        receipt.append("               OFFICIAL RECEIPT            \n");
        receipt.append("============================================\n");
    
        receipt.append(" Order ID      : ").append(payment.getOrderID()).append("\n");
        receipt.append(" Service Type  : ").append(payment.getServiceType()).append("\n");
        receipt.append(" Address       : ").append(payment.getAddress()).append("\n");
        receipt.append(" Date          : ").append(payment.getDate()).append("\n");
        receipt.append(" Order Status  : ").append(payment.getOrderStatus()).append("\n");
        receipt.append(" Payment Status: ").append(payment.getPaymentStatus()).append("\n\n");
    
        receipt.append(" Items Ordered:\n");
        receipt.append("--------------------------------------------\n");
    
        // Retrieve order items from Payment object
        ArrayList<CusOrder> orderItems = payment.getOrderItems();
    

        for (CusOrder item : orderItems) {
            receipt.append(String.format(" %-20s x%-3d RM%-6.2f \n",
                item.getName(), item.getQuantity(), item.getPrice())); // Uses Food Name
        }

    
        receipt.append("--------------------------------------------\n");
        receipt.append(String.format(" Total Amount: RM%.2f \n", payment.getTotalAmount()));
        receipt.append("============================================\n");
        receipt.append("         THANK YOU FOR YOUR ORDER!          \n");
        receipt.append("============================================\n");
    
        receiptArea.setText(receipt.toString());
    }
    
}
