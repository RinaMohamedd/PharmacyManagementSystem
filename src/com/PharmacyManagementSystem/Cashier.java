package com.PharmacyManagementSystem;

import java.util.ArrayList;
import com.PharmacyManagementSystem.Cart.Status;

public class Cashier extends User{
    private ArrayList<Cart> orderHandled;
    private static int n = 0;

    public Cashier() {}

    public Cashier(String name, String email, String password) {
        super(name, Role.CASHIER, email, password);
        id = generateId();
        orderHandled = new ArrayList<>();
    }

    public ArrayList<Cart> getOrdersHandled() {
        return orderHandled;
    }

    public Cart createOrder(Customer customer) {
        Cart newOrder = new Cart(customer);
        orderHandled.add(newOrder);
        return newOrder;
    }

    public void processPayment(Cart order) {
        System.out.println("Total is " + order.calculateTotalPrice());
        order.setStatus(Status.COMPLETED);
        //more code to get payment
        System.out.println("Payment processed successfully");
    }

    public void viewOrderHistory() {
        if (orderHandled.isEmpty()) {
            System.out.println("No orders handled yet.");
            return;
        }
        for (Cart order : orderHandled) {
            System.out.println(order.toString());
        }
    }

    private String generateId() {
        String Id = "Cashier_" + n;
        n++;
        return Id;
    }
}
