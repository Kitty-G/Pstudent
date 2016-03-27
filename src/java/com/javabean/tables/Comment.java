/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import java.util.Date;

/**
 *
 * @author KittyG
 */
public class Comment {

    public enum CommentType {
        Post,
        Reply
    }

    public enum CommentStatus {
        Default,
        Sticky,
        Deleted
    }
    private String activityId;
    private String userId;
    private int commentId;
    private String commentContent;
    private CommentType commentType;
    private int replyId;
    private CommentStatus commentStatus;
    private Date createTime;
}
