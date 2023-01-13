package com.izumi.h_simplefactory.b;

/***
 * �����a�������⣺����������һ���޸ģ��ͻ��˴���ҲҪ�����޸ģ�
 * �޸Ĵ������£�ʹ�ü򵥹������ģʽ
 */

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

class RiceNoodle implements Food {
    @Override
    public void eat() {
        System.out.println("��������");
    }
}

class FoodFactory {
    public static Food getFood(int n) {
        Food food = null;
        switch (n) {
            case 1:
                food = new Hamburger();
                break;

            case 2:
                food = new RiceNoodle();
                break;
        }
        return food;
    }
}

// ���� ��
// =================================
// �û� ��

// �û���չ�����Ʒ�Ĵ��루���⣺������ӵ�������ȥ����Ϊ�����Ĵ����Ǳ���д�ģ���
class Lp implements Food {
    @Override
    public void eat() {
        System.out.println("��Ƥ");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Food f = FoodFactory.getFood(1);
        f.eat();
    }
}

/***
 *  �ŵ�
 *  1. �Ѿ����Ʒ�����ͣ��ӿͻ��˴����У����������
 *  2. �������ˣ�����޸��� �����Ʒ���������ͻ���Ҳ֪����
 *  ��߷����ˡ�����ӿڱ�̡���˼��
 *
 *  ȱ�㣺
 *  1. �ͻ��˲��ò�����Ӳ����Щ����������Ʒ��ӳ���ϵ�����磺1. ��Ӧ�������� 2. ��Ӧ����
 *  2. ��������Ʒ�ر�࣬��򵥹������ͻ���ʮ��ӷ�ס�������100�������Ʒ������Ҫ�ڼ򵥹�����switch��д��100��case
 *  3. ����Ҫ���ǣ��仯���ˣ��ͻ�����Ҫ��չ�����Ʒ��ʱ���Ʊ�Ҫ�޸ļ򵥹����еĴ��룬������Υ���ˡ�����ԭ��
 */