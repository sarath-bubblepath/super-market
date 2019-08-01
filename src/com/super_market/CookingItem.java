package com.super_market;

import java.util.Date;

public class CookingItem extends AbstractItem implements EatableItemIntf {

    private Date mfgDate;
    private Date expiryDate;
    private FoodType foodType;

    public CookingItem(ItemBuilder itemBuilder) {
        super(itemBuilder);
        this.mfgDate = itemBuilder.getMfgDate();
        this.expiryDate = itemBuilder.getExpiryDate();
    }

    @Override
    public Date mfgDate() {
        return mfgDate;
    }

    @Override
    public Date expiryDate() {
        return expiryDate;
    }

    @Override
    public FoodType foodType() {
        return foodType;
    }
}
