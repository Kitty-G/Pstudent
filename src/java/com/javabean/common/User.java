/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.common;

import java.util.Date;

/**
 *
 * @author KittyG
 */
public abstract class User {

    public enum Identity {
        Visitor,
        User,
        Administrator,
        SuperAdministrator
    }

    public enum Gender {
        Unknown,
        Male,
        Female
    }
    private String userId;
    private String userName;
    private Identity identity;
    private Gender gender;
    private Date createTime;

    public User() {

    }

    public User(String userId, String userName, Identity identity, Gender gender, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.identity = identity;
        this.gender = gender;
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
