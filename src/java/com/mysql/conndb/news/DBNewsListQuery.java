/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb.news;

import com.javabean.news.NewsInfo;
import com.mysql.conndb.MySQLOperate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author KittyG
 */
public class DBNewsListQuery extends MySQLOperate{
    private ResultSet rs;
    
    public DBNewsListQuery(){
        super("p_student","reader","aptx4869");
    }
    public List NewsList() throws SQLException{
        NewsInfo ni=new NewsInfo();
        int count=0;
        List list=new LinkedList();
        String sql;
        sql="select * from news";
        rs=super.SQLQuery(sql);
        // need rs row number 
        //array or list in the ni


        while(rs.next()){
            ni=new NewsInfo();
            ni.setNews_id(rs.getString("newsid"));
            ni.setNews_name(rs.getString("newsname"));
            ni.setNews_time(rs.getTimestamp("newstime"));
            ni.setNews_path(rs.getString("newspath"));
            list.add(ni);
        }
        return list;
    }
    
    public void CloseDB() throws SQLException{
        rs.close();
        super.ConnectClose();
    }
}
