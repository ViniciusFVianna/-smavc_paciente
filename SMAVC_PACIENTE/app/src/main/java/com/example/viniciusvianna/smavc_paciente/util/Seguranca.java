package com.example.viniciusvianna.smavc_paciente.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ViniciusVianna on 27/07/2017.
 */

public class Seguranca {

    private static MessageDigest md = null;

    static{
        try{
            md = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
    }//fecha static

    private static char[] hexCodes(byte[] text){
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i <text.length; i++){
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput , i * 2);
        }
        return  hexOutput;
    }
    public static  String criptografar(String pwd){
        if (md !=null){
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }
}//fecha classe
