/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.Notice;
import com.javabean.tools.Convert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zxli
 */
public class Activity extends Notice {

    public enum ActivityType {
        Attend,
        Vote,
    }

    public enum IdentityLevel {
        Anyone,
        Student,
        NeedyStudent
    }

    private ActivityType activityType;
    private IdentityLevel identityLevel;
    private int limitPeopleNumber;

    public Activity() {

    }

    public Activity(String noticeId, String noticeTitle, String noticeContent, String adminId, NoticeType noticeType, NoticeStatus noticeStatus, int imageCount, Date createTime, ActivityType activityType, IdentityLevel identityLevel, int limitPeopleNumber) {
        super(noticeId, noticeTitle, noticeContent, adminId, noticeType, noticeStatus, imageCount, createTime);
        this.activityType = activityType;
        this.identityLevel = identityLevel;
        this.limitPeopleNumber = limitPeopleNumber;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public IdentityLevel getIdentityLevel() {
        return identityLevel;
    }

    public void setIdentityLevel(IdentityLevel identityLevel) {
        this.identityLevel = identityLevel;
    }

    public int getLimitPeopleNumber() {
        return limitPeopleNumber;
    }

    public void setLimitPeopleNumber(int limitPeopleNumber) {
        this.limitPeopleNumber = limitPeopleNumber;
    }

    public Activity GetNewsInfo(String noticeId) {
        Activity activity;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM ACTIVITY WHERE NOTICEID = ? ";
        SQLOperate sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, noticeId);
        try {
            activity = new Activity();
            while (rs.next()) {
                activity.setNoticeId(rs.getString("NOTICEID"));
                activity.setNoticeTitle(rs.getString("NOTICETITLE"));
                activity.setNoticeContent(rs.getString("NOTICECONTENT"));
                activity.setAdminId(rs.getString("ADMINID"));
                activity.setNoticeType(NoticeType.values()[rs.getInt("NOTICETYPE")]);
                activity.setNoticeStatus(NoticeStatus.values()[rs.getInt("NOTICESTATUS")]);
                activity.setImageCount(rs.getInt("IMAGECOUNT"));
                activity.setCreateTime(rs.getTimestamp("CREATETIME"));
                activity.activityType = ActivityType.values()[rs.getInt("ACTIVITYTYPE")];
                activity.identityLevel = IdentityLevel.values()[rs.getInt("IDENTITYLEVEL")];
                activity.limitPeopleNumber = rs.getInt("LIMITPEOPLENUMBER");
            }
        } catch (SQLException ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return activity;
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
            affectCount = sqlOperate.Insert("ACTIVITY", values);
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
            values.add(Convert.EnumToString(this.activityType));
            values.add(Convert.EnumToString(this.identityLevel));
            values.add(String.valueOf(this.limitPeopleNumber));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
