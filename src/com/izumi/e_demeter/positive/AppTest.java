package com.izumi.e_demeter.positive;

class Computer {
    private void saveDate() {
        System.out.println("��������");
    }
    private void killProcess() {
        System.out.println("�رճ���");
    }
    private void closeScreen() {
        System.out.println("�ر���Ļ");
    }
    private void poweroff() {
        System.out.println("�ϵ�");
    }

    public void shutDown() {
        saveDate();
        killProcess();
        closeScreen();
        poweroff();
    }
}

class Person {
    private Computer c = new Computer();
    // ���ϵ����ط��������
    public void shutdownComputer() {
        c.shutDown();
    }

}

public class AppTest {

}
