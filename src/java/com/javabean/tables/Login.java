/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.User.Identity;
import com.javabean.tools.Convert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Login(String userId, String md5Password, Identity identity) {
        this.userId = userId;
        this.md5Password = md5Password;
        this.identity = identity;
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

    public Login GetLoginInfo(String userId, Identity identity) {
        SQLOperate sqlOperate;
        List<String> list;
        Login login;
        ResultSet rs;
        String sql;
        sqlOperate = new SQLOperate();
        list = new ArrayList<>();
        sql = "SELECT * FROM LOGIN WHERE USERID = ? AND IDENTITY = ? ";
        list.add(userId);
        list.add(Convert.EnumToIntString(identity));
        rs = sqlOperate.Query(sql, list);
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

    public boolean AddLoginInfo() {
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
            affectCount = sqlOperate.Insert("LOGIN", values);
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
            values.add(this.userId);
            values.add(this.md5Password);
            values.add(this.userName);
            values.add(Convert.EnumToIntString(this.identity));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
