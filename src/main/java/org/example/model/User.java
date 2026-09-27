package org.example.model;

public class User {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String role; // "ADMIN" හෝ "CUSTOMER"

    // Constructor
    public User(String userId, String username, String password, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters (Encapsulation)
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Text file එකට Save කිරීමට පහසු වන පරිදි Data Format කිරීම
    public String toFileString() {
        return userId + "," + username + "," + password + "," + email + "," + role;
    }
}