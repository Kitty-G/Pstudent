/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tools;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author zxli
 */
public class FileHelper {

    public enum FileType {
        Unkown,
        JPG,
        GIF,
        PNG,
        BMP,
        XLS,
        XLSX
    }

    private String displayName;
    private String internalName;
    private String extensionName;
    private long size;
    private String relativePath;
    private String realPath;
    private FileType fileType;
    private FileItem fileItem;

    public FileHelper(String relativePath, FileItem fileItem) {
        try {
            this.internalName = SystemInfo.GetUniqueId();
        } catch (Exception ex) {
            Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.relativePath = relativePath;
        this.fileItem = fileItem;
    }

    public FileHelper(String displayName, String internalName, String relativePath, FileItem fileItem) {
        this.displayName = displayName;
        this.internalName = internalName;
        this.relativePath = relativePath;
        this.fileItem = fileItem;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getInternalName() {
        return internalName;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public long getSize() {
        return size;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public String getRealPath() {
        return realPath;
    }

    public FileType getFileType() {
        return fileType;
    }

    public FileItem getFileItem() {
        return fileItem;
    }

    public boolean SaveFile() throws Exception {
        boolean result;
        String fileName;
        String realDirectoryPath;
        File directory;
        File file;

        if (fileItem == null) {
            //log
            return false;
        }
        this.size = fileItem.getSize();
        fileName = fileItem.getName();
        System.out.println(fileName);
        if (fileName == null || fileName.trim().length() == 0) {
            return false;
        }

        this.displayName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
        this.extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        this.fileType = MappingFileType(extensionName);
        if (fileType == FileType.Unkown) {
            if (extensionName != null) {
                this.internalName += "." + extensionName;
            }
        } else {
            this.internalName += "." + fileType.toString().toLowerCase();
        }
        realDirectoryPath = "D:" + File.separator + "test" + File.separator + this.relativePath;
        this.realPath = realDirectoryPath + File.separator + this.internalName;

        //log
        try {
            directory = new File(realDirectoryPath);
            if (!directory.exists()) {
                result = directory.mkdirs();
                if (!result) {
                    //log can't create directory
                    return false;
                }
            }

            file = new File(realPath);
            fileItem.write(file);
            result = true;
            //log
        } catch (Exception ex) {
            result = false;
            //log
        }
        return result;
    }

    private FileType MappingFileType(String extensionName) {
        String lowerName;
        FileType mappingFileType;
        if (extensionName == null) {
            return FileType.Unkown;
        }
        lowerName = extensionName.toLowerCase();
        switch (lowerName) {
            case "jpg":
                mappingFileType = FileType.JPG;
                break;
            case "gif":
                mappingFileType = FileType.GIF;
                break;
            case "png":
                mappingFileType = FileType.PNG;
                break;
            case "bmp":
                mappingFileType = FileType.BMP;
                break;
            case "xls":
                mappingFileType = FileType.XLS;
                break;
            case "xlsx":
                mappingFileType = FileType.XLSX;
                break;
            default:
                mappingFileType = FileType.Unkown;
        }
        return mappingFileType;
    }

}
