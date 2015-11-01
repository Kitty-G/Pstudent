/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.std_info;

import com.mysql.conndb.std_info.DBP_infoUpdate;
import java.sql.SQLException;

/**
 *
 * @author KittyG
 */
public class p_info {
    private String stdid;
    private String dorm_room;
    private String origin;                                                      //province_city
    private int level;
    private String reason;
    private String skill;
    private int parttime;
    private String prize;
    public p_info(String student_id,String dorm,String room,String province,String city,int poor_level,String poor_reason,String person_skill,int part_time,String person_prize){
        stdid=student_id;
        dorm_room=dorm+"_"+room;
        origin=province+"_"+city;
        level=poor_level;
        reason=poor_reason;
        skill=person_skill;
        parttime=part_time;
        prize=person_prize;
    }

    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public String getDorm_room() {
        return dorm_room;
    }

    public void setDorm_room(String dorm_room) {
        this.dorm_room = dorm_room;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getParttime() {
        return parttime;
    }

    public void setParttime(int parttime) {
        this.parttime = parttime;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
    
    public int dataUpdate() throws SQLException{
        int result;
        
        //Word Check
        DBP_infoUpdate pu=new DBP_infoUpdate(stdid,dorm_room,origin,level,reason,skill,parttime,prize);
        result=pu.UpdateInfo();
        pu.CloseDB();
        if(result!=1){
            return -1;
        }
        return 0;
    }
}
