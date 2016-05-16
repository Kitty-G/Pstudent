/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KittyG
 */
public class Major {

    private String majorCode;
    private String majorName;
    private String academyCode;
    private String academyName;

    public Major() {

    }

    public Major(String majorCode, String majorName, String academyCode, String academyName) {
        this.majorCode = majorCode;
        this.majorName = majorName;
        this.academyCode = academyCode;
        this.academyName = academyName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getAcademyCode() {
        return academyCode;
    }

    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public Major GetMajorInfoByMajorCode(String majorCode) {
        Major major;
        SQLOperate sqlOperate;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM MAJOR WHERE MAJORCODE = ? ";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, majorCode);
        try {
            major = new Major();
            while (rs.next()) {
                major.majorCode = rs.getString("MAJORCODE");
                major.majorName = rs.getString("MAJORNAME");
                major.academyCode = rs.getString("ACADEMYCODE");
                major.academyName = rs.getString("ACADEMYNAME");
            }
        } catch (SQLException ex) {
            //log
            major = null;
        }
        return major;
    }

    public List<Major> GetMajorInfoByAcademyCode(String academyCode) {
        List<Major> majorList;
        SQLOperate sqlOperate;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM MAJOR WHERE ACADEMYCODE = ? ";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, academyCode);
        majorList = new ArrayList();
        try {
            while (rs.next()) {
                try {
                    Major majorTemp = new Major();
                    majorTemp.majorCode = rs.getString("MAJORCODE");
                    majorTemp.majorName = rs.getString("MAJORNAME");
                    majorTemp.academyCode = rs.getString("ACADEMYCODE");
                    majorTemp.academyName = rs.getString("ACADEMYNAME");
                    majorList.add(majorTemp);
                } catch (Exception ex) {
                }
            }
        } catch (Exception ex) {
            //log
            majorList = null;
        }
        return majorList;
    }

    public boolean AddMajorInfo() {
        SQLOperate sqlOperate;
        List<String> values;
        boolean result;
        try {
            int affectCount;
            sqlOperate = new SQLOperate();
            values = ToValues();
            if (values == null) {
                return false;
            }
            affectCount = sqlOperate.Insert("MAJOR", values);
            result = affectCount == 1;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    private List<String> ToValues() {
        List<String> values;
        try {
            values = new ArrayList<>();
            values.add(this.majorCode);
            values.add(this.majorName);
            values.add(this.academyCode);
            values.add(this.academyName);
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
