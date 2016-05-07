/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author KittyG
 */
public class ExcelDocument {

    public enum ExcelDocumentType {

        XLS,
        XLSX
    }
    private String filePath;
    private ExcelDocumentType excelDocumentType;
    private File file;
    private FileInputStream fileInputStream;
    private Workbook workbook;
    private HSSFWorkbook hssfWorkbook;

    public ExcelDocument(String filePath, ExcelDocumentType excelDocumentType) {
        this.filePath = filePath;
        this.excelDocumentType = excelDocumentType;
    }

    public String getFilePath() {
        return filePath;
    }

    public ExcelDocumentType getExcelDocumentType() {
        return excelDocumentType;
    }

    public File getFile() {
        return file;
    }

    public Object getWorkbook() {
        if (excelDocumentType == ExcelDocumentType.XLS) {
            return this.hssfWorkbook;
        } else {
            return this.workbook;
        }

    }

    public boolean Initialize() {
        boolean result;
        this.file = new File(filePath);
        try {
            this.fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if (this.excelDocumentType == ExcelDocumentType.XLS) {
            result = XLSInitialize();
        } else if (this.excelDocumentType == ExcelDocumentType.XLSX) {
            result = XLSXInitialize();
        } else {
            result = false;
        }
        return result;
    }

    private boolean XLSInitialize() {
        boolean result = false;
        POIFSFileSystem fileSystem;
        try {
            fileSystem = new POIFSFileSystem(this.fileInputStream);
            this.hssfWorkbook = new HSSFWorkbook(fileSystem);
            result = true;
        } catch (IOException ex) {
            Logger.getLogger(ExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
    }

    private boolean XLSXInitialize() {
        boolean result = false;
        try {
            this.workbook = WorkbookFactory.create(this.fileInputStream);
            result = true;
        } catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {
            Logger.getLogger(ExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
    }

    public void Close() {
        try {
            if (this.fileInputStream != null) {
                this.fileInputStream.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ExcelDocument excelDocument = new ExcelDocument("D:/ab.xls", ExcelDocumentType.XLS);
        System.out.println(excelDocument.Initialize());
    }
}
