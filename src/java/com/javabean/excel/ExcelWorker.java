/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.excel;

import com.javabean.administrator.AdministratorWorker;
import com.javabean.common.DataRow;
import com.javabean.common.DefaultValue;
import com.javabean.common.SelectField;
import com.javabean.common.User.Gender;
import com.javabean.common.User.Identity;
import com.javabean.excel.ExcelDBTableReader.SupportTable;
import com.javabean.excel.ExcelDocument.ExcelDocumentType;
import com.javabean.major.MajorWorker;
import com.javabean.managingdepartment.ManagingDepartmentWorker;
import com.javabean.student.StudentWorker;
import com.javabean.tables.Administrator.ManageLevel;
import com.javabean.tables.ManagingDepartment.DepartmentLevel;
import com.javabean.tools.Convert;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author KittyG
 */
public class ExcelWorker {

    private ExcelDocumentType excelDocumentType;
    private int[] columnMapping;
    private String filePath;
    private SupportTable tableName;

    public ExcelWorker() {

    }

    public ExcelWorker(String filePath, ExcelDocumentType excelDocumentType) {
        this.filePath = filePath;
        this.excelDocumentType = excelDocumentType;
    }

    public ExcelWorker(String filePath, ExcelDocumentType excelDocumentType, int[] columnMapping, SupportTable tableName) {
        this.filePath = filePath;
        this.excelDocumentType = excelDocumentType;
        this.columnMapping = columnMapping;
        this.tableName = tableName;
    }

    public List<SelectField> GetTableColumnNameList(SupportTable tableName) {
        ExcelDBTableReader tableReader;
        tableReader = new ExcelDBTableReader();
        return tableReader.GetColumnNameList(tableName);
    }

    public List<String> GetDisplayNameList(List<SelectField> fieldList) {
        ExcelDBTableReader tableReader;
        tableReader = new ExcelDBTableReader();
        return tableReader.GetDisplayNameList(fieldList);
    }

    public HashMap GetSheetNameMap() {
        ExcelDocumentReader documentReader;
        documentReader = new ExcelDocumentReader(this.filePath, this.excelDocumentType);
        if (documentReader.Initialize()) {
            return documentReader.getSheetNameMap();
        } else {
            return null;
        }
    }

    public List<String> GetDocumentColumnName(int sheetIndex) {
        ExcelDocumentReader documentReader;
        documentReader = new ExcelDocumentReader(this.filePath, this.excelDocumentType);
        if (documentReader.Initialize()) {
            return documentReader.GetColumnName(sheetIndex);
        } else {
            return null;
        }
    }

    public List<DataRow> TestMapping(int sheetIndex) {
        List<DataRow> dataRowList = null;
        switch (tableName) {
            case Student:
                dataRowList = StudentTestMapping(sheetIndex);
                break;
            case Administrator:
                dataRowList = AdministratorTestMapping(sheetIndex);
                break;
            case Major:
                dataRowList = MajorTestMapping(sheetIndex);
                break;
            case ManagingDepartment:
                dataRowList = ManagingDepartmentTestMapping(sheetIndex);
                break;
        }
        return dataRowList;
    }

