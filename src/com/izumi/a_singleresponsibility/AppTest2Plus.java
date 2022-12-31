package com.izumi.a_singleresponsibility;

// 需求：统计一个文本文件中，有多少个句子
public class AppTest2Plus {

    public static String[] getWords(String str) {
        String[] strs = SplitStr.words(str, "[\\.!?。]+");
        return strs;
    }

    public static void main(String[] args) throws Exception {
        String str = FileReaderClass.loadFile("./src/com/izumi/a_singleresponsibility/2.txt");
        String[] strs = getWords(str);
        System.out.println(strs.length);
    }
}
