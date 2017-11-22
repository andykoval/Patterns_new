package com.company;

import java.util.Arrays;

/**
 * Created by andy on 21.11.2017.
 */
public class CryptoTest {

    public byte[] crypto(String word, String key) {
        byte[] wordBytes = word.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] cryptoBytes = new byte[word.length()];

        for (int i = 0; i < word.length(); i++) {
            cryptoBytes[i] = (byte) (wordBytes[i] ^ keyBytes[i % key.length()]);
        }
        return cryptoBytes;
    }

    public String unCrypto(byte[] b, String key) {
        byte[] keyBytes = key.getBytes();
        byte[] uncryptoBytes = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            uncryptoBytes[i] = (byte) (b[i] ^ keyBytes[i % key.length()]);
        }
        return new String(uncryptoBytes);
    }
//    public

    public static void main(String[] args) {
        String key = "pizanskaya bashnia";
        CryptoTest cryptoTest = new CryptoTest();
        System.out.println(cryptoTest.
                unCrypto(cryptoTest.crypto("Butterfly in the fire, welcome to our Country? gentlemens!", key), key));

    }

}
