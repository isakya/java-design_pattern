package com.izumi.h_simplefactory.a;

// �����Ʒ
interface Food {
    void eat();
}

// �����Ʒ
class Hamburger implements Food {

    @Override
    public void eat() {
        System.out.println("�Ժ�������");
    }
}

// =================================

public class AppTest {
    public static void main(String[] args) {
        Food f = new Hamburger();
        f.eat();
    }
}

/***
 * ��������൱��������ΪֻҪ�����޸��˾����Ʒ����������ô�ͻ��˴���ҲҪ��֮һ��ı�
 * ��������Ϊ��˴��룬���Ϳͻ��˴��������ϵ�
 *
 * ϣ����Ч���ǣ����۷������˴�������޸ģ��ͻ��˴��붼Ӧ�ò�֪���������޸Ŀͻ��˴��룡
 */