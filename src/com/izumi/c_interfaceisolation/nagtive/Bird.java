package com.izumi.c_interfaceisolation.nagtive;

public class Bird implements Animal{
    @Override
    public void eat() {
        System.out.println("�Գ���");
    }

    @Override
    public void swim() {
        throw new RuntimeException("You can you up");
    }

    @Override
    public void fly() {
        System.out.println("�ɰ���");
    }
}
