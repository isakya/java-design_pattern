package com.izumi.a_singleresponsibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
// ����һ��ͳ��һ���ı��ļ��У��ж��ٸ��ַ�
// �������ͳ��һ���ı��ļ��У��ж��ٸ�����
public class AppTest {
    public static void main(String[] args) throws Exception {
        // �������֪ʶ�㲹�䣺
        // �ֽ������ַ���������һ�������Reader����һ���������InputStream��
        // ReaderĬ�ϲ�ѯ������������ϵͳһ�µ�������ǲ���ϵͳ�����ĵģ�����Reader�ͻ�ʹ��GBK���
        // ��GBK����С�һ������ռ�����ֽڣ�Ҫ�����ֽ����Ļ�������ֻ��һ�����ֽ�ȥ��ȡ�����Ը��������������������ֽڵ�����
        // һ�����ֲ�һ��ռ2���ֽڣ��ÿ������UTF-8��һ�����־�ռ3���ֽ�
        // GBK���һ������ռ2���ֽڣ��Һ��ֵ������ֽڣ�������1��ͷ�ģ�����ֽ���1��ͷ�ͺϲ�������ֽڽ��ͣ�����ϵͳΪʲô��֪��ʲôʱ��������ģ�ʲôʱ����������ַ�����a�����97�����Ե�������
        // ���GBK������ -�ſ�ͷ���ֽڣ�Ҳ��ϲ�������ֽڽ��н��ͳ����ģ����ǲ��ܳ����ֽڳ���-127~128����������


        // 1. �ַ���������������Բ����ı��ļ����ַ���
        // javaֻ��ʶunicode���
        // ��ȡ�����±��е����� ---> gbk ---> �� ---> unicode ---> 21271
        Reader in = new FileReader("./src/com/izumi/a_singleresponsibility/1.txt");

        /**
        // ����һ��
        int count = 0;
        // ͳ���ַ���
        while (in.read() != -1) {
            count++;
        }
        System.out.println(count);
        in.close();
        */


        // �������
        BufferedReader br = new BufferedReader(in);
        String line = null;
        StringBuffer sb = new StringBuffer("");
        while ((line = br.readLine()) != null) {
            System.out.println(line + "!!!");
            sb.append(line);
            sb.append(" ");
        }
        System.out.println(sb);

        String[] words = sb.toString().split("[^a-zA-Z]+"); // ���� �ո�+ ��ʾ1������ո�, ^��ƥ�䵽�ַ�������ַ�
        for(String word : words) {
            System.out.println(word);
        }
        System.out.println(words.length);
        br.close();


        // 2. �ֽ������������
        // Reader n2 = new FileReader("./src/com/izumi/a_singleresponsibility/1.txt");
        // int in2 = n2.read();
        // System.out.println(in2);
        // in.close();


        // 3. ��֤�������
        String s = "��";
        // ���룺�ַ� --> ��� --> ����
        byte[] bb = s.getBytes("gbk");
        System.out.println(Arrays.toString(bb)); // [-67, -16]
        // ���룺���� --> ��� --> �ַ�
        byte[] bb2 = s.getBytes("unicode");
        System.out.println(Arrays.toString(bb2)); // [-2, -1, -111, -47] ע��-2,-1��unicode����ı�־�Կ�ͷ
        // ע������java�õ���unicode�������javaÿ���ַ���ռ2���ֽڣ�����һ���ֽڰ����ã�javaҲ�Ჹ�������ֽ�
    }
}
