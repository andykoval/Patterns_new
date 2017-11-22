package com.company;

import java.io.*;

/**
 * Created by andy on 21.11.2017.
 */
public class CryptoMain {
    private static String key;

    public static void main(String[] args) throws IOException {

        key = "abracadabra";

        File file = new File("C:\\dir2\\text1.txt");
        File file1 = new File("C:\\dir2\\text2.txt");
        File file2 = new File("C:\\dir2\\text3.txt");
        InputStream in = new BufferedInputStream(new CryptoInputStream(new FileInputStream(file), key));
        OutputStream out = new BufferedOutputStream(new CryptoOutputStream(new FileOutputStream(file1), key));
        InputStream in1 = new BufferedInputStream(new CryptoInputStream(new FileInputStream(file1), key));
        OutputStream out1 = new BufferedOutputStream(new CryptoOutputStream(new FileOutputStream(file2), key));
        int oneByte;
        while ((oneByte = in.read()) != -1)
            out.write(oneByte);
        if (in != null) ;
        in.close();
        if (out != null) {
            out.close();
            out.flush();
        }
        while ((oneByte = in1.read()) != -1)
            out1.write(oneByte);
        if (in1 != null) ;
        in1.close();
        if (out1 != null) {
            out1.close();
            out1.flush();
        }

//        int count;
//        byte[] bytes = new byte[1024];
//        while ((count = in.read(bytes)) != -1)
//            out.write(bytes, 0, count);
//        if (in != null)
//            in.close();
//        if (out != null) {
//            out.close();
//            out.flush();
//        }
//
//        while ((count = in1.read(bytes)) != -1) {
//            System.out.println(count);
//            out1.write(bytes, 0, count);
//        }
//        if (in1 != null)
//            in1.close();
//        if (out1 != null) {
//            out1.close();
//            out1.flush();
//        }
        }
    }
