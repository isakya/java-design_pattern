package com.izumi.a_singleresponsibility;

import java.io.*;

public class FileReaderClass {
    public static String loadFile(String path) throws Exception {
        Reader in = new FileReader(path);
        BufferedReader br = new BufferedReader(in);
        String line = null;
        StringBuffer sb = new StringBuffer("");
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }
        br.close();

        return sb.toString();
    }
}
