/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.common;

/**
 *
 * @author zxli
 */
//This class for html select form value and name
public class SelectField {
    public enum FieldLevel{
        Integral,
        Normal,
        Automatic
    }
    
    private String internalName;
    private String displayName;
    private FieldLevel fieldLevel;

    
    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public FieldLevel getFieldLevel() {
        return fieldLevel;
    }

    public void setFieldLevel(FieldLevel fieldLevel) {
        this.fieldLevel = fieldLevel;
    }

    public SelectField(String internalName,String displayName,FieldLevel fieldLevel) {
        this.internalName=internalName;
        this.displayName=displayName;
        this.fieldLevel=fieldLevel;
    }
}
