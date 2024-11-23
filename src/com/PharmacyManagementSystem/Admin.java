package com.PharmacyManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Admin extends User{

    private ArrayList<Product> products;
    private ArrayList<Cashier> cashiers;
    private ArrayList<Customer> customers;
    private ArrayList<Supplier> suppliers;
    private ArrayList<Cart> orders;
    private static int n = 0;

    public Admin() {};
    public Admin(String name, String email, String password) {
        super(name, Role.ADMIN, email, password);
        id = generateId();
        products = new ArrayList<>();
        //users = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }
    public void setCashiers(ArrayList<Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    /*public ArrayList<Cart> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Cart> orders) {
        this.orders = orders;
    }*/

    //Product methods
    //20/11
    //should check if the product already exists and if it does then change the quantity only if it's greater
    public void addNewProduct(String pName, double pPrice, int pQuantity, Supplier pSupplier, LocalDate pExpirationDate) {
        Product product = new Product(pName, pPrice, pQuantity, pSupplier, pExpirationDate);
        products.add(product);
        System.out.println("Product added successfully to the pharmacy");
    }

    //20//11
    public void editProduct(String productId, String field, String value) {//done
        for (Product product : products) {
            if (product.getProductId().equals(productId)){
                if (field.equalsIgnoreCase("name")) {
                    product.setName(value);
                    return;
                }
                else if (field.equalsIgnoreCase("price")) {
                    product.setPrice(Double.parseDouble(value));
                    return;
                }
                else if (field.equalsIgnoreCase("quantity")) {
                    product.setQuantity(Integer.parseInt(value));
                    return;
                }
                else {
                    System.out.println("Only Name, Price, and Quantity can be edited");
                    return;
                }
            }
            System.out.println("Product not found");
        }
    }

    //I think it won't be changed
    public void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        System.out.println("Product removed");
    }

    //20/11 should it just be boolean?
    public Product searchProductByField(String field, String value) {
        for (Product product : products) {
            if (field.equalsIgnoreCase("name") && product.getName().equalsIgnoreCase(value)) {
                return product;
            }
            else if (field.equalsIgnoreCase("id") && product.getProductId().equals(value)) {
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    //20/11
    public void viewProductReport() {
        System.out.println("---- Products Report ----");
        //will be changed
        System.out.println("List of Suppliers:");
        for(Supplier supplier: suppliers) {
            System.out.print(supplier.getName() + ": ");
            for(Product product : supplier.getProductSupplied()) {
                System.out.println(product.getName());
            }
        }
        System.out.println("List of Prices:");
        System.out.println("Best seller Product over a specific period of time:");
        System.out.println("Most revenue Product over a specific period of time:");

        for (Product product : products) {
            System.out.println("Number of pieces sold over a specific period of time:");

            System.out.println("List of suppliers:");
            System.out.println(product.getSuppliers());
            System.out.println("");
        }
    }

    //Cashier methods
    //20/11
    public void addNewCashier(String cName, String cEmail, String cPassword) {
        Cashier cashier = new Cashier(cName, cEmail, cPassword);
        cashiers.add(cashier);
        System.out.println("Cashier added successfully to the pharmacy");
    }

    //20/11
    public void editCashier(String cashierId, String field, String value) {//done
        for (Cashier cashier : cashiers) {
            if (cashier.getId().equals(cashierId)){
                if (field.equalsIgnoreCase("name")) {
                    cashier.setName(value);
                    return;
                }
                else if (field.equalsIgnoreCase("email")) {
                    cashier.setEmail(value);
                }
                else {
                    System.out.println("Only Name and Email can be edited");
                    return;
                }
            }
            System.out.println("Product not found");
        }
    }

    //20/11
    public void removeCashier(String cashierId) {
        cashiers.removeIf(cashier -> cashier.getId().equals(cashierId));
        System.out.println("Cashier removed");
    }

    //20/11
    public Cashier searchCashierByField(String field, String value) {
        for (Cashier cashier : cashiers) {
            if (field.equalsIgnoreCase("name") && cashier.getName().equalsIgnoreCase(value)) {
                return cashier;
            }
            else if (field.equalsIgnoreCase("id") && cashier.getId().equals(value)) {
                return cashier;
            }
            else if (field.equalsIgnoreCase("email") && cashier.getEmail().equals(value)) {
                return cashier;
            }
        }
        System.out.println("Cashier not found");
        return null;
    }

    //Customer methods
    //20/11
    public void addNewCustomer(String cName, String cEmail, String cPassword) {
        Customer customer = new Customer(cName, cEmail, cPassword);
        customers.add(customer);
        System.out.println("Customer added successfully to the pharmacy");
    }

    //20/11
    public void editCustomer(String customerId, String field, String value) {//done
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)){
                if (field.equalsIgnoreCase("name")) {
                    customer.setName(value);
                    return;
                }
                else if (field.equalsIgnoreCase("email")) {
                    customer.setEmail(value);
                }
                else {
                    System.out.println("Only Name and Email can be edited");
                    return;
                }
            }
            System.out.println("Customer not found");
        }
    }

    //20/11
    public void removeCustomer(String customerId) {
        cashiers.removeIf(customer -> customer.getId().equals(customerId));
        System.out.println("Customer removed");
    }

    //20/11
    public Customer searchCustomerByField(String field, String value) {
        for (Customer customer : customers) {
            if (field.equalsIgnoreCase("name") && customer.getName().equalsIgnoreCase(value)) {
                return customer;
            }
            else if (field.equalsIgnoreCase("id") && customer.getId().equals(value)) {
                return customer;
            }
            else if (field.equalsIgnoreCase("email") && customer.getEmail().equals(value)) {
                return customer;
            }
        }
        System.out.println("Cashier not found");
        return null;
    }

    //Supplier methods
    //20/11
    public void addNewSupplier(String sName, String sEmail, String sPassword, String sContactInfo) {
        Supplier supplier = new Supplier(sName, sEmail, sPassword, sContactInfo);
        suppliers.add(supplier);
        System.out.println("Supplier added successfully to the pharmacy");
    }

    //20/11
    public void editSupplier(String supplierId, String field, String value) {//done
        for (Supplier supplier : suppliers) {
            if (supplier.getId().equals(supplierId)){
                if (field.equalsIgnoreCase("name")) {
                    supplier.setName(value);
                    return;
                }
                else if (field.equalsIgnoreCase("email")) {
                    supplier.setEmail(value);
                }
                else {
                    System.out.println("Only Name and Email can be edited");
                    return;
                }
            }
            System.out.println("Supplier not found");
        }
    }

    //20/11
    public void removeSupplier(String supplierId) {
        suppliers.removeIf(supplier -> supplier.getId().equals(supplierId));
        System.out.println("Supplier removed");
    }

    //20/11
    public Supplier searchSupplierByField(String field, String value) {
        for (Supplier supplier : suppliers) {
            if (field.equalsIgnoreCase("name") && supplier.getName().equalsIgnoreCase(value)) {
                return supplier;
            }
            else if (field.equalsIgnoreCase("id") && supplier.getId().equals(value)) {
                return supplier;
            }
            else if (field.equalsIgnoreCase("email") && supplier.getEmail().equals(value)) {
                return supplier;
            }
        }
        System.out.println("Supplier not found");
        return null;
    }

    //Report about Users
    //20/11
    public void viewUserReport() {
        System.out.println("---- Users Report ----");


        //Number of Orders per each Cashier and their details
        System.out.println("Number of Orders per each Cashier and their details:");
        for (Cashier cashier : cashiers) {
            System.out.println("Number of Orders for " + cashier.getId() + ": " + cashier.getOrdersHandled().size());
            System.out.println("Orders Details:");
            for(Cart order: cashier.getOrdersHandled()) {
                System.out.println(order);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");


        //Cashier with the maximum number of Orders
        System.out.println("Cashier with the maximum number of Orders:");
        int maxOrders_cashier = 0;
        Cashier maxOrderCashier = null;
        for (Cashier cashier : cashiers) {
            if(cashier.getOrdersHandled().size() > maxOrders_cashier)
            {
                maxOrders_cashier = cashier.getOrdersHandled().size();
                maxOrderCashier = cashier;
            }
        }
        if (maxOrderCashier != null) {
            System.out.println("Cashier: " + maxOrderCashier);
            System.out.println("Number of Orders: " + maxOrders_cashier);
        } else {
            System.out.println("No cashiers to determine the maximum no. of Orders");
        }
        System.out.println("-------------------------------------------------------");


        //Cashier with the maximum number of revenue
        System.out.println("Cashier with the maximum number of revenue:");
        double maxRev = 0.0;
        Cashier maxRevCashier = null;
        for (Cashier cashier : cashiers) {

            if (cashier.getTotalPriceOfAllOrders() > maxRev) {
                maxRev = cashier.getTotalPriceOfAllOrders();
                maxRevCashier = cashier;
            }
        }
        if (maxRevCashier != null) {
            System.out.println("Cashier: " + maxRevCashier);
            System.out.println("Revenue: " + maxRev);
        } else {
            System.out.println("No cashiers to determine the maximum revenue");
        }
        System.out.println("-------------------------------------------------------");


        //Number of Orders per each Supplier and their details
        System.out.println("Number of Orders per each Supplier and their details:");
        for (Supplier supplier : suppliers) {
            System.out.println("Number od Orders for " + supplier.getId() + ": " + supplier.getProductCount());
            System.out.println("Orders Details:");
            for(Product order : supplier.getProductSupplied()) {
                System.out.println(order);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");


        //Supplier with maximum number of Orders
        System.out.println("Supplier with maximum number of Orders:");
        int maxOrders_sup = 0;
        Supplier maxOrderSupplier = null;
        for (Supplier supplier : suppliers) {
            if(supplier.getProductCount() > maxOrders_cashier)
            {

                maxOrders_sup = supplier.getProductCount();
                maxOrderSupplier = supplier;
            }
        }
        if (maxOrderSupplier != null) {
            System.out.println("Supplier: " + maxOrderSupplier);
            System.out.println("Number of Orders: " + maxOrders_sup);
        } else {
            System.out.println("No suppliers to determine the maximum no. of Orders");
        }
        System.out.println("-------------------------------------------------------");


        //Supplier with maximum number of revenue
        System.out.println("Supplier with maximum number of revenue:");
        Supplier maxRevSupplier = null;
        double maxRevSupplierRev = 0.0;
        for (Supplier supplier : suppliers) {
            if (supplier.getTotalPriceOfAllOrders() > maxRevSupplierRev) {
                maxRevSupplierRev = supplier.getTotalPriceOfAllOrders();
                maxRevSupplier = supplier;
            }
        }
        if (maxRevSupplier != null) {
            System.out.println("Supplier: " + maxRevSupplier);
            System.out.println("Revenue: " + maxRevSupplierRev);
        } else {
            System.out.println("No suppliers to determine the maximum revenue");
        }
        System.out.println("-------------------------------------------------------");


        //Number of Orders per each Customer and their details
        System.out.println("Number of Orders per each Customer and their details:");
        for (Customer customer : customers) {
            System.out.println("Number of Orders for " + customer.getId() + ": " + customer.getOrderHistory().size());
            System.out.println("Orders History:");
            for(Cart order : customer.getOrderHistory()) {
                System.out.println(order);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");


        //Customer with the maximum number of Orders
        System.out.println("Customer with the maximum number of Orders:");
        Customer maxOrderCustomer = null;
        double maxOrders_customer = 0;
        for (Customer customer : customers) {
            if (customer.getOrderHistory().size() > maxOrders_customer) {
                maxOrders_customer = customer.getOrderHistory().size() ;
                maxOrderCustomer = customer;
            }
        }
        if (maxOrderCustomer != null) {
            System.out.println("Customer: " + maxOrderCustomer);
            System.out.println("Number of Orders: " + maxOrders_customer);
        } else {
            System.out.println("No customers to determine the maximum no. of Orders");
        }
        System.out.println("-------------------------------------------------------");


        //Customer with the maximum number of revenue
        System.out.println("Customer with the maximum number of revenue:");
        Customer maxRevCustomer = null;
        double maxRevCustomerRev=0;
        for (Customer customer : customers) {
            if (customer.getTotalPriceOfAllOrders() > maxRevCustomerRev) {
                maxRevCustomerRev = customer.getTotalPriceOfAllOrders();
                maxRevCustomer = customer;
            }
        }
        if (maxRevCustomer != null) {
            System.out.println("Customer: " + maxRevCustomer);
            System.out.println("Revenue: " + maxRevCustomerRev);
        } else {
            System.out.println("No customers to determine the maximum revenue");
        }
        System.out.println("-------------------------------------------------------");
    }

    //will be changed
    public void viewOrdersReport() {
        System.out.println("---- Orders Report ----");
        System.out.println("Orders details:");
        System.out.println("--------------------------------------------");
        for (Cart order : orders) {
            System.out.println("Order ID: " + order.getId() + "\nCustomer: " + order.getCustomer().getName()
                    + "\nProduct List: ");
            order.printProductList();
            System.out.println("\nTotal Price: " + order.getTotalPrice()
                    + "\nOrder Date: " + order.getOrderDate());
            System.out.println();
        }
        System.out.println("--------------------------------------------");
        System.out.println("Average revenue over a specific period of time:");
        System.out.println("Total revenue over a specific period of time:");
    }

    private String generateId() {
        String Id = "Admin_" + n;
        n++;
        return Id;
    }
}
