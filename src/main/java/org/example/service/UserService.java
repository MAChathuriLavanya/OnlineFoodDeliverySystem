package org.example.service;

import org.example.model.Admin;
import org.example.model.Customer;
import org.example.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String FILE_PATH = "src/main/resources/users.txt";

    // File එකට පරිශීලකයෙක් එකතු කිරීම
    public boolean registerUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.toFileString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

    // File එකෙන් පරිශීලකයන් ලබා ගැනීම
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return users;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String userId = parts[0];
                    String username = parts[1];
                    String password = parts[2];
                    String email = parts[3];
                    String role = parts[4];

                    if ("CUSTOMER".equalsIgnoreCase(role) && parts.length >= 6) {
                        users.add(new Customer(userId, username, password, email, parts[5]));
                    } else if ("ADMIN".equalsIgnoreCase(role) && parts.length >= 6) {
                        users.add(new Admin(userId, username, password, email, parts[5]));
                    } else {
                        users.add(new User(userId, username, password, email, role));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return users;
    }

    // Login පරික්ෂා කිරීම
    public User login(String username, String password) {
        for (User user : getAllUsers()) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}