package com.izumi.k_prototype.d;


import java.io.*;
import java.util.Date;

// �����c���е����ݣ��޸Ĵ������£�

/***
 *  �������л�+�����л� ����������
 */
class WeekReport implements Cloneable, Serializable {
    private int id;
    private String emp;
    private String summary;
    private String plan;
    private String suggestion;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeekReport{" +
                "id=" + id +
                ", emp='" + emp + '\'' +
                ", summary='" + summary + '\'' +
                ", plain='" + plan + '\'' +
                ", suggestion='" + suggestion + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            OutputStream out = new FileOutputStream("public/a.txt");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this); // ���л�ʱ��������������Բ㼶��ϵ�ᱻ���л��Զ�������
            oos.close();

            InputStream in = new FileInputStream("public/a.txt");
            ObjectInputStream ois = new ObjectInputStream(in);
            Object clone = ois.readObject();
            ois.close();
            return clone;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }


}

public class AppTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // ��һ���ܱ�
        WeekReport wr = new WeekReport();
        wr.setEmp("��ɺɺ");
        wr.setSummary("��������7��ԭ��");
        wr.setPlan("���������ģʽ");
        wr.setSuggestion("��");
        wr.setTime(new Date());
        System.out.println(wr);

        // �ڶ����ܱ�
        WeekReport wr2 = (WeekReport) wr.clone();
        wr2.setSummary("abc");
        wr2.setPlan("xyz");
        System.out.println(wr2);
        System.out.println(wr == wr2);
        wr2.getTime().setTime(0);
        System.out.println(wr);
        System.out.println(wr2);

        // ��ʱ���������л�+�����л����Ѿ������������
        // �����ǣ�
        // ���л���Ŀ��λ����д���ģ�λ�ò�Ӧ��д����linux��û���̷�����

    }
}