    private List<DataRow> StudentTestMapping(int sheetIndex) {
        ExcelDocumentReader documentReader;
        List<List<String>> dataRowList;
        List<DataRow> dataRowResult;
        List<SelectField> tableColumnName;

        documentReader = new ExcelDocumentReader(this.filePath, this.excelDocumentType);

        if (documentReader.Initialize()) {
            tableColumnName = GetTableColumnNameList(this.tableName);
            dataRowList = documentReader.GetDataRowList(sheetIndex);
            dataRowResult = new ArrayList();
            dataRowResult.add(new DataRow(GetDisplayNameList(tableColumnName), false));
            for (int i = 1; i < dataRowList.size(); i++) {
                DataRow rowTemp;
                boolean validTemp;
                List<String> docDataLine = dataRowList.get(i);
                List<String> dataTemp = new ArrayList();
                try {
                    for (int j = 0; j < tableColumnName.size(); j++) {
                        SelectField fieldTemp = tableColumnName.get(j);
                        switch (fieldTemp.getFieldLevel()) {
                            case Automatic: {
                                switch (fieldTemp.getInternalName()) {
                                    case "Password":
                                        dataTemp.add(DefaultValue.StudentPassword);
                                        break;
                                    case "Identity":
                                        dataTemp.add(Convert.EnumToIntString(Identity.User));
                                        break;
                                }
                                break;
                            }
                            case Integral: {
                                dataTemp.add(docDataLine.get(this.columnMapping[j]));
                                break;
                            }
                        }
                    }
                    validTemp = true;
                } catch (Exception ex) {
                    validTemp = false;
                    dataTemp = null;
                }
                rowTemp = new DataRow(dataTemp, validTemp);
                dataRowResult.add(rowTemp);
            }
            return dataRowResult;
        } else {
            //Test Run failed
            return null;
        }
    }

    private List<DataRow> AdministratorTestMapping(int sheetIndex) {
        ExcelDocumentReader documentReader;
        List<List<String>> dataRowList;
        List<DataRow> dataRowResult;
        List<SelectField> tableColumnName;

        documentReader = new ExcelDocumentReader(this.filePath, this.excelDocumentType);

        if (documentReader.Initialize()) {
            tableColumnName = GetTableColumnNameList(this.tableName);
            dataRowList = documentReader.GetDataRowList(sheetIndex);
            dataRowResult = new ArrayList();
            dataRowResult.add(new DataRow(GetDisplayNameList(tableColumnName), false));
            for (int i = 1; i < dataRowList.size(); i++) {
                DataRow rowTemp;
                boolean validTemp;
                List<String> docDataLine = dataRowList.get(i);
                List<String> dataTemp = new ArrayList();
                try {
                    for (int j = 0; j < tableColumnName.size(); j++) {
                        SelectField fieldTemp = tableColumnName.get(j);
                        switch (fieldTemp.getFieldLevel()) {
                            case Automatic: {
                                switch (fieldTemp.getInternalName()) {
                                    case "Password":
                                        dataTemp.add(DefaultValue.AdministratorPassword);
                                        break;
                                    case "Identity":
                                        dataTemp.add(Convert.EnumToIntString(Identity.Administrator));
                                        break;
                                }
                                break;
                            }
                            case Normal: {
                                String valueTemp;
                                valueTemp = docDataLine.get(this.columnMapping[j]);
                                valueTemp = Convert.NullToString(valueTemp, Convert.ReturnStringValue.Empty);
                                dataTemp.add(valueTemp);
                                break;
                            }
                            case Integral: {
                                dataTemp.add(docDataLine.get(this.columnMapping[j]));
                                break;
                            }
                        }
                    }
                    validTemp = true;
                } catch (Exception ex) {
                    validTemp = false;
                    dataTemp = null;
                }
                rowTemp = new DataRow(dataTemp, validTemp);
                dataRowResult.add(rowTemp);
            }
            return dataRowResult;
        } else {
            //Test Run failed
            return null;
        }
    }

