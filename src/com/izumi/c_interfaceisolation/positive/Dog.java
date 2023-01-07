package com.izumi.c_interfaceisolation.positive;

public class Dog implements Eatable, Swimable{

    @Override
    public void eat() {
        System.out.println("π∑≥‘∑π");
    }

    @Override
    public void swim() {
        System.out.println("π∑≈Ÿ");
    }
}
