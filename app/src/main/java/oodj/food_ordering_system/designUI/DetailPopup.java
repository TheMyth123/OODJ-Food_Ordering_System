package oodj.food_ordering_system.designUI;



import javax.swing.*;
import java.awt.*;

public class DetailPopup {
    public static void showDetails(String itemName, String imagePath) {
        // Create a JDialog (modal pop-up)
        JDialog dialog = new JDialog();
        dialog.setTitle(itemName);
        dialog.setSize(350, 400);
        dialog.setLayout(new BorderLayout());
        dialog.setModal(true); // Ensures the user interacts with the pop-up first

        // Load Image
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add Image to Dialog
        dialog.add(imageLabel, BorderLayout.CENTER);

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
