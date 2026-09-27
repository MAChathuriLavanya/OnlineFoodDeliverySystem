package org.example.service;

import org.example.model.FoodItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private static final String FILE_PATH = "src/main/resources/menu.txt";

    // Menu එකට අලුත් Food Item එකක් එකතු කිරීම
    public boolean addFoodItem(FoodItem item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(item.toFileString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error adding food item: " + e.getMessage());
            return false;
        }
    }

    // Menu එකේ ඇති සියලුම Food Items ලබා ගැනීම
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> items = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return items;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String itemId = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    String category = parts[3];

                    items.add(new FoodItem(itemId, name, price, category));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading menu: " + e.getMessage());
        }

        return items;
    }
}
