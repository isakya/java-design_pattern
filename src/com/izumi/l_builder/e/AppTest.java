package com.izumi.l_builder.e;

/**
 * 需求：定义一个电脑类，并实例化出电脑类的对象，以及给该对象的属性赋值
 *
 * 针对于d包中的问题，修改代码如下：
 *      真正的建造者模式
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

// 指挥者
class Director {
    public Computer build(ComputerBuilder cb) {
        cb.setCpu();
        cb.setGpu();
        cb.setHd();
        cb.setMemory();
        return cb.build();
    }
}

//   作者 ↑
// ======================================================
//   用户 ↓

class MiddleHighComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7 7700");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx2060ti");
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


public class AppTest {
    public static void main(String[] args) {
        // 创建建造者
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        LowComputerBuilder lcb = new LowComputerBuilder();
        MiddleHighComputerBuilder mhcb = new MiddleHighComputerBuilder();

        // 创建指挥者
        Director director = new Director();
        
        // 玩游戏
        Computer c = director.build(acb);
        System.out.println(c);


        // 开发
        Computer c2 = director.build(mcb);
        System.out.println(c2);


        // 办公
        Computer c1 = director.build(lcb);
        System.out.println(c1);
        
        // 客户端自定义的中高配电脑
        Computer c3 = director.build(mhcb);
        System.out.println(c3);
        
    }
}

/**
 *  这就是建造者模式：
 *      优点：
 *          1. 创建对象的过程稳定不变（因为有ComputerBuilder接口来稳定过程）
 *          2. 创建对象的过程只写了一次，没有重复代码（指挥完成）
 *          3. 当需要扩展指挥者的时候，不用修改之前的代码，这符合了开闭原则
 *
 *
 *      建造者与工厂模式的区别：
 *          工厂模式只需要一个简单的new，new出产品即可！
 *          建造者模式更注重在new出产品指挥的，为产品属性赋值的过程！！
 *
 *
 *
 */
