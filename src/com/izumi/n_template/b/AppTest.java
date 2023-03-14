package com.izumi.n_template.b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用模板方法模式，解决a包中的问题
 *      不变的部分写成模板，变的部分写成抽象方法，让用户自己实现
 */

abstract class Template {
    public void template() {
        System.out.println("--start--");
        long start = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();
        System.out.println("end: "+(end - start));
    }

    public abstract void code();
}

// =======================================================

class A extends Template {
    @Override
    public void code() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(0, 1);
        }
    }
}

public class AppTest {
    public static void main(String[] args) {
        A a = new A();
        a.template();
    }
}


