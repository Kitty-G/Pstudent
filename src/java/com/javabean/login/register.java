/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.login;

import com.mysql.conndb.register.DBRegisterInsert;
import com.mysql.conndb.register.DBRegisterQuery;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class register {
    private String stdid;
    private String usr;
    private String pwd;
    private String time;
    public register(String id,String username,String password){
        stdid=id;
        usr=username;
        pwd=password;
    }

    public String getStdid() {
        return stdid;
    }

    public String getUsr() {
        return usr;
    }

    public String getPwd() {
        return pwd;
    }

    public String getTime() {
        return time;
    }
            
    public int UserIDQuery() throws SQLException{
//        WordCheck
        DBRegisterQuery rq=new DBRegisterQuery(stdid,usr);
        int result;
        if(!rq.IDExistCheck()){
            if(!rq.NameExistCheck()){
               result=0;                                                        //用户名密码都不存在返回0
            }else{
                result=2;                                                       //用户名存在返回2
            }
        }else{
            result=1;                                                           //学号存在返回1
        }
        rq.CloseDB();
        return result;
    }
    
    public int InfoInsert() throws SQLException{
        DBRegisterInsert ri=new DBRegisterInsert(stdid,usr,pwd);
        int result=ri.InfoInsert();
        ri.CloseDB();
        return result;
    }
}
