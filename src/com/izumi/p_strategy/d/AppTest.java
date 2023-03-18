package com.izumi.p_strategy.d;

/**
 * 针对c包中的问题，修改代码如下：
 *
 *  新思路：把飞行和叫的方法，从鸭子类中分离出来！（不等同于c包中的分离）
 *
 */

// 飞的行为
interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞···");
    }
}

class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("绑个火箭飞···");
    }
}

class FlyWithKick implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("被人踢飞···");
    }
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞···");
    }
}

// 叫的行为
interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("正经鸭子嘎嘎叫");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不正经鸭子吱吱叫");
    }
}

class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<静默的>>");
    }
}


// 公共鸭子
abstract class Duck {
    // protected 是为了让子类能够调用
    protected FlyBehavior fb;
    protected QuackBehavior qb;

    public void swim() {
        System.out.println("鸭子游泳...");
    }
    public abstract void display();

    public void performFly() {
        fb.fly();
    }
    public void performQuack() {
        qb.quack();
    }

    public FlyBehavior getFb() {
        return fb;
    }

    public void setFb(FlyBehavior fb) {
        this.fb = fb;
    }

    public QuackBehavior getQb() {
        return qb;
    }

    public void setQb(QuackBehavior qb) {
        this.qb = qb;
    }
}


// 野鸭
class MallardDuck extends Duck {

    public MallardDuck() {
        this.fb = new FlyWithWings();
        this.qb = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }
}

// 红头鸭
class RedHeadDuck extends Duck{
    public RedHeadDuck() {
        this.fb = new FlyWithWings();
        this.qb = new Quack();
    }
    @Override
    public void display() {
        System.out.println("红头鸭");
    }
}

// 橡皮鸭
class RubberDuck extends Duck{
    public RubberDuck() {
        this.fb = new FlyNoWay();
        this.qb = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}

// ================================================================

class FlyWithCat implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("机器猫带着鸭子飞···");
    }
}

public class AppTest {

    public static void main(String[] args) {
        RubberDuck d = new RubberDuck();
        d.swim();
        d.performFly();
        d.performQuack();

        // 运行时改变方法行为，使得橡皮鸭能飞，只是被踢飞
        d.setFb(new FlyWithKick());
    }
}

/**
 *  此时，针对于48种鸭子，有12种方法而言，每种飞行方法，只写1次！
 *
 *  以上解决方案就是策略模式！
 */

