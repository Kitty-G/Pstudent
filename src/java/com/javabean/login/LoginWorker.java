/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.login;

import com.javabean.common.User.Identity;
import com.javabean.tables.Login;
import com.javabean.tools.Convert;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KittyG
 */
public class LoginWorker {

    private Login login;

    public LoginWorker() {

    }

    public LoginWorker(String userId, String password, Identity identity) {
        try {
            this.login = new Login(userId, Convert.ConvertStringTo32BitMD5String(password), identity);
        } catch (Exception ex) {
            Logger.getLogger(LoginWorker.class.getName()).log(Level.SEVERE, null, ex);
            login = null;
        }
    }

    public LoginWorker(String userId, String password, String userName, Identity identity) {
        try {
            this.login = new Login(userId, Convert.ConvertStringTo32BitMD5String(password), userName, identity);
        } catch (Exception ex) {
            Logger.getLogger(LoginWorker.class.getName()).log(Level.SEVERE, null, ex);
            login = null;
        }
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean LoginChecker() {
        boolean result;
        Login loginChecker;
        loginChecker = login.GetLoginInfo(login.getUserId(), login.getIdentity());
        result = false;
        if (login == null || loginChecker.getUserId() == null) {
            return false;
        }
        if (loginChecker.getMd5Password().equals(this.login.getMd5Password())) {
            result = true;
            this.login.setUserName(loginChecker.getUserName());
            this.login.setIdentity(loginChecker.getIdentity());
        }
        return result;
    }
}
