package com.izumi.c_interfaceisolation.positive;

public class Bird implements Eatable, Flyable{
    @Override
    public void eat() {
        System.out.println("�Գ���");
    }

    @Override
    public void fly() {
        System.out.println("�ɰ���");
    }
}
