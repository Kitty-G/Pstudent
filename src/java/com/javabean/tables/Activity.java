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

    public List<Activity> GetNoticeIndexInfo(int ignoreNumber, int returnNumber) {
        List<Activity> activityList;
        ResultSet rs;
        List<String> queryList;
        String sql;

        sql = "SELECT NOTICEID,NOTICETITLE,NOTICESTATUS,CREATETIME FROM ? ORDER BY CREATETIME LIMIT ?,?";
        queryList = new ArrayList();
        queryList.add("ACTIVITY");
        queryList.add(String.valueOf(ignoreNumber));
        queryList.add(String.valueOf(returnNumber));
        SQLOperate sqlOperate = new SQLOperate();

        activityList = new ArrayList();
        rs = sqlOperate.Query(sql, queryList);
        try {
            Activity activityTemp;
            while (rs.next()) {
                try {
                    activityTemp = new Activity();
                    activityTemp.setNoticeId(rs.getString("NOTICEID"));
                    activityTemp.setNoticeTitle(rs.getString("NOTICETITLE"));
                    activityTemp.setNoticeContent(rs.getString("NOTICECONTENT"));
                    activityTemp.setAdminId(rs.getString("ADMINISTRATORID"));
                    activityTemp.setNoticeType(NoticeType.values()[rs.getInt("NOTICETYPE")]);
                    activityTemp.setNoticeStatus(NoticeStatus.values()[rs.getInt("NOTICESTATUS")]);
                    activityTemp.setImageCount(rs.getInt("IMAGECOUNT"));
                    activityTemp.setCreateTime(rs.getTimestamp("CREATETIME"));
                    activityTemp.activityType = ActivityType.values()[rs.getInt("ACTIVITYTYPE")];
                    activityTemp.identityLevel = IdentityLevel.values()[rs.getInt("IDENTITYLEVEL")];
                    activityTemp.limitPeopleNumber = rs.getInt("LIMITPEOPLENUMBER");
                    activityList.add(activityTemp);
                } catch (SQLException ex) {
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return activityList;
    }

    public Activity GetActivityInfo(String noticeId) {
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

    public boolean AddActivityInfo() {
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
            values.add(Convert.EnumToIntString(this.getNoticeType()));
            values.add(Convert.EnumToIntString(this.getNoticeStatus()));
            values.add(String.valueOf(this.getImageCount()));
            values.add(Convert.ConvertDateToString(this.getCreateTime(), Convert.TimeFormat.YYYYMMDDHHMMSS));
            values.add(Convert.EnumToIntString(this.activityType));
            values.add(Convert.EnumToIntString(this.identityLevel));
            values.add(String.valueOf(this.limitPeopleNumber));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
