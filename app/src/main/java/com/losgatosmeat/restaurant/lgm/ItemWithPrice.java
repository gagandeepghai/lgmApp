package com.losgatosmeat.restaurant.lgm;

/**
 * Created by gghai on 8/17/16.
 */
public class ItemWithPrice {
    String name;
    String price;

    ItemWithPrice(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + "\t\t" + this.price;
    }
}
