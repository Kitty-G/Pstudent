/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.news;

import com.mysql.conndb.news.DBNewsListQuery;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author KittyG
 */
public class News {
    private String newsid;
    
    public News(){
        
    }
    public List getNewsList() throws SQLException{
        DBNewsListQuery nlq=new DBNewsListQuery();
        return nlq.NewsList();
    }
}
