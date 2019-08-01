package com.super_market;

import java.util.Date;

public class ItemBuilder {

    private String barCode;
    private String name;
    private Float price;
    private Integer quantity;
    private Date mfgDate;
    private Date expiryDate;

    public ItemBuilder setBarCode(String barCode) {
        this.barCode = barCode;
        return this;
    }

    public String getBarCode() {
        return barCode;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemBuilder setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public ItemBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ItemBuilder setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
        return this;
    }

    public Date getMfgDate() {
        return mfgDate;
    }

    public ItemBuilder setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
