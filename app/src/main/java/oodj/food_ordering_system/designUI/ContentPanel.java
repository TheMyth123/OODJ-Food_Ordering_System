package oodj.food_ordering_system.designUI;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class ContentPanel extends JPanel {
    public ContentPanel() {

        
        // Initialize components
        JButton payBtn = new JButton("Pay by Card");
        payBtn.setBackground(new java.awt.Color(255, 51, 51));
        payBtn.setForeground(new java.awt.Color(255, 255, 255));

        JLabel totalLab = new JLabel(" Total：RM");
        totalLab.setBackground(new java.awt.Color(153, 153, 153));
        totalLab.setFont(new java.awt.Font("Dialog", Font.BOLD, 18));
        totalLab.setForeground(new java.awt.Color(0, 0, 0));
        totalLab.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JTable cartTable = new JTable(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "FoodID", "Name", "Quantity", "Total" }
        ) {
            Class[] types = new Class[]{
                String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        JScrollPane jScrollPane1 = new JScrollPane(cartTable);

        JLabel customernameLab = new JLabel("Customer Name:");
        JLabel contactLab = new JLabel("Contact Number:");
        JLabel emailLab = new JLabel("Email:");
        JLabel addressLab = new JLabel("Address:");
        JLabel nameLab = new JLabel("Username");

        // Set up GroupLayout with proper left-alignment
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20) // Padding from the left
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customernameLab)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLab, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                    .addComponent(contactLab)
                    .addComponent(emailLab)
                    .addComponent(addressLab)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalLab, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(payBtn, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE)) // Padding from the right
    );

    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20) // Padding from the top
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(customernameLab)
                    .addComponent(nameLab))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactLab)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLab)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressLab)
                .addGap(18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLab, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(payBtn))
                .addContainerGap(20, Short.MAX_VALUE)) // Padding from the bottom
    );
    }
}
