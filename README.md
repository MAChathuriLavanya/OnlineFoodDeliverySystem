# Online Food Delivery System 🍔🍕

A Java-based console application for managing online food orders with object-oriented principles and file persistence.

## 🚀 Features

- **User Management**: Support for `Customer` and `Admin` user roles using Inheritance.
- **Menu Management**: Add and view available food items across different categories.
- **Order Processing**: Place food orders with real-time total calculations and status tracking.
- **File Persistence**: All user profiles, menu items, and order records are saved locally in `.txt` files.

## 🛠️ Project Structure

```text
src/main/java/org/example/
├── model/
│   ├── User.java
│   ├── Admin.java
│   ├── Customer.java
│   ├── FoodItem.java
│   └── Order.java
├── service/
│   ├── UserService.java
│   ├── MenuService.java
│   └── OrderService.java
└── Main.java
