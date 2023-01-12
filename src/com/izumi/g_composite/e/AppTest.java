package com.izumi.g_composite.e;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// ��������һ�����ϣ�Ҫ��ü����ܼ�¼�����ӹ����ٸ�Ԫ�ء�������ͳ��ĳһʱ�̼������ж��ٸ�Ԫ�أ�

// ����� d �������⣬�޸Ĵ������£�
// 1. MySet��Ҳ��Ҫȥ�̳�HashSet
// 2. ȡ����֮����MySet��HashSet����������ϵ����Ϲ�ϵ��
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
        set2.add("��������");
        set2.add("��ڤ��");
        set2.add("Ǭ����Ų��");

        set.addAll(set2);
        set.add("���¾Ž�");

        System.out.println(set.getCount());
    }
}

/**
 * ��ʱ�����Ѿ��������������
 *
 *      �����ǣ�
 *          1. �ѵ��Ժ󶼲���ʹ�ü̳�����
 *          2. �ѵ��Ժ󶼲��ܽ��з�����д����
 *
 *      �̳�ԭ������������� �� �������� ����ͬһ���ˣ��ͱ�̳�
 */