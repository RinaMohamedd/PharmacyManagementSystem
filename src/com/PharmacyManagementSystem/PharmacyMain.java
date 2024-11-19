package com.PharmacyManagementSystem;

import java.util.Scanner;

public class PharmacyMain {
    public static void main(String[] args) {
        //Admin a = new Admin("Rina", "Rina123@gmail.com");
        int choice;
        Scanner in = new Scanner(System.in);
        do {
            int innerChoice;
            System.out.println("Choose your role:");
            System.out.println("-----------------------------------");
            System.out.println("| 1. Admin                        |");
            System.out.println("| 2. Customer                     |");
            System.out.println("| 3. Cashier                      |");
            System.out.println("| 4. Exit                         |");
            System.out.println("-----------------------------------");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Admin Menu:");
                        System.out.println("-----------------------------------");
                        System.out.println("| 1. Add New Product              |");
                        System.out.println("| 2. Edit Product                 |");
                        System.out.println("| 3. Remove Product               |");
                        System.out.println("| 4. Search for a Product         |");
                        System.out.println("| 5. View Reports About Products  |");
                        System.out.println("| 6. Add New User                 |");
                        System.out.println("| 7. Edit User                    |");
                        System.out.println("| 8. Remove User                  |");
                        System.out.println("| 9. Search for a User            |");
                        System.out.println("| 10. View Reports About Users    |");
                        System.out.println("| 11. View Reports About Orders   |");
                        System.out.println("| 12. LogOut                      |");
                        System.out.println("-----------------------------------");
                        System.out.print("Enter your choice: ");
                        innerChoice = in.nextInt();

                        switch (innerChoice) {
                            case 1:
                                System.out.println("Add New Product");
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Edit Product");
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Remove Product");
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Search for s Product");
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("View Reports About Products");
                                System.out.println();
                                break;
                            case 6:
                                System.out.println("Add New User");
                                System.out.println();
                                break;
                            case 7:
                                System.out.println("Edit User");
                                System.out.println();
                                break;
                            case 8:
                                System.out.println("Remove User");
                                System.out.println();
                                break;
                            case 9:
                                System.out.println("Search for a User");
                                System.out.println();
                                break;
                            case 10:
                                System.out.println("View Reports About Users");
                                System.out.println();
                                break;
                            case 11:
                                System.out.println("View Reports About Orders");
                                System.out.println();
                                break;
                            default:
                                System.out.println("You are now logged out");
                                System.out.println();
                        }
                    } while(innerChoice != 12);
                    break;
                case 2:
                    /*String name, email;
                    System.out.println("Enter name: ");
                    name = in.next();
                    System.out.println("Enter email: ");
                    email = in.next();
                    Customer c = new Customer(name, email);*/

                    do {
                        System.out.println("Customer Menu:");
                        System.out.println("-----------------------------------");
                        System.out.println("| 1. View Orders History          |");
                        System.out.println("| 2. Rate Order                   |");
                        System.out.println("| 3. LogOut                       |");
                        System.out.println("-----------------------------------");
                        System.out.print("Enter your choice: ");
                        innerChoice = in.nextInt();

                        switch (innerChoice) {
                            case 1:
                                System.out.println("View Orders History");
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Rate Order");
                                System.out.println();
                                break;
                            default:
                                System.out.println("You are now logged out");
                                System.out.println();
                        }
                    } while(innerChoice != 3);
                    break;
                case 3:
                    do {
                        System.out.println("Cashier Menu:");
                        System.out.println("-----------------------------------");
                        System.out.println("| 1. Create Cart                  |");
                        System.out.println("| 2. Add Product to Cart          |");
                        System.out.println("| 3. Remove Product from Cart     |");
                        System.out.println("| 4. Calculate Payment            |");
                        System.out.println("| 5. Cancel Cart                  |");
                        System.out.println("| 6. LogOut                       |");
                        System.out.println("-----------------------------------");
                        System.out.print("Enter your choice: ");
                        innerChoice = in.nextInt();

                        switch (innerChoice) {
                            case 1:
                                System.out.println("Create Cart");
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Add Product to Cart");
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Remove Product from Cart");
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Calculate Payment");
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("Cancel Cart");
                                System.out.println();
                                break;
                            default:
                                System.out.println("You are now logged out");
                                System.out.println();
                        }
                    } while(innerChoice != 6);
                    break;
                default:
                    System.out.println("Exiting Program");
            }
        } while(choice != 4);













        /*Scanner sc = new Scanner(System.in);

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
        cu1.viewOrderDetails();*/
    }
}
