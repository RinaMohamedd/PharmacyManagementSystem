package com.PharmacyManagementSystem;

import java.util.ArrayList;

public class Supplier extends User {
    private String contactInfo;
    private ArrayList<Product> productSupplied;
    private static int n = 0;

    public Supplier() {}

    public Supplier(String name, String email, String password, String contactInfo) {
        super(name, Role.SUPPLIER, email, password);
        id = generateId();
        this.contactInfo = contactInfo;
        productSupplied = new ArrayList<>();
    }

    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<Product> getProductSupplied() {
        return productSupplied;
    }
    public void setProductSupplied(ArrayList<Product> productSupplied) {
        this.productSupplied = productSupplied;
    }

    public void addProduct(Product product) {
        productSupplied.add(product);
    }

    public void removeProduct(Product product) {
        productSupplied.remove(product);
    }

    public int getProductCount() {
        return productSupplied.size();
    }


    public double getTotalPriceOfAllOrders() {
        double totalPrice = 0;
        for (Product order : productSupplied) {
            totalPrice += order.getPrice();
        }
        return totalPrice;
    }

    private String generateId() {
        String Id = "Supplier_" + n;
        n++;
        return Id;
    }

    @Override
    public String toString() {
        return "{ Supplier ID: " + id + ", Supplier Name: " + name + ", Constact Info: "
                + contactInfo + "Number of Products Supplied: " + getProductCount() + " }";
    }
}
