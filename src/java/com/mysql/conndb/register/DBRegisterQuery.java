/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb.register;

import com.mysql.conndb.MySQLOperate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class DBRegisterQuery extends MySQLOperate{
    private String user;
    private String id;
    private ResultSet rs;
    public DBRegisterQuery(String stdid,String username){
        super("p_student","reader","aptx4869");
        id=stdid;
        user=username;
    }
    public boolean IDExistCheck() throws SQLException{
        rs=super.ConditionQuery("login","stdid",id);
        if(rs.next()){
            if(rs.getString("stdid").equals(id)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public boolean NameExistCheck() throws SQLException{
        rs=super.ConditionQuery("login","username", user);
        if(rs.next()){
            if(rs.getString("username").equals("user")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void CloseDB() throws SQLException{
        rs.close();
        super.ConnectClose();
    }
}
