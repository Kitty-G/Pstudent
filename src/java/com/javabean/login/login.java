package com.javabean.login;

import com.dbctrl.mysql.WordCheck;
import com.mysql.conndb.login.DBLoginQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public int loginVerify() throws SQLException{
        WordCheck wc=new WordCheck(); 
        DBLoginQuery lq=new DBLoginQuery(usr,pwd);
        int power;
        int checkResult;
        if(wc.numcharCheck(usr)==-1){
            checkResult=lq.Check();
            if(checkResult>0){
                power=checkResult;
                lq.CloseDB();
                return power;
            }else if(checkResult==0){
                return 0;                                                       //pwd error
            }else if(checkResult==-1){
                return -1;                                                      //usr not exist
            }else{
                return -99;
            }
        }else{
            return -1;                                                          //usrname illegal
        }
    }
}
