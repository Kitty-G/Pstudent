package com.javabean.login;

import com.dbctrl.mysql.WordCheck;
import com.mysql.conndb.login.DBLoginQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class login{
    private String usr;
    private String pwd;
    public login(){
        usr=null;
        pwd=null;
    }

    public login(String user,String password){
        usr=user;
        pwd=password;
    }
    public String getUsr() {
        return usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public int loginVerify(String user,String password){
        List list=new ArrayList();
        list.add(user);
        list.add(password);
        WordCheck wc=new WordCheck(list,1); 
        DBLoginQuery lq=new DBLoginQuery(user,password);
        if(true){
            
        }
        return 0;
    }
}
