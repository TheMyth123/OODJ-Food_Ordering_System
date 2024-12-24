package oodj.food_ordering_system.designUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NotificationItem extends javax.swing.JPanel {
    
    public NotificationItem(String title, String content, String timestamp, String actionLink) {
        initComponents();
        titleLabel.setText(title);
        contentLabel.setText(content);
        timestampLabel.setText(timestamp);

        // behave like a button
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Print "Clicked" when the item is clicked
                System.out.println(title + " " + actionLink + " Clicked");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new java.awt.Color(80, 80, 80)); // Lighten the background
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new java.awt.Color(60, 60, 60)); // Original color
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        contentLabel = new javax.swing.JLabel();
        timestampLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(60, 60, 60));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); 
        titleLabel.setForeground(new java.awt.Color(255, 169, 140));
        titleLabel.setText("Title");

        contentLabel.setBackground(new java.awt.Color(200, 200, 200));
        contentLabel.setForeground(new java.awt.Color(200, 200, 200));
        contentLabel.setText("Content");

        timestampLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        timestampLabel.setForeground(new java.awt.Color(150, 150, 150));
        timestampLabel.setText("Timestamp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timestampLabel)
                    .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timestampLabel)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel contentLabel;
    private javax.swing.JLabel timestampLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration                   
}
