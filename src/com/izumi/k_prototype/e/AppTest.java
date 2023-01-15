package com.izumi.k_prototype.e;


import java.io.*;
import java.util.Date;

// 针对于d包中的内容，修改代码如下：

/***
 * 把对象信息写入到内存当中，然后在从内存中读取出来，就可以做到深拷贝，这样就不用考虑存储位置问题
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
            // 把对象信息写入到内存当中
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this); // 序列化时，对象的所有属性层级关系会被序列化自动处理！！
            oos.close();

            // 从内存中取出数据
            byte[] bb = out.toByteArray();
            InputStream in = new ByteArrayInputStream(bb);
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
        wr2.getTime().setTime(0);
        System.out.println(wr);
        System.out.println(wr2);

        // 此时，这才是推荐的原型模式写法！！
    }
}
