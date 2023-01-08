package com.izumi.d_dependencyreverse.negtive;


class Person {
    public void feed(Dog dog) {
        System.out.println("��ʼι��������");
        dog.eat();
    }
    public void feed(Cat cat) {
        System.out.println("��ʼι��������");
        cat.eat();
    }
}

class Dog {
    public void eat() {
        System.out.println("���й�ͷ");
    }
}



// ====================================

// �仯���ͻ��˲�������Ҫι��������Ҫιè����
// �ͷ����Լ�����һ��è��
class Cat {
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


// ���ϴ���Υ������������ԭ����Ϊÿ���²�䶯ʱ���ϲ㶼Ҫ����һ��䶯

// ���²�����һ������ʱ���ϲ�Ӧ�á���֪�������ϲ����Ӧ�ò��øĶ���