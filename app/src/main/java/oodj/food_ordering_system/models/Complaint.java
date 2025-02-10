package oodj.food_ordering_system.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Complaint {
    private String id;
    private String user;
    private List<String> messages;
    private boolean resolved;

    // ✅ Constructor with an existing message list
    public Complaint(String id, String user, List<String> messages) {
        this.id = id; 
        this.user = user;
        this.messages = (messages != null) ? messages : new ArrayList<>(); // ✅ Prevents null
        this.resolved = false;
    }

    // ✅ Constructor with a single message
    public Complaint(String user, String message) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
        this.user = user;
        this.messages = new ArrayList<>(); // ✅ Initialize messages before using add()
        this.messages.add("User: " + message);
        this.resolved = false;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void addMessage(String sender, String message) {
        if (!resolved) {
            messages.add(sender + ": " + message);
        }
    }

    public List<String> getMessages() {
        if (messages == null) {  // ✅ Ensure messages is never null
            messages = new ArrayList<>();
        }
        return messages;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void resolve() {
        resolved = true;
        messages.add("System: This complaint has been resolved.");
    }
}
