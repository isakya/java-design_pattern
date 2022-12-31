package com.izumi.a_singleresponsibility;

// 需求：统计一个文本文件中，有多少个单词
public class AppTestPlus {
    public static String[] getWords(String str) {
        String[] strs = SplitStr.words(str, "[^a-zA-Z]+");
        return strs;
    }
    public static void main(String[] args) throws Exception {
        // 方法的语句在同一个抽象层次上，不能又抽象又有实现细节
        String str = FileReaderClass.loadFile("./src/com/izumi/a_singleresponsibility/1.txt");
        String[] strs = getWords(str);
        System.out.println(strs.length);
    }
}
