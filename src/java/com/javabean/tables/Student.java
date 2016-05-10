/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.User;
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
public class Student extends User {

    private int grade;
    private String majorCode;
    private int classNo;
    private Date intendedTime;

    public Student() {

    }

    public Student(String userId, String userName, Identity identity, Gender gender, Date createTime, int grade, String majorCode, int classNo, Date intendedTime) {
        super(userId, userName, identity, gender, createTime);
        this.grade = grade;
        this.majorCode = majorCode;
        this.classNo = classNo;
        this.intendedTime = intendedTime;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public Date getIntendedTime() {
        return intendedTime;
    }

    public void setIntendedTime(Date intendedTime) {
        this.intendedTime = intendedTime;
    }

    public Student GetStudentInfo(String userId) {
        Student student;
        SQLOperate sqlOperate;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM STUDENT WHERE USERID = ? ";
 sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, userId);
        try {
            student = new Student();
            while (rs.next()) {
                student.setUserId(rs.getString("USERID"));
                student.setUserName(rs.getString("USERNAME"));
                student.setIdentity(Identity.values()[rs.getInt("IDENTITY")]);
                student.setGender(Gender.values()[rs.getInt("GENDER")]);
                student.setCreateTime(rs.getTimestamp("CREATETIME"));
                student.setGrade(rs.getInt("GRADE"));
                student.setMajorCode(rs.getString("MAJORCODE"));
                student.setClassNo(rs.getInt("CLASSNO"));
                student.setIntendedTime(rs.getTimestamp("INTENDEDTIME"));
            }
        } catch (SQLException ex) {
            //log
            return null;
        }
        return student;
    }

    public boolean AddStudentInfo() {
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
            affectCount = sqlOperate.Insert("STUDENT", values);
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
            values.add(this.getUserId());
            values.add(this.getUserName());
            values.add(Convert.EnumToIntString(this.getIdentity()));
            values.add(Convert.EnumToIntString(this.getGender()));
            values.add(Convert.ConvertDateToString(this.getCreateTime(), Convert.TimeFormat.YYYYMMDDHHMMSS));
            values.add(String.valueOf(this.grade));
            values.add(this.majorCode);
            values.add(String.valueOf(this.classNo));
            values.add(Convert.ConvertDateToString(this.intendedTime, Convert.TimeFormat.YYYYMMDDHHMMSS));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }

}
