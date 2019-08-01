package com.super_market;

public abstract class AbstractItem {

    // init
    private String barCode;
    private String name;
    private Float price;
    private Integer quantity;


    public AbstractItem(ItemBuilder itemBuilder) {
        this.barCode = itemBuilder.getBarCode();
        this.name = itemBuilder.getName();
        this.price = itemBuilder.getPrice();
        this.quantity = itemBuilder.getQuantity();
    }

//    public abstract String barCode();
//
//    public abstract String getName();
//
//    public abstract Float getUnitPrice();


    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public AbstractItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
