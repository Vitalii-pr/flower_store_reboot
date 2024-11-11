package org.example.flowerstore_continue.delivery;

import org.example.flowerstore_continue.flowerStore.Item;

import java.util.List;

public interface Delivery {
    String deliver(List<Item> items);
}
