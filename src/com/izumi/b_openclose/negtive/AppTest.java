package com.izumi.b_openclose.negtive;



public class AppTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("����");
        car.setColor("��ɫ");
        car.setLouyou(true);
        car.setPrice(666666);
        System.out.println(car.toString());
    }
}

// �仯������������������Ҫ�����
// Υ������ԭ����������ǣ�ֱ�Ӵ�Car��Դ���룬��getPrice�������޸