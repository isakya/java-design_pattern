package com.izumi.a_singleresponsibility;

// ����ͳ��һ���ı��ļ��У��ж��ٸ�����
public class AppTest2Plus {

    public static String[] getWords(String str) {
        String[] strs = SplitStr.words(str, "[\\.!?��]+");
        return strs;
    }

    public static void main(String[] args) throws Exception {
        String str = FileReaderClass.loadFile("./src/com/izumi/a_singleresponsibility/2.txt");
        String[] strs = getWords(str);
        System.out.println(strs.length);
    }
}
