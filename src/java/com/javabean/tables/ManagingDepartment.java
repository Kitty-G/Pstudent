/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.tools.Convert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zxli
 */
public class ManagingDepartment {

    public enum DepartmentLevel {
        Major,
        Academy
    }

    private String administratorId;
    private String departmentCode;
    private DepartmentLevel departmentLevel;

    public ManagingDepartment() {

    }

    public ManagingDepartment(String administratorId, String departmentCode, DepartmentLevel departmentLevel) {
        this.administratorId = administratorId;
        this.departmentCode = departmentCode;
        this.departmentLevel = departmentLevel;
    }

    public String getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(String administratorId) {
        this.administratorId = administratorId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public DepartmentLevel getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(DepartmentLevel departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    public ManagingDepartment GetManagingDepartmentInfoByAdminId(String administratorId) {
        ManagingDepartment managingDepartment;
        SQLOperate sqlOperate;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM MANAGINGDEPARTMENT WHERE ADMINISTRATORID = ? ";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, administratorId);
        try {
            managingDepartment = new ManagingDepartment();
            while (rs.next()) {
                managingDepartment.administratorId = rs.getString("ADMINISTRATORID");
                managingDepartment.departmentCode = rs.getString("DEPARTMENTCODE");
                managingDepartment.departmentLevel = DepartmentLevel.values()[rs.getInt("DEPARTMENTLEVEL")];
            }
        } catch (SQLException ex) {
            //log
            return null;
        }
        return managingDepartment;
    }

    public boolean AddManagingDepartmentInfo() {
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
            affectCount = sqlOperate.Insert("MANAGINGDEPARTMENT", values);
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
            values.add(this.administratorId);
            values.add(this.departmentCode);
            values.add(Convert.EnumToIntString(this.departmentLevel));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
