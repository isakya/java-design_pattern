package com.izumi.p_strategy.b;

/**
 * 游戏版本更新：需要把游戏中的鸭子加上一个飞的功能
 *
 * 开发人员解决方案：在父类加上一个fly方法以让鸭子实现飞的功能
 *
 * 方案问题：在父类加上fly方法，导致所有的鸭子都具有了飞的功能，但实际上有特殊的鸭子不能飞，比如橡皮鸭子，也就是父类的方法，并不是所有子类都能通用的！！
 *
 */

// 公共鸭子
abstract class Duck {
    public void quack() {
        System.out.println("鸭子叫");
    }
    public void swim() {
        System.out.println("鸭子游泳...");
    }
    public abstract void display();

    public void fly() {
        System.out.println("鸭子飞");
    }
}


// 野鸭
class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }
}

// 红头鸭
class RedHeadDuck extends Duck {
    @Override
    public void display() {
        System.out.println("红头鸭");
    }
}

// 橡皮鸭
class RubberDuck extends Duck {
    // 橡皮鸭不是正经鸭子，所以需要重写父类 的 鸭子叫方法(quack)
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }

    // 橡皮鸭子不会飞，却又继承了父类中飞的方法，所有可以像重写quack那样，重写flay
    @Override
    public void fly() {
        System.out.println("橡皮鸭子不能飞");
    }
}

public class AppTest {

    public static void main(String[] args) {
        RedHeadDuck d = new RedHeadDuck();
        d.quack();
        d.swim();
        d.fly();
        d.display();
    }
}

/***
 * 以上程序问题：如果连续不断的增加各种不能飞的鸭子，也就需要连续不断的重写飞的方法，这就仿佛从一个噩梦跳入另一个噩梦
 */