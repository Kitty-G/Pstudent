/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tools;

import java.io.File;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author zxli
 */
public class SystemInfo {

    public static final String ProjectRealPath;
    public static final String ProjectName;
    static {
        String classPath = SystemInfo.class.getClassLoader().getResource("\\").getPath();
        ProjectRealPath = ConvertRealPath(classPath);
        ProjectName="project";
    }

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

    public static String GetServiceRealPath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/");
    }

    private static String ConvertRealPath(String path) {
        if ("\\".equals(File.separator)) {
            path = path.substring(1, path.indexOf("/WEB-INF/classes"));
            path = path.replace("/", "\\");
        } else if ("/".equals(File.separator)) {
            path = path.substring(0, path.indexOf("/WEB-INF/classes"));
            path = path.replace("\\", "/");
        }
        return path;
    }

    public static void main(String[] args) {
        try {
            System.out.println(GetBasePath());
            System.out.println(GetUniqueId());
            System.out.println(SystemInfo.ProjectRealPath);
        } catch (Exception ex) {
            Logger.getLogger(SystemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
