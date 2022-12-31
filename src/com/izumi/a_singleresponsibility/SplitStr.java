package com.izumi.a_singleresponsibility;

public class SplitStr {
    public static String[] words(String str, String reg) {
        String[] s = str.split(reg);
        return s;
    }
}
