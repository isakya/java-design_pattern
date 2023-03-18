package com.izumi.p_strategy.c;

/**
 * 针对b包中的问题：开发人员需要判断每个鸭子叫和飞与否，就重写quack和fly方法。显然，这个工作量是巨大的！
 *
 *
 * 新思路：不会飞就没有fly方法，不会叫就没有quack方法
 *      方案：把这两个经常变化的方法，从父类中分出来，分成两个接口：Quackable, Flyable
 *
 *
 */

interface Quackable {
    void quack();
}

interface flyable {
    void fly();
}


// 公共鸭子
abstract class Duck {
    public void swim() {
        System.out.println("鸭子游泳...");
    }
    public abstract void display();
}


// 野鸭
class MallardDuck extends Duck implements Quackable,flyable{
    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }

    @Override
    public void quack() {
        System.out.println("正经鸭子叫");
    }

    @Override
    public void fly() {
        System.out.println("正经鸭子飞");
    }
}

// 红头鸭
class RedHeadDuck extends Duck implements Quackable,flyable{

    @Override
    public void display() {
        System.out.println("红头鸭");
    }

    @Override
    public void quack() {
        System.out.println("正经鸭子叫");
    }

    @Override
    public void fly() {
        System.out.println("正经鸭子飞");
    }
}

// 橡皮鸭
class RubberDuck extends Duck implements Quackable{
    @Override
    public void quack() {
        System.out.println("不正经鸭子：吱吱叫");
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}

public class AppTest {

    public static void main(String[] args) {
        RedHeadDuck d = new RedHeadDuck();
        d.fly();
        d.quack();
        d.swim();
    }
}

/***
 *  问题：
 *      修改之前：新增鸭子角色，开发人员就要判断这个鸭子飞和叫与否，来重写飞和叫的方法
 *      修改之后：新增鸭子角色，开发人员也要判断这个鸭子飞和叫与否，来实现飞和叫的接口
 *
 *  缺点：
 *      1、开发人员仍然没有减少工作量
 *      2、fly和quack没有重用性可言，需要fly和quack的鸭子都实现了一遍它们两的方法
 *
 *      不过缺点2可以用jdk_1.8的特性解决，接口方法的默认实现，如下：
 *                                     interface flyable {
 *                                          default void fly() {
 *                                              System.out.println("正经鸭子飞");
 *                                          }
 *                                      }
 *      但如果在48种鸭子中，有12种飞行方法，缺点2又重现
 *
 */

