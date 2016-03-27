
package com.javabean.table;

import java.util.Date;

public class Comment {
	public enum CommentType{
		Post,
		Reply
	}
	public enum CommentStatus{
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
