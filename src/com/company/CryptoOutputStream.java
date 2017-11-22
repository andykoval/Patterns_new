package com.company;

/**
 * Created by andy on 21.11.2017.
 */

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {

    public String key;

    protected CryptoOutputStream(OutputStream out, String key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {
        byte[] keyBytes = key.getBytes();
        int newb = (int) ((byte) b ^ keyBytes[0]);
        super.write(newb);
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte[] uncrypted = new byte[b.length];
        byte[] keyBytes = key.getBytes();
        for (int i = 0; i < b.length; i++) {
            uncrypted[i] = (byte) (b[i] ^ keyBytes[i % keyBytes.length]);
        }
        super.write(uncrypted);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        byte[] uncrypted = new byte[b.length];
        byte[] keyBytes = key.getBytes();
        for (int i = 0; i < b.length; i++) {
            uncrypted[i] = (byte) (b[i] ^ keyBytes[i % keyBytes.length]);
        }
        super.write(uncrypted, off, len);
    }
//    @Override
//    public int read() throws IOException {
//        byte[] keyBytes = key.getBytes();
//        int onebyte = read();
//        byte newByte = (byte) ((byte)onebyte^keyBytes[0]);
//        return super.read();
//    }
//
//    @Override
//    public int read(byte[] b) throws IOException {
//        byte[] keyBytes = key.getBytes();
//        byte[] crypted = new byte[b.length];
//        for (int i = 0; i < b.length; i++) {
//            crypted[i] = (byte) (b[i] ^ keyBytes[i % keyBytes.length]);
//        }
//        return super.read(crypted);
//    }


}