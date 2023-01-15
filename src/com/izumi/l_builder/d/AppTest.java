package com.izumi.l_builder.d;

/**
 * 需求：定义一个电脑类，并实例化出电脑类的对象，以及给该对象的属性赋值
 *
 * 针对于c包中的问题，修改代码如下：
 *      创建一个建造者接口，把制作产品的具体步骤稳定下拉
 *      我们让建造者去实现建造者接口，接口中的方法步骤，类就必须都要实现，少一个抽象方法就会报错！
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

interface ComputerBuilder {
    void setCpu();
    void setGpu();
    void setMemory();
    void setHd();
    Computer build();
}

// 高端电脑
class AdvancedComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7 8750U");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx2080ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("32g");
    }

    @Override
    public void setHd() {
        computer.setHd("2T机械硬盘");
    }
}

// 中端电脑
class MiddleComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i5 9700");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx1060ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16g");
    }

    @Override
    public void setHd() {
        computer.setHd("256g固态 + 500g机械硬盘");
    }
}


// 低端电脑
class LowComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        return computer;
    }


    @Override
    public void setCpu() {
        computer.setCpu("i3 7100");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx760ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8g");
    }

    @Override
    public void setHd() {
        computer.setHd("500g机械硬盘");
    }
}

//   作者 ↑
// ======================================================
//   用户 ↓

public class AppTest {
    public static void main(String[] args) {
        // 创建建造者

        // 玩游戏
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        acb.setCpu();
        acb.setGpu();
        acb.setHd();
        acb.setMemory();
        Computer c = acb.build();
        System.out.println(c);


        // 开发
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        mcb.setCpu();
        mcb.setGpu();
        mcb.setHd();
        mcb.setMemory();
        Computer c2 = mcb.build();
        System.out.println(c2);


        // 办公
        LowComputerBuilder lcb = new LowComputerBuilder();
        lcb.setCpu();
        lcb.setGpu();
        lcb.setHd();
        lcb.setMemory();
        Computer c1 = lcb.build();
        System.out.println(c1);
    }
}

/**
 *  目前这种改进仍然不是建造者模式：
 *      优点：
 *          建造者类中的建筑过程是稳定的，不会漏掉某一步！！这样客户端想扩展建造者时，也不会漏掉某一步
 *
 *
 *      缺点：
 *          1. 代码仍然有重复
 *          2. 现在又变成了客户端自己配置电脑，又违反了迪米特法则
 *
 */
