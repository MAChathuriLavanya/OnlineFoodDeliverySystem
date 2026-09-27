package org.example;

import org.example.model.Admin;
import org.example.model.Customer;
import org.example.model.FoodItem;
import org.example.model.Order;
import org.example.model.User;
import org.example.service.MenuService;
import org.example.service.OrderService;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();

        System.out.println("=== 1. Testing User Management ===");
        Customer customer1 = new Customer("U001", "kamal", "pas123", "kamal@gmail.com", "No 12, Colombo");
        Admin admin1 = new Admin("A001", "nimal_admin", "admin123", "admin@food.com", "IT Dept");

        userService.registerUser(customer1);
        userService.registerUser(admin1);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId() + " | Name: " + user.getUsername() + " | Role: " + user.getRole());
        }

        System.out.println("\n=== 2. Testing Menu Management ===");
        FoodItem item1 = new FoodItem("F001", "Chicken Burger", 1200.00, "Main Course");
        FoodItem item2 = new FoodItem("F002", "Iced Coffee", 450.00, "Beverage");

        menuService.addFoodItem(item1);
        menuService.addFoodItem(item2);

        List<FoodItem> menu = menuService.getAllFoodItems();
        for (FoodItem item : menu) {
            System.out.println("ID: " + item.getItemId() + " | Item: " + item.getName() + " | Price: Rs." + item.getPrice());
        }

        System.out.println("\n=== 3. Testing Order Placement ===");
        List<FoodItem> orderedItems = new ArrayList<>();
        orderedItems.add(item1);
        orderedItems.add(item2);

        double total = item1.getPrice() + item2.getPrice();
        Order newOrder = new Order("ORD1001", customer1.getUserId(), orderedItems, total, "PENDING");

        if (orderService.placeOrder(newOrder)) {
            System.out.println("Order Placed Successfully! Order ID: " + newOrder.getOrderId() + " | Total: Rs." + newOrder.getTotalPrice());
        } else {
            System.out.println("Failed to place order.");
        }
    }
}