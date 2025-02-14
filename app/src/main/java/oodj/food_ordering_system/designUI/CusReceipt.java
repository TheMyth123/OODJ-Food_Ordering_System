// package oodj.food_ordering_system.designUI;

// import java.time.format.DateTimeFormatter;
// import java.util.ArrayList;

// import oodj.food_ordering_system.models.Payment;
// import oodj.food_ordering_system.utils.OrderHandling;

// public class CusReceipt extends javax.swing.JFrame {

//     private String orderID;
//     private String customerID;

//     public CusReceipt(String orderID) {
//         this.orderID = orderID;
//         initComponents();
//         displayBook();
//     }


//    private void displayBook() {
//        if (this.orderID != null && !this.orderID.isEmpty()) {
//            ArrayList<Payment> payments = OrderHandling.getOrderHistory();
//            for (Payment payment : payments) {
//                if (payment.getOrderID().equals(this.orderID)) {
//                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.ENGLISH);

//                    customerID = payment.getCustomerID();
//                    orderID.setText(payment.getOrderI(D));
//                 //    UpDate.setText(.getPickupDate().format(dateFormatter));
//                 //    OffDate.setText(booking.getDropoffDate().format(dateFormatter));
//                    RatePrice.setText(String.valueOf(booking.getRatePerDay()));

//                    Total.setText(String.valueOf(booking.getTotalAmount()));

//                 //    ArrayList<Payment> payments = CarHandling.getCar();
//                 //    for (Car car : cars) {
//                 //        if (car.getcarID().equals(booking.getCarId())) {
//                 //            Brand.setText(car.getBrand());
//                 //            Model.setText(car.getModel());
//                 //            break;
//                 //        }
//                 //    }

//                 //    ArrayList<Customer> customers = UserHandling.getCustomers();
//                 //    for (Customer customer : customers) {
//                 //        if (customer.getID().equals(customerID)) {
//                 //            Name.setText(customer.getName());
//                 //            ContactNumber.setText(customer.getContactnumber());
//                 //            break;
//                 //        }
//                 //    }
//             //        ArrayList<Payments> payments = PaymentHandling.getPayment();
//             //        for (Payments payment : payments) {
//             //            if (payment.getBookId().equals(this.bookID)) {
//             //                Date.setText(String.valueOf(payment.getPaymentDate().format(dateFormatter)));
//             //                PaymentMethod.setText(payment.getPaymentMethod());
//             //                PaymentID.setText(payment.getPaymentId());
//             //                break;
//             //            }
//             //        }
//             //        break;
//             //    }
           
//        } else {
//            BookingID.setText("No Book ID provided");
//        }
//    }
// }

//     @SuppressWarnings("unchecked")
//     // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//     private void initComponents() {

//         back_icon = new javax.swing.JPanel();
//         m1 = new javax.swing.JPanel();
//         m2 = new javax.swing.JPanel();
//         backBtn = new javax.swing.JButton();
//         title = new javax.swing.JLabel();
//         title2 = new javax.swing.JLabel();
//         m4 = new javax.swing.JPanel();
//         content = new javax.swing.JPanel();
//         DateLabel = new javax.swing.JLabel();
//         Date = new javax.swing.JLabel();
//         NameLabel = new javax.swing.JLabel();
//         Name = new javax.swing.JLabel();
//         ContactLabel = new javax.swing.JLabel();
//         ContactNumber = new javax.swing.JLabel();
//         PaymentLabel = new javax.swing.JLabel();
//         BookingIDLabel = new javax.swing.JLabel();
//         BookingID = new javax.swing.JLabel();
//         BrandLabel = new javax.swing.JLabel();
//         Brand = new javax.swing.JLabel();
//         ModelLabel = new javax.swing.JLabel();
//         Model = new javax.swing.JLabel();
//         UpDateLabel = new javax.swing.JLabel();
//         UpDate = new javax.swing.JLabel();
//         OffDateLabel = new javax.swing.JLabel();
//         OffDate = new javax.swing.JLabel();
//         RatePriceLabel = new javax.swing.JLabel();
//         RatePrice = new javax.swing.JLabel();
//         TotalLabel = new javax.swing.JLabel();
//         Total = new javax.swing.JLabel();
//         Line = new javax.swing.JPanel();
//         Line1 = new javax.swing.JPanel();
//         PaymentID = new javax.swing.JLabel();

//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//         setTitle("Receipt");
//         setBackground(new java.awt.Color(255, 169, 140));
//         setMinimumSize(new java.awt.Dimension(550, 700));
//         setUndecorated(true);
//         setResizable(false);
//         setType(java.awt.Window.Type.POPUP);
//         getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

