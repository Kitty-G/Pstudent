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
public class EnumInvalidException extends Exception{
    public EnumInvalidException(){
        super("Enum is invalid");
    }
}
