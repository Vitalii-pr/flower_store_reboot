package org.example.flowerstore_continue.delivery;

import org.example.flowerstore_continue.flowerStore.Item;

import java.util.List;

public class PostDeliveryStrategy implements Delivery{
    @Override
    public String deliver(List<Item> items) {
        return "Post delivery " + items;
    }
}
