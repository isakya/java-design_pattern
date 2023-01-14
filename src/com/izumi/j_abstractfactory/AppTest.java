package com.izumi.j_abstractfactory;

/***
 * ��Թ������������⣺���ж����Ʒ�ȼ�ʱ��ʳ����ϡ���Ʒ...����������ͻ�ܶ࣡
 * �޸Ĵ������£�ʹ�ó��󹤳�ģʽ
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


interface Drink {
    void drink();
}

class Cola implements Drink {
    public void drink() {
        System.out.println("�ɿڿ��֣���ָ��ӵ�У�");
    }
}

class IcePeak implements Drink {
    @Override
    public void drink() {
        System.out.println("�������ϣ���С�ͺ�����");
    }
}


interface Factory {
    Food getFood();
    Drink getDrink();
}

class KFCFactory implements Factory {
    @Override
    public Food getFood() {
        return new Hamburger();
    }
    @Override
    public Drink getDrink() {
        return new Cola();
    }
}

class SanQinFactory implements Factory {
    @Override
    public Food getFood() {
        return new RiceNoodle();
    }
    @Override
    public Drink getDrink() {
        return new IcePeak();
    }
}


class Business {
    public static void taste(Factory ff) {
        Food f = ff.getFood();
        Drink d = ff.getDrink();
        System.out.println("��ί1��Ʒ��");
        f.eat();
        d.drink();

        Food f1 = ff.getFood();
        Drink d1 = ff.getDrink();
        System.out.println("��ί2��Ʒ��");
        f1.eat();
        d1.drink();

        Food f2 = ff.getFood();
        Drink d2 = ff.getDrink();
        System.out.println("��ί3��Ʒ��");
        f2.eat();
        d2.drink();

    }
}


// ���� ��
// =================================
// �û� ��

// �û���չ
class Lp implements Food {
    @Override
    public void eat() {
        System.out.println("����ߦ��Ƥ");
    }
}

class Fanta implements Drink {
    @Override
    public void drink() {
        System.out.println("�Ҵ��ֵ��ӵ��");
    }
}

class BaoJiFactory implements Factory {
    @Override
    public Drink getDrink() {
        return new Fanta();
    }

    @Override
    public Food getFood() {
        return new Lp();
    }
}

public class AppTest {
    public static void main(String[] args) {
        Business.taste(new KFCFactory());
        Business.taste(new BaoJiFactory());
    }
}



/***
 *  ���󹤳���
 *      �ŵ㣺
 *          1. ��Ȼ�м򵥹����͹����������ŵ�
 *          2. ����Ҫ���ǣ����󹤳��ѹ���������������ˣ������ж��ٸ���Ʒ�ȼ���������һ��
 *
 *          �ܵ㣺
 *              1. Ϊʲô���ع����У��ͱ��������ߴ�������أ�
 *                 Ϊʲô�Ͳ��������ߴ�����֣�
 *
 *              ���ͣ�
 *                  ���󹤳��У��������������Ʒ��������Ʒ֮�䣬������������ϵ��
 *                  ͬһ�������еĲ�Ʒ������ͬһ����Ʒ�أ������ܰѲ�ͬ��Ʒ���еĲ�Ʒ��ϵ�һ�����󹤳���ʵ�����С�
 *
 *       ȱ�㣺
 *          1. ����Ʒ�ȼ������仯ʱ�����Ӳ�Ʒ�ȼ� �� ɾ����Ʒ�ȼ�������Ҫ����������ǰ����������޸ģ����Υ���ˡ�����ԭ��
 *
 *       ���ۣ�
 *          �����Ʒ�ȼ��ȽϹ̶�ʱ�����Կ���ʹ�ó��󹤳���
 *          �����Ʒ�ȼ������仯���򲻽���ʹ�ó��󹤳�
 *
 */




