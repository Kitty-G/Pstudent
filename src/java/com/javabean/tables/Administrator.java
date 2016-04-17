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

    public enum ManagementLevel {
        University,
        Academy,
        Major
    }
    private ManagementLevel managementLevel;
    private String telephone;
    private String email;
}
