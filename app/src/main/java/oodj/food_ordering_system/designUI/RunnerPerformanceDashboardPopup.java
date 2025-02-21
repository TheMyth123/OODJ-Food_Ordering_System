package oodj.food_ordering_system.designUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class RunnerPerformanceDashboardPopup extends JPanel {
    private String runnerID;
    private String runnerName;
    
    // Labels to display statistics
    private JLabel totalDeliveriesLabel;
    private JLabel totalEarningsLabel;
    private JLabel averageDeliveryTimeLabel;
    private JLabel averageDeliveryFeeLabel;
    
    public RunnerPerformanceDashboardPopup(String runnerID, String runnerName) {
        this.runnerID = runnerID;
        this.runnerName = runnerName;
        initComponents();
        loadDetails();
    }
    
    private void initComponents() {
        setBackground(new Color(31, 31, 31));
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Top: Runner name
        JLabel nameLabel = new JLabel("Runner: " + runnerName);
        nameLabel.setForeground(new Color(255, 169, 140));
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(nameLabel, BorderLayout.NORTH);
        
        // Center: 2x2 grid of statistic boxes
        JPanel boxesPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        boxesPanel.setBackground(new Color(31, 31, 31));
        
        // Create value labels (default to zero)
        totalDeliveriesLabel = new JLabel("0");
        totalEarningsLabel = new JLabel("0");
        averageDeliveryTimeLabel = new JLabel("0");
        averageDeliveryFeeLabel = new JLabel("0");
        
        // Add boxes
        boxesPanel.add(createBoxPanel("Total Deliveries", totalDeliveriesLabel));
        boxesPanel.add(createBoxPanel("Total Earnings", totalEarningsLabel));
        boxesPanel.add(createBoxPanel("Average Delivery Time", averageDeliveryTimeLabel));
        boxesPanel.add(createBoxPanel("Average Delivery Fee", averageDeliveryFeeLabel));
        
        add(boxesPanel, BorderLayout.CENTER);
    }
    
    // Helper method to create a statistic box panel
    private JPanel createBoxPanel(String title, JLabel valueLabel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(43, 43, 43));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        valueLabel.setForeground(new Color(255, 169, 140));
        valueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(valueLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    // Copy the calculation logic from RunnerRevenueDashboard.loadDetails()
    private void loadDetails() {
        int completedDeliveries = 0;
        double totalEarnings = 0.0;
        int totalDeliveryTime = 0; // in minutes
        
        // Specify the file path (adjust if needed)
        String filePath = "app\\\\src\\\\main\\\\resources\\\\databases\\\\delivery_runner_task.txt";
        JSONArray taskArray;
        File file = new File(filePath);
        
        if (file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                taskArray = new JSONArray(content.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading delivery task data file.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "No delivery task data found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Process each task: count only completed tasks for this runner
        for (int i = 0; i < taskArray.length(); i++) {
            JSONObject task = taskArray.getJSONObject(i);
            String taskRunnerID = task.getString("RunnerID");
            String taskStatus = task.getString("TaskStatus");
            
            if (taskRunnerID.equals(this.runnerID) && "completed".equalsIgnoreCase(taskStatus)) {
                completedDeliveries++;
                totalEarnings += task.getDouble("DeliveryFee");
                
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
        
        int avgDeliveryTime = completedDeliveries > 0 ? totalDeliveryTime / completedDeliveries : 0;
        double avgDeliveryFee = completedDeliveries > 0 ? totalEarnings / completedDeliveries : 0.0;
        
        // Update labels with calculated data
        totalDeliveriesLabel.setText(String.valueOf(completedDeliveries));
        totalEarningsLabel.setText(String.format("%.2f", totalEarnings));
        averageDeliveryTimeLabel.setText(avgDeliveryTime + " minutes");
        averageDeliveryFeeLabel.setText(String.format("%.2f", avgDeliveryFee));
    }
}
