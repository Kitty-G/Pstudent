/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.common.Notice.NoticeType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KittyG
 */
public class Image {

    private String imageId;
    private String imageName;
    private String noticeId;
    private NoticeType noticeType;
    private String relativePath;
    private Date createTime;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Image> GetImageInfo(String noticeId) {
        SQLOperate sqlOperate;
        List<Image> imageList;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM IMAGE WHERE NOTICEID = ? ";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, noticeId);
        imageList = new ArrayList();
        try {
            Image imageTemp;
            while (rs.next()) {
                try {
                    imageTemp = new Image();
                    imageTemp.imageId = rs.getString("IMAGEID");
                    imageTemp.imageName = rs.getString("IMAGENAME");
                    imageTemp.noticeId = rs.getString("NOTICEID");
                    imageTemp.noticeType = NoticeType.values()[rs.getInt("NOTICETYPE")];
                    imageTemp.relativePath = rs.getString("RELATIVEPATH");
                    imageTemp.createTime = rs.getTimestamp("CREATETIME");
                    imageList.add(imageTemp);
                } catch (SQLException ex) {
                }
            }
        } catch (Exception ex) {
            //log
            return null;
        }
        return imageList;
    }
}
