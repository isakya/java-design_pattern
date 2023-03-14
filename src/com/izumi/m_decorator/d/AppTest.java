package com.izumi.m_decorator.d;

/**
 *
 *  针对c包的问题，现引入 “装饰器设计模式” 来解决问题
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


/**
 * 制作4种咖啡
 */
class Decaf extends Beverage {
    public Decaf() {
        super("无咖啡因咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 1;
    }
}

class Espresso extends Beverage {
    public Espresso() {
        super("浓缩咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 2;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        super("焦炒咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 1.5;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        super("混合咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 3;
    }
}




/***
 *  判断两个类之间能不能有继承关系，主要看这两个类之间有没有 “is a” 关系。并且还要符合里氏替换原则原则！
 *
 *  以上是原则，理念性的东西，不是语法强制要遵循的规范，所以在特定情况下，可以违反这个原则
 *
 *  所以尽管调料不是饮料，但是为了制作出装饰器模式，我们也只能让调料去继承饮料！
 *
 */

/**
 * 调料类
 */
abstract class Condiment extends Beverage{

    // 让调料类，关联饮料类
    protected Beverage beverage;

    public Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }
}

class Milk extends Condiment {
    public Milk(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + " 牛奶";
    }
}

class Soy extends Condiment {
    public Soy(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.3;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + " 豆浆";
    }
}

class Mocha extends Condiment {
    public Mocha(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.4;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + " 摩卡";
    }
}

class Bubble extends Condiment {
    public Bubble(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.1;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + " 泡沫";
    }
}


// ===================================================

public class AppTest {
    public static void main(String[] args) {

        Beverage b = new DarkRoast();

        Milk m = new Milk(b);
        Mocha mc = new Mocha(m);
        Soy dj = new Soy(mc);
        Soy dj2 = new Soy(dj);

        System.out.println(dj2.getDescription() + ": " + dj2.cost());
    }
}

/**
 *  优点：
 *      1、加新饮料，不会违反开闭原则
 *      2、加新调料，也不会违反开闭原则
 *
 *  缺点：
 *      1、声明的装饰类有些多
 *
 */
