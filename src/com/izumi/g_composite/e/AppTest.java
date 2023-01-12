package com.izumi.g_composite.e;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// 需求：制作一个集合，要求该集合能记录曾经加过多少个元素。（不是统计某一时刻集合中有多少个元素）

// 针对于 d 包的问题，修改代码如下：
// 1. MySet再也不要去继承HashSet
// 2. 取而代之，让MySet和HashSet发生关联关系（组合关系）
class MySet {
    private Set set = new HashSet();
    private int count = 0;

    public boolean add(Object o) {
        count++;
        return set.add(o);
    }

    public boolean addAll(Collection c) {
        count += c.size();
        return set.addAll(c);
    }

    public int getCount() {
        return count;
    }
}

public class AppTest {
    public static void main(String[] args) {
        MySet set = new MySet();

        Set set2 = new HashSet();
        set2.add("葵花宝典");
        set2.add("北冥神功");
        set2.add("乾坤大挪移");

        set.addAll(set2);
        set.add("独孤九剑");

        System.out.println(set.getCount());
    }
}

/**
 * 此时代码已经完美解决需求了
 *
 *      问题是：
 *          1. 难道以后都不能使用继承了吗？
 *          2. 难道以后都不能进行方法重写了吗？
 *
 *      继承原则：如果父类作者 和 子类作者 不是同一个人，就别继承
 */