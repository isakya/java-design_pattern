package com.izumi.c_interfaceisolation.nagtive;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("���Է�");
    }

    @Override
    public void swim() {
        System.out.println("����");
    }

    @Override
    public void fly() {
        throw new RuntimeException("ex? ����������");
    }
}
