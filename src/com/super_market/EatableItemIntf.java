package com.super_market;

import java.util.Date;

public interface EatableItemIntf {

    Date mfgDate();

    Date expiryDate();

    FoodType foodType();
}
