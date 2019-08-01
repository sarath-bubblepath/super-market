package com.super_market;

import java.util.Date;

public class SnackItem extends AbstractItem implements EatableItemIntf {

    private Date mfdDate;
    private Date expiryDate;

    public SnackItem(ItemBuilder itemBuilder) {
        super(itemBuilder);
        this.mfdDate = itemBuilder.getMfgDate();
        this.expiryDate = itemBuilder.getExpiryDate();
    }

    @Override
    public Date mfgDate() {
        return null;
    }

    @Override
    public Date expiryDate() {
        return null;
    }

    @Override
    public FoodType foodType() {
        return null;
    }
}
