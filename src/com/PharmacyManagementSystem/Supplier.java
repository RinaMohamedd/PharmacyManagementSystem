package com.PharmacyManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private int supplierId;
    private String name;
    private String contactInfo;
    private List<Product> productSupplied;

    public Supplier() {}

    public Supplier(int supplierId, String name, String contactInfo) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactInfo = contactInfo;
        productSupplied = new ArrayList<>();
    }

    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
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

    public void displaySupplierInfo() {
        System.out.println("Supplier ID: " + supplierId);
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Number of Products Supplied: " + getProductCount());
    }
}
