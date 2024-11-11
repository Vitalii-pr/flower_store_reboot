package org.example.flowerstore_continue.delivery;

import org.example.flowerstore_continue.flowerStore.Item;

import java.util.List;

public class DHLDeliveryStrategy implements Delivery{
    @Override
    public String deliver(List<Item> items) {
        return "DHL delivery " + items;
    }
}
