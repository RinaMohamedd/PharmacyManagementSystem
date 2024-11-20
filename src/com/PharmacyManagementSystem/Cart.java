package com.PharmacyManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cart {
    protected String id = "0";
    private Status status; //I feel like it's unnecessary but idk
    protected Customer customer;
    private ArrayList<Product> productList;
    private ArrayList<Integer> quantityList;
    protected double totalPrice;
    private LocalDate orderDate;
    private static int n = 0;

    public enum Status {
        PENDING,
        COMPLETED,
        CANCELLED;
    }

    //no changes needed so far
    public Cart() {
        id = generateId();
        this.productList = new ArrayList<>();
        this.quantityList = new ArrayList<>();
        this.totalPrice = 0.0;
        this.orderDate = LocalDate.now();
    }

    public Cart(Customer customer) {
        id = generateId();
        this.customer = customer;
        this.productList = new ArrayList<>();
        this.quantityList = new ArrayList<>();
        this.totalPrice = 0.0;
        this.orderDate = LocalDate.now();
    }


    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    //comment this out
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void printProductList() {
        System.out.println("List of products:");
        for(int i = 0 ; i < productList.size(); i++) {
            System.out.println("Product " + (i+1) + ": " + (productList.get(i)).getName() +
                    ", Quantity: " + quantityList.get(i));
        }
    }

    //comment this out
    public ArrayList<Integer> getQuantityList() {
        return quantityList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }


    public void addProduct(Product product, int quantity) {
        productList.add(product);
        quantityList.add(quantity);
        calculateTotalPrice();
    }

    public void removeProduct(Product product) {
        int index = productList.indexOf(product);
        if (index != -1) {
            productList.remove(index);
            quantityList.remove(index);
            calculateTotalPrice();
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public double calculateTotalPrice() {
        totalPrice = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            totalPrice += productList.get(i).getPrice() * quantityList.get(i);
        }
        return totalPrice;
    }

    /*public Order checkout(Customer customer) {
        Order order = new Order(generateOrderId(), customer);
        for (int i = 0; i < productList.size(); i++) {
            order.addProduct(productList.get(i), quantityList.get(i));
        }
        productList.clear();
        quantityList.clear();
        totalPrice = 0.0;
        return order;
    }*/

    private String generateId() {
        String Id = "Order_" + n;
        n++;
        return Id;
    }

    //will check later
    @Override
    public String toString() {
        return "Order ID: " + id + ", Customer: " + customer.getName() + ", Total Price: "
                + totalPrice + ", Order Date: " + orderDate;
    }
}
