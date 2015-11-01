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
public class DBP_infoUpdate extends MySQLOperate{
    private String stdid;
    private String dorm_room;
    private String origin;                                                      //province_city
    private int level;
    private String reason;
    private String skill;
    private int parttime;
    private String prize;
    public DBP_infoUpdate(String student_id,String student_dorm_room,String student_origin,int poor_level,String poor_reason,String person_skill,int part_time,String person_prize){
        super("p_student","writer","aptx4869");
        stdid=student_id;
        dorm_room=student_dorm_room;
        origin=student_origin;
        level=poor_level;
        reason=poor_reason;
        skill=person_skill;
        parttime=part_time;
        prize=person_prize;
    }
    public int UpdateInfo() throws SQLException{
        int result=0;
        String sql;
        sql="insert into p_info values ('"+stdid+"','"+dorm_room+"','"+origin+"',"+level+",'"+reason+"','"+skill+"',"+parttime+",'"+prize+"');";
        super.InsertSQL(sql);                                                   //need application time
        return result;
    }
    public void CloseDB() throws SQLException{
        super.ConnectClose();
    }
}
