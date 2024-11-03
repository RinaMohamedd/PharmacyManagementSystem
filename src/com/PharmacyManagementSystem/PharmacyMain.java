package com.PharmacyManagementSystem;

import java.util.Scanner;

public class PharmacyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Customer cu1 = new Customer();

        System.out.println("Enter your name: ");
        cu1.setName(sc.nextLine());
        System.out.println("Enter your email: ");
        cu1.setEmail(sc.nextLine());

        Cart c1 = new Cart();
        System.out.println("c1 id: " + c1.getId());
        Cart c2 = new Cart();
        System.out.println("c2 id: " + c2.getId());
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setName("p1");
        p2.setName("p2");
        p1.setPrice(33);
        p2.setPrice(90);
        c1.addProduct(p1, 2);
        System.out.println("price after adding one products: " + c1.getTotalPrice());
        c1.addProduct(p2, 4);
        System.out.println("price after adding two products: " + c1.getTotalPrice());
        c1.printProductlist();

        Product p3 = new Product();
        p3.setName("p3");
        p3.setPrice(56);
        c2.addProduct(p3, 3);
        System.out.println("price after adding one product: " + c2.getTotalPrice());
        c2.printProductlist();

        cu1.addOrder(c1);
        cu1.addOrder(c2);

        //there's an issue here
        System.out.println("Order history for customer cu1: ");
        cu1.viewOrderDetails();
    }
}
