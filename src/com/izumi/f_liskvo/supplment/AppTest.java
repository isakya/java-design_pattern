package com.izumi.f_liskvo.supplment;

/***
 * ������д�� ������͸����У������˷���������ͬ����������ͬ������������ͬ�ķ���ʱ�����ɷ�����д
 * ������д���������ƣ�
 *      1. ������д����ķ���ʱ�����෽���ķ������η����ܱȸ���ĸ��ϸ�
 *      2. ������д����ķ���ʱ�����෽�������׳��ȸ��������쳣
 * ΪʲôҪ�������������ƣ�����Ϊ�˱�֤������������滻���������﷨���ᱨ��(����Ϊ�˷��������滻ԭ��)
 */

class Fu {
    public void f1() {

    }
}

class Zi extends Fu {
    public void f1() {

    }
}


public class AppTest {
    public static void main(String[] args) {
        Fu fu = new Zi();
        fu.f1();
    }
}
