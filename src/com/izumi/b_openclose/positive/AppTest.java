package com.izumi.b_openclose.positive;


public class AppTest {
    public static void main(String[] args) {
        Car car = new DiscountCar();
        car.setBrand("奔驰");
        car.setColor("黑色");
        car.setLouyou(true);
        car.setPrice(666666);
        System.out.println(car.getPrice());
    }
}

// 变化：现在所有汽车，需要打八折
// 符合开闭原则的做法就是：始终保证Car的源代码不会被修改
// 做法：创建一个Car的子类重写Car的getPrice方法