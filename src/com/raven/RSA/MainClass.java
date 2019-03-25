package com.raven.RSA;

import java.math.BigInteger;

public class MainClass {

    /** Trivial test program. */
    public static void main(String[] args) {
        RSA rsa = new RSA(2048);

        String text1 = "Hey! What's up? man man man man man man man man man man " +
                "man man man man man man man man man man man man man man man man man man man man" +
                "man man man man man man man man man man man man";
        System.out.println("Plaintext: " + text1);
        BigInteger plaintext = new BigInteger(text1.getBytes());

        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);
        plaintext = rsa.decrypt(ciphertext);

        String text2 = new String(plaintext.toByteArray());
        System.out.println("Plaintext: " + text2 + ' ' + text1.length());
    }
}
