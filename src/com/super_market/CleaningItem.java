package com.super_market;

import java.util.Date;

public class CleaningItem extends AbstractItem implements NonEatableItemIntf {

    private Date expiryDate;

    public CleaningItem(ItemBuilder itemBuilder) {
        super(itemBuilder);
        this.expiryDate = itemBuilder.getExpiryDate();
    }

    @Override
    public Date expiryDate() {
        return expiryDate;
    }
}
