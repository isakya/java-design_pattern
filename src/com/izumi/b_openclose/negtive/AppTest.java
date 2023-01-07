package com.izumi.b_openclose.negtive;



public class AppTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("奔驰");
        car.setColor("黑色");
        car.setLouyou(true);
        car.setPrice(666666);
        System.out.println(car.toString());
    }
}

// 变化：现在所有汽车，需要打八折
// 违反开闭原则的做法就是，直接打开Car的源代码，在getPrice方法上修改