//         back_icon.setBackground(new java.awt.Color(25, 25, 25));
//         back_icon.setMaximumSize(new java.awt.Dimension(550, 90));
//         back_icon.setMinimumSize(new java.awt.Dimension(550, 90));
//         back_icon.setPreferredSize(new java.awt.Dimension(550, 90));
//         back_icon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

//         m1.setBackground(new java.awt.Color(25, 25, 25));
//         m1.setMaximumSize(new java.awt.Dimension(550, 25));
//         m1.setMinimumSize(new java.awt.Dimension(550, 25));
//         m1.setPreferredSize(new java.awt.Dimension(548, 25));

//         javax.swing.GroupLayout m1Layout = new javax.swing.GroupLayout(m1);
//         m1.setLayout(m1Layout);
//         m1Layout.setHorizontalGroup(
//             m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 550, Short.MAX_VALUE)
//         );
//         m1Layout.setVerticalGroup(
//             m1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 25, Short.MAX_VALUE)
//         );

//         back_icon.add(m1);

//         m2.setBackground(new java.awt.Color(25, 25, 25));
//         m2.setMaximumSize(new java.awt.Dimension(10, 43));
//         m2.setMinimumSize(new java.awt.Dimension(10, 43));

//         javax.swing.GroupLayout m2Layout = new javax.swing.GroupLayout(m2);
//         m2.setLayout(m2Layout);
//         m2Layout.setHorizontalGroup(
//             m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 10, Short.MAX_VALUE)
//         );
//         m2Layout.setVerticalGroup(
//             m2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 43, Short.MAX_VALUE)
//         );

//         back_icon.add(m2);

//         backBtn.setBackground(new java.awt.Color(25, 25, 25));
//         backBtn.setForeground(new java.awt.Color(245, 251, 254));
//         backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/backIcon.png"))); // NOI18N
//         backBtn.setBorder(null);
//         backBtn.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 backBtnActionPerformed(evt);
//             }
//         });
//         back_icon.add(backBtn);

//         title.setBackground(new java.awt.Color(25, 25, 25));
//         title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         title.setForeground(new java.awt.Color(255, 169, 140));
//         title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         title.setText("Official Receipt");
//         title.setAlignmentX(0.5F);
//         title.setMaximumSize(new java.awt.Dimension(444, 35));
//         title.setMinimumSize(new java.awt.Dimension(444, 35));
//         title.setPreferredSize(new java.awt.Dimension(444, 35));
//         back_icon.add(title);

//         title2.setBackground(new java.awt.Color(25, 25, 25));
//         title2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
//         title2.setForeground(new java.awt.Color(255, 169, 140));
//         title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         title2.setText("Car Connect");
//         title2.setAlignmentX(0.5F);
//         title2.setMaximumSize(new java.awt.Dimension(550, 25));
//         title2.setMinimumSize(new java.awt.Dimension(550, 25));
//         title2.setPreferredSize(new java.awt.Dimension(550, 25));
//         back_icon.add(title2);

//         getContentPane().add(back_icon);

//         m4.setBackground(new java.awt.Color(25, 25, 25));
//         m4.setMaximumSize(new java.awt.Dimension(550, 25));
//         m4.setMinimumSize(new java.awt.Dimension(550, 25));
//         m4.setPreferredSize(new java.awt.Dimension(550, 25));

//         javax.swing.GroupLayout m4Layout = new javax.swing.GroupLayout(m4);
//         m4.setLayout(m4Layout);
//         m4Layout.setHorizontalGroup(
//             m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 550, Short.MAX_VALUE)
//         );
//         m4Layout.setVerticalGroup(
//             m4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 25, Short.MAX_VALUE)
//         );

//         getContentPane().add(m4);

//         content.setBackground(new java.awt.Color(25, 25, 25));
//         content.setMaximumSize(new java.awt.Dimension(550, 620));
//         content.setMinimumSize(new java.awt.Dimension(550, 620));
//         content.setPreferredSize(new java.awt.Dimension(550, 630));
//         content.setLayout(null);

//         DateLabel.setBackground(new java.awt.Color(25, 25, 25));
//         DateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         DateLabel.setForeground(new java.awt.Color(245, 251, 254));
//         DateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         DateLabel.setText("Date : ");
//         DateLabel.setAlignmentX(0.5F);
//         DateLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         DateLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         DateLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(DateLabel);
//         DateLabel.setBounds(50, 0, 60, 35);

