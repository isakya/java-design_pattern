package com.izumi.i_factorymethod;


/***
 * 工厂方法代码如下：
 */

// 抽象产品
interface Food {
    void eat();
}

// 具体产品
class Hamburger implements Food {

    @Override
    public void eat() {
        System.out.println("吃汉堡包！");
    }
}

class RiceNoodle implements Food {
    @Override
    public void eat() {
        System.out.println("过桥米线");
    }
}

interface FoodFactory {
    Food getFood();
}

class HamburgerFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Hamburger();
    }
}

class RiceNoodleFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new RiceNoodle();
    }
}

class Business {
    public static void taste(FoodFactory ff) {
        Food f = ff.getFood();
        System.out.println("评委1，品尝");
        f.eat();
        System.out.println("评委2，品尝");
        f.eat();
        System.out.println("评委3，品尝");
        f.eat();
    }
}

// 作者 ↑
// =================================
// 用户 ↓

class Lp implements Food {
    @Override
    public void eat() {
        System.out.println("凉皮");
    }
}

class LpFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Lp();
    }
}


public class AppTest {
    public static void main(String[] args) {
        FoodFactory ff = new HamburgerFactory();
        Food food1 = ff.getFood();

        FoodFactory lp = new LpFactory();
        Food food2 = ff.getFood();

        Business.taste(ff);
        // 解释了自己是作者为什么不直接实例化类，还要实现工厂的原因
        Business.taste(lp);

    }
}

/***
 * 工厂方法
 *      优点:
 *          1. 仍然具有简单工厂的优点：服务器端修改了具体产品的类名以后，客户端不知道。
 *          2. 当客户端需要扩展一个新的产品时，不需要修改作者原来的代码，只是扩展一个新的工厂而已
 *
 *      杠点：
 *          1. 简单工厂、工厂方法，都有一个优点，就是服务器端的具体产品类名变化了以后，客户端不知道！
 *             但是，客户端仍然依赖于具体的工厂类名，此时，如果服务器端修改了具体工厂的类名，那么客户端也要随之一起修改！
 *             仿佛折腾了一圈又回到了原点！！！解释如下：
 *
 *             解释：
 *                  作为工厂的名字，是视为接口的。作者有责任，有义务保证工厂的名字是稳定的。
 *                  也就是说：虽然客户端依赖于工厂的具体类名，在行内所有工厂的名字都是趋向于稳定，
 *                  至少工厂类的名字，要比具体产品类的名字更加稳定！
 *
 *           2. 既然产品是我们自己客户端扩展出来的，那么为什么不直接实例化呢？毕竟这个扩展出来的Lp这个产品，我们自己就是作者。
 *              我们自己是作者的话，想怎么改类名都可以自己把控，为什么还要为自己制作的产品做工厂呢？
 *
 *              解释：
 *                  因为，作者在开发功能时，不仅仅只会开发一些抽象产品、具体产品、对应的工厂，还会配套地搭配一些提前做好的框架。
 *
 *
 *            3. 现在制作出LpFactory，是为了能把LpFactory传入给Business.taste方法，所以，必须定义LpFactory。
 *               杠：为什么不从一开始就让Business.taste方法就直接接收Food参数呢？而不是现在的FoodFactory作为参数。
 *
 *
 *       缺点：
 *          如果有多个产品等级，那么工厂类的数量，就会爆炸式增长
 *
 */




