/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.excel;

import com.javabean.common.SelectField;
import com.javabean.common.SelectField.FieldLevel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zxli
 */
public class ExcelDBTableReader {

    public enum SupportTable {
        Student,
        Administrator,
        Major,
        ManagingDepartment
    }

    public List<SelectField> GetColumnNameList(SupportTable tableName) throws Exception {
        List<SelectField> columnName = new ArrayList();
        SelectField tempField;
        switch (tableName) {
            case Student: {
                tempField = new SelectField("UserId", "学号",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("Name", "姓名",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("Gender", "性别",FieldLevel.Normal);
                columnName.add(tempField);
                tempField = new SelectField("Grade", "年级",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("MajorCode", "专业代码",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("ClassNo", "班级",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("IntendedTime", "入学时间",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("CreateTime", "创建时间",FieldLevel.Automatic);
                columnName.add(tempField);
                break;
            }
            case Administrator: {
                tempField = new SelectField("UserId", "管理员账号",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("ManagementLevel", "管理员级别",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("Name", "姓名",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("Gender", "性别",FieldLevel.Normal);
                columnName.add(tempField);
                tempField = new SelectField("Telephone", "联系电话",FieldLevel.Normal);
                columnName.add(tempField);
                tempField = new SelectField("Email", "电子邮箱",FieldLevel.Normal);
                columnName.add(tempField);
                tempField = new SelectField("CreateTime", "创建时间",FieldLevel.Automatic);
                columnName.add(tempField);
                break;
            }
            case Major: {
                tempField = new SelectField("AcademyCode", "学院代码",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("AcademyName", "学院名称",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("MajorCode", "专业代码",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("MajorName", "专业名称",FieldLevel.Integral);
                columnName.add(tempField);
                break;
            }
            case ManagingDepartment: {
                tempField = new SelectField("AdministratorId", "管理员账号",FieldLevel.Integral);
                columnName.add(tempField);
                tempField = new SelectField("DepartmentCode", "管理院系编号",FieldLevel.Integral);
                columnName.add(tempField);
                break;
            }
            default:
                throw new Exception("");
        }
        return columnName;
    }
}