//         Date.setBackground(new java.awt.Color(25, 25, 25));
//         Date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         Date.setForeground(new java.awt.Color(245, 251, 254));
//         Date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         Date.setText("< current date>");
//         Date.setAlignmentX(0.5F);
//         Date.setMaximumSize(new java.awt.Dimension(160, 35));
//         Date.setMinimumSize(new java.awt.Dimension(160, 35));
//         Date.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(Date);
//         Date.setBounds(110, 0, 160, 35);

//         NameLabel.setBackground(new java.awt.Color(25, 25, 25));
//         NameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         NameLabel.setForeground(new java.awt.Color(245, 251, 254));
//         NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         NameLabel.setText("Customer : ");
//         NameLabel.setAlignmentX(0.5F);
//         NameLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         NameLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         NameLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(NameLabel);
//         NameLabel.setBounds(50, 80, 140, 35);

//         Name.setBackground(new java.awt.Color(25, 25, 25));
//         Name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         Name.setForeground(new java.awt.Color(245, 251, 254));
//         Name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         Name.setText("< Customer name >");
//         Name.setAlignmentX(0.5F);
//         Name.setMaximumSize(new java.awt.Dimension(160, 35));
//         Name.setMinimumSize(new java.awt.Dimension(160, 35));
//         Name.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(Name);
//         Name.setBounds(250, 80, 260, 35);

//         ContactLabel.setBackground(new java.awt.Color(25, 25, 25));
//         ContactLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         ContactLabel.setForeground(new java.awt.Color(245, 251, 254));
//         ContactLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         ContactLabel.setText("Contact Number : ");
//         ContactLabel.setAlignmentX(0.5F);
//         ContactLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         ContactLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         ContactLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(ContactLabel);
//         ContactLabel.setBounds(50, 110, 140, 35);

//         ContactNumber.setBackground(new java.awt.Color(25, 25, 25));
//         ContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         ContactNumber.setForeground(new java.awt.Color(245, 251, 254));
//         ContactNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         ContactNumber.setText("< Contact Number >");
//         ContactNumber.setAlignmentX(0.5F);
//         ContactNumber.setMaximumSize(new java.awt.Dimension(160, 35));
//         ContactNumber.setMinimumSize(new java.awt.Dimension(160, 35));
//         ContactNumber.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(ContactNumber);
//         ContactNumber.setBounds(250, 110, 260, 35);

//         PaymentLabel.setBackground(new java.awt.Color(25, 25, 25));
//         PaymentLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         PaymentLabel.setForeground(new java.awt.Color(245, 251, 254));
//         PaymentLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         PaymentLabel.setText("Payment ID : ");
//         PaymentLabel.setAlignmentX(0.5F);
//         PaymentLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         PaymentLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         PaymentLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(PaymentLabel);
//         PaymentLabel.setBounds(50, 140, 140, 35);

//         BookingIDLabel.setBackground(new java.awt.Color(25, 25, 25));
//         BookingIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         BookingIDLabel.setForeground(new java.awt.Color(245, 251, 254));
//         BookingIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         BookingIDLabel.setText("Booking ID : ");
//         BookingIDLabel.setAlignmentX(0.5F);
//         BookingIDLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         BookingIDLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         BookingIDLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(BookingIDLabel);
//         BookingIDLabel.setBounds(50, 230, 140, 35);

//         BookingID.setBackground(new java.awt.Color(25, 25, 25));
//         BookingID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         BookingID.setForeground(new java.awt.Color(245, 251, 254));
//         BookingID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         BookingID.setText("< Booking ID >");
//         BookingID.setAlignmentX(0.5F);
//         BookingID.setMaximumSize(new java.awt.Dimension(160, 35));
//         BookingID.setMinimumSize(new java.awt.Dimension(160, 35));
//         BookingID.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(BookingID);
//         BookingID.setBounds(250, 230, 260, 35);

//         BrandLabel.setBackground(new java.awt.Color(25, 25, 25));
//         BrandLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         BrandLabel.setForeground(new java.awt.Color(245, 251, 254));
//         BrandLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         BrandLabel.setText("Car Brand : ");
//         BrandLabel.setAlignmentX(0.5F);
//         BrandLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         BrandLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         BrandLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(BrandLabel);
//         BrandLabel.setBounds(50, 260, 140, 35);

