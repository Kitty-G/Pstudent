/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbctrl.mysql;

import com.mysql.conndb.*;
import java.sql.SQLException;

/**
 *
 * @author Silver
 */
public class RegisterInsert  extends MySQLOperate{
    public RegisterInsert(String user,String password) throws SQLException {
        super("worker","root","aptx4869");
        try {
            super.Insert("information", "'"+user+"','"+password+"',current_date,'user'");
            super.Insert("login_data", "'"+user+"',current_date,0");
        }catch(SQLException e){
          e.printStackTrace();
       } catch(Exception e) {  
           e.printStackTrace(); 
       }finally{
            super.ConnectClose();
        }
   }
}
