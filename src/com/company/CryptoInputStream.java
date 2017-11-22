package com.company;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {

    public String key;

    protected CryptoInputStream(InputStream in, String key) {
        super(in);
        this.key=key;
    }

    @Override
    public int read() throws IOException {
        byte[] keyBytes = key.getBytes();
        int onebyte = read();
        byte [] newByte = new byte[]{((byte) ((byte)onebyte^keyBytes[0]))};
        return super.read(newByte);
    }

    @Override
    public int read(byte[] b) throws IOException {
        byte[] keyBytes = key.getBytes();
        byte[] crypted = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            crypted[i] = (byte) (b[i] ^ keyBytes[i % keyBytes.length]);
        }
        return super.read(crypted);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        byte[] keyBytes = key.getBytes();
        byte[] crypted = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            crypted[i] = (byte) (b[i] ^ keyBytes[i % keyBytes.length]);
        }
        return super.read(crypted, off, len);
    }
}
