package com.izumi.p_strategy.a;

/***
 * 鸭子游戏：角色都是鸭子，但不同鸭子之间又有共性
 *
 * 开发人员：为了代码的重用性，就制作一个鸭子类Duck把共性提高到父类当中
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

public class AppTest {

    public static void main(String[] args) {
        RedHeadDuck d = new RedHeadDuck();
        d.quack();
        d.swim();
        d.display();
    }
}
