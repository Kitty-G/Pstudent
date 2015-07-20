/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public class LoginSearch extends MySQLOperate{
     private ResultSet rs;
     private boolean check=false;

    public LoginSearch(String user,String password) throws SQLException {
        super("worker","root","aptx4869");
        try { 
            rs = super.ConditionQuery("information","user",user);
            rs.next();
            if(rs.getString("password").equals(password)){
                System.out.println("Check success");
                System.out.println(rs.getString("user") + "\t"+rs.getString("password"));
                check=true;
                if(
                super.Update("login_data","last_login", "current_date", "user", user)&&
                super.Update("login_data","login_times", "login_times+1", "user", user)
                )System.out.println("update success");
//                statement = conn.createStatement();
//                sql="update login_data set last_login=current_date,login_times=login_times+1 where user='"+user+"';";
//                statement.executeUpdate(sql); 
            }
         }catch(SQLException e){
//          e.printStackTrace();
//             System.out.println("user");
        }  catch(Exception e) {  
//           e.printStackTrace();
       } finally{
            super.ConnectClose();
            rs.close();
        }
   }
    public boolean getCheck(){
        return check;
    }

}
