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
import java.awt.Component;
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
import raven.glasspanepopup.DefaultLayoutCallBack;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;

public class VendorAnalysisPanel extends JPanel {

    private final Color accentColor = new Color(255, 169, 140);
    private final Color darkBackground = new Color(31, 31, 31);

    public VendorAnalysisPanel(String analysisType) {
        setLayout(new BorderLayout());
        setBackground(darkBackground);
        switch (analysisType) {
            case "Vendor Revenue":
                addChart(createVendorRevenueChart());
                break;
            case "Best Selling Items":
                addChart(createBestSellingItemsChart());
                break;
            case "Order Types Breakdown":
                addChart(createOrderTypesBreakdownChart());
                break;
            case "Customer Order Frequency":
                addChart(createCustomerOrderFrequencyChart());
                break;
            case "Vendor Revenue Dashboard":
                addVendorRevenueDashboard();
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

    private void addVendorRevenueDashboard() {
        JSONArray vendors = new JSONArray(readVendorFile());
        JPanel vendorGridPanel = new JPanel(new GridLayout(0, 3, 20, 20));
        vendorGridPanel.setBackground(darkBackground);
        vendorGridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (int i = 0; i < vendors.length(); i++) {
            JSONObject vendor = vendors.getJSONObject(i);
            vendorGridPanel.add(createVendorCard(
                vendor.getString("VendorID"),
                vendor.getString("FoodCourtName"),
                vendor.getString("VendorName")
            ));
        }
        JScrollPane scrollPane = new JScrollPane(vendorGridPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(darkBackground);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setWheelScrollingEnabled(true);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createVendorCard(String vendorId, String foodCourtName, String vendorName) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(new Color(50, 50, 50));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(accentColor, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        JLabel idLabel = createInfoLabel("ID: " + vendorId, 16, Font.BOLD);
        JLabel nameLabel = createInfoLabel(vendorName, 14, Font.PLAIN);
        JLabel courtLabel = createInfoLabel(foodCourtName, 12, Font.ITALIC);
        infoPanel.add(idLabel);
        infoPanel.add(nameLabel);
        infoPanel.add(courtLabel);
        
        JButton viewButton = new JButton("View Dashboard");
        viewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        viewButton.setBackground(accentColor);
        viewButton.setForeground(darkBackground);
        viewButton.setFocusPainted(false);
        viewButton.addActionListener(e -> {
            // Create a new popup using the clicked vendor's id
            VendorRevenueDashboardPopup popupPanel = new VendorRevenueDashboardPopup(vendorId);
            GlassPanePopup.showPopup(popupPanel, new DefaultOption() {
                @Override
                public float opacity() {
                    return 0;
                }
                @Override
                public net.miginfocom.layout.LayoutCallback getLayoutCallBack(Component parent) {
                    return new DefaultLayoutCallBack(parent) {
                        @Override
                        public void correctBounds(net.miginfocom.layout.ComponentWrapper cw) {
                            int x = (parent.getWidth() - cw.getWidth()) / 2;
                            int y = (parent.getHeight() - cw.getHeight()) / 2;
                            cw.setBounds(x, y, cw.getWidth(), cw.getHeight());
                        }
                    };
                }
            });
        });
        
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

    private JFreeChart createVendorRevenueChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JSONArray payments = new JSONArray(readPaymentsFile());
        Map<String, Double> revenueMap = new HashMap<>();
        Map<String, String> menuToVendor = buildMenuToVendorMap();
        Map<String, String> vendorToFoodCourt = buildVendorToFoodCourtMap();
        for (int i = 0; i < payments.length(); i++) {
            JSONObject payment = payments.getJSONObject(i);
            JSONArray orderItems = payment.getJSONArray("OrderItems");
            for (int j = 0; j < orderItems.length(); j++) {
                JSONObject itemObj = orderItems.getJSONObject(j);
                String menuID = itemObj.getString("menuID");
                String vendorID = menuToVendor.getOrDefault(menuID, "Unknown");
                String foodCourt = vendorToFoodCourt.getOrDefault(vendorID, "Unknown");
                double itemTotal = itemObj.getDouble("totalPrice");
                revenueMap.put(foodCourt, revenueMap.getOrDefault(foodCourt, 0.0) + itemTotal);
            }
        }
        for (Map.Entry<String, Double> entry : revenueMap.entrySet()) {
            dataset.addValue(entry.getValue(), "Revenue", entry.getKey());
        }
        return ChartFactory.createBarChart(
            "Vendor Revenue", "Food Court", "Revenue", dataset,
            PlotOrientation.VERTICAL, false, true, false
        );
    }

    private JFreeChart createBestSellingItemsChart() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        JSONArray payments = new JSONArray(readPaymentsFile());
        Map<String, Integer> itemCountMap = new HashMap<>();
        Map<String, String> menuNameMap = buildMenuToNameMap();
        for (int i = 0; i < payments.length(); i++) {
            JSONObject payment = payments.getJSONObject(i);
            JSONArray itemsArray = payment.getJSONArray("OrderItems");
            for (int j = 0; j < itemsArray.length(); j++) {
                JSONObject itemObj = itemsArray.getJSONObject(j);
                String menuID = itemObj.getString("menuID");
                int quantity = itemObj.getInt("quantity");
                String menuName = menuNameMap.getOrDefault(menuID, menuID);
                itemCountMap.put(menuName, itemCountMap.getOrDefault(menuName, 0) + quantity);
            }
        }
        itemCountMap.forEach(dataset::setValue);
        return ChartFactory.createPieChart("Best Selling Items", dataset, true, true, false);
    }

    private JFreeChart createOrderTypesBreakdownChart() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        JSONArray payments = new JSONArray(readPaymentsFile());
        Map<String, Integer> typeCount = new HashMap<>();
        for (int i = 0; i < payments.length(); i++) {
            JSONObject payment = payments.getJSONObject(i);
            String serviceType = payment.getString("ServiceType");
            if ("Request for Delivery".equalsIgnoreCase(serviceType)) {
                serviceType = "Delivery";
            }
            typeCount.put(serviceType, typeCount.getOrDefault(serviceType, 0) + 1);
        }
        typeCount.forEach(dataset::setValue);
        return ChartFactory.createPieChart("Order Types Breakdown", dataset, true, true, false);
    }

    private JFreeChart createCustomerOrderFrequencyChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JSONArray payments = new JSONArray(readPaymentsFile());
        Map<String, Integer> customerOrders = new HashMap<>();
        for (int i = 0; i < payments.length(); i++) {
            String customerId = payments.getJSONObject(i).getString("CustomerID");
            customerOrders.put(customerId, customerOrders.getOrDefault(customerId, 0) + 1);
        }
        customerOrders.forEach((id, count) -> {
            Customer customer = UserHandling.getCustomerByID(id);
            dataset.addValue(count, "Orders", customer != null ? customer.getName() : id);
        });
        JFreeChart chart = ChartFactory.createBarChart(
            "Customer Order Frequency", "Customer", "Number of Orders", dataset,
            PlotOrientation.VERTICAL, false, true, false
        );
        if (chart.getPlot() instanceof CategoryPlot) {
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            if (plot.getRangeAxis() instanceof NumberAxis) {
                NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();
                numAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            }
        }
        return chart;
    }
}
