/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.Exception.ConvertException;
import com.javabean.tools.Convert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KittyG
 */
public class ActivityAttendee {

    public enum SignupStatus {
        Dispensable,
        NotApplied,
        UnderReview,
        Rejected,
        Approved
    }

    public enum GetDataMethod {
        UserId,
        ActivityId
    }
    private String activityId;
    private String userId;
    private SignupStatus signupStatus;
    private Date createTime;

    public ActivityAttendee() {

    }

    public ActivityAttendee(String activityId, String userId, SignupStatus signupStatus, Date createTime) {
        this.activityId = activityId;
        this.userId = userId;
        this.signupStatus = signupStatus;
        this.createTime = createTime;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SignupStatus getSignupStatus() {
        return signupStatus;
    }

    public void setSignupStatus(SignupStatus signupStatus) {
        this.signupStatus = signupStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ActivityAttendee> GetActivityAttendeeList(String id, GetDataMethod getDataMethod) {
        List<ActivityAttendee> attendeeList;
        ActivityAttendee attendeeTemp;
        SQLOperate sqlOperate;
        ResultSet rs;
        String sql;
        try {
            attendeeList = new ArrayList<>();
            sqlOperate = new SQLOperate();
            if (getDataMethod == GetDataMethod.ActivityId) {
                sql = "SELECT * FROM ACTIVITYATTENDEE WHERE ACTIVITYID = ?";
            } else {
                sql = "SELECT * FROM ACTIVITYATTENDEE WHERE USERID = ?";
            }
            rs = sqlOperate.Query(sql, id);
            while (rs.next()) {
                try {
                    attendeeTemp = new ActivityAttendee();
                    attendeeTemp.activityId = rs.getString("ACTIVITYID");
                    attendeeTemp.userId = rs.getString("USERID");
                    attendeeTemp.signupStatus = SignupStatus.values()[rs.getInt("SIGNUPSTATUS")];
                    attendeeTemp.createTime = Convert.ConvertStringToDate(rs.getString("CREATETIME"), Convert.TimeFormat.HHMMSS);
                    attendeeList.add(attendeeTemp);
                } catch (SQLException | ConvertException ex) {
                    //log
                }
            }
        } catch (Exception ex) {
            //log
            attendeeList = null;
        }
        return attendeeList;
    }

}
