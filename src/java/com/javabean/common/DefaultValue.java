/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.common;

import com.javabean.tools.Convert;
import com.javabean.tools.Convert.TimeFormat;
import com.javabean.common.Exception.EnumInvalidException;
import java.util.Date;

/**
 *
 * @author zxli
 */
public class DefaultValue {

    public static String StudentPassword = "12345678";
    public static String AdministratorPassword = "dlpuadmin";

    public String AutomaticColumnMapping(SelectField field) throws Exception {
        String defaultValue = null;
        try {
            switch (field.getInternalName()) {
                case "CreateTime":
                    Date date = new Date();
                    defaultValue = Convert.ConvertDateToString(date, TimeFormat.YYYYMMDDHHMMSS);
                    break;
                default:
                    throw new EnumInvalidException();
            }
        } catch (Exception e) {

        }
        return defaultValue;
    }
}
