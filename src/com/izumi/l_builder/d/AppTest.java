package com.izumi.l_builder.d;

/**
 * ���󣺶���һ�������࣬��ʵ������������Ķ����Լ����ö�������Ը�ֵ
 *
 * �����c���е����⣬�޸Ĵ������£�
 *      ����һ�������߽ӿڣ���������Ʒ�ľ��岽���ȶ�����
 *      �����ý�����ȥʵ�ֽ����߽ӿڣ��ӿ��еķ������裬��ͱ��붼Ҫʵ�֣���һ�����󷽷��ͻᱨ��
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

// �߶˵���
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
        computer.setHd("2T��еӲ��");
    }
}

// �ж˵���
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
        computer.setHd("256g��̬ + 500g��еӲ��");
    }
}


// �Ͷ˵���
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
        computer.setHd("500g��еӲ��");
    }
}

//   ���� ��
// ======================================================
//   �û� ��

public class AppTest {
    public static void main(String[] args) {
        // ����������

        // ����Ϸ
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        acb.setCpu();
        acb.setGpu();
        acb.setHd();
        acb.setMemory();
        Computer c = acb.build();
        System.out.println(c);


        // ����
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        mcb.setCpu();
        mcb.setGpu();
        mcb.setHd();
        mcb.setMemory();
        Computer c2 = mcb.build();
        System.out.println(c2);


        // �칫
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
 *  Ŀǰ���ָĽ���Ȼ���ǽ�����ģʽ��
 *      �ŵ㣺
 *          ���������еĽ����������ȶ��ģ�����©��ĳһ�����������ͻ�������չ������ʱ��Ҳ����©��ĳһ��
 *
 *
 *      ȱ�㣺
 *          1. ������Ȼ���ظ�
 *          2. �����ֱ���˿ͻ����Լ����õ��ԣ���Υ���˵����ط���
 *
 */
