package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by andy on 21.11.2017.
 */
public class ServerCrypto {
    private static String key;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        key = "someWord#1";
        ServerSocket ssock = new ServerSocket(12347);
        Socket sock = ssock.accept();

        InputStream in = new CryptoInputStream(sock.getInputStream(),key);
        OutputStream out = new CryptoOutputStream(sock.getOutputStream(), key);

//        InputStream in = sock.getInputStream();
//        OutputStream out = sock.getOutputStream();
//        InputStream in = new BufferedInputStream(
//                new CryptoInputStream(sock.getInputStream(), key));
//        OutputStream out = new BufferedOutputStream (
//                new CryptoOutputStream(sock.getOutputStream(), key));
        ObjectInputStream objin = new ObjectInputStream(in);
        ObjectOutputStream objout = new ObjectOutputStream(out);
//        InputStream in = new CryptoInputStream(new FileInputStream("C:\\dir2\\test.bin"), key);
//        OutputStream out = new CryptoOutputStream(new FileOutputStream("C:\\dir2\\test.bin"), key);

        Object o = objin.readObject();
        System.out.println(o);
        objout.writeObject("Hello too))");

        out.flush();
        out.close();
        in.close();

    }
}