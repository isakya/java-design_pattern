package com.izumi.zz_classrelation;

public class Relation {
    /**

        // �̳й�ϵ
        class A {}

        class B extends A{}

     */

    /**

        // ������ϵ: B����A
        // ������һ����Ķ�����Ϊ����һ�����ȫ�ֱ���
        class A {}

        class B {
            // ��Ϊ�ֶΣ�����
            A a = new A();

        }

     */

    /**

         // ������ϵ: B������A
         // ������һ����Ķ�����Ϊ����һ����ľֲ�����
         class A {}

         class B {
             // ��Ϊ�����ľֲ��������βΣ�����
             void f1(A a) {

             }
         }

     */

}
