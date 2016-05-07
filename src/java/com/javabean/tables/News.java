/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.Notice;
import com.javabean.tools.Convert;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KittyG
 */
public class News extends Notice {

    public News() {

    }

    public News(String noticeId, String noticeTitle, String noticeContent, String adminId, NoticeType noticeType, NoticeStatus noticeStatus, int imageCount, Date createTime) {
        super(noticeId, noticeTitle, noticeContent, adminId, noticeType, noticeStatus, imageCount, createTime);
    }

    public News GetNewsInfo(String noticeId) {
        News news;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM NEWS WHERE NOTICEID = ? ";
        SQLOperate sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, noticeId);
        try {
            news = new News();
            while (rs.next()) {
                news.setNoticeId(rs.getString("NOTICEID"));
                news.setNoticeTitle(rs.getString("NOTICETITLE"));
                news.setNoticeContent(rs.getString("NOTICECONTENT"));
                news.setAdminId(rs.getString("ADMINID"));
                news.setNoticeType(NoticeType.values()[rs.getInt("NOTICETYPE")]);
                news.setNoticeStatus(NoticeStatus.values()[rs.getInt("NOTICESTATUS")]);
                news.setImageCount(rs.getInt("IMAGECOUNT"));
                news.setCreateTime(rs.getTimestamp("CREATETIME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return news;
    }

    public boolean AddNewsInfo() {
        SQLOperate sqlOperate;
        List<String> values;
        boolean result;
        try {
            int affectCount;
            sqlOperate = new SQLOperate();
            values = ToValues();
            if (values == null) {
                return false;
            }
            affectCount = sqlOperate.Insert("News", values);
            result = affectCount == 1;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    private List<String> ToValues() {
        List<String> values;
        try {
            values = new ArrayList<>();
            values.add(this.getNoticeId());
            values.add(this.getNoticeTitle());
            values.add(this.getNoticeContent());
            values.add(this.getAdminId());
            values.add(Convert.EnumToString(this.getNoticeType()));
            values.add(Convert.EnumToString(this.getNoticeStatus()));
            values.add(String.valueOf(this.getImageCount()));
            values.add(Convert.ConvertDateToString(this.getCreateTime(), Convert.TimeFormat.YYYYMMDDHHMMSS));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
