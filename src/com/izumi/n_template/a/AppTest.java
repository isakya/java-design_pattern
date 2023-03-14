package com.izumi.n_template.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试ArrayList和LinkedList的添加加效率，查询效率
 */
public class AppTest {
    public static void main(String[] args) {
        System.out.println("--start--");
        long start = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        // List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(0,1);
        }

        long end = System.currentTimeMillis();

        System.out.println("end: "+(end - start));
    }
}

/**
 * 问题：
 * 此时，每次测试的代码发生变化时，都势必要修改原有代码，如果修改之后，又需要测试之前的代码，那么又要把之前的代码写回来！
 */
