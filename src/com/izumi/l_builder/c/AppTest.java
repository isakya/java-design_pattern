package com.izumi.l_builder.c;

/**
 * ���󣺶���һ�������࣬��ʵ������������Ķ����Լ����ö�������Ը�ֵ
 *
 * �����b���е����⣬�޸Ĵ������£�
 *      ����ڲ�ͬ����������Ҫ������ͬ�Ľ����ߣ����ֱ�������ͬ���õĵ���
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

// �߶˵���
class AdvancedComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 8750U");
        computer.setGpu("rtx2080ti");
        computer.setMemory("32g");
        computer.setHd("2T��еӲ��");
        return computer;
    }
}

// �ж˵���
class MiddleComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i5 9700");
        computer.setGpu("rtx1060ti");
        computer.setMemory("16g");
        computer.setHd("256g��̬ + 500g��еӲ��");
        return computer;
    }
}


// �Ͷ˵���
class LowComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i3 7100");
        computer.setGpu("rtx760ti");
        computer.setMemory("8g");
        computer.setHd("500g��еӲ��");
        return computer;
    }
}

//   ���� ��
// ======================================================
//   �û� ��

public class AppTest {
    public static void main(String[] args) {
        // ����������
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        LowComputerBuilder lcb = new LowComputerBuilder();

        // ����Ϸ
        Computer c = acb.build();
        System.out.println(c);


        // ����
        Computer c2 = mcb.build();
        System.out.println(c2);


        // �칫
        Computer c1 = lcb.build();
        System.out.println(c1);
    }
}

/**
 *  Ŀǰ���ָĽ���Ȼ���ǽ�����ģʽ��
 *      �ŵ㣺
 *          1. ���Ը��ݿͻ��˵Ĳ�ͬ����ʹ�ò�ͬ�Ľ�������������Ʒ
 *
 *
 *      ȱ�㣺
 *          1. �����ͬ�Ľ������еĴ��룬�����ظ����룬ֻ�ǲ�����ͬ����
 *          2. ������̲��ȶ������ĳ���������ڴ�����Ʒ�Ĺ����У�©����ĳһ�������������ᱨ��
 *          ���൱�ڣ�KFC��ĳһ�ҷֵ꣬����������������ͻȻ����ĳһ�����裬�����ĺ�����ζ���ͱ��ˣ���Ϊû�б�׼��
 *
 */
