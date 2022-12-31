package com.izumi.a_singleresponsibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
// 需求一：统计一个文本文件中，有多少个字符
// 需求二：统计一个文本文件中，有多少个单词
public class AppTest {
    public static void main(String[] args) throws Exception {
        // 编码基础知识点补充：
        // 字节流和字符流的区别：一个查码表（Reader）、一个不查码表（InputStream）
        // Reader默认查询的码表是与操作系统一致的码表，我们操作系统是中文的，所以Reader就会使用GBK码表
        // 而GBK码表中、一个汉字占两个字节，要是用字节流的话，它就只能一个个字节去读取，所以根本读不出完整的两个字节的中文
        // 一个汉字不一定占2个字节，得看码表：如UTF-8的一个汉字就占3个字节
        // GBK码表一个汉字占2个字节，且汉字的两个字节，都是以1开头的，如果字节是1开头就合并后面的字节解释，所以系统为什么能知道什么时候解释中文，什么时候解释其他字符，如a码表是97，所以单独解释
        // 如果GBK中是以 -号开头的字节，也会合并后面的字节进行解释成中文，但是不能超过字节长度-127~128，否则会溢出


        // 1. 字符流（查码表），所以操作文本文件用字符流
        // java只认识unicode码表
        // 读取到记事本中的数字 ---> gbk ---> 北 ---> unicode ---> 21271
        Reader in = new FileReader("./src/com/izumi/a_singleresponsibility/1.txt");

        /**
        // 需求一：
        int count = 0;
        // 统计字符数
        while (in.read() != -1) {
            count++;
        }
        System.out.println(count);
        in.close();
        */


        // 需求二：
        BufferedReader br = new BufferedReader(in);
        String line = null;
        StringBuffer sb = new StringBuffer("");
        while ((line = br.readLine()) != null) {
            System.out.println(line + "!!!");
            sb.append(line);
            sb.append(" ");
        }
        System.out.println(sb);

        String[] words = sb.toString().split("[^a-zA-Z]+"); // 正则 空格+ 表示1到多个空格, ^是匹配到字符以外的字符
        for(String word : words) {
            System.out.println(word);
        }
        System.out.println(words.length);
        br.close();


        // 2. 字节流（不查码表）
        // Reader n2 = new FileReader("./src/com/izumi/a_singleresponsibility/1.txt");
        // int in2 = n2.read();
        // System.out.println(in2);
        // in.close();


        // 3. 验证编码解码
        String s = "金";
        // 编码：字符 --> 码表 --> 数字
        byte[] bb = s.getBytes("gbk");
        System.out.println(Arrays.toString(bb)); // [-67, -16]
        // 解码：数字 --> 码表 --> 字符
        byte[] bb2 = s.getBytes("unicode");
        System.out.println(Arrays.toString(bb2)); // [-2, -1, -111, -47] 注：-2,-1是unicode编码的标志性开头
        // 注：由于java用的是unicode码表，所以java每个字符都占2个字节，哪怕一个字节阿够用，java也会补足两个字节
    }
}