//         Brand.setBackground(new java.awt.Color(25, 25, 25));
//         Brand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         Brand.setForeground(new java.awt.Color(245, 251, 254));
//         Brand.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         Brand.setText("< Car Brand >");
//         Brand.setAlignmentX(0.5F);
//         Brand.setMaximumSize(new java.awt.Dimension(160, 35));
//         Brand.setMinimumSize(new java.awt.Dimension(160, 35));
//         Brand.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(Brand);
//         Brand.setBounds(250, 260, 260, 35);

//         ModelLabel.setBackground(new java.awt.Color(25, 25, 25));
//         ModelLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         ModelLabel.setForeground(new java.awt.Color(245, 251, 254));
//         ModelLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         ModelLabel.setText("Car Model : ");
//         ModelLabel.setAlignmentX(0.5F);
//         ModelLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         ModelLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         ModelLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(ModelLabel);
//         ModelLabel.setBounds(50, 290, 140, 35);

//         Model.setBackground(new java.awt.Color(25, 25, 25));
//         Model.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         Model.setForeground(new java.awt.Color(245, 251, 254));
//         Model.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         Model.setText("< Car Model >");
//         Model.setAlignmentX(0.5F);
//         Model.setMaximumSize(new java.awt.Dimension(160, 35));
//         Model.setMinimumSize(new java.awt.Dimension(160, 35));
//         Model.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(Model);
//         Model.setBounds(250, 290, 260, 35);

//         UpDateLabel.setBackground(new java.awt.Color(25, 25, 25));
//         UpDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         UpDateLabel.setForeground(new java.awt.Color(245, 251, 254));
//         UpDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         UpDateLabel.setText("Pick Up Date : ");
//         UpDateLabel.setAlignmentX(0.5F);
//         UpDateLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         UpDateLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         UpDateLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(UpDateLabel);
//         UpDateLabel.setBounds(50, 320, 140, 35);

//         UpDate.setBackground(new java.awt.Color(25, 25, 25));
//         UpDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         UpDate.setForeground(new java.awt.Color(245, 251, 254));
//         UpDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         UpDate.setText("< Date >");
//         UpDate.setAlignmentX(0.5F);
//         UpDate.setMaximumSize(new java.awt.Dimension(160, 35));
//         UpDate.setMinimumSize(new java.awt.Dimension(160, 35));
//         UpDate.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(UpDate);
//         UpDate.setBounds(250, 320, 260, 35);

//         OffDateLabel.setBackground(new java.awt.Color(25, 25, 25));
//         OffDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         OffDateLabel.setForeground(new java.awt.Color(245, 251, 254));
//         OffDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         OffDateLabel.setText("Drop Off Date : ");
//         OffDateLabel.setAlignmentX(0.5F);
//         OffDateLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         OffDateLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         OffDateLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(OffDateLabel);
//         OffDateLabel.setBounds(50, 350, 140, 35);

//         OffDate.setBackground(new java.awt.Color(25, 25, 25));
//         OffDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         OffDate.setForeground(new java.awt.Color(245, 251, 254));
//         OffDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         OffDate.setText("< Date >");
//         OffDate.setAlignmentX(0.5F);
//         OffDate.setMaximumSize(new java.awt.Dimension(160, 35));
//         OffDate.setMinimumSize(new java.awt.Dimension(160, 35));
//         OffDate.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(OffDate);
//         OffDate.setBounds(250, 350, 260, 35);

//         RatePriceLabel.setBackground(new java.awt.Color(25, 25, 25));
//         RatePriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         RatePriceLabel.setForeground(new java.awt.Color(245, 251, 254));
//         RatePriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         RatePriceLabel.setText("Price Per Rate(RM) : ");
//         RatePriceLabel.setAlignmentX(0.5F);
//         RatePriceLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         RatePriceLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         RatePriceLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(RatePriceLabel);
//         RatePriceLabel.setBounds(50, 380, 140, 35);

//         RatePrice.setBackground(new java.awt.Color(25, 25, 25));
//         RatePrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         RatePrice.setForeground(new java.awt.Color(245, 251, 254));
//         RatePrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         RatePrice.setText("< Price Per Rate >");
//         RatePrice.setAlignmentX(0.5F);
//         RatePrice.setMaximumSize(new java.awt.Dimension(160, 35));
//         RatePrice.setMinimumSize(new java.awt.Dimension(160, 35));
//         RatePrice.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(RatePrice);
//         RatePrice.setBounds(250, 380, 260, 35);

