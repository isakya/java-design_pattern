package com.izumi.f_liskvo.positive;

// ����


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
// �����������β�ȥ�̳г�����
class Square {
    private  double sidelength;
}

public class AppTest {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setWidth(12);
        r.setLength(20);

        Utils.transform(r);
    }
}
