package com.izumi.c_interfaceisolation.nagtive;

public class Bird implements Animal{
    @Override
    public void eat() {
        System.out.println("³Ô³æ×Ó");
    }

    @Override
    public void swim() {
        throw new RuntimeException("You can you up");
    }

    @Override
    public void fly() {
        System.out.println("·É°¡·É");
    }
}
