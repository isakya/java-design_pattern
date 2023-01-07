package com.izumi.c_interfaceisolation.positive;

public class Bird implements Eatable, Flyable{
    @Override
    public void eat() {
        System.out.println("³Ô³æ×Ó");
    }

    @Override
    public void fly() {
        System.out.println("·É°¡·É");
    }
}
