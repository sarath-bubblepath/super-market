package com.super_market;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Inventory {

    static List<AbstractItem> items = new ArrayList<>();

    public static void init() {
        ItemBuilder tataSalt = new ItemBuilder().setBarCode("8901").setName("Tata Salt").setPrice(19.00f).setQuantity(10)
                .setMfgDate(currentTime())
                .setExpiryDate(dateCal(Calendar.DAY_OF_MONTH, 3));
        items.add(new CookingItem(tataSalt));
        ItemBuilder vim = new ItemBuilder().setBarCode("8902").setName("Vim").setPrice(20.00f).setQuantity(5)
                .setExpiryDate(currentTime());
        items.add(new CleaningItem(vim));
        ItemBuilder chips = new ItemBuilder().setBarCode("8903").setName("Lays chips").setPrice(10.00f).setQuantity(15)
                .setMfgDate(dateCal(Calendar.DAY_OF_MONTH, -1))
                .setExpiryDate(dateCal(Calendar.DAY_OF_MONTH, 2));
        items.add(new SnackItem(chips));
    }

    private static Date currentTime() {
        return Calendar.getInstance().getTime();
    }

    private static Date dateCal(int field, int amount) {
        Calendar calInst = Calendar.getInstance();
        calInst.set(field, amount);
        return calInst.getTime();
    }

    public static void printItems() throws Exception {
        for (AbstractItem item : items) {
            System.out.println("Barcode: " + item.getBarCode());
            System.out.println("Name: " + item.getName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println();
        }
    }

    public static List<LineItem> buyItem(String barCode, Integer quantity) {
        AbstractItem reqItem = filterItemFromList(barCode);
        if (reqItem == null) {
            throw new AppException(String.format("Item (%s) is not found. Please try again", barCode));
        }
        // check item is available
        if (reqItem.getQuantity() == 0) {
            throw new AppException(String.format("Item (%s) stock is currently unavailable. Please try again", reqItem.getName()));
        } else if (reqItem.getQuantity() < quantity) {
            throw new AppException(String.format("Item (%s) quantity of %s only available. Please try again", reqItem.getName(), reqItem.getQuantity()));
        }
        return purchaseItem(reqItem, quantity);
    }

    private static List<LineItem> purchaseItem(AbstractItem reqItem, Integer quantity) {
        TransactionHolder.addLineItem(reqItem, quantity);
        reqItem.setQuantity(reqItem.getQuantity() - quantity);
        return TransactionHolder.getLineItems();
    }

    public static AbstractItem filterItemFromList(String barCode) {
        for (AbstractItem item :items) {
            if (item.getBarCode().equalsIgnoreCase(barCode)) {
                return item;
            }
        }
        return null;
    }
}
