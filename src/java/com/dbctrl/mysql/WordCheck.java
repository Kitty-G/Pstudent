/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbctrl.mysql;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author KittyG
 */
public class WordCheck {
    public int numcharCheck(String str){
        char[] c=str.toCharArray();
        for(int i=0;i<c.length;i++){
            if((48<=c[i] && c[i]<=57)||(65<=c[i] && c[i]<=90)||(97<=c[i] && c[i]<=122)){
                continue;
            }else{
                return i;
            }
        }
        return -1;
    }
    public int numCheck(String str){
        char[] c=str.toCharArray();
        for(int i=0;i<c.length;i++){
            if(48<=c[i] && c[i]<=57){
                continue;
            }else{
                return i;
            }
        }
        return -1;
    }
}
