package com.PharmacyManagementSystem;

import java.util.ArrayList;

public class Admin extends User{

    private ArrayList<Product> products;
    private ArrayList<User> users;
    private ArrayList<Cart> orders;
    private static int n = 0;

    public Admin() {};
    public Admin(String name, String email) {
        super(name, Role.ADMIN, email);
        id = generateId();
        products = new ArrayList<>();
        users = new ArrayList<>();
        orders = new ArrayList<>();
    }

    //probably done
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully");
    }

    //needs to change in case the product id doesn't exist
    public void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        System.out.println("Product removed");
    }

    //will need to change so that I can edit one thing at a time
    public void editProduct(String productId, Product updatedProduct) { //done
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setSupplier(updatedProduct.getSupplier());
                System.out.println("Product updated successfully");
                return;
            }
        }
        System.out.println("Product not found");
    }

    //probably done
    public Product searchProductByField(String field, String value) {
        for (Product product : products) {
            if (field.equalsIgnoreCase("name") && product.getName().equalsIgnoreCase(value)) {
                return product;
            } else if (field.equalsIgnoreCase("id") && product.getProductId().equals(value)) {
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully");
    }

    public void editUser(String userId, User updatedUser) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                user.setName(updatedUser.getName());
                System.out.println("User updated successfully");
                return;
            }
        }
        System.out.println("User not found");

    }

    public void removeUser(String userId) {
        users.removeIf(user -> user.getId().equals(userId));
        System.out.println("User removed");
    }

    /*public User searchUserByField(String field, String value) { //done
        for (User user : users) {
            if (field.equalsIgnoreCase("name") && user.getName().equalsIgnoreCase(value)) {
                return user;
            } else if (field.equalsIgnoreCase("id") && user.getId()).equalsIgnoreCase(value) {
                return user;
            }
        }
        System.out.println("User not found");
        return null;
    }*/

    public void viewUsersReport() {
        System.out.println("---- Users Report ----");
        for (User user : users) {
            System.out.println("User ID: " + user.getId() + ", Name: " + user.getName() + ", Role: " + user.getRole());
        }
    }

    public void viewOrdersReport() {
        System.out.println("---- Orders Report ----");
        for (Cart order : orders) {
            System.out.println("Order ID: " + order.getId() + ", Customer: " + order.getCustomer().getName() + ", Total Price: " + order.getTotalPrice());
        }
    }

    /*public void addOrder(Cart order) {
        orders.add(order);
        System.out.println("Order added with ID: " + order.getOrderId());
    }*/

    private String generateId() {
        String Id = "Admin_" + n;
        n++;
        return Id;
    }
}
