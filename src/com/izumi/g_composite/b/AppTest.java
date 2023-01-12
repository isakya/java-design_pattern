package com.izumi.g_composite.b;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// ��������һ�����ϣ�Ҫ��ü����ܼ�¼�����ӹ����ٸ�Ԫ�ء�������ͳ��ĳһʱ�̼������ж��ٸ�Ԫ�أ�

// �����a�������⣬addAll��ص�add�������޸Ĵ������£�
// 1. ��addAllɾ��������Ҫ��д����HashSet��addAll
// 2. �ø����addAll����ȥ�ص�add

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
        set2.add("��������");
        set2.add("��ڤ��");
        set2.add("Ǭ����Ų��");

        set.addAll(set2);
        set.add("���¾Ž�");

        System.out.println(set.getCount());
    }
}

/**
 * ��ʱ�����Ѿ��������󣬵����������⣺
 *      1. Ŀǰ������룬��������������һ����ʵ������HashSet��addAll��������ȥ�ص�add����
 *      2. ��һ������JDK�汾�У�HashSet��addAllʵ�ִ��룬ͻȻ���ٻص�add�����������MySet�ͻᱻ��������
 */