package com.izumi.e_demeter.positive;

class Computer {
    private void saveDate() {
        System.out.println("保存数据");
    }
    private void killProcess() {
        System.out.println("关闭程序");
    }
    private void closeScreen() {
        System.out.println("关闭屏幕");
    }
    private void poweroff() {
        System.out.println("断电");
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
    // 符合迪米特法则的做法
    public void shutdownComputer() {
        c.shutDown();
    }

}

public class AppTest {

}
