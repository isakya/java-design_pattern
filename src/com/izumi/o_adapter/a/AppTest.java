package com.izumi.o_adapter.a;

/**
 * 适配器：
 *      一个类的接口转换成客户希望的另一个接口。适配器模式让那些接口不兼容的类可以一起工作
 *
 * 通俗解释：
 *      根据已有的接口，生成想要的接口
 */

class Calc {
    public int add(int a, int b) {
        return a + b;
    }
}

//=======================================

// 变化：客户端希望计算3个数的和，而Calc的add方法只能接受2个参数！

class CalcAdapter {
    private Calc calc;

    public CalcAdapter(Calc c) {
        calc = c;
    }

    public int add(int a, int b, int c) {
        return calc.add(a, calc.add(b, c));
    }
}


public class AppTest {
    public static void main(String[] args) {
        Calc c = new Calc();
        CalcAdapter calcAdapter = new CalcAdapter(c);
        int r = calcAdapter.add(1, 2,3);
        System.out.println(r);
    }
}
