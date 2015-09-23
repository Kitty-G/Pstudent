/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb.login;

import com.mysql.conndb.MySQLOperate;
import com.mysql.conndb.tools.Security;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class DBLoginQuery extends MySQLOperate{
    private ResultSet rs;
    private boolean check=false;
    private String usr=null;
    private String pwd=null;
    public DBLoginQuery(String user,String password){
        super("p_student","reader","aptx4869");
//        WordCheck wordcheck=new WordCheck(); 
        usr=user;
        pwd=password;
        }
    
    
    public int Check() throws SQLException{
        rs=super.ConditionQuery("login","stdid",usr);
        if(rs.next()){
            Security s=new Security();
            pwd=s.MD5_Bit32(pwd);
            if(rs.getString("password").equals(pwd)){
                return this.getPower();
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }
    
    public String getUsername() throws SQLException{
        return rs.getString("username");
    }
    public int getPower() throws SQLException{
        return rs.getInt("power");
    }
    public void CloseDB() throws SQLException{
        rs.close();
        super.ConnectClose();
    }
}
