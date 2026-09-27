package org.example.model;

public class Customer extends User {
    private String deliveryAddress;

    // Constructor
    public Customer(String userId, String username, String password, String email, String deliveryAddress) {
        super(userId, username, password, email, "CUSTOMER");
        this.deliveryAddress = deliveryAddress;
    }

    // Getter and Setter
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    // Polymorphic method override for text file persistence
    @Override
    public String toFileString() {
        return super.toFileString() + "," + deliveryAddress;
    }
}
