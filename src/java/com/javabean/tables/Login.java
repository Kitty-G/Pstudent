/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.User.Identity;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class Login {

    private String userId;
    private String md5Password;
    private String userName;
    private Identity identity;

    public Login() {

    }

    public Login(String userId, String md5Password) {
        this.userId = userId;
        this.md5Password = md5Password;
    }

    public Login(String userId, String md5Password, String userName, Identity identity) {
        this.userId = userId;
        this.md5Password = md5Password;
        this.userName = userName;
        this.identity = identity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMd5Password() {
        return md5Password;
    }

    public void setMd5Password(String md5Password) {
        this.md5Password = md5Password;
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

    public Login GetLoginInfo(String userId) {
        Login login;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM NEWS WHERE USERID = ? ";
        SQLOperate sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, userId);
        try {
            login = new Login();
            while (rs.next()) {
                login.userId = rs.getString("USERID");
                login.md5Password = rs.getString("MD5PASSWORD");
                login.userName = rs.getString("USERNAME");
                login.identity = Identity.values()[rs.getInt("IDENTITY")];
            }
        } catch (SQLException ex) {
            //need log
            return null;
        }
        return login;
    }

}
