package com.izumi.f_liskvo.negtive;

/***
 * 继承的作用：
 *  1. 提高代码重用性
 *  2. 多态的前提
 *
 *  两个类能不能发生继承关系的依据是什么？
 *      答：a. 有没有“is a”关系
 *          b. 在两个类有了 is a 关系之后，还要考虑子类对象在替换了父类对象之后，业务逻辑是否变化！如果变化，则不能发生继承关系
 *
 * 正方形和长方形有“is a”关系，但我们能不能让正方形类就去继承长方形类，
 * 因为还要考虑业务场景，在特定的业务场景下，正方形是否能替换长方形，且替换长方形以后，业务逻辑是否变化
 *
 */

class Utils {
    public static void transform(Rectangle r) {
        while (r.getWidth() <= r.getLength()) {
            r.setWidth(r.getWidth() + 1);
            System.out.println(r.getWidth() + ":" + r.getLength());
        }
    }
}

// 长方形类
class Rectangle {
    private double length;
    private double width;


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
// 反例：正方形继承了长方形
class Square extends Rectangle {
    private  double sidelength;

    @Override
    public double getLength() {
        return sidelength;
    }

    @Override
    public void setLength(double length) {
        this.sidelength = length;
    }

    @Override
    public double getWidth() {
        return sidelength;
    }

    @Override
    public void setWidth(double width) {
        this.sidelength = width;
    }
}

public class AppTest {
    public static void main(String[] args) {
        Rectangle r = new Square();
        r.setWidth(12);
        r.setLength(20);
        // 业务效果变了
        Utils.transform(r); // 死循环
    }
}
