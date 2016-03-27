package com.javabean.login;

import com.mysql.conndb.WordCheck;
import com.mysql.conndb.login.DBLoginQuery;
import java.sql.SQLException;

public class Login{
    private String usr;
    private String username=null;
    private String pwd;
    private int character;
    public Login(){
        usr=null;
        pwd=null;
    }

    public Login(String usr,String pwd,int character){
        this.usr=usr;
        this.pwd=pwd;
        this.character=character;
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
    
    public String getUsername(){
        return username;
    }
    
    public int loginVerify() throws SQLException{
        WordCheck wc=new WordCheck(); 
        DBLoginQuery lq=new DBLoginQuery(usr,pwd);
        int power;
        int checkResult;
        if(wc.numcharCheck(usr)==-1){
            checkResult=lq.Check(character);
            if(checkResult>0){
                power=checkResult;
                username=lq.getUsername();
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
