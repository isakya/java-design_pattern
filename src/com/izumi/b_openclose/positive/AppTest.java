package com.izumi.b_openclose.positive;


public class AppTest {
    public static void main(String[] args) {
        Car car = new DiscountCar();
        car.setBrand("����");
        car.setColor("��ɫ");
        car.setLouyou(true);
        car.setPrice(666666);
        System.out.println(car.getPrice());
    }
}

// �仯������������������Ҫ�����
// ���Ͽ���ԭ����������ǣ�ʼ�ձ�֤Car��Դ���벻�ᱻ�޸�
// ����������һ��Car��������дCar��getPrice����