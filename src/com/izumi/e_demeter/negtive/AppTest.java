package com.izumi.e_demeter.negtive;

class Computer {
    public void saveDate() {
        System.out.println("��������");
    }
    public void killProcess() {
        System.out.println("�رճ���");
    }
    public void closeScreen() {
        System.out.println("�ر���Ļ");
    }
    public void poweroff() {
        System.out.println("�ϵ�");
    }
}

class Person {
    private Computer c = new Computer();
    // ��ʱ���Person����Computer��ϸ��֪����̫����
    // ����Person���ԣ�ֻ��Ҫ֪�����ػ���ť���ľ����ˣ�����Ҫָ����α������ݣ���ιرս��̣���ζϵ�ȵ���Щϸ�ڡ�����
    // �����Ĵ��븴�Ӷ�̫�ߣ���һ�û�ʹ�ò��������п�����ɸ������ʧ
    public void shutdownComputer() {
        c.saveDate();
        c.killProcess();
        c.closeScreen();
        c.poweroff();
    }

}

public class AppTest {

}
