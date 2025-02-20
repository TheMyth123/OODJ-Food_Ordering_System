package oodj.food_ordering_system.utils;

import oodj.food_ordering_system.models.Notification;

import javax.swing.*;

import static oodj.food_ordering_system.designUI.LoginPage.loginID;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;

public class NotificationUtils{

    public static void loadNotifications(JPanel panel, List<Notification> notifications) {
        panel.removeAll(); // Clear old notifications

        for (Notification notification : notifications) {
            JPanel notificationCard = new JPanel();
            notificationCard.setBackground(new Color(43, 43, 43));
            notificationCard.setMaximumSize(new Dimension(280, 60));
            notificationCard.setPreferredSize(new Dimension(280, 60));
            notificationCard.setLayout(new BorderLayout());

            JLabel title = new JLabel(trimText(notification.getTitle(), 20));
            title.setForeground(new Color(255, 169, 140));

            JLabel content = new JLabel(trimText(notification.getContent(), 30));
            content.setForeground(new Color(245, 251, 254));

            JLabel timestamp = new JLabel(notification.getTimestamp());
            timestamp.setForeground(new Color(169, 169, 169));

            notificationCard.add(title, BorderLayout.NORTH);
            notificationCard.add(content, BorderLayout.CENTER);
            notificationCard.add(timestamp, BorderLayout.SOUTH);

            panel.add(notificationCard);
        }

        panel.revalidate();
        panel.repaint();
    }

    private static String trimText(String text, int length) {
        return text.length() > length ? text.substring(0, length) + "..." : text;
    }

    public static List<Notification> getUnreadNotifications(String jsonText) {
        List<Notification> notifications = new ArrayList<>();

        // Parse the JSON string into a JSONArray
        JSONArray notificationsArray = new JSONArray(jsonText);

        // Iterate through all notifications in the JSONArray
        for (int i = 0; i < notificationsArray.length(); i++) {
            JSONObject notificationObject = notificationsArray.getJSONObject(i);

            // Extract values for the fields
            String userId = notificationObject.getString("UserID");
            String readStatus = notificationObject.getString("ReadStatus");
            String status = notificationObject.getString("Status");

            // Check if the notification meets the specified conditions
            if ("Admin".equals(userId) && "False".equals(readStatus) && "True".equals(status)) {
                // Store the relevant information in a Notification object
                String timestamp = notificationObject.getString("Timestamp");
                String title = notificationObject.getString("Title");
                String content = notificationObject.getString("Content");
                String actionLink = notificationObject.getString("ActionLink");

                // Create a Notification object and add it to the list
                Notification notification = new Notification(timestamp, title, content, actionLink);
                notifications.add(notification);
            }
            
        }
        return notifications;
    }

    public static String getAllNotifications() {
        try {
            // Adjust the path to your notification.txt file
            String path = "app\\src\\main\\resources\\databases\\notification.txt";
            File file = new File(path);

            if (file.exists()) {
                // Read all lines from the file into a single string
                return new String(Files.readAllBytes(Paths.get(path)));
            } else {
                System.out.println("File not found: " + path);
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

// Error on customer notification
    public static List<Notification> getUnreadNotifications(String jsonText, String loginID, boolean isAdmin) {
        List<Notification> notifications = new ArrayList<>();

        // Parse the JSON string into a JSONArray
        JSONArray notificationsArray = new JSONArray(jsonText);

        // Iterate through all notifications in the JSONArray
        for (int i = 0; i < notificationsArray.length(); i++) {
            JSONObject notificationObject = notificationsArray.getJSONObject(i);

            // Extract values for the fields
            String userId = notificationObject.getString("UserID");
            String readStatus = notificationObject.getString("ReadStatus");
            String status = notificationObject.getString("Status");

            // Check if the notification meets the specified conditions
            if ((isAdmin && "Admin".equals(userId) && "False".equals(readStatus) && "True".equals(status)) || (isAdmin && "Manager".equals(userId) && "False".equals(readStatus) && "True".equals(status)) || (!isAdmin && loginID.equals(userId)) && "False".equals(readStatus) && "True".equals(status)) {
                // Store the relevant information in a Notification object
                String timestamp = notificationObject.getString("Timestamp");
                String title = notificationObject.getString("Title");
                String content = notificationObject.getString("Content");
                String actionLink = notificationObject.getString("ActionLink");

                // Create a Notification object and add it to the list
                Notification notification = new Notification(timestamp, title, content, actionLink);
                notifications.add(notification);
            }
        }
        return notifications;
    }

    public static void NotificationCreator(String userID, String type, String content, String title, String actionlink){
        try {
            // Adjust the path to your notification.txt file
            String path = "app/src/main/resources/databases/notification.txt";
            File file = new File(path);

            if (file.exists()) {
                String jsonText = new String(Files.readAllBytes(Paths.get(path)));
                JSONArray notificationsArray = new JSONArray(jsonText);

                String notificationID = "NT" + String.format("%05d", UserHandling.getNTId() + 1);

                JSONObject notification = new JSONObject();
                notification.put("UserID", userID);
                notification.put("ReadStatus", "False");
                notification.put("Status", "True");
                notification.put("Timestamp", java.time.LocalDateTime.now().toString());
                notification.put("Title", title);
                notification.put("Content", content);
                notification.put("ActionLink", actionlink);
                notification.put("Type", type);
                notification.put("NotificationID", notificationID);

                notificationsArray.put(notification);

                try (FileWriter fileWriter = new FileWriter(path)) {
                    fileWriter.write(notificationsArray.toString(2)); // Pretty print with indentation
                    fileWriter.flush();
                }
            } else {
                System.out.println("File not found: " + path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}


