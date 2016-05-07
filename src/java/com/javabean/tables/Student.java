/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.javabean.common.User;
import java.util.Date;

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

}
