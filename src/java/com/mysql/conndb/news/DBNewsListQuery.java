/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb.news;

import com.javabean.news.NewsInfo;
import com.mysql.conndb.MySQLOperate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class DBNewsListQuery extends MySQLOperate{
    private ResultSet rs;
    
    public DBNewsListQuery(){
        super("p_student","reader","aptx4869");
    }
    public NewsInfo[] NewsList() throws SQLException{
        NewsInfo[] ni;
        String sql;
        sql="select news_id,news_name,news_time from news";
        rs=super.SQLQuery(sql);
        ni=new NewsInfo[rs.getRow()];
        for(int i=0;i<ni.length;i++){
            ni[i].setNews_id(rs.getString("newsid"));
            ni[i].setNews_name(rs.getString("newsname"));
            ni[i].setNews_time(rs.getString("newstime"));
            ni[i].setNews_path(rs.getString("newspath"));
            rs.next();
        }
        return ni;
    }
}
