package org.example.flowerstore_continue;

import org.example.flowerstore_continue.flowerStore.Item;


//this class only for testing
public class BasicItem extends Item {
    private final double price;

    public BasicItem(double price, String description) {
        this.price = price;
        this.setDescription(description);
    }

    @Override
    public double getPrice() {
        return price;
    }
}