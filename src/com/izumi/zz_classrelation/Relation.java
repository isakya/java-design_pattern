package com.izumi.zz_classrelation;

public class Relation {
    /**

        // 继承关系
        class A {}

        class B extends A{}

     */

    /**

        // 关联关系: B关联A
        // 关联：一个类的对象作为另外一个类的全局变量
        class A {}

        class B {
            // 作为字段：关联
            A a = new A();

        }

     */

    /**

         // 依赖关系: B依赖于A
         // 依赖：一个类的对象作为另外一个类的局部变量
         class A {}

         class B {
             // 作为方法的局部变量或形参：依赖
             void f1(A a) {

             }
         }

     */

}