    private List<DataRow> MajorTestMapping(int sheetIndex) {
        ExcelDocumentReader documentReader;
        List<List<String>> dataRowList;
        List<DataRow> dataRowResult;
        List<SelectField> tableColumnName;

        documentReader = new ExcelDocumentReader(this.filePath, this.excelDocumentType);

        if (documentReader.Initialize()) {
            tableColumnName = GetTableColumnNameList(this.tableName);
            dataRowList = documentReader.GetDataRowList(sheetIndex);
            dataRowResult = new ArrayList();
            dataRowResult.add(new DataRow(GetDisplayNameList(tableColumnName), false));
            for (int i = 1; i < dataRowList.size(); i++) {
                DataRow rowTemp;
                boolean validTemp;
                List<String> docDataLine = dataRowList.get(i);
                List<String> dataTemp = new ArrayList();
                try {
                    for (int j = 0; j < tableColumnName.size(); j++) {
                        SelectField fieldTemp = tableColumnName.get(j);
                        switch (fieldTemp.getFieldLevel()) {
                            case Integral: {
                                dataTemp.add(docDataLine.get(this.columnMapping[j]));
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    validTemp = true;
                } catch (Exception ex) {
                    validTemp = false;
                    dataTemp = null;
                }
                rowTemp = new DataRow(dataTemp, validTemp);
                dataRowResult.add(rowTemp);
            }
            return dataRowResult;
        } else {
            //Test Run failed
            return null;
        }
    }

    private List<DataRow> ManagingDepartmentTestMapping(int sheetIndex) {
        ExcelDocumentReader documentReader;
        List<List<String>> dataRowList;
        List<DataRow> dataRowResult;
        List<SelectField> tableColumnName;

        documentReader = new ExcelDocumentReader(this.filePath, this.excelDocumentType);

        if (documentReader.Initialize()) {
            tableColumnName = GetTableColumnNameList(this.tableName);
            dataRowList = documentReader.GetDataRowList(sheetIndex);
            dataRowResult = new ArrayList();
            dataRowResult.add(new DataRow(GetDisplayNameList(tableColumnName), false));
            for (int i = 1; i < dataRowList.size(); i++) {
                DataRow rowTemp;
                boolean validTemp;
                List<String> docDataLine = dataRowList.get(i);
                List<String> dataTemp = new ArrayList();
                try {
                    for (int j = 0; j < tableColumnName.size(); j++) {
                        SelectField fieldTemp = tableColumnName.get(j);
                        switch (fieldTemp.getFieldLevel()) {
                            case Integral: {
                                dataTemp.add(docDataLine.get(this.columnMapping[j]));
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    validTemp = true;
                } catch (Exception ex) {
                    validTemp = false;
                    dataTemp = null;
                }
                rowTemp = new DataRow(dataTemp, validTemp);
                dataRowResult.add(rowTemp);
            }
            return dataRowResult;
        } else {
            //Test Run failed
            return null;
        }
    }

    public int[] InsertDataToDatabase(int sheetIndex) {
        List<DataRow> dataRowList;
        int successFailed[] = {0, 0};
        dataRowList = TestMapping(sheetIndex);
        switch (this.tableName) {
            case Student: {
                StudentWorker worker;
                boolean result;
                for (DataRow row : dataRowList) {
                    if (row.isValid()) {
                        worker = GetStudentWorker(row);
                        if (worker != null) {
                            result = worker.AddStudent();
                            if (result) {
                                successFailed[0]++;
                            } else {
                                successFailed[1]++;
                            }
                        } else {
                            successFailed[1]++;
                        }
                    }
                }
                break;
            }
            case Administrator: {
                AdministratorWorker worker;
                boolean result;
                for (DataRow row : dataRowList) {
                    if (row.isValid()) {
                        worker = GetAdministratorWorker(row);
                        if (worker != null) {
                            result = worker.AddAdministrator();
                            if (result) {
                                successFailed[0]++;
                            } else {
                                successFailed[1]++;
                            }
                        } else {
                            successFailed[1]++;
                        }
                    }
                }
                break;
            }
            case Major: {
                MajorWorker worker;
                boolean result;
                for (DataRow row : dataRowList) {
                    if (row.isValid()) {
                        worker = GetMajorWorker(row);
                        if (worker != null) {
                            result = worker.AddMajor();
                            if (result) {
                                successFailed[0]++;
                            } else {
                                successFailed[1]++;
                            }
                        } else {
                            successFailed[1]++;
                        }
                    }
                }
                break;
            }
            case ManagingDepartment: {
                ManagingDepartmentWorker worker;
                boolean result;
                for (DataRow row : dataRowList) {
                    if (row.isValid()) {
                        worker = GetManagingDepartmentWorker(row);
                        if (worker != null) {
                            result = worker.AddManagingDepartment();
                            if (result) {
                                successFailed[0]++;
                            } else {
                                successFailed[1]++;
                            }
                        } else {
                            successFailed[1]++;
                        }
                    }
                }
                break;
            }
        }
        return successFailed;
    }

    private StudentWorker GetStudentWorker(DataRow dataRow) {
        StudentWorker worker;
        List<String> dataList;
        String userId;
        String password;
        String userName;
        Identity identity;
        Gender gender;
        int grade;
        String majorCode;
        int classNo;
        Date intendedTime;
        try {
            dataList = dataRow.getDataList();
            userId = dataList.get(0);
            password = dataList.get(1);
            userName = dataList.get(2);
            identity = Identity.values()[Integer.parseInt(dataList.get(3))];
            gender = Gender.values()[Integer.parseInt(dataList.get(4))];
            grade = Integer.parseInt(dataList.get(5));
            majorCode = dataList.get(6);
            classNo = Integer.parseInt(dataList.get(7));
            intendedTime = Convert.ConvertStringToDate(dataList.get(8), Convert.TimeFormat.YYYYMMDD);
            worker = new StudentWorker(userId, password, userName, identity, gender, grade, majorCode, classNo, intendedTime);
        } catch (Exception ex) {
            worker = null;
        }
        return worker;
    }

    private AdministratorWorker GetAdministratorWorker(DataRow dataRow) {
        AdministratorWorker worker;
        List<String> dataList;
        String userId;
        String password;
        String userName;
        Identity identity;
        Gender gender;
        ManageLevel manageLevel;
        String telephone;
        String email;
        try {
            dataList = dataRow.getDataList();
            userId = dataList.get(0);
            password = dataList.get(1);
            userName = dataList.get(2);
            identity = Identity.values()[Integer.parseInt(dataList.get(3))];
            gender = Gender.values()[Integer.parseInt(dataList.get(4))];
            manageLevel = ManageLevel.values()[Integer.parseInt(dataList.get(5))];
            telephone = dataList.get(6);
            email = dataList.get(7);
            worker = new AdministratorWorker(userId, password, userName, identity, gender, manageLevel, telephone, email);
        } catch (Exception ex) {
            worker = null;
        }
        return worker;
    }

    private MajorWorker GetMajorWorker(DataRow dataRow) {
        MajorWorker worker;
        List<String> dataList;
        String majorCode;
        String majorName;
        String academyCode;
        String academyName;
        try {
            dataList = dataRow.getDataList();
            majorCode = dataList.get(0);
            majorName = dataList.get(1);
            academyCode = dataList.get(2);
            academyName = dataList.get(3);
            worker = new MajorWorker(majorCode, majorName, academyCode, academyName);
        } catch (Exception ex) {
            worker = null;
        }
        return worker;
    }

    private ManagingDepartmentWorker GetManagingDepartmentWorker(DataRow dataRow) {
        ManagingDepartmentWorker worker;
        List<String> dataList;
        String administratorId;
        String departmentCode;
        DepartmentLevel departmentLevel;
        try {
            dataList = dataRow.getDataList();
            administratorId = dataList.get(0);
            departmentCode = dataList.get(1);
            departmentLevel = DepartmentLevel.values()[Integer.parseInt(dataList.get(2))];
            worker = new ManagingDepartmentWorker(administratorId, departmentCode, departmentLevel);
        } catch (Exception ex) {
            worker = null;
        }
        return worker;
    }

    public static void main(String[] args) {
        int[] mapping = {0, -1, 1, -1, 2, 3, 4, 5, 6};
        ExcelWorker worker = new ExcelWorker("D:/doit.xlsx", ExcelDocumentType.XLSX, mapping, SupportTable.Student);
//        List<SelectField> ls = worker.GetTableColumnNameList(SupportTable.Student);
//        HashMap h = worker.GetSheetNameMap();
//        List<String> s = worker.GetDocumentColumnName(0);
//        List<DataRow> ld = worker.TestMapping(0);
        int[] result = worker.InsertDataToDatabase(0);
        System.out.println(result[0] + "      " + result[1]);
    }
}
