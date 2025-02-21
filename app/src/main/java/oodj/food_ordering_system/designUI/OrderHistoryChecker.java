// // package oodj.food_ordering_system.designUI;

// // import java.awt.Color;
// // import java.awt.FlowLayout;
// // import java.awt.event.ActionEvent;
// // import java.awt.event.ActionListener;
// // import java.util.List;
// // import javax.swing.BoxLayout;
// // import javax.swing.JButton;
// // import javax.swing.JComboBox;
// // import javax.swing.JFrame;
// // import javax.swing.JLabel;
// // import javax.swing.JPanel;


// // /**
// //  *
// //  * @author khwon
// //  */
// // public class RevenueDashboardView extends JPanel{
// //         int WIDTH;
// // 	int HEIGHT = 150;
// // 	AddTransactionDao transfuc = new AddTransactionDao();
// // 	public RevenueDashboardView(int x,int y, int width, int height) {
// // 		// separate 2 windows ?????? 
// // 		this.setBounds(x,y,width,height);
// // 		this.WIDTH = width;
// // 		Init();
// // 	}

// //         void Init() {
		
// // 		// layout 
// // 		this.setLayout(null);
// // 		this.setBackground(Color.gray);
// //                 Style style = new Style();
		

// //                 // add content panel
// //                 JPanel jpanel1 = new JPanel();
// //                 jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
// // 		jpanel1.setBounds(0,0,WIDTH,50);
// //                 jpanel1.setBackground(Color.red);
// //                 JLabel notificationlabel = new JLabel("Revenue Dashboard");
// // 		notificationlabel.setFont(style.title);
// // 		jpanel1.add(notificationlabel);
                
// //                 JPanel jpanel2 = new JPanel();
// // 		jpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10)); // left alignment
// // 		jpanel2.setBounds(0,50,WIDTH,50);
// // 		jpanel2.setBackground(Color.green);
                
// //                 JPanel jpanel3 = new JPanel();
// // 		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT,10,20)); // left alignment
// // 		jpanel3.setBounds(50,150,250,275);
// // 		jpanel3.setBackground(Color.YELLOW);
// //                 jpanel3.setLayout(new BoxLayout(jpanel3, BoxLayout.Y_AXIS));
// //                 JLabel TotalRevenue = new JLabel("TotalRevenue");
// // 		TotalRevenue.setFont(style.title);
// // 		jpanel3.add(TotalRevenue);
                
// //                 JPanel jpanel4 = new JPanel();
// // 		jpanel4.setLayout(new FlowLayout(FlowLayout.LEFT,10,20)); // left alignment
// // 		jpanel4.setBounds(350,150,250,275);
// // 		jpanel4.setBackground(Color.YELLOW);
// //                 jpanel4.setLayout(new BoxLayout(jpanel4, BoxLayout.Y_AXIS));
// //                 JLabel OrderPerMonth = new JLabel("Order /Month");
// // 		OrderPerMonth.setFont(style.title);
// // 		jpanel4.add(OrderPerMonth);
                
// // //                JPanel jpanel5 = new JPanel();
// // //		jpanel5.setLayout(new FlowLayout(FlowLayout.LEFT,10,20)); // left alignment
// // //		jpanel5.setBounds(650,150,400,275);
// // //		jpanel5.setBackground(Color.YELLOW);
// // //                jpanel5.setLayout(new BoxLayout(jpanel5, BoxLayout.Y_AXIS));
// // //                JLabel graph = new JLabel("Graph");
// // //		graph.setFont(style.title);
// // //		jpanel5.add(graph);
                
// //                 // add button sample
                
// //                 JLabel jlabel1 = new JLabel("Month:");
// // 		jpanel2.add(jlabel1);
// // 		JComboBox MonthlySales = new JComboBox();
// // 		MonthlySales.addItem("--Select Month--");
// // 		MonthlySales.addItem("January");
// // 		MonthlySales.addItem("February");
// //                 MonthlySales.addItem("March");
// // 		MonthlySales.addItem("April");
// //                 MonthlySales.addItem("May");
// // 		MonthlySales.addItem("June");
// //                 MonthlySales.addItem("July");
// // 		MonthlySales.addItem("August");
// //                 MonthlySales.addItem("September");
// // 		MonthlySales.addItem("October");
// //                 MonthlySales.addItem("Novmeber");
// // 		MonthlySales.addItem("December");
// // 		jpanel2.add(MonthlySales);
                
// //                 this.add(jpanel1);
// //                 this.add(jpanel2);
// //                 this.add(jpanel3);
// //                 this.add(jpanel4);
// // //                this.add(jpanel5);

// //                 JLabel TotalRevenueValue = new JLabel("RM: 0");
// //                 TotalRevenueValue.setFont(style.account);
// //                 jpanel3.add(TotalRevenueValue);
// //                 JLabel TotalOrderValue = new JLabel("0 order");
// //                 TotalOrderValue.setFont(style.account);
// //                 jpanel4.add(TotalOrderValue);
                
