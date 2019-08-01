package com.super_market;

import java.util.Scanner;

public class MainApp {

    public static void init() {
        Store.init();
    }

    public static void main(String[] args) throws Exception {
        init();
        printValues();
        printOptions();
        Scanner scanner = null;
        try {
            _main(scanner);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void printOptions() {
        System.out.println("1. Print Inventory, 2. Buy Item, 3. Generate Bill, 4. Total Sales, 5. Apply Discount, 6. Exit");
    }

    private static void _main(Scanner scanner) throws Exception {
        do {
            System.out.println("Enter option : ");
            scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                System.out.println(scanner.next() + " - not allowed values. retry");
                continue;
            }
            int option = scanner.nextInt();
            try {
                optionHandler(option, scanner);
            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
            if (option == 6) {
                System.out.println("Bye!!");
                break;
            }
            System.out.println();
            printOptions();
        } while (true);
    }

    private static int handleInput(Scanner scanner) {
        System.out.println("Enter option : ");
        scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println(scanner.next() + " - not allowed values. retry");
            return 0;
        }
        return scanner.nextInt();
    }

    private static void printValues() throws Exception {
        System.out.println("Inventory");
        Inventory.printItems();
        System.out.println();
        System.out.println("Customers");
        CustomerHolder.print();
        System.out.println();
        System.out.println("Employees");
        Employee.print();
        System.out.println();
    }

    private static void optionHandler(int option, Scanner scanner) throws Exception {
        switch (option) {
            case 1: // Print Inventory
                Inventory.printItems();
                break;
            case 2:
                // Buy Item
                Inventory.buyItem(getInput(scanner, "Enter barcode"),
                        Integer.parseInt(getInput(scanner, "Enter quantity")));
                break;
            case 3:
                // Generate Bill
                generateBill(scanner);
                break;
            case 4:
                // Total Sales
                System.out.println("Total sale: " + TransactionHolder.getTotalSales());
                break;
            case 5:
                // Apply discount
                System.out.println("not handled - retry");
                break;
            case 6: // exit
                return;
            default:
                System.out.println("unexcepted value - " + option);
        }
    }

    private static void generateBill(Scanner scanner) {
        System.out.println("Enter Customer name");
        String customerName = scanner.next();
        Customer customer = CustomerHolder.filterCustomer(customerName);
        if (customer == null) {
            getInput(scanner, "Customer is not found. Please try again");
            return;
        }
        TransactionHolder.addBill(customerName, TransactionHolder.getLineItems());
    }

    private static String getInput(Scanner scanner, String s) {
        System.out.println(s);
        return scanner.next();
    }
}
