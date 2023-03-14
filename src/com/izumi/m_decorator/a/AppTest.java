package com.izumi.m_decorator.a;

/**
 * 业务场景：星巴克卖咖啡，一开始只有4种咖啡：
 *  1、Decaf 2、Espresso 3、DrakRoast 4、HouseBlend
 *
 *  因为所有咖啡都有共性，所以开发人员，把他们的共性都提取到一个父类中：Beverage
 *
 *
 */
abstract class Beverage {
    private String description;
    public Beverage(String description) {
        this.description = description;
    }
    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        super("无咖啡因咖啡");
    }
    public double cost() {
        return 1;
    }
}

class Espresso extends Beverage {
    public Espresso() {
        super("浓缩咖啡");
    }
    public double cost() {
        return 2;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        super("焦炒咖啡");
    }
    public double cost() {
        return 1.5;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        super("混合咖啡");
    }
    public double cost() {
        return 3;
    }
}

// ===================================================
public class AppTest {
    public static void main(String[] args) {

        Beverage b = new Decaf();
        Beverage b2 = new Espresso();
        Beverage b3 = new DarkRoast();
        Beverage b4 = new HouseBlend();

        System.out.println(b.getDescription() + ": " + b.cost());
        System.out.println(b2.getDescription() + ": " + b2.cost());
        System.out.println(b3.getDescription() + ": " + b3.cost());
        System.out.println(b4.getDescription() + ": " + b4.cost());
    }
}

/**
 * 如果需求不发生变化，以上代码没有问题。
 *
 *
 *
 * 如今变化来了：
 *  新业务场景：调料
 *      可以给咖啡中放调料：如：牛奶、豆浆、摩卡、泡沫（只是为了好玩）
 *
 *  现如何设计，以应对这种变化？看b包
 */
