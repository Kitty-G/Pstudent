/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.login;

import com.javabean.common.Exception.ConvertException;
import com.javabean.common.User.Identity;
import com.javabean.tables.Login;
import com.javabean.tools.Convert;

/**
 *
 * @author KittyG
 */
public class LoginWorker {

    private String userId;
    private String password;
    private String userName;
    private Identity identity;

    public LoginWorker() {

    }

    public LoginWorker(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public LoginWorker(String userId, String password, String userName, Identity identity) {
        this.userId = userId;
        this.password = password;
        this.identity = identity;
    }

    public boolean LoginChecker() {
        Convert convert;
        Login login;
        boolean result;
        login = new Login(userId);
        convert = new Convert();
        login = login.getLoginInfo();
        result = false;
        try {
            if (login == null) {
                return false;
            }
            if (login.getMd5Password().equals(convert.ConvertStringTo32BitMD5String(password))) {
                result = true;
                this.userName = login.getUserName();
                this.identity = login.getIdentity();
            }
        } catch (ConvertException e) {
            result = false;
        } catch (Exception e) {
            result = false;
            //Need log info
        }
        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
