// package oodj.food_ordering_system.utils;

// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.ArrayList;

// import org.json.JSONArray;
// import org.json.JSONObject;

// import oodj.food_ordering_system.models.Admin;

// public class test {
//     public static ArrayList<Admin> getAdmins() {
//         ArrayList<Admin> buffer = new ArrayList<>();

//         try {
//             String jsonData = new String(Files.readAllBytes(Paths.get(ADMIN)));
//             JSONArray adminsArray = new JSONArray(jsonData);

//             for (int i = 0; i < adminsArray.length(); i++) {
//                 JSONObject adminData = adminsArray.getJSONObject(i);

//                 String adminID = adminData.getString("AdminID");
//                 String username = adminData.getString("Username");
//                 String password = adminData.getString("Password");
//                 String name = adminData.getString("Name");
//                 String email = adminData.getString("Email");
//                 Boolean status = adminData.getBoolean("Status");

//                 Admin admin = new Admin(adminID, username, password, name, email, status);
//                 buffer.add(admin);
//             }

//         } catch (Exception e) {
//             DialogBox.errorMessage("Error reading or parsing admin JSON file: " + e.getMessage(), "Error");
//         }

//         return buffer;
//     }
// }
