package com.izumi.i_factorymethod;


/***
 * ���������������£�
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

interface FoodFactory {
    Food getFood();
}

class HamburgerFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Hamburger();
    }
}

class RiceNoodleFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new RiceNoodle();
    }
}

class Business {
    public static void taste(FoodFactory ff) {
        Food f = ff.getFood();
        System.out.println("��ί1��Ʒ��");
        f.eat();
        System.out.println("��ί2��Ʒ��");
        f.eat();
        System.out.println("��ί3��Ʒ��");
        f.eat();
    }
}

// ���� ��
// =================================
// �û� ��

class Lp implements Food {
    @Override
    public void eat() {
        System.out.println("��Ƥ");
    }
}

class LpFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Lp();
    }
}


public class AppTest {
    public static void main(String[] args) {
        FoodFactory ff = new HamburgerFactory();
        Food food1 = ff.getFood();

        FoodFactory lp = new LpFactory();
        Food food2 = ff.getFood();

        Business.taste(ff);
        // �������Լ�������Ϊʲô��ֱ��ʵ�����࣬��Ҫʵ�ֹ�����ԭ��
        Business.taste(lp);

    }
}

/***
 * ��������
 *      �ŵ�:
 *          1. ��Ȼ���м򵥹������ŵ㣺���������޸��˾����Ʒ�������Ժ󣬿ͻ��˲�֪����
 *          2. ���ͻ�����Ҫ��չһ���µĲ�Ʒʱ������Ҫ�޸�����ԭ���Ĵ��룬ֻ����չһ���µĹ�������
 *
 *      �ܵ㣺
 *          1. �򵥹�������������������һ���ŵ㣬���Ƿ������˵ľ����Ʒ�����仯���Ժ󣬿ͻ��˲�֪����
 *             ���ǣ��ͻ�����Ȼ�����ھ���Ĺ�����������ʱ��������������޸��˾��幤������������ô�ͻ���ҲҪ��֮һ���޸ģ�
 *             �·�������һȦ�ֻص���ԭ�㣡�����������£�
 *
 *             ���ͣ�
 *                  ��Ϊ���������֣�����Ϊ�ӿڵġ����������Σ�������֤�������������ȶ��ġ�
 *                  Ҳ����˵����Ȼ�ͻ��������ڹ����ľ������������������й��������ֶ����������ȶ���
 *                  ���ٹ���������֣�Ҫ�Ⱦ����Ʒ������ָ����ȶ���
 *
 *           2. ��Ȼ��Ʒ�������Լ��ͻ�����չ�����ģ���ôΪʲô��ֱ��ʵ�����أ��Ͼ������չ������Lp�����Ʒ�������Լ��������ߡ�
 *              �����Լ������ߵĻ�������ô�������������Լ��ѿأ�Ϊʲô��ҪΪ�Լ������Ĳ�Ʒ�������أ�
 *
 *              ���ͣ�
 *                  ��Ϊ�������ڿ�������ʱ��������ֻ�Ὺ��һЩ�����Ʒ�������Ʒ����Ӧ�Ĺ������������׵ش���һЩ��ǰ���õĿ�ܡ�
 *
 *
 *            3. ����������LpFactory����Ϊ���ܰ�LpFactory�����Business.taste���������ԣ����붨��LpFactory��
 *               �ܣ�Ϊʲô����һ��ʼ����Business.taste������ֱ�ӽ���Food�����أ����������ڵ�FoodFactory��Ϊ������
 *
 *
 *       ȱ�㣺
 *          ����ж����Ʒ�ȼ�����ô��������������ͻᱬըʽ����
 *
 */




