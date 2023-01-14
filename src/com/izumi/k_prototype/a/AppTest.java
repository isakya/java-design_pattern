package com.izumi.k_prototype.a;


import java.util.Date;

// 仿表单的类
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
        // 第一周周报
        WeekReport wr = new WeekReport();
        wr.setEmp("张珊珊");
        wr.setSummary("讲解完了7大原则");
        wr.setPlan("讲解完设计模式");
        wr.setSuggestion("无");
        wr.setTime(new Date());
        System.out.println(wr);

        // 第二周周报
        // 问题：第二周周报内容与第一周周报内容大部分一致，但仍要重复设置！
        WeekReport wr2 = new WeekReport();
        wr2.setEmp("张珊珊");
        wr2.setSummary("讲解HTML");
        wr2.setPlan("讲解CSS");
        wr2.setSuggestion("无");
        wr2.setTime(new Date());
        System.out.println(wr2);

        // 期望：不变的，就不填了，只设置变化的部分。
    }
}
