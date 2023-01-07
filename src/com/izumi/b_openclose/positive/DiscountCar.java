package com.izumi.b_openclose.positive;

public class DiscountCar extends Car{
    @Override
    public double getPrice() {
        return super.getPrice() * 0.8;
    }
}
