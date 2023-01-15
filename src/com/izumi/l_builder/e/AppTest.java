package com.izumi.l_builder.e;

/**
 * ���󣺶���һ�������࣬��ʵ������������Ķ����Լ����ö�������Ը�ֵ
 *
 * �����d���е����⣬�޸Ĵ������£�
 *      �����Ľ�����ģʽ
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

// ָ����
class Director {
    public Computer build(ComputerBuilder cb) {
        cb.setCpu();
        cb.setGpu();
        cb.setHd();
        cb.setMemory();
        return cb.build();
    }
}

//   ���� ��
// ======================================================
//   �û� ��

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
        computer.setHd("256g��̬ + 500g��еӲ��");
    }
}


public class AppTest {
    public static void main(String[] args) {
        // ����������
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        LowComputerBuilder lcb = new LowComputerBuilder();
        MiddleHighComputerBuilder mhcb = new MiddleHighComputerBuilder();

        // ����ָ����
        Director director = new Director();
        
        // ����Ϸ
        Computer c = director.build(acb);
        System.out.println(c);


        // ����
        Computer c2 = director.build(mcb);
        System.out.println(c2);


        // �칫
        Computer c1 = director.build(lcb);
        System.out.println(c1);
        
        // �ͻ����Զ�����и������
        Computer c3 = director.build(mhcb);
        System.out.println(c3);
        
    }
}

/**
 *  ����ǽ�����ģʽ��
 *      �ŵ㣺
 *          1. ��������Ĺ����ȶ����䣨��Ϊ��ComputerBuilder�ӿ����ȶ����̣�
 *          2. ��������Ĺ���ֻд��һ�Σ�û���ظ����루ָ����ɣ�
 *          3. ����Ҫ��չָ���ߵ�ʱ�򣬲����޸�֮ǰ�Ĵ��룬������˿���ԭ��
 *
 *
 *      �������빤��ģʽ������
 *          ����ģʽֻ��Ҫһ���򵥵�new��new����Ʒ���ɣ�
 *          ������ģʽ��ע����new����Ʒָ�ӵģ�Ϊ��Ʒ���Ը�ֵ�Ĺ��̣���
 *
 *
 *
 */
