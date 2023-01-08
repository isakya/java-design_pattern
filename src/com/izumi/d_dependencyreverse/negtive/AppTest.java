package com.izumi.d_dependencyreverse.negtive;


class Person {
    public void feed(Dog dog) {
        System.out.println("开始喂养。。。");
        dog.eat();
    }
    public void feed(Cat cat) {
        System.out.println("开始喂养。。。");
        cat.eat();
    }
}

class Dog {
    public void eat() {
        System.out.println("狗啃骨头");
    }
}



// ====================================

// 变化：客户端不仅仅需要喂狗，还需要喂猫！！
// 客服端自己定义一个猫类
class Cat {
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


// 以上代码违反了依赖倒置原则，因为每当下层变动时，上层都要跟着一起变动

// 当下层新增一个动物时，上层应该“不知道”，上层代码应该不用改动！