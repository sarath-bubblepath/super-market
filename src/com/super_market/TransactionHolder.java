package com.super_market;

import java.util.ArrayList;
import java.util.List;

//factory
public class TransactionHolder {

    static List<LineItem> lineItems = new ArrayList<>();
    static List<Bill> bills = new ArrayList<>();

    public static void addLineItem(AbstractItem reqItem, Integer quantity) {
        LineItem li = new LineItem(reqItem.getName(), reqItem.getPrice(), quantity);
        li.calculateItemAmount();
        lineItems.add(li);
    }

    public static List<LineItem> getLineItems() {
        return lineItems;
    }

    public static void addBill(String customerName, List<LineItem> lineItems) {
        Bill bill = new Bill(customerName, lineItems);
        bills.add(bill);
        bill.printBill();
        TransactionHolder.lineItems = new ArrayList<>(); // resetting the items from list
    }

    public static Float getTotalSales() {
        Float totalSales = 0f;
        for (Bill bill : bills) {
            totalSales += bill.getTotalTxnAmount();
        }
        return totalSales;
    }
}
