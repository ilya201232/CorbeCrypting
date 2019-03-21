package com.corbie.DES;


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

public class Crypting {

    static void chat(String msg, SecretKey key) throws Exception{
        DesEncrypter encrypter = new DesEncrypter(key);
        String encrypted = encrypter.encrypt(msg);
        System.out.println("Зашифрованное сообщение >>> " + encrypted);
        String decrypted = encrypter.decrypt(encrypted);
        System.out.println("Расшифрованное сообщение >>> " + decrypted);
    }

    public static void main(String[] argv) throws Exception{
        Scanner sc = new Scanner(System.in);
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();


        System.out.print("Добро пожаловать в альфа версию мессенждера Corbie!\n" +
                "Для помощи введите help\n" +
                "Введите команду:\n");

        String com;
        boolean f = false;
        do{
            com = sc.next();
            switch (com) {
                case "help":
                    System.out.print("Возможные команды:\n" +
                            "help - вывод справки\n" +
                            "enter_msg - Ввод сообщения\n" +
                            "getSecKey - Вывод ключа шифрования\n" +
                            "getAlName - Вывод названия алгоритма\n" +
                            "EXIT - Выход\n");
                    break;
                case "enter_msg":
                    System.out.println("Введите сообщение:");
                    sc.useDelimiter("\n");
                    String msg = sc.next();
                    chat(msg, key);
                    f = true;
                    break;
                case "getSecKey":
                    System.out.println("Ваш ключ шифрования: " + key);
                    f = true;
                    break;
                case "getAlName":
                    System.out.println("DES");
                    f = true;
                    break;
                case "EXIT":
                    System.out.println("Пока!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверная команда. Повторите попытку");
                    break;
            }
        }while (f == false);
    }
}
