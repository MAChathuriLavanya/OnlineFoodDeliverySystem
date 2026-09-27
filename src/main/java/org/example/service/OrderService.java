package org.example.service;

import org.example.model.Order;

import java.io.*;

public class OrderService {
    private static final String FILE_PATH = "src/main/resources/orders.txt";

    public boolean placeOrder(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(order.toFileString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error placing order: " + e.getMessage());
            return false;
        }
    }
}