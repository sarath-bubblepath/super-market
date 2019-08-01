package com.super_market;

public abstract class Item {

    String barCode;
    String name;
    Float price;

    Item(ItemBuilder itemBuilder) {
        this.barCode = itemBuilder.getBarCode();
        this.name = itemBuilder.getName();
        this.price = itemBuilder.getPrice();
    }

}
