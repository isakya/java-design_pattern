package com.izumi.d_dependencyreverse.positive;

interface Animal {
    void eat();
}

class Person {
    public void feed(Animal a) {
        System.out.println("��ʼι��������");
        a.eat();
    }
}

class Dog implements Animal{
    public void eat() {
        System.out.println("���й�ͷ");
    }
}



// ====================================

// �仯���ͻ��˲�������Ҫι��������Ҫιè����
// �ͷ����Լ�����һ��è��
class Cat implements Animal{
    public void eat() {
        System.out.println("è����");
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
