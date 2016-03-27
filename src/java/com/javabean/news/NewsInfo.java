/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.news;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author KittyG
 */
public class NewsInfo {
    private String news_id;
    private String admin_id;
    private String news_name;
    private String news_time;
    private String news_path;

    public NewsInfo(){
        this.news_id="";
        this.admin_id="";
        this.news_name="";
        this.news_time="";
        this.news_path="";
    }
    
    public NewsInfo(String news_id,String admin_id,String news_name,String news_time,String news_path){
        this.news_id=news_id;
        this.admin_id=admin_id;
        this.news_name=news_name;
        this.news_time=news_time;
        this.news_path=news_path;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }
    
    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getNews_name() {
        return news_name;
    }

    public void setNews_name(String news_name) {
        this.news_name = news_name;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(Timestamp news_time) {
        int year=news_time.getYear()-100;
        if(news_time.getDay()/10==0)
            this.news_time=year+"-"+news_time.getMonth()+"-0"+news_time.getDay();
        else{
            this.news_time=year+"-"+news_time.getMonth()+"-"+news_time.getDay();
        }
    }
    
    public String getNews_path() {
        return news_path;
    }

    public void setNews_path(String news_path) {
        this.news_path = news_path;
    }
    
    public String getFormatNewsName(){
        String name;
        name=this.getNews_name();
        if(name.length()>30){
            name=name.substring(0, 30);
        }
        return name;
    }
}
