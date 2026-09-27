package org.example.model;

import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    private List<FoodItem> items;
    private double totalPrice;
    private String status; // "PENDING", "PREPARING", "DELIVERED"

    public Order(String orderId, String customerId, List<FoodItem> items, double totalPrice, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public List<FoodItem> getItems() { return items; }
    public double getTotalPrice() { return totalPrice; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String toFileString() {
        StringBuilder itemIds = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            itemIds.append(items.get(i).getItemId());
            if (i < items.size() - 1) {
                itemIds.append(";");
            }
        }
        return orderId + "," + customerId + "," + itemIds.toString() + "," + totalPrice + "," + status;
    }
}
