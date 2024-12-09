package oodj.food_ordering_system.utils;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class DialogBox {

    private static ImageIcon resizedImage(ImageIcon icon) {
        Image image = icon.getImage();
        Image currentimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(currentimg);
        return icon;
    }

    
    public static void reminderMessage(String message, String title) {
        ImageIcon reminderIcon = new ImageIcon("app\\src\\main\\resources\\images\\reminderIcon.png");
        reminderIcon = resizedImage(reminderIcon);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, reminderIcon);
    }

    public static void errorMessage(String message, String title) {
        ImageIcon errorIcon = new ImageIcon("app\\src\\main\\resources\\images\\errorIcon.png");
        errorIcon = resizedImage(errorIcon);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE, errorIcon);
    }

    public static void successMessage(String message, String title) {
        ImageIcon successIcon = new ImageIcon("app\\src\\main\\resources\\images\\successIcon.png");
        successIcon = resizedImage(successIcon);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, successIcon);
    }

    public static boolean confirmMessage(String message, String title) {
        String[] options = {"Yes", "No"};
        int confirm = JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return confirm == 0; 
    }
    
}

