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
public class ActivityAttendee {
    public enum SignupStatus{
        NotApplied,
        UnderReview,
        Rejected,
        Approved
    }
    private String activityId;
    private String userId;
    private SignupStatus signupStatus;
    private Date signupTime;
}
