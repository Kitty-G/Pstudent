/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.common;

import java.util.Date;

/**
 *
 * @author KittyG
 */
public class Notice {
    public enum AppType{
        News,
        Activity
    }
    public enum NoticeStatus{
        Default,
        Sticky
    }
    private String id;
    private String title;
    private String text;
    private AppType noticeType;
    private NoticeStatus noticeStatus;
    private int imageNumber;
    private Date createTime;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AppType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(AppType noticeType) {
        this.noticeType = noticeType;
    }

    public NoticeStatus getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(NoticeStatus noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
