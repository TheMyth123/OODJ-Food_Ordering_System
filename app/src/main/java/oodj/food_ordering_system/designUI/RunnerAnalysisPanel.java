package oodj.food_ordering_system.designUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONArray;
import org.json.JSONObject;
import oodj.food_ordering_system.models.Customer;
import oodj.food_ordering_system.utils.UserHandling;

public class RunnerAnalysisPanel extends JPanel {

    private final Color accentColor = new Color(255, 169, 140);
    private final Color darkBackground = new Color(31, 31, 31);

    public RunnerAnalysisPanel(String analysisType) {
        setLayout(new BorderLayout());
        setBackground(darkBackground);
        switch (analysisType) {
            case "Total Deliveries":
                //addChart(createTotalDeliveriesChart());
                break;
            case "Customer Ratings":
                //addChart(createCustomerRatingsChart());
                break;
            case "Runner Performance Dashboard":
                addRunnerPerformanceDashboard();
                break;
            default:
                add(createCenteredLabel("No analysis available for: " + analysisType));
                break;
        }
    }

    private void addChart(JFreeChart chart) {
        if (chart == null) return;
        chart.setBackgroundPaint(darkBackground);
        chart.getPlot().setBackgroundPaint(darkBackground);
        if (chart.getTitle() != null) {
            chart.getTitle().setPaint(accentColor);
            chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 20));
        }
        if (chart.getPlot() instanceof CategoryPlot) {
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            plot.getRenderer().setSeriesPaint(0, accentColor);
            customizeAxis(plot.getDomainAxis());
            customizeAxis(plot.getRangeAxis());
            plot.setDomainGridlinePaint(new Color(60, 60, 60));
            plot.setRangeGridlinePaint(new Color(60, 60, 60));
        } else if (chart.getPlot() instanceof PiePlot) {
            PiePlot<?> plot = (PiePlot<?>) chart.getPlot();
            plot.setLabelBackgroundPaint(darkBackground);
            plot.setLabelOutlinePaint(null);
            plot.setLabelShadowPaint(null);
            plot.setLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
            plot.setLabelPaint(Color.WHITE);
        }
        if (chart.getLegend() != null) {
            chart.getLegend().setItemFont(new Font("Segoe UI", Font.PLAIN, 12));
            chart.getLegend().setBackgroundPaint(darkBackground);
            chart.getLegend().setItemPaint(Color.WHITE);
        }
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(darkBackground);
        add(chartPanel, BorderLayout.CENTER);
    }

    private void customizeAxis(org.jfree.chart.axis.Axis axis) {
        axis.setLabelFont(new Font("Segoe UI", Font.BOLD, 14));
        axis.setTickLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
        axis.setLabelPaint(Color.WHITE);
        axis.setTickLabelPaint(Color.WHITE);
    }

    private void addRunnerPerformanceDashboard() {
        JSONArray runners = new JSONArray(readRunnerFile());
        JPanel runnerGridPanel = new JPanel(new GridLayout(0, 3, 20, 20));
        runnerGridPanel.setBackground(darkBackground);
        runnerGridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (int i = 0; i < runners.length(); i++) {
            JSONObject runner = runners.getJSONObject(i);
            runnerGridPanel.add(createRunnerCard(
                runner.getString("RunnerID"),
                runner.getString("Name"),
                runner.getString("LicensePlate")
            ));
        }
        JScrollPane scrollPane = new JScrollPane(runnerGridPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(darkBackground);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setWheelScrollingEnabled(true);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createRunnerCard(String runnerID, String Name, String LicensePlate) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(new Color(50, 50, 50));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(accentColor, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        JLabel idLabel = createInfoLabel("ID: " + runnerID, 16, Font.BOLD);
        JLabel nameLabel = createInfoLabel(Name, 14, Font.PLAIN);
        JLabel licenseLabel = createInfoLabel(LicensePlate, 12, Font.ITALIC);
        infoPanel.add(idLabel);
        infoPanel.add(nameLabel);
        infoPanel.add(licenseLabel);
        JButton viewButton = new JButton("View Dashboard");
        viewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        viewButton.setBackground(accentColor);
        viewButton.setForeground(darkBackground);
        viewButton.setFocusPainted(false);
        viewButton.addActionListener(e -> showMaintenanceMessage(runnerID));
        card.add(infoPanel, BorderLayout.CENTER);
        card.add(viewButton, BorderLayout.SOUTH);
        return card;
    }

    private JLabel createInfoLabel(String text, int size, int style) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", style, size));
        label.setForeground(Color.WHITE);
        return label;
    }

    private void showMaintenanceMessage(String vendorId) {
        JOptionPane.showMessageDialog(this,
            "Revenue dashboard for " + vendorId + "\nis currently under maintenance!",
            "Feature Coming Soon",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private JLabel createCenteredLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        return label;
    }

    private String readPaymentsFile() {
        try {
            return new String(Files.readAllBytes(Paths.get("app\\src\\main\\resources\\databases\\payment.txt")));
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    private Map<String, String> buildMenuToVendorMap() {
        Map<String, String> menuMap = new HashMap<>();
        try {
            String menuJson = new String(Files.readAllBytes(Paths.get("app\\src\\main\\resources\\databases\\menu.txt")));
            JSONArray menuArray = new JSONArray(menuJson);
            for (int i = 0; i < menuArray.length(); i++) {
                JSONObject menuItem = menuArray.getJSONObject(i);
                if ("True".equalsIgnoreCase(menuItem.getString("Status"))) {
                    String menuID = menuItem.getString("id");
                    String vendorID = menuItem.getString("VendorID");
                    menuMap.put(menuID, vendorID);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return menuMap;
    }

    private Map<String, String> buildMenuToNameMap() {
        Map<String, String> menuNameMap = new HashMap<>();
        try {
            String menuJson = new String(Files.readAllBytes(Paths.get("app\\src\\main\\resources\\databases\\menu.txt")));
            JSONArray menuArray = new JSONArray(menuJson);
            for (int i = 0; i < menuArray.length(); i++) {
                JSONObject menuItem = menuArray.getJSONObject(i);
                if ("True".equalsIgnoreCase(menuItem.getString("Status"))) {
                    String menuID = menuItem.getString("id");
                    String menuName = menuItem.getString("name");
                    menuNameMap.put(menuID, menuName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menuNameMap;
    }

    private String readVendorFile() {
        try {
            String path = "app\\src\\main\\resources\\databases\\vendor.txt";
            File file = new File(path);
            if (file.exists()) {
                return new String(Files.readAllBytes(Paths.get(path)));
            } else {
                System.out.println("Vendor file not found: " + path);
                return "[]";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    private String readRunnerFile() {
        try {
            String path = "app\\src\\main\\resources\\databases\\delivery_runner.txt";
            File file = new File(path);
            if (file.exists()) {
                return new String(Files.readAllBytes(Paths.get(path)));
            } else {
                System.out.println("Delivery Runner file not found: " + path);
                return "[]";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    private String readDeliveryRunnerTasksFile() {
        try {
            String path = "app\\src\\main\\resources\\databases\\delivery_runner_task.txt";
            File file = new File(path);
            if (file.exists()) {
                return new String(Files.readAllBytes(Paths.get(path)));
            } else {
                System.out.println("Delivery Runner Task file not found: " + path);
                return "[]";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    private Map<String, String> buildVendorToFoodCourtMap() {
        Map<String, String> vendorMap = new HashMap<>();
        try {
            String vendorJson = readVendorFile();
            JSONArray vendorArray = new JSONArray(vendorJson);
            for (int i = 0; i < vendorArray.length(); i++) {
                JSONObject vendorObj = vendorArray.getJSONObject(i);
                String vendorID = vendorObj.getString("VendorID");
                String foodCourtName = vendorObj.getString("FoodCourtName");
                vendorMap.put(vendorID, foodCourtName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendorMap;
    }

    // private JFreeChart createTotalDeliveriesChart() {
    //     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    //     try {
    //         String jsonStr = readDeliveryRunnerTasksFile();
    //         JSONArray tasks = new JSONArray(jsonStr);
    //         Map<String, Integer> deliveriesCount = new HashMap<>();
    //         for (int i = 0; i < tasks.length(); i++) {
    //             JSONObject task = tasks.getJSONObject(i);
    //             String runnerID = task.getString("RunnerID");
    //             deliveriesCount.put(runnerID, deliveriesCount.getOrDefault(runnerID, 0) + 1);
    //         }
    //         for (Map.Entry<String, Integer> entry : deliveriesCount.entrySet()) {
    //             dataset.addValue(entry.getValue(), "Total Deliveries", entry.getKey());
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     JFreeChart chart = ChartFactory.createBarChart(
    //         "Total Deliveries",
    //         "Runner",
    //         "Number of Deliveries",
    //         dataset,
    //         PlotOrientation.VERTICAL,
    //         false,
    //         true,
    //         false
    //     );
    //     if (chart.getPlot() instanceof CategoryPlot) {
    //         CategoryPlot plot = (CategoryPlot) chart.getPlot();
    //         if (plot.getRangeAxis() instanceof NumberAxis) {
    //             NumberAxis axis = (NumberAxis) plot.getRangeAxis();
    //             axis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    //         }
    //     }
    //     return chart;
    // }

    // private JFreeChart createCustomerRatingsChart() {
        
    // }
}
