package org.example;

import org.example.model.Admin;
import org.example.model.Customer;
import org.example.model.FoodItem;
import org.example.model.User;
import org.example.service.MenuService;
import org.example.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        MenuService menuService = new MenuService();

        System.out.println("=== Testing User Management ===");

        // Sample Customer and Admin
        Customer customer1 = new Customer("U001", "kamal", "pas123", "kamal@gmail.com", "No 12, Colombo");
        Admin admin1 = new Admin("A001", "nimal_admin", "admin123", "admin@food.com", "IT Dept");

        userService.registerUser(customer1);
        userService.registerUser(admin1);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId() + " | Name: " + user.getUsername() + " | Role: " + user.getRole());
        }

        System.out.println("\n=== Testing Menu Management ===");

        // Sample Food Items
        FoodItem item1 = new FoodItem("F001", "Chicken Burger", 1200.00, "Main Course");
        FoodItem item2 = new FoodItem("F002", "Iced Coffee", 450.00, "Beverage");
        FoodItem item3 = new FoodItem("F003", "Chocolate Cake", 600.00, "Dessert");

        // Save Food Items to menu.txt
        menuService.addFoodItem(item1);
        menuService.addFoodItem(item2);
        menuService.addFoodItem(item3);

        // Read and Display Menu Items
        System.out.println("\n--- Food Menu ---");
        List<FoodItem> menu = menuService.getAllFoodItems();
        for (FoodItem item : menu) {
            System.out.println("ID: " + item.getItemId() + " | Item: " + item.getName() + " | Price: Rs." + item.getPrice() + " | Category: " + item.getCategory());
        }
    }
}