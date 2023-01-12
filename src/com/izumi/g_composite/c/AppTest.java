package com.izumi.g_composite.c;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// 需求：制作一个集合，要求该集合能记录曾经加过多少个元素。（不是统计某一时刻集合中有多少个元素）

// 针对于 b 包的问题，MySet必须依赖于这样一个事实：addAll必须回调add，但是JDK未来的版本不会做这个保证！

// 修改代码如下：我们自己亲自重写addAll，这次重写addAll，不再让count累加c.size()了，而是保证addAll一定会调用add

class MySet extends HashSet {
    private int count = 0;
    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        boolean bb = false;
        for(Object obj : c) {
            if(add(c)) {
                bb = true;
            }
        }
        return bb;
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
 * 此时代码已经更满足需求了，但还是有问题：
 *      问题1：如果在新的jdk版本中，HashSet突然多了一个元素加入集合的入口方法：addSome，
 *           这个addSome使我们始料未及的，我们的MySet根本没有重写新版本中出现的addSome方法。
 *           这样，在新版本中，MySet也继承了addSome方法，当使用addSome方法添加元素时，根本不会去统计元素的数量。
 *
 *      问题2：我们重写了addAll方法，和add方法，在HashSet的所有方法中，难免会有一些其他方法会依赖于addAll方法和add方法。
 *            然而当重写了别人类中的某些方法，就会导致其他以利于这些方法的方法出现问题！
 *
 */