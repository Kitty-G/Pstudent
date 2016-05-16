/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.managingdepartment;

import com.javabean.tables.ManagingDepartment;

/**
 *
 * @author KittyG
 */
public class ManagingDepartmentWorker {

    private ManagingDepartment managingDepartment;

    public ManagingDepartmentWorker() {

    }

    public ManagingDepartmentWorker(String administratorId, String departmentCode, ManagingDepartment.DepartmentLevel departmentLevel) {
        managingDepartment = new ManagingDepartment(administratorId, departmentCode, departmentLevel);
    }

    public boolean AddManagingDepartment() {
        //need lock connection
        boolean result;
        result = this.managingDepartment.AddManagingDepartmentInfo();
        return result;
    }

}
