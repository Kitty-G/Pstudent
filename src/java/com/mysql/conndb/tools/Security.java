/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KittyG
 */
public class Security {
    public String MD5_Bit32(String source){
        MessageDigest m;
        String source_result=null;
        byte[] source_toByte;
        byte[] source_MD5Byte;
        try {
            source_toByte=source.getBytes("UTF-8");
            m=MessageDigest.getInstance("MD5");
            m.reset();
            m.update(source_toByte);
            source_MD5Byte=m.digest();
            source_result=ByteToHexString(source_MD5Byte);
        }catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        return source_result;
    }
    private static String ByteToHexString(byte[] data){
        StringBuilder s=new StringBuilder();
//        for(byte i:data){
//            s.append(Integer.toHexString(0xff & i));
//        }
//        for (int i = 0; i < data.length; i++) {
//            s.append(Integer.toHexString(0xff & data[i]));
//        }
        for(int i = 0;i<data.length;i++){
            String hex = Integer.toHexString(0xff & data[i]);
            if(hex.length() == 1)
                s.append('0');
            s.append(hex);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Security().MD5_Bit32("abc"));
    }
}
