package com.izumi.j_abstractfactory;

/***
 * 针对工厂方法的问题：当有多个产品等级时（食物、饮料、甜品...），工厂类就会很多！
 * 修改代码如下：使用抽象工厂模式
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


interface Drink {
    void drink();
}

class Cola implements Drink {
    public void drink() {
        System.out.println("可口可乐，你指的拥有！");
    }
}

class IcePeak implements Drink {
    @Override
    public void drink() {
        System.out.println("冰峰饮料，从小就喝它！");
    }
}


interface Factory {
    Food getFood();
    Drink getDrink();
}

class KFCFactory implements Factory {
    @Override
    public Food getFood() {
        return new Hamburger();
    }
    @Override
    public Drink getDrink() {
        return new Cola();
    }
}

class SanQinFactory implements Factory {
    @Override
    public Food getFood() {
        return new RiceNoodle();
    }
    @Override
    public Drink getDrink() {
        return new IcePeak();
    }
}


class Business {
    public static void taste(Factory ff) {
        Food f = ff.getFood();
        Drink d = ff.getDrink();
        System.out.println("评委1，品尝");
        f.eat();
        d.drink();

        Food f1 = ff.getFood();
        Drink d1 = ff.getDrink();
        System.out.println("评委2，品尝");
        f1.eat();
        d1.drink();

        Food f2 = ff.getFood();
        Drink d2 = ff.getDrink();
        System.out.println("评委3，品尝");
        f2.eat();
        d2.drink();

    }
}


// 作者 ↑
// =================================
// 用户 ↓

// 用户扩展
class Lp implements Food {
    @Override
    public void eat() {
        System.out.println("宝鸡擀面皮");
    }
}

class Fanta implements Drink {
    @Override
    public void drink() {
        System.out.println("芬达，你值得拥有");
    }
}

class BaoJiFactory implements Factory {
    @Override
    public Drink getDrink() {
        return new Fanta();
    }

    @Override
    public Food getFood() {
        return new Lp();
    }
}

public class AppTest {
    public static void main(String[] args) {
        Business.taste(new KFCFactory());
        Business.taste(new BaoJiFactory());
    }
}



/***
 *  抽象工厂：
 *      优点：
 *          1. 任然有简单工厂和工厂方法的优点
 *          2. 更重要的是，抽象工厂把工厂类的数量减少了！无论有多少个产品等级，工厂就一套
 *
 *          杠点：
 *              1. 为什么三秦工厂中，就必须是米线搭配冰峰呢？
 *                 为什么就不能是米线搭配可乐？
 *
 *              解释：
 *                  抽象工厂中，可以生产多个产品，这多个产品之间，必须有内在联系。
 *                  同一个工厂中的产品都属于同一个产品簇！！不能把不同产品簇中的产品混合到一个抽象工厂的实现类中。
 *
 *       缺点：
 *          1. 当产品等级发生变化时（增加产品等级 或 删除产品等级），都要引起所有以前工厂代码的修改，这就违反了“开闭原则“
 *
 *       结论：
 *          如果产品等级比较固定时，可以考虑使用抽象工厂，
 *          如果产品等级经常变化，则不建议使用抽象工厂
 *
 */




