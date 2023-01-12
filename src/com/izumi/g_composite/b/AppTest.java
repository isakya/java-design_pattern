package com.izumi.g_composite.b;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// 需求：制作一个集合，要求该集合能记录曾经加过多少个元素。（不是统计某一时刻集合中有多少个元素）

// 针对于a包的问题，addAll会回调add方法，修改代码如下：
// 1. 把addAll删除掉，不要重写父类HashSet的addAll
// 2. 让父类的addAll本身去回调add

class MySet extends HashSet {
    private int count = 0;
    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
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
 * 此时代码已经满足需求，但还是有问题：
 *      1. 目前这个代码，必须依赖于这样一个事实，就是HashSet的addAll方法必须去回调add方法
 *      2. 万一将来的JDK版本中，HashSet的addAll实现代码，突然不再回调add方法，那这个MySet就会被“撼动”
 */