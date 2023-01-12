package com.izumi.g_composite.d;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// ��������һ�����ϣ�Ҫ��ü����ܼ�¼�����ӹ����ٸ�Ԫ�ء�������ͳ��ĳһʱ�̼������ж��ٸ�Ԫ�أ�

// ����� c �������⣬�޸Ĵ������£�
// 1. ���ǲ�����дadd��addAll������
// 2. ��������2������add��addAll�ķ�����add2 addAll2 ��Ҫ�����API�ĵ���˵����ÿ��ʹ��add��addAll��ʱ�򣬶�ȥ����add2��addAll2
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
        set2.add("��������");
        set2.add("��ڤ��");
        set2.add("Ǭ����Ų��");

        set.addAll2(set2);
        set.add2("���¾Ž�");

        System.out.println(set.getCount());
    }
}

/**
 * ��ʱ�����Ѿ��������������ˣ������������⣺
 *        �����ǣ�
 *              1. Ŀǰ����������û�Ҫ���е���֣��û����뿴���api�ĵ��������˻�Ҫ�ԹԵذ��ĵ�Ҫ����ʹ��
 *              2. ���������ǣ�����°汾��jdk�У�HashSetǡ�ö��˸��������ͽ���add2��addAll2���Ǿ��ֻص�a������
 *
 */