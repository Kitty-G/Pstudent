/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Silver
 */
public class AllSearch {
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/worker";
        // MySQL配置时的用户名
        String SQL_User = "root";
        // Java连接MySQL配置时的密码
        String SQL_Password = "aptx4869";
        String sql,target,data;
        Statement statement;
        ResultSet rs;
        Connection conn;
        boolean check=false;
        
    public AllSearch(String type,String input) {
        target=type;
        data=input;
    }
    public boolean SearchTarget(){
                try {
        // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            conn = DriverManager.getConnection(url, SQL_User, SQL_Password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            // statement用来执行SQL语句
            statement = conn.createStatement();
            // 要执行的SQL语句
            sql = "select "+target+" from Information where "+target+" ='"+data+"'";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(target).equals(data)){
                    System.out.println("success");
                    check=true;
                }
            }
            
            rs.close();  conn.close();
        } catch(ClassNotFoundException e){
          System.out.println("Sorry,can`t find the Driver!");   e.printStackTrace();
      } catch(SQLException e){
          e.printStackTrace();
       } catch(Exception e) {  
           e.printStackTrace(); 
       }finally{
                    return check;
                }
    }
    
    
}
