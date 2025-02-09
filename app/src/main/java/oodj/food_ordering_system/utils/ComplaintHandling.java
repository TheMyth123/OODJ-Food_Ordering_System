package oodj.food_ordering_system.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import oodj.food_ordering_system.models.Complaint;

public class ComplaintHandling {
    private static final String COMPLAINT = FileHandling.filePath.COMPLAINT_PATH.getValue();


    public static int getCMid() {
        int tempCount = 0;
    
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(COMPLAINT)));
            JSONArray topUpArray = new JSONArray(jsonData);
    
            for (int i = 0; i < topUpArray.length(); i++) {
                JSONObject topUpData = topUpArray.getJSONObject(i);
                String orderID = topUpData.getString("ComplaintID");
                if (orderID.contains("CM")) {
                    tempCount++;
                }
            }
        } catch (Exception e) {
            // Display error if file reading or parsing fails
            DialogBox.errorMessage("Error reading or parsing order JSON file: " + e.getMessage(), "Error");
        }
    
        return tempCount;
    }

    // public static void addComplaint(Complaint complaint) {
    //     try {
    //         String jsonData = new String(Files.readAllBytes(Paths.get(COMPLAINT)));
    //         JSONArray complaintArray = new JSONArray(jsonData);
    //         JSONObject complaintData = new JSONObject();
    //         complaintData.put("ComplaintID", "CM" + getCMid());
    //         complaintData.put("CustomerID", complaint.getUser());
    //         complaintData.put("Messages", complaint.getMessages());
    //         complaintData.put("Resolved", complaint.isResolved());
    //         complaintArray.put(complaintData);
    //         FileHandling.saveToFile(complaintArray, COMPLAINT);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    public static void addNewComplaint(Complaint complaint) {
        System.out.println("DEBUG: addComplaint() was called");
    
        try {
            Path filePath = Paths.get(COMPLAINT);
            
            // Ensure the file exists before reading
            if (!Files.exists(filePath)) {
                Files.write(filePath, "[]".getBytes()); // Create an empty JSON array if missing
                System.out.println("File did not exist, created a new complaints.txt file.");
            }
    
            String jsonData = new String(Files.readAllBytes(filePath)).trim();
            System.out.println("File content before adding complaint: " + jsonData);
    
            JSONArray complaintArray;
            if (jsonData.isEmpty() || jsonData.equals("[]")) {
                complaintArray = new JSONArray();
            } else {
                complaintArray = new JSONArray(jsonData);
            }
    
            // Debugging to confirm complaint details
            System.out.println("Adding complaint with ID: CM" + getCMid());
            System.out.println("Customer: " + complaint.getUser());
            System.out.println("Messages: " + complaint.getMessages());
    
            JSONObject complaintData = new JSONObject();
            complaintData.put("ComplaintID", "CM" + getCMid());
            complaintData.put("CustomerID", complaint.getUser());
            complaintData.put("Messages", complaint.getMessages());
            complaintData.put("Resolved", complaint.isResolved());
    
            complaintArray.put(complaintData);
            FileHandling.saveToFile(complaintArray, COMPLAINT);
    
            System.out.println("Complaint successfully added!");
    
        } catch (IOException e) {
            System.err.println("File I/O error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

    public static void updateComplaint(Complaint complaint) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(COMPLAINT)));
            JSONArray complaintArray = new JSONArray(jsonData);
            for (int i = 0; i < complaintArray.length(); i++) {
                JSONObject complaintData = complaintArray.getJSONObject(i);
                if (complaintData.getString("ComplaintID").equals(complaint.getId())) {
                    complaintData.put("Messages", complaint.getMessages());
                    complaintData.put("Resolved", complaint.isResolved());
                    complaintArray.put(i, complaintData);
                    FileHandling.saveToFile(complaintArray, COMPLAINT);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Complaint> readComplaints() throws IOException {
        ArrayList<Complaint> complaints = new ArrayList<>();
        Path filePath = Paths.get(COMPLAINT);
    
        // ✅ Check if the file exists before reading
        if (!Files.exists(filePath)) {
            System.out.println("Error: Complaint JSON file not found.");
            return complaints; // Return empty list
        }
    
        String jsonData = new String(Files.readAllBytes(filePath)).trim();
    
        // ✅ Check if file is empty and prevent JSON parsing errors
        if (jsonData.isEmpty() || jsonData.equals("[]")) {
            System.out.println("Warning: Complaint JSON file is empty.");
            return complaints; // Return empty list instead of trying to parse
        }
    
        try {
            JSONArray complaintArray = new JSONArray(jsonData);
            for (int i = 0; i < complaintArray.length(); i++) {
                JSONObject complaintData = complaintArray.getJSONObject(i);
    
                // ✅ Ensure messages is never null
                List<String> messages = new ArrayList<>();
                if (complaintData.has("Messages") && !complaintData.isNull("Messages")) {
                    JSONArray messagesArray = complaintData.optJSONArray("Messages"); // Avoid NullPointerException
                    if (messagesArray != null) {
                        for (int j = 0; j < messagesArray.length(); j++) {
                            messages.add(messagesArray.getString(j));
                        }
                    }
                }
    
                Complaint complaint = new Complaint(
                    complaintData.getString("ComplaintID"),
                    complaintData.getString("CustomerID"),
                    messages
                );
                complaints.add(complaint);
            }
        } catch (JSONException e) {
            System.out.println("JSON Parsing Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaints;
    }
    
    



    public static Complaint getComplaintById(String complaintId) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(COMPLAINT)));
            JSONArray complaintArray = new JSONArray(jsonData);
            for (int i = 0; i < complaintArray.length(); i++) {
                JSONObject complaintData = complaintArray.getJSONObject(i);
                if (complaintData.getString("ComplaintID").equals(complaintId)) {
                    List<String> messages = new ArrayList<>();
                    JSONArray messagesArray = complaintData.getJSONArray("Messages");
                    for (int j = 0; j < messagesArray.length(); j++) {
                        messages.add(messagesArray.getString(j));
                    }
                    return new Complaint(
                        complaintData.getString("ComplaintID"),
                        complaintData.getString("CustomerID"),
                        messages
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
