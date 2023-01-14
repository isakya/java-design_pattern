package com.izumi.k_prototype.a;


import java.util.Date;

// �±�����
class WeekReport {
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
}

public class AppTest {
    public static void main(String[] args) {
        // ��һ���ܱ�
        WeekReport wr = new WeekReport();
        wr.setEmp("��ɺɺ");
        wr.setSummary("��������7��ԭ��");
        wr.setPlan("���������ģʽ");
        wr.setSuggestion("��");
        wr.setTime(new Date());
        System.out.println(wr);

        // �ڶ����ܱ�
        // ���⣺�ڶ����ܱ��������һ���ܱ����ݴ󲿷�һ�£�����Ҫ�ظ����ã�
        WeekReport wr2 = new WeekReport();
        wr2.setEmp("��ɺɺ");
        wr2.setSummary("����HTML");
        wr2.setPlan("����CSS");
        wr2.setSuggestion("��");
        wr2.setTime(new Date());
        System.out.println(wr2);

        // ����������ģ��Ͳ����ˣ�ֻ���ñ仯�Ĳ��֡�
    }
}
