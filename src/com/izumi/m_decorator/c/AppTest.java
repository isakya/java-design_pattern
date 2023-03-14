package com.izumi.m_decorator.c;

/**
 *
 *  针对于b包的问题，我们不必为每一种咖啡加每一种调料都创建一个类，这种做法过于愚蠢
 *
 *  现解决方案：可以直接在父类Beverage中，添加4个boolean属性，分别代表是否加了4种调料
 */
abstract class Beverage {
    private String description;

    // 解决方案
    private boolean milk,soy,mocha,bubble;

    public Beverage(String description) {
        this.description = description;
    }

    public double cost() {
        double total = 0;

        if(milk) {
            total += 0.2;
        }
        if(soy) {
            total += 0.3;
        }
        if(mocha) {
            total += 0.4;
        }
        if(bubble) {
            total += 0.1;
        }

        return total;
    }

    public String getDescription() {

        String str = description;

        if(milk) {
            str = str + " 牛奶";
        }
        if(soy) {
            str = str + " 豆浆";
        }
        if(mocha) {
            str = str + " 摩卡";
        }
        if(bubble) {
            str = str + " 泡沫";
        }
        return str;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean isBubble() {
        return bubble;
    }

    public void setBubble(boolean bubble) {
        this.bubble = bubble;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        super("无咖啡因咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 1 + super.cost();
    }
}

class Espresso extends Beverage {
    public Espresso() {
        super("浓缩咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 2 + super.cost();
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        super("焦炒咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 1.5 + super.cost();
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        super("混合咖啡");
    }
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 3 + super.cost();
    }
}

// ===================================================

class Tea extends Beverage {
    public Tea() {
        super("茶");
    }

    public double cost() {
        return 2 + super.cost();
    }
}

public class AppTest {
    public static void main(String[] args) {

        Beverage b = new Tea();

        b.setMilk(true);
        b.setSoy(true);

        System.out.println(b.getDescription() + ": " + b.cost());
    }
}

/**
 *
 * 优点：
 *  1、类没有爆炸，没有出现各种各样的类！
 *  2、如果增加新饮料不会带来什么影响
 *
 * 缺点：怕变化
 *  1、如果再加一样调料：如枸杞，则要修改源码
 *
 */
