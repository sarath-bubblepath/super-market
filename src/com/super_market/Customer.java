package com.super_market;

public class Customer {

    String custId;
    int age;
    // Location for delivery

    UserIntf user;

    public Customer(String custId, UserIntf user) {
        this.custId = custId;
        this.user = user;
    }

    public String getName() {
        return user.getName();
    }

    public String getPhoneNumber() {
        return user.getPhoneNumber();
    }

    public String getCustId() {
        return custId;
    }

    // select item -> what do you want ? asking what to item
    // purchase item -> asking what to biller -> bill the items
}
