/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.std_info;

import com.mysql.conndb.WordCheck;
import com.mysql.conndb.std_info.DBD_infoUpdate;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class d_info {
    private String stdid;
    private String rname;
    private int sex;
    private String id;
    private String major;
    private String grade_class;
    private String tel;
    private String email;
    private String addr;
    public d_info(String student_id,String real_name,int student_sex,String student_idcard,String student_major,String grade,String class_no,String telephone,String Email,String address){
        stdid=student_id;
        rname=real_name;
        sex=student_sex;
        id=student_idcard;
        major=student_major.substring(0, 2)+"_"+student_major.substring(2);
        grade_class=grade+"_"+class_no;
        tel=telephone;
        email=Email;
        addr=address;
    }
    public String getStdid() {
        return stdid;
    }

    public String getRname() {
        return rname;
    }

    public int getSex() {
        return sex;
    }

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAddr() {
        return addr;
    }
    
    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    
    public String getGrade_class() {
        return grade_class;
    }

    public void setGrade_class(String grade_class) {
        this.grade_class = grade_class;
    }
    
    public int dataUpdate() throws SQLException{
        int result;
        WordCheck wc=new WordCheck();
        if(!wc.stdidCheck(stdid)){
            return -99;                                                         //stdid invalid
        }
        DBD_infoUpdate du=new DBD_infoUpdate(stdid,rname,sex,id,major,grade_class,tel,email,addr);
        result=du.UpdateInfo();
        if(result>1){
            du.CloseDB();
            return -111;
                                                                                //stdid is not unique Database should rollback
        }
        if(result!=1){
            du.CloseDB();
            return -1;
        }
        du.CloseDB();
        return 0;
    }
}
