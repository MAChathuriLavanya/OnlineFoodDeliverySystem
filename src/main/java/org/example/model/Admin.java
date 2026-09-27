package org.example.model;

public class Admin extends User {
    private String department;

    // Constructor
    public Admin(String userId, String username, String password, String email, String department) {
        super(userId, username, password, email, "ADMIN");
        this.department = department;
    }

    // Getter and Setter
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // Polymorphic method override for text file persistence
    @Override
    public String toFileString() {
        return super.toFileString() + "," + department;
    }
}