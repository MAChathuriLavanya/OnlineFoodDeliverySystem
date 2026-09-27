package org.example;

import org.example.model.Admin;
import org.example.model.Customer;
import org.example.model.User;
import org.example.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        System.out.println("=== Adding Sample Users ===");

        // Sample Customer and Admin objects
        Customer customer1 = new Customer("U001", "kamal", "pas123", "kamal@gmail.com", "No 12, Colombo");
        Admin admin1 = new Admin("A001", "nimal_admin", "admin123", "admin@food.com", "IT Dept");

        // Save users to users.txt
        userService.registerUser(customer1);
        userService.registerUser(admin1);

        System.out.println("\n=== Reading All Users From File ===");
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("ID: " + user.getUserId() + " | Name: " + user.getUsername() + " | Role: " + user.getRole());
        }

        System.out.println("\n=== Testing Login ===");
        User loggedInUser = userService.login("kamal", "pas123");
        if (loggedInUser != null) {
            System.out.println("Login Successful! Welcome " + loggedInUser.getUsername());
        } else {
            System.out.println("Login Failed!");
        }
    }
}