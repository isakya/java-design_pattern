package com.izumi.l_builder.a;

/**
 * ���󣺶���һ�������࣬��ʵ������������Ķ����Լ����ö�������Ը�ֵ
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

//   ���� ��
// ======================================================
//   �û� ��

public class AppTest {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.setCpu("i7 7500");
        c.setGpu("gtx750ti");
        c.setMemory("16g");
        c.setHd("1T��е");

        System.out.println(c);
    }
}

/**
 * ȱ�㣺
 *      1. �ͻ��˳���Ա����ʵ�����ò�Ʒ�Ķ���֮�󣬱���Ϊ�ö����ÿһ�����Ը�ֵ���������ڿͻ��˳���Ա��˵��̫�鷳�ˣ�
 *      2. Υ���˵����ط���
 *
 *
 *
 * ������ģʽ �� ����ģʽ ������
 * ������ģʽ������ʵ��������Ķ���֮�󣬻�Ҫ���ö�������Ը�ֵ��
 *
 */
