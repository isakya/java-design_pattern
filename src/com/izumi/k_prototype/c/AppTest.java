package com.izumi.k_prototype.c;


import java.util.Date;

// 针对于b包中的内容，修改代码如下：

/***
 *      仅仅修改了WeekReport的clone方法
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
        WeekReport clone = (WeekReport) super.clone();
        // 把日期也克隆一份
        Date clone2 = (Date) clone.getTime().clone();
        clone.setTime(clone2);
        return clone;
    }
}

public class AppTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 第一周周报
        WeekReport wr = new WeekReport();
        wr.setEmp("张珊珊");
        wr.setSummary("讲解完了7大原则");
        wr.setPlan("讲解完设计模式");
        wr.setSuggestion("无");
        wr.setTime(new Date());
        System.out.println(wr);

        // 第二周周报
        WeekReport wr2 = (WeekReport) wr.clone();
        wr2.setSummary("abc");
        wr2.setPlan("xyz");
        System.out.println(wr2);
        System.out.println(wr == wr2);

        // 设置时间，发现不会影响第一周报的时间了
        wr2.getTime().setTime(0);

        System.out.println(wr);
        System.out.println(wr2);

        // 目前已经达到了深拷贝的目的，也就是修改副本对象的任何属性，都对原有对象没有任何影响！！
        // 问题是：如果对象深度比较深，则深拷贝实现起来很麻烦！
    }
}
