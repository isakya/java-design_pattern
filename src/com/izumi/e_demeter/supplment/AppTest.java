package com.izumi.e_demeter.supplment;

import java.util.Date;
import java.util.List;

class Foo {
    public Bar get() {
        return new Bar();
    }
}
class Bar {

}

public class AppTest {
    private List list;

    public String f1(Integer i) {
        Date d = new Date();
        String s = new String();

        return s;
    }

    public void f2() {
        List<String> list; // StringҲ������
        Foo f = new Foo();
        Bar bar = f.get(); // ��������

        // �����������ת��Ϊ���ѣ�
        f3(bar); // ��Ϊ������������һ���������Ϳ���ת��Ϊ����
    }

    public void f3(Bar bar) {

    }
}