// //                 String account = Login.account;                

                
// //                 MonthlySales.addActionListener (new ActionListener () {
// //                 public void actionPerformed(ActionEvent e) {
// //                         List<Transactions> translist  = transfuc.findDataByID(account);    
// //                         translist  = transfuc.findDataByPeriod(translist,MonthlySales.getSelectedIndex());
// //                         System.out.println(MonthlySales.getSelectedIndex());
// //                         double totalRevenue = 0;
// //                         int totalOrder = translist.size();
// //                         if(totalOrder>0){
// //                             for(int i = 0; i < translist.size(); i++){
// //                                 totalRevenue +=  Double.parseDouble(translist.get(i).getContent()); 
// //                             }
// //                         TotalRevenueValue.setText("RM"+Tools.decimformatter.format(totalRevenue));
// //                         TotalOrderValue.setText(totalOrder+" orders");
// //                     }
// //                         else{
// //                             TotalRevenueValue.setText("RM 0");
// //                             TotalOrderValue.setText("0 orders");
// //                         }
// //                 }
                
// //                 });                

// //         }

// // }


// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.util.Date;
// import javax.swing.*;
// import java.awt.event.*;
// import java.io.*;
// import org.json.*;
// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
// import org.jfree.data.category.DefaultCategoryDataset;

// public class OrderHistoryChecker {

//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Order History Checker");
//         frame.setSize(600, 400);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         JPanel panel = new JPanel();
//         frame.add(panel);
//         placeComponents(panel);

//         frame.setVisible(true);
//     }

//     private static void placeComponents(JPanel panel) {
//         panel.setLayout(null);

//         JLabel periodLabel = new JLabel("Select Period:");
//         periodLabel.setBounds(10, 20, 150, 25);
//         panel.add(periodLabel);

//         String[] periods = {"Daily", "Monthly", "Quarterly"};
//         JComboBox<String> periodDropdown = new JComboBox<>(periods);
//         periodDropdown.setBounds(150, 20, 150, 25);
//         panel.add(periodDropdown);

//         JButton checkButton = new JButton("Check History");
//         checkButton.setBounds(150, 60, 150, 25);
//         panel.add(checkButton);

//         JTextArea resultArea = new JTextArea();
//         resultArea.setBounds(10, 100, 560, 50);
//         panel.add(resultArea);

//         checkButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String selectedPeriod = (String) periodDropdown.getSelectedItem();
//                 JSONArray history = getVendorOrderHistory("VD00001", selectedPeriod);
//                 resultArea.setText(selectedPeriod + " order history: " + history.toString());
//                 createRevenueChart(history);
//             }
//         });
//     }

//     private static JSONArray getVendorOrderHistory(String vendorID, String period) {
//         try {
//             String filePath = "order_data.json"; // Replace with actual path
//             File file = new File(filePath);
            
//             if (!file.exists()) {
//                 return new JSONArray();
//             }

//             StringBuilder content = new StringBuilder();
//             try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                 String line;
//                 while ((line = reader.readLine()) != null) {
//                     content.append(line);
//                 }
//             }

//             JSONArray orderArray = new JSONArray(content.toString());
//             JSONArray filteredOrders = new JSONArray();
//             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//             Calendar cal = Calendar.getInstance();

//             switch (period.toLowerCase()) {
//                 case "daily":
//                     cal.add(Calendar.DAY_OF_YEAR, -1);
//                     break;
//                 case "monthly":
//                     cal.add(Calendar.MONTH, -1);
//                     break;
//                 case "quarterly":
//                     cal.add(Calendar.MONTH, -3);
//                     break;
//                 default:
//                     return new JSONArray();
//             }

//             Date cutoffDate = cal.getTime();

//             for (int i = 0; i < orderArray.length(); i++) {
//                 JSONObject order = orderArray.getJSONObject(i);
//                 if (!order.has("Date") || !order.has("TotalAmount")) continue;
                
//                 try {
//                     Date orderDate = sdf.parse(order.getString("Date"));
//                     if (!orderDate.before(cutoffDate)) {
//                         filteredOrders.put(order);
//                     }
//                 } catch (Exception ex) {
//                     ex.printStackTrace();
//                 }
//             }
//             return filteredOrders;
//         } catch (Exception e) {
//             e.printStackTrace();
//             return new JSONArray();
//         }
//     }

//     private static void createRevenueChart(JSONArray history) {
//         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//         for (int i = 0; i < history.length(); i++) {
//             try {
//                 JSONObject order = history.getJSONObject(i);
//                 if (!order.has("Date") || !order.has("TotalAmount")) continue;
                
//                 String date = order.getString("Date");
//                 double totalAmount = order.getDouble("TotalAmount");
//                 dataset.addValue(totalAmount, "Revenue", date);
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//             }
//         }

//         JFreeChart chart = ChartFactory.createLineChart(
//             "Revenue Over Time", "Date", "Revenue",
//             dataset);
        
//         JFrame chartFrame = new JFrame("Revenue Chart");
//         chartFrame.setSize(600, 400);
//         chartFrame.add(new ChartPanel(chart));
//         chartFrame.setVisible(true);
//     }
// }

