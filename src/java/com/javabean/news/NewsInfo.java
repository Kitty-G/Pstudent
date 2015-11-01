/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.news;

/**
 *
 * @author KittyG
 */
public class NewsInfo {
    private String news_id;
    private String news_name;
    private String news_time;
    private String news_path;

    public NewsInfo(String news_id,String news_name,String news_time,String news_path){
        this.news_id=news_id;
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

    public String getNews_name() {
        return news_name;
    }

    public void setNews_name(String news_name) {
        this.news_name = news_name;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }
    
    public String getNews_path() {
        return news_path;
    }

    public void setNews_path(String news_path) {
        this.news_path = news_path;
    }
}
