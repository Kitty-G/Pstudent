/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tables;

import java.util.Date;

/**
 *
 * @author KittyG
 */
public class NeedyStudent {

    public enum PovertyLevel {
        Normal,
        Relatively,
        Resperately
    }

    public enum ApprovalStatus {
        NotApplied,
        UnderReview,
        Rejected,
        Expired,
        Approved
    }
    private String userId;
    private String idCardNumber;
    private String telephone;
    private String email;
    private String address;
    private String originCode;
    private String dormRoom;
    private String personSpeciality;
    private String receivedAward;
    private PovertyLevel povertyLevel;
    private String povertyReason;
    private Date applicationDate;
    private Date validatedDate;
    private ApprovalStatus approvalStatus;

    public NeedyStudent() {
        
    }
}
