/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb;

import java.sql.*;   

public class MySQLConnector {
        private String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        private String url;
        // MySQL配置时的用户名
//        private String SQL_User = "root";
//        // Java连接MySQL配置时的密码
//        private String SQL_Password = "aptx4869";
        private Connection conn;
    public MySQLConnector(String database,String SQL_User,String SQL_Password) {
        try {
        // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            url="jdbc:mysql://127.0.0.1:3306/"+database;
            conn = DriverManager.getConnection(url, SQL_User, SQL_Password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
        } catch(ClassNotFoundException e){
          System.out.println("Sorry,can`t find the Driver!");   e.printStackTrace();
      } catch(SQLException e){
          e.printStackTrace();
       } catch(Exception e) {  
           e.printStackTrace(); 
       }
   }
    
    public Connection getConnecter(){
        return conn;
    }
    
    public static void main(String[] args) {
        MySQLConnector Connector=new MySQLConnector("worker","root","aptx4869");
    }

}
