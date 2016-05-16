/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.administrator;

import com.javabean.common.User.Gender;
import com.javabean.common.User.Identity;
import com.javabean.tables.Administrator;
import com.javabean.tables.Administrator.ManageLevel;
import com.javabean.tables.Login;
import com.javabean.tools.Convert;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KittyG
 */
public class AdministratorWorker {

    private Login login;
    private Administrator administrator;

    public AdministratorWorker(String userId, String password, String userName, Identity identity, Gender gender, ManageLevel manageLevel, String telephone, String email) {
        try {
            this.login = new Login(userId, Convert.ConvertStringTo32BitMD5String(password), userName, identity);
            this.administrator = new Administrator(userId, userName, identity, gender, new Date(), manageLevel, telephone, email);
        } catch (Exception ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            login = null;
            administrator = null;
        }
    }

    public boolean AddAdministrator() {
        //need lock connection
        boolean result;
        result = this.login.AddLoginInfo();
        if (result) {
            result = this.administrator.AddAdministratorInfo();
        }
        return result;
    }
}
