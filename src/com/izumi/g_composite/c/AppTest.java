package com.izumi.g_composite.c;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// ��������һ�����ϣ�Ҫ��ü����ܼ�¼�����ӹ����ٸ�Ԫ�ء�������ͳ��ĳһʱ�̼������ж��ٸ�Ԫ�أ�

// ����� b �������⣬MySet��������������һ����ʵ��addAll����ص�add������JDKδ���İ汾�����������֤��

// �޸Ĵ������£������Լ�������дaddAll�������дaddAll��������count�ۼ�c.size()�ˣ����Ǳ�֤addAllһ�������add

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
        set2.add("��������");
        set2.add("��ڤ��");
        set2.add("Ǭ����Ų��");

        set.addAll(set2);
        set.add("���¾Ž�");

        System.out.println(set.getCount());
    }
}

/**
 * ��ʱ�����Ѿ������������ˣ������������⣺
 *      ����1��������µ�jdk�汾�У�HashSetͻȻ����һ��Ԫ�ؼ��뼯�ϵ���ڷ�����addSome��
 *           ���addSomeʹ����ʼ��δ���ģ����ǵ�MySet����û����д�°汾�г��ֵ�addSome������
 *           ���������°汾�У�MySetҲ�̳���addSome��������ʹ��addSome�������Ԫ��ʱ����������ȥͳ��Ԫ�ص�������
 *
 *      ����2��������д��addAll��������add��������HashSet�����з����У��������һЩ����������������addAll������add������
 *            Ȼ������д�˱������е�ĳЩ�������ͻᵼ��������������Щ�����ķ����������⣡
 *
 */