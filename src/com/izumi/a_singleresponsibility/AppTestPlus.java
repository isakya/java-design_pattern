package com.izumi.a_singleresponsibility;

// ����ͳ��һ���ı��ļ��У��ж��ٸ�����
public class AppTestPlus {
    public static String[] getWords(String str) {
        String[] strs = SplitStr.words(str, "[^a-zA-Z]+");
        return strs;
    }
    public static void main(String[] args) throws Exception {
        // �����������ͬһ���������ϣ������ֳ�������ʵ��ϸ��
        String str = FileReaderClass.loadFile("./src/com/izumi/a_singleresponsibility/1.txt");
        String[] strs = getWords(str);
        System.out.println(strs.length);
    }
}
