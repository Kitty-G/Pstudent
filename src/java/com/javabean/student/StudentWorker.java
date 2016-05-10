/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.student;

import com.javabean.common.User.Gender;
import com.javabean.common.User.Identity;
import com.javabean.tables.Login;
import com.javabean.tables.Student;
import com.javabean.tools.Convert;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KittyG
 */
public class StudentWorker {

    private Login login;
    private Student student;

    public StudentWorker(String userId, String password, String userName, Identity identity, Gender gender, int grade, String majorCode, int classNo, Date intendedTime) {
        try {
            this.login = new Login(userId, Convert.ConvertStringTo32BitMD5String(password), userName, identity);
            this.student = new Student(userId, userName, identity, gender, new Date(), grade, majorCode, classNo, intendedTime);
        } catch (Exception ex) {
            Logger.getLogger(StudentWorker.class.getName()).log(Level.SEVERE, null, ex);
            login = null;
            student = null;
        }
    }

    public boolean AddStudent() {
        //need lock connection
        boolean result;
        result = this.login.AddLoginInfo();
        if (result) {
            result = this.student.AddStudentInfo();
        }
        return result;
    }

    public static void main(String[] args) {
        StudentWorker studentWorker;
        studentWorker = new StudentWorker("1000000000", "12345678", "我是小明", Identity.User, Gender.Male, 2012, "0501", 1, new Date());
//        System.out.println(studentWorker.AddStudent());
    }
}
