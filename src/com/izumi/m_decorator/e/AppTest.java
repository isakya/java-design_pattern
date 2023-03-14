package com.izumi.m_decorator.e;

import java.io.*;

/**
 * 装饰器模式已学完
 *
 * jdk中的流，就是装饰器模式的体现
 */
public class AppTest {
    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("/m_decorator");
        BufferedInputStream ris = new BufferedInputStream(in);
        InputStreamReader isr = new InputStreamReader(ris, "utf-8");
        isr.close();
    }
}
