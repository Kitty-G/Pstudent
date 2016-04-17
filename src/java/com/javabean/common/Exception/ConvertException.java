/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.common.Exception;

/**
 *
 * @author zxli
 */
public class ConvertException extends Exception {

    public ConvertException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum ConvertExceptionType {
        DateToTime,
        TimeToDate,
        StringToBit32MD5
    }
    private ConvertExceptionType convertExceptionType;

    public ConvertException(String message, ConvertExceptionType convertExceptionType) {
        super();
        this.convertExceptionType = convertExceptionType;
    }

    public ConvertExceptionType getConvertExceptionType() {
        return convertExceptionType;
    }

    public void setConvertExceptionType(ConvertExceptionType convertExceptionType) {
        this.convertExceptionType = convertExceptionType;
    }

    public static String getMessage(ConvertExceptionType convertExceptionType) {
        String message = null;
        switch (convertExceptionType) {
            case DateToTime:
                message = "Convert date to time failed";
                break;
            case TimeToDate:
                message = "Convert time and date failed";
                break;
            case StringToBit32MD5:
                message = "Convert string to bit 32 MD5 failed";
                break;
        }
        return message;
    }
}
