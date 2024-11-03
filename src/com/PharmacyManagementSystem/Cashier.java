package com.PharmacyManagementSystem;

import java.util.ArrayList;
import java.util.List;
import com.PharmacyManagementSystem.Cart.Status;

public class Cashier extends User{
    private List<Cart> orderHandled;

    public Cashier(String id, String name, String email) {
        super(id, name, Role.CASHIER, email);
        orderHandled = new ArrayList<>();
    }

    public List<Cart> getOrdersHandled() {
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
        //will be changed
        return "";
    }
}
