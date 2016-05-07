/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.excel;

import com.javabean.excel.ExcelDocument.ExcelDocumentType;
import com.javabean.tools.Convert;
import com.javabean.tools.Convert.ReturnStringValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author zxli
 */
public class ExcelDocumentReader {

    private HashMap sheetNameMap;
    private String filePath;
    private ExcelDocumentType excelDocumentType;
    private ExcelDocument excelDocument;
    private Workbook workbook;
    private HSSFWorkbook hssfWorkbook;

    public ExcelDocumentReader(String filePath, ExcelDocumentType excelDocumentType) {
        this.filePath = filePath;
        this.excelDocumentType = excelDocumentType;
    }

    public ExcelDocument GetExcelDocument() {
        if (this.excelDocument == null) {
            this.excelDocument = new ExcelDocument(this.filePath, this.excelDocumentType);
        }
        return this.excelDocument;
    }

    public boolean Initialize() {
        boolean result;
        GetExcelDocument();
        result = this.excelDocument.Initialize();
        if (!result) {
            //Log
            return false;
        }
        if (this.excelDocument.getWorkbook() == null) {
            return false;
        }
        if (this.excelDocumentType == ExcelDocumentType.XLS) {
            this.hssfWorkbook = (HSSFWorkbook) this.excelDocument.getWorkbook();
            result = this.hssfWorkbook != null;
        } else {
            this.workbook = (Workbook) this.excelDocument.getWorkbook();
            result = this.workbook != null;
        }
        if (result) {
            result = GetSheetName();
        }
        return result;
    }

    private boolean GetSheetName() {
        boolean result;
        int sheetCount;
        try {
            this.sheetNameMap = new HashMap();
            if (this.excelDocumentType == ExcelDocumentType.XLS) {
                sheetCount = this.hssfWorkbook.getNumberOfSheets();
                for (int i = 0; i < sheetCount; i++) {
                    this.sheetNameMap.put(String.valueOf(1), this.hssfWorkbook.getSheetName(i));
                }
            } else {
                sheetCount = this.workbook.getNumberOfSheets();
                for (int i = 0; i < sheetCount; i++) {
                    this.sheetNameMap.put(String.valueOf(1), this.workbook.getSheetName(i));
                }
            }
            result = true;
        } catch (Exception ex) {
            //log
            this.sheetNameMap = null;
            result = false;
        }
        return result;
    }

    private Sheet GetSheet(int sheetIndex) {
        Sheet sheet;
        try {
            if (this.excelDocumentType == ExcelDocumentType.XLS) {
                sheet = this.hssfWorkbook.getSheetAt(sheetIndex);
            } else {
                sheet = this.workbook.getSheetAt(sheetIndex);
            }
        } catch (Exception ex) {
            sheet = null;
        }
        return sheet;
    }

    public String[] GetColumnName(int sheetIndex) {
        String[] columnNameList;
        Sheet sheet;
        Cell cell;
        int columnCount;
        String stringTemp;
        sheet = GetSheet(sheetIndex);
        if (sheet == null) {
            return null;
        }
        Row row = sheet.getRow(0);
        columnCount = row.getLastCellNum();
        columnNameList = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            cell = row.getCell(i);
            stringTemp = Convert.NullToString(cell.getStringCellValue(), ReturnStringValue.NULL);
            columnNameList[i] = stringTemp;
        }
        return columnNameList;
    }

    public List<List<String>> GetDataRowList(int sheetIndex) {
        List<List<String>> dataRowList;
        Sheet sheet;
        Row row;
        int rowCount;
        int columnCount;
        sheet = GetSheet(sheetIndex);
        if (sheet == null) {
            return null;
        }
        rowCount = sheet.getLastRowNum();
        row = sheet.getRow(0);
        columnCount = row.getLastCellNum();
        dataRowList = new ArrayList<>();
        for (int i = 0; i < rowCount + 1; i++) {
            List<String> dataRow = GetOneDataRow(sheet, i, columnCount);
            if (dataRow != null) {
                dataRowList.add(dataRow);
            }
        }
        return dataRowList;
    }

    private List<String> GetOneDataRow(Sheet sheet, int rowIndex, int columnCount) {
        List<String> dataRow;
        Cell cell;
        Row row;
        String stringTemp;
        dataRow = new ArrayList<>();
        try {
            row = sheet.getRow(rowIndex);
            for (int i = 0; i < columnCount; i++) {
                cell = row.getCell(i);
                if (cell == null) {
                    stringTemp = "NULL";
                } else {
                    stringTemp = cell.getStringCellValue();
                }
                dataRow.add(stringTemp);
            }
        } catch (Exception ex) {
            dataRow = null;
        }
        return dataRow;
    }

    public static void main(String[] args) {
        ExcelDocumentReader reader = new ExcelDocumentReader("D:/a.xls", ExcelDocumentType.XLS);
        if (reader.Initialize()) {
            Iterator iter = reader.sheetNameMap.entrySet().iterator();
            System.out.println("遍历sheet");
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
            Sheet sheet;
            sheet = reader.GetSheet(0);
            List<List<String>> dataRowList;

            dataRowList = reader.GetDataRowList(0);
            for (int i = 0; i < dataRowList.size(); i++) {
                for (int j = 0; j < dataRowList.get(i).size(); j++) {
                    System.out.print(dataRowList.get(i).get(j) + "\t");
                }
                System.out.println("");
            }
        } else {
            System.out.println("Initialize false");
        }
    }
}
