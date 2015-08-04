/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class MySQLOperate extends MySQLConnector{
     private String sql;
     private Statement statement;
     private ResultSet rs;
     private Connection conn;
    public MySQLOperate(String database,String SQL_User,String SQL_Password) {
        super(database,SQL_User,SQL_Password);
    }
    public ResultSet ConditionQuery(String table,String columnName,String limit) throws SQLException{
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="select * from "+table+" where "+columnName+"='"+limit+"';";
        rs = statement.executeQuery(sql);
        return rs;
    }
    public ResultSet AllQuery(String table) throws SQLException{
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="select * from "+table+";";
        rs = statement.executeQuery(sql);
        return rs;
    }
    public boolean QueryCheck(String table,String columnName,String limit) throws SQLException{
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="select * from "+table+" where "+columnName+"='"+limit+"';";
        rs = statement.executeQuery(sql);
        while(rs.next()){
            if(rs.getString(columnName).equals(limit)){
                System.out.println("success");
                return true;
            }
        }
        return false;
    }
    
    public String[] QueryColname(String table) throws SQLException{
        String[] colName;
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="select * from "+table+";";
        rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd=rs.getMetaData();
        colName=new String[rsmd.getColumnCount()];
        System.out.println(colName.length);
        for (int i = 0; i <colName.length; i++) {
            colName[i]=rsmd.getColumnName(i+1);
        }
        return colName;
    }
    
    public boolean Insert(String table,String values) throws SQLException{
        int affected;
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="insert into "+table+" values ("+values+");";
        affected=statement.executeUpdate(sql);
        if(affected>0)return true;
        else return false;
    }
    public boolean Update (String table,String target,String values,String columnName,String limit) throws SQLException{
        int affected;
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="update "+table+" set "+target+"="+values+" where "+columnName+" = '"+limit+"';";
        affected=statement.executeUpdate(sql);
        if(affected>0)return true;
        else return false;
    }
    public boolean Delete (String table,String columnName,String limit) throws SQLException{
        int affected;
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="delete from "+table+" where "+columnName+"='"+limit+"';";
        affected=statement.executeUpdate(sql);
        if(affected>0)return true;
        else return false;
    }
    public int RowsCount(String table) throws SQLException{
        int rows=0;
        conn=super.getConnecter();
        statement = conn.createStatement();
        sql="select * from "+table+";";
        rs = statement.executeQuery(sql);
        while(rs.next()){
            rows++;
        }
        return rows;
    }
    
    public ResultSet SQLQuery(String SQLStatement) throws SQLException{
        conn=super.getConnecter();
        statement = conn.createStatement();
        rs=statement.executeQuery(SQLStatement);
        return rs;
    }
    public int SQLUpdate(String SQLStatement) throws SQLException{
        conn=super.getConnecter();
        statement = conn.createStatement();
        return statement.executeUpdate(SQLStatement);
    }
    public void ConnectClose() throws SQLException{
        conn.close();
    }
    public void ResultSetClose() throws SQLException{
        rs.close();
    }
}
