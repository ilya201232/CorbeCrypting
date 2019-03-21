package com.corbie.DES;


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Crypting {

    public static void main(String[] argv){
        try {
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            DesEncrypter encrypter = new DesEncrypter(key);
            String encrypted = encrypter.encrypt("ЛОЛ а ты прикольный");
            String decrypted = encrypter.decrypt(encrypted);

            System.out.println(encrypted + " ___________________ " + decrypted);
        }
        catch (Exception e){
            e.printStackTrace();
        }




    }
}
