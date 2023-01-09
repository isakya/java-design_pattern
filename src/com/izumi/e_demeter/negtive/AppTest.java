package com.izumi.e_demeter.negtive;

class Computer {
    public void saveDate() {
        System.out.println("保存数据");
    }
    public void killProcess() {
        System.out.println("关闭程序");
    }
    public void closeScreen() {
        System.out.println("关闭屏幕");
    }
    public void poweroff() {
        System.out.println("断电");
    }
}

class Person {
    private Computer c = new Computer();
    // 此时这个Person对于Computer的细节知道的太多了
    // 对于Person而言，只需要知道，关机按钮在哪就行了，不需要指导如何保存数据，如何关闭进程，如何断电等等这些细节。。。
    // 这样的代码复杂度太高，万一用户使用不当，就有可能造成更大的损失
    public void shutdownComputer() {
        c.saveDate();
        c.killProcess();
        c.closeScreen();
        c.poweroff();
    }

}

public class AppTest {

}
