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
public class ChangePassword  extends MySQLOperate{
    
    private boolean result=false;
    public ChangePassword(String user,String password) throws SQLException {
        super("worker","root","aptx4869");
        try {
            if(super.Update("information", "password",password, "user", user)){
                result=true;
            }
        } catch(SQLException e){
          e.printStackTrace();
       } catch(Exception e) {  
           e.printStackTrace(); 
       }finally{
            super.ConnectClose();
        }
   }
   public boolean getResult(){
       return result;
   }
}
