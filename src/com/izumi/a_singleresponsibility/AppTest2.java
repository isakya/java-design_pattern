package com.izumi.a_singleresponsibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

// 需求一：统计一个文本文件中，有多少个句子
public class AppTest2 {
    public static void main(String[] args) throws Exception {
        Reader in = new FileReader("./src/com/izumi/a_singleresponsibility/2.txt");

        BufferedReader br = new BufferedReader(in);
        String line = null;
        StringBuffer sb = new StringBuffer("");
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }

        String[] words = sb.toString().split("[\\.!?。]+"); // 正则 + 表示1到多个空格, ^是匹配到字符以外的字符, . 代表任意字符
        for(String word : words) {
            System.out.println(word + "%%%%");
        }
        if(words[words.length -1].length() == 0) {
            System.out.println(words.length - 1);
        } else {
            System.out.println(words.length);
        }
        br.close();
    }
}
