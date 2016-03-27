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
    private String Text;
    private AppType noticeType;
    private NoticeStatus noticeStatus;
    private int imageNumber;
    private Date createTime;
}
