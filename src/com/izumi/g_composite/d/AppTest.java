package com.izumi.g_composite.d;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// 需求：制作一个集合，要求该集合能记录曾经加过多少个元素。（不是统计某一时刻集合中有多少个元素）

// 针对于 c 包的问题，修改代码如下：
// 1. 我们不再重写add和addAll方法了
// 2. 额外制作2个代替add和addAll的方法：add2 addAll2 还要在类的API文档中说明，每当使用add和addAll的时候，都去调用add2和addAll2
class MySet extends HashSet {
    private int count = 0;
    public boolean add2(Object o) {
        count++;
        return super.add(o);
    }

    public boolean addAll2(Collection c) {
        boolean bb = false;
        for(Object obj : c) {
            if(add2(c)) {
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

        set.addAll2(set2);
        set.add2("独孤九剑");

        System.out.println(set.getCount());
    }
}

/**
 * 此时代码已经几乎满足需求了，但还是有问题：
 *        问题是：
 *              1. 目前这种情况对用户要求有点过分，用户必须看类的api文档，看完了还要乖乖地按文档要求来使用
 *              2. 更致命的是，如果新版本的jdk中，HashSet恰好多了个方法，就叫做add2和addAll2，那就又回到a问题了
 *
 */