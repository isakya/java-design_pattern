package com.izumi.g_composite.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// ��������һ�����ϣ�Ҫ��ü����ܼ�¼�����ӹ����ٸ�Ԫ�ء�������ͳ��ĳһʱ�̼������ж��ٸ�Ԫ�أ�
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
        set2.add("��������");
        set2.add("��ڤ��");
        set2.add("Ǭ����Ų��");

        set.addAll(set2);

        System.out.println(set.getCount());
    }
}

// ���⣺��ִ����addAll֮��count����3������6����ΪaddAll�ص���add����
// ���������Ĵ���û�н������