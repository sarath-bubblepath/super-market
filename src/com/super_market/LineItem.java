package com.super_market;

public class LineItem {
    // list of transaction
    // total sales

    private String name;
    private Float unitPrice;
    private Integer quantity;
    private Float amount;

    public LineItem(String name, Float unitPrice, Integer quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public void calculateItemAmount() {
        this.amount = getUnitPrice() * getQuantity();
    }

    public String getName() {
        return name;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getAmount() {
        return amount;
    }
}
