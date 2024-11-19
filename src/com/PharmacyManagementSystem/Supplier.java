package com.PharmacyManagementSystem;

import java.util.ArrayList;

public class Supplier extends User {
    private String contactInfo;
    private ArrayList<Product> productSupplied;
    private static int n = 0;

    public Supplier() {}

    public Supplier(String name, String email, String contactInfo) {
        super(name, Role.SUPPLIER, email);
        id = generateId();
        this.contactInfo = contactInfo;
        productSupplied = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public void setSupplierId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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

    private String generateId() {
        String Id = "Supplier_" + n;
        n++;
        return Id;
    }

    public void displaySupplierInfo() {
        System.out.println("Supplier ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Number of Products Supplied: " + getProductCount());
    }
}
