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
    public WordCheck(String word,int num){
        
    }
    public WordCheck(List list,int num){
        String str;
        switch(num){
            case 1:
                for(Iterator i = list.iterator();i.hasNext(); ){
                    str = (String) i.next();
                    numcharCheck(str);
                }
                break;
            default:break;
        }
    }
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
