/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import com.databasecontrol.mysql.SQLOperate;
import com.javabean.tools.Convert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String commentId;
    private String activityId;
    private String userId;
    private int commentNumber;
    private String commentContent;
    private CommentType commentType;
    private String replyCommentId;
    private CommentStatus commentStatus;
    private boolean anonymous;
    private Date createTime;

    public Comment() {

    }

    public Comment(String commentId, String activityId, String userId, int commentNumber, String commentContent, CommentType commentType, String replyCommentId, CommentStatus commentStatus, boolean anonymous, Date createTime) {
        this.commentId = commentId;
        this.activityId = activityId;
        this.userId = userId;
        this.commentNumber = commentNumber;
        this.commentContent = commentContent;
        this.commentType = commentType;
        this.replyCommentId = replyCommentId;
        this.commentStatus = commentStatus;
        this.anonymous = anonymous;
        this.createTime = createTime;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public String getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(String replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public CommentStatus getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatus commentStatus) {
        this.commentStatus = commentStatus;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Comment GetCommentInfoByCommentId(String commentId) {
        SQLOperate sqlOperate;
        Comment comment;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM COMMENT WHERE COMMENTID = ? ";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, commentId);
        try {
            comment = new Comment();
            while (rs.next()) {
                comment.commentId = rs.getString("COMMENTID");
                comment.activityId = rs.getString("ACTIVITYID");
                comment.userId = rs.getString("USERID");
                comment.commentNumber = rs.getInt("COMMENTNUMBER");
                comment.commentContent = rs.getString("COMMENTCONTENT");
                comment.commentType = CommentType.values()[rs.getInt("COMMENTTYPE")];
                comment.replyCommentId = rs.getString("REPLYCOMMENTID");
                comment.commentStatus = CommentStatus.values()[rs.getInt("COMMENTSTATUS")];
                comment.anonymous = rs.getBoolean("ANONYMOUS");
                comment.createTime = rs.getTimestamp("CREATETIME");
            }
        } catch (SQLException ex) {
            //log
            return null;
        }
        return comment;
    }

    public List<Comment> GetCommentInfoActivityId(String activityId) {
        SQLOperate sqlOperate;
        List<Comment> commentList;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM COMMENT WHERE COMMENTID = ? ORDER BY COMMENTNUMBER";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, commentId);
        commentList = GetCommentData(rs);
        return commentList;
    }
    
        public List<Comment> GetCommentInfoActivityId(String activityId,int ignoreNumber,int returnNumber) {
        SQLOperate sqlOperate;
        List<Comment> commentList;
        ResultSet rs;
        String sql;
//        sql = "SELECT * FROM COMMENT WHERE COMMENTID = ? ORDER BY COMMENTNUMBER OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, commentId);
        commentList = GetCommentData(rs);
        return commentList;
    }

    private List<Comment> GetCommentData(ResultSet rs) {
        List<Comment> commentList;
        try {
            commentList = new ArrayList();
            Comment commentTemp;
            try {
                while (rs.next()) {
                    commentTemp = new Comment();
                    commentTemp.commentId = rs.getString("COMMENTID");
                    commentTemp.activityId = rs.getString("ACTIVITYID");
                    commentTemp.userId = rs.getString("USERID");
                    commentTemp.commentNumber = rs.getInt("COMMENTNUMBER");
                    commentTemp.commentContent = rs.getString("COMMENTCONTENT");
                    commentTemp.commentType = CommentType.values()[rs.getInt("COMMENTTYPE")];
                    commentTemp.replyCommentId = rs.getString("REPLYCOMMENTID");
                    commentTemp.commentStatus = CommentStatus.values()[rs.getInt("COMMENTSTATUS")];
                    commentTemp.anonymous = rs.getBoolean("ANONYMOUS");
                    commentTemp.createTime = rs.getTimestamp("CREATETIME");
                    commentList.add(commentTemp);
                }
            } catch (SQLException ex) {
            }
        } catch (Exception ex) {
            //log
            return null;
        }
        return commentList;
    }

    public boolean AddCommentInfo() {
        SQLOperate sqlOperate;
        List<String> values;
        boolean result;
        try {
            int affectCount;
            sqlOperate = new SQLOperate();
            values = ToValues();
            if (values == null) {
                return false;
            }
            affectCount = sqlOperate.Insert("COMMENT", values);
            result = affectCount == 1;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    private List<String> ToValues() {
        List<String> values;
        try {
            values = new ArrayList<>();
            values.add(this.commentId);
            values.add(this.activityId);
            values.add(this.userId);
            values.add(String.valueOf(this.commentNumber));
            values.add(this.commentContent);
            values.add(Convert.EnumToIntString(this.commentType));
            values.add(this.replyCommentId);
            values.add(Convert.EnumToIntString(this.commentStatus));
            values.add(String.valueOf(this.anonymous));
            values.add(Convert.ConvertDateToString(this.createTime, Convert.TimeFormat.YYYYMMDDHHMMSS));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }

}
