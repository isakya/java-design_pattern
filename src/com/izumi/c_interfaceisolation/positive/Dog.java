package com.izumi.c_interfaceisolation.positive;

public class Dog implements Eatable, Swimable{

    @Override
    public void eat() {
        System.out.println("���Է�");
    }

    @Override
    public void swim() {
        System.out.println("����");
    }
}
