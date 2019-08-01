package com.super_market;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private String custName;
    private List<LineItem> lineItems;
    private Float totalTxnAmount = 0f;

    public Bill(String custName, List<LineItem> lineItems) {
        this.custName = custName;
        this.lineItems = lineItems;
        calculateTotalAmount();
    }

    public String getCustName() {
        return custName;
    }

    public Float getTotalTxnAmount() {
        return totalTxnAmount;
    }

//    public static void printBill(List<LineItem> lineItems) {
//        Float totalTxnAmount = 0f;
//        for (LineItem lineItem : lineItems) {
//            System.out.println(String.format("%s %s * %s = %s", lineItem.getName(),
//                    lineItem.getUnitPrice(), lineItem.getQuantity(), lineItem.getAmount()));
//            totalTxnAmount += lineItem.getAmount();
//        }
//        System.out.println("Total : " + totalTxnAmount);
//    }

    public void printBill() {
//        Float totalTxnAmount = 0f;
        for (LineItem lineItem : lineItems) {
            System.out.println(String.format("%s %s * %s = %s", lineItem.getName(),
                    lineItem.getUnitPrice(), lineItem.getQuantity(), lineItem.getAmount()));
//            totalTxnAmount += lineItem.getAmount();
        }
        System.out.println("Total : " + getTotalTxnAmount());
    }

    private Float calculateTotalAmount() {
        for (LineItem lineItem : lineItems) {
            totalTxnAmount += lineItem.getAmount();
        }
        return totalTxnAmount;
    }

}
