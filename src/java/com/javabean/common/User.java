/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.common;

/**
 *
 * @author KittyG
 */
public class User {
    public enum Identity{
        User,
        Administrator,
        SuperAdministrator
    }
    public enum Gender{
        Unknown,
        Male,
        Female
    }
    private String userId;
    private String name;
    private Identity identity;
    private Gender gender;
    private String permission;      //Need Class Permission
}
