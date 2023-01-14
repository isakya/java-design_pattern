package com.izumi.k_prototype.b;


import java.util.Date;

// �����a���е����ݣ��޸Ĵ������£�

/***
 *      ʹ�á�ԭ��ģʽ��������������
 *      1. ������Ŀ����ʵ��Cloneable�ӿڣ��ýӿ���û���κγ��󷽷��������Ľӿڽ�����һ������ǽӿڡ��������ǣ�����jvm��
 *         �κ�ʵ���˸�Cloneable�ӿڵ���Ķ��󣬿��Ա���¡����
 *
 *      2. ������дjava.lang.Object��clone������һ��Ҫ�Ѹ÷����ķ������η�����дΪpublic������Ȼ�޷�����clone������
 */
class WeekReport implements Cloneable {
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
        return super.clone();
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
        /**
         *  ��¡һ��wr���󣬵õ�һ���¶���
         *  ˼��1��clone�������᲻�����������ĵ��ã� ���ǲ��ᣡ��ô���clone���������ʵ�ֿ�¡�����Ч����
         *  clone������ֱ�Ӹ����ڴ��е�2���ơ�Ч�ʻ����ߣ�
         *
         *  ˼��2����Ȼclone����û�����������ĵ��ã�name��¡�����Ķ��󣬺�ԭ�ȵĶ��󣬵�ַ�Ƿ�һ�£� �𰸣���һ��
         *  ������������ͬ�ռ��еĶ���
         */
        WeekReport wr2 = (WeekReport) wr.clone();
        // wr2.setSummary("abc");
        // wr2.setPlan("xyz");
        // wr2.setTime(new Date());
        System.out.println(wr2);
        System.out.println(wr == wr2);

        // �����ǣ��޸�������һ����������ԣ���һ������������Ƿ��仯��
        // Date���setTime���������ú������ģ��������������1970.1.1 00:00:00�����ĺ�����
        // ϴ�����޸���wr2��time���ԣ���wr��time�ֶ�Ҳ��Ӱ���ˣ�Ϊʲô����Ϊ���ֿ�¡��ʽ�ǡ�ǳ������
        // ��ν��ǳ���������ǰ�ԭ���Ķ����2���ƣ�ԭ������
        wr2.getTime().setTime(0);

        System.out.println(wr);
        System.out.println(wr2);

        // ����������ϣ����¡�����ĸ�������������ô�޸�����������Ӱ��ԭ���Ķ��󣡣�
    }
}
