/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.tools;

import com.javabean.tools.FileHelper;
import com.javabean.tools.SystemInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author zxli
 */
public class FileUploadHelper {

    public enum SupportFunction {
        News,
        Activity
    }

    private final HttpServletRequest servletRequest;
    private final SupportFunction supportFunction;
    private int fileCount;
    private List<Integer> validItemNumberList;
    private final long singleFileMaxSize;
    private final long limitedSize;
    private long[] size;
    private long totalSize;
    private int[] fileResult;
    private String relativePath;

    private static final String tempFilePath = "TempFile";
    private ServletFileUpload servletFileUpload;

    public FileUploadHelper(HttpServletRequest servletRequest, SupportFunction supportFunction, long singleFileMaxSize, long limitedSize) {
        this.servletRequest = servletRequest;
        this.supportFunction = supportFunction;
        this.singleFileMaxSize = singleFileMaxSize;
        this.limitedSize = limitedSize;
    }

    public boolean Initialize() {
        boolean result;
        String tempRealPath;
        File repository;
        int sizeThreshold;
        DiskFileItemFactory diskFileItemFactory;
        ServletFileUpload fileUpload;
        try {
            this.relativePath = MappingRelativePath();
            tempRealPath = SystemInfo.GetBasePath() + File.separator + tempFilePath;
            repository = new File(tempRealPath);
            sizeThreshold = 1024 * 6;
            diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setRepository(repository);
            diskFileItemFactory.setSizeThreshold(sizeThreshold);
            fileUpload = new ServletFileUpload(diskFileItemFactory);
            fileUpload.setSizeMax(limitedSize);
            fileUpload.setHeaderEncoding("UTF-8");
            result = true;
        } catch (Exception ex) {
            fileUpload = null;
            result = false;
            //log
        }
        if (result) {
            this.servletFileUpload = fileUpload;
        }
        return result;
    }

    public int UploadFiles() {
        List<FileItem> fileItemList;
        int result;
        int i;
        if (servletRequest == null) {
            return -1;
        }
        try {
            fileItemList = this.servletFileUpload.parseRequest(servletRequest);
            this.validItemNumberList = GetFileItemNumber(fileItemList);
            this.fileCount = this.validItemNumberList.size();
            this.fileResult = new int[this.fileCount];
            if (!CheckAndGetFilesSize(fileItemList)) {
                //out of all files max size
                return -2;
            }
            i = 0;
            for (int temp : validItemNumberList) {
                FileItem fileItem;
                try {
                    fileItem = fileItemList.get(temp);
                    if (size[i] > this.singleFileMaxSize) {
                        //out of single file size limit
                        fileResult[i]=-2;
                        continue;
                    }
                    fileResult[i] = UploadFile(fileItem);
                } catch (Exception ex) {
                    //log
                    fileResult[i] = -1;
                } finally {
                    i++;
                }
            }
            result = 0;
        } catch (FileUploadException ex) {
            Logger.getLogger(FileUploadHelper.class.getName()).log(Level.SEVERE, null, ex);
            fileResult = null;
            this.size = null;
            result = -3;
        }
        return result;

    }

    private int UploadFile(FileItem fileItem) throws Exception {
        int result;
        FileHelper fileHelper;
        fileHelper = new FileHelper(this.relativePath, fileItem);
        result = fileHelper.SaveFile() ? 0 : -1;
        return result;
    }

    private List<Integer> GetFileItemNumber(List<FileItem> fileItemList) {
        List<Integer> numberList;
        int i = 0;
        numberList = new ArrayList();
        for (FileItem itemTemp : fileItemList) {
            if (!itemTemp.isFormField()) {
                numberList.add(i);
            }
            i++;
        }
        return numberList;
    }

    private String MappingRelativePath() {
        String path;
        switch (this.supportFunction) {
            case News:
                path = "";
                break;
            case Activity:
                path = "";
                break;
            default:
                path = null;
        }
        return path;
    }

    private boolean CheckAndGetFilesSize(List<FileItem> fileItemList) {
        FileItem fileItem;
        int i;
        long sizeTemp;
        this.size = new long[this.fileCount];
        i = 0;
        sizeTemp = 0;
        for (int temp : this.validItemNumberList) {
            fileItem = fileItemList.get(temp);
            this.size[i] = fileItem.getSize();
            sizeTemp += this.size[i];
            i++;
        }
        this.totalSize = sizeTemp;
        return this.limitedSize > sizeTemp;
    }

}
