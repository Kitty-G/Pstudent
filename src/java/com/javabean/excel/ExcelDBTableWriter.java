/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.excel;

import com.javabean.common.DefaultValue;
import com.javabean.common.Exception.BuildSQLStringException;
import com.javabean.common.SelectField;
import com.javabean.common.SelectField.FieldLevel;
import com.javabean.excel.ExcelDBTableReader.SupportTable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zxli
 */
public class ExcelDBTableWriter {

    public int WriteExcelDataToDB(SupportTable supportTable, List<SelectField> choseColumnList, List<List<String>> dataRowList) {
        ExcelDBTableReader dbTableReader = new ExcelDBTableReader();
        List<SelectField> dbColumnList, automaticColumnList;
        String sql;
        int result;
        try {
            dbColumnList = dbTableReader.GetColumnNameList(supportTable);
            if (!CheckIntegralColumn(choseColumnList, dbColumnList)) {
                return -1;
            }
            automaticColumnList = GetAutoSelectFieldList(dbColumnList);
            sql = BuildSQLString(supportTable, choseColumnList, automaticColumnList);
//            result = WriteToDB(sql, automaticColumnList, dataRowList);
        } catch (Exception ex) {
            Logger.getLogger(ExcelDBTableWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    //Check the neccessary columns have been chose
    private boolean CheckIntegralColumn(List<SelectField> choseColumnList, List<SelectField> dbColumnList) {
        int dbIntegralCount;
        int choseIntegralCount;

        choseIntegralCount = GetIntegralCount(choseColumnList);
        dbIntegralCount = GetIntegralCount(dbColumnList);
        return choseIntegralCount == dbIntegralCount;
    }

    private int GetIntegralCount(List<SelectField> columnList) {
        int integralCount = 0;
        for (SelectField tempField : columnList) {
            if (tempField.getFieldLevel() == FieldLevel.Integral) {
                integralCount++;
            }
        }
        return integralCount;
    }

//    private List<SelectField> AddAutomaticColumn(List<SelectField> dbColumnList) {
//        List<SelectField> automaticColumnList = new ArrayList<>();
//        if (dbColumnList == null) {
//            return null;
//        }
//        for (SelectField fieldTemp : dbColumnList) {
//            if (FieldLevel.Automatic == fieldTemp.getFieldLevel()) {
//                automaticColumnList.add(fieldTemp);
//            }
//        }
//        return automaticColumnList;
//    }

    private String BuildSQLString(SupportTable supportTable, List<SelectField> columnList, List<SelectField> automaticColumnList) throws Exception {
        //The head is the string before values(...),append the column name   eg. insert into table(...) 
        StringBuilder sqlStringHead = new StringBuilder("INSERT INTO ");
        //The tail is the string after the head,append the values ? eg. values(?,?,?)
        StringBuilder sqlStringTail = new StringBuilder(" VALUES(");
        StringBuilder sqlString;
        sqlStringHead.append(supportTable.toString().toUpperCase());
        sqlStringHead.append("(");
        //If columnList is invalid,return null.
        if (columnList == null || columnList.isEmpty()) {
            return null;
        }
        //Before that,string sqlStringHead is "INSERT INTO TABLE(" ,and string sqlStringTail is "VALUES("
        try {
            sqlStringHead.append(columnList.get(0).getInternalName().toUpperCase());
            sqlStringTail.append("?");
            columnList.remove(0);
            //Add the remaining column
            for (SelectField fieldTemp : columnList) {
                sqlStringHead.append(",");
                sqlStringHead.append(fieldTemp.getInternalName().toUpperCase());
                sqlStringTail.append(",");
                sqlStringTail.append("?");
            }
            //Add automatic column that values get from the server  eg.time
            if (automaticColumnList != null) {
                for (SelectField fieldTemp : automaticColumnList) {
                    sqlStringHead.append(",");
                    sqlStringHead.append(fieldTemp.getInternalName().toUpperCase());
                    sqlStringTail.append(",");
                    sqlStringTail.append("?");
                }
            }
            sqlStringHead.append(") ");
            sqlStringTail.append(");");
            sqlString = sqlStringHead;
            sqlString.append(sqlStringTail);
            return sqlString.toString();
        } catch (Exception e) {
            throw new BuildSQLStringException();
        }
    }

    private List<List<String>> MergeAutoColumn(List<SelectField> columnList, List<List<String>> dataRowList) {
        List<List<String>> mergedDataList;
        List<SelectField> automaticColumnList;
        automaticColumnList = GetAutoSelectFieldList(columnList);
        mergedDataList = new ArrayList();
        for (List<String> dataRowTemp : dataRowList) {
            try {
                for (SelectField columnTemp : automaticColumnList) {
                    DefaultValue defaultValue = new DefaultValue();
                    String valueTemp = defaultValue.AutomaticColumnMapping(columnTemp);
                    dataRowTemp.add(valueTemp);
                }
                mergedDataList.add(dataRowTemp);
            } catch (Exception e) {
                //Add to log
            }
        }
        return mergedDataList;
    }

    private List<SelectField> GetAutoSelectFieldList(List<SelectField> columnList) {
        List<SelectField> automaticColumnList;
        if (columnList == null) {
            return null;
        }
        automaticColumnList = new ArrayList();
        for (SelectField fieldTemp : columnList) {
            if (fieldTemp.getFieldLevel() == FieldLevel.Automatic) {
                automaticColumnList.add(fieldTemp);
            }
        }
        return automaticColumnList;
    }
}
