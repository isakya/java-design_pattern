package com.izumi.l_builder.c;

/**
 * 需求：定义一个电脑类，并实例化出电脑类的对象，以及给该对象的属性赋值
 *
 * 针对于b包中的问题，修改代码如下：
 *      针对于不同需求，我们需要创建不同的建造者，来分别生产不同配置的电脑
 */

class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "AppTest{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }
}

// 高端电脑
class AdvancedComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 8750U");
        computer.setGpu("rtx2080ti");
        computer.setMemory("32g");
        computer.setHd("2T机械硬盘");
        return computer;
    }
}

// 中端电脑
class MiddleComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i5 9700");
        computer.setGpu("rtx1060ti");
        computer.setMemory("16g");
        computer.setHd("256g固态 + 500g机械硬盘");
        return computer;
    }
}


// 低端电脑
class LowComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i3 7100");
        computer.setGpu("rtx760ti");
        computer.setMemory("8g");
        computer.setHd("500g机械硬盘");
        return computer;
    }
}

//   作者 ↑
// ======================================================
//   用户 ↓

public class AppTest {
    public static void main(String[] args) {
        // 创建建造者
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        LowComputerBuilder lcb = new LowComputerBuilder();

        // 玩游戏
        Computer c = acb.build();
        System.out.println(c);


        // 开发
        Computer c2 = mcb.build();
        System.out.println(c2);


        // 办公
        Computer c1 = lcb.build();
        System.out.println(c1);
    }
}

/**
 *  目前这种改进仍然不是建造者模式：
 *      优点：
 *          1. 可以根据客户端的不同需求，使用不同的建造者来生产产品
 *
 *
 *      缺点：
 *          1. 多个不同的建造者中的代码，都在重复代码，只是参数不同而已
 *          2. 建造过程不稳定，如果某个建造者在创建产品的过程中，漏掉了某一部，编译器不会报错
 *          （相当于，KFC的某一家分店，制作汉堡包的流程突然少了某一个步骤，出来的汉堡包味道就变了！因为没有标准）
 *
 */
