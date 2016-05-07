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
public abstract class Notice {

    public enum NoticeType {
        News,
        Activity
    }

    public enum NoticeStatus {
        Default,
        Sticky
    }
    private String noticeId;
    private String noticeTitle;
    private String noticeContent;
    private String adminId;
    private NoticeType noticeType;
    private NoticeStatus noticeStatus;
    private int imageCount;
    private Date createTime;

    public Notice() {

    }

    public Notice(String noticeId, String noticeTitle, String noticeContent, String adminId, NoticeType noticeType, NoticeStatus noticeStatus, int imageCount, Date createTime) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.adminId = adminId;
        this.noticeType = noticeType;
        this.noticeStatus = noticeStatus;
        this.imageCount = imageCount;
        this.createTime = createTime;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public NoticeStatus getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(NoticeStatus noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
