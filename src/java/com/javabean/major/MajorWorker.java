/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.major;

import com.javabean.tables.Major;

/**
 *
 * @author KittyG
 */
public class MajorWorker {

    private Major major;

    public MajorWorker() {

    }

public MajorWorker(String majorCode, String majorName, String academyCode, String academyName) {
        major = new Major(majorCode, majorName, academyCode, academyName);
    }

    public boolean AddMajor() {
        //need lock connection
        boolean result;
        result = this.major.AddMajorInfo();
        return result;
    }
}
