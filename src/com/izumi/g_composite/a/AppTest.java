package com.izumi.g_composite.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// 需求：制作一个集合，要求该集合能记录曾经加过多少个元素。（不是统计某一时刻集合中有多少个元素）
class MySet extends HashSet {
    private int count = 0;
    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
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

        System.out.println(set.getCount());
    }
}

// 问题：在执行了addAll之后，count不是3，而是6，因为addAll回调了add方法
// 所以这样的代码没有解决需求