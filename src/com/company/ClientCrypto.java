package com.company;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by andy on 21.11.2017.
 */


public class ClientCrypto {

//    public static void writeToFile(InputStream in, File file) throws IOException {
//        OutputStream out = new FileOutputStream("C:\\dir2\\test.bin");
//        try {
//            byte[] bytes = new byte[1024];
//            int count;
//            while ((count = in.read(bytes)) != -1)
//                out.write(bytes);
//        } finally {
//            if(in!=null)
//                in.close();
//            if (out != null) {
//                out.flush();
//                out.close();
//            }
//        }
//    }



    private static String key;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        key = "someWord#1";

        Socket sock = new Socket();
        sock.connect(new InetSocketAddress("localhost", 12347));
//        InputStream in = new CryptoInputStream(sock.getInputStream(), key);
//        OutputStream out = new CryptoOutputStream(sock.getOutputStream(), key);

        InputStream in = sock.getInputStream();
        OutputStream out = sock.getOutputStream();
//        InputStream in = new BufferedInputStream(
//                new CryptoInputStream(sock.getInputStream(), key));
//        OutputStream out = new BufferedOutputStream (
//                new CryptoOutputStream(sock.getOutputStream(), key));
//        ObjectOutputStream objout = new ObjectOutputStream(new CryptoOutputStream(out, key));
//        ObjectInputStream objin = new ObjectInputStream(new CryptoInputStream(in,key));
//        InputStream in = new CryptoInputStream(new FileInputStream("C:\\dir2\\test.bin"), key);
//        OutputStream out = new CryptoOutputStream(new FileOutputStream("C:\\dir2\\test.bin"), key);
        ObjectOutputStream objout = new ObjectOutputStream(out);
        ObjectInputStream objin = new ObjectInputStream(in);

        objout.writeObject("HELLO");
        Object object = objin.readObject();
        System.out.println(object);

        out.flush();
        out.close();
        in.close();
        sock.close();
    }
}
