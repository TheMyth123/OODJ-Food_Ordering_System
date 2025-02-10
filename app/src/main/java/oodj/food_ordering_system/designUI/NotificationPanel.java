package oodj.food_ordering_system.designUI;

import net.miginfocom.swing.MigLayout;
import oodj.food_ordering_system.models.Notification;

import java.util.List;
import javax.swing.*;

public class NotificationPanel extends javax.swing.JPanel{

    private List<Notification> notifications;

    public NotificationPanel(List<Notification> notifications) {
        this.notifications = notifications;
        initComponents();
        setOpaque(false);
        JScrollBar sb = scroll.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new java.awt.Color(33, 140, 206));
        sb.setPreferredSize(new java.awt.Dimension(8, 8));
        sb.setUI(new ScrollBar());
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        panel.setLayout(new MigLayout("inset 0, fillx, wrap", "[fill]"));

        if (notifications.isEmpty()) {
            setPreferredSize(new java.awt.Dimension(388, 466));
        }

        loadNoti();
    }
    
    private void loadNoti() {
        for (Notification notification : notifications) {
            panel.add(new NotificationItem(notification.getTitle(), notification.getContent(), notification.getTimestamp(), notification.getActionLink()));
        }
    }

    @Override
    protected void paintComponent (java.awt.Graphics grphcs) {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) grphcs.create();
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        int header = 10;
        java.awt.geom.AffineTransform tran = new java.awt.geom.AffineTransform();
        tran.translate(getWidth() -25, 5);
        tran.rotate(Math.toRadians(45));
        java.awt.geom.Path2D p = new java.awt.geom.Path2D.Double(new java.awt.geom.RoundRectangle2D.Double(0, 0, 20, 20, 5, 5),tran);
        java.awt.geom.Area area = new java.awt.geom.Area(p);
        area.add(new java.awt.geom.Area(new java.awt.geom.RoundRectangle2D.Double(0, header, getWidth(), getHeight()-header, 10, 10)));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(45, 45, 45));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 10, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 169, 140));
        jLabel1.setText("Notifications");

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBackground(new java.awt.Color(45, 45, 45));
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getVerticalScrollBar().setBlockIncrement(32);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        scroll.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scroll))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration                   
}
