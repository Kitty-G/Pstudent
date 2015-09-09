/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb.register;

import com.mysql.conndb.MySQLOperate;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class DBRegisterInsert extends MySQLOperate{
    private String id;
    private String usr;
    private String pwd;
    public DBRegisterInsert(String stdid,String username,String password){
        super("p_student","writer","aptx4869");
        id=stdid;
        usr=username;
        pwd=password;
    }
    public int InfoInsert() throws SQLException{
        String sql="insert into login values('"+id+"','"+usr+"','"+pwd+"',1);";
//        sql="insert into login values('1205010000','bingo00','123456',2)";
        if(!super.InsertSQL(sql)){
            return 1;
        }
        sql="insert into d_info(stdid,login_time) values ('"+id+"',curdate())";
       if(!super.InsertSQL(sql)){
            return 2;
        }                                                                       //return 2
        sql="insert into p_info(stdid) values ("+id+")";                      //return 3
        if(!super.InsertSQL(sql)){
            return 3;
        }
        return 0;
    }
    
    public void CloseDB() throws SQLException{
        super.ConnectClose();
    }
}
