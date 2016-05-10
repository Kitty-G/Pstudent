/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.javabean.common.User;

/**
 *
 * @author KittyG
 */
public class Administrator extends User {

    public enum ManageLevel {
        Undefined,
        Major,
        Academy,
        University
    }
    private ManageLevel manageLevel;
    private String telephone;
    private String email;

    public ManageLevel getManageLevel() {
        return manageLevel;
    }

    public void setManageLevel(ManageLevel manageLevel) {
        this.manageLevel = manageLevel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
