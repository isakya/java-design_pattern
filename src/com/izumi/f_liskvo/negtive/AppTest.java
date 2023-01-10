package com.izumi.f_liskvo.negtive;

/***
 * �̳е����ã�
 *  1. ��ߴ���������
 *  2. ��̬��ǰ��
 *
 *  �������ܲ��ܷ����̳й�ϵ��������ʲô��
 *      ��a. ��û�С�is a����ϵ
 *          b. ������������ is a ��ϵ֮�󣬻�Ҫ��������������滻�˸������֮��ҵ���߼��Ƿ�仯������仯�����ܷ����̳й�ϵ
 *
 * �����κͳ������С�is a����ϵ���������ܲ��������������ȥ�̳г������࣬
 * ��Ϊ��Ҫ����ҵ�񳡾������ض���ҵ�񳡾��£��������Ƿ����滻�����Σ����滻�������Ժ�ҵ���߼��Ƿ�仯
 *
 */

class Utils {
    public static void transform(Rectangle r) {
        while (r.getWidth() <= r.getLength()) {
            r.setWidth(r.getWidth() + 1);
            System.out.println(r.getWidth() + ":" + r.getLength());
        }
    }
}

// ��������
class Rectangle {
    private double length;
    private double width;


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
// �����������μ̳��˳�����
class Square extends Rectangle {
    private  double sidelength;

    @Override
    public double getLength() {
        return sidelength;
    }

    @Override
    public void setLength(double length) {
        this.sidelength = length;
    }

    @Override
    public double getWidth() {
        return sidelength;
    }

    @Override
    public void setWidth(double width) {
        this.sidelength = width;
    }
}

public class AppTest {
    public static void main(String[] args) {
        Rectangle r = new Square();
        r.setWidth(12);
        r.setLength(20);
        // ҵ��Ч������
        Utils.transform(r); // ��ѭ��
    }
}
