package org.example.flowerstore_continue;

import org.example.flowerstore_continue.flowerStore.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;
    private Flower flowerSecond;
    private FlowerPack pack, packSecond;
    private FlowerBucket bucket;

    @BeforeEach
    public void init() {
        flower = new Flower();
        flowerSecond = new Flower();
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int priceSecond = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        flowerSecond.setPrice(priceSecond);
        Assertions.assertEquals(price, flower.getPrice());
        // print(pack.toString());

        pack = new FlowerPack(flower, RANDOM_GENERATOR.nextInt(MAX_PRICE));
        Assertions.assertEquals(price*pack.getQuantity(), pack.getPrice());

        packSecond = new FlowerPack(
                flowerSecond,
                RANDOM_GENERATOR.nextInt(MAX_PRICE));

        Assertions.assertEquals(
                priceSecond*packSecond.getQuantity(),
                packSecond.getPrice());

        bucket = new FlowerBucket(pack, packSecond);
        Assertions.assertEquals(
                bucket.getPrice(),
                packSecond.getPrice()+pack.getPrice());
    }

    @Test
    public void testBasicItemPrice() {
        Item item = new BasicItem(100, "Basic Item");
        assertEquals(100, item.getPrice(), 0.01);
    }

    @Test
    public void testRibbonDecorator() {
        Item item = new RibbonDecorator(new BasicItem(100, "Basic Item with Ribbon"));
        assertEquals(140, item.getPrice(), 0.01);
    }

    @Test
    public void testPaperDecorator() {
        Item item = new PaperDecorator(new BasicItem(100, "Basic Item with Paper"));
        assertEquals(113, item.getPrice(), 0.01);
    }

    @Test
    public void testBasketDecorator() {
        Item item = new BasketDecorator(new BasicItem(100, "Basic Item with Basket"));
        assertEquals(104, item.getPrice(), 0.01);
    }

    @Test
    public void testMultipleDecorators() {
        Item item = new RibbonDecorator(new PaperDecorator(new BasketDecorator(new BasicItem(100, "Decorated Item"))));
        assertEquals(157, item.getPrice(), 0.01);
    }
}
