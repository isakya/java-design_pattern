package com.izumi.c_interfaceisolation.nagtive;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("¹·³Ô·¹");
    }

    @Override
    public void swim() {
        System.out.println("¹·ÅÙ");
    }

    @Override
    public void fly() {
        throw new RuntimeException("ex? ÄãĞĞÄãÀ´·É");
    }
}
