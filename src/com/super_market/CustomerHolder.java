package com.super_market;

import java.util.ArrayList;
import java.util.List;

public class CustomerHolder {

    static List<Customer> customers = new ArrayList<>();

    // demo customers
    public static void init() {
        customers.add(new Customer("cust_001", new User("Cust_A", "9729837271")));
        customers.add(new Customer("cust_002", new User("Cust_B", "9939738942")));
    }

    public static void print() {
        for (Customer cust : customers) {
            System.out.println("Name : " + cust.getName());
            System.out.println("Phone: " + cust.getPhoneNumber());
        }
    }

    public static Customer filterCustomer(String customerName) {
        for (Customer cust :customers) {
            if (cust.getName().equalsIgnoreCase(customerName)) {
                return cust;
            }
        }
        return null;
    }

}
