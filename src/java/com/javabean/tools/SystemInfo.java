/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tools;

import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zxli
 */
public class SystemInfo {

    public static String GetUniqueId() throws Exception {
        String uniqueId;
        Date date = new Date();
        uniqueId = Convert.ConvertDateToString(date, Convert.TimeFormat.NumYYYYMMDDHHMMSS);
        uniqueId += UUID.randomUUID().toString().substring(0, 6);
        return uniqueId;
    }

    public static String GetBasePath() {
        String basePath;
        basePath = System.getProperty("user.dir");
        return basePath;
    }

    public static void main(String[] args) {
        try {
            System.out.println(GetBasePath());
            System.out.println(GetUniqueId());
        } catch (Exception ex) {
            Logger.getLogger(SystemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
