/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.User;
import com.javabean.tools.Convert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Administrator() {

    }

    public Administrator(String userId, String userName, Identity identity, Gender gender, Date createTime, ManageLevel manageLevel, String telephone, String email) {
        super(userId, userName, identity, gender, createTime);
        this.manageLevel = manageLevel;
        this.telephone = telephone;
        this.email = email;
    }

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

    public Administrator GetAdministratorInfo(String userId) {
        Administrator administrator;
        SQLOperate sqlOperate;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM ADMINISTRATOR WHERE USERID = ? ";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, userId);
        try {
            administrator = new Administrator();
            while (rs.next()) {
                administrator.setUserId(rs.getString("USERID"));
                administrator.setUserName(rs.getString("USERNAME"));
                administrator.setIdentity(Identity.values()[rs.getInt("IDENTITY")]);
                administrator.setGender(Gender.values()[rs.getInt("GENDER")]);
                administrator.setCreateTime(rs.getTimestamp("CREATETIME"));
                administrator.setManageLevel(ManageLevel.values()[rs.getInt("MANAGELEVEL")]);
                administrator.setTelephone(rs.getString("TELEPHONE"));
                administrator.setEmail(rs.getString("EMAIL"));
            }
        } catch (SQLException ex) {
            //log
            return null;
        }
        return administrator;
    }

    public boolean AddAdministratorInfo() {
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
            affectCount = sqlOperate.Insert("ADMINISTRATOR", values);
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
            values.add(this.getUserId());
            values.add(this.getUserName());
            values.add(Convert.EnumToIntString(this.getIdentity()));
            values.add(Convert.EnumToIntString(this.getGender()));
            values.add(Convert.ConvertDateToString(this.getCreateTime(), Convert.TimeFormat.YYYYMMDDHHMMSS));
            values.add(Convert.EnumToIntString(manageLevel));
            values.add(this.telephone);
            values.add(this.email);
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
