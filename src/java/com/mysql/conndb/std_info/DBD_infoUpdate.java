/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conndb.std_info;

import com.mysql.conndb.MySQLOperate;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class DBD_infoUpdate extends MySQLOperate{
    private String stdid;
    private String rname;
    private int sex;
    private String id;
    private String dept_major;
    private String grade_class;
    private String tel;
    private String email;
    private String addr;

    public DBD_infoUpdate(String student_id,String realname,int student_sex,String personal_id,String major,String grade_class_no,String telephone,String Email,String address){
        super("p_student","updater","aptx4869");
        stdid=student_id;
        rname=realname;
        sex=student_sex;
        id=personal_id;
        dept_major=major;
        grade_class=grade_class_no;
        tel=telephone;
        email=Email;
        addr=address;
    }
    public int UpdateInfo() throws SQLException{
        int result;
        String sql;
        sql="update d_info set realname='"+rname+"',sex="+sex+",idno='"+id+"',major='"+dept_major+"',class='"+grade_class+"',tel='"+tel+"',email='"+email+"',addr='"+addr+"' where stdid='"+stdid+"';";
        result=super.SQLUpdate(sql);
        if(result==1){
            sql="update login set power=2 where stdid='"+stdid+"'";
            result=super.SQLUpdate(sql);
        }
        return result;                                                          // return 1 
    }
    public void CloseDB() throws SQLException{
        super.ConnectClose();
    }
}