//         TotalLabel.setBackground(new java.awt.Color(25, 25, 25));
//         TotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         TotalLabel.setForeground(new java.awt.Color(245, 251, 254));
//         TotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         TotalLabel.setText("Total Price : ");
//         TotalLabel.setAlignmentX(0.5F);
//         TotalLabel.setMaximumSize(new java.awt.Dimension(60, 35));
//         TotalLabel.setMinimumSize(new java.awt.Dimension(60, 35));
//         TotalLabel.setPreferredSize(new java.awt.Dimension(60, 35));
//         content.add(TotalLabel);
//         TotalLabel.setBounds(50, 490, 140, 35);

//         Total.setBackground(new java.awt.Color(25, 25, 25));
//         Total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         Total.setForeground(new java.awt.Color(245, 251, 254));
//         Total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         Total.setText("< Total Price >");
//         Total.setAlignmentX(0.5F);
//         Total.setMaximumSize(new java.awt.Dimension(160, 35));
//         Total.setMinimumSize(new java.awt.Dimension(160, 35));
//         Total.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(Total);
//         Total.setBounds(250, 490, 260, 35);

//         Line.setBackground(new java.awt.Color(50, 50, 50));
//         Line.setMaximumSize(new java.awt.Dimension(2, 670));
//         Line.setMinimumSize(new java.awt.Dimension(2, 670));

//         javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
//         Line.setLayout(LineLayout);
//         LineLayout.setHorizontalGroup(
//             LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 450, Short.MAX_VALUE)
//         );
//         LineLayout.setVerticalGroup(
//             LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 670, Short.MAX_VALUE)
//         );

//         content.add(Line);
//         Line.setBounds(50, 490, 450, 2);

//         Line1.setBackground(new java.awt.Color(50, 50, 50));
//         Line1.setMaximumSize(new java.awt.Dimension(2, 670));
//         Line1.setMinimumSize(new java.awt.Dimension(2, 670));

//         javax.swing.GroupLayout Line1Layout = new javax.swing.GroupLayout(Line1);
//         Line1.setLayout(Line1Layout);
//         Line1Layout.setHorizontalGroup(
//             Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 450, Short.MAX_VALUE)
//         );
//         Line1Layout.setVerticalGroup(
//             Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGap(0, 670, Short.MAX_VALUE)
//         );

//         content.add(Line1);
//         Line1.setBounds(50, 520, 450, 2);

//         PaymentID.setBackground(new java.awt.Color(25, 25, 25));
//         PaymentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//         PaymentID.setForeground(new java.awt.Color(245, 251, 254));
//         PaymentID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//         PaymentID.setText("< Payment ID >");
//         PaymentID.setAlignmentX(0.5F);
//         PaymentID.setMaximumSize(new java.awt.Dimension(160, 35));
//         PaymentID.setMinimumSize(new java.awt.Dimension(160, 35));
//         PaymentID.setPreferredSize(new java.awt.Dimension(160, 35));
//         content.add(PaymentID);
//         PaymentID.setBounds(250, 140, 260, 35);

//         getContentPane().add(content);

//         pack();
//         setLocationRelativeTo(null);
//     }// </editor-fold>                        

//     private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
//         dispose();
//     }                                       


//     // Variables declaration - do not modify                     
//     private javax.swing.JLabel BookingID;
//     private javax.swing.JLabel BookingIDLabel;
//     private javax.swing.JLabel Brand;
//     private javax.swing.JLabel BrandLabel;
//     private javax.swing.JLabel ContactLabel;
//     private javax.swing.JLabel ContactNumber;
//     private javax.swing.JLabel Date;
//     private javax.swing.JLabel DateLabel;
//     private javax.swing.JPanel Line;
//     private javax.swing.JPanel Line1;
//     private javax.swing.JLabel Model;
//     private javax.swing.JLabel ModelLabel;
//     private javax.swing.JLabel Name;
//     private javax.swing.JLabel NameLabel;
//     private javax.swing.JLabel OffDate;
//     private javax.swing.JLabel OffDateLabel;
//     private javax.swing.JLabel PaymentID;
//     private javax.swing.JLabel PaymentLabel;
//     private javax.swing.JLabel RatePrice;
//     private javax.swing.JLabel RatePriceLabel;
//     private javax.swing.JLabel Total;
//     private javax.swing.JLabel TotalLabel;
//     private javax.swing.JLabel UpDate;
//     private javax.swing.JLabel UpDateLabel;
//     private javax.swing.JButton backBtn;
//     private javax.swing.JPanel back_icon;
//     private javax.swing.JPanel content;
//     private javax.swing.JPanel m1;
//     private javax.swing.JPanel m2;
//     private javax.swing.JPanel m4;
//     private javax.swing.JLabel title;
//     private javax.swing.JLabel title2;
//     // End of variables declaration                   

// }
