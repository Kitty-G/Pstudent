/*
 * To change this template, choose Tools | Templates
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

    public NeedyStudent(String userId, String idCardNumber, String telephone, String email, String address, String originCode, String dormRoom, String personSpeciality, String receivedAward, PovertyLevel povertyLevel, String povertyReason, Date applicationDate, Date validatedDate, ApprovalStatus approvalStatus) {
        this.userId = userId;
        this.idCardNumber = idCardNumber;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.originCode = originCode;
        this.dormRoom = dormRoom;
        this.personSpeciality = personSpeciality;
        this.receivedAward = receivedAward;
        this.povertyLevel = povertyLevel;
        this.povertyReason = povertyReason;
        this.applicationDate = applicationDate;
        this.validatedDate = validatedDate;
        this.approvalStatus = approvalStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getDormRoom() {
        return dormRoom;
    }

    public void setDormRoom(String dormRoom) {
        this.dormRoom = dormRoom;
    }

    public String getPersonSpeciality() {
        return personSpeciality;
    }

    public void setPersonSpeciality(String personSpeciality) {
        this.personSpeciality = personSpeciality;
    }

    public String getReceivedAward() {
        return receivedAward;
    }

    public void setReceivedAward(String receivedAward) {
        this.receivedAward = receivedAward;
    }

    public PovertyLevel getPovertyLevel() {
        return povertyLevel;
    }

    public void setPovertyLevel(PovertyLevel povertyLevel) {
        this.povertyLevel = povertyLevel;
    }

    public String getPovertyReason() {
        return povertyReason;
    }

    public void setPovertyReason(String povertyReason) {
        this.povertyReason = povertyReason;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getValidatedDate() {
        return validatedDate;
    }

    public void setValidatedDate(Date validatedDate) {
        this.validatedDate = validatedDate;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public NeedyStudent GetNeedyStudentInfo(String userId) {
        SQLOperate sqlOperate;
        NeedyStudent needyStudent;
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM NEEDYSTUDENT WHERE USERID = ? ";
        sqlOperate = new SQLOperate();
        rs = sqlOperate.Query(sql, userId);
        try {
            needyStudent = new NeedyStudent();
            while (rs.next()) {
                needyStudent.userId = rs.getString("USERID");
                needyStudent.idCardNumber = rs.getString("IDCARDNUMBER");
                needyStudent.telephone = rs.getString("TELEPHONE");
                needyStudent.email = rs.getString("EMAIL");
                needyStudent.address = rs.getString("ADDRESS");
                needyStudent.originCode = rs.getString("ORIGINCODE");
                needyStudent.dormRoom = rs.getString("DORMROOM");
                needyStudent.personSpeciality = rs.getString("PERSONSPECIALITY");
                needyStudent.receivedAward = rs.getString("RECEIVEAWARD");
                needyStudent.povertyLevel = PovertyLevel.values()[rs.getInt("POVERTYLEVEL")];
                needyStudent.povertyReason = rs.getString("POVERTYREASON");
                needyStudent.applicationDate = rs.getTimestamp("APPLICATIONDATE");
                needyStudent.validatedDate = rs.getTimestamp("VALIDATEDDATE");
                needyStudent.approvalStatus = ApprovalStatus.values()[rs.getInt("APPROVALSTATUS")];
            }
        } catch (SQLException ex) {
            //log
            return null;
        }
        return needyStudent;
    }

    public boolean AddNeedyStudentInfo() {
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
            affectCount = sqlOperate.Insert("NEEDYSTUDENT", values);
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
            values.add(this.userId);
            values.add(this.idCardNumber);
            values.add(this.telephone);
            values.add(this.email);
            values.add(this.address);
            values.add(this.originCode);
            values.add(this.dormRoom);
            values.add(this.personSpeciality);
            values.add(this.receivedAward);
            values.add(Convert.EnumToIntString(this.povertyLevel));
            values.add(this.povertyReason);
            values.add(Convert.ConvertDateToString(this.applicationDate, Convert.TimeFormat.YYYYMMDDHHMMSS));
            values.add(Convert.ConvertDateToString(this.validatedDate, Convert.TimeFormat.YYYYMMDDHHMMSS));
            values.add(Convert.EnumToIntString(this.approvalStatus));
        } catch (Exception ex) {
            values = null;
        }
        return values;
    }
}
