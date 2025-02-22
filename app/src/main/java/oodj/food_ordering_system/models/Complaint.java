package oodj.food_ordering_system.models;

import java.util.ArrayList;
import java.util.List;


public class Complaint {
    private String id;
    private String user;
    private List<String> messages;
    private boolean resolved;

    public Complaint(String id, String user, List<String> messages, boolean resolved) {
        this.id = id; 
        this.user = user;
        this.messages = (messages != null) ? messages : new ArrayList<>();
        this.resolved = resolved; // Correctly assign from JSON
    }
    

    // Constructor with a single message
    public Complaint(String user, String message) {
        // this.id = id; 
        this.user = user;
        this.messages = new ArrayList<>();
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
        if (messages == null) {  // Ensure messages is never null
            messages = new ArrayList<>();
        }
        return messages;
    }

    public boolean isResolved() {
        return this.resolved;
    }
    
    

    public void resolve() {
        resolved = true;
        messages.add("System: This complaint has been resolved.");
    }
}
