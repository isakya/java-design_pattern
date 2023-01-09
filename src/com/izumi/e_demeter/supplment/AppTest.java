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
        List<String> list; // String也是朋友
        Foo f = new Foo();
        Bar bar = f.get(); // 不是朋友

        // 不是朋友如何转换为朋友？
        f3(bar); // 变为参数传入另外一个方法，就可以转换为朋友
    }

    public void f3(Bar bar) {

    }
}
