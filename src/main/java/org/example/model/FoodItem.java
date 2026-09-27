package org.example.model;

public class FoodItem {
    private String itemId;
    private String name;
    private double price;
    private String category; // "Main Course", "Beverage", "Dessert" etc.

    // Constructor
    public FoodItem(String itemId, String name, double price, String category) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // Text file එකේ save කිරීමට format කිරීම
    public String toFileString() {
        return itemId + "," + name + "," + price + "," + category;
    }
}