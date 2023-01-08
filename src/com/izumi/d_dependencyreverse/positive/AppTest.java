package com.izumi.d_dependencyreverse.positive;

interface Animal {
    void eat();
}

class Person {
    public void feed(Animal a) {
        System.out.println("开始喂养。。。");
        a.eat();
    }
}

class Dog implements Animal{
    public void eat() {
        System.out.println("狗啃骨头");
    }
}



// ====================================

// 变化：客户端不仅仅需要喂狗，还需要喂猫！！
// 客服端自己定义一个猫类
class Cat implements Animal{
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Person p = new Person();
        Dog d = new Dog();
        Cat c = new Cat();

        p.feed(d);
        p.feed(c);
    }
}
