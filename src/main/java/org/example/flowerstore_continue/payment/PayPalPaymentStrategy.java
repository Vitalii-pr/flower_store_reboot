package org.example.flowerstore_continue.payment;

public class PayPalPaymentStrategy implements Payment{

    @Override
    public String toPay(float price){
        return price + " to pay via PayPal";
    }


}
