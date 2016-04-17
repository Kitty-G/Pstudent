/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tools;

import com.javabean.common.Exception.ConvertException;
import com.javabean.common.Exception.ConvertException.ConvertExceptionType;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author zxli
 */
public class Convert {

    public enum TimeFormat {
        YYYYMMDDHHMMSS,
        YYYYMMDD,
        HHMMSS
    }

    public String ConvertDateToTime(Date date, TimeFormat timeFormat) throws Exception {

        String format;
        SimpleDateFormat simpleDateFormat;
        try {
            format = getTimeFormatString(timeFormat);
            simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            throw new ConvertException(ConvertException.getMessage(ConvertExceptionType.DateToTime), ConvertExceptionType.DateToTime);
        }
    }

    public Date ConvertTimeToDate(String time, TimeFormat timeFormat) throws ConvertException {
        String format;
        SimpleDateFormat simpleDateFormat;
        try {
            format = getTimeFormatString(timeFormat);
            simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(time);
        } catch (Exception e) {
            throw new ConvertException(ConvertException.getMessage(ConvertExceptionType.TimeToDate), ConvertExceptionType.TimeToDate);
        }
    }

    private String getTimeFormatString(TimeFormat timeFormat) {
        String format = null;
        switch (timeFormat) {
            case YYYYMMDDHHMMSS:
                format = "yyyy-MM-dd HH:mm:ss";
                break;
            case YYYYMMDD:
                format = "yyyy-MM-dd";
                break;
            case HHMMSS:
                format = "HH:mm:ss";
                break;
            default:
                break;
        }
        return format;
    }

    public String ConvertStringTo32BitMD5String(String string) throws Exception {
        String MD5String;
        MessageDigest messageDigest;
        byte[] stringByte;
        byte[] stringMD5Byte;
        try {
            stringByte = string.getBytes("UTF-8");
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(stringByte);
            stringMD5Byte = messageDigest.digest();
            MD5String = ByteToHexString(stringMD5Byte);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new ConvertException(ConvertException.getMessage(ConvertExceptionType.StringToBit32MD5), ConvertExceptionType.StringToBit32MD5);
        }

        return MD5String;
    }

    private String ByteToHexString(byte[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(0xff & data[i]);
            if (hex.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }
}
