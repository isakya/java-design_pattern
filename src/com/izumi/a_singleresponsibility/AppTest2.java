package com.izumi.a_singleresponsibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

// ����һ��ͳ��һ���ı��ļ��У��ж��ٸ�����
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

        String[] words = sb.toString().split("[\\.!?��]+"); // ���� + ��ʾ1������ո�, ^��ƥ�䵽�ַ�������ַ�, . ���������ַ�
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
