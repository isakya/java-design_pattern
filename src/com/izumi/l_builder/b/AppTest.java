package com.izumi.l_builder.b;

/**
 * ���󣺶���һ�������࣬��ʵ������������Ķ����Լ����ö�������Ը�ֵ
 *
 * �����a���е����⣬�޸Ĵ������£�
 * ���ߣ�ר�Ŵ���һ��"ComputerBuilder" �࣬ �����ר�Ÿ��Ʒ�װ��װ���ԵĹ���
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

// ���Խ������࣬�������࣬�������һ����Ʒ
class ComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 8750U");
        computer.setCpu("rtx2080ti");
        computer.setMemory("32g");
        computer.setHd("2T��еӲ��");
        return computer;
    }
}


//   ���� ��
// ======================================================
//   �û� ��

public class AppTest {
    public static void main(String[] args) {
        // ����������
        ComputerBuilder cb = new ComputerBuilder();

        // ����Ϸ
        Computer c = cb.build();
        System.out.println(c);

        // �칫
        Computer c1 = cb.build();
        System.out.println(c1);

        // ����
        Computer c2 = cb.build();
        System.out.println(c2);
    }
}

/**
 *  Ŀǰ����д�������ǽ�����ģʽ��Ŀǰ���ŵ㣺
 *      1. �ͻ��˳�����Ҫһ����Ʒʱ��ֱ��������Ҫ���ɣ������߷�װ�˴������Եġ����ӡ�����
 *
 *
 *  ȱ�㣺
 *      1. ��װ��̫���� ���ۿͻ���������ʲô�����ǲ���������ã�û�������
 */
